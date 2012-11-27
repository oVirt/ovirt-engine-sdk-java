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

import javax.xml.bind.JAXBException;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.ovirt.engine.sdk.common.CollectionDecorator;
import org.ovirt.engine.sdk.exceptions.ServerException;
import org.ovirt.engine.sdk.utils.CollectionUtils;
import org.ovirt.engine.sdk.utils.HttpHeaderUtils;
import org.ovirt.engine.sdk.utils.UrlHelper;
import org.ovirt.engine.sdk.web.HttpProxyBroker;
import org.ovirt.engine.sdk.web.UrlParameterType;
import org.ovirt.engine.sdk.entities.Action;

/**
 * Permissions decorator.
 */
@SuppressWarnings("unused")
public class StorageDomainPermissions extends
        CollectionDecorator<org.ovirt.engine.sdk.entities.Permission,
                            org.ovirt.engine.sdk.entities.Permissions,
                            StorageDomainPermission> {

    private StorageDomain parent;

    /**
     * @param proxy HttpProxyBroker
     * @param parent StorageDomain
     */
    public StorageDomainPermissions(HttpProxyBroker proxy, StorageDomain parent) {
        super(proxy, "permissions");
        this.parent = parent;
    }

    /**
     * Lists StorageDomainPermission objects.
     * 
     * @return
     *     List of StorageDomainPermissions
     *
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws IOException
     * @throws JAXBException
     */
    @Override
    public List<StorageDomainPermission> list() throws ClientProtocolException,
            ServerException, IOException, JAXBException {
        String url = this.parent.getHref() + SLASH + getName();
        return list(url, org.ovirt.engine.sdk.entities.Permissions.class, StorageDomainPermission.class);
    }

    /**
     * Fetches StorageDomainPermission object by id.
     * 
     * @return 
     *     {@link StorageDomainPermission }
     *
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws IOException
     * @throws JAXBException
     */
    @Override
    public StorageDomainPermission get(UUID id) throws ClientProtocolException,
            ServerException, IOException, JAXBException {
        String url = this.parent.getHref() + SLASH + getName() + SLASH + id.toString();
        return getProxy().get(url, org.ovirt.engine.sdk.entities.Permission.class, StorageDomainPermission.class);
    }

    /**
     * Adds Permission object.
     *
     * @param Permission
     *
     * Overload 1: 
     *   permission.user.id
     *   permission.role.id
     *
     * Overload 2: 
     *   permission.role.id
     *   permission.group.id
     *
     * @return
     *     {@link StorageDomainPermission }
     *
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws IOException
     * @throws JAXBException
     */
    public StorageDomainPermission add(org.ovirt.engine.sdk.entities.Permission permission) throws 
            ClientProtocolException, ServerException, IOException, JAXBException {
        String url = this.parent.getHref() + SLASH + getName();
        return getProxy().add(url, permission, org.ovirt.engine.sdk.entities.Permission.class, StorageDomainPermission.class);
    }

}

