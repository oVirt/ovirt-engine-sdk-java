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

import javax.xml.bind.JAXBException;

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
import org.ovirt.engine.sdk.utils.Mapper;
import org.ovirt.engine.sdk.utils.SerializationHelper;
import org.ovirt.engine.sdk.utils.UrlHelper;

/**
 * Proxy in to transport layer
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

        for (String key : this.staticHeaders.keySet()) {
            request.addHeader(key, this.staticHeaders.get(key));
        }

        request.addHeader("Filter", Boolean.toString(isFilter()));

        // TODO: fetch + inject JSESSIONID cookie in to headers
        // TODO: inject dynamic headers
    }

    /**
     * Unmarshales item from the xml
     * 
     * @param from
     *            entity type
     * @param to
     *            decorator type
     * @param xml
     *            xml object representation
     * 
     * @return decorator
     * 
     * @throws JAXBException
     */
    private <F, T> T unmarshall(Class<F> from, Class<T> to, String xml) throws JAXBException {
        F res = SerializationHelper.unmarshall(from, xml);
        return Mapper.map(res, to, this);
    }

    /**
     * updates resource
     * 
     * @param url
     *            resource url
     * @param entity
     *            resource
     * @param from
     *            from type
     * @param to
     *            to type
     * 
     * @return updated resource
     * 
     * @throws IOException
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws JAXBException
     */
    public <F, T> T update(String url, F entity, Class<F> from, Class<T> to)
            throws IOException, ClientProtocolException, ServerException, JAXBException {
        return update(url, entity, from, to, null);
    }

    /**
     * updates resource
     * 
     * @param url
     *            resource url
     * @param entity
     *            resource
     * @param from
     *            from type
     * @param to
     *            to type
     * @param headers
     *            HTTP headers
     * 
     * @return updated resource
     * 
     * @throws IOException
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws JAXBException
     */
    public <F, T> T update(String url, F entity, Class<F> from, Class<T> to, List<Header> headers)
            throws IOException, ClientProtocolException, ServerException, JAXBException {

        HttpPut httpput = new HttpPut(this.urlHelper.combine(url));

        String xmlReq = SerializationHelper.marshall(from, entity);
        HttpEntity httpentity = new StringEntity(xmlReq);
        httpput.setEntity(httpentity);

        String xmlRes = execute(httpput, headers, null);
        F res = SerializationHelper.unmarshall(from, xmlRes);

        return Mapper.map(res, to, this);
    }

    /**
     * Performs action on a resource
     * 
     * @param url
     *            resource url
     * @param entity
     *            resource
     * @param from
     *            from type
     * @param to
     *            to type
     * 
     * @return action response
     * 
     * @throws IOException
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws JAXBException
     */
    public <F, T> T action(String url, F entity, Class<F> from, Class<T> to)
            throws IOException, ClientProtocolException, ServerException, JAXBException {
        return add(url, entity, from, to, null);
    }

    /**
     * Performs action on a resource
     * 
     * @param url
     *            resource url
     * @param entity
     *            resource
     * @param from
     *            from type
     * @param to
     *            to type
     * @param headers
     *            HTTP headers
     * 
     * @return action response
     * 
     * @throws IOException
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws JAXBException
     */
    public <F, T> T action(String url, F entity, Class<F> from, Class<T> to, List<Header> headers)
            throws IOException, ClientProtocolException, ServerException, JAXBException {
        return add(url, entity, from, to, headers);
    }

    /**
     * Adds new resource
     * 
     * @param url
     *            collection url
     * @param entity
     *            entity to add
     * @param from
     *            from type
     * @param to
     *            to type
     * 
     * @return added resource
     * 
     * @throws IOException
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws JAXBException
     */
    public <F, T> T add(String url, F entity, Class<F> from, Class<T> to)
            throws IOException, ClientProtocolException, ServerException, JAXBException {
        return add(url, entity, from, to, null);
    }

    /**
     * Adds new resource
     * 
     * @param url
     *            collection url
     * @param entity
     *            entity to add
     * @param from
     *            from type
     * @param to
     *            to type
     * 
     * @param headers
     *            HTTP headers
     * 
     * @return added resource
     * 
     * @throws IOException
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws JAXBException
     */
    public <F, T> T add(String url, F entity, Class<F> from, Class<T> to, List<Header> headers)
            throws IOException, ClientProtocolException, ServerException, JAXBException {

        HttpPost httpost = new HttpPost(this.urlHelper.combine(url));

        String xmlReq = SerializationHelper.marshall(from, entity);
        HttpEntity httpentity = new StringEntity(xmlReq);
        httpost.setEntity(httpentity);

        String xmlRes = execute(httpost, headers, null);
        return SerializationHelper.unmarshall(to, xmlRes);
    }

    /**
     * Deletes resource
     * 
     * @param url
     *            resource url
     * @param to
     *            to typr
     * 
     * @return response
     * 
     * @throws IOException
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws JAXBException
     */
    public <F, T> T delete(String url, Class<T> to)
            throws IOException, ClientProtocolException, ServerException, JAXBException {
        return delete(url, null, null, to, null);
    }

    /**
     * Deletes resource
     * 
     * @param url
     *            resource url
     * @param entity
     *            entity to pass
     * @param from
     *            from type
     * @param to
     *            to type
     * 
     * @return response
     * 
     * @throws IOException
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws JAXBException
     */
    public <F, T> T delete(String url, F entity, Class<F> from, Class<T> to)
            throws IOException, ClientProtocolException, ServerException, JAXBException {
        return delete(url, entity, from, to, null);
    }

    /**
     * Deletes resource
     * 
     * @param url
     *            resource url
     * @param entity
     *            entity to pass
     * @param from
     *            from type
     * @param to
     *            to type
     * @param headers
     *            HTTP headers
     * 
     * @return response
     * 
     * @throws IOException
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws JAXBException
     */
    public <F, T> T delete(String url, F entity, Class<F> from, Class<T> to, List<Header> headers)
            throws IOException, ClientProtocolException, ServerException, JAXBException {

        HttpDelete httdelete = new HttpDelete(this.urlHelper.combine(url));
        if (entity != null && from != null) {
            // TODO: inject entity to DELETE request
            // String xmlReq = SerializationHelper.marshall(from, entity);
            // HttpEntity httpentity = new StringEntity(xmlReq);
            // httdelete.setEntity(httpentity);
        }
        String xmlRes = execute(httdelete, headers, null);
        return SerializationHelper.unmarshall(to, xmlRes);
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
     *            entity url
     * @param from
     *            from type
     * @param to
     *            to type
     * @param headers
     *            HTTP headers
     * 
     * @return entity
     * 
     * @throws IOException
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws JAXBException
     */
    public <F, T> T get(String url, Class<F> from, Class<T> to, List<Header> headers)
            throws IOException, ClientProtocolException, ServerException, JAXBException {

        HttpGet httpget = new HttpGet(this.urlHelper.combine(url));
        String xmlRes = execute(httpget, headers, null);

        return unmarshall(from, to, xmlRes);
    }

    /**
     * Fetches resource
     * 
     * @param url
     *            entity url
     * @param from
     *            from type
     * @param to
     *            to type
     * 
     * @return entity
     * 
     * @throws IOException
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws JAXBException
     */
    public <F, T> T get(String url, Class<F> from, Class<T> to)
            throws IOException, ClientProtocolException, ServerException, JAXBException {
        return get(url, from, to, null);
    }

    /**
     * Fetches resource
     * 
     * @param url
     *            entity url
     * 
     * @return entity XML representation
     * 
     * @throws IOException
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws JAXBException
     */
    public String get(String url)
            throws IOException, ClientProtocolException, ServerException, JAXBException {
        return get(url, null);
    }

    /**
     * Fetches resource
     * 
     * @param url
     *            entity url
     * @param headers
     *            HTTP headers
     * 
     * @return entity
     * 
     * @throws IOException
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws JAXBException
     */
    public String get(String url, List<Header> headers)
            throws IOException, ClientProtocolException, ServerException, JAXBException {

        HttpGet httpget = new HttpGet(this.urlHelper.combine(url));
        return execute(httpget, headers, null);
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
