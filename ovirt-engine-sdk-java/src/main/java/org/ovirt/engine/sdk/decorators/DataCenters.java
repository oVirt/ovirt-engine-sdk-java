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
import java.util.UUID;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.ovirt.engine.sdk.common.CollectionDecorator;
import org.ovirt.engine.sdk.exceptions.ServerException;
import org.ovirt.engine.sdk.utils.CollectionUtils;
import org.ovirt.engine.sdk.utils.HttpHeaderBuilder;
import org.ovirt.engine.sdk.utils.HttpHeaderUtils;
import org.ovirt.engine.sdk.utils.UrlBuilder;
import org.ovirt.engine.sdk.utils.UrlBuilder;
import org.ovirt.engine.sdk.utils.UrlHelper;
import org.ovirt.engine.sdk.web.HttpProxyBroker;
import org.ovirt.engine.sdk.web.UrlParameterType;
import org.ovirt.engine.sdk.entities.Action;

/**
 * <p>DataCenters providing relation and functional services
 * <p>to {@link org.ovirt.engine.sdk.entities.DataCenters }.
 */
@SuppressWarnings("unused")
public class DataCenters extends
        CollectionDecorator<org.ovirt.engine.sdk.entities.DataCenter,
                            org.ovirt.engine.sdk.entities.DataCenters,
                            DataCenter> {

    /**
     * @param proxy HttpProxyBroker
     */
    public DataCenters(HttpProxyBroker proxy) {
        super(proxy, "datacenters");
    }

    /**
     * Lists DataCenter objects.
     *
     * @return
     *     List of {@link DataCenter }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    @Override
    public List<DataCenter> list() throws ClientProtocolException,
            ServerException, IOException {
        String url = SLASH + getName();
        return list(url, org.ovirt.engine.sdk.entities.DataCenters.class, DataCenter.class);
    }

    /**
     * Fetches DataCenter object by id.
     *
     * @return {@link DataCenter }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    @Override
    public DataCenter get(UUID id) throws ClientProtocolException,
            ServerException, IOException {
        String url = SLASH + getName() + SLASH + id.toString();
        return getProxy().get(url, org.ovirt.engine.sdk.entities.DataCenter.class, DataCenter.class);
    }

    /**
     * Fetches DataCenter object by id.
     *
     * @return {@link DataCenter }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    @Override
    public DataCenter getById(String id) throws ClientProtocolException,
            ServerException, IOException {
        String url = SLASH + getName() + SLASH + id;
        return getProxy().get(url, org.ovirt.engine.sdk.entities.DataCenter.class, DataCenter.class);
    }

    /**
     * Lists DataCenter objects.
     *
     * @param query
     *    <pre>
     *    [search query]
     *    </pre>
     * @param caseSensitive
     *    <pre>
     *    [true|false]
     *    </pre>
     * @param max
     *    <pre>
     *    [max results]
     *    </pre>
     *
     *
     * @return List of {@link DataCenter }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public List<DataCenter> list(String query, Boolean caseSensitive, Integer max) throws ClientProtocolException,
            ServerException, IOException {

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(SLASH + getName());
        if (query != null) {
            urlBuilder.add("search", query, UrlParameterType.QUERY);
        }
        if (caseSensitive != null) {
            urlBuilder.add("case_sensitive", caseSensitive, UrlParameterType.MATRIX);
        }
        if (max != null) {
            urlBuilder.add("max", max, UrlParameterType.MATRIX);
        }
        String url = urlBuilder.build();

        return list(url, org.ovirt.engine.sdk.entities.DataCenters.class,
                DataCenter.class, headers);
    }
    /**
     * Adds DataCenter object.
     *
     * @param datacenter {@link org.ovirt.engine.sdk.entities.DataCenter}
     *    <pre>
     *    datacenter.local
     *    datacenter.name
     *    [datacenter.comment]
     *    [datacenter.description]
     *    [datacenter.storage_format]
     *    [datacenter.storage_type]
     *    [datacenter.version.major]
     *    [datacenter.version.minor]
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
    public DataCenter add(org.ovirt.engine.sdk.entities.DataCenter datacenter) throws
            ClientProtocolException, ServerException, IOException {
        String url = SLASH + getName();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().add(url, datacenter,
                org.ovirt.engine.sdk.entities.DataCenter.class,
                DataCenter.class, headers);
    }
    /**
     * Adds DataCenter object.
     *
     * @param datacenter {@link org.ovirt.engine.sdk.entities.DataCenter}
     *    <pre>
     *    datacenter.local
     *    datacenter.name
     *    [datacenter.comment]
     *    [datacenter.description]
     *    [datacenter.storage_format]
     *    [datacenter.storage_type]
     *    [datacenter.version.major]
     *    [datacenter.version.minor]
     *    </pre>
     *
     * @param expect
     *    <pre>
     *    [201-created]
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
    public DataCenter add(org.ovirt.engine.sdk.entities.DataCenter datacenter, String expect) throws
            ClientProtocolException, ServerException, IOException {
        String url = SLASH + getName();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        if (expect != null) {
            headersBuilder.add("Expect", expect);
        }
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().add(url, datacenter,
                org.ovirt.engine.sdk.entities.DataCenter.class,
                DataCenter.class, headers);
    }
    /**
     * Adds DataCenter object.
     *
     * @param datacenter {@link org.ovirt.engine.sdk.entities.DataCenter}
     *    <pre>
     *    datacenter.local
     *    datacenter.name
     *    [datacenter.comment]
     *    [datacenter.description]
     *    [datacenter.storage_format]
     *    [datacenter.storage_type]
     *    [datacenter.version.major]
     *    [datacenter.version.minor]
     *    </pre>
     *
     * @param expect
     *    <pre>
     *    [201-created]
     *    </pre>
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
    public DataCenter add(org.ovirt.engine.sdk.entities.DataCenter datacenter, String expect, String correlationId) throws
            ClientProtocolException, ServerException, IOException {
        String url = SLASH + getName();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        if (expect != null) {
            headersBuilder.add("Expect", expect);
        }
        if (correlationId != null) {
            headersBuilder.add("Correlation-Id", correlationId);
        }
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().add(url, datacenter,
                org.ovirt.engine.sdk.entities.DataCenter.class,
                DataCenter.class, headers);
    }

}

