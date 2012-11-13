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

import org.apache.http.client.ClientProtocolException;
import org.ovirt.engine.sdk.common.CollectionDecorator;
import org.ovirt.engine.sdk.exceptions.ServerException;
import org.ovirt.engine.sdk.utils.CollectionUtils;
import org.ovirt.engine.sdk.utils.UrlHelper;
import org.ovirt.engine.sdk.web.HttpProxyBroker;
import org.ovirt.engine.sdk.web.UrlParameterType;

public class Vms extends CollectionDecorator<org.ovirt.engine.sdk.entities.VM, org.ovirt.engine.sdk.entities.VMs, Vm> {

    public Vms(HttpProxyBroker proxy) {
        super(proxy);
    }

    @Override
    public List<Vm> list() throws ClientProtocolException, ServerException, IOException, JAXBException {
        String url = "/vms";
        return list(url, org.ovirt.engine.sdk.entities.VMs.class, Vm.class);
    }

    public List<Vm> list(String query) throws ClientProtocolException, ServerException, IOException, JAXBException {
        String url = "/vms" + UrlHelper.append(UrlParameterType.SEARCH, query);
        return list(url, org.ovirt.engine.sdk.entities.VMs.class, Vm.class);
    }

    @Override
    public Vm get(UUID id) throws ClientProtocolException, ServerException, IOException, JAXBException {
        String url = "/vms/" + id.toString();
        return getProxy().get(url, org.ovirt.engine.sdk.entities.VM.class, Vm.class);
    }

    @Override
    public Vm get(String name) throws ClientProtocolException, ServerException, IOException, JAXBException {
        List<Vm> collection = list("name=" + name);
        return CollectionUtils.getFirstItem(collection);
    }
}
