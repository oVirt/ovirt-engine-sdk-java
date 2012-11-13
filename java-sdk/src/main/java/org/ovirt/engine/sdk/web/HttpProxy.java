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
import java.net.URL;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.BasicHttpContext;
import org.ovirt.engine.sdk.exceptions.ServerException;
import org.ovirt.engine.sdk.utils.HttpHeaderUtils;
import org.ovirt.engine.sdk.utils.HttpResponseHelper;

/**
 * Proxy in to transport layer
 */
public class HttpProxy {

    private static int BAD_REQUEST = 400;
    private static String STATIC_HEADERS[] = new String[] { "Content-type:application/xml" };
    // private static String PERSISTENT_AUTH_HEADER = "Prefer:persistent-auth";

    private ConnectionsPool pool;
    private List<Header> staticHeaders;
    private boolean persistentAuth = true;
    private boolean insecure = false;
    private boolean filter = false;
    private boolean debug = false;

    /**
     * 
     * @param pool
     *            ConnectionsPool
     * @param persistent_auth
     *            persistent authetication
     * @param insecure
     *            flag
     * @param filter
     *            flag
     * @param debug
     *            flag
     */
    public HttpProxy(ConnectionsPool pool, boolean persistent_auth, boolean insecure,
            boolean filter, boolean debug) {
        super();
        this.pool = pool;
        this.staticHeaders = HttpHeaderUtils.toHeaders(STATIC_HEADERS);
        this.persistentAuth = persistent_auth;
        this.insecure = insecure;
        this.filter = filter;
        this.debug = debug;
    }

    /**
     * @return oVirt API url
     */
    public URL getUrl() {
        return pool.getUrl();
    }

    /**
     * Executes HTTP request
     * 
     * @param request
     *            HTTP request
     * @param headers
     *            HTTP headers
     * @param last
     *            flags if persistanet auth. should be closed
     * 
     * @return XML
     * 
     * @throws IOException
     * @throws ClientProtocolException
     * @throws ServerException
     */
    public String execute(HttpUriRequest request, List<Header> headers, Boolean last)
            throws IOException, ClientProtocolException, ServerException {

        injectHeaders(request, headers);
        HttpResponse response = this.pool.execute(request, new BasicHttpContext());

        // TODO: save cookie

        if (response.getStatusLine().getStatusCode() < BAD_REQUEST) {
            return HttpResponseHelper.getEntity(response.getEntity());
        }

        throw new ServerException(response);
    }

    /**
     * Injects HTTP headers in to request
     * 
     * @param request
     * @param headers
     */
    private void injectHeaders(HttpUriRequest request, List<Header> headers) {
        if (headers != null && !headers.isEmpty()) {
            request.setHeaders(headers.toArray(new Header[headers.size()]));
        }

        for (Header header : this.staticHeaders) {
            // TODO: support DELETE with body
            if (header.getName().equals("Content-type") && (request instanceof HttpDelete)) {
                continue;
            }
            request.addHeader(header);
        }

        request.addHeader("Filter", Boolean.toString(isFilter()));

        // TODO: fetch + inject JSESSIONID cookie in to headers
        // TODO: inject dynamic headers
    }

    /**
     * @return persistent authentication flag
     */
    public boolean isPersistentAuth() {
        return persistentAuth;
    }

    /**
     * @param sets
     *            persistent authentication flag
     */
    public void setPersistentAuth(boolean persistentAuth) {
        this.persistentAuth = persistentAuth;
    }

    /**
     * @return Insecure flag
     */
    public boolean isInsecure() {
        return insecure;
    }

    /**
     * @param insecure
     *            sets Insecure flag
     */
    public void setInsecure(boolean insecure) {
        this.insecure = insecure;
    }

    /**
     * @return Filter flag
     */
    public boolean isFilter() {
        return filter;
    }

    /**
     * @param filter
     *            sets Filter flag
     */
    public void setFilter(boolean filter) {
        this.filter = filter;
    }

    /**
     * @return Debug flag
     */
    public boolean isDebug() {
        return debug;
    }

    /**
     * @param debug
     *            sets Debug flag
     */
    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    /**
     * When HttpClient instance is no longer needed, shut down the connection manager to ensure immediate deallocation
     * of all system resources.
     */
    public void shutdown() {
        this.pool.getConnectionManager().shutdown();
    }
}
