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
 * <p>InstanceTypes providing relation and functional services
 * <p>to {@link org.ovirt.engine.sdk.entities.InstanceTypes }.
 */
@SuppressWarnings("unused")
public class InstanceTypes extends
        CollectionDecorator<org.ovirt.engine.sdk.entities.InstanceType,
                            org.ovirt.engine.sdk.entities.InstanceTypes,
                            InstanceType> {

    /**
     * @param proxy HttpProxyBroker
     */
    public InstanceTypes(HttpProxyBroker proxy) {
        super(proxy, "instancetypes");
    }

    /**
     * Lists InstanceType objects.
     *
     * @return
     *     List of {@link InstanceType }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    @Override
    public List<InstanceType> list() throws ClientProtocolException,
            ServerException, IOException {
        String url = SLASH + getName();
        return list(url, org.ovirt.engine.sdk.entities.InstanceTypes.class, InstanceType.class);
    }

    /**
     * Fetches InstanceType object by id.
     *
     * @return {@link InstanceType }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    @Override
    public InstanceType get(UUID id) throws ClientProtocolException,
            ServerException, IOException {
        String url = SLASH + getName() + SLASH + id.toString();
        return getProxy().get(url, org.ovirt.engine.sdk.entities.InstanceType.class, InstanceType.class);
    }

    /**
     * Fetches InstanceType object by id.
     *
     * @return {@link InstanceType }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    @Override
    public InstanceType getById(String id) throws ClientProtocolException,
            ServerException, IOException {
        String url = SLASH + getName() + SLASH + id;
        return getProxy().get(url, org.ovirt.engine.sdk.entities.InstanceType.class, InstanceType.class);
    }

    /**
     * Lists InstanceType objects.
     *
     * @param max
     *    <pre>
     *    [max results]
     *    </pre>
     *
     *
     * @return List of {@link InstanceType }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public List<InstanceType> list(Integer max) throws ClientProtocolException,
            ServerException, IOException {

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(SLASH + getName());
        if (max != null) {
            urlBuilder.add("max", max, UrlParameterType.MATRIX);
        }
        String url = urlBuilder.build();

        return list(url, org.ovirt.engine.sdk.entities.InstanceTypes.class,
                InstanceType.class, headers);
    }
    /**
     * Adds InstanceType object.
     *
     * @param instancetype {@link org.ovirt.engine.sdk.entities.InstanceType}
     *    <pre>
     *    instance_type.name
     *    [instance_type.memory]
     *    [instance_type.cpu.topology.cores]
     *    [instance_type.high_availability.enabled]
     *    [instance_type.origin]
     *    [instance_type.high_availability.priority]
     *    [instance_type.console.enabled]
     *    [instance_type.description]
     *    [instance_type.os.boot]
     *    [instance_type.cpu.topology.sockets]
     *    [instance_type.cpu_shares]
     *    [instance_type.cpu.architecture]
     *    [instance_type.display.type]
     *    [instance_type.display.monitors]
     *    [instance_typeay.single_qxl_pci]
     *    [instance_type.display.smartcard_enabled]
     *    [instance_type.usb.enabled]
     *    [instance_type.usb.type]
     *    [instance_type.migration_downtime]
     *    [instance_type.virtio_scsi.enabled]
     *    [instance_type.soundcard_enabled]
     *    </pre>
     *
     * @return
     *     {@link InstanceType }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public InstanceType add(org.ovirt.engine.sdk.entities.InstanceType instancetype) throws
            ClientProtocolException, ServerException, IOException {
        String url = SLASH + getName();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().add(url, instancetype,
                org.ovirt.engine.sdk.entities.InstanceType.class,
                InstanceType.class, headers);
    }
    /**
     * Adds InstanceType object.
     *
     * @param instancetype {@link org.ovirt.engine.sdk.entities.InstanceType}
     *    <pre>
     *    instance_type.name
     *    [instance_type.memory]
     *    [instance_type.cpu.topology.cores]
     *    [instance_type.high_availability.enabled]
     *    [instance_type.origin]
     *    [instance_type.high_availability.priority]
     *    [instance_type.console.enabled]
     *    [instance_type.description]
     *    [instance_type.os.boot]
     *    [instance_type.cpu.topology.sockets]
     *    [instance_type.cpu_shares]
     *    [instance_type.cpu.architecture]
     *    [instance_type.display.type]
     *    [instance_type.display.monitors]
     *    [instance_typeay.single_qxl_pci]
     *    [instance_type.display.smartcard_enabled]
     *    [instance_type.usb.enabled]
     *    [instance_type.usb.type]
     *    [instance_type.migration_downtime]
     *    [instance_type.virtio_scsi.enabled]
     *    [instance_type.soundcard_enabled]
     *    </pre>
     *
     * @param expect
     *    <pre>
     *    [201-created]
     *    </pre>
     *
     * @return
     *     {@link InstanceType }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public InstanceType add(org.ovirt.engine.sdk.entities.InstanceType instancetype, String expect) throws
            ClientProtocolException, ServerException, IOException {
        String url = SLASH + getName();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        if (expect != null) {
            headersBuilder.add("Expect", expect);
        }
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().add(url, instancetype,
                org.ovirt.engine.sdk.entities.InstanceType.class,
                InstanceType.class, headers);
    }
    /**
     * Adds InstanceType object.
     *
     * @param instancetype {@link org.ovirt.engine.sdk.entities.InstanceType}
     *    <pre>
     *    instance_type.name
     *    [instance_type.memory]
     *    [instance_type.cpu.topology.cores]
     *    [instance_type.high_availability.enabled]
     *    [instance_type.origin]
     *    [instance_type.high_availability.priority]
     *    [instance_type.console.enabled]
     *    [instance_type.description]
     *    [instance_type.os.boot]
     *    [instance_type.cpu.topology.sockets]
     *    [instance_type.cpu_shares]
     *    [instance_type.cpu.architecture]
     *    [instance_type.display.type]
     *    [instance_type.display.monitors]
     *    [instance_typeay.single_qxl_pci]
     *    [instance_type.display.smartcard_enabled]
     *    [instance_type.usb.enabled]
     *    [instance_type.usb.type]
     *    [instance_type.migration_downtime]
     *    [instance_type.virtio_scsi.enabled]
     *    [instance_type.soundcard_enabled]
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
     *     {@link InstanceType }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public InstanceType add(org.ovirt.engine.sdk.entities.InstanceType instancetype, String expect, String correlationId) throws
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

        return getProxy().add(url, instancetype,
                org.ovirt.engine.sdk.entities.InstanceType.class,
                InstanceType.class, headers);
    }

}

