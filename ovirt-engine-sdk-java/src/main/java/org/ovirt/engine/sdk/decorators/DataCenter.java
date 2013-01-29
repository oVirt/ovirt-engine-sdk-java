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

    private DataCenterPermissions dataCenterPermissions;
    private DataCenterStorageDomains dataCenterStorageDomains;
    private DataCenterQuotas dataCenterQuotas;


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
     * Gets the value of the DataCenterPermissions property.
     *
     * @return
     *     {@link DataCenterPermissions }
     */
    public synchronized DataCenterPermissions getPermissions() {
        if (this.dataCenterPermissions == null) {
            this.dataCenterPermissions = new DataCenterPermissions(proxy, this);
        }
        return dataCenterPermissions;
    }
    /**
     * Gets the value of the DataCenterStorageDomains property.
     *
     * @return
     *     {@link DataCenterStorageDomains }
     */
    public synchronized DataCenterStorageDomains getStorageDomains() {
        if (this.dataCenterStorageDomains == null) {
            this.dataCenterStorageDomains = new DataCenterStorageDomains(proxy, this);
        }
        return dataCenterStorageDomains;
    }
    /**
     * Gets the value of the DataCenterQuotas property.
     *
     * @return
     *     {@link DataCenterQuotas }
     */
    public synchronized DataCenterQuotas getQuotas() {
        if (this.dataCenterQuotas == null) {
            this.dataCenterQuotas = new DataCenterQuotas(proxy, this);
        }
        return dataCenterQuotas;
    }


    /**
     * Updates DataCenter object.
     *
     * @param datacenter {@link org.ovirt.engine.sdk.entities.DataCenter}
     *    <pre>
     *    [datacenter.name]
     *    [datacenter.storage_type]
     *    [datacenter.version.major]
     *    [datacenter.version.minor]
     *    [datacenter.description]
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
        return getProxy().update(url, this, org.ovirt.engine.sdk.entities.DataCenter.class, DataCenter.class);
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

        List<Header> headers = new HttpHeaderBuilder()
                .build();

        url = new UrlBuilder(url)
                .build();

        return getProxy().delete(url, Response.class, headers);
    }
    /**
     * Deletes object.
     *
     * @param correlationId
     *    <pre>
     *    [any string]
     *    </pre>
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

        List<Header> headers = new HttpHeaderBuilder()
                .add("Correlation-Id", correlationId)
                .build();

        url = new UrlBuilder(url)
                .add("async", async, UrlParameterType.MATRIX)
                .build();

        return getProxy().delete(url, Response.class, headers);
    }
    /**
     * Deletes object.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    [action.force]
     *    </pre>
     *
     * @param correlationId
     *    <pre>
     *    [any string]
     *    </pre>
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

        List<Header> headers = new HttpHeaderBuilder()
                .add("Correlation-Id", correlationId)
                .build();

        url = new UrlBuilder(url)
                .add("async", async, UrlParameterType.MATRIX)
                .build();

        return getProxy().delete(url, action,
                org.ovirt.engine.sdk.entities.Action.class, Response.class, headers);
    }

}

