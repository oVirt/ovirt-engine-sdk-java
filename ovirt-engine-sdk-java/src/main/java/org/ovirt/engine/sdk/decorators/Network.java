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
 * <p>Network providing relation and functional services
 * <p>to {@link org.ovirt.engine.sdk.entities.Network }.
 */
@SuppressWarnings("unused")
public class Network extends
        org.ovirt.engine.sdk.entities.Network {

    private HttpProxyBroker proxy;
    private final Object LOCK = new Object();

    private volatile NetworkPermissions networkPermissions;
    private volatile NetworkLabels networkLabels;
    private volatile NetworkVnicProfiles networkVnicProfiles;


    /**
     * @param proxy HttpProxyBroker
     */
    public Network(HttpProxyBroker proxy) {
        this.proxy = proxy;
    }

    /**
     * @return HttpProxyBroker
     */
    private HttpProxyBroker getProxy() {
        return proxy;
    }

    /**
     * Gets the value of the NetworkPermissions property.
     *
     * @return
     *     {@link NetworkPermissions }
     */
    public NetworkPermissions getPermissions() {
        if (this.networkPermissions == null) {
            synchronized (this.LOCK) {
                if (this.networkPermissions == null) {
                    this.networkPermissions = new NetworkPermissions(proxy, this);
                }
            }
        }
        return networkPermissions;
    }
    /**
     * Gets the value of the NetworkLabels property.
     *
     * @return
     *     {@link NetworkLabels }
     */
    public NetworkLabels getLabels() {
        if (this.networkLabels == null) {
            synchronized (this.LOCK) {
                if (this.networkLabels == null) {
                    this.networkLabels = new NetworkLabels(proxy, this);
                }
            }
        }
        return networkLabels;
    }
    /**
     * Gets the value of the NetworkVnicProfiles property.
     *
     * @return
     *     {@link NetworkVnicProfiles }
     */
    public NetworkVnicProfiles getVnicProfiles() {
        if (this.networkVnicProfiles == null) {
            synchronized (this.LOCK) {
                if (this.networkVnicProfiles == null) {
                    this.networkVnicProfiles = new NetworkVnicProfiles(proxy, this);
                }
            }
        }
        return networkVnicProfiles;
    }


    /**
     * Updates Network object.
     *
     * @param network {@link org.ovirt.engine.sdk.entities.Network}
     *    <pre>
     *    [network.name]
     *    [network.description]
     *    [network.comment]
     *    [network.vlan.id]
     *    [network.ip.address]
     *    [network.ip.gateway]
     *    [network.ip.netmask]
     *    [network.display]
     *    [network.stp]
     *    [network.mtu]
     *    </pre>
     *
     * @return
     *     {@link Network }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public Network update() throws ClientProtocolException,
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
                Network.class,
                headers);
    }
    /**
     * Updates Network object.
     *
     * @param network {@link org.ovirt.engine.sdk.entities.Network}
     *    <pre>
     *    [network.name]
     *    [network.description]
     *    [network.comment]
     *    [network.vlan.id]
     *    [network.ip.address]
     *    [network.ip.gateway]
     *    [network.ip.netmask]
     *    [network.display]
     *    [network.stp]
     *    [network.mtu]
     *    </pre>
     *
     * @param correlationId
     *    <pre>
     *    [any string]
     *    </pre>
     *
     * @return
     *     {@link Network }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public Network update(String correlationId) throws ClientProtocolException,
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
                Network.class,
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

