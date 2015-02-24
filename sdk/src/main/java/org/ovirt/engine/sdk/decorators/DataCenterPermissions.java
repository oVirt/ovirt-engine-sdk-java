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
 * <p>DataCenterPermissions providing relation and functional services
 * <p>to {@link org.ovirt.engine.sdk.entities.Permissions }.
 */
@SuppressWarnings("unused")
public class DataCenterPermissions extends
        CollectionDecorator<org.ovirt.engine.sdk.entities.Permission,
                            org.ovirt.engine.sdk.entities.Permissions,
                            DataCenterPermission> {

    private DataCenter parent;

    /**
     * @param proxy HttpProxyBroker
     * @param parent DataCenter
     */
    public DataCenterPermissions(HttpProxyBroker proxy, DataCenter parent) {
        super(proxy, "permissions");
        this.parent = parent;
    }

    /**
     * Lists DataCenterPermission objects.
     *
     * @return
     *     List of {@link DataCenterPermission }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    @Override
    public List<DataCenterPermission> list() throws ClientProtocolException,
            ServerException, IOException {
        String url = this.parent.getHref() + SLASH + getName();
        return list(url, org.ovirt.engine.sdk.entities.Permissions.class, DataCenterPermission.class);
    }

    /**
     * Fetches DataCenterPermission object by id.
     *
     * @return
     *     {@link DataCenterPermission }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    @Override
    public DataCenterPermission get(UUID id) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.parent.getHref() + SLASH + getName() + SLASH + id.toString();
        return getProxy().get(url, org.ovirt.engine.sdk.entities.Permission.class, DataCenterPermission.class);
    }

    /**
     * Fetches DataCenterPermission object by id.
     *
     * @return
     *     {@link DataCenterPermission }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    @Override
    public DataCenterPermission getById(String id) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.parent.getHref() + SLASH + getName() + SLASH + id;
        return getProxy().get(url, org.ovirt.engine.sdk.entities.Permission.class, DataCenterPermission.class);
    }

    /**
     * Adds Permission object.
     *
     * @param permission {@link org.ovirt.engine.sdk.entities.Permission}
     *    <pre>
     *    Overload 1:
     *
     *      add a new user level
     *      permission on the data center
     *
     *      permission.user.id
     *      permission.role.id
     *
     *    Overload 2:
     *
     *      add a new role permission on
     *      the data center
     *
     *      permission.role.id
     *      permission.group.id
     *    </pre>
     *
     * @return
     *     {@link DataCenterPermission }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public DataCenterPermission add(org.ovirt.engine.sdk.entities.Permission permission) throws
            ClientProtocolException, ServerException, IOException {
        String url = this.parent.getHref() + SLASH + getName();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().add(url, permission,
                org.ovirt.engine.sdk.entities.Permission.class,
                DataCenterPermission.class, headers);
    }
    /**
     * Adds Permission object.
     *
     * @param permission {@link org.ovirt.engine.sdk.entities.Permission}
     *    <pre>
     *    Overload 1:
     *
     *      add a new user level
     *      permission on the data center
     *
     *      permission.user.id
     *      permission.role.id
     *
     *    Overload 2:
     *
     *      add a new role permission on
     *      the data center
     *
     *      permission.role.id
     *      permission.group.id
     *    </pre>
     *
     * @param expect
     *    <pre>
     *    [201-created]
     *    </pre>
     *
     * @return
     *     {@link DataCenterPermission }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public DataCenterPermission add(org.ovirt.engine.sdk.entities.Permission permission, String expect) throws
            ClientProtocolException, ServerException, IOException {
        String url = this.parent.getHref() + SLASH + getName();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        if (expect != null) {
            headersBuilder.add("Expect", expect);
        }
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().add(url, permission,
                org.ovirt.engine.sdk.entities.Permission.class,
                DataCenterPermission.class, headers);
    }
    /**
     * Adds Permission object.
     *
     * @param permission {@link org.ovirt.engine.sdk.entities.Permission}
     *    <pre>
     *    Overload 1:
     *
     *      add a new user level
     *      permission on the data center
     *
     *      permission.user.id
     *      permission.role.id
     *
     *    Overload 2:
     *
     *      add a new role permission on
     *      the data center
     *
     *      permission.role.id
     *      permission.group.id
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
     *     {@link DataCenterPermission }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public DataCenterPermission add(org.ovirt.engine.sdk.entities.Permission permission, String expect, String correlationId) throws
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

        return getProxy().add(url, permission,
                org.ovirt.engine.sdk.entities.Permission.class,
                DataCenterPermission.class, headers);
    }

}

