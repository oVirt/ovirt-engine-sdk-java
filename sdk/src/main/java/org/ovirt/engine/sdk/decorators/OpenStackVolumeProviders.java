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
 * <p>OpenStackVolumeProviders providing relation and functional services
 * <p>to {@link org.ovirt.engine.sdk.entities.OpenStackVolumeProviders }.
 */
@SuppressWarnings("unused")
public class OpenStackVolumeProviders extends
        CollectionDecorator<org.ovirt.engine.sdk.entities.OpenStackVolumeProvider,
                            org.ovirt.engine.sdk.entities.OpenStackVolumeProviders,
                            OpenStackVolumeProvider> {

    /**
     * @param proxy HttpProxyBroker
     */
    public OpenStackVolumeProviders(HttpProxyBroker proxy) {
        super(proxy, "openstackvolumeproviders");
    }

    /**
     * Lists OpenStackVolumeProvider objects.
     *
     * @return
     *     List of {@link OpenStackVolumeProvider }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    @Override
    public List<OpenStackVolumeProvider> list() throws ClientProtocolException,
            ServerException, IOException {
        String url = SLASH + getName();
        return list(url, org.ovirt.engine.sdk.entities.OpenStackVolumeProviders.class, OpenStackVolumeProvider.class);
    }

    /**
     * Fetches OpenStackVolumeProvider object by id.
     *
     * @return {@link OpenStackVolumeProvider }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    @Override
    public OpenStackVolumeProvider get(UUID id) throws ClientProtocolException,
            ServerException, IOException {
        String url = SLASH + getName() + SLASH + id.toString();
        return getProxy().get(url, org.ovirt.engine.sdk.entities.OpenStackVolumeProvider.class, OpenStackVolumeProvider.class);
    }

    /**
     * Fetches OpenStackVolumeProvider object by id.
     *
     * @return {@link OpenStackVolumeProvider }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    @Override
    public OpenStackVolumeProvider getById(String id) throws ClientProtocolException,
            ServerException, IOException {
        String url = SLASH + getName() + SLASH + id;
        return getProxy().get(url, org.ovirt.engine.sdk.entities.OpenStackVolumeProvider.class, OpenStackVolumeProvider.class);
    }

    /**
     * Adds OpenStackVolumeProvider object.
     *
     * @param openstackvolumeprovider {@link org.ovirt.engine.sdk.entities.OpenStackVolumeProvider}
     *    <pre>
     *    openstack_volume_provider.name
     *    openstack_volume_provider.data_center.id|name
     *    [openstack_volume_provider.description]
     *    [openstack_volume_provider.url]
     *    [openstack_volume_provider.requires_authentication]
     *    [openstack_volume_provider.username]
     *    [openstack_volume_provider.password]
     *    [openstack_volume_provider.authentication_url]
     *    [openstack_volume_provider.properties.property]
     *    </pre>
     *
     * @return
     *     {@link OpenStackVolumeProvider }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public OpenStackVolumeProvider add(org.ovirt.engine.sdk.entities.OpenStackVolumeProvider openstackvolumeprovider) throws
            ClientProtocolException, ServerException, IOException {
        String url = SLASH + getName();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().add(url, openstackvolumeprovider,
                org.ovirt.engine.sdk.entities.OpenStackVolumeProvider.class,
                OpenStackVolumeProvider.class, headers);
    }
    /**
     * Adds OpenStackVolumeProvider object.
     *
     * @param openstackvolumeprovider {@link org.ovirt.engine.sdk.entities.OpenStackVolumeProvider}
     *    <pre>
     *    openstack_volume_provider.name
     *    openstack_volume_provider.data_center.id|name
     *    [openstack_volume_provider.description]
     *    [openstack_volume_provider.url]
     *    [openstack_volume_provider.requires_authentication]
     *    [openstack_volume_provider.username]
     *    [openstack_volume_provider.password]
     *    [openstack_volume_provider.authentication_url]
     *    [openstack_volume_provider.properties.property]
     *    </pre>
     *
     * @param correlationId
     *    <pre>
     *    [any string]
     *    </pre>
     *
     * @return
     *     {@link OpenStackVolumeProvider }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public OpenStackVolumeProvider add(org.ovirt.engine.sdk.entities.OpenStackVolumeProvider openstackvolumeprovider, String correlationId) throws
            ClientProtocolException, ServerException, IOException {
        String url = SLASH + getName();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        if (correlationId != null) {
            headersBuilder.add("Correlation-Id", correlationId);
        }
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().add(url, openstackvolumeprovider,
                org.ovirt.engine.sdk.entities.OpenStackVolumeProvider.class,
                OpenStackVolumeProvider.class, headers);
    }
    /**
     * Adds OpenStackVolumeProvider object.
     *
     * @param openstackvolumeprovider {@link org.ovirt.engine.sdk.entities.OpenStackVolumeProvider}
     *    <pre>
     *    openstack_volume_provider.name
     *    openstack_volume_provider.data_center.id|name
     *    [openstack_volume_provider.description]
     *    [openstack_volume_provider.url]
     *    [openstack_volume_provider.requires_authentication]
     *    [openstack_volume_provider.username]
     *    [openstack_volume_provider.password]
     *    [openstack_volume_provider.authentication_url]
     *    [openstack_volume_provider.properties.property]
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
     *
     * @return
     *     {@link OpenStackVolumeProvider }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public OpenStackVolumeProvider add(org.ovirt.engine.sdk.entities.OpenStackVolumeProvider openstackvolumeprovider, String correlationId, String expect) throws
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

        return getProxy().add(url, openstackvolumeprovider,
                org.ovirt.engine.sdk.entities.OpenStackVolumeProvider.class,
                OpenStackVolumeProvider.class, headers);
    }
    /**
     * Lists OpenStackVolumeProvider objects.
     *
     * @param max
     *    <pre>
     *    [max results]
     *    </pre>
     *
     *
     * @return List of {@link OpenStackVolumeProvider }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public List<OpenStackVolumeProvider> list(Integer max) throws ClientProtocolException,
            ServerException, IOException {

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(SLASH + getName());
        if (max != null) {
            urlBuilder.add("max", max, UrlParameterType.MATRIX);
        }

        String url = urlBuilder.build();

        return list(url, org.ovirt.engine.sdk.entities.OpenStackVolumeProviders.class,
                OpenStackVolumeProvider.class, headers);
    }

}
