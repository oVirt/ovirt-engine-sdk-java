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
 * <p>VMDisk providing relation and functional services
 * <p>to {@link org.ovirt.engine.sdk.entities.Disk }. 
 */
@SuppressWarnings("unused")
public class VMDisk extends
        org.ovirt.engine.sdk.entities.Disk {

    private HttpProxyBroker proxy;

    private VMDiskPermissions vMDiskPermissions;
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
     * Gets the value of the VMDiskPermissions property.
     *
     * @return
     *     {@link VMDiskPermissions }
     */
    public synchronized VMDiskPermissions getPermissions() {
        if (this.vMDiskPermissions == null) {
            this.vMDiskPermissions = new VMDiskPermissions(proxy, this);
        }
        return vMDiskPermissions;
    }
    /**
     * Gets the value of the VMDiskStatistics property.
     *
     * @return
     *     {@link VMDiskStatistics }
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
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     * @return
     *     {@link Action }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public Action activate(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/activate";

        List<Header> headers = new HttpHeaderBuilder()
                .build();

        url = new UrlBuilder(url)
                .build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs activate action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     * @param correlationId
     *    <pre>
     *    [any string]
     *    </pre>
     *
     * @return
     *     {@link Action }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public Action activate(Action action, String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/activate";

        List<Header> headers = new HttpHeaderBuilder()
                .add("Correlation-Id", correlationId)
                .build();

        url = new UrlBuilder(url)
                .build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Updates VMDisk object.
     *
     * @param disk {@link org.ovirt.engine.sdk.entities.Disk}
     *    <pre>
     *    [size]
     *    [provisioned_size]
     *    [disk.interface]
     *    [disk.format]
     *    [disk.sparse]
     *    [disk.bootable]
     *    [disk.shareable]
     *    [disk.propagate_errors]
     *    [disk.wipe_after_delete]
     *    </pre>
     *
     * @return
     *     {@link VMDisk }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public VMDisk update() throws ClientProtocolException,
            ServerException, IOException {
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
    /**
     * Performs deactivate action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     * @return
     *     {@link Action }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public Action deactivate(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/deactivate";

        List<Header> headers = new HttpHeaderBuilder()
                .build();

        url = new UrlBuilder(url)
                .build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs deactivate action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     * @param correlationId
     *    <pre>
     *    [any string]
     *    </pre>
     *
     * @return
     *     {@link Action }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public Action deactivate(Action action, String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/deactivate";

        List<Header> headers = new HttpHeaderBuilder()
                .add("Correlation-Id", correlationId)
                .build();

        url = new UrlBuilder(url)
                .build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs move action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    storagedomain.id|name
     *    [action.async]
     *    [action.grace_period.expiry]
     *    </pre>
     *
     * @return
     *     {@link Action }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public Action move(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/move";

        List<Header> headers = new HttpHeaderBuilder()
                .build();

        url = new UrlBuilder(url)
                .build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs move action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    storagedomain.id|name
     *    [action.async]
     *    [action.grace_period.expiry]
     *    </pre>
     *
     * @param correlationId
     *    <pre>
     *    [any string]
     *    </pre>
     *
     * @return
     *     {@link Action }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public Action move(Action action, String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/move";

        List<Header> headers = new HttpHeaderBuilder()
                .add("Correlation-Id", correlationId)
                .build();

        url = new UrlBuilder(url)
                .build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }

}

