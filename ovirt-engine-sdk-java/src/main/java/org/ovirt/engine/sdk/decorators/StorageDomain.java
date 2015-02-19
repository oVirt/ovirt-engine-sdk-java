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
    private final Object LOCK = new Object();

    private volatile StorageDomainPermissions storageDomainPermissions;
    private volatile StorageDomainVMs storageDomainVMs;
    private volatile StorageDomainTemplates storageDomainTemplates;
    private volatile StorageDomainStorageConnections storageDomainStorageConnections;
    private volatile StorageDomainDiskSnapshots storageDomainDiskSnapshots;
    private volatile StorageDomainDisks storageDomainDisks;
    private volatile StorageDomainImages storageDomainImages;
    private volatile StorageDomainFiles storageDomainFiles;
    private volatile StorageDomainDiskProfiles storageDomainDiskProfiles;


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
    public StorageDomainPermissions getPermissions() {
        if (this.storageDomainPermissions == null) {
            synchronized (this.LOCK) {
                if (this.storageDomainPermissions == null) {
                    this.storageDomainPermissions = new StorageDomainPermissions(proxy, this);
                }
            }
        }
        return storageDomainPermissions;
    }
    /**
     * Gets the value of the StorageDomainVMs property.
     *
     * @return
     *     {@link StorageDomainVMs }
     */
    public StorageDomainVMs getVMs() {
        if (this.storageDomainVMs == null) {
            synchronized (this.LOCK) {
                if (this.storageDomainVMs == null) {
                    this.storageDomainVMs = new StorageDomainVMs(proxy, this);
                }
            }
        }
        return storageDomainVMs;
    }
    /**
     * Gets the value of the StorageDomainTemplates property.
     *
     * @return
     *     {@link StorageDomainTemplates }
     */
    public StorageDomainTemplates getTemplates() {
        if (this.storageDomainTemplates == null) {
            synchronized (this.LOCK) {
                if (this.storageDomainTemplates == null) {
                    this.storageDomainTemplates = new StorageDomainTemplates(proxy, this);
                }
            }
        }
        return storageDomainTemplates;
    }
    /**
     * Gets the value of the StorageDomainStorageConnections property.
     *
     * @return
     *     {@link StorageDomainStorageConnections }
     */
    public StorageDomainStorageConnections getStorageConnections() {
        if (this.storageDomainStorageConnections == null) {
            synchronized (this.LOCK) {
                if (this.storageDomainStorageConnections == null) {
                    this.storageDomainStorageConnections = new StorageDomainStorageConnections(proxy, this);
                }
            }
        }
        return storageDomainStorageConnections;
    }
    /**
     * Gets the value of the StorageDomainDiskSnapshots property.
     *
     * @return
     *     {@link StorageDomainDiskSnapshots }
     */
    public StorageDomainDiskSnapshots getDiskSnapshots() {
        if (this.storageDomainDiskSnapshots == null) {
            synchronized (this.LOCK) {
                if (this.storageDomainDiskSnapshots == null) {
                    this.storageDomainDiskSnapshots = new StorageDomainDiskSnapshots(proxy, this);
                }
            }
        }
        return storageDomainDiskSnapshots;
    }
    /**
     * Gets the value of the StorageDomainDisks property.
     *
     * @return
     *     {@link StorageDomainDisks }
     */
    public StorageDomainDisks getDisks() {
        if (this.storageDomainDisks == null) {
            synchronized (this.LOCK) {
                if (this.storageDomainDisks == null) {
                    this.storageDomainDisks = new StorageDomainDisks(proxy, this);
                }
            }
        }
        return storageDomainDisks;
    }
    /**
     * Gets the value of the StorageDomainImages property.
     *
     * @return
     *     {@link StorageDomainImages }
     */
    public StorageDomainImages getImages() {
        if (this.storageDomainImages == null) {
            synchronized (this.LOCK) {
                if (this.storageDomainImages == null) {
                    this.storageDomainImages = new StorageDomainImages(proxy, this);
                }
            }
        }
        return storageDomainImages;
    }
    /**
     * Gets the value of the StorageDomainFiles property.
     *
     * @return
     *     {@link StorageDomainFiles }
     */
    public StorageDomainFiles getFiles() {
        if (this.storageDomainFiles == null) {
            synchronized (this.LOCK) {
                if (this.storageDomainFiles == null) {
                    this.storageDomainFiles = new StorageDomainFiles(proxy, this);
                }
            }
        }
        return storageDomainFiles;
    }
    /**
     * Gets the value of the StorageDomainDiskProfiles property.
     *
     * @return
     *     {@link StorageDomainDiskProfiles }
     */
    public StorageDomainDiskProfiles getDiskProfiles() {
        if (this.storageDomainDiskProfiles == null) {
            synchronized (this.LOCK) {
                if (this.storageDomainDiskProfiles == null) {
                    this.storageDomainDiskProfiles = new StorageDomainDiskProfiles(proxy, this);
                }
            }
        }
        return storageDomainDiskProfiles;
    }


    /**
     * Updates StorageDomain object.
     *
     * @param storagedomain {@link org.ovirt.engine.sdk.entities.StorageDomain}
     *    <pre>
     *    Overload 1:
     *
     *      update the storage domain
     *
     *      [storagedomain.name]
     *
     *    Overload 2:
     *
     *      update the storage domain
     *
     *      storagedomain.host.id|name
     *      storagedomain.storage.logical_unit
     *      [storagedomain.name]
     *      [storagedomain.comment]
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

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().update(
                url,
                this,
                org.ovirt.engine.sdk.entities.StorageDomain.class,
                StorageDomain.class,
                headers);
    }
    /**
     * Updates StorageDomain object.
     *
     * @param storagedomain {@link org.ovirt.engine.sdk.entities.StorageDomain}
     *    <pre>
     *    Overload 1:
     *
     *      update the storage domain
     *
     *      [storagedomain.name]
     *
     *    Overload 2:
     *
     *      update the storage domain
     *
     *      storagedomain.host.id|name
     *      storagedomain.storage.logical_unit
     *      [storagedomain.name]
     *      [storagedomain.comment]
     *      [storagedomain.storage.override_luns]
     *    </pre>
     *
     * @param async
     *    <pre>
     *    [true|false]
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
    public StorageDomain update(Boolean async) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        if (async != null) {
            urlBuilder.add("async", async, UrlParameterType.MATRIX);
        }
        url = urlBuilder.build();

        return getProxy().update(
                url,
                this,
                org.ovirt.engine.sdk.entities.StorageDomain.class,
                StorageDomain.class,
                headers);
    }
    /**
     * Updates StorageDomain object.
     *
     * @param storagedomain {@link org.ovirt.engine.sdk.entities.StorageDomain}
     *    <pre>
     *    Overload 1:
     *
     *      update the storage domain
     *
     *      [storagedomain.name]
     *
     *    Overload 2:
     *
     *      update the storage domain
     *
     *      storagedomain.host.id|name
     *      storagedomain.storage.logical_unit
     *      [storagedomain.name]
     *      [storagedomain.comment]
     *      [storagedomain.storage.override_luns]
     *    </pre>
     *
     * @param correlationId
     *    <pre>
     *    [any string]
     *    </pre>
     *
     * @param async
     *    <pre>
     *    [true|false]
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
    public StorageDomain update(Boolean async, String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        if (correlationId != null) {
            headersBuilder.add("Correlation-Id", correlationId);
        }
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        if (async != null) {
            urlBuilder.add("async", async, UrlParameterType.MATRIX);
        }
        url = urlBuilder.build();

        return getProxy().update(
                url,
                this,
                org.ovirt.engine.sdk.entities.StorageDomain.class,
                StorageDomain.class,
                headers);
    }
    /**
     * Performs isattached action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    action.host.id
     *    </pre>
     *
     * @return
     *     {@link Action }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public Action isattached(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/isattached";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs isattached action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    action.host.id
     *    </pre>
     *
     * @param async
     *    <pre>
     *    [true|false]
     *    </pre>
     *
     * @return
     *     {@link Action }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public Action isattached(Action action, Boolean async) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/isattached";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        if (async != null) {
            urlBuilder.add("async", async, UrlParameterType.MATRIX);
        }
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs isattached action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    action.host.id
     *    </pre>
     *
     * @param correlationId
     *    <pre>
     *    [any string]
     *    </pre>
     *
     * @param async
     *    <pre>
     *    [true|false]
     *    </pre>
     *
     * @return
     *     {@link Action }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public Action isattached(Action action, Boolean async, String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/isattached";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        if (correlationId != null) {
            headersBuilder.add("Correlation-Id", correlationId);
        }
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        if (async != null) {
            urlBuilder.add("async", async, UrlParameterType.MATRIX);
        }
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
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

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().delete(url, Response.class, headers);
    }
    /**
     * Deletes object.
     *
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
    public Response delete(Boolean async) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        if (async != null) {
            urlBuilder.add("async", async, UrlParameterType.MATRIX);
        }
        url = urlBuilder.build();

        return getProxy().delete(url, Response.class, headers);
    }
    /**
     * Deletes object.
     *
     * @param correlationId
     *    <pre>
     *    [any string]
     *    </pre>
     *
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

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        if (correlationId != null) {
            headersBuilder.add("Correlation-Id", correlationId);
        }
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        if (async != null) {
            urlBuilder.add("async", async, UrlParameterType.MATRIX);
        }
        url = urlBuilder.build();

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
    public Response delete(org.ovirt.engine.sdk.entities.StorageDomain storagedomain, Boolean async) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        if (async != null) {
            urlBuilder.add("async", async, UrlParameterType.MATRIX);
        }
        url = urlBuilder.build();

        return getProxy().delete(url, storagedomain,
                org.ovirt.engine.sdk.entities.StorageDomain.class, Response.class, headers);
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
     *
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

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        if (correlationId != null) {
            headersBuilder.add("Correlation-Id", correlationId);
        }
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        if (async != null) {
            urlBuilder.add("async", async, UrlParameterType.MATRIX);
        }
        url = urlBuilder.build();

        return getProxy().delete(url, storagedomain,
                org.ovirt.engine.sdk.entities.StorageDomain.class, Response.class, headers);
    }

}

