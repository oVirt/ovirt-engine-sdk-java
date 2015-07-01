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
 * <p>Templates providing relation and functional services
 * <p>to {@link org.ovirt.engine.sdk.entities.Templates }.
 */
@SuppressWarnings("unused")
public class Templates extends
        CollectionDecorator<org.ovirt.engine.sdk.entities.Template,
                            org.ovirt.engine.sdk.entities.Templates,
                            Template> {

    /**
     * @param proxy HttpProxyBroker
     */
    public Templates(HttpProxyBroker proxy) {
        super(proxy, "templates");
    }

    /**
     * Lists Template objects.
     *
     * @return
     *     List of {@link Template }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    @Override
    public List<Template> list() throws ClientProtocolException,
            ServerException, IOException {
        String url = SLASH + getName();
        return list(url, org.ovirt.engine.sdk.entities.Templates.class, Template.class);
    }

    /**
     * Fetches Template object by id.
     *
     * @return {@link Template }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    @Override
    public Template get(UUID id) throws ClientProtocolException,
            ServerException, IOException {
        String url = SLASH + getName() + SLASH + id.toString();
        return getProxy().get(url, org.ovirt.engine.sdk.entities.Template.class, Template.class);
    }

    /**
     * Fetches Template object by id.
     *
     * @return {@link Template }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    @Override
    public Template getById(String id) throws ClientProtocolException,
            ServerException, IOException {
        String url = SLASH + getName() + SLASH + id;
        return getProxy().get(url, org.ovirt.engine.sdk.entities.Template.class, Template.class);
    }

    /**
     * Lists Template objects.
     *
     * @param query
     *    <pre>
     *    [search query]
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
     *
     * @return List of {@link Template }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public List<Template> list(String query, Boolean caseSensitive, Integer max) throws ClientProtocolException,
            ServerException, IOException {

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(SLASH + getName());
        if (query != null) {
            urlBuilder.add("search", query, UrlParameterType.QUERY);
        }
        if (caseSensitive != null) {
            urlBuilder.add("case_sensitive", caseSensitive, UrlParameterType.MATRIX);
        }
        if (max != null) {
            urlBuilder.add("max", max, UrlParameterType.MATRIX);
        }
        String url = urlBuilder.build();

        return list(url, org.ovirt.engine.sdk.entities.Templates.class,
                Template.class, headers);
    }
    /**
     * Lists Template objects.
     *
     * @param allContent
     *    <pre>
     *    [true|false]
     *    </pre>
     *
     * @param query
     *    <pre>
     *    [search query]
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
     *
     * @return List of {@link Template }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public List<Template> list(String query, Boolean caseSensitive, Integer max, String allContent) throws ClientProtocolException,
            ServerException, IOException {

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        if (allContent != null) {
            headersBuilder.add("All-Content", allContent);
        }
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(SLASH + getName());
        if (query != null) {
            urlBuilder.add("search", query, UrlParameterType.QUERY);
        }
        if (caseSensitive != null) {
            urlBuilder.add("case_sensitive", caseSensitive, UrlParameterType.MATRIX);
        }
        if (max != null) {
            urlBuilder.add("max", max, UrlParameterType.MATRIX);
        }
        String url = urlBuilder.build();

        return list(url, org.ovirt.engine.sdk.entities.Templates.class,
                Template.class, headers);
    }
    /**
     * Adds Template object.
     *
     * @param template {@link org.ovirt.engine.sdk.entities.Template}
     *    <pre>
     *    template.vm.id|name
     *    template.name
     *    [template.memory]
     *    [template.cpu.topology.cores]
     *    [template.high_availability.enabled]
     *    [template.os.cmdline]
     *    [template.origin]
     *    [template.high_availability.priority]
     *    [template.timezone]
     *    [template.storage_domain.id]
     *    [template.domain.name]
     *    [template.type]
     *    [template.stateless]
     *    [template.delete_protected]
     *    [template.sso.methods.method]
     *    [vm.rng_device.rate.bytes]
     *    [vm.rng_device.rate.period]
     *    [vm.rng_device.source]
     *    [template.console.enabled]
     *    [template.placement_policy.affinity]
     *    [template.description]
     *    [template.comment]
     *    [template.custom_properties.custom_property]
     *    [template.os.type]
     *    [template.os.boot]
     *    [template.cpu.topology.sockets]
     *    [template.cpu_shares]
     *    [template.cpu.architecture]
     *    [template.os.kernel]
     *    [template.display.type]
     *    [template.display.monitors]
     *    [vm.display.single_qxl_pci]
     *    [template.display.allow_override]
     *    [template.display.smartcard_enabled]
     *    [template.display.file_transfer_enabled]
     *    [template.display.copy_paste_enabled]
     *    [template.display.keyboard_layout]
     *    [template.os.initRd]
     *    [template.usb.enabled]
     *    [template.usb.type]
     *    [template.tunnel_migration]
     *    [template.migration_downtime]
     *    [template.virtio_scsi.enabled]
     *    [template.soundcard_enabled]
     *    [template.vm.disks.disk]
     *    [template.permissions.clone]
     *    [template.version.version_name]
     *    [template.version.base_template.id]
     *    [template.cpu.cpu_tune.vcpu_pin]
     *    [template.serial_number.policy]
     *    [template.serial_number.value]
     *    [template.bios.boot_menu.enabled]
     *    [template.cluster.id]
     *    [template.cluster.name]
     *    [template.cpu_profile.id]
     *    </pre>
     *
     * @return
     *     {@link Template }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public Template add(org.ovirt.engine.sdk.entities.Template template) throws
            ClientProtocolException, ServerException, IOException {
        String url = SLASH + getName();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().add(url, template,
                org.ovirt.engine.sdk.entities.Template.class,
                Template.class, headers);
    }
    /**
     * Adds Template object.
     *
     * @param template {@link org.ovirt.engine.sdk.entities.Template}
     *    <pre>
     *    template.vm.id|name
     *    template.name
     *    [template.memory]
     *    [template.cpu.topology.cores]
     *    [template.high_availability.enabled]
     *    [template.os.cmdline]
     *    [template.origin]
     *    [template.high_availability.priority]
     *    [template.timezone]
     *    [template.storage_domain.id]
     *    [template.domain.name]
     *    [template.type]
     *    [template.stateless]
     *    [template.delete_protected]
     *    [template.sso.methods.method]
     *    [vm.rng_device.rate.bytes]
     *    [vm.rng_device.rate.period]
     *    [vm.rng_device.source]
     *    [template.console.enabled]
     *    [template.placement_policy.affinity]
     *    [template.description]
     *    [template.comment]
     *    [template.custom_properties.custom_property]
     *    [template.os.type]
     *    [template.os.boot]
     *    [template.cpu.topology.sockets]
     *    [template.cpu_shares]
     *    [template.cpu.architecture]
     *    [template.os.kernel]
     *    [template.display.type]
     *    [template.display.monitors]
     *    [vm.display.single_qxl_pci]
     *    [template.display.allow_override]
     *    [template.display.smartcard_enabled]
     *    [template.display.file_transfer_enabled]
     *    [template.display.copy_paste_enabled]
     *    [template.display.keyboard_layout]
     *    [template.os.initRd]
     *    [template.usb.enabled]
     *    [template.usb.type]
     *    [template.tunnel_migration]
     *    [template.migration_downtime]
     *    [template.virtio_scsi.enabled]
     *    [template.soundcard_enabled]
     *    [template.vm.disks.disk]
     *    [template.permissions.clone]
     *    [template.version.version_name]
     *    [template.version.base_template.id]
     *    [template.cpu.cpu_tune.vcpu_pin]
     *    [template.serial_number.policy]
     *    [template.serial_number.value]
     *    [template.bios.boot_menu.enabled]
     *    [template.cluster.id]
     *    [template.cluster.name]
     *    [template.cpu_profile.id]
     *    </pre>
     *
     * @param expect
     *    <pre>
     *    [201-created]
     *    </pre>
     *
     * @return
     *     {@link Template }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public Template add(org.ovirt.engine.sdk.entities.Template template, String expect) throws
            ClientProtocolException, ServerException, IOException {
        String url = SLASH + getName();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        if (expect != null) {
            headersBuilder.add("Expect", expect);
        }
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().add(url, template,
                org.ovirt.engine.sdk.entities.Template.class,
                Template.class, headers);
    }
    /**
     * Adds Template object.
     *
     * @param template {@link org.ovirt.engine.sdk.entities.Template}
     *    <pre>
     *    template.vm.id|name
     *    template.name
     *    [template.memory]
     *    [template.cpu.topology.cores]
     *    [template.high_availability.enabled]
     *    [template.os.cmdline]
     *    [template.origin]
     *    [template.high_availability.priority]
     *    [template.timezone]
     *    [template.storage_domain.id]
     *    [template.domain.name]
     *    [template.type]
     *    [template.stateless]
     *    [template.delete_protected]
     *    [template.sso.methods.method]
     *    [vm.rng_device.rate.bytes]
     *    [vm.rng_device.rate.period]
     *    [vm.rng_device.source]
     *    [template.console.enabled]
     *    [template.placement_policy.affinity]
     *    [template.description]
     *    [template.comment]
     *    [template.custom_properties.custom_property]
     *    [template.os.type]
     *    [template.os.boot]
     *    [template.cpu.topology.sockets]
     *    [template.cpu_shares]
     *    [template.cpu.architecture]
     *    [template.os.kernel]
     *    [template.display.type]
     *    [template.display.monitors]
     *    [vm.display.single_qxl_pci]
     *    [template.display.allow_override]
     *    [template.display.smartcard_enabled]
     *    [template.display.file_transfer_enabled]
     *    [template.display.copy_paste_enabled]
     *    [template.display.keyboard_layout]
     *    [template.os.initRd]
     *    [template.usb.enabled]
     *    [template.usb.type]
     *    [template.tunnel_migration]
     *    [template.migration_downtime]
     *    [template.virtio_scsi.enabled]
     *    [template.soundcard_enabled]
     *    [template.vm.disks.disk]
     *    [template.permissions.clone]
     *    [template.version.version_name]
     *    [template.version.base_template.id]
     *    [template.cpu.cpu_tune.vcpu_pin]
     *    [template.serial_number.policy]
     *    [template.serial_number.value]
     *    [template.bios.boot_menu.enabled]
     *    [template.cluster.id]
     *    [template.cluster.name]
     *    [template.cpu_profile.id]
     *    </pre>
     *
     * @param expect
     *    <pre>
     *    [201-created]
     *    </pre>
     * @param correlationId
     *    <pre>
     *    [any string]
     *    </pre>
     *
     * @return
     *     {@link Template }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public Template add(org.ovirt.engine.sdk.entities.Template template, String expect, String correlationId) throws
            ClientProtocolException, ServerException, IOException {
        String url = SLASH + getName();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        if (expect != null) {
            headersBuilder.add("Expect", expect);
        }
        if (correlationId != null) {
            headersBuilder.add("Correlation-Id", correlationId);
        }
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().add(url, template,
                org.ovirt.engine.sdk.entities.Template.class,
                Template.class, headers);
    }

}

