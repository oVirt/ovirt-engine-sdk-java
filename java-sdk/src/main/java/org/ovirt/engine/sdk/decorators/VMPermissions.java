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
import org.ovirt.engine.sdk.utils.HttpHeaderUtils;
import org.ovirt.engine.sdk.utils.UrlHelper;
import org.ovirt.engine.sdk.web.HttpProxyBroker;
import org.ovirt.engine.sdk.web.UrlParameterType;
import org.ovirt.engine.sdk.entities.Action;

/**
 * Permissions decorator.
 */
@SuppressWarnings("unused")
public class VMPermissions extends
        CollectionDecorator<org.ovirt.engine.sdk.entities.Permission,
                            org.ovirt.engine.sdk.entities.Permissions,
                            VMPermission> {

    private VM parent;

    /**
     * @param proxy HttpProxyBroker
     * @param parent VM
     */
    public VMPermissions(HttpProxyBroker proxy, VM parent) {
        super(proxy, "permissions");
        this.parent = parent;
    }

    /**
     * Lists VMPermission objects.
     * 
     * @return
     *     List of VMPermissions
     *
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws IOException
     */
    @Override
    public List<VMPermission> list() throws ClientProtocolException,
            ServerException, IOException {
        String url = this.parent.getHref() + SLASH + getName();
        return list(url, org.ovirt.engine.sdk.entities.Permissions.class, VMPermission.class);
    }

    /**
     * Fetches VMPermission object by id.
     * 
     * @return 
     *     {@link VMPermission }
     *
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws IOException
     */
    @Override
    public VMPermission get(UUID id) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.parent.getHref() + SLASH + getName() + SLASH + id.toString();
        return getProxy().get(url, org.ovirt.engine.sdk.entities.Permission.class, VMPermission.class);
    }

    /**
     * Adds Permission object.
     *
     * @param permission
     *
     * <pre>
     * Overload 1: 
     *    permission.user.id
     *    permission.role.id
     *
     * Overload 2: 
     *    permission.role.id
     *    permission.group.id
     * </pre>
     *
     * @return
     *     {@link VMPermission }
     *
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws IOException
     */
    public VMPermission add(org.ovirt.engine.sdk.entities.Permission permission) throws 
            ClientProtocolException, ServerException, IOException {
        String url = this.parent.getHref() + SLASH + getName();
        return getProxy().add(url, permission, org.ovirt.engine.sdk.entities.Permission.class, VMPermission.class);
    }

}

