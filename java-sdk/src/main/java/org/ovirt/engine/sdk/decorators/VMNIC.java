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

import javax.xml.bind.JAXBException;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.ovirt.engine.sdk.entities.Action;
import org.ovirt.engine.sdk.entities.Response;
import org.ovirt.engine.sdk.exceptions.ServerException;
import org.ovirt.engine.sdk.utils.HttpHeaderUtils;
import org.ovirt.engine.sdk.web.HttpProxyBroker;

/**
 * NIC decorator.
 */
@SuppressWarnings("unused")
public class VMNIC extends
        org.ovirt.engine.sdk.entities.NIC {

    private HttpProxyBroker proxy;

    private VMNICStatistics vMNICStatistics;


    /**
     * @param proxy HttpProxyBroker
     */
    public VMNIC(HttpProxyBroker proxy) {
        this.proxy = proxy;
    }

    /**
     * @return HttpProxyBroker
     */
    private HttpProxyBroker getProxy() {
        return proxy;
    }

    /**
     * Gets the value of the VMNICStatistics property.
     * 
     * @return
     *     possible object is
     *     {@link VMNICStatistics }
     *     
     */
    public synchronized VMNICStatistics getStatistics() {
        if (this.vMNICStatistics == null) {
            this.vMNICStatistics = new VMNICStatistics(proxy, this);
        }
        return vMNICStatistics;
    }


    /**
     * Performs activate action.
     *
     * @param action
     *
     * @return
     *     {@link Action }
     *
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws IOException
     * @throws JAXBException
     */
    public Action activate(Action action) throws ClientProtocolException,
            ServerException, IOException, JAXBException {
        String url = this.getHref() + "/activate";
        return getProxy().action(url, action, Action.class, Action.class);
    }
    /**
     * Updates VMNIC object.
     *
     * @param nic
     *
     * <pre>
     * [nic.network.id|name]
     * [nic.name]
     * [nic.mac.address]
     * [nic.interface]
     * [nic.port_mirroring.networks.network]
     * </pre>
     *
     * @return
     *     possible object is
     *     {@link VMNIC }
     *
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws IOException
     * @throws JAXBException
     */
    public VMNIC update() throws ClientProtocolException,
            ServerException, IOException, JAXBException {
        String url = this.getHref();
        return getProxy().update(url, this, org.ovirt.engine.sdk.entities.NIC.class, VMNIC.class);
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
     * @throws JAXBException
     */
    public Response delete() throws ClientProtocolException,
            ServerException, IOException, JAXBException {
        String url = this.getHref();
        return getProxy().delete(url, Response.class);
    }
    /**
     * Performs deactivate action.
     *
     * @param action
     *
     * @return
     *     {@link Action }
     *
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws IOException
     * @throws JAXBException
     */
    public Action deactivate(Action action) throws ClientProtocolException,
            ServerException, IOException, JAXBException {
        String url = this.getHref() + "/deactivate";
        return getProxy().action(url, action, Action.class, Action.class);
    }

}

