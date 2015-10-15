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
 * <p>VmNics providing relation and functional services
 * <p>to {@link org.ovirt.engine.sdk.entities.Nics }.
 */
@SuppressWarnings("unused")
public class VmNics extends
        CollectionDecorator<org.ovirt.engine.sdk.entities.Nic,
                            org.ovirt.engine.sdk.entities.Nics,
                            VmNic> {

    private Vm parent;

    /**
     * @param proxy HttpProxyBroker
     * @param parent Vm
     */
    public VmNics(HttpProxyBroker proxy, Vm parent) {
        super(proxy, "nics");
        this.parent = parent;
    }

    /**
     * Lists VmNic objects.
     *
     * @return
     *     List of {@link VmNic }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    @Override
    public List<VmNic> list() throws ClientProtocolException,
            ServerException, IOException {
        String url = this.parent.getHref() + SLASH + getName();
        return list(url, org.ovirt.engine.sdk.entities.Nics.class, VmNic.class);
    }

    /**
     * Fetches VmNic object by id.
     *
     * @return
     *     {@link VmNic }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    @Override
    public VmNic get(UUID id) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.parent.getHref() + SLASH + getName() + SLASH + id.toString();
        return getProxy().get(url, org.ovirt.engine.sdk.entities.Nic.class, VmNic.class);
    }

    /**
     * Fetches VmNic object by id.
     *
     * @return
     *     {@link VmNic }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    @Override
    public VmNic getById(String id) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.parent.getHref() + SLASH + getName() + SLASH + id;
        return getProxy().get(url, org.ovirt.engine.sdk.entities.Nic.class, VmNic.class);
    }

    /**
     * Adds Nic object.
     *
     * @param nic {@link org.ovirt.engine.sdk.entities.Nic}
     *    <pre>
     *    nic.name
     *    [nic.vnic_profile.id]
     *    [nic.linked]
     *    [nic.mac.address]
     *    [nic.interface]
     *    [nic.plugged]
     *    </pre>
     *
     *
     * @return
     *     {@link VmNic }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public VmNic add(org.ovirt.engine.sdk.entities.Nic nic) throws
            ClientProtocolException, ServerException, IOException {
        String url = this.parent.getHref() + SLASH + getName();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().add(url, nic,
                org.ovirt.engine.sdk.entities.Nic.class,
                VmNic.class, headers);
    }
    /**
     * Adds Nic object.
     *
     * @param nic {@link org.ovirt.engine.sdk.entities.Nic}
     *    <pre>
     *    nic.name
     *    [nic.vnic_profile.id]
     *    [nic.linked]
     *    [nic.mac.address]
     *    [nic.interface]
     *    [nic.plugged]
     *    </pre>
     *
     * @param correlationId
     *    <pre>
     *    [any string]
     *    </pre>
     * @return
     *     {@link VmNic }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public VmNic add(org.ovirt.engine.sdk.entities.Nic nic, String correlationId) throws
            ClientProtocolException, ServerException, IOException {
        String url = this.parent.getHref() + SLASH + getName();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        if (correlationId != null) {
            headersBuilder.add("Correlation-Id", correlationId);
        }
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().add(url, nic,
                org.ovirt.engine.sdk.entities.Nic.class,
                VmNic.class, headers);
    }
    /**
     * Adds Nic object.
     *
     * @param nic {@link org.ovirt.engine.sdk.entities.Nic}
     *    <pre>
     *    nic.name
     *    [nic.vnic_profile.id]
     *    [nic.linked]
     *    [nic.mac.address]
     *    [nic.interface]
     *    [nic.plugged]
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
     *     {@link VmNic }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public VmNic add(org.ovirt.engine.sdk.entities.Nic nic, String correlationId, String expect) throws
            ClientProtocolException, ServerException, IOException {
        String url = this.parent.getHref() + SLASH + getName();

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

        return getProxy().add(url, nic,
                org.ovirt.engine.sdk.entities.Nic.class,
                VmNic.class, headers);
    }
    /**
     * Lists VmNic objects.
     *
     * @param allContent
     *    <pre>
     *    [true|false]
     *    </pre>
     *
     * @return List of {@link VmNic }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public List<VmNic> list(String allContent) throws ClientProtocolException,
            ServerException, IOException {

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        if (allContent != null) {
            headersBuilder.add("All-Content", allContent);
        }
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(this.parent.getHref() + SLASH + getName());
        String url = urlBuilder.build();

        return list(url, org.ovirt.engine.sdk.entities.Nics.class,
                VmNic.class, headers);
    }
    /**
     * Lists VmNic objects.
     *
     * @param allContent
     *    <pre>
     *    [true|false]
     *    </pre>
     * @param max
     *    <pre>
     *    [max results]
     *    </pre>
     *
     * @return List of {@link VmNic }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public List<VmNic> list(String allContent, Integer max) throws ClientProtocolException,
            ServerException, IOException {

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        if (allContent != null) {
            headersBuilder.add("All-Content", allContent);
        }
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(this.parent.getHref() + SLASH + getName());
        if (max != null) {
            urlBuilder.add("max", max, UrlParameterType.MATRIX);
        }

        String url = urlBuilder.build();

        return list(url, org.ovirt.engine.sdk.entities.Nics.class,
                VmNic.class, headers);
    }

}
