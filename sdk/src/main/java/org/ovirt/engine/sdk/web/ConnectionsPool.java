//
// Copyright (c) 2012 Red Hat, Inc.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//           http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
//

package org.ovirt.engine.sdk.web;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.List;

import javax.net.ssl.SSLException;

import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.ExecutionContext;
import org.apache.http.protocol.HttpContext;

/**
 * HTTP Connections Pool manager
 */
public class ConnectionsPool {

    private static int MAX_RETRY_REQUEST = 5;

    private DefaultHttpClient client = null;
    private CookieStore cookieStore;
    private IdleConnectionMonitorThread idleConnectionsWatchdog;
    private URL url = null;
    private Integer sessionTimeout;

    /**
     * 
     * @param client
     *            DefaultHttpClient
     * @param url
     *            oVirt API url
     * @param sessionTimeout
     *            authentication session inactivity timeout
     * @param checkTtL
     *            idle connections check TTL
     * @param closeTtl
     *            idle connections close TTL
     */
    public ConnectionsPool(DefaultHttpClient client, URL url, Integer sessionTimeout, long checkTtL, long closeTtl) {
        this.client = client;
        this.cookieStore = this.client.getCookieStore();
        this.url = url;
        this.sessionTimeout = sessionTimeout;
        injectHttpRequestRetryHandler(this.client);
        idleConnectionsWatchdog =
                new IdleConnectionMonitorThread(
                        this.client.getConnectionManager(),
                        checkTtL,
                        closeTtl);
        idleConnectionsWatchdog.start();
    }

    /**
     * Executes HTTP request
     * 
     * @param request
     *            HttpUriRequest
     * @param context
     *            HttpContext
     * 
     * @return {@link HttpResponse}
     * 
     * @throws IOException
     * @throws ClientProtocolException
     */
    public HttpResponse execute(HttpUriRequest request, HttpContext context)
            throws IOException, ClientProtocolException {
        return this.client.execute(request, context);
    }

    /**
     * @return {@link Cookie}
     */
    public List<Cookie> getCookies() {
        return cookieStore.getCookies();
    }

    /**
     * @return {@link CookieStore}
     */
    public CookieStore getCookieStore() {
        return cookieStore;
    }

    /**
     * @return {@link ConnectionManager}
     */
    public ClientConnectionManager getConnectionManager() {
        return this.client.getConnectionManager();
    }

    private void injectHttpRequestRetryHandler(DefaultHttpClient httpclient) {
        HttpRequestRetryHandler myRetryHandler = new HttpRequestRetryHandler() {

            @Override
            public boolean retryRequest(
                    IOException exception,
                    int executionCount,
                    HttpContext context) {
                if (executionCount >= MAX_RETRY_REQUEST) {
                    // Do not retry if over max retry count
                    return false;
                }
                if (exception instanceof InterruptedIOException) {
                    // Timeout
                    return false;
                }
                if (exception instanceof UnknownHostException) {
                    // Unknown host
                    return false;
                }
                if (exception instanceof ConnectException) {
                    // Connection refused
                    return false;
                }
                if (exception instanceof SSLException) {
                    // SSL handshake exception
                    return false;
                }
                HttpRequest request = (HttpRequest) context.getAttribute(
                        ExecutionContext.HTTP_REQUEST);
                boolean idempotent = !(request instanceof HttpEntityEnclosingRequest);
                if (idempotent) {
                    // Retry if the request is considered idempotent
                    return true;
                }
                return false;
            }
        };

        httpclient.setHttpRequestRetryHandler(myRetryHandler);
    }

    /**
     * @return oVirt API url
     */
    public URL getUrl() {
        return url;
    }

    /**
     * @return authentication session inactivity timeout
     */
    public Integer getSessionTimeout() {
        return sessionTimeout;
    }

    /**
     * When ConnectionsPool instance is no longer needed, shut down
     * the connection manager and idle connections watchdog
     * to ensure immediate deallocation of all system resources.
     */
    public void shutdown() {
        this.idleConnectionsWatchdog.shutdown();
        this.getConnectionManager().shutdown();
    }
}
