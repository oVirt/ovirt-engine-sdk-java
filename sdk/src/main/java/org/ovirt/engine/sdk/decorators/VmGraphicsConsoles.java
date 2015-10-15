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
 * <p>VmGraphicsConsoles providing relation and functional services
 * <p>to {@link org.ovirt.engine.sdk.entities.GraphicsConsoles }.
 */
@SuppressWarnings("unused")
public class VmGraphicsConsoles extends
        CollectionDecorator<org.ovirt.engine.sdk.entities.GraphicsConsole,
                            org.ovirt.engine.sdk.entities.GraphicsConsoles,
                            VmGraphicsConsole> {

    private Vm parent;

    /**
     * @param proxy HttpProxyBroker
     * @param parent Vm
     */
    public VmGraphicsConsoles(HttpProxyBroker proxy, Vm parent) {
        super(proxy, "graphicsconsoles");
        this.parent = parent;
    }

    /**
     * Lists VmGraphicsConsole objects.
     *
     * @return
     *     List of {@link VmGraphicsConsole }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    @Override
    public List<VmGraphicsConsole> list() throws ClientProtocolException,
            ServerException, IOException {
        String url = this.parent.getHref() + SLASH + getName();
        return list(url, org.ovirt.engine.sdk.entities.GraphicsConsoles.class, VmGraphicsConsole.class);
    }

    /**
     * Fetches VmGraphicsConsole object by id.
     *
     * @return
     *     {@link VmGraphicsConsole }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    @Override
    public VmGraphicsConsole get(UUID id) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.parent.getHref() + SLASH + getName() + SLASH + id.toString();
        return getProxy().get(url, org.ovirt.engine.sdk.entities.GraphicsConsole.class, VmGraphicsConsole.class);
    }

    /**
     * Fetches VmGraphicsConsole object by id.
     *
     * @return
     *     {@link VmGraphicsConsole }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    @Override
    public VmGraphicsConsole getById(String id) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.parent.getHref() + SLASH + getName() + SLASH + id;
        return getProxy().get(url, org.ovirt.engine.sdk.entities.GraphicsConsole.class, VmGraphicsConsole.class);
    }

    /**
     * Adds GraphicsConsole object.
     *
     * @param graphicsconsole {@link org.ovirt.engine.sdk.entities.GraphicsConsole}
     *    <pre>
     *    graphics_console.protocol
     *    </pre>
     *
     *
     * @return
     *     {@link VmGraphicsConsole }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public VmGraphicsConsole add(org.ovirt.engine.sdk.entities.GraphicsConsole graphicsconsole) throws
            ClientProtocolException, ServerException, IOException {
        String url = this.parent.getHref() + SLASH + getName();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().add(url, graphicsconsole,
                org.ovirt.engine.sdk.entities.GraphicsConsole.class,
                VmGraphicsConsole.class, headers);
    }
    /**
     * Adds GraphicsConsole object.
     *
     * @param graphicsconsole {@link org.ovirt.engine.sdk.entities.GraphicsConsole}
     *    <pre>
     *    graphics_console.protocol
     *    </pre>
     *
     * @param correlationId
     *    <pre>
     *    [any string]
     *    </pre>
     * @return
     *     {@link VmGraphicsConsole }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public VmGraphicsConsole add(org.ovirt.engine.sdk.entities.GraphicsConsole graphicsconsole, String correlationId) throws
            ClientProtocolException, ServerException, IOException {
        String url = this.parent.getHref() + SLASH + getName();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        if (correlationId != null) {
            headersBuilder.add("Correlation-Id", correlationId);
        }
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().add(url, graphicsconsole,
                org.ovirt.engine.sdk.entities.GraphicsConsole.class,
                VmGraphicsConsole.class, headers);
    }
    /**
     * Adds GraphicsConsole object.
     *
     * @param graphicsconsole {@link org.ovirt.engine.sdk.entities.GraphicsConsole}
     *    <pre>
     *    graphics_console.protocol
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
     *     {@link VmGraphicsConsole }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public VmGraphicsConsole add(org.ovirt.engine.sdk.entities.GraphicsConsole graphicsconsole, String correlationId, String expect) throws
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

        return getProxy().add(url, graphicsconsole,
                org.ovirt.engine.sdk.entities.GraphicsConsole.class,
                VmGraphicsConsole.class, headers);
    }
    /**
     * Lists VmGraphicsConsole objects.
     *
     * @param current
     *    <pre>
     *    [true|false]
     *    </pre>
     *
     * @return List of {@link VmGraphicsConsole }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public List<VmGraphicsConsole> list(Boolean current) throws ClientProtocolException,
            ServerException, IOException {

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(this.parent.getHref() + SLASH + getName());
        if (current != null) {
            urlBuilder.add("current", current, UrlParameterType.MATRIX);
        }

        String url = urlBuilder.build();

        return list(url, org.ovirt.engine.sdk.entities.GraphicsConsoles.class,
                VmGraphicsConsole.class, headers);
    }
    /**
     * Lists VmGraphicsConsole objects.
     *
     * @param current
     *    <pre>
     *    [true|false]
     *    </pre>
     * @param max
     *    <pre>
     *    [max results]
     *    </pre>
     *
     * @return List of {@link VmGraphicsConsole }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public List<VmGraphicsConsole> list(Boolean current, Integer max) throws ClientProtocolException,
            ServerException, IOException {

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(this.parent.getHref() + SLASH + getName());
        if (current != null) {
            urlBuilder.add("current", current, UrlParameterType.MATRIX);
        }

        if (max != null) {
            urlBuilder.add("max", max, UrlParameterType.MATRIX);
        }

        String url = urlBuilder.build();

        return list(url, org.ovirt.engine.sdk.entities.GraphicsConsoles.class,
                VmGraphicsConsole.class, headers);
    }

}
