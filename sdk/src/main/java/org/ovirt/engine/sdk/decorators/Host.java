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
 * <p>Host providing relation and functional services
 * <p>to {@link org.ovirt.engine.sdk.entities.Host }.
 */
@SuppressWarnings("unused")
public class Host extends
        org.ovirt.engine.sdk.entities.Host {

    private HttpProxyBroker proxy;
    private final Object LOCK = new Object();

    private volatile HostAgents hostAgents;
    private volatile HostHooks hostHooks;
    private volatile HostHostDevices hostHostDevices;
    private volatile HostKatelloErrata hostKatelloErrata;
    private volatile HostNICs hostNICs;
    private volatile HostNetworkAttachments hostNetworkAttachments;
    private volatile HostNumaNodes hostNumaNodes;
    private volatile HostPermissions hostPermissions;
    private volatile HostStatistics hostStatistics;
    private volatile HostStorageConnectionExtensions hostStorageConnectionExtensions;
    private volatile HostStorages hostStorages;
    private volatile HostTags hostTags;
    private volatile HostUnmanagedNetworks hostUnmanagedNetworks;


    /**
     * @param proxy HttpProxyBroker
     */
    public Host(HttpProxyBroker proxy) {
        this.proxy = proxy;
    }

    /**
     * @return HttpProxyBroker
     */
    private HttpProxyBroker getProxy() {
        return proxy;
    }

    /**
     * Gets the value of the HostHostDevices property.
     *
     * @return
     *     {@link HostHostDevices }
     */
    public HostHostDevices getHostDevices() {
        if (this.hostHostDevices == null) {
            synchronized (this.LOCK) {
                if (this.hostHostDevices == null) {
                    this.hostHostDevices = new HostHostDevices(proxy, this);
                }
            }
        }
        return hostHostDevices;
    }
    /**
     * Gets the value of the HostAgents property.
     *
     * @return
     *     {@link HostAgents }
     */
    public HostAgents getAgents() {
        if (this.hostAgents == null) {
            synchronized (this.LOCK) {
                if (this.hostAgents == null) {
                    this.hostAgents = new HostAgents(proxy, this);
                }
            }
        }
        return hostAgents;
    }
    /**
     * Gets the value of the HostHooks property.
     *
     * @return
     *     {@link HostHooks }
     */
    public HostHooks getHooks() {
        if (this.hostHooks == null) {
            synchronized (this.LOCK) {
                if (this.hostHooks == null) {
                    this.hostHooks = new HostHooks(proxy, this);
                }
            }
        }
        return hostHooks;
    }
    /**
     * Gets the value of the HostKatelloErrata property.
     *
     * @return
     *     {@link HostKatelloErrata }
     */
    public HostKatelloErrata getKatelloErrata() {
        if (this.hostKatelloErrata == null) {
            synchronized (this.LOCK) {
                if (this.hostKatelloErrata == null) {
                    this.hostKatelloErrata = new HostKatelloErrata(proxy, this);
                }
            }
        }
        return hostKatelloErrata;
    }
    /**
     * Gets the value of the HostNetworkAttachments property.
     *
     * @return
     *     {@link HostNetworkAttachments }
     */
    public HostNetworkAttachments getNetworkAttachments() {
        if (this.hostNetworkAttachments == null) {
            synchronized (this.LOCK) {
                if (this.hostNetworkAttachments == null) {
                    this.hostNetworkAttachments = new HostNetworkAttachments(proxy, this);
                }
            }
        }
        return hostNetworkAttachments;
    }
    /**
     * Gets the value of the HostNICs property.
     *
     * @return
     *     {@link HostNICs }
     */
    public HostNICs getHostNics() {
        if (this.hostNICs == null) {
            synchronized (this.LOCK) {
                if (this.hostNICs == null) {
                    this.hostNICs = new HostNICs(proxy, this);
                }
            }
        }
        return hostNICs;
    }
    /**
     * Gets the value of the HostNumaNodes property.
     *
     * @return
     *     {@link HostNumaNodes }
     */
    public HostNumaNodes getNumaNodes() {
        if (this.hostNumaNodes == null) {
            synchronized (this.LOCK) {
                if (this.hostNumaNodes == null) {
                    this.hostNumaNodes = new HostNumaNodes(proxy, this);
                }
            }
        }
        return hostNumaNodes;
    }
    /**
     * Gets the value of the HostPermissions property.
     *
     * @return
     *     {@link HostPermissions }
     */
    public HostPermissions getPermissions() {
        if (this.hostPermissions == null) {
            synchronized (this.LOCK) {
                if (this.hostPermissions == null) {
                    this.hostPermissions = new HostPermissions(proxy, this);
                }
            }
        }
        return hostPermissions;
    }
    /**
     * Gets the value of the HostStatistics property.
     *
     * @return
     *     {@link HostStatistics }
     */
    public HostStatistics getStatistics() {
        if (this.hostStatistics == null) {
            synchronized (this.LOCK) {
                if (this.hostStatistics == null) {
                    this.hostStatistics = new HostStatistics(proxy, this);
                }
            }
        }
        return hostStatistics;
    }
    /**
     * Gets the value of the HostStorages property.
     *
     * @return
     *     {@link HostStorages }
     */
    public HostStorages getHostStorage() {
        if (this.hostStorages == null) {
            synchronized (this.LOCK) {
                if (this.hostStorages == null) {
                    this.hostStorages = new HostStorages(proxy, this);
                }
            }
        }
        return hostStorages;
    }
    /**
     * Gets the value of the HostStorageConnectionExtensions property.
     *
     * @return
     *     {@link HostStorageConnectionExtensions }
     */
    public HostStorageConnectionExtensions getStorageConnectionExtensions() {
        if (this.hostStorageConnectionExtensions == null) {
            synchronized (this.LOCK) {
                if (this.hostStorageConnectionExtensions == null) {
                    this.hostStorageConnectionExtensions = new HostStorageConnectionExtensions(proxy, this);
                }
            }
        }
        return hostStorageConnectionExtensions;
    }
    /**
     * Gets the value of the HostTags property.
     *
     * @return
     *     {@link HostTags }
     */
    public HostTags getTags() {
        if (this.hostTags == null) {
            synchronized (this.LOCK) {
                if (this.hostTags == null) {
                    this.hostTags = new HostTags(proxy, this);
                }
            }
        }
        return hostTags;
    }
    /**
     * Gets the value of the HostUnmanagedNetworks property.
     *
     * @return
     *     {@link HostUnmanagedNetworks }
     */
    public HostUnmanagedNetworks getUnmanagedNetworks() {
        if (this.hostUnmanagedNetworks == null) {
            synchronized (this.LOCK) {
                if (this.hostUnmanagedNetworks == null) {
                    this.hostUnmanagedNetworks = new HostUnmanagedNetworks(proxy, this);
                }
            }
        }
        return hostUnmanagedNetworks;
    }


    /**
     * Performs activate action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    [action.async]
     *    [action.grace_period.expiry]
     *    </pre>
     *
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
    public Action activate(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/activate";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs activate action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    [action.async]
     *    [action.grace_period.expiry]
     *    </pre>
     *
     * @param correlationId
     *    <pre>
     *    [any string]
     *    </pre>
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
    public Action activate(Action action, String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/activate";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        if (correlationId != null) {
            headersBuilder.add("Correlation-Id", correlationId);
        }
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs activate action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    [action.async]
     *    [action.grace_period.expiry]
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
    public Action activate(Action action, String correlationId, Boolean async) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/activate";

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
     * Performs approve action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    Overload 1:
     *
     *      approve specified host to be
     *      added to the engine by using
     *      root password (deprecated
     *      verb). this occurs when the
     *      host registers itself with the
     *      engine
     *
     *      [action.cluster.id|name]
     *      [host.root_password]
     *      [action.async]
     *      [action.grace_period.expiry]
     *
     *    Overload 2:
     *
     *      approve specified host to be
     *      added to the engine by using
     *      ssh authentication. this
     *      occurs when the host registers
     *      itself with the engine
     *
     *      [action.cluster.id|name]
     *      [host.ssh.authentication_method]
     *      [host.ssh.user.user_name]
     *      [host.ssh.user.password]
     *      [action.async]
     *      [action.grace_period.expiry]
     *    </pre>
     *
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
    public Action approve(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/approve";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs approve action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    Overload 1:
     *
     *      approve specified host to be
     *      added to the engine by using
     *      root password (deprecated
     *      verb). this occurs when the
     *      host registers itself with the
     *      engine
     *
     *      [action.cluster.id|name]
     *      [host.root_password]
     *      [action.async]
     *      [action.grace_period.expiry]
     *
     *    Overload 2:
     *
     *      approve specified host to be
     *      added to the engine by using
     *      ssh authentication. this
     *      occurs when the host registers
     *      itself with the engine
     *
     *      [action.cluster.id|name]
     *      [host.ssh.authentication_method]
     *      [host.ssh.user.user_name]
     *      [host.ssh.user.password]
     *      [action.async]
     *      [action.grace_period.expiry]
     *    </pre>
     *
     * @param correlationId
     *    <pre>
     *    [any string]
     *    </pre>
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
    public Action approve(Action action, String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/approve";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        if (correlationId != null) {
            headersBuilder.add("Correlation-Id", correlationId);
        }
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs approve action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    Overload 1:
     *
     *      approve specified host to be
     *      added to the engine by using
     *      root password (deprecated
     *      verb). this occurs when the
     *      host registers itself with the
     *      engine
     *
     *      [action.cluster.id|name]
     *      [host.root_password]
     *      [action.async]
     *      [action.grace_period.expiry]
     *
     *    Overload 2:
     *
     *      approve specified host to be
     *      added to the engine by using
     *      ssh authentication. this
     *      occurs when the host registers
     *      itself with the engine
     *
     *      [action.cluster.id|name]
     *      [host.ssh.authentication_method]
     *      [host.ssh.user.user_name]
     *      [host.ssh.user.password]
     *      [action.async]
     *      [action.grace_period.expiry]
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
    public Action approve(Action action, String correlationId, Boolean async) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/approve";

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
     * Performs commitnetconfig action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    [action.async]
     *    [action.grace_period.expiry]
     *    </pre>
     *
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
    public Action commitnetconfig(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/commitnetconfig";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs commitnetconfig action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    [action.async]
     *    [action.grace_period.expiry]
     *    </pre>
     *
     * @param correlationId
     *    <pre>
     *    [any string]
     *    </pre>
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
    public Action commitnetconfig(Action action, String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/commitnetconfig";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        if (correlationId != null) {
            headersBuilder.add("Correlation-Id", correlationId);
        }
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs commitnetconfig action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    [action.async]
     *    [action.grace_period.expiry]
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
    public Action commitnetconfig(Action action, String correlationId, Boolean async) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/commitnetconfig";

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
     * Performs deactivate action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    [action.reason]
     *    [action.async]
     *    [action.grace_period.expiry]
     *    </pre>
     *
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
    public Action deactivate(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/deactivate";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs deactivate action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    [action.reason]
     *    [action.async]
     *    [action.grace_period.expiry]
     *    </pre>
     *
     * @param correlationId
     *    <pre>
     *    [any string]
     *    </pre>
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
    public Action deactivate(Action action, String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/deactivate";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        if (correlationId != null) {
            headersBuilder.add("Correlation-Id", correlationId);
        }
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs deactivate action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    [action.reason]
     *    [action.async]
     *    [action.grace_period.expiry]
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
    public Action deactivate(Action action, String correlationId, Boolean async) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/deactivate";

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
     * @param async
     *    <pre>
     *    [true|false]
     *    </pre>
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
     * @param async
     *    <pre>
     *    [true|false]
     *    </pre>
     * @param correlationId
     *    <pre>
     *    [any string]
     *    </pre>
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
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    [action.async]
     *    [action.grace_period.expiry]
     *    </pre>
     *
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
    public Response delete(org.ovirt.engine.sdk.entities.Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().delete(url, action,
                org.ovirt.engine.sdk.entities.Action.class, Response.class, headers);
    }
    /**
     * Deletes object.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    [action.async]
     *    [action.grace_period.expiry]
     *    </pre>
     *
     * @param async
     *    <pre>
     *    [true|false]
     *    </pre>
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
    public Response delete(org.ovirt.engine.sdk.entities.Action action, Boolean async) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        if (async != null) {
            urlBuilder.add("async", async, UrlParameterType.MATRIX);
        }

        url = urlBuilder.build();

        return getProxy().delete(url, action,
                org.ovirt.engine.sdk.entities.Action.class, Response.class, headers);
    }
    /**
     * Deletes object.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    [action.async]
     *    [action.grace_period.expiry]
     *    </pre>
     *
     * @param async
     *    <pre>
     *    [true|false]
     *    </pre>
     * @param correlationId
     *    <pre>
     *    [any string]
     *    </pre>
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
    public Response delete(org.ovirt.engine.sdk.entities.Action action, Boolean async, String correlationId) throws ClientProtocolException,
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

        return getProxy().delete(url, action,
                org.ovirt.engine.sdk.entities.Action.class, Response.class, headers);
    }
    /**
     * Performs enrollcertificate action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
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
    public Action enrollcertificate(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/enrollcertificate";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs enrollcertificate action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     * @param async
     *    <pre>
     *    [true|false]
     *    </pre>
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
    public Action enrollcertificate(Action action, Boolean async) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/enrollcertificate";

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
     * Performs enrollcertificate action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     * @param async
     *    <pre>
     *    [true|false]
     *    </pre>
     * @param correlationId
     *    <pre>
     *    [any string]
     *    </pre>
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
    public Action enrollcertificate(Action action, Boolean async, String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/enrollcertificate";

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
     * Performs fence action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    action.fence_type
     *    [action.async]
     *    [action.grace_period.expiry]
     *    </pre>
     *
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
    public Action fence(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/fence";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs fence action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    action.fence_type
     *    [action.async]
     *    [action.grace_period.expiry]
     *    </pre>
     *
     * @param correlationId
     *    <pre>
     *    [any string]
     *    </pre>
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
    public Action fence(Action action, String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/fence";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        if (correlationId != null) {
            headersBuilder.add("Correlation-Id", correlationId);
        }
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs fence action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    action.fence_type
     *    [action.async]
     *    [action.grace_period.expiry]
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
    public Action fence(Action action, String correlationId, Boolean async) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/fence";

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
     * Performs forceselectspm action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    [action.async]
     *    [action.grace_period.expiry]
     *    </pre>
     *
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
    public Action forceselectspm(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/forceselectspm";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs forceselectspm action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    [action.async]
     *    [action.grace_period.expiry]
     *    </pre>
     *
     * @param correlationId
     *    <pre>
     *    [any string]
     *    </pre>
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
    public Action forceselectspm(Action action, String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/forceselectspm";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        if (correlationId != null) {
            headersBuilder.add("Correlation-Id", correlationId);
        }
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs forceselectspm action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    [action.async]
     *    [action.grace_period.expiry]
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
    public Action forceselectspm(Action action, String correlationId, Boolean async) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/forceselectspm";

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
     * Performs install action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    Overload 1:
     *
     *      install vdsm and other
     *      packages required to get the
     *      host ready to be used in the
     *      engine providing the root
     *      password. This has been
     *      deprecated
     *
     *      [action.root_password]
     *      [action.image]
     *      [action.host.override_iptables]
     *      [action.async]
     *      [action.grace_period.expiry]
     *
     *    Overload 2:
     *
     *      install vdsm and other
     *      packages required to get the
     *      host ready to be used in the
     *      engine providing the ssh
     *      password
     *
     *      [action.ssh.port]
     *      [action.ssh.fingerprint]
     *      [action.ssh.authentication_method]
     *      [action.ssh.user.user_name]
     *      [action.ssh.user.password]
     *      [action.image]
     *      [action.host.override_iptables]
     *      [action.async]
     *      [action.grace_period.expiry]
     *    </pre>
     *
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
    public Action install(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/install";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs install action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    Overload 1:
     *
     *      install vdsm and other
     *      packages required to get the
     *      host ready to be used in the
     *      engine providing the root
     *      password. This has been
     *      deprecated
     *
     *      [action.root_password]
     *      [action.image]
     *      [action.host.override_iptables]
     *      [action.async]
     *      [action.grace_period.expiry]
     *
     *    Overload 2:
     *
     *      install vdsm and other
     *      packages required to get the
     *      host ready to be used in the
     *      engine providing the ssh
     *      password
     *
     *      [action.ssh.port]
     *      [action.ssh.fingerprint]
     *      [action.ssh.authentication_method]
     *      [action.ssh.user.user_name]
     *      [action.ssh.user.password]
     *      [action.image]
     *      [action.host.override_iptables]
     *      [action.async]
     *      [action.grace_period.expiry]
     *    </pre>
     *
     * @param correlationId
     *    <pre>
     *    [any string]
     *    </pre>
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
    public Action install(Action action, String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/install";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        if (correlationId != null) {
            headersBuilder.add("Correlation-Id", correlationId);
        }
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs install action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    Overload 1:
     *
     *      install vdsm and other
     *      packages required to get the
     *      host ready to be used in the
     *      engine providing the root
     *      password. This has been
     *      deprecated
     *
     *      [action.root_password]
     *      [action.image]
     *      [action.host.override_iptables]
     *      [action.async]
     *      [action.grace_period.expiry]
     *
     *    Overload 2:
     *
     *      install vdsm and other
     *      packages required to get the
     *      host ready to be used in the
     *      engine providing the ssh
     *      password
     *
     *      [action.ssh.port]
     *      [action.ssh.fingerprint]
     *      [action.ssh.authentication_method]
     *      [action.ssh.user.user_name]
     *      [action.ssh.user.password]
     *      [action.image]
     *      [action.host.override_iptables]
     *      [action.async]
     *      [action.grace_period.expiry]
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
    public Action install(Action action, String correlationId, Boolean async) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/install";

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
     * Performs iscsidiscover action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    action.iscsi.address
     *    [action.async]
     *    [action.grace_period.expiry]
     *    </pre>
     *
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
    public Action iscsidiscover(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/iscsidiscover";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs iscsidiscover action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    action.iscsi.address
     *    [action.async]
     *    [action.grace_period.expiry]
     *    </pre>
     *
     * @param correlationId
     *    <pre>
     *    [any string]
     *    </pre>
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
    public Action iscsidiscover(Action action, String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/iscsidiscover";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        if (correlationId != null) {
            headersBuilder.add("Correlation-Id", correlationId);
        }
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs iscsidiscover action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    action.iscsi.address
     *    [action.async]
     *    [action.grace_period.expiry]
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
    public Action iscsidiscover(Action action, String correlationId, Boolean async) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/iscsidiscover";

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
     * Performs iscsilogin action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    action.iscsi.address
     *    action.iscsi.target
     *    [action.async]
     *    [action.grace_period.expiry]
     *    </pre>
     *
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
    public Action iscsilogin(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/iscsilogin";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs iscsilogin action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    action.iscsi.address
     *    action.iscsi.target
     *    [action.async]
     *    [action.grace_period.expiry]
     *    </pre>
     *
     * @param correlationId
     *    <pre>
     *    [any string]
     *    </pre>
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
    public Action iscsilogin(Action action, String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/iscsilogin";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        if (correlationId != null) {
            headersBuilder.add("Correlation-Id", correlationId);
        }
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs iscsilogin action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    action.iscsi.address
     *    action.iscsi.target
     *    [action.async]
     *    [action.grace_period.expiry]
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
    public Action iscsilogin(Action action, String correlationId, Boolean async) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/iscsilogin";

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
     * Performs refresh action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    [action.async]
     *    [action.grace_period.expiry]
     *    </pre>
     *
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
    public Action refresh(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/refresh";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs refresh action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    [action.async]
     *    [action.grace_period.expiry]
     *    </pre>
     *
     * @param async
     *    <pre>
     *    [true|false]
     *    </pre>
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
    public Action refresh(Action action, Boolean async) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/refresh";

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
     * Performs refresh action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    [action.async]
     *    [action.grace_period.expiry]
     *    </pre>
     *
     * @param async
     *    <pre>
     *    [true|false]
     *    </pre>
     * @param correlationId
     *    <pre>
     *    [any string]
     *    </pre>
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
    public Action refresh(Action action, Boolean async, String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/refresh";

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
     * Performs setupnetworks action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    [action.modified_network_attachments.network_attachment]
     *    [action.removed_network_attachments.network_attachment]
     *    [action.modified_bonds.host_nic]
     *    [action.removed_bonds.host_nic]
     *    [action.synchronized_network_attachments.network_attachment]
     *    [action.modified_labels.label]
     *    [action.removed_labels.label]
     *    [action.check_connectivity]
     *    [action.connectivity_timeout]
     *    [action.async]
     *    [action.grace_period.expiry]
     *    </pre>
     *
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
    public Action setupnetworks(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/setupnetworks";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs setupnetworks action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    [action.modified_network_attachments.network_attachment]
     *    [action.removed_network_attachments.network_attachment]
     *    [action.modified_bonds.host_nic]
     *    [action.removed_bonds.host_nic]
     *    [action.synchronized_network_attachments.network_attachment]
     *    [action.modified_labels.label]
     *    [action.removed_labels.label]
     *    [action.check_connectivity]
     *    [action.connectivity_timeout]
     *    [action.async]
     *    [action.grace_period.expiry]
     *    </pre>
     *
     * @param async
     *    <pre>
     *    [true|false]
     *    </pre>
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
    public Action setupnetworks(Action action, Boolean async) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/setupnetworks";

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
     * Performs setupnetworks action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    [action.modified_network_attachments.network_attachment]
     *    [action.removed_network_attachments.network_attachment]
     *    [action.modified_bonds.host_nic]
     *    [action.removed_bonds.host_nic]
     *    [action.synchronized_network_attachments.network_attachment]
     *    [action.modified_labels.label]
     *    [action.removed_labels.label]
     *    [action.check_connectivity]
     *    [action.connectivity_timeout]
     *    [action.async]
     *    [action.grace_period.expiry]
     *    </pre>
     *
     * @param async
     *    <pre>
     *    [true|false]
     *    </pre>
     * @param correlationId
     *    <pre>
     *    [any string]
     *    </pre>
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
    public Action setupnetworks(Action action, Boolean async, String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/setupnetworks";

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
     * Performs unregisteredstoragedomainsdiscover action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    [action.iscsi.address]
     *    [action.iscsi_target]
     *    [action.async]
     *    [action.grace_period.expiry]
     *    </pre>
     *
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
    public Action unregisteredstoragedomainsdiscover(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/unregisteredstoragedomainsdiscover";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs unregisteredstoragedomainsdiscover action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    [action.iscsi.address]
     *    [action.iscsi_target]
     *    [action.async]
     *    [action.grace_period.expiry]
     *    </pre>
     *
     * @param correlationId
     *    <pre>
     *    [any string]
     *    </pre>
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
    public Action unregisteredstoragedomainsdiscover(Action action, String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/unregisteredstoragedomainsdiscover";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        if (correlationId != null) {
            headersBuilder.add("Correlation-Id", correlationId);
        }
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs unregisteredstoragedomainsdiscover action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    [action.iscsi.address]
     *    [action.iscsi_target]
     *    [action.async]
     *    [action.grace_period.expiry]
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
    public Action unregisteredstoragedomainsdiscover(Action action, String correlationId, Boolean async) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/unregisteredstoragedomainsdiscover";

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
     * Updates Host object.
     *
     * @param host {@link org.ovirt.engine.sdk.entities.Host}
     *    <pre>
     *    Overload 1:
     *
     *      update the specified host in
     *      the system. This is deprecated
     *      and is provided only for
     *      backwards compatibility
     *
     *      [host.name]
     *      [host.comment]
     *      [host.address]
     *      [host.root_password]
     *      [host.display.address]
     *      [host.cluster.id|name]
     *      [host.port]
     *      [host.spm.priority]
     *      [host.power_management.type]
     *      [host.power_management.enabled]
     *      [host.power_management.address]
     *      [host.power_management.username]
     *      [host.power_management.password]
     *      [host.power_management.automatic_pm_enabled]
     *      [host.power_management.options.option]
     *      [host.power_management.pm_proxy]
     *      [host.power_management.agents.agent]
     *      [host.power_management.kdump_detection]
     *      [host.external_host_provider.id]
     *
     *    Overload 2:
     *
     *      update the specified host in the system
     *
     *      [host.name]
     *      [host.comment]
     *      [host.address]
     *      [host.ssh.port]
     *      [host.ssh.user.user_name]
     *      [host.ssh.fingerprint]
     *      [host.display.address]
     *      [host.cluster.id|name]
     *      [host.port]
     *      [host.spm.priority]
     *      [host.power_management.type]
     *      [host.power_management.automatic_pm_enabled]
     *      [host.power_management.enabled]
     *      [host.power_management.address]
     *      [host.power_management.username]
     *      [host.power_management.password]
     *      [host.power_management.options.option]
     *      [host.power_management.pm_proxy]
     *      [host.power_management.agents.agent]
     *      [host.power_management.kdump_detection]
     *    </pre>
     *
     *
     * @return
     *     {@link Host }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public Host update() throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().update(
                url,
                this,
                org.ovirt.engine.sdk.entities.Host.class,
                Host.class,
                headers);
    }
    /**
     * Updates Host object.
     *
     * @param host {@link org.ovirt.engine.sdk.entities.Host}
     *    <pre>
     *    Overload 1:
     *
     *      update the specified host in
     *      the system. This is deprecated
     *      and is provided only for
     *      backwards compatibility
     *
     *      [host.name]
     *      [host.comment]
     *      [host.address]
     *      [host.root_password]
     *      [host.display.address]
     *      [host.cluster.id|name]
     *      [host.port]
     *      [host.spm.priority]
     *      [host.power_management.type]
     *      [host.power_management.enabled]
     *      [host.power_management.address]
     *      [host.power_management.username]
     *      [host.power_management.password]
     *      [host.power_management.automatic_pm_enabled]
     *      [host.power_management.options.option]
     *      [host.power_management.pm_proxy]
     *      [host.power_management.agents.agent]
     *      [host.power_management.kdump_detection]
     *      [host.external_host_provider.id]
     *
     *    Overload 2:
     *
     *      update the specified host in the system
     *
     *      [host.name]
     *      [host.comment]
     *      [host.address]
     *      [host.ssh.port]
     *      [host.ssh.user.user_name]
     *      [host.ssh.fingerprint]
     *      [host.display.address]
     *      [host.cluster.id|name]
     *      [host.port]
     *      [host.spm.priority]
     *      [host.power_management.type]
     *      [host.power_management.automatic_pm_enabled]
     *      [host.power_management.enabled]
     *      [host.power_management.address]
     *      [host.power_management.username]
     *      [host.power_management.password]
     *      [host.power_management.options.option]
     *      [host.power_management.pm_proxy]
     *      [host.power_management.agents.agent]
     *      [host.power_management.kdump_detection]
     *    </pre>
     *
     * @param async
     *    <pre>
     *    [true|false]
     *    </pre>
     * @return
     *     {@link Host }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public Host update(Boolean async) throws ClientProtocolException,
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
                org.ovirt.engine.sdk.entities.Host.class,
                Host.class,
                headers);
    }
    /**
     * Updates Host object.
     *
     * @param host {@link org.ovirt.engine.sdk.entities.Host}
     *    <pre>
     *    Overload 1:
     *
     *      update the specified host in
     *      the system. This is deprecated
     *      and is provided only for
     *      backwards compatibility
     *
     *      [host.name]
     *      [host.comment]
     *      [host.address]
     *      [host.root_password]
     *      [host.display.address]
     *      [host.cluster.id|name]
     *      [host.port]
     *      [host.spm.priority]
     *      [host.power_management.type]
     *      [host.power_management.enabled]
     *      [host.power_management.address]
     *      [host.power_management.username]
     *      [host.power_management.password]
     *      [host.power_management.automatic_pm_enabled]
     *      [host.power_management.options.option]
     *      [host.power_management.pm_proxy]
     *      [host.power_management.agents.agent]
     *      [host.power_management.kdump_detection]
     *      [host.external_host_provider.id]
     *
     *    Overload 2:
     *
     *      update the specified host in the system
     *
     *      [host.name]
     *      [host.comment]
     *      [host.address]
     *      [host.ssh.port]
     *      [host.ssh.user.user_name]
     *      [host.ssh.fingerprint]
     *      [host.display.address]
     *      [host.cluster.id|name]
     *      [host.port]
     *      [host.spm.priority]
     *      [host.power_management.type]
     *      [host.power_management.automatic_pm_enabled]
     *      [host.power_management.enabled]
     *      [host.power_management.address]
     *      [host.power_management.username]
     *      [host.power_management.password]
     *      [host.power_management.options.option]
     *      [host.power_management.pm_proxy]
     *      [host.power_management.agents.agent]
     *      [host.power_management.kdump_detection]
     *    </pre>
     *
     * @param async
     *    <pre>
     *    [true|false]
     *    </pre>
     * @param correlationId
     *    <pre>
     *    [any string]
     *    </pre>
     * @return
     *     {@link Host }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public Host update(Boolean async, String correlationId) throws ClientProtocolException,
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
                org.ovirt.engine.sdk.entities.Host.class,
                Host.class,
                headers);
    }
    /**
     * Updates Host object.
     *
     * @param host {@link org.ovirt.engine.sdk.entities.Host}
     *    <pre>
     *    Overload 1:
     *
     *      update the specified host in
     *      the system. This is deprecated
     *      and is provided only for
     *      backwards compatibility
     *
     *      [host.name]
     *      [host.comment]
     *      [host.address]
     *      [host.root_password]
     *      [host.display.address]
     *      [host.cluster.id|name]
     *      [host.port]
     *      [host.spm.priority]
     *      [host.power_management.type]
     *      [host.power_management.enabled]
     *      [host.power_management.address]
     *      [host.power_management.username]
     *      [host.power_management.password]
     *      [host.power_management.automatic_pm_enabled]
     *      [host.power_management.options.option]
     *      [host.power_management.pm_proxy]
     *      [host.power_management.agents.agent]
     *      [host.power_management.kdump_detection]
     *      [host.external_host_provider.id]
     *
     *    Overload 2:
     *
     *      update the specified host in the system
     *
     *      [host.name]
     *      [host.comment]
     *      [host.address]
     *      [host.ssh.port]
     *      [host.ssh.user.user_name]
     *      [host.ssh.fingerprint]
     *      [host.display.address]
     *      [host.cluster.id|name]
     *      [host.port]
     *      [host.spm.priority]
     *      [host.power_management.type]
     *      [host.power_management.automatic_pm_enabled]
     *      [host.power_management.enabled]
     *      [host.power_management.address]
     *      [host.power_management.username]
     *      [host.power_management.password]
     *      [host.power_management.options.option]
     *      [host.power_management.pm_proxy]
     *      [host.power_management.agents.agent]
     *      [host.power_management.kdump_detection]
     *    </pre>
     *
     * @param async
     *    <pre>
     *    [true|false]
     *    </pre>
     * @param correlationId
     *    <pre>
     *    [any string]
     *    </pre>
     * @param expect
     *    <pre>
     *    [202-accepted]
     *    </pre>
     * @return
     *     {@link Host }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public Host update(Boolean async, String correlationId, String expect) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        if (correlationId != null) {
            headersBuilder.add("Correlation-Id", correlationId);
        }
        if (expect != null) {
            headersBuilder.add("Expect", expect);
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
                org.ovirt.engine.sdk.entities.Host.class,
                Host.class,
                headers);
    }
    /**
     * Performs upgrade action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    [action.image]
     *    [action.async]
     *    [action.grace_period.expiry]
     *    </pre>
     *
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
    public Action upgrade(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/upgrade";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs upgrade action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    [action.image]
     *    [action.async]
     *    [action.grace_period.expiry]
     *    </pre>
     *
     * @param async
     *    <pre>
     *    [true|false]
     *    </pre>
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
    public Action upgrade(Action action, Boolean async) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/upgrade";

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
     * Performs upgrade action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    [action.image]
     *    [action.async]
     *    [action.grace_period.expiry]
     *    </pre>
     *
     * @param async
     *    <pre>
     *    [true|false]
     *    </pre>
     * @param correlationId
     *    <pre>
     *    [any string]
     *    </pre>
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
    public Action upgrade(Action action, Boolean async, String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/upgrade";

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

}
