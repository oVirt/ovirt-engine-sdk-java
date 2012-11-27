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
 * Disk decorator.
 */
@SuppressWarnings("unused")
public class VMDisk extends
        org.ovirt.engine.sdk.entities.Disk {

    private HttpProxyBroker proxy;

    private VMDiskStatistics vMDiskStatistics;


    /**
     * @param proxy HttpProxyBroker
     */
    public VMDisk(HttpProxyBroker proxy) {
        this.proxy = proxy;
    }

    /**
     * @return HttpProxyBroker
     */
    private HttpProxyBroker getProxy() {
        return proxy;
    }

    /**
     * Gets the value of the VMDiskStatistics property.
     * 
     * @return
     *     possible object is
     *     {@link VMDiskStatistics }
     *     
     */
    public synchronized VMDiskStatistics getStatistics() {
        if (this.vMDiskStatistics == null) {
            this.vMDiskStatistics = new VMDiskStatistics(proxy, this);
        }
        return vMDiskStatistics;
    }


    /**
     * Performs activate action.
     *
     * @param Action
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
     * Updates VMDisk object.
     *
     * @param Disk
     *
     * size
     * provisioned_size
     * disk.interface
     * disk.format
     * disk.sparse
     * disk.bootable
     * disk.shareable
     * disk.propagate_errors
     * disk.wipe_after_delete
     *
     * @return
     *     possible object is
     *     {@link VMDisk }
     *
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws IOException
     * @throws JAXBException
     */
    public VMDisk update() throws ClientProtocolException,
            ServerException, IOException, JAXBException {
        String url = this.getHref();
        return getProxy().update(url, this, org.ovirt.engine.sdk.entities.Disk.class, VMDisk.class);
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
     * @param Action
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

