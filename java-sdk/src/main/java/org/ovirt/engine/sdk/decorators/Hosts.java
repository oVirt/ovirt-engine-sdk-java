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
 * Hosts decorator
 * providing {@link org.ovirt.engine.sdk.entities.Hosts } decorating services.
 */
@SuppressWarnings("unused")
public class Hosts extends
        CollectionDecorator<org.ovirt.engine.sdk.entities.Host, 
                            org.ovirt.engine.sdk.entities.Hosts, 
                            Host> {

    /**
     * @param proxy HttpProxyBroker
     */
    public Hosts(HttpProxyBroker proxy) {
        super(proxy, "hosts");
    }

    /**
     * Lists Host objects.
     *
     * @return
     *     List of {@link Host }
     *
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws IOException
     */
    @Override
    public List<Host> list() throws ClientProtocolException,
            ServerException, IOException {
        String url = SLASH + getName();
        return list(url, org.ovirt.engine.sdk.entities.Hosts.class, Host.class);
    }

    /**
     * Fetches Host object by id.
     *
     * @return {@link Host }
     *
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws IOException
     */
    @Override
    public Host get(UUID id) throws ClientProtocolException,
            ServerException, IOException {
        String url = SLASH + getName() + SLASH + id.toString();
        return getProxy().get(url, org.ovirt.engine.sdk.entities.Host.class, Host.class);
    }

    /**
     * Adds Host object.
     *
     * @param host
     *
     * <pre>
     * host.name
     * host.address
     * host.root_password
     * host.cluster.id
     * [host.port]
     * [host.storage_manager.priority]
     * [host.power_management.type]
     * [host.power_management.enabled]
     * [host.power_management.address]
     * [host.power_management.user_name]
     * [host.power_management.password]
     * [host.power_management.options.option]
     * [host.reboot_after_installation]
     * </pre>
     *
     * @return
     *     {@link Host }
     *
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws IOException
     */
    public Host add(org.ovirt.engine.sdk.entities.Host host) throws 
            ClientProtocolException, ServerException, IOException {
        String url = SLASH + getName();
        return getProxy().add(url, host, org.ovirt.engine.sdk.entities.Host.class, Host.class);
    }

}

