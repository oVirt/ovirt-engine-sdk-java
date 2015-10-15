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
import org.ovirt.engine.sdk.utils.HttpHeaderBuilder;
import org.ovirt.engine.sdk.utils.HttpHeaderUtils;
import org.ovirt.engine.sdk.utils.UrlBuilder;
import org.ovirt.engine.sdk.utils.UrlBuilder;
import org.ovirt.engine.sdk.utils.UrlHelper;
import org.ovirt.engine.sdk.web.HttpProxyBroker;
import org.ovirt.engine.sdk.web.UrlParameterType;
import org.ovirt.engine.sdk.entities.Action;

/**
 * <p>Vms providing relation and functional services
 * <p>to {@link org.ovirt.engine.sdk.entities.Vms }.
 */
@SuppressWarnings("unused")
public class Vms extends
        CollectionDecorator<org.ovirt.engine.sdk.entities.Vm,
                            org.ovirt.engine.sdk.entities.Vms,
                            Vm> {

    /**
     * @param proxy HttpProxyBroker
     */
    public Vms(HttpProxyBroker proxy) {
        super(proxy, "vms");
    }

    /**
     * Lists Vm objects.
     *
     * @return
     *     List of {@link Vm }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    @Override
    public List<Vm> list() throws ClientProtocolException,
            ServerException, IOException {
        String url = SLASH + getName();
        return list(url, org.ovirt.engine.sdk.entities.Vms.class, Vm.class);
    }

    /**
     * Fetches Vm object by id.
     *
     * @return {@link Vm }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    @Override
    public Vm get(UUID id) throws ClientProtocolException,
            ServerException, IOException {
        String url = SLASH + getName() + SLASH + id.toString();
        return getProxy().get(url, org.ovirt.engine.sdk.entities.Vm.class, Vm.class);
    }

    /**
     * Fetches Vm object by id.
     *
     * @return {@link Vm }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    @Override
    public Vm getById(String id) throws ClientProtocolException,
            ServerException, IOException {
        String url = SLASH + getName() + SLASH + id;
        return getProxy().get(url, org.ovirt.engine.sdk.entities.Vm.class, Vm.class);
    }

    /**
     * Adds Vm object.
     *
     * @param vm {@link org.ovirt.engine.sdk.entities.Vm}
     *    <pre>
     *    Overload 1:
     *
     *      add a virtual machine to the
     *      system from scratch
     *
     *      vm.name
     *      vm.template.id|name
     *      vm.cluster.id|name
     *      [vm.instance_type.id|name]
     *      [vm.quota.id]
     *      [vm.time_zone.name]
     *      [vm.os.boot]
     *      [vm.custom_properties.custom_property]
     *      [vm.os.type]
     *      [vm.usb.enabled]
     *      [vm.usb.type]
     *      [vm.type]
     *      [vm.os.initRd]
     *      [vm.display.monitors]
     *      [vm.display.single_qxl_pci]
     *      [vm.display.type]
     *      [vm.display.allow_override]
     *      [vm.display.smartcard_enabled]
     *      [vm.display.file_transfer_enabled]
     *      [vm.display.copy_paste_enabled]
     *      [vm.display.keyboard_layout]
     *      [vm.display.disconnect_action]
     *      [vm.os.cmdline]
     *      [vm.cpu.topology.cores]
     *      [vm.cpu.architecture]
     *      [vm.memory]
     *      [vm.io.threads]
     *      [vm.memory_policy.guaranteed]
     *      [vm.memory_policy.ballooning]
     *      [vm.high_availability.priority]
     *      [vm.high_availability.enabled]
     *      [vm.domain.name]
     *      [vm.description]
     *      [vm.comment]
     *      [vm.stateless]
     *      [vm.delete_protected]
     *      [vm.sso.methods.method]
     *      [vm.rng_device.rate.bytes]
     *      [vm.rng_device.rate.period]
     *      [vm.rng_device.source]
     *      [vm.console.enabled]
     *      [vm.cpu.mode]
     *      [vm.cpu.topology.sockets]
     *      [vm.cpu_shares]
     *      [vm.placement_policy.affinity]
     *      [vm.placement_policy.hosts.host]
     *      [vm.origin]
     *      [vm.os.kernel]
     *      [vm.tunnel_migration]
     *      [vm.migration_downtime]
     *      [vm.virtio_scsi.enabled]
     *      [vm.soundcard_enabled]
     *      [vm.custom_emulated_machine]
     *      [vm.custom_cpu_model]
     *      [vm.payloads.payload]
     *      [vm.initialization.configuration.type]
     *      [vm.initialization.configuration.data]
     *      [vm.cpu.cpu_tune.vcpu_pins.vcpu_pin]
     *      [vm.use_latest_template_version]
     *      [vm.serial_number.policy]
     *      [vm.serial_number.value]
     *      [vm.bios.boot_menu.enabled]
     *      [vm.numa_tune_mode]
     *      [vm.start_paused]
     *      [vm.cpu_profile.id]
     *      [vm.migration.auto_converge]
     *      [vm.migration.compressed]
     *      [vm.small_icon.id]
     *      [vm.large_icon.id]
     *      [vm.large_icon.media_type]
     *      [vm.large_icon.data]
     *
     *    Overload 2:
     *
     *      add a virtual machine to the
     *      system by cloning from a
     *      snapshot
     *
     *      vm.name
     *      vm.template.id|name
     *      vm.cluster.id|name
     *      vm.snapshots.snapshot
     *      [vm.quota.id]
     *      [vm.time_zone.name]
     *      [vm.os.boot]
     *      [vm.custom_properties.custom_property]
     *      [vm.os.type]
     *      [vm.usb.enabled]
     *      [vm.usb.type]
     *      [vm.type]
     *      [vm.os.initRd]
     *      [vm.display.monitors]
     *      [vm.display.single_qxl_pci]
     *      [vm.display.type]
     *      [vm.display.allow_override]
     *      [vm.display.smartcard_enabled]
     *      [vm.display.file_transfer_enabled]
     *      [vm.display.copy_paste_enabled]
     *      [vm.display.keyboard_layout]
     *      [vm.display.disconnect_action]
     *      [vm.os.cmdline]
     *      [vm.cpu.topology.cores]
     *      [vm.cpu_shares]
     *      [vm.cpu.architecture]
     *      [vm.memory]
     *      [vm.memory_policy.guaranteed]
     *      [vm.memory_policy.ballooning]
     *      [vm.high_availability.priority]
     *      [vm.high_availability.enabled]
     *      [vm.domain.name]
     *      [vm.description]
     *      [vm.comment]
     *      [vm.stateless]
     *      [vm.delete_protected]
     *      [vm.sso.methods.method]
     *      [vm.rng_device.rate.bytes]
     *      [vm.rng_device.rate.period]
     *      [vm.rng_device.source]
     *      [vm.console.enabled]
     *      [vm.cpu.topology.sockets]
     *      [vm.placement_policy.affinity]
     *      [vm.placement_policy.hosts.host]
     *      [vm.origin]
     *      [vm.os.kernel]
     *      [vm.tunnel_migration]
     *      [vm.migration_downtime]
     *      [vm.virtio_scsi.enabled]
     *      [vm.soundcard_enabled]
     *      [vm.custom_emulated_machine]
     *      [vm.custom_cpu_model]
     *      [vm.payloads.payload]
     *      [vm.cpu.cpu_tune.vcpu_pins.vcpu_pin]
     *      [vm.serial_number.policy]
     *      [vm.serial_number.value]
     *      [vm.bios.boot_menu.enabled]
     *      [vm.numa_tune_mode]
     *      [vm.start_paused]
     *      [vm.cpu_profile.id]
     *      [vm.migration.auto_converge]
     *      [vm.migration.compressed]
     *      [vm.small_icon.id]
     *      [vm.large_icon.id]
     *      [vm.large_icon.media_type]
     *      [vm.large_icon.data]
     *
     *    Overload 3:
     *
     *      add a virtual machine to the
     *      system from a configuration -
     *      requires the configuration
     *      type and the configuration
     *      data
     *
     *      vm.initialization.configuration.type
     *      vm.initialization.configuration.data
     *      [vm.name]
     *      [vm.quota.id]
     *      [vm.time_zone.name]
     *      [vm.os.boot]
     *      [vm.custom_properties.custom_property]
     *      [vm.os.type]
     *      [vm.usb.enabled]
     *      [vm.usb.type]
     *      [vm.type]
     *      [vm.os.initRd]
     *      [vm.display.monitors]
     *      [vm.display.type]
     *      [vm.display.allow_override]
     *      [vm.display.smartcard_enabled]
     *      [vm.display.file_transfer_enabled]
     *      [vm.display.copy_paste_enabled]
     *      [vm.display.keyboard_layout]
     *      [vm.display.disconnect_action]
     *      [vm.os.cmdline]
     *      [vm.cpu.topology.cores]
     *      [vm.memory]
     *      [vm.memory_policy.guaranteed]
     *      [vm.memory_policy.ballooning]
     *      [vm.high_availability.priority]
     *      [vm.high_availability.enabled]
     *      [vm.domain.name]
     *      [vm.description]
     *      [vm.comment]
     *      [vm.stateless]
     *      [vm.delete_protected]
     *      [vm.sso.methods.method]
     *      [vm.rng_device.rate.bytes]
     *      [vm.rng_device.rate.period]
     *      [vm.rng_device.source]
     *      [vm.cpu.mode]
     *      [vm.cpu.topology.sockets]
     *      [vm.placement_policy.affinity]
     *      [vm.placement_policy.hosts.host]
     *      [vm.origin]
     *      [vm.os.kernel]
     *      [vm.disks.clone]
     *      [vm.tunnel_migration]
     *      [vm.migration_downtime]
     *      [vm.virtio_scsi.enabled]
     *      [vm.payloads.payload]
     *      [vm.initialization.configuration.type]
     *      [vm.initialization.configuration.data]
     *      [vm.initialization.regenerate_ids]
     *      [vm.cpu.cpu_tune.vcpu_pins.vcpu_pin]
     *      [vm.serial_number.policy]
     *      [vm.serial_number.value]
     *      [vm.bios.boot_menu.enabled]
     *      [vm.numa_tune_mode]
     *      [vm.start_paused]
     *      [vm.cpu_profile.id]
     *      [vm.migration.auto_converge]
     *      [vm.migration.compressed]
     *      [vm.small_icon.id]
     *      [vm.large_icon.id]
     *      [vm.large_icon.media_type]
     *      [vm.large_icon.data]
     *    </pre>
     *
     *
     * @return
     *     {@link Vm }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public Vm add(org.ovirt.engine.sdk.entities.Vm vm) throws
            ClientProtocolException, ServerException, IOException {
        String url = SLASH + getName();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().add(url, vm,
                org.ovirt.engine.sdk.entities.Vm.class,
                Vm.class, headers);
    }
    /**
     * Adds Vm object.
     *
     * @param vm {@link org.ovirt.engine.sdk.entities.Vm}
     *    <pre>
     *    Overload 1:
     *
     *      add a virtual machine to the
     *      system from scratch
     *
     *      vm.name
     *      vm.template.id|name
     *      vm.cluster.id|name
     *      [vm.instance_type.id|name]
     *      [vm.quota.id]
     *      [vm.time_zone.name]
     *      [vm.os.boot]
     *      [vm.custom_properties.custom_property]
     *      [vm.os.type]
     *      [vm.usb.enabled]
     *      [vm.usb.type]
     *      [vm.type]
     *      [vm.os.initRd]
     *      [vm.display.monitors]
     *      [vm.display.single_qxl_pci]
     *      [vm.display.type]
     *      [vm.display.allow_override]
     *      [vm.display.smartcard_enabled]
     *      [vm.display.file_transfer_enabled]
     *      [vm.display.copy_paste_enabled]
     *      [vm.display.keyboard_layout]
     *      [vm.display.disconnect_action]
     *      [vm.os.cmdline]
     *      [vm.cpu.topology.cores]
     *      [vm.cpu.architecture]
     *      [vm.memory]
     *      [vm.io.threads]
     *      [vm.memory_policy.guaranteed]
     *      [vm.memory_policy.ballooning]
     *      [vm.high_availability.priority]
     *      [vm.high_availability.enabled]
     *      [vm.domain.name]
     *      [vm.description]
     *      [vm.comment]
     *      [vm.stateless]
     *      [vm.delete_protected]
     *      [vm.sso.methods.method]
     *      [vm.rng_device.rate.bytes]
     *      [vm.rng_device.rate.period]
     *      [vm.rng_device.source]
     *      [vm.console.enabled]
     *      [vm.cpu.mode]
     *      [vm.cpu.topology.sockets]
     *      [vm.cpu_shares]
     *      [vm.placement_policy.affinity]
     *      [vm.placement_policy.hosts.host]
     *      [vm.origin]
     *      [vm.os.kernel]
     *      [vm.tunnel_migration]
     *      [vm.migration_downtime]
     *      [vm.virtio_scsi.enabled]
     *      [vm.soundcard_enabled]
     *      [vm.custom_emulated_machine]
     *      [vm.custom_cpu_model]
     *      [vm.payloads.payload]
     *      [vm.initialization.configuration.type]
     *      [vm.initialization.configuration.data]
     *      [vm.cpu.cpu_tune.vcpu_pins.vcpu_pin]
     *      [vm.use_latest_template_version]
     *      [vm.serial_number.policy]
     *      [vm.serial_number.value]
     *      [vm.bios.boot_menu.enabled]
     *      [vm.numa_tune_mode]
     *      [vm.start_paused]
     *      [vm.cpu_profile.id]
     *      [vm.migration.auto_converge]
     *      [vm.migration.compressed]
     *      [vm.small_icon.id]
     *      [vm.large_icon.id]
     *      [vm.large_icon.media_type]
     *      [vm.large_icon.data]
     *
     *    Overload 2:
     *
     *      add a virtual machine to the
     *      system by cloning from a
     *      snapshot
     *
     *      vm.name
     *      vm.template.id|name
     *      vm.cluster.id|name
     *      vm.snapshots.snapshot
     *      [vm.quota.id]
     *      [vm.time_zone.name]
     *      [vm.os.boot]
     *      [vm.custom_properties.custom_property]
     *      [vm.os.type]
     *      [vm.usb.enabled]
     *      [vm.usb.type]
     *      [vm.type]
     *      [vm.os.initRd]
     *      [vm.display.monitors]
     *      [vm.display.single_qxl_pci]
     *      [vm.display.type]
     *      [vm.display.allow_override]
     *      [vm.display.smartcard_enabled]
     *      [vm.display.file_transfer_enabled]
     *      [vm.display.copy_paste_enabled]
     *      [vm.display.keyboard_layout]
     *      [vm.display.disconnect_action]
     *      [vm.os.cmdline]
     *      [vm.cpu.topology.cores]
     *      [vm.cpu_shares]
     *      [vm.cpu.architecture]
     *      [vm.memory]
     *      [vm.memory_policy.guaranteed]
     *      [vm.memory_policy.ballooning]
     *      [vm.high_availability.priority]
     *      [vm.high_availability.enabled]
     *      [vm.domain.name]
     *      [vm.description]
     *      [vm.comment]
     *      [vm.stateless]
     *      [vm.delete_protected]
     *      [vm.sso.methods.method]
     *      [vm.rng_device.rate.bytes]
     *      [vm.rng_device.rate.period]
     *      [vm.rng_device.source]
     *      [vm.console.enabled]
     *      [vm.cpu.topology.sockets]
     *      [vm.placement_policy.affinity]
     *      [vm.placement_policy.hosts.host]
     *      [vm.origin]
     *      [vm.os.kernel]
     *      [vm.tunnel_migration]
     *      [vm.migration_downtime]
     *      [vm.virtio_scsi.enabled]
     *      [vm.soundcard_enabled]
     *      [vm.custom_emulated_machine]
     *      [vm.custom_cpu_model]
     *      [vm.payloads.payload]
     *      [vm.cpu.cpu_tune.vcpu_pins.vcpu_pin]
     *      [vm.serial_number.policy]
     *      [vm.serial_number.value]
     *      [vm.bios.boot_menu.enabled]
     *      [vm.numa_tune_mode]
     *      [vm.start_paused]
     *      [vm.cpu_profile.id]
     *      [vm.migration.auto_converge]
     *      [vm.migration.compressed]
     *      [vm.small_icon.id]
     *      [vm.large_icon.id]
     *      [vm.large_icon.media_type]
     *      [vm.large_icon.data]
     *
     *    Overload 3:
     *
     *      add a virtual machine to the
     *      system from a configuration -
     *      requires the configuration
     *      type and the configuration
     *      data
     *
     *      vm.initialization.configuration.type
     *      vm.initialization.configuration.data
     *      [vm.name]
     *      [vm.quota.id]
     *      [vm.time_zone.name]
     *      [vm.os.boot]
     *      [vm.custom_properties.custom_property]
     *      [vm.os.type]
     *      [vm.usb.enabled]
     *      [vm.usb.type]
     *      [vm.type]
     *      [vm.os.initRd]
     *      [vm.display.monitors]
     *      [vm.display.type]
     *      [vm.display.allow_override]
     *      [vm.display.smartcard_enabled]
     *      [vm.display.file_transfer_enabled]
     *      [vm.display.copy_paste_enabled]
     *      [vm.display.keyboard_layout]
     *      [vm.display.disconnect_action]
     *      [vm.os.cmdline]
     *      [vm.cpu.topology.cores]
     *      [vm.memory]
     *      [vm.memory_policy.guaranteed]
     *      [vm.memory_policy.ballooning]
     *      [vm.high_availability.priority]
     *      [vm.high_availability.enabled]
     *      [vm.domain.name]
     *      [vm.description]
     *      [vm.comment]
     *      [vm.stateless]
     *      [vm.delete_protected]
     *      [vm.sso.methods.method]
     *      [vm.rng_device.rate.bytes]
     *      [vm.rng_device.rate.period]
     *      [vm.rng_device.source]
     *      [vm.cpu.mode]
     *      [vm.cpu.topology.sockets]
     *      [vm.placement_policy.affinity]
     *      [vm.placement_policy.hosts.host]
     *      [vm.origin]
     *      [vm.os.kernel]
     *      [vm.disks.clone]
     *      [vm.tunnel_migration]
     *      [vm.migration_downtime]
     *      [vm.virtio_scsi.enabled]
     *      [vm.payloads.payload]
     *      [vm.initialization.configuration.type]
     *      [vm.initialization.configuration.data]
     *      [vm.initialization.regenerate_ids]
     *      [vm.cpu.cpu_tune.vcpu_pins.vcpu_pin]
     *      [vm.serial_number.policy]
     *      [vm.serial_number.value]
     *      [vm.bios.boot_menu.enabled]
     *      [vm.numa_tune_mode]
     *      [vm.start_paused]
     *      [vm.cpu_profile.id]
     *      [vm.migration.auto_converge]
     *      [vm.migration.compressed]
     *      [vm.small_icon.id]
     *      [vm.large_icon.id]
     *      [vm.large_icon.media_type]
     *      [vm.large_icon.data]
     *    </pre>
     *
     * @param clone
     *    <pre>
     *    [true|false]
     *    </pre>
     * @return
     *     {@link Vm }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public Vm add(org.ovirt.engine.sdk.entities.Vm vm, Boolean clone) throws
            ClientProtocolException, ServerException, IOException {
        String url = SLASH + getName();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        if (clone != null) {
            urlBuilder.add("clone", clone, UrlParameterType.MATRIX);
        }

        url = urlBuilder.build();

        return getProxy().add(url, vm,
                org.ovirt.engine.sdk.entities.Vm.class,
                Vm.class, headers);
    }
    /**
     * Adds Vm object.
     *
     * @param vm {@link org.ovirt.engine.sdk.entities.Vm}
     *    <pre>
     *    Overload 1:
     *
     *      add a virtual machine to the
     *      system from scratch
     *
     *      vm.name
     *      vm.template.id|name
     *      vm.cluster.id|name
     *      [vm.instance_type.id|name]
     *      [vm.quota.id]
     *      [vm.time_zone.name]
     *      [vm.os.boot]
     *      [vm.custom_properties.custom_property]
     *      [vm.os.type]
     *      [vm.usb.enabled]
     *      [vm.usb.type]
     *      [vm.type]
     *      [vm.os.initRd]
     *      [vm.display.monitors]
     *      [vm.display.single_qxl_pci]
     *      [vm.display.type]
     *      [vm.display.allow_override]
     *      [vm.display.smartcard_enabled]
     *      [vm.display.file_transfer_enabled]
     *      [vm.display.copy_paste_enabled]
     *      [vm.display.keyboard_layout]
     *      [vm.display.disconnect_action]
     *      [vm.os.cmdline]
     *      [vm.cpu.topology.cores]
     *      [vm.cpu.architecture]
     *      [vm.memory]
     *      [vm.io.threads]
     *      [vm.memory_policy.guaranteed]
     *      [vm.memory_policy.ballooning]
     *      [vm.high_availability.priority]
     *      [vm.high_availability.enabled]
     *      [vm.domain.name]
     *      [vm.description]
     *      [vm.comment]
     *      [vm.stateless]
     *      [vm.delete_protected]
     *      [vm.sso.methods.method]
     *      [vm.rng_device.rate.bytes]
     *      [vm.rng_device.rate.period]
     *      [vm.rng_device.source]
     *      [vm.console.enabled]
     *      [vm.cpu.mode]
     *      [vm.cpu.topology.sockets]
     *      [vm.cpu_shares]
     *      [vm.placement_policy.affinity]
     *      [vm.placement_policy.hosts.host]
     *      [vm.origin]
     *      [vm.os.kernel]
     *      [vm.tunnel_migration]
     *      [vm.migration_downtime]
     *      [vm.virtio_scsi.enabled]
     *      [vm.soundcard_enabled]
     *      [vm.custom_emulated_machine]
     *      [vm.custom_cpu_model]
     *      [vm.payloads.payload]
     *      [vm.initialization.configuration.type]
     *      [vm.initialization.configuration.data]
     *      [vm.cpu.cpu_tune.vcpu_pins.vcpu_pin]
     *      [vm.use_latest_template_version]
     *      [vm.serial_number.policy]
     *      [vm.serial_number.value]
     *      [vm.bios.boot_menu.enabled]
     *      [vm.numa_tune_mode]
     *      [vm.start_paused]
     *      [vm.cpu_profile.id]
     *      [vm.migration.auto_converge]
     *      [vm.migration.compressed]
     *      [vm.small_icon.id]
     *      [vm.large_icon.id]
     *      [vm.large_icon.media_type]
     *      [vm.large_icon.data]
     *
     *    Overload 2:
     *
     *      add a virtual machine to the
     *      system by cloning from a
     *      snapshot
     *
     *      vm.name
     *      vm.template.id|name
     *      vm.cluster.id|name
     *      vm.snapshots.snapshot
     *      [vm.quota.id]
     *      [vm.time_zone.name]
     *      [vm.os.boot]
     *      [vm.custom_properties.custom_property]
     *      [vm.os.type]
     *      [vm.usb.enabled]
     *      [vm.usb.type]
     *      [vm.type]
     *      [vm.os.initRd]
     *      [vm.display.monitors]
     *      [vm.display.single_qxl_pci]
     *      [vm.display.type]
     *      [vm.display.allow_override]
     *      [vm.display.smartcard_enabled]
     *      [vm.display.file_transfer_enabled]
     *      [vm.display.copy_paste_enabled]
     *      [vm.display.keyboard_layout]
     *      [vm.display.disconnect_action]
     *      [vm.os.cmdline]
     *      [vm.cpu.topology.cores]
     *      [vm.cpu_shares]
     *      [vm.cpu.architecture]
     *      [vm.memory]
     *      [vm.memory_policy.guaranteed]
     *      [vm.memory_policy.ballooning]
     *      [vm.high_availability.priority]
     *      [vm.high_availability.enabled]
     *      [vm.domain.name]
     *      [vm.description]
     *      [vm.comment]
     *      [vm.stateless]
     *      [vm.delete_protected]
     *      [vm.sso.methods.method]
     *      [vm.rng_device.rate.bytes]
     *      [vm.rng_device.rate.period]
     *      [vm.rng_device.source]
     *      [vm.console.enabled]
     *      [vm.cpu.topology.sockets]
     *      [vm.placement_policy.affinity]
     *      [vm.placement_policy.hosts.host]
     *      [vm.origin]
     *      [vm.os.kernel]
     *      [vm.tunnel_migration]
     *      [vm.migration_downtime]
     *      [vm.virtio_scsi.enabled]
     *      [vm.soundcard_enabled]
     *      [vm.custom_emulated_machine]
     *      [vm.custom_cpu_model]
     *      [vm.payloads.payload]
     *      [vm.cpu.cpu_tune.vcpu_pins.vcpu_pin]
     *      [vm.serial_number.policy]
     *      [vm.serial_number.value]
     *      [vm.bios.boot_menu.enabled]
     *      [vm.numa_tune_mode]
     *      [vm.start_paused]
     *      [vm.cpu_profile.id]
     *      [vm.migration.auto_converge]
     *      [vm.migration.compressed]
     *      [vm.small_icon.id]
     *      [vm.large_icon.id]
     *      [vm.large_icon.media_type]
     *      [vm.large_icon.data]
     *
     *    Overload 3:
     *
     *      add a virtual machine to the
     *      system from a configuration -
     *      requires the configuration
     *      type and the configuration
     *      data
     *
     *      vm.initialization.configuration.type
     *      vm.initialization.configuration.data
     *      [vm.name]
     *      [vm.quota.id]
     *      [vm.time_zone.name]
     *      [vm.os.boot]
     *      [vm.custom_properties.custom_property]
     *      [vm.os.type]
     *      [vm.usb.enabled]
     *      [vm.usb.type]
     *      [vm.type]
     *      [vm.os.initRd]
     *      [vm.display.monitors]
     *      [vm.display.type]
     *      [vm.display.allow_override]
     *      [vm.display.smartcard_enabled]
     *      [vm.display.file_transfer_enabled]
     *      [vm.display.copy_paste_enabled]
     *      [vm.display.keyboard_layout]
     *      [vm.display.disconnect_action]
     *      [vm.os.cmdline]
     *      [vm.cpu.topology.cores]
     *      [vm.memory]
     *      [vm.memory_policy.guaranteed]
     *      [vm.memory_policy.ballooning]
     *      [vm.high_availability.priority]
     *      [vm.high_availability.enabled]
     *      [vm.domain.name]
     *      [vm.description]
     *      [vm.comment]
     *      [vm.stateless]
     *      [vm.delete_protected]
     *      [vm.sso.methods.method]
     *      [vm.rng_device.rate.bytes]
     *      [vm.rng_device.rate.period]
     *      [vm.rng_device.source]
     *      [vm.cpu.mode]
     *      [vm.cpu.topology.sockets]
     *      [vm.placement_policy.affinity]
     *      [vm.placement_policy.hosts.host]
     *      [vm.origin]
     *      [vm.os.kernel]
     *      [vm.disks.clone]
     *      [vm.tunnel_migration]
     *      [vm.migration_downtime]
     *      [vm.virtio_scsi.enabled]
     *      [vm.payloads.payload]
     *      [vm.initialization.configuration.type]
     *      [vm.initialization.configuration.data]
     *      [vm.initialization.regenerate_ids]
     *      [vm.cpu.cpu_tune.vcpu_pins.vcpu_pin]
     *      [vm.serial_number.policy]
     *      [vm.serial_number.value]
     *      [vm.bios.boot_menu.enabled]
     *      [vm.numa_tune_mode]
     *      [vm.start_paused]
     *      [vm.cpu_profile.id]
     *      [vm.migration.auto_converge]
     *      [vm.migration.compressed]
     *      [vm.small_icon.id]
     *      [vm.large_icon.id]
     *      [vm.large_icon.media_type]
     *      [vm.large_icon.data]
     *    </pre>
     *
     * @param clone
     *    <pre>
     *    [true|false]
     *    </pre>
     * @param clonePermissions
     *    <pre>
     *    [true|false]
     *    </pre>
     * @return
     *     {@link Vm }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public Vm add(org.ovirt.engine.sdk.entities.Vm vm, Boolean clone, Boolean clonePermissions) throws
            ClientProtocolException, ServerException, IOException {
        String url = SLASH + getName();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        if (clone != null) {
            urlBuilder.add("clone", clone, UrlParameterType.MATRIX);
        }

        if (clonePermissions != null) {
            urlBuilder.add("clone_permissions", clonePermissions, UrlParameterType.MATRIX);
        }

        url = urlBuilder.build();

        return getProxy().add(url, vm,
                org.ovirt.engine.sdk.entities.Vm.class,
                Vm.class, headers);
    }
    /**
     * Adds Vm object.
     *
     * @param vm {@link org.ovirt.engine.sdk.entities.Vm}
     *    <pre>
     *    Overload 1:
     *
     *      add a virtual machine to the
     *      system from scratch
     *
     *      vm.name
     *      vm.template.id|name
     *      vm.cluster.id|name
     *      [vm.instance_type.id|name]
     *      [vm.quota.id]
     *      [vm.time_zone.name]
     *      [vm.os.boot]
     *      [vm.custom_properties.custom_property]
     *      [vm.os.type]
     *      [vm.usb.enabled]
     *      [vm.usb.type]
     *      [vm.type]
     *      [vm.os.initRd]
     *      [vm.display.monitors]
     *      [vm.display.single_qxl_pci]
     *      [vm.display.type]
     *      [vm.display.allow_override]
     *      [vm.display.smartcard_enabled]
     *      [vm.display.file_transfer_enabled]
     *      [vm.display.copy_paste_enabled]
     *      [vm.display.keyboard_layout]
     *      [vm.display.disconnect_action]
     *      [vm.os.cmdline]
     *      [vm.cpu.topology.cores]
     *      [vm.cpu.architecture]
     *      [vm.memory]
     *      [vm.io.threads]
     *      [vm.memory_policy.guaranteed]
     *      [vm.memory_policy.ballooning]
     *      [vm.high_availability.priority]
     *      [vm.high_availability.enabled]
     *      [vm.domain.name]
     *      [vm.description]
     *      [vm.comment]
     *      [vm.stateless]
     *      [vm.delete_protected]
     *      [vm.sso.methods.method]
     *      [vm.rng_device.rate.bytes]
     *      [vm.rng_device.rate.period]
     *      [vm.rng_device.source]
     *      [vm.console.enabled]
     *      [vm.cpu.mode]
     *      [vm.cpu.topology.sockets]
     *      [vm.cpu_shares]
     *      [vm.placement_policy.affinity]
     *      [vm.placement_policy.hosts.host]
     *      [vm.origin]
     *      [vm.os.kernel]
     *      [vm.tunnel_migration]
     *      [vm.migration_downtime]
     *      [vm.virtio_scsi.enabled]
     *      [vm.soundcard_enabled]
     *      [vm.custom_emulated_machine]
     *      [vm.custom_cpu_model]
     *      [vm.payloads.payload]
     *      [vm.initialization.configuration.type]
     *      [vm.initialization.configuration.data]
     *      [vm.cpu.cpu_tune.vcpu_pins.vcpu_pin]
     *      [vm.use_latest_template_version]
     *      [vm.serial_number.policy]
     *      [vm.serial_number.value]
     *      [vm.bios.boot_menu.enabled]
     *      [vm.numa_tune_mode]
     *      [vm.start_paused]
     *      [vm.cpu_profile.id]
     *      [vm.migration.auto_converge]
     *      [vm.migration.compressed]
     *      [vm.small_icon.id]
     *      [vm.large_icon.id]
     *      [vm.large_icon.media_type]
     *      [vm.large_icon.data]
     *
     *    Overload 2:
     *
     *      add a virtual machine to the
     *      system by cloning from a
     *      snapshot
     *
     *      vm.name
     *      vm.template.id|name
     *      vm.cluster.id|name
     *      vm.snapshots.snapshot
     *      [vm.quota.id]
     *      [vm.time_zone.name]
     *      [vm.os.boot]
     *      [vm.custom_properties.custom_property]
     *      [vm.os.type]
     *      [vm.usb.enabled]
     *      [vm.usb.type]
     *      [vm.type]
     *      [vm.os.initRd]
     *      [vm.display.monitors]
     *      [vm.display.single_qxl_pci]
     *      [vm.display.type]
     *      [vm.display.allow_override]
     *      [vm.display.smartcard_enabled]
     *      [vm.display.file_transfer_enabled]
     *      [vm.display.copy_paste_enabled]
     *      [vm.display.keyboard_layout]
     *      [vm.display.disconnect_action]
     *      [vm.os.cmdline]
     *      [vm.cpu.topology.cores]
     *      [vm.cpu_shares]
     *      [vm.cpu.architecture]
     *      [vm.memory]
     *      [vm.memory_policy.guaranteed]
     *      [vm.memory_policy.ballooning]
     *      [vm.high_availability.priority]
     *      [vm.high_availability.enabled]
     *      [vm.domain.name]
     *      [vm.description]
     *      [vm.comment]
     *      [vm.stateless]
     *      [vm.delete_protected]
     *      [vm.sso.methods.method]
     *      [vm.rng_device.rate.bytes]
     *      [vm.rng_device.rate.period]
     *      [vm.rng_device.source]
     *      [vm.console.enabled]
     *      [vm.cpu.topology.sockets]
     *      [vm.placement_policy.affinity]
     *      [vm.placement_policy.hosts.host]
     *      [vm.origin]
     *      [vm.os.kernel]
     *      [vm.tunnel_migration]
     *      [vm.migration_downtime]
     *      [vm.virtio_scsi.enabled]
     *      [vm.soundcard_enabled]
     *      [vm.custom_emulated_machine]
     *      [vm.custom_cpu_model]
     *      [vm.payloads.payload]
     *      [vm.cpu.cpu_tune.vcpu_pins.vcpu_pin]
     *      [vm.serial_number.policy]
     *      [vm.serial_number.value]
     *      [vm.bios.boot_menu.enabled]
     *      [vm.numa_tune_mode]
     *      [vm.start_paused]
     *      [vm.cpu_profile.id]
     *      [vm.migration.auto_converge]
     *      [vm.migration.compressed]
     *      [vm.small_icon.id]
     *      [vm.large_icon.id]
     *      [vm.large_icon.media_type]
     *      [vm.large_icon.data]
     *
     *    Overload 3:
     *
     *      add a virtual machine to the
     *      system from a configuration -
     *      requires the configuration
     *      type and the configuration
     *      data
     *
     *      vm.initialization.configuration.type
     *      vm.initialization.configuration.data
     *      [vm.name]
     *      [vm.quota.id]
     *      [vm.time_zone.name]
     *      [vm.os.boot]
     *      [vm.custom_properties.custom_property]
     *      [vm.os.type]
     *      [vm.usb.enabled]
     *      [vm.usb.type]
     *      [vm.type]
     *      [vm.os.initRd]
     *      [vm.display.monitors]
     *      [vm.display.type]
     *      [vm.display.allow_override]
     *      [vm.display.smartcard_enabled]
     *      [vm.display.file_transfer_enabled]
     *      [vm.display.copy_paste_enabled]
     *      [vm.display.keyboard_layout]
     *      [vm.display.disconnect_action]
     *      [vm.os.cmdline]
     *      [vm.cpu.topology.cores]
     *      [vm.memory]
     *      [vm.memory_policy.guaranteed]
     *      [vm.memory_policy.ballooning]
     *      [vm.high_availability.priority]
     *      [vm.high_availability.enabled]
     *      [vm.domain.name]
     *      [vm.description]
     *      [vm.comment]
     *      [vm.stateless]
     *      [vm.delete_protected]
     *      [vm.sso.methods.method]
     *      [vm.rng_device.rate.bytes]
     *      [vm.rng_device.rate.period]
     *      [vm.rng_device.source]
     *      [vm.cpu.mode]
     *      [vm.cpu.topology.sockets]
     *      [vm.placement_policy.affinity]
     *      [vm.placement_policy.hosts.host]
     *      [vm.origin]
     *      [vm.os.kernel]
     *      [vm.disks.clone]
     *      [vm.tunnel_migration]
     *      [vm.migration_downtime]
     *      [vm.virtio_scsi.enabled]
     *      [vm.payloads.payload]
     *      [vm.initialization.configuration.type]
     *      [vm.initialization.configuration.data]
     *      [vm.initialization.regenerate_ids]
     *      [vm.cpu.cpu_tune.vcpu_pins.vcpu_pin]
     *      [vm.serial_number.policy]
     *      [vm.serial_number.value]
     *      [vm.bios.boot_menu.enabled]
     *      [vm.numa_tune_mode]
     *      [vm.start_paused]
     *      [vm.cpu_profile.id]
     *      [vm.migration.auto_converge]
     *      [vm.migration.compressed]
     *      [vm.small_icon.id]
     *      [vm.large_icon.id]
     *      [vm.large_icon.media_type]
     *      [vm.large_icon.data]
     *    </pre>
     *
     * @param clone
     *    <pre>
     *    [true|false]
     *    </pre>
     * @param clonePermissions
     *    <pre>
     *    [true|false]
     *    </pre>
     * @param correlationId
     *    <pre>
     *    [any string]
     *    </pre>
     * @return
     *     {@link Vm }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public Vm add(org.ovirt.engine.sdk.entities.Vm vm, Boolean clone, Boolean clonePermissions, String correlationId) throws
            ClientProtocolException, ServerException, IOException {
        String url = SLASH + getName();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        if (correlationId != null) {
            headersBuilder.add("Correlation-Id", correlationId);
        }
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        if (clone != null) {
            urlBuilder.add("clone", clone, UrlParameterType.MATRIX);
        }

        if (clonePermissions != null) {
            urlBuilder.add("clone_permissions", clonePermissions, UrlParameterType.MATRIX);
        }

        url = urlBuilder.build();

        return getProxy().add(url, vm,
                org.ovirt.engine.sdk.entities.Vm.class,
                Vm.class, headers);
    }
    /**
     * Adds Vm object.
     *
     * @param vm {@link org.ovirt.engine.sdk.entities.Vm}
     *    <pre>
     *    Overload 1:
     *
     *      add a virtual machine to the
     *      system from scratch
     *
     *      vm.name
     *      vm.template.id|name
     *      vm.cluster.id|name
     *      [vm.instance_type.id|name]
     *      [vm.quota.id]
     *      [vm.time_zone.name]
     *      [vm.os.boot]
     *      [vm.custom_properties.custom_property]
     *      [vm.os.type]
     *      [vm.usb.enabled]
     *      [vm.usb.type]
     *      [vm.type]
     *      [vm.os.initRd]
     *      [vm.display.monitors]
     *      [vm.display.single_qxl_pci]
     *      [vm.display.type]
     *      [vm.display.allow_override]
     *      [vm.display.smartcard_enabled]
     *      [vm.display.file_transfer_enabled]
     *      [vm.display.copy_paste_enabled]
     *      [vm.display.keyboard_layout]
     *      [vm.display.disconnect_action]
     *      [vm.os.cmdline]
     *      [vm.cpu.topology.cores]
     *      [vm.cpu.architecture]
     *      [vm.memory]
     *      [vm.io.threads]
     *      [vm.memory_policy.guaranteed]
     *      [vm.memory_policy.ballooning]
     *      [vm.high_availability.priority]
     *      [vm.high_availability.enabled]
     *      [vm.domain.name]
     *      [vm.description]
     *      [vm.comment]
     *      [vm.stateless]
     *      [vm.delete_protected]
     *      [vm.sso.methods.method]
     *      [vm.rng_device.rate.bytes]
     *      [vm.rng_device.rate.period]
     *      [vm.rng_device.source]
     *      [vm.console.enabled]
     *      [vm.cpu.mode]
     *      [vm.cpu.topology.sockets]
     *      [vm.cpu_shares]
     *      [vm.placement_policy.affinity]
     *      [vm.placement_policy.hosts.host]
     *      [vm.origin]
     *      [vm.os.kernel]
     *      [vm.tunnel_migration]
     *      [vm.migration_downtime]
     *      [vm.virtio_scsi.enabled]
     *      [vm.soundcard_enabled]
     *      [vm.custom_emulated_machine]
     *      [vm.custom_cpu_model]
     *      [vm.payloads.payload]
     *      [vm.initialization.configuration.type]
     *      [vm.initialization.configuration.data]
     *      [vm.cpu.cpu_tune.vcpu_pins.vcpu_pin]
     *      [vm.use_latest_template_version]
     *      [vm.serial_number.policy]
     *      [vm.serial_number.value]
     *      [vm.bios.boot_menu.enabled]
     *      [vm.numa_tune_mode]
     *      [vm.start_paused]
     *      [vm.cpu_profile.id]
     *      [vm.migration.auto_converge]
     *      [vm.migration.compressed]
     *      [vm.small_icon.id]
     *      [vm.large_icon.id]
     *      [vm.large_icon.media_type]
     *      [vm.large_icon.data]
     *
     *    Overload 2:
     *
     *      add a virtual machine to the
     *      system by cloning from a
     *      snapshot
     *
     *      vm.name
     *      vm.template.id|name
     *      vm.cluster.id|name
     *      vm.snapshots.snapshot
     *      [vm.quota.id]
     *      [vm.time_zone.name]
     *      [vm.os.boot]
     *      [vm.custom_properties.custom_property]
     *      [vm.os.type]
     *      [vm.usb.enabled]
     *      [vm.usb.type]
     *      [vm.type]
     *      [vm.os.initRd]
     *      [vm.display.monitors]
     *      [vm.display.single_qxl_pci]
     *      [vm.display.type]
     *      [vm.display.allow_override]
     *      [vm.display.smartcard_enabled]
     *      [vm.display.file_transfer_enabled]
     *      [vm.display.copy_paste_enabled]
     *      [vm.display.keyboard_layout]
     *      [vm.display.disconnect_action]
     *      [vm.os.cmdline]
     *      [vm.cpu.topology.cores]
     *      [vm.cpu_shares]
     *      [vm.cpu.architecture]
     *      [vm.memory]
     *      [vm.memory_policy.guaranteed]
     *      [vm.memory_policy.ballooning]
     *      [vm.high_availability.priority]
     *      [vm.high_availability.enabled]
     *      [vm.domain.name]
     *      [vm.description]
     *      [vm.comment]
     *      [vm.stateless]
     *      [vm.delete_protected]
     *      [vm.sso.methods.method]
     *      [vm.rng_device.rate.bytes]
     *      [vm.rng_device.rate.period]
     *      [vm.rng_device.source]
     *      [vm.console.enabled]
     *      [vm.cpu.topology.sockets]
     *      [vm.placement_policy.affinity]
     *      [vm.placement_policy.hosts.host]
     *      [vm.origin]
     *      [vm.os.kernel]
     *      [vm.tunnel_migration]
     *      [vm.migration_downtime]
     *      [vm.virtio_scsi.enabled]
     *      [vm.soundcard_enabled]
     *      [vm.custom_emulated_machine]
     *      [vm.custom_cpu_model]
     *      [vm.payloads.payload]
     *      [vm.cpu.cpu_tune.vcpu_pins.vcpu_pin]
     *      [vm.serial_number.policy]
     *      [vm.serial_number.value]
     *      [vm.bios.boot_menu.enabled]
     *      [vm.numa_tune_mode]
     *      [vm.start_paused]
     *      [vm.cpu_profile.id]
     *      [vm.migration.auto_converge]
     *      [vm.migration.compressed]
     *      [vm.small_icon.id]
     *      [vm.large_icon.id]
     *      [vm.large_icon.media_type]
     *      [vm.large_icon.data]
     *
     *    Overload 3:
     *
     *      add a virtual machine to the
     *      system from a configuration -
     *      requires the configuration
     *      type and the configuration
     *      data
     *
     *      vm.initialization.configuration.type
     *      vm.initialization.configuration.data
     *      [vm.name]
     *      [vm.quota.id]
     *      [vm.time_zone.name]
     *      [vm.os.boot]
     *      [vm.custom_properties.custom_property]
     *      [vm.os.type]
     *      [vm.usb.enabled]
     *      [vm.usb.type]
     *      [vm.type]
     *      [vm.os.initRd]
     *      [vm.display.monitors]
     *      [vm.display.type]
     *      [vm.display.allow_override]
     *      [vm.display.smartcard_enabled]
     *      [vm.display.file_transfer_enabled]
     *      [vm.display.copy_paste_enabled]
     *      [vm.display.keyboard_layout]
     *      [vm.display.disconnect_action]
     *      [vm.os.cmdline]
     *      [vm.cpu.topology.cores]
     *      [vm.memory]
     *      [vm.memory_policy.guaranteed]
     *      [vm.memory_policy.ballooning]
     *      [vm.high_availability.priority]
     *      [vm.high_availability.enabled]
     *      [vm.domain.name]
     *      [vm.description]
     *      [vm.comment]
     *      [vm.stateless]
     *      [vm.delete_protected]
     *      [vm.sso.methods.method]
     *      [vm.rng_device.rate.bytes]
     *      [vm.rng_device.rate.period]
     *      [vm.rng_device.source]
     *      [vm.cpu.mode]
     *      [vm.cpu.topology.sockets]
     *      [vm.placement_policy.affinity]
     *      [vm.placement_policy.hosts.host]
     *      [vm.origin]
     *      [vm.os.kernel]
     *      [vm.disks.clone]
     *      [vm.tunnel_migration]
     *      [vm.migration_downtime]
     *      [vm.virtio_scsi.enabled]
     *      [vm.payloads.payload]
     *      [vm.initialization.configuration.type]
     *      [vm.initialization.configuration.data]
     *      [vm.initialization.regenerate_ids]
     *      [vm.cpu.cpu_tune.vcpu_pins.vcpu_pin]
     *      [vm.serial_number.policy]
     *      [vm.serial_number.value]
     *      [vm.bios.boot_menu.enabled]
     *      [vm.numa_tune_mode]
     *      [vm.start_paused]
     *      [vm.cpu_profile.id]
     *      [vm.migration.auto_converge]
     *      [vm.migration.compressed]
     *      [vm.small_icon.id]
     *      [vm.large_icon.id]
     *      [vm.large_icon.media_type]
     *      [vm.large_icon.data]
     *    </pre>
     *
     * @param clone
     *    <pre>
     *    [true|false]
     *    </pre>
     * @param clonePermissions
     *    <pre>
     *    [true|false]
     *    </pre>
     * @param correlationId
     *    <pre>
     *    [any string]
     *    </pre>
     * @param expect
     *    <pre>
     *    [201-created]
     *    </pre>
     * @return
     *     {@link Vm }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public Vm add(org.ovirt.engine.sdk.entities.Vm vm, Boolean clone, Boolean clonePermissions, String correlationId, String expect) throws
            ClientProtocolException, ServerException, IOException {
        String url = SLASH + getName();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        if (correlationId != null) {
            headersBuilder.add("Correlation-Id", correlationId);
        }
        if (expect != null) {
            headersBuilder.add("Expect", expect);
        }
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        if (clone != null) {
            urlBuilder.add("clone", clone, UrlParameterType.MATRIX);
        }

        if (clonePermissions != null) {
            urlBuilder.add("clone_permissions", clonePermissions, UrlParameterType.MATRIX);
        }

        url = urlBuilder.build();

        return getProxy().add(url, vm,
                org.ovirt.engine.sdk.entities.Vm.class,
                Vm.class, headers);
    }
    /**
     * Lists Vm objects.
     *
     * @param allContent
     *    <pre>
     *    [true|false]
     *    </pre>
     *
     * @return List of {@link Vm }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public List<Vm> list(String allContent) throws ClientProtocolException,
            ServerException, IOException {

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        if (allContent != null) {
            headersBuilder.add("All-Content", allContent);
        }
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(SLASH + getName());
        String url = urlBuilder.build();

        return list(url, org.ovirt.engine.sdk.entities.Vms.class,
                Vm.class, headers);
    }
    /**
     * Lists Vm objects.
     *
     * @param allContent
     *    <pre>
     *    [true|false]
     *    </pre>
     * @param caseSensitive
     *    <pre>
     *    [true|false]
     *    </pre>
     *
     * @return List of {@link Vm }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public List<Vm> list(String allContent, Boolean caseSensitive) throws ClientProtocolException,
            ServerException, IOException {

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        if (allContent != null) {
            headersBuilder.add("All-Content", allContent);
        }
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(SLASH + getName());
        if (caseSensitive != null) {
            urlBuilder.add("case_sensitive", caseSensitive, UrlParameterType.MATRIX);
        }

        String url = urlBuilder.build();

        return list(url, org.ovirt.engine.sdk.entities.Vms.class,
                Vm.class, headers);
    }
    /**
     * Lists Vm objects.
     *
     * @param allContent
     *    <pre>
     *    [true|false]
     *    </pre>
     * @param caseSensitive
     *    <pre>
     *    [true|false]
     *    </pre>
     * @param max
     *    <pre>
     *    [max results]
     *    </pre>
     *
     * @return List of {@link Vm }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public List<Vm> list(String allContent, Boolean caseSensitive, Integer max) throws ClientProtocolException,
            ServerException, IOException {

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        if (allContent != null) {
            headersBuilder.add("All-Content", allContent);
        }
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(SLASH + getName());
        if (caseSensitive != null) {
            urlBuilder.add("case_sensitive", caseSensitive, UrlParameterType.MATRIX);
        }

        if (max != null) {
            urlBuilder.add("max", max, UrlParameterType.MATRIX);
        }

        String url = urlBuilder.build();

        return list(url, org.ovirt.engine.sdk.entities.Vms.class,
                Vm.class, headers);
    }
    /**
     * Lists Vm objects.
     *
     * @param allContent
     *    <pre>
     *    [true|false]
     *    </pre>
     * @param caseSensitive
     *    <pre>
     *    [true|false]
     *    </pre>
     * @param max
     *    <pre>
     *    [max results]
     *    </pre>
     * @param query
     *    <pre>
     *    [search query]
     *    </pre>
     *
     * @return List of {@link Vm }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public List<Vm> list(String allContent, Boolean caseSensitive, Integer max, String query) throws ClientProtocolException,
            ServerException, IOException {

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        if (allContent != null) {
            headersBuilder.add("All-Content", allContent);
        }
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(SLASH + getName());
        if (caseSensitive != null) {
            urlBuilder.add("case_sensitive", caseSensitive, UrlParameterType.MATRIX);
        }

        if (max != null) {
            urlBuilder.add("max", max, UrlParameterType.MATRIX);
        }

        if (query != null) {
            urlBuilder.add("search", query, UrlParameterType.QUERY);
        }

        String url = urlBuilder.build();

        return list(url, org.ovirt.engine.sdk.entities.Vms.class,
                Vm.class, headers);
    }

}
