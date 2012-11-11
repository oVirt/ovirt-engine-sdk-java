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

import javax.xml.bind.JAXBException;

import org.apache.http.client.ClientProtocolException;
import org.ovirt.engine.api.model.Action;
import org.ovirt.engine.api.model.Response;
import org.ovirt.engine.api.model.VM;
import org.ovirt.engine.sdk.exceptions.ServerException;
import org.ovirt.engine.sdk.web.HttpProxy;

public class Vm extends VM {

    private HttpProxy proxy;

    public Vm(HttpProxy proxy) {
        this.proxy = proxy;
    }

    private HttpProxy getProxy() {
        return proxy;
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

        return getProxy().update(url, this, VM.class, Vm.class);
    }
}
