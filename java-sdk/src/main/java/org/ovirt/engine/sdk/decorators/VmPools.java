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
 * VmPools decorator.
 */
@SuppressWarnings("unused")
public class VmPools extends
        CollectionDecorator<org.ovirt.engine.sdk.entities.VmPool, 
                            org.ovirt.engine.sdk.entities.VmPools, 
                            VmPool> {

    /**
     * @param proxy HttpProxyBroker
     */
    public VmPools(HttpProxyBroker proxy) {
        super(proxy, "vmpools");
    }

    /**
     * Lists VmPool objects.
     *
     * @return
     *     List of VmPools
     *
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws IOException
     * @throws JAXBException
     */
    @Override
    public List<VmPool> list() throws ClientProtocolException,
            ServerException, IOException, JAXBException {
        String url = SLASH + getName();
        return list(url, org.ovirt.engine.sdk.entities.VmPools.class, VmPool.class);
    }

    /**
     * Fetches VmPool object by id.
     *
     * @return {@link VmPool }
     *
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws IOException
     * @throws JAXBException
     */
    @Override
    public VmPool get(UUID id) throws ClientProtocolException,
            ServerException, IOException, JAXBException {
        String url = SLASH + getName() + SLASH + id.toString();
        return getProxy().get(url, org.ovirt.engine.sdk.entities.VmPool.class, VmPool.class);
    }

    /**
     * Adds VmPool object.
     *
     * @param VmPool
     *
     * vmpool.cluster.id|name
     * vmpool.template.id|name
     * vmpool.name
     * vmpool.size
     *
     * @return
     *     {@link VmPool }
     *
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws IOException
     * @throws JAXBException
     */
    public VmPool add(org.ovirt.engine.sdk.entities.VmPool vmpool) throws 
            ClientProtocolException, ServerException, IOException, JAXBException {
        String url = SLASH + getName();
        return getProxy().add(url, vmpool, org.ovirt.engine.sdk.entities.VmPool.class, VmPool.class);
    }

}

