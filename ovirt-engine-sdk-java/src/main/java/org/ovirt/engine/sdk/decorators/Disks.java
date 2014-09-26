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
 * <p>Disks providing relation and functional services
 * <p>to {@link org.ovirt.engine.sdk.entities.Disks }.
 */
@SuppressWarnings("unused")
public class Disks extends
        CollectionDecorator<org.ovirt.engine.sdk.entities.Disk,
                            org.ovirt.engine.sdk.entities.Disks,
                            Disk> {

    /**
     * @param proxy HttpProxyBroker
     */
    public Disks(HttpProxyBroker proxy) {
        super(proxy, "disks");
    }

    /**
     * Lists Disk objects.
     *
     * @return
     *     List of {@link Disk }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    @Override
    public List<Disk> list() throws ClientProtocolException,
            ServerException, IOException {
        String url = SLASH + getName();
        return list(url, org.ovirt.engine.sdk.entities.Disks.class, Disk.class);
    }

    /**
     * Fetches Disk object by id.
     *
     * @return {@link Disk }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    @Override
    public Disk get(UUID id) throws ClientProtocolException,
            ServerException, IOException {
        String url = SLASH + getName() + SLASH + id.toString();
        return getProxy().get(url, org.ovirt.engine.sdk.entities.Disk.class, Disk.class);
    }

    /**
     * Fetches Disk object by id.
     *
     * @return {@link Disk }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    @Override
    public Disk getById(String id) throws ClientProtocolException,
            ServerException, IOException {
        String url = SLASH + getName() + SLASH + id;
        return getProxy().get(url, org.ovirt.engine.sdk.entities.Disk.class, Disk.class);
    }

    /**
     * Lists Disk objects.
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
     * @return List of {@link Disk }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public List<Disk> list(String query, Boolean caseSensitive, Integer max) throws ClientProtocolException,
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

        return list(url, org.ovirt.engine.sdk.entities.Disks.class,
                Disk.class, headers);
    }
    /**
     * Adds Disk object.
     *
     * @param disk {@link org.ovirt.engine.sdk.entities.Disk}
     *    <pre>
     *    Overload 1:
     *
     *      add a new disk to the system
     *      with specified size, space
     *      will be allocated from the
     *      storage domain for the disk
     *
     *      provisioned_size
     *      disk.interface
     *      disk.format
     *      [disk.alias]
     *      [disk.name]
     *      [disk.size]
     *      [disk.sparse]
     *      [disk.bootable]
     *      [disk.shareable]
     *      [disk.propagate_errors]
     *      [disk.wipe_after_delete]
     *      [disk.quota.id]
     *      [disk.disk_profile.id]
     *      [disk.storage_domains.storage_domain]
     *
     *    Overload 2:
     *
     *      add a new lun disk to the
     *      system, this operation does
     *      not require size but requires
     *      lun connection details
     *
     *      disk.interface
     *      disk.lun_storage.type
     *      disk.lun_storage.logical_unit
     *      [disk.alias]
     *      [disk.sparse]
     *      [disk.bootable]
     *      [disk.shareable]
     *      [disk.propagate_errors]
     *      [disk.wipe_after_delete]
     *      [disk.quota.id]
     *      [disk.sgio]
     *      [disk.lun_storage.host]
     *    </pre>
     *
     * @return
     *     {@link Disk }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public Disk add(org.ovirt.engine.sdk.entities.Disk disk) throws
            ClientProtocolException, ServerException, IOException {
        String url = SLASH + getName();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().add(url, disk,
                org.ovirt.engine.sdk.entities.Disk.class,
                Disk.class, headers);
    }
    /**
     * Adds Disk object.
     *
     * @param disk {@link org.ovirt.engine.sdk.entities.Disk}
     *    <pre>
     *    Overload 1:
     *
     *      add a new disk to the system
     *      with specified size, space
     *      will be allocated from the
     *      storage domain for the disk
     *
     *      provisioned_size
     *      disk.interface
     *      disk.format
     *      [disk.alias]
     *      [disk.name]
     *      [disk.size]
     *      [disk.sparse]
     *      [disk.bootable]
     *      [disk.shareable]
     *      [disk.propagate_errors]
     *      [disk.wipe_after_delete]
     *      [disk.quota.id]
     *      [disk.disk_profile.id]
     *      [disk.storage_domains.storage_domain]
     *
     *    Overload 2:
     *
     *      add a new lun disk to the
     *      system, this operation does
     *      not require size but requires
     *      lun connection details
     *
     *      disk.interface
     *      disk.lun_storage.type
     *      disk.lun_storage.logical_unit
     *      [disk.alias]
     *      [disk.sparse]
     *      [disk.bootable]
     *      [disk.shareable]
     *      [disk.propagate_errors]
     *      [disk.wipe_after_delete]
     *      [disk.quota.id]
     *      [disk.sgio]
     *      [disk.lun_storage.host]
     *    </pre>
     *
     * @param expect
     *    <pre>
     *    [201-created]
     *    </pre>
     *
     * @return
     *     {@link Disk }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public Disk add(org.ovirt.engine.sdk.entities.Disk disk, String expect) throws
            ClientProtocolException, ServerException, IOException {
        String url = SLASH + getName();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        if (expect != null) {
            headersBuilder.add("Expect", expect);
        }
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().add(url, disk,
                org.ovirt.engine.sdk.entities.Disk.class,
                Disk.class, headers);
    }
    /**
     * Adds Disk object.
     *
     * @param disk {@link org.ovirt.engine.sdk.entities.Disk}
     *    <pre>
     *    Overload 1:
     *
     *      add a new disk to the system
     *      with specified size, space
     *      will be allocated from the
     *      storage domain for the disk
     *
     *      provisioned_size
     *      disk.interface
     *      disk.format
     *      [disk.alias]
     *      [disk.name]
     *      [disk.size]
     *      [disk.sparse]
     *      [disk.bootable]
     *      [disk.shareable]
     *      [disk.propagate_errors]
     *      [disk.wipe_after_delete]
     *      [disk.quota.id]
     *      [disk.disk_profile.id]
     *      [disk.storage_domains.storage_domain]
     *
     *    Overload 2:
     *
     *      add a new lun disk to the
     *      system, this operation does
     *      not require size but requires
     *      lun connection details
     *
     *      disk.interface
     *      disk.lun_storage.type
     *      disk.lun_storage.logical_unit
     *      [disk.alias]
     *      [disk.sparse]
     *      [disk.bootable]
     *      [disk.shareable]
     *      [disk.propagate_errors]
     *      [disk.wipe_after_delete]
     *      [disk.quota.id]
     *      [disk.sgio]
     *      [disk.lun_storage.host]
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
     *     {@link Disk }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public Disk add(org.ovirt.engine.sdk.entities.Disk disk, String expect, String correlationId) throws
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

        return getProxy().add(url, disk,
                org.ovirt.engine.sdk.entities.Disk.class,
                Disk.class, headers);
    }

}

