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
 * <p>VMVirtualNumaNodes providing relation and functional services
 * <p>to {@link org.ovirt.engine.sdk.entities.VirtualNumaNodes }.
 */
@SuppressWarnings("unused")
public class VMVirtualNumaNodes extends
        CollectionDecorator<org.ovirt.engine.sdk.entities.VirtualNumaNode,
                            org.ovirt.engine.sdk.entities.VirtualNumaNodes,
                            VMVirtualNumaNode> {

    private VM parent;

    /**
     * @param proxy HttpProxyBroker
     * @param parent VM
     */
    public VMVirtualNumaNodes(HttpProxyBroker proxy, VM parent) {
        super(proxy, "numanodes");
        this.parent = parent;
    }

    /**
     * Lists VMVirtualNumaNode objects.
     *
     * @return
     *     List of {@link VMVirtualNumaNode }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    @Override
    public List<VMVirtualNumaNode> list() throws ClientProtocolException,
            ServerException, IOException {
        String url = this.parent.getHref() + SLASH + getName();
        return list(url, org.ovirt.engine.sdk.entities.VirtualNumaNodes.class, VMVirtualNumaNode.class);
    }

    /**
     * Fetches VMVirtualNumaNode object by id.
     *
     * @return
     *     {@link VMVirtualNumaNode }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    @Override
    public VMVirtualNumaNode get(UUID id) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.parent.getHref() + SLASH + getName() + SLASH + id.toString();
        return getProxy().get(url, org.ovirt.engine.sdk.entities.VirtualNumaNode.class, VMVirtualNumaNode.class);
    }

    /**
     * Fetches VMVirtualNumaNode object by id.
     *
     * @return
     *     {@link VMVirtualNumaNode }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    @Override
    public VMVirtualNumaNode getById(String id) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.parent.getHref() + SLASH + getName() + SLASH + id;
        return getProxy().get(url, org.ovirt.engine.sdk.entities.VirtualNumaNode.class, VMVirtualNumaNode.class);
    }

    /**
     * Lists VMVirtualNumaNode objects.
     *
     * @param max
     *    <pre>
     *    [max results]
     *    </pre>
     *
     *
     * @return List of {@link VMVirtualNumaNode }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public List<VMVirtualNumaNode> list(Integer max) throws ClientProtocolException,
            ServerException, IOException {

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(this.parent.getHref() + SLASH + getName());
        if (max != null) {
            urlBuilder.add("max", max, UrlParameterType.MATRIX);
        }
        String url = urlBuilder.build();

        return list(url, org.ovirt.engine.sdk.entities.VirtualNumaNodes.class,
                VMVirtualNumaNode.class, headers);
    }
    /**
     * Adds VirtualNumaNode object.
     *
     * @param virtualnumanode {@link org.ovirt.engine.sdk.entities.VirtualNumaNode}
     *    <pre>
     *    vm_numa_node.index
     *    vm_numa_node.memory
     *    vm_numa_node.cpu.cores.core
     *    [vm_numa_node.numa_node_pins.numa_node_pin]
     *    </pre>
     *
     * @return
     *     {@link VMVirtualNumaNode }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public VMVirtualNumaNode add(org.ovirt.engine.sdk.entities.VirtualNumaNode virtualnumanode) throws
            ClientProtocolException, ServerException, IOException {
        String url = this.parent.getHref() + SLASH + getName();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().add(url, virtualnumanode,
                org.ovirt.engine.sdk.entities.VirtualNumaNode.class,
                VMVirtualNumaNode.class, headers);
    }
    /**
     * Adds VirtualNumaNode object.
     *
     * @param virtualnumanode {@link org.ovirt.engine.sdk.entities.VirtualNumaNode}
     *    <pre>
     *    vm_numa_node.index
     *    vm_numa_node.memory
     *    vm_numa_node.cpu.cores.core
     *    [vm_numa_node.numa_node_pins.numa_node_pin]
     *    </pre>
     *
     * @param expect
     *    <pre>
     *    [201-created]
     *    </pre>
     *
     * @return
     *     {@link VMVirtualNumaNode }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public VMVirtualNumaNode add(org.ovirt.engine.sdk.entities.VirtualNumaNode virtualnumanode, String expect) throws
            ClientProtocolException, ServerException, IOException {
        String url = this.parent.getHref() + SLASH + getName();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        if (expect != null) {
            headersBuilder.add("Expect", expect);
        }
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().add(url, virtualnumanode,
                org.ovirt.engine.sdk.entities.VirtualNumaNode.class,
                VMVirtualNumaNode.class, headers);
    }
    /**
     * Adds VirtualNumaNode object.
     *
     * @param virtualnumanode {@link org.ovirt.engine.sdk.entities.VirtualNumaNode}
     *    <pre>
     *    vm_numa_node.index
     *    vm_numa_node.memory
     *    vm_numa_node.cpu.cores.core
     *    [vm_numa_node.numa_node_pins.numa_node_pin]
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
     *     {@link VMVirtualNumaNode }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public VMVirtualNumaNode add(org.ovirt.engine.sdk.entities.VirtualNumaNode virtualnumanode, String expect, String correlationId) throws
            ClientProtocolException, ServerException, IOException {
        String url = this.parent.getHref() + SLASH + getName();

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

        return getProxy().add(url, virtualnumanode,
                org.ovirt.engine.sdk.entities.VirtualNumaNode.class,
                VMVirtualNumaNode.class, headers);
    }

}

