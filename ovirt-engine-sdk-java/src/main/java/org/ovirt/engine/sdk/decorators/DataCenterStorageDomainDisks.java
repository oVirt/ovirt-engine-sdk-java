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
 * <p>DataCenterStorageDomainDisks providing relation and functional services
 * <p>to {@link org.ovirt.engine.sdk.entities.Disks }.
 */
@SuppressWarnings("unused")
public class DataCenterStorageDomainDisks extends
        CollectionDecorator<org.ovirt.engine.sdk.entities.Disk,
                            org.ovirt.engine.sdk.entities.Disks,
                            DataCenterStorageDomainDisk> {

    private DataCenterStorageDomain parent;

    /**
     * @param proxy HttpProxyBroker
     * @param parent DataCenterStorageDomain
     */
    public DataCenterStorageDomainDisks(HttpProxyBroker proxy, DataCenterStorageDomain parent) {
        super(proxy, "disks");
        this.parent = parent;
    }

    /**
     * Lists DataCenterStorageDomainDisk objects.
     *
     * @return
     *     List of {@link DataCenterStorageDomainDisk }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    @Override
    public List<DataCenterStorageDomainDisk> list() throws ClientProtocolException,
            ServerException, IOException {
        String url = this.parent.getHref() + SLASH + getName();
        return list(url, org.ovirt.engine.sdk.entities.Disks.class, DataCenterStorageDomainDisk.class);
    }

    /**
     * Fetches DataCenterStorageDomainDisk object by id.
     *
     * @return
     *     {@link DataCenterStorageDomainDisk }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    @Override
    public DataCenterStorageDomainDisk get(UUID id) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.parent.getHref() + SLASH + getName() + SLASH + id.toString();
        return getProxy().get(url, org.ovirt.engine.sdk.entities.Disk.class, DataCenterStorageDomainDisk.class);
    }

    /**
     * Fetches DataCenterStorageDomainDisk object by id.
     *
     * @return
     *     {@link DataCenterStorageDomainDisk }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    @Override
    public DataCenterStorageDomainDisk getById(String id) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.parent.getHref() + SLASH + getName() + SLASH + id;
        return getProxy().get(url, org.ovirt.engine.sdk.entities.Disk.class, DataCenterStorageDomainDisk.class);
    }

    /**
     * Lists DataCenterStorageDomainDisk objects.
     *
     * @param query
     *    <pre>
     *    [query]
     *    </pre>
     * @param caseSensitive
     *    <pre>
     *    [true|false]
     *    </pre>
     * @param max
     *    <pre>
     *    [max results]
     *    </pre>
     * @param unregistered
     *    <pre>
     *    [true|false]
     *    </pre>
     *
     *
     * @return List of {@link DataCenterStorageDomainDisk }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public List<DataCenterStorageDomainDisk> list(String query, Boolean caseSensitive, Integer max, Boolean unregistered) throws ClientProtocolException,
            ServerException, IOException {

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(this.parent.getHref() + SLASH + getName());
        if (query != null) {
            urlBuilder.add("search", query, UrlParameterType.QUERY);
        }
        if (caseSensitive != null) {
            urlBuilder.add("case_sensitive", caseSensitive, UrlParameterType.MATRIX);
        }
        if (max != null) {
            urlBuilder.add("max", max, UrlParameterType.MATRIX);
        }
        if (unregistered != null) {
            urlBuilder.add("unregistered", unregistered, UrlParameterType.MATRIX);
        }
        String url = urlBuilder.build();

        return list(url, org.ovirt.engine.sdk.entities.Disks.class,
                DataCenterStorageDomainDisk.class, headers);
    }
    /**
     * Adds Disk object.
     *
     * @param disk {@link org.ovirt.engine.sdk.entities.Disk}
     *    <pre>
     *    Overload 1:
     *
     *      add a new disk with the
     *      specified size to the storage
     *      domain in the data center,
     *      allocating space from the
     *      storage domain
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
     *
     *    Overload 2:
     *
     *      add a new lun disk to the
     *      storage domain in the data
     *      center
     *
     *      disk.interface
     *      disk.format
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
     *    </pre>
     *
     * @return
     *     {@link DataCenterStorageDomainDisk }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public DataCenterStorageDomainDisk add(org.ovirt.engine.sdk.entities.Disk disk) throws
            ClientProtocolException, ServerException, IOException {
        String url = this.parent.getHref() + SLASH + getName();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().add(url, disk,
                org.ovirt.engine.sdk.entities.Disk.class,
                DataCenterStorageDomainDisk.class, headers);
    }
    /**
     * Adds Disk object.
     *
     * @param disk {@link org.ovirt.engine.sdk.entities.Disk}
     *    <pre>
     *    Overload 1:
     *
     *      add a new disk with the
     *      specified size to the storage
     *      domain in the data center,
     *      allocating space from the
     *      storage domain
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
     *
     *    Overload 2:
     *
     *      add a new lun disk to the
     *      storage domain in the data
     *      center
     *
     *      disk.interface
     *      disk.format
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
     *    </pre>
     *
     * @param unregistered
     *    <pre>
     *    [true|false]
     *    </pre>
     *
     * @return
     *     {@link DataCenterStorageDomainDisk }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public DataCenterStorageDomainDisk add(org.ovirt.engine.sdk.entities.Disk disk, Boolean unregistered) throws
            ClientProtocolException, ServerException, IOException {
        String url = this.parent.getHref() + SLASH + getName();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        if (unregistered != null) {
            urlBuilder.add("unregistered", unregistered, UrlParameterType.MATRIX);
        }
        url = urlBuilder.build();

        return getProxy().add(url, disk,
                org.ovirt.engine.sdk.entities.Disk.class,
                DataCenterStorageDomainDisk.class, headers);
    }
    /**
     * Adds Disk object.
     *
     * @param disk {@link org.ovirt.engine.sdk.entities.Disk}
     *    <pre>
     *    Overload 1:
     *
     *      add a new disk with the
     *      specified size to the storage
     *      domain in the data center,
     *      allocating space from the
     *      storage domain
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
     *
     *    Overload 2:
     *
     *      add a new lun disk to the
     *      storage domain in the data
     *      center
     *
     *      disk.interface
     *      disk.format
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
     *    </pre>
     *
     * @param expect
     *    <pre>
     *    [201-created]
     *    </pre>
     *
     * @param unregistered
     *    <pre>
     *    [true|false]
     *    </pre>
     *
     * @return
     *     {@link DataCenterStorageDomainDisk }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public DataCenterStorageDomainDisk add(org.ovirt.engine.sdk.entities.Disk disk, Boolean unregistered, String expect) throws
            ClientProtocolException, ServerException, IOException {
        String url = this.parent.getHref() + SLASH + getName();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        if (expect != null) {
            headersBuilder.add("Expect", expect);
        }
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        if (unregistered != null) {
            urlBuilder.add("unregistered", unregistered, UrlParameterType.MATRIX);
        }
        url = urlBuilder.build();

        return getProxy().add(url, disk,
                org.ovirt.engine.sdk.entities.Disk.class,
                DataCenterStorageDomainDisk.class, headers);
    }
    /**
     * Adds Disk object.
     *
     * @param disk {@link org.ovirt.engine.sdk.entities.Disk}
     *    <pre>
     *    Overload 1:
     *
     *      add a new disk with the
     *      specified size to the storage
     *      domain in the data center,
     *      allocating space from the
     *      storage domain
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
     *
     *    Overload 2:
     *
     *      add a new lun disk to the
     *      storage domain in the data
     *      center
     *
     *      disk.interface
     *      disk.format
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
     * @param unregistered
     *    <pre>
     *    [true|false]
     *    </pre>
     *
     * @return
     *     {@link DataCenterStorageDomainDisk }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public DataCenterStorageDomainDisk add(org.ovirt.engine.sdk.entities.Disk disk, Boolean unregistered, String expect, String correlationId) throws
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
        if (unregistered != null) {
            urlBuilder.add("unregistered", unregistered, UrlParameterType.MATRIX);
        }
        url = urlBuilder.build();

        return getProxy().add(url, disk,
                org.ovirt.engine.sdk.entities.Disk.class,
                DataCenterStorageDomainDisk.class, headers);
    }

}

