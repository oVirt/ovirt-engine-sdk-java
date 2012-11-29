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
 * Disks decorator
 * providing {@link org.ovirt.engine.sdk.entities.Disks } decorating services.
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
     * @throws ServerException
     * @throws IOException
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
     * @throws ServerException
     * @throws IOException
     */
    @Override
    public Disk get(UUID id) throws ClientProtocolException,
            ServerException, IOException {
        String url = SLASH + getName() + SLASH + id.toString();
        return getProxy().get(url, org.ovirt.engine.sdk.entities.Disk.class, Disk.class);
    }

    /**
     * Adds Disk object.
     *
     * @param disk
     *
     * <pre>
     * Overload 1: 
     *    provisioned_size
     *    disk.interface
     *    disk.format
     *    [disk.alias]
     *    [disk.name]
     *    [disk.size]
     *    [disk.sparse]
     *    [disk.bootable]
     *    [disk.shareable]
     *    [disk.propagate_errors]
     *    [disk.wipe_after_delete]
     *    [disk.storage_domains.storage_domain]
     *
     * Overload 2: 
     *    disk.interface
     *    disk.format
     *    disk.lun_storage.type
     *    disk.lun_storage.logical_unit
     *    [disk.alias]
     *    [disk.sparse]
     *    [disk.bootable]
     *    [disk.shareable]
     *    [disk.propagate_errors]
     *    [disk.wipe_after_delete]
     *    [disk.storage_domains.storage_domain]
     * </pre>
     *
     * @return
     *     {@link Disk }
     *
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws IOException
     */
    public Disk add(org.ovirt.engine.sdk.entities.Disk disk) throws 
            ClientProtocolException, ServerException, IOException {
        String url = SLASH + getName();
        return getProxy().add(url, disk, org.ovirt.engine.sdk.entities.Disk.class, Disk.class);
    }

}

