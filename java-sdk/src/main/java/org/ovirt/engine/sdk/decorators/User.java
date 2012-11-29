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

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.ovirt.engine.sdk.entities.Action;
import org.ovirt.engine.sdk.entities.Response;
import org.ovirt.engine.sdk.exceptions.ServerException;
import org.ovirt.engine.sdk.utils.HttpHeaderUtils;
import org.ovirt.engine.sdk.web.HttpProxyBroker;

/**
 * User decorator.
 */
@SuppressWarnings("unused")
public class User extends
        org.ovirt.engine.sdk.entities.User {

    private HttpProxyBroker proxy;

    private UserRoles userRoles;
    private UserTags userTags;
    private UserPermissions userPermissions;


    /**
     * @param proxy HttpProxyBroker
     */
    public User(HttpProxyBroker proxy) {
        this.proxy = proxy;
    }

    /**
     * @return HttpProxyBroker
     */
    private HttpProxyBroker getProxy() {
        return proxy;
    }

    /**
     * Gets UserRoles collection decorator.
     * 
     * @return
     *     {@link UserRoles }
     *     
     */
    public synchronized UserRoles getRoles() {
        if (this.userRoles == null) {
            this.userRoles = new UserRoles(proxy, this);
        }
        return userRoles;
    }
    /**
     * Gets UserTags collection decorator.
     * 
     * @return
     *     {@link UserTags }
     *     
     */
    public synchronized UserTags getTags() {
        if (this.userTags == null) {
            this.userTags = new UserTags(proxy, this);
        }
        return userTags;
    }
    /**
     * Gets UserPermissions collection decorator.
     * 
     * @return
     *     {@link UserPermissions }
     *     
     */
    public synchronized UserPermissions getPermissions() {
        if (this.userPermissions == null) {
            this.userPermissions = new UserPermissions(proxy, this);
        }
        return userPermissions;
    }


    /**
     * Deletes object.
     *
     * @return
     *     {@link Response }
     *
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws IOException
     */
    public Response delete() throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref();
        return getProxy().delete(url, Response.class);
    }

}

