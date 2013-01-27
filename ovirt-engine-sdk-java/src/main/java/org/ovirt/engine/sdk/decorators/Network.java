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
import org.ovirt.engine.sdk.utils.HttpHeaderBuilder;
import org.ovirt.engine.sdk.utils.HttpHeaderUtils;
import org.ovirt.engine.sdk.utils.UrlBuilder;
import org.ovirt.engine.sdk.web.HttpProxyBroker;

/**
 * <p>Network providing relation and functional services
 * <p>to {@link org.ovirt.engine.sdk.entities.Network }. 
 */
@SuppressWarnings("unused")
public class Network extends
        org.ovirt.engine.sdk.entities.Network {

    private HttpProxyBroker proxy;

    private NetworkPermissions networkPermissions;


    /**
     * @param proxy HttpProxyBroker
     */
    public Network(HttpProxyBroker proxy) {
        this.proxy = proxy;
    }

    /**
     * @return HttpProxyBroker
     */
    private HttpProxyBroker getProxy() {
        return proxy;
    }

    /**
     * Gets the value of the NetworkPermissions property.
     *
     * @return
     *     {@link NetworkPermissions }
     */
    public synchronized NetworkPermissions getPermissions() {
        if (this.networkPermissions == null) {
            this.networkPermissions = new NetworkPermissions(proxy, this);
        }
        return networkPermissions;
    }


    /**
     * Updates Network object.
     *
     * @param network
     *
     * <pre>
     * [network.name]
     * [network.description]
     * [network.vlan.id]
     * [network.ip.address]
     * [network.ip.gateway]
     * [network.ip.netmask]
     * [network.display]
     * [network.stp]
     * [network.mtu]
     * </pre>
     *
     * @return
     *     {@link Network }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public Network update() throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref();
        return getProxy().update(url, this, org.ovirt.engine.sdk.entities.Network.class, Network.class);
    }
    /**
     * Deletes object.
     *
     * @return
     *     {@link Response }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public Response delete() throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref();
        return getProxy().delete(url, Response.class);
    }

}

