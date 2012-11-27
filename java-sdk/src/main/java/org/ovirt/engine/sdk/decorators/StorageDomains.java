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
 * StorageDomains decorator.
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
     *     List of StorageDomains
     *
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws IOException
     * @throws JAXBException
     */
    @Override
    public List<StorageDomain> list() throws ClientProtocolException,
            ServerException, IOException, JAXBException {
        String url = SLASH + getName();
        return list(url, org.ovirt.engine.sdk.entities.StorageDomains.class, StorageDomain.class);
    }

    /**
     * Fetches StorageDomain object by id.
     *
     * @return {@link StorageDomain }
     *
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws IOException
     * @throws JAXBException
     */
    @Override
    public StorageDomain get(UUID id) throws ClientProtocolException,
            ServerException, IOException, JAXBException {
        String url = SLASH + getName() + SLASH + id.toString();
        return getProxy().get(url, org.ovirt.engine.sdk.entities.StorageDomain.class, StorageDomain.class);
    }

    /**
     * Adds StorageDomain object.
     *
     * @param StorageDomain
     *
     * Overload 1: 
     *   storagedomain.host.id|name
     *   storagedomain.type
     *   storagedomain.storage.type
     *   storagedomain.format
     *   storagedomain.storage.address
     *   storagedomain.storage.logical_unit
     *   storagedomain.name
     *   storagedomain.storage.override_luns
     *
     * Overload 2: 
     *   storagedomain.host.id|name
     *   storagedomain.type
     *   storagedomain.storage.type
     *   storagedomain.format
     *   storagedomain.storage.address
     *   storagedomain.storage.path
     *   storagedomain.name
     *
     * Overload 3: 
     *   storagedomain.host.id|name
     *   storagedomain.type
     *   storagedomain.storage.type
     *   storagedomain.format
     *   storagedomain.storage.path
     *   storagedomain.name
     *
     * Overload 4: 
     *   storagedomain.host.id|name
     *   storagedomain.type
     *   storagedomain.storage.type
     *   storagedomain.format
     *   storagedomain.storage.path
     *   storagedomain.storage.vfs_type
     *   storagedomain.name
     *   storagedomain.storage.address
     *   storagedomain.storage.mount_options
     *
     * @return
     *     {@link StorageDomain }
     *
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws IOException
     * @throws JAXBException
     */
    public StorageDomain add(org.ovirt.engine.sdk.entities.StorageDomain storagedomain) throws 
            ClientProtocolException, ServerException, IOException, JAXBException {
        String url = SLASH + getName();
        return getProxy().add(url, storagedomain, org.ovirt.engine.sdk.entities.StorageDomain.class, StorageDomain.class);
    }

}

