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
 * <p>DataCenterNetwork providing relation and functional services
 * <p>to {@link org.ovirt.engine.sdk.entities.Network }.
 */
@SuppressWarnings("unused")
public class DataCenterNetwork extends
        org.ovirt.engine.sdk.entities.Network {

    private HttpProxyBroker proxy;
    private final Object LOCK = new Object();

    private volatile DataCenterNetworkPermissions dataCenterNetworkPermissions;
    private volatile DataCenterNetworkVnicProfiles dataCenterNetworkVnicProfiles;
    private volatile DataCenterNetworkLabels dataCenterNetworkLabels;


    /**
     * @param proxy HttpProxyBroker
     */
    public DataCenterNetwork(HttpProxyBroker proxy) {
        this.proxy = proxy;
    }

    /**
     * @return HttpProxyBroker
     */
    private HttpProxyBroker getProxy() {
        return proxy;
    }

    /**
     * Gets the value of the DataCenterNetworkPermissions property.
     *
     * @return
     *     {@link DataCenterNetworkPermissions }
     */
    public DataCenterNetworkPermissions getPermissions() {
        if (this.dataCenterNetworkPermissions == null) {
            synchronized (this.LOCK) {
                if (this.dataCenterNetworkPermissions == null) {
                    this.dataCenterNetworkPermissions = new DataCenterNetworkPermissions(proxy, this);
                }
            }
        }
        return dataCenterNetworkPermissions;
    }
    /**
     * Gets the value of the DataCenterNetworkVnicProfiles property.
     *
     * @return
     *     {@link DataCenterNetworkVnicProfiles }
     */
    public DataCenterNetworkVnicProfiles getVnicProfiles() {
        if (this.dataCenterNetworkVnicProfiles == null) {
            synchronized (this.LOCK) {
                if (this.dataCenterNetworkVnicProfiles == null) {
                    this.dataCenterNetworkVnicProfiles = new DataCenterNetworkVnicProfiles(proxy, this);
                }
            }
        }
        return dataCenterNetworkVnicProfiles;
    }
    /**
     * Gets the value of the DataCenterNetworkLabels property.
     *
     * @return
     *     {@link DataCenterNetworkLabels }
     */
    public DataCenterNetworkLabels getLabels() {
        if (this.dataCenterNetworkLabels == null) {
            synchronized (this.LOCK) {
                if (this.dataCenterNetworkLabels == null) {
                    this.dataCenterNetworkLabels = new DataCenterNetworkLabels(proxy, this);
                }
            }
        }
        return dataCenterNetworkLabels;
    }


    /**
     * Updates DataCenterNetwork object.
     *
     * @param network {@link org.ovirt.engine.sdk.entities.Network}
     *    <pre>
     *    [network.display]
     *    [network.usages.usage]
     *    </pre>
     *
     * @return
     *     {@link DataCenterNetwork }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public DataCenterNetwork update() throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().update(
                url,
                this,
                org.ovirt.engine.sdk.entities.Network.class,
                DataCenterNetwork.class,
                headers);
    }
    /**
     * Updates DataCenterNetwork object.
     *
     * @param network {@link org.ovirt.engine.sdk.entities.Network}
     *    <pre>
     *    [network.display]
     *    [network.usages.usage]
     *    </pre>
     *
     * @param correlationId
     *    <pre>
     *    [any string]
     *    </pre>
     *
     * @return
     *     {@link DataCenterNetwork }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public DataCenterNetwork update(String correlationId) throws ClientProtocolException,
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
                org.ovirt.engine.sdk.entities.Network.class,
                DataCenterNetwork.class,
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

}

