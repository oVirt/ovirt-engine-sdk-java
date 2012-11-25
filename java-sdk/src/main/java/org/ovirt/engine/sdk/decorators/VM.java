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
import org.ovirt.engine.sdk.entities.Response;
import org.ovirt.engine.sdk.exceptions.ServerException;
import org.ovirt.engine.sdk.utils.HttpHeaderUtils;
import org.ovirt.engine.sdk.web.HttpProxyBroker;

public class VM extends
        org.ovirt.engine.sdk.entities.VM {

    private HttpProxyBroker proxy;

    private VMPermissions vMPermissions;
    private VMTags vMTags;
    private VMSnapshots vMSnapshots;
    private VMStatistics vMStatistics;
    private VMDisks vMDisks;
    private VMNICs vMNICs;
    private VMCdRoms vMCdRoms;


    public VM(HttpProxyBroker proxy) {
        this.proxy = proxy;
    }

    private HttpProxyBroker getProxy() {
        return proxy;
    }

    public synchronized VMPermissions getVMPermissions() {
        if (this.vMPermissions == null) {
            this.vMPermissions = new VMPermissions(proxy, this);
        }
        return vMPermissions;
    }

    public synchronized VMTags getVMTags() {
        if (this.vMTags == null) {
            this.vMTags = new VMTags(proxy, this);
        }
        return vMTags;
    }

    public synchronized VMSnapshots getVMSnapshots() {
        if (this.vMSnapshots == null) {
            this.vMSnapshots = new VMSnapshots(proxy, this);
        }
        return vMSnapshots;
    }

    public synchronized VMStatistics getVMStatistics() {
        if (this.vMStatistics == null) {
            this.vMStatistics = new VMStatistics(proxy, this);
        }
        return vMStatistics;
    }

    public synchronized VMDisks getVMDisks() {
        if (this.vMDisks == null) {
            this.vMDisks = new VMDisks(proxy, this);
        }
        return vMDisks;
    }

    public synchronized VMNICs getVMNICs() {
        if (this.vMNICs == null) {
            this.vMNICs = new VMNICs(proxy, this);
        }
        return vMNICs;
    }

    public synchronized VMCdRoms getVMCdRoms() {
        if (this.vMCdRoms == null) {
            this.vMCdRoms = new VMCdRoms(proxy, this);
        }
        return vMCdRoms;
    }



   public Action suspend(Action action) throws ClientProtocolException, ServerException, IOException, JAXBException {
        String url = this.getHref() + "/suspend";
        return getProxy().action(url, action, Action.class, Action.class);
    }

   public Action stop(Action action) throws ClientProtocolException, ServerException, IOException, JAXBException {
        String url = this.getHref() + "/stop";
        return getProxy().action(url, action, Action.class, Action.class);
    }

   public Action cancelmigration(Action action) throws ClientProtocolException, ServerException, IOException, JAXBException {
        String url = this.getHref() + "/cancelmigration";
        return getProxy().action(url, action, Action.class, Action.class);
    }

   public Action export(Action action) throws ClientProtocolException, ServerException, IOException, JAXBException {
        String url = this.getHref() + "/export";
        return getProxy().action(url, action, Action.class, Action.class);
    }

   public Action detach(Action action) throws ClientProtocolException, ServerException, IOException, JAXBException {
        String url = this.getHref() + "/detach";
        return getProxy().action(url, action, Action.class, Action.class);
    }

   public Action ticket(Action action) throws ClientProtocolException, ServerException, IOException, JAXBException {
        String url = this.getHref() + "/ticket";
        return getProxy().action(url, action, Action.class, Action.class);
    }

   public Action start(Action action) throws ClientProtocolException, ServerException, IOException, JAXBException {
        String url = this.getHref() + "/start";
        return getProxy().action(url, action, Action.class, Action.class);
    }

   public Action migrate(Action action) throws ClientProtocolException, ServerException, IOException, JAXBException {
        String url = this.getHref() + "/migrate";
        return getProxy().action(url, action, Action.class, Action.class);
    }

   public Action move(Action action) throws ClientProtocolException, ServerException, IOException, JAXBException {
        String url = this.getHref() + "/move";
        return getProxy().action(url, action, Action.class, Action.class);
    }

   public Action shutdown(Action action) throws ClientProtocolException, ServerException, IOException, JAXBException {
        String url = this.getHref() + "/shutdown";
        return getProxy().action(url, action, Action.class, Action.class);
    }


}

