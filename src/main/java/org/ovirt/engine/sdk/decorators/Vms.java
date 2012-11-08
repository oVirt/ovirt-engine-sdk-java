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

import javax.xml.bind.JAXBException;

import org.apache.http.client.ClientProtocolException;
import org.ovirt.engine.api.model.VM;
import org.ovirt.engine.api.model.VMs;
import org.ovirt.engine.sdk.common.AbstractBackendCollection;
import org.ovirt.engine.sdk.exceptions.RequestException;
import org.ovirt.engine.sdk.web.HttpProxy;

public class Vms extends AbstractBackendCollection<VM, VMs> {

    private HttpProxy proxy;

    public Vms(HttpProxy proxy) {
        this.proxy = proxy;
    }

    @Override
    public List<VM> list() throws ClientProtocolException, RequestException, IOException, JAXBException {
        String url = "/vms";
        String xml = this.proxy.get(url);
        return unmarshallCollection(VMs.class, xml);
    }

    @Override
    public VM get(String id) throws ClientProtocolException, RequestException, IOException, JAXBException {
        String url = "/vms/" + id;
        String xml = this.proxy.get(url);
        return unmarshallResource(VM.class, xml);
    }
}
