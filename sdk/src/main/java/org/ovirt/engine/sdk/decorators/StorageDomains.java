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
 * <p>StorageDomains providing relation and functional services
 * <p>to {@link org.ovirt.engine.sdk.entities.StorageDomains }.
 */
@SuppressWarnings("unused")
public class StorageDomains extends
        CollectionDecorator<org.ovirt.engine.sdk.entities.StorageDomain,
                            org.ovirt.engine.sdk.entities.StorageDomains,
                            StorageDomain> {

    /**
     * @param proxy HttpProxyBroker
     */
    public StorageDomains(HttpProxyBroker proxy) {
        super(proxy, "storagedomains");
    }

    /**
     * Lists StorageDomain objects.
     *
     * @return
     *     List of {@link StorageDomain }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    @Override
    public List<StorageDomain> list() throws ClientProtocolException,
            ServerException, IOException {
        String url = SLASH + getName();
        return list(url, org.ovirt.engine.sdk.entities.StorageDomains.class, StorageDomain.class);
    }

    /**
     * Fetches StorageDomain object by id.
     *
     * @return {@link StorageDomain }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    @Override
    public StorageDomain get(UUID id) throws ClientProtocolException,
            ServerException, IOException {
        String url = SLASH + getName() + SLASH + id.toString();
        return getProxy().get(url, org.ovirt.engine.sdk.entities.StorageDomain.class, StorageDomain.class);
    }

    /**
     * Fetches StorageDomain object by id.
     *
     * @return {@link StorageDomain }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    @Override
    public StorageDomain getById(String id) throws ClientProtocolException,
            ServerException, IOException {
        String url = SLASH + getName() + SLASH + id;
        return getProxy().get(url, org.ovirt.engine.sdk.entities.StorageDomain.class, StorageDomain.class);
    }

    /**
     * Adds StorageDomain object.
     *
     * @param storagedomain {@link org.ovirt.engine.sdk.entities.StorageDomain}
     *    <pre>
     *    Overload 1:
     *
     *      add a new storage domain to
     *      the system using a direct lun
     *
     *      storagedomain.host.id|name
     *      storagedomain.type
     *      storagedomain.storage.type
     *      storagedomain.storage.address
     *      storagedomain.storage.logical_units.logical_unit
     *      [storagedomain.comment]
     *      [storagedomain.critical_space_action_blocker]
     *      [storagedomain.name]
     *      [storagedomain.storage.override_luns]
     *      [storagedomain.storage_format]
     *      [storagedomain.warning_low_space_indicator]
     *      [storagedomain.wipe_after_delete]
     *
     *    Overload 2:
     *
     *      Import an existing block
     *      storage domain to the system
     *      using the targets already
     *      connected to the host
     *
     *      storagedomain.host.id|name
     *      storagedomain.import
     *      storagedomain.storage.type
     *      storagedomain.type
     *      [storagedomain.comment]
     *      [storagedomain.critical_space_action_blocker]
     *      [storagedomain.storage.address]
     *      [storagedomain.warning_low_space_indicator]
     *
     *    Overload 3:
     *
     *      add a new storage domain to
     *      the system using the storage
     *      on the given host and path
     *
     *      storagedomain.host.id|name
     *      storagedomain.storage.address
     *      storagedomain.storage.path
     *      storagedomain.storage.type
     *      storagedomain.type
     *      [storagedomain.comment]
     *      [storagedomain.critical_space_action_blocker]
     *      [storagedomain.name]
     *      [storagedomain.storage_format]
     *      [storagedomain.warning_low_space_indicator]
     *      [storagedomain.wipe_after_delete]
     *
     *    Overload 4:
     *
     *      add a new storage domain to
     *      the system using the storage
     *      on the localhost at the given
     *      path
     *
     *      storagedomain.host.id|name
     *      storagedomain.storage.path
     *      storagedomain.storage.type
     *      storagedomain.type
     *      [storagedomain.name]
     *      [storagedomain.comment]
     *      [storagedomain.critical_space_action_blocker]
     *      [storagedomain.storage_format]
     *      [storagedomain.warning_low_space_indicator]
     *      [storagedomain.wipe_after_delete]
     *
     *    Overload 5:
     *
     *      add a new storage domain to
     *      the system using the gluster
     *      or posixfs storage
     *
     *      storagedomain.host.id|name
     *      storagedomain.storage.path
     *      storagedomain.storage.type
     *      storagedomain.storage.vfs_type
     *      storagedomain.type
     *      [storagedomain.comment]
     *      [storagedomain.critical_space_action_blocker]
     *      [storagedomain.name]
     *      [storagedomain.storage.address]
     *      [storagedomain.storage.mount_options]
     *      [storagedomain.storage_format]
     *      [storagedomain.warning_low_space_indicator]
     *      [storagedomain.wipe_after_delete]
     *    </pre>
     *
     *
     * @return
     *     {@link StorageDomain }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public StorageDomain add(org.ovirt.engine.sdk.entities.StorageDomain storagedomain) throws
            ClientProtocolException, ServerException, IOException {
        String url = SLASH + getName();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().add(url, storagedomain,
                org.ovirt.engine.sdk.entities.StorageDomain.class,
                StorageDomain.class, headers);
    }
    /**
     * Adds StorageDomain object.
     *
     * @param storagedomain {@link org.ovirt.engine.sdk.entities.StorageDomain}
     *    <pre>
     *    Overload 1:
     *
     *      add a new storage domain to
     *      the system using a direct lun
     *
     *      storagedomain.host.id|name
     *      storagedomain.type
     *      storagedomain.storage.type
     *      storagedomain.storage.address
     *      storagedomain.storage.logical_units.logical_unit
     *      [storagedomain.comment]
     *      [storagedomain.critical_space_action_blocker]
     *      [storagedomain.name]
     *      [storagedomain.storage.override_luns]
     *      [storagedomain.storage_format]
     *      [storagedomain.warning_low_space_indicator]
     *      [storagedomain.wipe_after_delete]
     *
     *    Overload 2:
     *
     *      Import an existing block
     *      storage domain to the system
     *      using the targets already
     *      connected to the host
     *
     *      storagedomain.host.id|name
     *      storagedomain.import
     *      storagedomain.storage.type
     *      storagedomain.type
     *      [storagedomain.comment]
     *      [storagedomain.critical_space_action_blocker]
     *      [storagedomain.storage.address]
     *      [storagedomain.warning_low_space_indicator]
     *
     *    Overload 3:
     *
     *      add a new storage domain to
     *      the system using the storage
     *      on the given host and path
     *
     *      storagedomain.host.id|name
     *      storagedomain.storage.address
     *      storagedomain.storage.path
     *      storagedomain.storage.type
     *      storagedomain.type
     *      [storagedomain.comment]
     *      [storagedomain.critical_space_action_blocker]
     *      [storagedomain.name]
     *      [storagedomain.storage_format]
     *      [storagedomain.warning_low_space_indicator]
     *      [storagedomain.wipe_after_delete]
     *
     *    Overload 4:
     *
     *      add a new storage domain to
     *      the system using the storage
     *      on the localhost at the given
     *      path
     *
     *      storagedomain.host.id|name
     *      storagedomain.storage.path
     *      storagedomain.storage.type
     *      storagedomain.type
     *      [storagedomain.name]
     *      [storagedomain.comment]
     *      [storagedomain.critical_space_action_blocker]
     *      [storagedomain.storage_format]
     *      [storagedomain.warning_low_space_indicator]
     *      [storagedomain.wipe_after_delete]
     *
     *    Overload 5:
     *
     *      add a new storage domain to
     *      the system using the gluster
     *      or posixfs storage
     *
     *      storagedomain.host.id|name
     *      storagedomain.storage.path
     *      storagedomain.storage.type
     *      storagedomain.storage.vfs_type
     *      storagedomain.type
     *      [storagedomain.comment]
     *      [storagedomain.critical_space_action_blocker]
     *      [storagedomain.name]
     *      [storagedomain.storage.address]
     *      [storagedomain.storage.mount_options]
     *      [storagedomain.storage_format]
     *      [storagedomain.warning_low_space_indicator]
     *      [storagedomain.wipe_after_delete]
     *    </pre>
     *
     * @param correlationId
     *    <pre>
     *    [any string]
     *    </pre>
     * @return
     *     {@link StorageDomain }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public StorageDomain add(org.ovirt.engine.sdk.entities.StorageDomain storagedomain, String correlationId) throws
            ClientProtocolException, ServerException, IOException {
        String url = SLASH + getName();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        if (correlationId != null) {
            headersBuilder.add("Correlation-Id", correlationId);
        }
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().add(url, storagedomain,
                org.ovirt.engine.sdk.entities.StorageDomain.class,
                StorageDomain.class, headers);
    }
    /**
     * Adds StorageDomain object.
     *
     * @param storagedomain {@link org.ovirt.engine.sdk.entities.StorageDomain}
     *    <pre>
     *    Overload 1:
     *
     *      add a new storage domain to
     *      the system using a direct lun
     *
     *      storagedomain.host.id|name
     *      storagedomain.type
     *      storagedomain.storage.type
     *      storagedomain.storage.address
     *      storagedomain.storage.logical_units.logical_unit
     *      [storagedomain.comment]
     *      [storagedomain.critical_space_action_blocker]
     *      [storagedomain.name]
     *      [storagedomain.storage.override_luns]
     *      [storagedomain.storage_format]
     *      [storagedomain.warning_low_space_indicator]
     *      [storagedomain.wipe_after_delete]
     *
     *    Overload 2:
     *
     *      Import an existing block
     *      storage domain to the system
     *      using the targets already
     *      connected to the host
     *
     *      storagedomain.host.id|name
     *      storagedomain.import
     *      storagedomain.storage.type
     *      storagedomain.type
     *      [storagedomain.comment]
     *      [storagedomain.critical_space_action_blocker]
     *      [storagedomain.storage.address]
     *      [storagedomain.warning_low_space_indicator]
     *
     *    Overload 3:
     *
     *      add a new storage domain to
     *      the system using the storage
     *      on the given host and path
     *
     *      storagedomain.host.id|name
     *      storagedomain.storage.address
     *      storagedomain.storage.path
     *      storagedomain.storage.type
     *      storagedomain.type
     *      [storagedomain.comment]
     *      [storagedomain.critical_space_action_blocker]
     *      [storagedomain.name]
     *      [storagedomain.storage_format]
     *      [storagedomain.warning_low_space_indicator]
     *      [storagedomain.wipe_after_delete]
     *
     *    Overload 4:
     *
     *      add a new storage domain to
     *      the system using the storage
     *      on the localhost at the given
     *      path
     *
     *      storagedomain.host.id|name
     *      storagedomain.storage.path
     *      storagedomain.storage.type
     *      storagedomain.type
     *      [storagedomain.name]
     *      [storagedomain.comment]
     *      [storagedomain.critical_space_action_blocker]
     *      [storagedomain.storage_format]
     *      [storagedomain.warning_low_space_indicator]
     *      [storagedomain.wipe_after_delete]
     *
     *    Overload 5:
     *
     *      add a new storage domain to
     *      the system using the gluster
     *      or posixfs storage
     *
     *      storagedomain.host.id|name
     *      storagedomain.storage.path
     *      storagedomain.storage.type
     *      storagedomain.storage.vfs_type
     *      storagedomain.type
     *      [storagedomain.comment]
     *      [storagedomain.critical_space_action_blocker]
     *      [storagedomain.name]
     *      [storagedomain.storage.address]
     *      [storagedomain.storage.mount_options]
     *      [storagedomain.storage_format]
     *      [storagedomain.warning_low_space_indicator]
     *      [storagedomain.wipe_after_delete]
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
     *     {@link StorageDomain }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public StorageDomain add(org.ovirt.engine.sdk.entities.StorageDomain storagedomain, String correlationId, String expect) throws
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

        return getProxy().add(url, storagedomain,
                org.ovirt.engine.sdk.entities.StorageDomain.class,
                StorageDomain.class, headers);
    }
    /**
     * Lists StorageDomain objects.
     *
     * @param caseSensitive
     *    <pre>
     *    [true|false]
     *    </pre>
     *
     * @return List of {@link StorageDomain }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public List<StorageDomain> list(Boolean caseSensitive) throws ClientProtocolException,
            ServerException, IOException {

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(SLASH + getName());
        if (caseSensitive != null) {
            urlBuilder.add("case_sensitive", caseSensitive, UrlParameterType.MATRIX);
        }

        String url = urlBuilder.build();

        return list(url, org.ovirt.engine.sdk.entities.StorageDomains.class,
                StorageDomain.class, headers);
    }
    /**
     * Lists StorageDomain objects.
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
     * @return List of {@link StorageDomain }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public List<StorageDomain> list(Boolean caseSensitive, Integer max) throws ClientProtocolException,
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

        return list(url, org.ovirt.engine.sdk.entities.StorageDomains.class,
                StorageDomain.class, headers);
    }
    /**
     * Lists StorageDomain objects.
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
     * @return List of {@link StorageDomain }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public List<StorageDomain> list(Boolean caseSensitive, Integer max, String query) throws ClientProtocolException,
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

        return list(url, org.ovirt.engine.sdk.entities.StorageDomains.class,
                StorageDomain.class, headers);
    }

}
