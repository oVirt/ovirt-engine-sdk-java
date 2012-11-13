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

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.ovirt.engine.sdk.entities.Action;
import org.ovirt.engine.sdk.entities.KeyValuePair;
import org.ovirt.engine.sdk.entities.Response;
import org.ovirt.engine.sdk.exceptions.ServerException;
import org.ovirt.engine.sdk.utils.HttpHeaderUtils;
import org.ovirt.engine.sdk.web.HttpProxyBroker;

public class Vm extends org.ovirt.engine.sdk.entities.VM {

    private HttpProxyBroker proxy;
    private VmStatistics vmStatistics;

    public Vm(HttpProxyBroker proxy) {
        this.proxy = proxy;
    }

    private HttpProxyBroker getProxy() {
        return proxy;
    }

    public synchronized VmStatistics getVmStatistics() {
        if (this.vmStatistics == null) {
            this.vmStatistics = new VmStatistics(proxy, this);
        }
        return vmStatistics;
    }

    public Action start(Action holder) throws ClientProtocolException, ServerException, IOException, JAXBException {
        String url = this.getHref() + "/start";
        return getProxy().action(url, holder, Action.class, Action.class);
    }

    public Response delete() throws ClientProtocolException, ServerException, IOException, JAXBException {
        String url = this.getHref();
        return getProxy().delete(url, Response.class);
    }

    public Vm update() throws ClientProtocolException, ServerException, IOException, JAXBException {
        String url = this.getHref();
        return getProxy().update(url, this, org.ovirt.engine.sdk.entities.VM.class, Vm.class);
    }

    public Vm update(final String correlationId) throws ClientProtocolException, ServerException, IOException,
            JAXBException {
        String url = this.getHref();
        List<Header> headers = HttpHeaderUtils.toHeaders("Correlation-Id:" + correlationId);

        return getProxy().update(url, this, org.ovirt.engine.sdk.entities.VM.class, Vm.class, headers);
    }
}
