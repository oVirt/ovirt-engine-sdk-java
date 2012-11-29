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
 * HostNIC decorator.
 */
@SuppressWarnings("unused")
public class HostNIC extends
        org.ovirt.engine.sdk.entities.HostNIC {

    private HttpProxyBroker proxy;

    private HostNICStatistics hostNICStatistics;


    /**
     * @param proxy HttpProxyBroker
     */
    public HostNIC(HttpProxyBroker proxy) {
        this.proxy = proxy;
    }

    /**
     * @return HttpProxyBroker
     */
    private HttpProxyBroker getProxy() {
        return proxy;
    }

    /**
     * Gets HostNICStatistics collection decorator.
     * 
     * @return
     *     {@link HostNICStatistics }
     *     
     */
    public synchronized HostNICStatistics getStatistics() {
        if (this.hostNICStatistics == null) {
            this.hostNICStatistics = new HostNICStatistics(proxy, this);
        }
        return hostNICStatistics;
    }


    /**
     * Updates HostNIC object.
     *
     * @param hostnic
     *
     * <pre>
     * [hostnic.bonding.slaves.host_nic]
     * [hostnic.network.id|name]
     * [hostnic.name]
     * [hostnic.bonding.options.option]
     * [hostnic.ip.gateway]
     * [hostnic.boot_protocol]
     * [hostnic.mac]
     * [hostnic.ip.address]
     * [hostnic.ip.netmask]
     * [hostnic.ip.mtu]
     * </pre>
     *
     * @return
     *     {@link HostNIC }
     *
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws IOException
     */
    public HostNIC update() throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref();
        return getProxy().update(url, this, org.ovirt.engine.sdk.entities.HostNIC.class, HostNIC.class);
    }
    /**
     * Performs detach action.
     *
     * @param action
     *
     * <pre>
     * [action.async]
     * </pre>
     *
     * @return
     *     {@link Action }
     *
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws IOException
     */
    public Action detach(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/detach";
        return getProxy().action(url, action, Action.class, Action.class);
    }
    /**
     * Performs attach action.
     *
     * @param action
     *
     * <pre>
     * action.network.id|name
     * [action.async]
     * [action.grace_period.expiry]
     * </pre>
     *
     * @return
     *     {@link Action }
     *
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws IOException
     */
    public Action attach(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/attach";
        return getProxy().action(url, action, Action.class, Action.class);
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

