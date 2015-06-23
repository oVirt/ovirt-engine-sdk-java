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
 * <p>OpenStackNetworkProviders providing relation and functional services
 * <p>to {@link org.ovirt.engine.sdk.entities.OpenStackNetworkProviders }.
 */
@SuppressWarnings("unused")
public class OpenStackNetworkProviders extends
        CollectionDecorator<org.ovirt.engine.sdk.entities.OpenStackNetworkProvider,
                            org.ovirt.engine.sdk.entities.OpenStackNetworkProviders,
                            OpenStackNetworkProvider> {

    /**
     * @param proxy HttpProxyBroker
     */
    public OpenStackNetworkProviders(HttpProxyBroker proxy) {
        super(proxy, "openstacknetworkproviders");
    }

    /**
     * Lists OpenStackNetworkProvider objects.
     *
     * @return
     *     List of {@link OpenStackNetworkProvider }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    @Override
    public List<OpenStackNetworkProvider> list() throws ClientProtocolException,
            ServerException, IOException {
        String url = SLASH + getName();
        return list(url, org.ovirt.engine.sdk.entities.OpenStackNetworkProviders.class, OpenStackNetworkProvider.class);
    }

    /**
     * Fetches OpenStackNetworkProvider object by id.
     *
     * @return {@link OpenStackNetworkProvider }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    @Override
    public OpenStackNetworkProvider get(UUID id) throws ClientProtocolException,
            ServerException, IOException {
        String url = SLASH + getName() + SLASH + id.toString();
        return getProxy().get(url, org.ovirt.engine.sdk.entities.OpenStackNetworkProvider.class, OpenStackNetworkProvider.class);
    }

    /**
     * Fetches OpenStackNetworkProvider object by id.
     *
     * @return {@link OpenStackNetworkProvider }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    @Override
    public OpenStackNetworkProvider getById(String id) throws ClientProtocolException,
            ServerException, IOException {
        String url = SLASH + getName() + SLASH + id;
        return getProxy().get(url, org.ovirt.engine.sdk.entities.OpenStackNetworkProvider.class, OpenStackNetworkProvider.class);
    }

    /**
     * Adds OpenStackNetworkProvider object.
     *
     * @param openstacknetworkprovider {@link org.ovirt.engine.sdk.entities.OpenStackNetworkProvider}
     *    <pre>
     *    openstack_network_provider.name
     *    [openstack_network_provider.description]
     *    [openstack_network_provider.url]
     *    [openstack_network_provider.requires_authentication]
     *    [openstack_network_provider.username]
     *    [openstack_network_provider.password]
     *    [openstack_network_provider.authentication_url]
     *    [openstack_network_provider.properties.property]
     *    [openstack_network_provider.tenant_name]
     *    </pre>
     *
     *
     * @return
     *     {@link OpenStackNetworkProvider }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public OpenStackNetworkProvider add(org.ovirt.engine.sdk.entities.OpenStackNetworkProvider openstacknetworkprovider) throws
            ClientProtocolException, ServerException, IOException {
        String url = SLASH + getName();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().add(url, openstacknetworkprovider,
                org.ovirt.engine.sdk.entities.OpenStackNetworkProvider.class,
                OpenStackNetworkProvider.class, headers);
    }
    /**
     * Adds OpenStackNetworkProvider object.
     *
     * @param openstacknetworkprovider {@link org.ovirt.engine.sdk.entities.OpenStackNetworkProvider}
     *    <pre>
     *    openstack_network_provider.name
     *    [openstack_network_provider.description]
     *    [openstack_network_provider.url]
     *    [openstack_network_provider.requires_authentication]
     *    [openstack_network_provider.username]
     *    [openstack_network_provider.password]
     *    [openstack_network_provider.authentication_url]
     *    [openstack_network_provider.properties.property]
     *    [openstack_network_provider.tenant_name]
     *    </pre>
     *
     * @param correlationId
     *    <pre>
     *    [any string]
     *    </pre>
     * @return
     *     {@link OpenStackNetworkProvider }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public OpenStackNetworkProvider add(org.ovirt.engine.sdk.entities.OpenStackNetworkProvider openstacknetworkprovider, String correlationId) throws
            ClientProtocolException, ServerException, IOException {
        String url = SLASH + getName();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        if (correlationId != null) {
            headersBuilder.add("Correlation-Id", correlationId);
        }
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().add(url, openstacknetworkprovider,
                org.ovirt.engine.sdk.entities.OpenStackNetworkProvider.class,
                OpenStackNetworkProvider.class, headers);
    }
    /**
     * Adds OpenStackNetworkProvider object.
     *
     * @param openstacknetworkprovider {@link org.ovirt.engine.sdk.entities.OpenStackNetworkProvider}
     *    <pre>
     *    openstack_network_provider.name
     *    [openstack_network_provider.description]
     *    [openstack_network_provider.url]
     *    [openstack_network_provider.requires_authentication]
     *    [openstack_network_provider.username]
     *    [openstack_network_provider.password]
     *    [openstack_network_provider.authentication_url]
     *    [openstack_network_provider.properties.property]
     *    [openstack_network_provider.tenant_name]
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
     *     {@link OpenStackNetworkProvider }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public OpenStackNetworkProvider add(org.ovirt.engine.sdk.entities.OpenStackNetworkProvider openstacknetworkprovider, String correlationId, String expect) throws
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

        return getProxy().add(url, openstacknetworkprovider,
                org.ovirt.engine.sdk.entities.OpenStackNetworkProvider.class,
                OpenStackNetworkProvider.class, headers);
    }
    /**
     * Lists OpenStackNetworkProvider objects.
     *
     * @param max
     *    <pre>
     *    [max results]
     *    </pre>
     *
     * @return List of {@link OpenStackNetworkProvider }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public List<OpenStackNetworkProvider> list(Integer max) throws ClientProtocolException,
            ServerException, IOException {

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(SLASH + getName());
        if (max != null) {
            urlBuilder.add("max", max, UrlParameterType.MATRIX);
        }

        String url = urlBuilder.build();

        return list(url, org.ovirt.engine.sdk.entities.OpenStackNetworkProviders.class,
                OpenStackNetworkProvider.class, headers);
    }

}
