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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.util.EntityUtils;
import org.ovirt.engine.sdk.exceptions.RequestException;

public class HttpProxy {

    private static int BAD_REQUEST = 400;

    private ConnectionsPool pool;
    private Map<String, String> staticHeaders;
    private boolean persistent_auth = true;
    private boolean insecure = false;
    private boolean filter = false;
    private boolean debug = false;

    public HttpProxy(ConnectionsPool pool, boolean persistent_auth, boolean insecure,
            boolean filter, boolean debug) {
        super();
        this.pool = pool;
        this.staticHeaders = createStaticHeaders();
        this.persistent_auth = persistent_auth;
        this.insecure = insecure;
        this.filter = filter;
        this.debug = debug;
    }

    private Map<String, String> createStaticHeaders() {
        return new HashMap<String, String>() {
            private static final long serialVersionUID = -3309952775559222863L;
            {
                put("Content-type", "application/xml");
            }
        };
    }

    private String execute(HttpUriRequest request, List<Header> headers, Boolean last)
            throws IOException, ClientProtocolException, RequestException {

        injectHeaders(request, headers);
        HttpResponse response = this.pool.execute(request, new BasicHttpContext());

        // TODO: save cookie

        if (response.getStatusLine().getStatusCode() < BAD_REQUEST) {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                return EntityUtils.toString(entity);
            } else {
                return null;
            }
        }
        throw new RequestException(response.getStatusLine().getReasonPhrase());
    }

    private void injectHeaders(HttpUriRequest request, List<Header> headers) {
        if (headers != null && !headers.isEmpty()) {
            request.setHeaders(headers.toArray(new Header[headers.size()]));
        }

        for (String key : this.staticHeaders.keySet()) {
            request.addHeader(key, this.staticHeaders.get(key));
        }

        request.addHeader("Filter", Boolean.toString(isFilter()));

        // TODO: fetch + inject cookie in to headers
        // TODO: inject dynamic headers
    }

    public String update(String url, String entity)
            throws IOException, ClientProtocolException, RequestException {
        return update(url, null);
    }

    public String update(String url, String entity, List<Header> headers)
            throws IOException, ClientProtocolException, RequestException {

        HttpPut httpput = new HttpPut(url);
        HttpEntity httpentity = new StringEntity(entity);
        httpput.setEntity(httpentity);
        return execute(httpput, headers, null);
    }

    public String action(String url, String entity)
            throws IOException, ClientProtocolException, RequestException {
        return action(url, entity);
    }

    public String action(String url, String entity, List<Header> headers)
            throws IOException, ClientProtocolException, RequestException {
        return add(url, entity, headers);
    }

    public String add(String url, String entity)
            throws IOException, ClientProtocolException, RequestException {
        return add(url, entity, null);
    }

    public String add(String url, String entity, List<Header> headers)
            throws IOException, ClientProtocolException, RequestException {

        HttpPost httpost = new HttpPost(url);
        HttpEntity httpentity = new StringEntity(entity);
        httpost.setEntity(httpentity);
        return execute(httpost, headers, null);
    }

    public String delete(String url)
            throws IOException, ClientProtocolException, RequestException {
        return delete(url, null, null);
    }

    public String delete(String url, String entity)
            throws IOException, ClientProtocolException, RequestException {
        return delete(url, entity, null);
    }

    public String delete(String url, String entity, List<Header> headers)
            throws IOException, ClientProtocolException, RequestException {

        HttpPost httpost = new HttpPost(url);
        if (!entity.equals(null)) {
            HttpEntity httpentity = new StringEntity(entity);
            httpost.setEntity(httpentity);
        }
        return execute(httpost, headers, null);
    }

    public String get(String url)
            throws IOException, ClientProtocolException, RequestException {
        return get(url, null);
    }

    public String get(String url, List<Header> headers)
            throws IOException, ClientProtocolException, RequestException {

        HttpGet httpget = new HttpGet(url);
        return execute(httpget, headers, null);
    }

    public boolean isPersistent_auth() {
        return persistent_auth;
    }

    public void setPersistent_auth(boolean persistent_auth) {
        this.persistent_auth = persistent_auth;
    }

    public boolean isInsecure() {
        return insecure;
    }

    public void setInsecure(boolean insecure) {
        this.insecure = insecure;
    }

    public boolean isFilter() {
        return filter;
    }

    public void setFilter(boolean filter) {
        this.filter = filter;
    }

    public boolean isDebug() {
        return debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }
}
