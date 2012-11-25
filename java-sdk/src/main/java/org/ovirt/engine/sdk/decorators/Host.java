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

@SuppressWarnings("unused")
public class Host extends
        org.ovirt.engine.sdk.entities.Host {

    private HttpProxyBroker proxy;

    private HostNICs hostNICs;
    private HostTags hostTags;
    private HostPermissions hostPermissions;
    private HostStatistics hostStatistics;


    public Host(HttpProxyBroker proxy) {
        this.proxy = proxy;
    }

    private HttpProxyBroker getProxy() {
        return proxy;
    }

    public synchronized HostNICs getHostNics() {
        if (this.hostNICs == null) {
            this.hostNICs = new HostNICs(proxy, this);
        }
        return hostNICs;
    }
    public synchronized HostTags getTags() {
        if (this.hostTags == null) {
            this.hostTags = new HostTags(proxy, this);
        }
        return hostTags;
    }
    public synchronized HostPermissions getPermissions() {
        if (this.hostPermissions == null) {
            this.hostPermissions = new HostPermissions(proxy, this);
        }
        return hostPermissions;
    }
    public synchronized HostStatistics getStatistics() {
        if (this.hostStatistics == null) {
            this.hostStatistics = new HostStatistics(proxy, this);
        }
        return hostStatistics;
    }


   public Action install(Action action) throws ClientProtocolException, ServerException, IOException, JAXBException {
        String url = this.getHref() + "/install";
        return getProxy().action(url, action, Action.class, Action.class);
    }
   public Action activate(Action action) throws ClientProtocolException, ServerException, IOException, JAXBException {
        String url = this.getHref() + "/activate";
        return getProxy().action(url, action, Action.class, Action.class);
    }
    public Host update() throws ClientProtocolException, ServerException, IOException, JAXBException {
        String url = this.getHref();
        return getProxy().update(url, this, org.ovirt.engine.sdk.entities.Host.class, Host.class);
    }
   public Action fence(Action action) throws ClientProtocolException, ServerException, IOException, JAXBException {
        String url = this.getHref() + "/fence";
        return getProxy().action(url, action, Action.class, Action.class);
    }
   public Action iscsidiscover(Action action) throws ClientProtocolException, ServerException, IOException, JAXBException {
        String url = this.getHref() + "/iscsidiscover";
        return getProxy().action(url, action, Action.class, Action.class);
    }
   public Action approve(Action action) throws ClientProtocolException, ServerException, IOException, JAXBException {
        String url = this.getHref() + "/approve";
        return getProxy().action(url, action, Action.class, Action.class);
    }
   public Action iscsilogin(Action action) throws ClientProtocolException, ServerException, IOException, JAXBException {
        String url = this.getHref() + "/iscsilogin";
        return getProxy().action(url, action, Action.class, Action.class);
    }
    public Response delete() throws ClientProtocolException, ServerException, IOException, JAXBException {
        String url = this.getHref();
        return getProxy().delete(url, Response.class);
    }
   public Action deactivate(Action action) throws ClientProtocolException, ServerException, IOException, JAXBException {
        String url = this.getHref() + "/deactivate";
        return getProxy().action(url, action, Action.class, Action.class);
    }
   public Action commitnetconfig(Action action) throws ClientProtocolException, ServerException, IOException, JAXBException {
        String url = this.getHref() + "/commitnetconfig";
        return getProxy().action(url, action, Action.class, Action.class);
    }

}

