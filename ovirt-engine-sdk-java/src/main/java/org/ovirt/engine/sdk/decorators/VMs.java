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
import org.ovirt.engine.sdk.utils.HttpHeaderUtils;
import org.ovirt.engine.sdk.utils.UrlBuilder;
import org.ovirt.engine.sdk.utils.UrlHelper;
import org.ovirt.engine.sdk.web.HttpProxyBroker;
import org.ovirt.engine.sdk.web.UrlParameterType;
import org.ovirt.engine.sdk.entities.Action;

/**
 * <p>VMs providing relation and functional services
 * <p>to {@link org.ovirt.engine.sdk.entities.VMs } .
 */
@SuppressWarnings("unused")
public class VMs extends
        CollectionDecorator<org.ovirt.engine.sdk.entities.VM, 
                            org.ovirt.engine.sdk.entities.VMs, 
                            VM> {

    /**
     * @param proxy HttpProxyBroker
     */
    public VMs(HttpProxyBroker proxy) {
        super(proxy, "vms");
    }

    /**
     * Lists VM objects.
     *
     * @return
     *     List of {@link VM }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    @Override
    public List<VM> list() throws ClientProtocolException,
            ServerException, IOException {
        String url = SLASH + getName();
        return list(url, org.ovirt.engine.sdk.entities.VMs.class, VM.class);
    }

    /**
     * Fetches VM object by id.
     *
     * @return {@link VM }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    @Override
    public VM get(UUID id) throws ClientProtocolException,
            ServerException, IOException {
        String url = SLASH + getName() + SLASH + id.toString();
        return getProxy().get(url, org.ovirt.engine.sdk.entities.VM.class, VM.class);
    }

    /**
     * Lists VM objects.
     *
     * @param query
     *            search query
     * @param caseSensitive
     *            true|false
     * @param max
     *            max results
     *
     * @return List of {@link VM }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public List<VM> list(String query, Boolean caseSensitive, Integer max) throws ClientProtocolException,
            ServerException, IOException {
        String url = new UrlBuilder(SLASH + getName())
                .add("search", query, UrlParameterType.QUERY)
                .add("case_sensitive", caseSensitive, UrlParameterType.MATRIX)
                .add("max", max, UrlParameterType.MATRIX)
                .build();
        return list(url, org.ovirt.engine.sdk.entities.VMs.class, VM.class);
    }

    /**
     * Adds VM object.
     *
     * @param vm
     *
     * <pre>
     * vm.name
     * vm.template.id|name
     * vm.cluster.id|name
     * [vm.quota.id]
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
     * [vm.disks.clone]
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
    public VM add(org.ovirt.engine.sdk.entities.VM vm) throws 
            ClientProtocolException, ServerException, IOException {
        String url = SLASH + getName();
        return getProxy().add(url, vm, org.ovirt.engine.sdk.entities.VM.class, VM.class);
    }

}

