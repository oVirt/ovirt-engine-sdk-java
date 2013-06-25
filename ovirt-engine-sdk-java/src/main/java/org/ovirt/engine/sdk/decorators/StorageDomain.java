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

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.ovirt.engine.sdk.entities.Action;
import org.ovirt.engine.sdk.entities.Response;
import org.ovirt.engine.sdk.exceptions.ServerException;
import org.ovirt.engine.sdk.utils.HttpHeaderBuilder;
import org.ovirt.engine.sdk.utils.HttpHeaderUtils;
import org.ovirt.engine.sdk.utils.UrlBuilder;
import org.ovirt.engine.sdk.web.HttpProxyBroker;
import org.ovirt.engine.sdk.web.UrlParameterType;

/**
 * <p>StorageDomain providing relation and functional services
 * <p>to {@link org.ovirt.engine.sdk.entities.StorageDomain }.
 */
@SuppressWarnings("unused")
public class StorageDomain extends
        org.ovirt.engine.sdk.entities.StorageDomain {

    private HttpProxyBroker proxy;

    private StorageDomainPermissions storageDomainPermissions;
    private StorageDomainVMs storageDomainVMs;
    private StorageDomainTemplates storageDomainTemplates;
    private StorageDomainDisks storageDomainDisks;
    private StorageDomainFiles storageDomainFiles;


    /**
     * @param proxy HttpProxyBroker
     */
    public StorageDomain(HttpProxyBroker proxy) {
        this.proxy = proxy;
    }

    /**
     * @return HttpProxyBroker
     */
    private HttpProxyBroker getProxy() {
        return proxy;
    }

    /**
     * Gets the value of the StorageDomainPermissions property.
     *
     * @return
     *     {@link StorageDomainPermissions }
     */
    public synchronized StorageDomainPermissions getPermissions() {
        if (this.storageDomainPermissions == null) {
            this.storageDomainPermissions = new StorageDomainPermissions(proxy, this);
        }
        return storageDomainPermissions;
    }
    /**
     * Gets the value of the StorageDomainVMs property.
     *
     * @return
     *     {@link StorageDomainVMs }
     */
    public synchronized StorageDomainVMs getVMs() {
        if (this.storageDomainVMs == null) {
            this.storageDomainVMs = new StorageDomainVMs(proxy, this);
        }
        return storageDomainVMs;
    }
    /**
     * Gets the value of the StorageDomainTemplates property.
     *
     * @return
     *     {@link StorageDomainTemplates }
     */
    public synchronized StorageDomainTemplates getTemplates() {
        if (this.storageDomainTemplates == null) {
            this.storageDomainTemplates = new StorageDomainTemplates(proxy, this);
        }
        return storageDomainTemplates;
    }
    /**
     * Gets the value of the StorageDomainDisks property.
     *
     * @return
     *     {@link StorageDomainDisks }
     */
    public synchronized StorageDomainDisks getDisks() {
        if (this.storageDomainDisks == null) {
            this.storageDomainDisks = new StorageDomainDisks(proxy, this);
        }
        return storageDomainDisks;
    }
    /**
     * Gets the value of the StorageDomainFiles property.
     *
     * @return
     *     {@link StorageDomainFiles }
     */
    public synchronized StorageDomainFiles getFiles() {
        if (this.storageDomainFiles == null) {
            this.storageDomainFiles = new StorageDomainFiles(proxy, this);
        }
        return storageDomainFiles;
    }


    /**
     * Updates StorageDomain object.
     *
     * @param storagedomain {@link org.ovirt.engine.sdk.entities.StorageDomain}
     *    <pre>
     *    Overload 1:
     *      [storagedomain.name]
     *
     *    Overload 2:
     *      storagedomain.host.id|name
     *      storagedomain.storage.logical_unit
     *      [storagedomain.name]
     *      [storagedomain.storage.override_luns]
     *    </pre>
     *
     * @return
     *     {@link StorageDomain }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public StorageDomain update() throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref();
        return getProxy().update(url, this, org.ovirt.engine.sdk.entities.StorageDomain.class, StorageDomain.class);
    }
    /**
     * Deletes object.
     *
     * @return
     *     {@link Response }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public Response delete() throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref();

        List<Header> headers = new HttpHeaderBuilder()
                .build();

        url = new UrlBuilder(url)
                .build();

        return getProxy().delete(url, Response.class, headers);
    }
    /**
     * Deletes object.
     *
     * @param correlationId
     *    <pre>
     *    [any string]
     *    </pre>
     * @param async
     *    <pre>
     *    [true|false]
     *    </pre>
     *
     * @return
     *     {@link Response }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public Response delete(Boolean async, String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref();

        List<Header> headers = new HttpHeaderBuilder()
                .add("Correlation-Id", correlationId)
                .build();

        url = new UrlBuilder(url)
                .add("async", async, UrlParameterType.MATRIX)
                .build();

        return getProxy().delete(url, Response.class, headers);
    }
    /**
     * Deletes object.
     *
     * @param storagedomain {@link org.ovirt.engine.sdk.entities.StorageDomain}
     *    <pre>
     *    storagedomain.host.id|name
     *    [storagedomain.format]
     *    </pre>
     *
     * @param correlationId
     *    <pre>
     *    [any string]
     *    </pre>
     * @param async
     *    <pre>
     *    [true|false]
     *    </pre>
     *
     * @return
     *     {@link Response }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public Response delete(org.ovirt.engine.sdk.entities.StorageDomain storagedomain, Boolean async, String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref();

        List<Header> headers = new HttpHeaderBuilder()
                .add("Correlation-Id", correlationId)
                .build();

        url = new UrlBuilder(url)
                .add("async", async, UrlParameterType.MATRIX)
                .build();

        return getProxy().delete(url, storagedomain,
                org.ovirt.engine.sdk.entities.StorageDomain.class, Response.class, headers);
    }

}

