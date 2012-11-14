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

package org.ovirt.engine.sdk.decorators;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.xml.bind.JAXBException;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.ovirt.engine.sdk.common.CollectionDecorator;
import org.ovirt.engine.sdk.entities.NIC;
import org.ovirt.engine.sdk.exceptions.ServerException;
import org.ovirt.engine.sdk.utils.CollectionUtils;
import org.ovirt.engine.sdk.utils.HttpHeaderUtils;
import org.ovirt.engine.sdk.utils.UrlHelper;
import org.ovirt.engine.sdk.web.HttpProxyBroker;
import org.ovirt.engine.sdk.web.UrlParameterType;

public class VmNics extends CollectionDecorator<org.ovirt.engine.sdk.entities.NIC, org.ovirt.engine.sdk.entities.Nics, VmNic> {

    private Vm parent;

    public VmNics(HttpProxyBroker proxy, Vm parent) {
        super(proxy);
        this.parent = parent;
    }

    @Override
    public List<VmNic> list() throws ClientProtocolException, ServerException, IOException, JAXBException {
        String url = "/vms/" + this.parent.getId() + "/nics";
        return list(url, org.ovirt.engine.sdk.entities.Nics.class, VmNic.class);
    }

    public List<VmNic> list(int max) throws ClientProtocolException, ServerException, IOException, JAXBException {
        String url = "/vms/" + this.parent.getId() + "/nics"
                        + UrlHelper.append(UrlParameterType.MATRIX, "max=" + String.valueOf(max));
        return list(url, org.ovirt.engine.sdk.entities.Nics.class, VmNic.class);
    }

    @Override
    public VmNic get(UUID id) throws ClientProtocolException, ServerException, IOException, JAXBException {
        String url = "/vms/" + this.parent.getId() + "/nics/" + id.toString();
        return getProxy().get(url, org.ovirt.engine.sdk.entities.NIC.class, VmNic.class);
    }

    @Override
    public VmNic get(String name) throws ClientProtocolException, ServerException, IOException, JAXBException {
        List<VmNic> collection = list();
        return CollectionUtils.getItemByName(name, collection);
    }

    public VmNic add(NIC nic) throws ClientProtocolException, ServerException, IOException, JAXBException {
        String url = "/vms/" + this.parent.getId() + "/nics";
        return getProxy().add(url, nic, NIC.class, VmNic.class);
    }

    public VmNic add(NIC nic, String correlationId, String expect) throws ClientProtocolException, ServerException,
            IOException,
            JAXBException {
        String url = "/vms/" + this.parent.getId() + "/nics";
        List<Header> headers = HttpHeaderUtils.toHeaders("Correlation-Id:" + correlationId,
                "Expect:" + expect);
        return getProxy().add(url, nic, NIC.class, VmNic.class, headers);
    }
}
