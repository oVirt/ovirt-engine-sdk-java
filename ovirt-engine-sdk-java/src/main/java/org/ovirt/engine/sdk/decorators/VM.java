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
import org.ovirt.engine.sdk.web.UrlParameterType;

/**
 * <p>VM providing relation and functional services
 * <p>to {@link org.ovirt.engine.sdk.entities.VM }.
 */
@SuppressWarnings("unused")
public class VM extends
        org.ovirt.engine.sdk.entities.VM {

    private HttpProxyBroker proxy;
    private final Object LOCK = new Object();

    private volatile VMPermissions vMPermissions;
    private volatile VMReportedDevices vMReportedDevices;
    private volatile VMVirtualNumaNodes vMVirtualNumaNodes;
    private volatile VMTags vMTags;
    private volatile VMSnapshots vMSnapshots;
    private volatile VMStatistics vMStatistics;
    private volatile VMApplications vMApplications;
    private volatile VMWatchDogs vMWatchDogs;
    private volatile VMDisks vMDisks;
    private volatile VMNICs vMNICs;
    private volatile VMSessions vMSessions;
    private volatile VMCdRoms vMCdRoms;


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
    public VMPermissions getPermissions() {
        if (this.vMPermissions == null) {
            synchronized (this.LOCK) {
                if (this.vMPermissions == null) {
                    this.vMPermissions = new VMPermissions(proxy, this);
                }
            }
        }
        return vMPermissions;
    }
    /**
     * Gets the value of the VMReportedDevices property.
     *
     * @return
     *     {@link VMReportedDevices }
     */
    public VMReportedDevices getReportedDevices() {
        if (this.vMReportedDevices == null) {
            synchronized (this.LOCK) {
                if (this.vMReportedDevices == null) {
                    this.vMReportedDevices = new VMReportedDevices(proxy, this);
                }
            }
        }
        return vMReportedDevices;
    }
    /**
     * Gets the value of the VMVirtualNumaNodes property.
     *
     * @return
     *     {@link VMVirtualNumaNodes }
     */
    public VMVirtualNumaNodes getVirtualNumaNodes() {
        if (this.vMVirtualNumaNodes == null) {
            synchronized (this.LOCK) {
                if (this.vMVirtualNumaNodes == null) {
                    this.vMVirtualNumaNodes = new VMVirtualNumaNodes(proxy, this);
                }
            }
        }
        return vMVirtualNumaNodes;
    }
    /**
     * Gets the value of the VMTags property.
     *
     * @return
     *     {@link VMTags }
     */
    public VMTags getTags() {
        if (this.vMTags == null) {
            synchronized (this.LOCK) {
                if (this.vMTags == null) {
                    this.vMTags = new VMTags(proxy, this);
                }
            }
        }
        return vMTags;
    }
    /**
     * Gets the value of the VMSnapshots property.
     *
     * @return
     *     {@link VMSnapshots }
     */
    public VMSnapshots getSnapshots() {
        if (this.vMSnapshots == null) {
            synchronized (this.LOCK) {
                if (this.vMSnapshots == null) {
                    this.vMSnapshots = new VMSnapshots(proxy, this);
                }
            }
        }
        return vMSnapshots;
    }
    /**
     * Gets the value of the VMStatistics property.
     *
     * @return
     *     {@link VMStatistics }
     */
    public VMStatistics getStatistics() {
        if (this.vMStatistics == null) {
            synchronized (this.LOCK) {
                if (this.vMStatistics == null) {
                    this.vMStatistics = new VMStatistics(proxy, this);
                }
            }
        }
        return vMStatistics;
    }
    /**
     * Gets the value of the VMApplications property.
     *
     * @return
     *     {@link VMApplications }
     */
    public VMApplications getApplications() {
        if (this.vMApplications == null) {
            synchronized (this.LOCK) {
                if (this.vMApplications == null) {
                    this.vMApplications = new VMApplications(proxy, this);
                }
            }
        }
        return vMApplications;
    }
    /**
     * Gets the value of the VMWatchDogs property.
     *
     * @return
     *     {@link VMWatchDogs }
     */
    public VMWatchDogs getWatchDogs() {
        if (this.vMWatchDogs == null) {
            synchronized (this.LOCK) {
                if (this.vMWatchDogs == null) {
                    this.vMWatchDogs = new VMWatchDogs(proxy, this);
                }
            }
        }
        return vMWatchDogs;
    }
    /**
     * Gets the value of the VMDisks property.
     *
     * @return
     *     {@link VMDisks }
     */
    public VMDisks getDisks() {
        if (this.vMDisks == null) {
            synchronized (this.LOCK) {
                if (this.vMDisks == null) {
                    this.vMDisks = new VMDisks(proxy, this);
                }
            }
        }
        return vMDisks;
    }
    /**
     * Gets the value of the VMNICs property.
     *
     * @return
     *     {@link VMNICs }
     */
    public VMNICs getNics() {
        if (this.vMNICs == null) {
            synchronized (this.LOCK) {
                if (this.vMNICs == null) {
                    this.vMNICs = new VMNICs(proxy, this);
                }
            }
        }
        return vMNICs;
    }
    /**
     * Gets the value of the VMSessions property.
     *
     * @return
     *     {@link VMSessions }
     */
    public VMSessions getSessions() {
        if (this.vMSessions == null) {
            synchronized (this.LOCK) {
                if (this.vMSessions == null) {
                    this.vMSessions = new VMSessions(proxy, this);
                }
            }
        }
        return vMSessions;
    }
    /**
     * Gets the value of the VMCdRoms property.
     *
     * @return
     *     {@link VMCdRoms }
     */
    public VMCdRoms getCdRoms() {
        if (this.vMCdRoms == null) {
            synchronized (this.LOCK) {
                if (this.vMCdRoms == null) {
                    this.vMCdRoms = new VMCdRoms(proxy, this);
                }
            }
        }
        return vMCdRoms;
    }


    /**
     * Performs suspend action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
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
    public Action suspend(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/suspend";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs suspend action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
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
    public Action suspend(Action action, String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/suspend";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        if (correlationId != null) {
            headersBuilder.add("Correlation-Id", correlationId);
        }
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Updates VM object.
     *
     * @param vm {@link org.ovirt.engine.sdk.entities.VM}
     *    <pre>
     *    [vm.instance_type.id|name]
     *    [vm.name]
     *    [vm.cluster.id|name]
     *    [vm.timezone]
     *    [vm.os.boot]
     *    [vm.custom_properties.custom_property]
     *    [vm.os.type]
     *    [vm.usb.enabled]
     *    [vm.usb.type]
     *    [vm.type]
     *    [vm.os.initRd]
     *    [vm.display.monitors]
     *    [vm.display.single_qxl_pci]
     *    [vm.display.type]
     *    [vm.display.allow_override]
     *    [vm.display.smartcard_enabled]
     *    [vm.display.file_transfer_enabled]
     *    [vm.display.copy_paste_enabled]
     *    [vm.display.keyboard_layout]
     *    [vm.os.cmdline]
     *    [vm.cpu.mode]
     *    [vm.cpu.architecture]
     *    [vm.cpu.topology.cores]
     *    [vm.cpu_shares]
     *    [vm.memory]
     *    [vm.memory_policy.guaranteed]
     *    [vm.memory_policy.ballooning]
     *    [vm.high_availability.priority]
     *    [vm.high_availability.enabled]
     *    [vm.domain.name]
     *    [vm.description]
     *    [vm.comment]
     *    [vm.stateless]
     *    [vm.delete_protected]
     *    [vm.sso.methods.method]
     *    [vm.rng_device.rate.bytes]
     *    [vm.rng_device.rate.period]
     *    [vm.rng_device.source]
     *    [vm.console.enabled]
     *    [vm.cpu.topology.sockets]
     *    [vm.placement_policy.affinity]
     *    [vm.placement_policy.host.id|name]
     *    [vm.origin]
     *    [vm.os.kernel]
     *    [vm.tunnel_migration]
     *    [vm.migration_downtime]
     *    [vm.virtio_scsi.enabled]
     *    [vm.soundcard_enabled]
     *    [vm.use_latest_template_version]
     *    [vm.payloads.payload]
     *    [vm.cpu.cpu_tune.vcpu_pin]
     *    [vm.serial_number.policy]
     *    [vm.serial_number.value]
     *    [vm.bios.boot_menu.enabled]
     *    [vm.numa_tune_mode]
     *    [vm.cpu_profile.id]
     *    </pre>
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

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().update(
                url,
                this,
                org.ovirt.engine.sdk.entities.VM.class,
                VM.class,
                headers);
    }
    /**
     * Updates VM object.
     *
     * @param vm {@link org.ovirt.engine.sdk.entities.VM}
     *    <pre>
     *    [vm.instance_type.id|name]
     *    [vm.name]
     *    [vm.cluster.id|name]
     *    [vm.timezone]
     *    [vm.os.boot]
     *    [vm.custom_properties.custom_property]
     *    [vm.os.type]
     *    [vm.usb.enabled]
     *    [vm.usb.type]
     *    [vm.type]
     *    [vm.os.initRd]
     *    [vm.display.monitors]
     *    [vm.display.single_qxl_pci]
     *    [vm.display.type]
     *    [vm.display.allow_override]
     *    [vm.display.smartcard_enabled]
     *    [vm.display.file_transfer_enabled]
     *    [vm.display.copy_paste_enabled]
     *    [vm.display.keyboard_layout]
     *    [vm.os.cmdline]
     *    [vm.cpu.mode]
     *    [vm.cpu.architecture]
     *    [vm.cpu.topology.cores]
     *    [vm.cpu_shares]
     *    [vm.memory]
     *    [vm.memory_policy.guaranteed]
     *    [vm.memory_policy.ballooning]
     *    [vm.high_availability.priority]
     *    [vm.high_availability.enabled]
     *    [vm.domain.name]
     *    [vm.description]
     *    [vm.comment]
     *    [vm.stateless]
     *    [vm.delete_protected]
     *    [vm.sso.methods.method]
     *    [vm.rng_device.rate.bytes]
     *    [vm.rng_device.rate.period]
     *    [vm.rng_device.source]
     *    [vm.console.enabled]
     *    [vm.cpu.topology.sockets]
     *    [vm.placement_policy.affinity]
     *    [vm.placement_policy.host.id|name]
     *    [vm.origin]
     *    [vm.os.kernel]
     *    [vm.tunnel_migration]
     *    [vm.migration_downtime]
     *    [vm.virtio_scsi.enabled]
     *    [vm.soundcard_enabled]
     *    [vm.use_latest_template_version]
     *    [vm.payloads.payload]
     *    [vm.cpu.cpu_tune.vcpu_pin]
     *    [vm.serial_number.policy]
     *    [vm.serial_number.value]
     *    [vm.bios.boot_menu.enabled]
     *    [vm.numa_tune_mode]
     *    [vm.cpu_profile.id]
     *    </pre>
     *
     * @param correlationId
     *    <pre>
     *    [any string]
     *    </pre>
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
    public VM update(String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        if (correlationId != null) {
            headersBuilder.add("Correlation-Id", correlationId);
        }
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().update(
                url,
                this,
                org.ovirt.engine.sdk.entities.VM.class,
                VM.class,
                headers);
    }
    /**
     * Performs commit_snapshot action.
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
    public Action commit_snapshot(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/commit_snapshot";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs commit_snapshot action.
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
    public Action commit_snapshot(Action action, String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/commit_snapshot";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        if (correlationId != null) {
            headersBuilder.add("Correlation-Id", correlationId);
        }
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs stop action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
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
    public Action stop(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/stop";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs stop action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
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
    public Action stop(Action action, String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/stop";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        if (correlationId != null) {
            headersBuilder.add("Correlation-Id", correlationId);
        }
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs cancelmigration action.
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
    public Action cancelmigration(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/cancelmigration";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs clone action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    action.vm.name
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
    public Action clone(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/clone";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs clone action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    action.vm.name
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
    public Action clone(Action action, String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/clone";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        if (correlationId != null) {
            headersBuilder.add("Correlation-Id", correlationId);
        }
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs exportVm action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    [action.async]
     *    [action.exclusive]
     *    [action.discard_snapshots]
     *    [action.storage_domain.id|name]
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
    public Action exportVm(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/export";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs exportVm action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    [action.async]
     *    [action.exclusive]
     *    [action.discard_snapshots]
     *    [action.storage_domain.id|name]
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
    public Action exportVm(Action action, String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/export";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        if (correlationId != null) {
            headersBuilder.add("Correlation-Id", correlationId);
        }
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs detach action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
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
    public Action detach(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/detach";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs detach action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
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
    public Action detach(Action action, String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/detach";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        if (correlationId != null) {
            headersBuilder.add("Correlation-Id", correlationId);
        }
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs maintenance action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    action.maintenance_enabled
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
    public Action maintenance(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/maintenance";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs maintenance action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    action.maintenance_enabled
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
    public Action maintenance(Action action, String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/maintenance";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        if (correlationId != null) {
            headersBuilder.add("Correlation-Id", correlationId);
        }
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs migrate action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    [action.host.id|name]
     *    [action.async]
     *    [action.force]
     *    [action.grace_period.expiry]
     *    [action.cluster.id]
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
    public Action migrate(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/migrate";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs migrate action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    [action.host.id|name]
     *    [action.async]
     *    [action.force]
     *    [action.grace_period.expiry]
     *    [action.cluster.id]
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
    public Action migrate(Action action, String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/migrate";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        if (correlationId != null) {
            headersBuilder.add("Correlation-Id", correlationId);
        }
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs preview_snapshot action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    action.snapshot.id
     *    [action.restore_memory]
     *    [action.disks.disk]
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
    public Action preview_snapshot(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/preview_snapshot";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs preview_snapshot action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    action.snapshot.id
     *    [action.restore_memory]
     *    [action.disks.disk]
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
    public Action preview_snapshot(Action action, String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/preview_snapshot";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        if (correlationId != null) {
            headersBuilder.add("Correlation-Id", correlationId);
        }
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs undo_snapshot action.
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
    public Action undo_snapshot(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/undo_snapshot";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs undo_snapshot action.
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
    public Action undo_snapshot(Action action, String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/undo_snapshot";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        if (correlationId != null) {
            headersBuilder.add("Correlation-Id", correlationId);
        }
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs ticket action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    [action.ticket.value]
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
    public Action ticket(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/ticket";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs ticket action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    [action.ticket.value]
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
    public Action ticket(Action action, String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/ticket";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        if (correlationId != null) {
            headersBuilder.add("Correlation-Id", correlationId);
        }
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs start action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    [action.vm.os.initRd]
     *    [action.vm.domain.name]
     *    [action.vm.placement_policy.host.id|name]
     *    [action.vm.placement_policy.affinity]
     *    [action.async]
     *    [action.vm.os.kernel]
     *    [action.grace_period.expiry]
     *    [action.vm.display.type]
     *    [action.vm.stateless]
     *    [action.vm.os.cmdline]
     *    [action.vm.domain.user.username]
     *    [action.pause]
     *    [action.vm.os.boot]
     *    [action.vm.domain.user.password]
     *    [action.vm.initialization.cloud_init.host.address]
     *    [action.vm.initialization.cloud_init.network_configuration.nics.nic]
     *    [action.vm.initialization.cloud_init.network_configuration.dns.servers.host]
     *    [action.vm.initialization.cloud_init.network_configuration.dns.search_domains.host]
     *    [action.vm.initialization.cloud_init.authorized_keys.authorized_key]
     *    [action.vm.initialization.cloud_init.regenerate_ssh_keys]
     *    [action.vm.initialization.cloud_init.timezone]
     *    [action.vm.initialization.cloud_init.users.user]
     *    [action.vm.initialization.cloud_init.payload_files.payload_file]
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
    public Action start(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/start";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs start action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    [action.vm.os.initRd]
     *    [action.vm.domain.name]
     *    [action.vm.placement_policy.host.id|name]
     *    [action.vm.placement_policy.affinity]
     *    [action.async]
     *    [action.vm.os.kernel]
     *    [action.grace_period.expiry]
     *    [action.vm.display.type]
     *    [action.vm.stateless]
     *    [action.vm.os.cmdline]
     *    [action.vm.domain.user.username]
     *    [action.pause]
     *    [action.vm.os.boot]
     *    [action.vm.domain.user.password]
     *    [action.vm.initialization.cloud_init.host.address]
     *    [action.vm.initialization.cloud_init.network_configuration.nics.nic]
     *    [action.vm.initialization.cloud_init.network_configuration.dns.servers.host]
     *    [action.vm.initialization.cloud_init.network_configuration.dns.search_domains.host]
     *    [action.vm.initialization.cloud_init.authorized_keys.authorized_key]
     *    [action.vm.initialization.cloud_init.regenerate_ssh_keys]
     *    [action.vm.initialization.cloud_init.timezone]
     *    [action.vm.initialization.cloud_init.users.user]
     *    [action.vm.initialization.cloud_init.payload_files.payload_file]
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
    public Action start(Action action, String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/start";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        if (correlationId != null) {
            headersBuilder.add("Correlation-Id", correlationId);
        }
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs reboot action.
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
    public Action reboot(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/reboot";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs reboot action.
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
    public Action reboot(Action action, String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/reboot";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        if (correlationId != null) {
            headersBuilder.add("Correlation-Id", correlationId);
        }
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
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

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().delete(url, Response.class, headers);
    }
    /**
     * Deletes object.
     *
     * @param async
     *    <pre>
     *    [true|false]
     *    </pre>
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
    public Response delete(Boolean async) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        if (async != null) {
            urlBuilder.add("async", async, UrlParameterType.MATRIX);
        }
        url = urlBuilder.build();

        return getProxy().delete(url, Response.class, headers);
    }
    /**
     * Deletes object.
     *
     * @param correlationId
     *    <pre>
     *    [any string]
     *    </pre>
     *
     * @param async
     *    <pre>
     *    [true|false]
     *    </pre>
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
    public Response delete(Boolean async, String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        if (correlationId != null) {
            headersBuilder.add("Correlation-Id", correlationId);
        }
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        if (async != null) {
            urlBuilder.add("async", async, UrlParameterType.MATRIX);
        }
        url = urlBuilder.build();

        return getProxy().delete(url, Response.class, headers);
    }
    /**
     * Deletes object.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    [action.force]
     *    [action.vm.disks.detach_only]
     *    [action.async]
     *    [action.grace_period.expiry]
     *    </pre>
     *
     * @param async
     *    <pre>
     *    [true|false]
     *    </pre>
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
    public Response delete(org.ovirt.engine.sdk.entities.Action action, Boolean async) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        if (async != null) {
            urlBuilder.add("async", async, UrlParameterType.MATRIX);
        }
        url = urlBuilder.build();

        return getProxy().delete(url, action,
                org.ovirt.engine.sdk.entities.Action.class, Response.class, headers);
    }
    /**
     * Deletes object.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    [action.force]
     *    [action.vm.disks.detach_only]
     *    [action.async]
     *    [action.grace_period.expiry]
     *    </pre>
     *
     * @param correlationId
     *    <pre>
     *    [any string]
     *    </pre>
     *
     * @param async
     *    <pre>
     *    [true|false]
     *    </pre>
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
    public Response delete(org.ovirt.engine.sdk.entities.Action action, Boolean async, String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        if (correlationId != null) {
            headersBuilder.add("Correlation-Id", correlationId);
        }
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        if (async != null) {
            urlBuilder.add("async", async, UrlParameterType.MATRIX);
        }
        url = urlBuilder.build();

        return getProxy().delete(url, action,
                org.ovirt.engine.sdk.entities.Action.class, Response.class, headers);
    }
    /**
     * Performs logon action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
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
    public Action logon(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/logon";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs logon action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
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
    public Action logon(Action action, String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/logon";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        if (correlationId != null) {
            headersBuilder.add("Correlation-Id", correlationId);
        }
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs move action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    action.storage_domain.id|name
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

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs move action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    action.storage_domain.id|name
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

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        if (correlationId != null) {
            headersBuilder.add("Correlation-Id", correlationId);
        }
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs shutdown action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
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
    public Action shutdown(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/shutdown";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs shutdown action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
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
    public Action shutdown(Action action, String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/shutdown";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        if (correlationId != null) {
            headersBuilder.add("Correlation-Id", correlationId);
        }
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }

}

