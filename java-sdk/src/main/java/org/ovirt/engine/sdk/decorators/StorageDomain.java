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
public class StorageDomain extends
        org.ovirt.engine.sdk.entities.StorageDomain {

    private HttpProxyBroker proxy;

    private StorageDomainPermissions storageDomainPermissions;
    private StorageDomainVMs storageDomainVMs;
    private StorageDomainTemplates storageDomainTemplates;
    private StorageDomainFiles storageDomainFiles;


    public StorageDomain(HttpProxyBroker proxy) {
        this.proxy = proxy;
    }

    private HttpProxyBroker getProxy() {
        return proxy;
    }

    public synchronized StorageDomainPermissions getStorageDomainPermissions() {
        if (this.storageDomainPermissions == null) {
            this.storageDomainPermissions = new StorageDomainPermissions(proxy, this);
        }
        return storageDomainPermissions;
    }

    public synchronized StorageDomainVMs getStorageDomainVMs() {
        if (this.storageDomainVMs == null) {
            this.storageDomainVMs = new StorageDomainVMs(proxy, this);
        }
        return storageDomainVMs;
    }

    public synchronized StorageDomainTemplates getStorageDomainTemplates() {
        if (this.storageDomainTemplates == null) {
            this.storageDomainTemplates = new StorageDomainTemplates(proxy, this);
        }
        return storageDomainTemplates;
    }

    public synchronized StorageDomainFiles getStorageDomainFiles() {
        if (this.storageDomainFiles == null) {
            this.storageDomainFiles = new StorageDomainFiles(proxy, this);
        }
        return storageDomainFiles;
    }



    public StorageDomain update() throws ClientProtocolException, ServerException, IOException, JAXBException {
        String url = this.getHref();
        return getProxy().update(url, this, org.ovirt.engine.sdk.entities.StorageDomain.class, StorageDomain.class);
    }
    public Response delete() throws ClientProtocolException, ServerException, IOException, JAXBException {
        String url = this.getHref();
        return getProxy().delete(url, Response.class);
    }

}

