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
 * <p>VmPools providing relation and functional services
 * <p>to {@link org.ovirt.engine.sdk.entities.VmPools }.
 */
@SuppressWarnings("unused")
public class VmPools extends
        CollectionDecorator<org.ovirt.engine.sdk.entities.VmPool,
                            org.ovirt.engine.sdk.entities.VmPools,
                            VmPool> {

    /**
     * @param proxy HttpProxyBroker
     */
    public VmPools(HttpProxyBroker proxy) {
        super(proxy, "vmpools");
    }

    /**
     * Lists VmPool objects.
     *
     * @return
     *     List of {@link VmPool }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    @Override
    public List<VmPool> list() throws ClientProtocolException,
            ServerException, IOException {
        String url = SLASH + getName();
        return list(url, org.ovirt.engine.sdk.entities.VmPools.class, VmPool.class);
    }

    /**
     * Fetches VmPool object by id.
     *
     * @return {@link VmPool }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    @Override
    public VmPool get(UUID id) throws ClientProtocolException,
            ServerException, IOException {
        String url = SLASH + getName() + SLASH + id.toString();
        return getProxy().get(url, org.ovirt.engine.sdk.entities.VmPool.class, VmPool.class);
    }

    /**
     * Fetches VmPool object by id.
     *
     * @return {@link VmPool }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    @Override
    public VmPool getById(String id) throws ClientProtocolException,
            ServerException, IOException {
        String url = SLASH + getName() + SLASH + id;
        return getProxy().get(url, org.ovirt.engine.sdk.entities.VmPool.class, VmPool.class);
    }

    /**
     * Adds VmPool object.
     *
     * @param vmpool {@link org.ovirt.engine.sdk.entities.VmPool}
     *    <pre>
     *    vm_pool.cluster.id|name
     *    vm_pool.name
     *    vm_pool.template.id|name
     *    [vm_pool.comment]
     *    [vm_pool.description]
     *    [vm_pool.display.proxy]
     *    [vm_pool.max_user_vms]
     *    [vm_pool.size]
     *    [vm_pool.soundcard_enabled]
     *    [vm_pool.type]
     *    </pre>
     *
     *
     * @return
     *     {@link VmPool }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public VmPool add(org.ovirt.engine.sdk.entities.VmPool vmpool) throws
            ClientProtocolException, ServerException, IOException {
        String url = SLASH + getName();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().add(url, vmpool,
                org.ovirt.engine.sdk.entities.VmPool.class,
                VmPool.class, headers);
    }
    /**
     * Adds VmPool object.
     *
     * @param vmpool {@link org.ovirt.engine.sdk.entities.VmPool}
     *    <pre>
     *    vm_pool.cluster.id|name
     *    vm_pool.name
     *    vm_pool.template.id|name
     *    [vm_pool.comment]
     *    [vm_pool.description]
     *    [vm_pool.display.proxy]
     *    [vm_pool.max_user_vms]
     *    [vm_pool.size]
     *    [vm_pool.soundcard_enabled]
     *    [vm_pool.type]
     *    </pre>
     *
     * @param correlationId
     *    <pre>
     *    [any string]
     *    </pre>
     * @return
     *     {@link VmPool }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public VmPool add(org.ovirt.engine.sdk.entities.VmPool vmpool, String correlationId) throws
            ClientProtocolException, ServerException, IOException {
        String url = SLASH + getName();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        if (correlationId != null) {
            headersBuilder.add("Correlation-Id", correlationId);
        }
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().add(url, vmpool,
                org.ovirt.engine.sdk.entities.VmPool.class,
                VmPool.class, headers);
    }
    /**
     * Adds VmPool object.
     *
     * @param vmpool {@link org.ovirt.engine.sdk.entities.VmPool}
     *    <pre>
     *    vm_pool.cluster.id|name
     *    vm_pool.name
     *    vm_pool.template.id|name
     *    [vm_pool.comment]
     *    [vm_pool.description]
     *    [vm_pool.display.proxy]
     *    [vm_pool.max_user_vms]
     *    [vm_pool.size]
     *    [vm_pool.soundcard_enabled]
     *    [vm_pool.type]
     *    </pre>
     *
     * @param correlationId
     *    <pre>
     *    [any string]
     *    </pre>
     * @param expect
     *    <pre>
     *    [201-created]
     *    </pre>
     * @return
     *     {@link VmPool }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public VmPool add(org.ovirt.engine.sdk.entities.VmPool vmpool, String correlationId, String expect) throws
            ClientProtocolException, ServerException, IOException {
        String url = SLASH + getName();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        if (correlationId != null) {
            headersBuilder.add("Correlation-Id", correlationId);
        }
        if (expect != null) {
            headersBuilder.add("Expect", expect);
        }
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().add(url, vmpool,
                org.ovirt.engine.sdk.entities.VmPool.class,
                VmPool.class, headers);
    }
    /**
     * Lists VmPool objects.
     *
     * @param caseSensitive
     *    <pre>
     *    [true|false]
     *    </pre>
     *
     * @return List of {@link VmPool }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public List<VmPool> list(Boolean caseSensitive) throws ClientProtocolException,
            ServerException, IOException {

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(SLASH + getName());
        if (caseSensitive != null) {
            urlBuilder.add("case_sensitive", caseSensitive, UrlParameterType.MATRIX);
        }

        String url = urlBuilder.build();

        return list(url, org.ovirt.engine.sdk.entities.VmPools.class,
                VmPool.class, headers);
    }
    /**
     * Lists VmPool objects.
     *
     * @param caseSensitive
     *    <pre>
     *    [true|false]
     *    </pre>
     * @param max
     *    <pre>
     *    [max results]
     *    </pre>
     *
     * @return List of {@link VmPool }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public List<VmPool> list(Boolean caseSensitive, Integer max) throws ClientProtocolException,
            ServerException, IOException {

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(SLASH + getName());
        if (caseSensitive != null) {
            urlBuilder.add("case_sensitive", caseSensitive, UrlParameterType.MATRIX);
        }

        if (max != null) {
            urlBuilder.add("max", max, UrlParameterType.MATRIX);
        }

        String url = urlBuilder.build();

        return list(url, org.ovirt.engine.sdk.entities.VmPools.class,
                VmPool.class, headers);
    }
    /**
     * Lists VmPool objects.
     *
     * @param caseSensitive
     *    <pre>
     *    [true|false]
     *    </pre>
     * @param max
     *    <pre>
     *    [max results]
     *    </pre>
     * @param query
     *    <pre>
     *    [search query]
     *    </pre>
     *
     * @return List of {@link VmPool }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public List<VmPool> list(Boolean caseSensitive, Integer max, String query) throws ClientProtocolException,
            ServerException, IOException {

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(SLASH + getName());
        if (caseSensitive != null) {
            urlBuilder.add("case_sensitive", caseSensitive, UrlParameterType.MATRIX);
        }

        if (max != null) {
            urlBuilder.add("max", max, UrlParameterType.MATRIX);
        }

        if (query != null) {
            urlBuilder.add("search", query, UrlParameterType.QUERY);
        }

        String url = urlBuilder.build();

        return list(url, org.ovirt.engine.sdk.entities.VmPools.class,
                VmPool.class, headers);
    }

}
