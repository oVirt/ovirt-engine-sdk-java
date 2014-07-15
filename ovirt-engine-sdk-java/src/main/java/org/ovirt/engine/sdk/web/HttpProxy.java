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
import java.util.ArrayList;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.protocol.BasicHttpContext;
import org.ovirt.engine.sdk.exceptions.ServerException;
import org.ovirt.engine.sdk.utils.HttpHeaderUtils;
import org.ovirt.engine.sdk.utils.HttpResponseHelper;
import org.ovirt.engine.sdk.utils.StringUtils;

/**
 * Proxy in to transport layer
 */
public class HttpProxy {

    private static final String SESSION_TTL_HEADER = "Session-TTL";
    private static final String COOKIE_HEADER = "Cookie";
    private static final String CONTENT_TYPE_HEADER = "Content-type";
    private static final String PERSISTENT_AUTH_HEADER_CONTENT = "persistent-auth";
    private static final String PERSISTENT_AUTH_HEADER = "Prefer";
    private static final String FILTER_HEADER = "Filter";
    private static final String EXPECT_HEADER = "Expect";
    private static final String ALTERNATIVE_EXPECT_HEADER = "X-Ovirt-Expect";
    private static final String STATIC_HEADERS[] = new String[] { "Content-type:application/xml" };
    private static final int BAD_REQUEST = 400;

    private ConnectionsPool pool;
    private List<Header> staticHeaders;
    private boolean persistentAuth = true;
    private boolean filter = false;
    private boolean debug = false;
    private String sessionid;

    /**
     * 
     * @param pool
     *            ConnectionsPool
     * @param persistent_auth
     *            persistent authetication
     * @param sessionid
     *            oVirt api sessionid to authenticate the user with
     *            (used as SSO solution instead of username+password)
     * @param insecure
     *            flag
     * @param filter
     *            flag
     * @param debug
     *            flag
     */
    public HttpProxy(ConnectionsPool pool, boolean persistent_auth,
            String sessionid, boolean filter, boolean debug) {
        super();
        this.pool = pool;
        this.staticHeaders = HttpHeaderUtils.toHeaders(STATIC_HEADERS);
        this.persistentAuth = persistent_auth;
        this.sessionid = sessionid;
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
        HttpResponse response = this.pool.execute(request, getContext());

        if (response.getStatusLine().getStatusCode() < BAD_REQUEST) {
            return HttpResponseHelper.getEntity(response.getEntity());
        }

        throw new ServerException(response);
    }

    /**
     * Generates peer hit context
     * 
     * @return {@link BasicHttpContext}
     */
    private BasicHttpContext getContext() {
        BasicHttpContext context = new BasicHttpContext();
        if (this.persistentAuth && StringUtils.isNulOrEmpty(this.sessionid)) {
            context.setAttribute(ClientContext.COOKIE_STORE, this.pool.getCookieStore());
        }
        return context;
    }

    /**
     * Removes headers with NULL value
     * 
     * @param headers
     * 
     * @return List of {@link Header} where value != null
     */
    private List<Header> excludeNullHeaders(List<Header> headers) {
        if (headers != null && !headers.isEmpty()) {
            List<Header> updated = new ArrayList<Header>();
            for (Header header : headers) {
                if (header.getValue() != null) {
                    updated.add(header);
                }
            }
            return updated;
        }
        return headers;
    }

    /**
     * Injects HTTP headers in to request
     * 
     * @param request
     * @param headers
     */
    private void injectHeaders(HttpUriRequest request, List<Header> headers) {
        List<Header> updated = excludeNullHeaders(headers);
        if (updated != null && !updated.isEmpty()) {
            request.setHeaders(updated.toArray(new Header[updated.size()]));
        }

        // The Apache web server ignores the "Expect" header, so if this header was explicitly added by the user, then
        // we need to add the alternative "X-Ovirt-Expect" as well:
        if (headers != null) {
            for (Header header : headers) {
                if (EXPECT_HEADER.equalsIgnoreCase(header.getName())) {
                    request.setHeader(ALTERNATIVE_EXPECT_HEADER, header.getValue());
                }
            }
        }

        // inject .ctr defined static parameters
        for (Header header : this.staticHeaders) {
            if (header.getName().equals(CONTENT_TYPE_HEADER)) {
                if ((request instanceof HttpDelete) &&
                        ((HttpDelete) request).getEntity() == null) {
                    continue;
                } else if ((request instanceof HttpPut) &&
                        ((HttpPut) request).getEntity() == null) {
                    continue;
                } else if ((request instanceof HttpPost) &&
                        ((HttpPost) request).getEntity() == null) {
                    continue;
                }
            }
            request.addHeader(header);
        }

        // inject FILTER_HEADER
        request.addHeader(FILTER_HEADER, Boolean.toString(isFilter()));

        if (this.persistentAuth) {
            // inject PERSISTENT_AUTH_HEADER
            request.addHeader(PERSISTENT_AUTH_HEADER, PERSISTENT_AUTH_HEADER_CONTENT);

            // inject COOKIE_HEADER if JSESSION provided explicitly
            if (!StringUtils.isNulOrEmpty(this.sessionid)) {
                request.addHeader(COOKIE_HEADER, this.sessionid);
            }

            // inject authentication session inactivity timeout
            if (this.pool.getSessionTimeout() != null) {
                request.addHeader(SESSION_TTL_HEADER,
                        String.valueOf(this.pool.getSessionTimeout()));
            }
        }
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
     * @param sessionid
     *            oVirt api sessionid to authenticate the user with
     *            (used as SSO solution instead of username+password)
     */
    public void setSessionid(String sessionid) {
        this.sessionid = sessionid;
    }

    /**
     * oVirt api sessionid to authenticate the user with
     * (used as SSO solution instead of username+password)
     */
    public boolean isSetSessionid() {
        return !StringUtils.isNulOrEmpty(this.sessionid);
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
     * When HttpProxy instance is no longer needed, shut down
     * the connection manager to ensure immediate deallocation of
     * all system resources.
     */
    public void shutdown() {
        this.pool.shutdown();
    }
}
