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

// *********************************************************************
// ********************* GENERATED CODE - DO NOT MODIFY ****************
// *********************************************************************

package org.ovirt.engine.sdk.decorators;

import java.io.IOException;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.ovirt.engine.sdk.entities.Action;
import org.ovirt.engine.sdk.entities.Response;
import org.ovirt.engine.sdk.exceptions.ServerException;
import org.ovirt.engine.sdk.utils.HttpHeaderBuilder;
import org.ovirt.engine.sdk.utils.HttpHeaderUtils;
import org.ovirt.engine.sdk.utils.UrlBuilder;
import org.ovirt.engine.sdk.web.HttpProxyBroker;
import org.ovirt.engine.sdk.web.UrlParameterType;

/**
 * <p>DataCenter providing relation and functional services
 * <p>to {@link org.ovirt.engine.sdk.entities.DataCenter }.
 */
@SuppressWarnings("unused")
public class DataCenter extends
        org.ovirt.engine.sdk.entities.DataCenter {

    private HttpProxyBroker proxy;
    private final Object LOCK = new Object();

    private volatile DataCenterClusters dataCenterClusters;
    private volatile DataCenterPermissions dataCenterPermissions;
    private volatile DataCenterQoSs dataCenterQoSs;
    private volatile DataCenterNetworks dataCenterNetworks;
    private volatile DataCenterIscsiBonds dataCenterIscsiBonds;
    private volatile DataCenterStorageDomains dataCenterStorageDomains;
    private volatile DataCenterQuotas dataCenterQuotas;


    /**
     * @param proxy HttpProxyBroker
     */
    public DataCenter(HttpProxyBroker proxy) {
        this.proxy = proxy;
    }

    /**
     * @return HttpProxyBroker
     */
    private HttpProxyBroker getProxy() {
        return proxy;
    }

    /**
     * Gets the value of the DataCenterClusters property.
     *
     * @return
     *     {@link DataCenterClusters }
     */
    public DataCenterClusters getClusters() {
        if (this.dataCenterClusters == null) {
            synchronized (this.LOCK) {
                if (this.dataCenterClusters == null) {
                    this.dataCenterClusters = new DataCenterClusters(proxy, this);
                }
            }
        }
        return dataCenterClusters;
    }
    /**
     * Gets the value of the DataCenterPermissions property.
     *
     * @return
     *     {@link DataCenterPermissions }
     */
    public DataCenterPermissions getPermissions() {
        if (this.dataCenterPermissions == null) {
            synchronized (this.LOCK) {
                if (this.dataCenterPermissions == null) {
                    this.dataCenterPermissions = new DataCenterPermissions(proxy, this);
                }
            }
        }
        return dataCenterPermissions;
    }
    /**
     * Gets the value of the DataCenterQoSs property.
     *
     * @return
     *     {@link DataCenterQoSs }
     */
    public DataCenterQoSs getQoSs() {
        if (this.dataCenterQoSs == null) {
            synchronized (this.LOCK) {
                if (this.dataCenterQoSs == null) {
                    this.dataCenterQoSs = new DataCenterQoSs(proxy, this);
                }
            }
        }
        return dataCenterQoSs;
    }
    /**
     * Gets the value of the DataCenterNetworks property.
     *
     * @return
     *     {@link DataCenterNetworks }
     */
    public DataCenterNetworks getNetworks() {
        if (this.dataCenterNetworks == null) {
            synchronized (this.LOCK) {
                if (this.dataCenterNetworks == null) {
                    this.dataCenterNetworks = new DataCenterNetworks(proxy, this);
                }
            }
        }
        return dataCenterNetworks;
    }
    /**
     * Gets the value of the DataCenterIscsiBonds property.
     *
     * @return
     *     {@link DataCenterIscsiBonds }
     */
    public DataCenterIscsiBonds getIscsiBonds() {
        if (this.dataCenterIscsiBonds == null) {
            synchronized (this.LOCK) {
                if (this.dataCenterIscsiBonds == null) {
                    this.dataCenterIscsiBonds = new DataCenterIscsiBonds(proxy, this);
                }
            }
        }
        return dataCenterIscsiBonds;
    }
    /**
     * Gets the value of the DataCenterStorageDomains property.
     *
     * @return
     *     {@link DataCenterStorageDomains }
     */
    public DataCenterStorageDomains getStorageDomains() {
        if (this.dataCenterStorageDomains == null) {
            synchronized (this.LOCK) {
                if (this.dataCenterStorageDomains == null) {
                    this.dataCenterStorageDomains = new DataCenterStorageDomains(proxy, this);
                }
            }
        }
        return dataCenterStorageDomains;
    }
    /**
     * Gets the value of the DataCenterQuotas property.
     *
     * @return
     *     {@link DataCenterQuotas }
     */
    public DataCenterQuotas getQuotas() {
        if (this.dataCenterQuotas == null) {
            synchronized (this.LOCK) {
                if (this.dataCenterQuotas == null) {
                    this.dataCenterQuotas = new DataCenterQuotas(proxy, this);
                }
            }
        }
        return dataCenterQuotas;
    }


    /**
     * Updates DataCenter object.
     *
     * @param datacenter {@link org.ovirt.engine.sdk.entities.DataCenter}
     *    <pre>
     *    [datacenter.name]
     *    [datacenter.description]
     *    [datacenter.comment]
     *    [datacenter.storage_type]
     *    [datacenter.local]
     *    [datacenter.version.major]
     *    [datacenter.version.minor]
     *    [datacenter.storage_format]
     *    </pre>
     *
     * @return
     *     {@link DataCenter }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public DataCenter update() throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().update(
                url,
                this,
                org.ovirt.engine.sdk.entities.DataCenter.class,
                DataCenter.class,
                headers);
    }
    /**
     * Updates DataCenter object.
     *
     * @param datacenter {@link org.ovirt.engine.sdk.entities.DataCenter}
     *    <pre>
     *    [datacenter.name]
     *    [datacenter.description]
     *    [datacenter.comment]
     *    [datacenter.storage_type]
     *    [datacenter.local]
     *    [datacenter.version.major]
     *    [datacenter.version.minor]
     *    [datacenter.storage_format]
     *    </pre>
     *
     * @param correlationId
     *    <pre>
     *    [any string]
     *    </pre>
     *
     * @return
     *     {@link DataCenter }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public DataCenter update(String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        if (correlationId != null) {
            headersBuilder.add("Correlation-Id", correlationId);
        }
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().update(
                url,
                this,
                org.ovirt.engine.sdk.entities.DataCenter.class,
                DataCenter.class,
                headers);
    }
    /**
     * Deletes object.
     *
     * @return
     *     {@link Response }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public Response delete() throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().delete(url, Response.class, headers);
    }
    /**
     * Deletes object.
     *
     * @param async
     *    <pre>
     *    [true|false]
     *    </pre>
     *
     * @return
     *     {@link Response }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public Response delete(Boolean async) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        if (async != null) {
            urlBuilder.add("async", async, UrlParameterType.MATRIX);
        }
        url = urlBuilder.build();

        return getProxy().delete(url, Response.class, headers);
    }
    /**
     * Deletes object.
     *
     * @param correlationId
     *    <pre>
     *    [any string]
     *    </pre>
     *
     * @param async
     *    <pre>
     *    [true|false]
     *    </pre>
     *
     * @return
     *     {@link Response }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public Response delete(Boolean async, String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        if (correlationId != null) {
            headersBuilder.add("Correlation-Id", correlationId);
        }
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        if (async != null) {
            urlBuilder.add("async", async, UrlParameterType.MATRIX);
        }
        url = urlBuilder.build();

        return getProxy().delete(url, Response.class, headers);
    }
    /**
     * Deletes object.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    [action.force]
     *    [action.async]
     *    [action.grace_period.expiry]
     *    </pre>
     *
     * @param async
     *    <pre>
     *    [true|false]
     *    </pre>
     *
     * @return
     *     {@link Response }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public Response delete(org.ovirt.engine.sdk.entities.Action action, Boolean async) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        if (async != null) {
            urlBuilder.add("async", async, UrlParameterType.MATRIX);
        }
        url = urlBuilder.build();

        return getProxy().delete(url, action,
                org.ovirt.engine.sdk.entities.Action.class, Response.class, headers);
    }
    /**
     * Deletes object.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    [action.force]
     *    [action.async]
     *    [action.grace_period.expiry]
     *    </pre>
     *
     * @param correlationId
     *    <pre>
     *    [any string]
     *    </pre>
     *
     * @param async
     *    <pre>
     *    [true|false]
     *    </pre>
     *
     * @return
     *     {@link Response }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public Response delete(org.ovirt.engine.sdk.entities.Action action, Boolean async, String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        if (correlationId != null) {
            headersBuilder.add("Correlation-Id", correlationId);
        }
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        if (async != null) {
            urlBuilder.add("async", async, UrlParameterType.MATRIX);
        }
        url = urlBuilder.build();

        return getProxy().delete(url, action,
                org.ovirt.engine.sdk.entities.Action.class, Response.class, headers);
    }

}

