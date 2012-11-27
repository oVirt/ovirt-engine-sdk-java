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
 * Permits decorator.
 */
@SuppressWarnings("unused")
public class GroupRolePermits extends
        CollectionDecorator<org.ovirt.engine.sdk.entities.Permit,
                            org.ovirt.engine.sdk.entities.Permits,
                            GroupRolePermit> {

    private GroupRole parent;

    /**
     * @param proxy HttpProxyBroker
     * @param parent GroupRole
     */
    public GroupRolePermits(HttpProxyBroker proxy, GroupRole parent) {
        super(proxy, "permits");
        this.parent = parent;
    }

    /**
     * Lists GroupRolePermit objects.
     * 
     * @return
     *     List<GroupRolePermit>
     *
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws IOException
     * @throws JAXBException
     */
    @Override
    public List<GroupRolePermit> list() throws ClientProtocolException,
            ServerException, IOException, JAXBException {
        String url = this.parent.getHref() + SLASH + getName();
        return list(url, org.ovirt.engine.sdk.entities.Permits.class, GroupRolePermit.class);
    }

    /**
     * Fetches GroupRolePermit object by id.
     * 
     * @return 
     *     {@link GroupRolePermit }
     *
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws IOException
     * @throws JAXBException
     */
    @Override
    public GroupRolePermit get(UUID id) throws ClientProtocolException,
            ServerException, IOException, JAXBException {
        String url = this.parent.getHref() + SLASH + getName() + SLASH + id.toString();
        return getProxy().get(url, org.ovirt.engine.sdk.entities.Permit.class, GroupRolePermit.class);
    }

    /**
     * Adds Permit object.
     * 
     * @param Permit
     *
     * @return
     *     {@link GroupRolePermit }
     *
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws IOException
     * @throws JAXBException
     */
    public GroupRolePermit add(org.ovirt.engine.sdk.entities.Permit permit) throws 
            ClientProtocolException, ServerException, IOException, JAXBException {
        String url = this.parent.getHref() + SLASH + getName();
        return getProxy().add(url, permit, org.ovirt.engine.sdk.entities.Permit.class, GroupRolePermit.class);
    }

}

