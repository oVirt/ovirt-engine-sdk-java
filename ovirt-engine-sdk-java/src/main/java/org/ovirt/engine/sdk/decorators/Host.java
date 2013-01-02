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
 * <p>Host providing relation and functional services
 * <p>to {@link org.ovirt.engine.sdk.entities.Host }. 
 */
@SuppressWarnings("unused")
public class Host extends
        org.ovirt.engine.sdk.entities.Host {

    private HttpProxyBroker proxy;

    private HostHooks hostHooks;
    private HostNICs hostNICs;
    private HostTags hostTags;
    private HostPermissions hostPermissions;
    private HostStatistics hostStatistics;


    /**
     * @param proxy HttpProxyBroker
     */
    public Host(HttpProxyBroker proxy) {
        this.proxy = proxy;
    }

    /**
     * @return HttpProxyBroker
     */
    private HttpProxyBroker getProxy() {
        return proxy;
    }

    /**
     * Gets the value of the HostHooks property.
     *
     * @return
     *     {@link HostHooks }
     */
    public synchronized HostHooks getHooks() {
        if (this.hostHooks == null) {
            this.hostHooks = new HostHooks(proxy, this);
        }
        return hostHooks;
    }
    /**
     * Gets the value of the HostNICs property.
     *
     * @return
     *     {@link HostNICs }
     */
    public synchronized HostNICs getHostNics() {
        if (this.hostNICs == null) {
            this.hostNICs = new HostNICs(proxy, this);
        }
        return hostNICs;
    }
    /**
     * Gets the value of the HostTags property.
     *
     * @return
     *     {@link HostTags }
     */
    public synchronized HostTags getTags() {
        if (this.hostTags == null) {
            this.hostTags = new HostTags(proxy, this);
        }
        return hostTags;
    }
    /**
     * Gets the value of the HostPermissions property.
     *
     * @return
     *     {@link HostPermissions }
     */
    public synchronized HostPermissions getPermissions() {
        if (this.hostPermissions == null) {
            this.hostPermissions = new HostPermissions(proxy, this);
        }
        return hostPermissions;
    }
    /**
     * Gets the value of the HostStatistics property.
     *
     * @return
     *     {@link HostStatistics }
     */
    public synchronized HostStatistics getStatistics() {
        if (this.hostStatistics == null) {
            this.hostStatistics = new HostStatistics(proxy, this);
        }
        return hostStatistics;
    }


    /**
     * Performs install action.
     *
     * @param action
     *
     * <pre>
     * [action.root_password]
     * </pre>
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
    public Action install(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/install";
        return getProxy().action(url, action, Action.class, Action.class);
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
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public Action activate(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/activate";
        return getProxy().action(url, action, Action.class, Action.class);
    }
    /**
     * Updates Host object.
     *
     * @param host
     *
     * <pre>
     * [host.name]
     * [host.address]
     * [host.root_password]
     * [host.cluster.id]
     * [host.port]
     * [host.storage_manager.priority]
     * [host.power_management.type]
     * [host.power_management.enabled]
     * [host.power_management.address]
     * [host.power_management.user_name]
     * [host.power_management.password]
     * [host.power_management.options.option]
     * [host.power_management.pm_proxy]
     * </pre>
     *
     * @return
     *     {@link Host }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public Host update() throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref();
        return getProxy().update(url, this, org.ovirt.engine.sdk.entities.Host.class, Host.class);
    }
    /**
     * Performs fence action.
     *
     * @param action
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
    public Action fence(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/fence";
        return getProxy().action(url, action, Action.class, Action.class);
    }
    /**
     * Performs iscsidiscover action.
     *
     * @param action
     *
     * <pre>
     * action.iscsi.address
     * </pre>
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
    public Action iscsidiscover(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/iscsidiscover";
        return getProxy().action(url, action, Action.class, Action.class);
    }
    /**
     * Performs approve action.
     *
     * @param action
     *
     * <pre>
     * [action.cluster.id|name]
     * [action.async]
     * [action.grace_period.expiry]
     * </pre>
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
    public Action approve(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/approve";
        return getProxy().action(url, action, Action.class, Action.class);
    }
    /**
     * Performs iscsilogin action.
     *
     * @param action
     *
     * <pre>
     * action.iscsi.address
     * action.iscsi.target
     * </pre>
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
    public Action iscsilogin(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/iscsilogin";
        return getProxy().action(url, action, Action.class, Action.class);
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
     * @param action
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
    public Action deactivate(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/deactivate";
        return getProxy().action(url, action, Action.class, Action.class);
    }
    /**
     * Performs commitnetconfig action.
     *
     * @param action
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
    public Action commitnetconfig(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/commitnetconfig";
        return getProxy().action(url, action, Action.class, Action.class);
    }

}

