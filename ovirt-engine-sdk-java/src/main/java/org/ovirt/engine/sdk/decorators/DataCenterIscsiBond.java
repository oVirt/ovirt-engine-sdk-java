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
 * <p>DataCenterIscsiBond providing relation and functional services
 * <p>to {@link org.ovirt.engine.sdk.entities.IscsiBond }.
 */
@SuppressWarnings("unused")
public class DataCenterIscsiBond extends
        org.ovirt.engine.sdk.entities.IscsiBond {

    private HttpProxyBroker proxy;
    private final Object LOCK = new Object();

    private volatile DataCenterIscsiBondNetworks dataCenterIscsiBondNetworks;
    private volatile DataCenterIscsiBondStorageConnections dataCenterIscsiBondStorageConnections;


    /**
     * @param proxy HttpProxyBroker
     */
    public DataCenterIscsiBond(HttpProxyBroker proxy) {
        this.proxy = proxy;
    }

    /**
     * @return HttpProxyBroker
     */
    private HttpProxyBroker getProxy() {
        return proxy;
    }

    /**
     * Gets the value of the DataCenterIscsiBondNetworks property.
     *
     * @return
     *     {@link DataCenterIscsiBondNetworks }
     */
    public DataCenterIscsiBondNetworks getNetworks() {
        if (this.dataCenterIscsiBondNetworks == null) {
            synchronized (this.LOCK) {
                if (this.dataCenterIscsiBondNetworks == null) {
                    this.dataCenterIscsiBondNetworks = new DataCenterIscsiBondNetworks(proxy, this);
                }
            }
        }
        return dataCenterIscsiBondNetworks;
    }
    /**
     * Gets the value of the DataCenterIscsiBondStorageConnections property.
     *
     * @return
     *     {@link DataCenterIscsiBondStorageConnections }
     */
    public DataCenterIscsiBondStorageConnections getStorageConnections() {
        if (this.dataCenterIscsiBondStorageConnections == null) {
            synchronized (this.LOCK) {
                if (this.dataCenterIscsiBondStorageConnections == null) {
                    this.dataCenterIscsiBondStorageConnections = new DataCenterIscsiBondStorageConnections(proxy, this);
                }
            }
        }
        return dataCenterIscsiBondStorageConnections;
    }


    /**
     * Updates DataCenterIscsiBond object.
     *
     * @param iscsibond {@link org.ovirt.engine.sdk.entities.IscsiBond}
     *    <pre>
     *    </pre>
     *
     * @return
     *     {@link DataCenterIscsiBond }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public DataCenterIscsiBond update() throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().update(
                url,
                this,
                org.ovirt.engine.sdk.entities.IscsiBond.class,
                DataCenterIscsiBond.class,
                headers);
    }
    /**
     * Updates DataCenterIscsiBond object.
     *
     * @param iscsibond {@link org.ovirt.engine.sdk.entities.IscsiBond}
     *    <pre>
     *    </pre>
     *
     * @param expect
     *    <pre>
     *    [201-created]
     *    </pre>
     *
     * @return
     *     {@link DataCenterIscsiBond }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public DataCenterIscsiBond update(String expect) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        if (expect != null) {
            headersBuilder.add("Expect", expect);
        }
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().update(
                url,
                this,
                org.ovirt.engine.sdk.entities.IscsiBond.class,
                DataCenterIscsiBond.class,
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

}

