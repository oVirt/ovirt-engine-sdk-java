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
import java.util.List;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.protocol.BasicHttpContext;
import org.ovirt.engine.sdk.exceptions.ServerException;
import org.ovirt.engine.sdk.utils.ConversionHelper;
import org.ovirt.engine.sdk.utils.HttpResponseHelper;
import org.ovirt.engine.sdk.utils.UrlHelper;

/**
 * HttpProxy
 */
public class HttpProxy {

    private static int BAD_REQUEST = 400;
    private static String STATIC_HEADERS = "Content-type:application/xml";
    // private static String PERSISTENT_AUTH_HEADER = "Prefer:persistent-auth";

    private ConnectionsPool pool;
    private Map<String, String> staticHeaders;
    private boolean persistentAuth = true;
    private boolean insecure = false;
    private boolean filter = false;
    private boolean debug = false;
    private UrlHelper urlHelper;

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
        this.staticHeaders = ConversionHelper.toMap(STATIC_HEADERS);
        this.persistentAuth = persistent_auth;
        this.insecure = insecure;
        this.filter = filter;
        this.debug = debug;
        this.urlHelper = new UrlHelper(pool.getUrl());
    }

    private String execute(HttpUriRequest request, List<Header> headers, Boolean last)
            throws IOException, ClientProtocolException, ServerException {

        injectHeaders(request, headers);
        HttpResponse response = this.pool.execute(request, new BasicHttpContext());

        // TODO: save cookie

        if (response.getStatusLine().getStatusCode() < BAD_REQUEST) {
            return HttpResponseHelper.getEntity(response.getEntity());
        }

        throw new ServerException(response);
    }

    private void injectHeaders(HttpUriRequest request, List<Header> headers) {
        if (headers != null && !headers.isEmpty()) {
            request.setHeaders(headers.toArray(new Header[headers.size()]));
        }

        for (String key : this.staticHeaders.keySet()) {
            request.addHeader(key, this.staticHeaders.get(key));
        }

        request.addHeader("Filter", Boolean.toString(isFilter()));

        // TODO: fetch + inject JSESSIONID cookie in to headers
        // TODO: inject dynamic headers
    }

    /**
     * updates resource
     * 
     * @param url
     *            resource url
     * @param entity
     *            resource
     * 
     * @return updated resource
     * 
     * @throws IOException
     * @throws ClientProtocolException
     * @throws ServerException
     */
    public String update(String url, String entity)
            throws IOException, ClientProtocolException, ServerException {
        return update(url, null);
    }

    /**
     * updates resource
     * 
     * @param url
     *            resource url
     * @param entity
     *            resource
     * @param headers
     *            HttpHeaders to use
     * 
     * @return updated resource
     * 
     * @throws IOException
     * @throws ClientProtocolException
     * @throws ServerException
     */
    public String update(String url, String entity, List<Header> headers)
            throws IOException, ClientProtocolException, ServerException {

        HttpPut httpput = new HttpPut(this.urlHelper.combine(url));
        HttpEntity httpentity = new StringEntity(entity);
        httpput.setEntity(httpentity);
        return execute(httpput, headers, null);
    }

    /**
     * Performs action on a resource
     * 
     * @param url
     *            resource url
     * @param entity
     *            resource
     * 
     * @return action response
     * 
     * @throws IOException
     * @throws ClientProtocolException
     * @throws ServerException
     */
    public String action(String url, String entity)
            throws IOException, ClientProtocolException, ServerException {
        return add(url, entity);
    }

    /**
     * Performs action on a resource
     * 
     * @param url
     *            resource url
     * @param entity
     *            resource
     * @param headers
     *            HttpHeaders to use
     * 
     * @return action response
     * 
     * @throws IOException
     * @throws ClientProtocolException
     * @throws ServerException
     */
    public String action(String url, String entity, List<Header> headers)
            throws IOException, ClientProtocolException, ServerException {
        return add(url, entity, headers);
    }

    /**
     * Adds new resource
     * 
     * @param url
     *            collection url
     * @param entity
     *            resource to add
     * 
     * @return added resource
     * 
     * @throws IOException
     * @throws ClientProtocolException
     * @throws ServerException
     */
    public String add(String url, String entity)
            throws IOException, ClientProtocolException, ServerException {
        return add(url, entity, null);
    }

    /**
     * Adds new resource
     * 
     * @param url
     *            collection url
     * @param entity
     *            resource to add
     * @param headers
     *            HttpHeaders to use
     * 
     * @return added resource
     * 
     * @throws IOException
     * @throws ClientProtocolException
     * @throws ServerException
     */
    public String add(String url, String entity, List<Header> headers)
            throws IOException, ClientProtocolException, ServerException {

        HttpPost httpost = new HttpPost(this.urlHelper.combine(url));
        HttpEntity httpentity = new StringEntity(entity);
        httpost.setEntity(httpentity);
        return execute(httpost, headers, null);
    }

    /**
     * Deletes resource
     * 
     * @param url
     *            resource url
     * 
     * @return
     * 
     * @throws IOException
     * @throws ClientProtocolException
     * @throws ServerException
     */
    public String delete(String url)
            throws IOException, ClientProtocolException, ServerException {
        return delete(url, null, null);
    }

    /**
     * Deletes resource
     * 
     * @param url
     *            resource url
     * @param entity
     *            to use
     * 
     * @return
     * 
     * @throws IOException
     * @throws ClientProtocolException
     * @throws ServerException
     */
    public String delete(String url, String entity)
            throws IOException, ClientProtocolException, ServerException {
        return delete(url, entity, null);
    }

    /**
     * Deletes resource
     * 
     * @param url
     *            resource url
     * @param entity
     *            to use
     * @param headers
     *            HttpHeaders to use
     * 
     * @return
     * 
     * @throws IOException
     * @throws ClientProtocolException
     * @throws ServerException
     */

    public String delete(String url, String entity, List<Header> headers)
            throws IOException, ClientProtocolException, ServerException {

        HttpDelete httdelete = new HttpDelete(this.urlHelper.combine(url));
        if (entity != null) {
            // HttpEntity httpentity = new StringEntity(entity);
            // TODO: inject entity to DELETE request
            // httdelete.setEntity(httpentity);
        }
        return execute(httdelete, headers, null);
    }

    /**
     * @return oVirt API root resource URL
     */
    public String getRoot() {
        return this.urlHelper.getRoot();
    }

    /**
     * Fetches resource
     * 
     * @param url
     *            resource url
     * @param headers
     *            HttpHeaders to use
     * 
     * @return resource
     * 
     * @throws IOException
     * @throws ClientProtocolException
     * @throws ServerException
     */
    public String get(String url, List<Header> headers)
            throws IOException, ClientProtocolException, ServerException {

        HttpGet httpget = new HttpGet(this.urlHelper.combine(url));
        return execute(httpget, headers, null);
    }

    /**
     * Fetches resource
     * 
     * @param url
     *            resource url
     * 
     * @return resource
     * 
     * @throws IOException
     * @throws ClientProtocolException
     * @throws ServerException
     */
    public String get(String url)
            throws IOException, ClientProtocolException, ServerException {
        return get(url, null);
    }

    public boolean isPersistentAuth() {
        return persistentAuth;
    }

    public void setPersistentAuth(boolean persistent_auth) {
        this.persistentAuth = persistent_auth;
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

    /**
     * When HttpClient instance is no longer needed, shut down the connection manager to ensure immediate deallocation
     * of all system resources.
     */
    public void shutdown() {
        this.pool.getConnectionManager().shutdown();
    }
}
