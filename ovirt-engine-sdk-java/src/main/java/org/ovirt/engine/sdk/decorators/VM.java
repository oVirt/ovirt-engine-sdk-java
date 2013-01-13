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
 * <p>VM providing relation and functional services
 * <p>to {@link org.ovirt.engine.sdk.entities.VM }. 
 */
@SuppressWarnings("unused")
public class VM extends
        org.ovirt.engine.sdk.entities.VM {

    private HttpProxyBroker proxy;

    private VMPermissions vMPermissions;
    private VMReportedDevices vMReportedDevices;
    private VMTags vMTags;
    private VMSnapshots vMSnapshots;
    private VMStatistics vMStatistics;
    private VMDisks vMDisks;
    private VMNICs vMNICs;
    private VMCdRoms vMCdRoms;


    /**
     * @param proxy HttpProxyBroker
     */
    public VM(HttpProxyBroker proxy) {
        this.proxy = proxy;
    }

    /**
     * @return HttpProxyBroker
     */
    private HttpProxyBroker getProxy() {
        return proxy;
    }

    /**
     * Gets the value of the VMPermissions property.
     *
     * @return
     *     {@link VMPermissions }
     */
    public synchronized VMPermissions getPermissions() {
        if (this.vMPermissions == null) {
            this.vMPermissions = new VMPermissions(proxy, this);
        }
        return vMPermissions;
    }
    /**
     * Gets the value of the VMReportedDevices property.
     *
     * @return
     *     {@link VMReportedDevices }
     */
    public synchronized VMReportedDevices getReportedDevices() {
        if (this.vMReportedDevices == null) {
            this.vMReportedDevices = new VMReportedDevices(proxy, this);
        }
        return vMReportedDevices;
    }
    /**
     * Gets the value of the VMTags property.
     *
     * @return
     *     {@link VMTags }
     */
    public synchronized VMTags getTags() {
        if (this.vMTags == null) {
            this.vMTags = new VMTags(proxy, this);
        }
        return vMTags;
    }
    /**
     * Gets the value of the VMSnapshots property.
     *
     * @return
     *     {@link VMSnapshots }
     */
    public synchronized VMSnapshots getSnapshots() {
        if (this.vMSnapshots == null) {
            this.vMSnapshots = new VMSnapshots(proxy, this);
        }
        return vMSnapshots;
    }
    /**
     * Gets the value of the VMStatistics property.
     *
     * @return
     *     {@link VMStatistics }
     */
    public synchronized VMStatistics getStatistics() {
        if (this.vMStatistics == null) {
            this.vMStatistics = new VMStatistics(proxy, this);
        }
        return vMStatistics;
    }
    /**
     * Gets the value of the VMDisks property.
     *
     * @return
     *     {@link VMDisks }
     */
    public synchronized VMDisks getDisks() {
        if (this.vMDisks == null) {
            this.vMDisks = new VMDisks(proxy, this);
        }
        return vMDisks;
    }
    /**
     * Gets the value of the VMNICs property.
     *
     * @return
     *     {@link VMNICs }
     */
    public synchronized VMNICs getNics() {
        if (this.vMNICs == null) {
            this.vMNICs = new VMNICs(proxy, this);
        }
        return vMNICs;
    }
    /**
     * Gets the value of the VMCdRoms property.
     *
     * @return
     *     {@link VMCdRoms }
     */
    public synchronized VMCdRoms getCdRoms() {
        if (this.vMCdRoms == null) {
            this.vMCdRoms = new VMCdRoms(proxy, this);
        }
        return vMCdRoms;
    }


    /**
     * Performs suspend action.
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
    public Action suspend(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/suspend";
        return getProxy().action(url, action, Action.class, Action.class);
    }
    /**
     * Updates VM object.
     *
     * @param vm
     *
     * <pre>
     * [vm.name]
     * [vm.cluster.id|name]
     * [vm.timezone]
     * [vm.os.boot]
     * [vm.custom_properties.custom_property]
     * [vm.os.type]
     * [vm.usb.enabled]
     * [vm.usb.type]
     * [vm.type]
     * [vm.os.initRd]
     * [vm.display.monitors]
     * [vm.display.type]
     * [vm.display.allow_override]
     * [vm.display.smartcard_enabled]
     * [vm.os.cmdline]
     * [vm.cpu.topology.cores]
     * [vm.memory]
     * [vm.high_availability.priority]
     * [vm.high_availability.enabled]
     * [vm.domain.name]
     * [vm.description]
     * [vm.stateless]
     * [vm.delete_protected]
     * [vm.cpu.topology.sockets]
     * [vm.placement_policy.affinity]
     * [vm.placement_policy.host.id|name]
     * [vm.origin]
     * [vm.os.kernel]
     * [vm.payloads.payload]
     * [vm.cpu.cpu_tune.vcpu_pin]
     * </pre>
     *
     * @return
     *     {@link VM }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public VM update() throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref();
        return getProxy().update(url, this, org.ovirt.engine.sdk.entities.VM.class, VM.class);
    }
    /**
     * Performs stop action.
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
    public Action stop(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/stop";
        return getProxy().action(url, action, Action.class, Action.class);
    }
    /**
     * Performs cancelmigration action.
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
    public Action cancelmigration(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/cancelmigration";
        return getProxy().action(url, action, Action.class, Action.class);
    }
    /**
     * Performs export action.
     *
     * @param action
     *
     * <pre>
     * [action.async]
     * [action.exclusive]
     * [action.discard_snapshots]
     * [action.storage_domain.id|name]
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
    public Action export(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/export";
        return getProxy().action(url, action, Action.class, Action.class);
    }
    /**
     * Performs detach action.
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
    public Action detach(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/detach";
        return getProxy().action(url, action, Action.class, Action.class);
    }
    /**
     * Performs ticket action.
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
    public Action ticket(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/ticket";
        return getProxy().action(url, action, Action.class, Action.class);
    }
    /**
     * Performs start action.
     *
     * @param action
     *
     * <pre>
     * [action.vm.os.initRd]
     * [action.vm.domain.name]
     * [action.vm.placement_policy.host.id|name]
     * [action.vm.placement_policy.affinity]
     * [action.async]
     * [action.vm.os.kernel]
     * [action.grace_period.expiry]
     * [action.vm.display.type]
     * [action.vm.stateless]
     * [action.vm.os.cmdline]
     * [action.vm.domain.user.username]
     * [action.pause]
     * [action.vm.os.boot]
     * [action.vm.domain.user.password]
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
    public Action start(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/start";
        return getProxy().action(url, action, Action.class, Action.class);
    }
    /**
     * Performs migrate action.
     *
     * @param action
     *
     * <pre>
     * [action.host.id|name]
     * [action.async]
     * [action.force]
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
    public Action migrate(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/migrate";
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
     * Performs move action.
     *
     * @param action
     *
     * <pre>
     * action.storage_domain.id|name
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
    public Action move(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/move";
        return getProxy().action(url, action, Action.class, Action.class);
    }
    /**
     * Performs shutdown action.
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
    public Action shutdown(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/shutdown";
        return getProxy().action(url, action, Action.class, Action.class);
    }

}

