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
import org.ovirt.engine.api.model.VM;
import org.ovirt.engine.sdk.exceptions.ServerException;
import org.ovirt.engine.sdk.utils.Mapper;
import org.ovirt.engine.sdk.utils.SerializationHelper;
import org.ovirt.engine.sdk.web.HttpProxy;

public class Vm extends VM {

    HttpProxy proxy;

    public Vm(HttpProxy proxy) {
        this.proxy = proxy;
    }

    public Vm start(Action holder) throws ClientProtocolException, ServerException, IOException, JAXBException {
        String url = this.getHref() + "/start";
        String xmlReq = SerializationHelper.marshall(Action.class, holder);
        String xmlRes = this.proxy.action(url, xmlReq.toLowerCase());

        return Mapper.map(org.ovirt.engine.api.model.VM.class, Vm.class, xmlRes, this.proxy);
    }

    public Vm delete() throws ClientProtocolException, ServerException, IOException, JAXBException {
        String url = this.getHref();
        String xmlRes = this.proxy.delete(url);

        return Mapper.map(org.ovirt.engine.api.model.VM.class, Vm.class, xmlRes, this.proxy);
    }
}
