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
 * <p>Vm providing relation and functional services
 * <p>to {@link org.ovirt.engine.sdk.entities.Vm }.
 */
@SuppressWarnings("unused")
public class Vm extends
        org.ovirt.engine.sdk.entities.Vm {

    private HttpProxyBroker proxy;
    private final Object LOCK = new Object();

    private volatile VmApplications vmApplications;
    private volatile VmCdroms vmCdroms;
    private volatile VmDisks vmDisks;
    private volatile VmGraphicsConsoles vmGraphicsConsoles;
    private volatile VmHostDevices vmHostDevices;
    private volatile VmKatelloErrata vmKatelloErrata;
    private volatile VmNics vmNics;
    private volatile VmPermissions vmPermissions;
    private volatile VmReportedDevices vmReportedDevices;
    private volatile VmSessions vmSessions;
    private volatile VmSnapshots vmSnapshots;
    private volatile VmStatistics vmStatistics;
    private volatile VmTags vmTags;
    private volatile VmVirtualNumaNodes vmVirtualNumaNodes;
    private volatile VmWatchdogs vmWatchdogs;


    /**
     * @param proxy HttpProxyBroker
     */
    public Vm(HttpProxyBroker proxy) {
        this.proxy = proxy;
    }

    /**
     * @return HttpProxyBroker
     */
    private HttpProxyBroker getProxy() {
        return proxy;
    }

    /**
     * Gets the value of the VmApplications property.
     *
     * @return
     *     {@link VmApplications }
     */
    public VmApplications getApplications() {
        if (this.vmApplications == null) {
            synchronized (this.LOCK) {
                if (this.vmApplications == null) {
                    this.vmApplications = new VmApplications(proxy, this);
                }
            }
        }
        return vmApplications;
    }
    /**
     * Gets the value of the VmCdroms property.
     *
     * @return
     *     {@link VmCdroms }
     */
    public VmCdroms getCdroms() {
        if (this.vmCdroms == null) {
            synchronized (this.LOCK) {
                if (this.vmCdroms == null) {
                    this.vmCdroms = new VmCdroms(proxy, this);
                }
            }
        }
        return vmCdroms;
    }
    /**
     * Gets the value of the VmDisks property.
     *
     * @return
     *     {@link VmDisks }
     */
    public VmDisks getDisks() {
        if (this.vmDisks == null) {
            synchronized (this.LOCK) {
                if (this.vmDisks == null) {
                    this.vmDisks = new VmDisks(proxy, this);
                }
            }
        }
        return vmDisks;
    }
    /**
     * Gets the value of the VmGraphicsConsoles property.
     *
     * @return
     *     {@link VmGraphicsConsoles }
     */
    public VmGraphicsConsoles getGraphicsConsoles() {
        if (this.vmGraphicsConsoles == null) {
            synchronized (this.LOCK) {
                if (this.vmGraphicsConsoles == null) {
                    this.vmGraphicsConsoles = new VmGraphicsConsoles(proxy, this);
                }
            }
        }
        return vmGraphicsConsoles;
    }
    /**
     * Gets the value of the VmHostDevices property.
     *
     * @return
     *     {@link VmHostDevices }
     */
    public VmHostDevices getHostDevices() {
        if (this.vmHostDevices == null) {
            synchronized (this.LOCK) {
                if (this.vmHostDevices == null) {
                    this.vmHostDevices = new VmHostDevices(proxy, this);
                }
            }
        }
        return vmHostDevices;
    }
    /**
     * Gets the value of the VmKatelloErrata property.
     *
     * @return
     *     {@link VmKatelloErrata }
     */
    public VmKatelloErrata getKatelloErrata() {
        if (this.vmKatelloErrata == null) {
            synchronized (this.LOCK) {
                if (this.vmKatelloErrata == null) {
                    this.vmKatelloErrata = new VmKatelloErrata(proxy, this);
                }
            }
        }
        return vmKatelloErrata;
    }
    /**
     * Gets the value of the VmNics property.
     *
     * @return
     *     {@link VmNics }
     */
    public VmNics getNics() {
        if (this.vmNics == null) {
            synchronized (this.LOCK) {
                if (this.vmNics == null) {
                    this.vmNics = new VmNics(proxy, this);
                }
            }
        }
        return vmNics;
    }
    /**
     * Gets the value of the VmVirtualNumaNodes property.
     *
     * @return
     *     {@link VmVirtualNumaNodes }
     */
    public VmVirtualNumaNodes getVirtualNumaNodes() {
        if (this.vmVirtualNumaNodes == null) {
            synchronized (this.LOCK) {
                if (this.vmVirtualNumaNodes == null) {
                    this.vmVirtualNumaNodes = new VmVirtualNumaNodes(proxy, this);
                }
            }
        }
        return vmVirtualNumaNodes;
    }
    /**
     * Gets the value of the VmPermissions property.
     *
     * @return
     *     {@link VmPermissions }
     */
    public VmPermissions getPermissions() {
        if (this.vmPermissions == null) {
            synchronized (this.LOCK) {
                if (this.vmPermissions == null) {
                    this.vmPermissions = new VmPermissions(proxy, this);
                }
            }
        }
        return vmPermissions;
    }
    /**
     * Gets the value of the VmReportedDevices property.
     *
     * @return
     *     {@link VmReportedDevices }
     */
    public VmReportedDevices getReportedDevices() {
        if (this.vmReportedDevices == null) {
            synchronized (this.LOCK) {
                if (this.vmReportedDevices == null) {
                    this.vmReportedDevices = new VmReportedDevices(proxy, this);
                }
            }
        }
        return vmReportedDevices;
    }
    /**
     * Gets the value of the VmSessions property.
     *
     * @return
     *     {@link VmSessions }
     */
    public VmSessions getSessions() {
        if (this.vmSessions == null) {
            synchronized (this.LOCK) {
                if (this.vmSessions == null) {
                    this.vmSessions = new VmSessions(proxy, this);
                }
            }
        }
        return vmSessions;
    }
    /**
     * Gets the value of the VmSnapshots property.
     *
     * @return
     *     {@link VmSnapshots }
     */
    public VmSnapshots getSnapshots() {
        if (this.vmSnapshots == null) {
            synchronized (this.LOCK) {
                if (this.vmSnapshots == null) {
                    this.vmSnapshots = new VmSnapshots(proxy, this);
                }
            }
        }
        return vmSnapshots;
    }
    /**
     * Gets the value of the VmStatistics property.
     *
     * @return
     *     {@link VmStatistics }
     */
    public VmStatistics getStatistics() {
        if (this.vmStatistics == null) {
            synchronized (this.LOCK) {
                if (this.vmStatistics == null) {
                    this.vmStatistics = new VmStatistics(proxy, this);
                }
            }
        }
        return vmStatistics;
    }
    /**
     * Gets the value of the VmTags property.
     *
     * @return
     *     {@link VmTags }
     */
    public VmTags getTags() {
        if (this.vmTags == null) {
            synchronized (this.LOCK) {
                if (this.vmTags == null) {
                    this.vmTags = new VmTags(proxy, this);
                }
            }
        }
        return vmTags;
    }
    /**
     * Gets the value of the VmWatchdogs property.
     *
     * @return
     *     {@link VmWatchdogs }
     */
    public VmWatchdogs getWatchdogs() {
        if (this.vmWatchdogs == null) {
            synchronized (this.LOCK) {
                if (this.vmWatchdogs == null) {
                    this.vmWatchdogs = new VmWatchdogs(proxy, this);
                }
            }
        }
        return vmWatchdogs;
    }


    /**
     * Performs cancelmigration action.
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
    public Action cancelmigration(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/cancelmigration";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs cancelmigration action.
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
    public Action cancelmigration(Action action, Boolean async) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/cancelmigration";

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
     * Performs clone action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    action.vm.name
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
    public Action clone(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/clone";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs clone action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    action.vm.name
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
    public Action clone(Action action, Boolean async) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/clone";

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
     * Performs clone action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    action.vm.name
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
    public Action clone(Action action, Boolean async, String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/clone";

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
     * Performs commit_snapshot action.
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
    public Action commit_snapshot(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/commit_snapshot";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs commit_snapshot action.
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
    public Action commit_snapshot(Action action, Boolean async) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/commit_snapshot";

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
     * Performs commit_snapshot action.
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
    public Action commit_snapshot(Action action, Boolean async, String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/commit_snapshot";

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
     * @param async
     *    <pre>
     *    [true|false]
     *    </pre>
     * @param correlationId
     *    <pre>
     *    [any string]
     *    </pre>
     * @param detachOnly
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
    public Response delete(Boolean async, String correlationId, Boolean detachOnly) throws ClientProtocolException,
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

        if (detachOnly != null) {
            urlBuilder.add("detach_only", detachOnly, UrlParameterType.MATRIX);
        }

        url = urlBuilder.build();

        return getProxy().delete(url, Response.class, headers);
    }
    /**
     * Deletes object.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    [action.force]
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
     *    [action.force]
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
     *    [action.force]
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
     * Deletes object.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    [action.force]
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
     * @param detachOnly
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
    public Response delete(org.ovirt.engine.sdk.entities.Action action, Boolean async, String correlationId, Boolean detachOnly) throws ClientProtocolException,
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

        if (detachOnly != null) {
            urlBuilder.add("detach_only", detachOnly, UrlParameterType.MATRIX);
        }

        url = urlBuilder.build();

        return getProxy().delete(url, action,
                org.ovirt.engine.sdk.entities.Action.class, Response.class, headers);
    }
    /**
     * Performs detach action.
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
    public Action detach(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/detach";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs detach action.
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
    public Action detach(Action action, Boolean async) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/detach";

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
     * Performs detach action.
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
    public Action detach(Action action, Boolean async, String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/detach";

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
     * Performs exportVm action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    [action.exclusive]
     *    [action.discard_snapshots]
     *    [action.storage_domain.id|name]
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
    public Action exportVm(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/export";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs exportVm action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    [action.exclusive]
     *    [action.discard_snapshots]
     *    [action.storage_domain.id|name]
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
    public Action exportVm(Action action, Boolean async) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/export";

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
     * Performs exportVm action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    [action.exclusive]
     *    [action.discard_snapshots]
     *    [action.storage_domain.id|name]
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
    public Action exportVm(Action action, Boolean async, String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/export";

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
     * Performs freezefilesystems action.
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
    public Action freezefilesystems(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/freezefilesystems";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs freezefilesystems action.
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
    public Action freezefilesystems(Action action, Boolean async) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/freezefilesystems";

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
     * Performs freezefilesystems action.
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
    public Action freezefilesystems(Action action, Boolean async, String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/freezefilesystems";

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
     * Performs logon action.
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
    public Action logon(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/logon";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs logon action.
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
    public Action logon(Action action, Boolean async) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/logon";

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
     * Performs logon action.
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
    public Action logon(Action action, Boolean async, String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/logon";

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
     * Performs maintenance action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    action.maintenance_enabled
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
    public Action maintenance(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/maintenance";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs maintenance action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    action.maintenance_enabled
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
    public Action maintenance(Action action, Boolean async) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/maintenance";

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
     * Performs maintenance action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    action.maintenance_enabled
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
    public Action maintenance(Action action, Boolean async, String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/maintenance";

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
     * Performs migrate action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    [action.host.id|name]
     *    [action.force]
     *    [action.cluster.id]
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
    public Action migrate(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/migrate";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs migrate action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    [action.host.id|name]
     *    [action.force]
     *    [action.cluster.id]
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
    public Action migrate(Action action, Boolean async) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/migrate";

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
     * Performs migrate action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    [action.host.id|name]
     *    [action.force]
     *    [action.cluster.id]
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
    public Action migrate(Action action, Boolean async, String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/migrate";

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
     * Performs move action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    action.storage_domain.id|name
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
    public Action move(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/move";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs move action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    action.storage_domain.id|name
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
    public Action move(Action action, Boolean async) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/move";

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
     * Performs move action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    action.storage_domain.id|name
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
    public Action move(Action action, Boolean async, String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/move";

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
     * Performs preview_snapshot action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    action.snapshot.id
     *    [action.restore_memory]
     *    [action.disks.disk]
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
    public Action preview_snapshot(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/preview_snapshot";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs preview_snapshot action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    action.snapshot.id
     *    [action.restore_memory]
     *    [action.disks.disk]
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
    public Action preview_snapshot(Action action, Boolean async) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/preview_snapshot";

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
     * Performs preview_snapshot action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    action.snapshot.id
     *    [action.restore_memory]
     *    [action.disks.disk]
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
    public Action preview_snapshot(Action action, Boolean async, String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/preview_snapshot";

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
     * Performs reboot action.
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
    public Action reboot(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/reboot";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs reboot action.
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
    public Action reboot(Action action, Boolean async) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/reboot";

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
     * Performs reboot action.
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
    public Action reboot(Action action, Boolean async, String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/reboot";

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
     * Performs reordermacaddresses action.
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
    public Action reordermacaddresses(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/reordermacaddresses";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs reordermacaddresses action.
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
    public Action reordermacaddresses(Action action, Boolean async) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/reordermacaddresses";

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
     * Performs reordermacaddresses action.
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
    public Action reordermacaddresses(Action action, Boolean async, String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/reordermacaddresses";

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
     * Performs shutdown action.
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
    public Action shutdown(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/shutdown";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs shutdown action.
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
    public Action shutdown(Action action, Boolean async) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/shutdown";

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
     * Performs shutdown action.
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
    public Action shutdown(Action action, Boolean async, String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/shutdown";

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
     * Performs start action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    [action.vm.os.initRd]
     *    [action.vm.domain.name]
     *    [action.vm.placement_policy.hosts.host]
     *    [action.vm.placement_policy.affinity]
     *    [action.vm.os.kernel]
     *    [action.vm.display.type]
     *    [action.vm.stateless]
     *    [action.vm.os.cmdline]
     *    [action.vm.domain.user.username]
     *    [action.pause]
     *    [action.vm.os.boot.devices.device]
     *    [action.vm.domain.user.password]
     *    [action.vm.initialization.cloud_init.host.address]
     *    [action.vm.custom_emulated_machine]
     *    [action.vm.custom_cpu_model]
     *    [action.vm.initialization.cloud_init.network_configuration.nics.nic]
     *    [action.vm.initialization.cloud_init.network_configuration.dns.servers.host]
     *    [action.vm.initialization.cloud_init.network_configuration.dns.search_domains.host]
     *    [action.vm.initialization.cloud_init.authorized_keys.authorized_key]
     *    [authorized_key.user.name]
     *    [action.vm.initialization.cloud_init.regenerate_ssh_keys]
     *    [action.vm.initialization.cloud_init.timezone]
     *    [action.vm.initialization.cloud_init.users.user]
     *    [action.vm.initialization.cloud_init.payload_files.payload_file]
     *    [action.use_sysprep]
     *    [action.use_cloud_init]
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
    public Action start(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/start";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs start action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    [action.vm.os.initRd]
     *    [action.vm.domain.name]
     *    [action.vm.placement_policy.hosts.host]
     *    [action.vm.placement_policy.affinity]
     *    [action.vm.os.kernel]
     *    [action.vm.display.type]
     *    [action.vm.stateless]
     *    [action.vm.os.cmdline]
     *    [action.vm.domain.user.username]
     *    [action.pause]
     *    [action.vm.os.boot.devices.device]
     *    [action.vm.domain.user.password]
     *    [action.vm.initialization.cloud_init.host.address]
     *    [action.vm.custom_emulated_machine]
     *    [action.vm.custom_cpu_model]
     *    [action.vm.initialization.cloud_init.network_configuration.nics.nic]
     *    [action.vm.initialization.cloud_init.network_configuration.dns.servers.host]
     *    [action.vm.initialization.cloud_init.network_configuration.dns.search_domains.host]
     *    [action.vm.initialization.cloud_init.authorized_keys.authorized_key]
     *    [authorized_key.user.name]
     *    [action.vm.initialization.cloud_init.regenerate_ssh_keys]
     *    [action.vm.initialization.cloud_init.timezone]
     *    [action.vm.initialization.cloud_init.users.user]
     *    [action.vm.initialization.cloud_init.payload_files.payload_file]
     *    [action.use_sysprep]
     *    [action.use_cloud_init]
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
    public Action start(Action action, Boolean async) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/start";

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
     * Performs start action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    [action.vm.os.initRd]
     *    [action.vm.domain.name]
     *    [action.vm.placement_policy.hosts.host]
     *    [action.vm.placement_policy.affinity]
     *    [action.vm.os.kernel]
     *    [action.vm.display.type]
     *    [action.vm.stateless]
     *    [action.vm.os.cmdline]
     *    [action.vm.domain.user.username]
     *    [action.pause]
     *    [action.vm.os.boot.devices.device]
     *    [action.vm.domain.user.password]
     *    [action.vm.initialization.cloud_init.host.address]
     *    [action.vm.custom_emulated_machine]
     *    [action.vm.custom_cpu_model]
     *    [action.vm.initialization.cloud_init.network_configuration.nics.nic]
     *    [action.vm.initialization.cloud_init.network_configuration.dns.servers.host]
     *    [action.vm.initialization.cloud_init.network_configuration.dns.search_domains.host]
     *    [action.vm.initialization.cloud_init.authorized_keys.authorized_key]
     *    [authorized_key.user.name]
     *    [action.vm.initialization.cloud_init.regenerate_ssh_keys]
     *    [action.vm.initialization.cloud_init.timezone]
     *    [action.vm.initialization.cloud_init.users.user]
     *    [action.vm.initialization.cloud_init.payload_files.payload_file]
     *    [action.use_sysprep]
     *    [action.use_cloud_init]
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
    public Action start(Action action, Boolean async, String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/start";

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
     * Performs stop action.
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
    public Action stop(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/stop";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs stop action.
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
    public Action stop(Action action, Boolean async) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/stop";

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
     * Performs stop action.
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
    public Action stop(Action action, Boolean async, String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/stop";

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
     * Performs suspend action.
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
    public Action suspend(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/suspend";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs suspend action.
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
    public Action suspend(Action action, Boolean async) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/suspend";

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
     * Performs suspend action.
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
    public Action suspend(Action action, Boolean async, String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/suspend";

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
     * Performs thawfilesystems action.
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
    public Action thawfilesystems(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/thawfilesystems";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs thawfilesystems action.
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
    public Action thawfilesystems(Action action, Boolean async) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/thawfilesystems";

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
     * Performs thawfilesystems action.
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
    public Action thawfilesystems(Action action, Boolean async, String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/thawfilesystems";

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
     * Performs ticket action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    [action.ticket.value]
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
    public Action ticket(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/ticket";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs ticket action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    [action.ticket.value]
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
    public Action ticket(Action action, Boolean async) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/ticket";

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
     * Performs ticket action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    [action.ticket.value]
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
    public Action ticket(Action action, Boolean async, String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/ticket";

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
     * Performs undo_snapshot action.
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
    public Action undo_snapshot(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/undo_snapshot";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs undo_snapshot action.
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
    public Action undo_snapshot(Action action, Boolean async) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/undo_snapshot";

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
     * Performs undo_snapshot action.
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
    public Action undo_snapshot(Action action, Boolean async, String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/undo_snapshot";

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
     * Updates Vm object.
     *
     * @param vm {@link org.ovirt.engine.sdk.entities.Vm}
     *    <pre>
     *    [vm.instance_type.id|name]
     *    [vm.name]
     *    [vm.cluster.id|name]
     *    [vm.time_zone.name]
     *    [vm.os.boot]
     *    [vm.custom_properties.custom_property]
     *    [vm.os.type]
     *    [vm.usb.enabled]
     *    [vm.usb.type]
     *    [vm.type]
     *    [vm.os.initRd]
     *    [vm.display.monitors]
     *    [vm.display.single_qxl_pci]
     *    [vm.display.type]
     *    [vm.display.allow_override]
     *    [vm.display.smartcard_enabled]
     *    [vm.display.file_transfer_enabled]
     *    [vm.display.copy_paste_enabled]
     *    [vm.display.keyboard_layout]
     *    [vm.os.cmdline]
     *    [vm.cpu.mode]
     *    [vm.cpu.architecture]
     *    [vm.cpu.topology.cores]
     *    [vm.cpu_shares]
     *    [vm.memory]
     *    [vm.io.threads]
     *    [vm.memory_policy.guaranteed]
     *    [vm.memory_policy.ballooning]
     *    [vm.high_availability.priority]
     *    [vm.high_availability.enabled]
     *    [vm.domain.name]
     *    [vm.description]
     *    [vm.comment]
     *    [vm.stateless]
     *    [vm.delete_protected]
     *    [vm.sso.methods.method]
     *    [vm.rng_device.rate.bytes]
     *    [vm.rng_device.rate.period]
     *    [vm.rng_device.source]
     *    [vm.console.enabled]
     *    [vm.cpu.topology.sockets]
     *    [vm.placement_policy.affinity]
     *    [vm.placement_policy.hosts.host]
     *    [vm.origin]
     *    [vm.os.kernel]
     *    [vm.tunnel_migration]
     *    [vm.migration_downtime]
     *    [vm.virtio_scsi.enabled]
     *    [vm.soundcard_enabled]
     *    [vm.custom_emulated_machine]
     *    [vm.custom_cpu_model]
     *    [vm.use_latest_template_version]
     *    [vm.payloads.payload]
     *    [vm.cpu.cpu_tune.vcpu_pins.vcpu_pin]
     *    [vm.serial_number.policy]
     *    [vm.serial_number.value]
     *    [vm.bios.boot_menu.enabled]
     *    [vm.numa_tune_mode]
     *    [vm.start_paused]
     *    [vm.cpu_profile.id]
     *    [vm.migration.auto_converge]
     *    [vm.migration.compressed]
     *    [vm.external_host_provider.id]
     *    [vm.small_icon.id]
     *    [vm.large_icon.id]
     *    [vm.large_icon.media_type]
     *    [vm.large_icon.data]
     *    </pre>
     *
     *
     * @return
     *     {@link Vm }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public Vm update() throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().update(
                url,
                this,
                org.ovirt.engine.sdk.entities.Vm.class,
                Vm.class,
                headers);
    }
    /**
     * Updates Vm object.
     *
     * @param vm {@link org.ovirt.engine.sdk.entities.Vm}
     *    <pre>
     *    [vm.instance_type.id|name]
     *    [vm.name]
     *    [vm.cluster.id|name]
     *    [vm.time_zone.name]
     *    [vm.os.boot]
     *    [vm.custom_properties.custom_property]
     *    [vm.os.type]
     *    [vm.usb.enabled]
     *    [vm.usb.type]
     *    [vm.type]
     *    [vm.os.initRd]
     *    [vm.display.monitors]
     *    [vm.display.single_qxl_pci]
     *    [vm.display.type]
     *    [vm.display.allow_override]
     *    [vm.display.smartcard_enabled]
     *    [vm.display.file_transfer_enabled]
     *    [vm.display.copy_paste_enabled]
     *    [vm.display.keyboard_layout]
     *    [vm.os.cmdline]
     *    [vm.cpu.mode]
     *    [vm.cpu.architecture]
     *    [vm.cpu.topology.cores]
     *    [vm.cpu_shares]
     *    [vm.memory]
     *    [vm.io.threads]
     *    [vm.memory_policy.guaranteed]
     *    [vm.memory_policy.ballooning]
     *    [vm.high_availability.priority]
     *    [vm.high_availability.enabled]
     *    [vm.domain.name]
     *    [vm.description]
     *    [vm.comment]
     *    [vm.stateless]
     *    [vm.delete_protected]
     *    [vm.sso.methods.method]
     *    [vm.rng_device.rate.bytes]
     *    [vm.rng_device.rate.period]
     *    [vm.rng_device.source]
     *    [vm.console.enabled]
     *    [vm.cpu.topology.sockets]
     *    [vm.placement_policy.affinity]
     *    [vm.placement_policy.hosts.host]
     *    [vm.origin]
     *    [vm.os.kernel]
     *    [vm.tunnel_migration]
     *    [vm.migration_downtime]
     *    [vm.virtio_scsi.enabled]
     *    [vm.soundcard_enabled]
     *    [vm.custom_emulated_machine]
     *    [vm.custom_cpu_model]
     *    [vm.use_latest_template_version]
     *    [vm.payloads.payload]
     *    [vm.cpu.cpu_tune.vcpu_pins.vcpu_pin]
     *    [vm.serial_number.policy]
     *    [vm.serial_number.value]
     *    [vm.bios.boot_menu.enabled]
     *    [vm.numa_tune_mode]
     *    [vm.start_paused]
     *    [vm.cpu_profile.id]
     *    [vm.migration.auto_converge]
     *    [vm.migration.compressed]
     *    [vm.external_host_provider.id]
     *    [vm.small_icon.id]
     *    [vm.large_icon.id]
     *    [vm.large_icon.media_type]
     *    [vm.large_icon.data]
     *    </pre>
     *
     * @param async
     *    <pre>
     *    [true|false]
     *    </pre>
     * @return
     *     {@link Vm }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public Vm update(Boolean async) throws ClientProtocolException,
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
                org.ovirt.engine.sdk.entities.Vm.class,
                Vm.class,
                headers);
    }
    /**
     * Updates Vm object.
     *
     * @param vm {@link org.ovirt.engine.sdk.entities.Vm}
     *    <pre>
     *    [vm.instance_type.id|name]
     *    [vm.name]
     *    [vm.cluster.id|name]
     *    [vm.time_zone.name]
     *    [vm.os.boot]
     *    [vm.custom_properties.custom_property]
     *    [vm.os.type]
     *    [vm.usb.enabled]
     *    [vm.usb.type]
     *    [vm.type]
     *    [vm.os.initRd]
     *    [vm.display.monitors]
     *    [vm.display.single_qxl_pci]
     *    [vm.display.type]
     *    [vm.display.allow_override]
     *    [vm.display.smartcard_enabled]
     *    [vm.display.file_transfer_enabled]
     *    [vm.display.copy_paste_enabled]
     *    [vm.display.keyboard_layout]
     *    [vm.os.cmdline]
     *    [vm.cpu.mode]
     *    [vm.cpu.architecture]
     *    [vm.cpu.topology.cores]
     *    [vm.cpu_shares]
     *    [vm.memory]
     *    [vm.io.threads]
     *    [vm.memory_policy.guaranteed]
     *    [vm.memory_policy.ballooning]
     *    [vm.high_availability.priority]
     *    [vm.high_availability.enabled]
     *    [vm.domain.name]
     *    [vm.description]
     *    [vm.comment]
     *    [vm.stateless]
     *    [vm.delete_protected]
     *    [vm.sso.methods.method]
     *    [vm.rng_device.rate.bytes]
     *    [vm.rng_device.rate.period]
     *    [vm.rng_device.source]
     *    [vm.console.enabled]
     *    [vm.cpu.topology.sockets]
     *    [vm.placement_policy.affinity]
     *    [vm.placement_policy.hosts.host]
     *    [vm.origin]
     *    [vm.os.kernel]
     *    [vm.tunnel_migration]
     *    [vm.migration_downtime]
     *    [vm.virtio_scsi.enabled]
     *    [vm.soundcard_enabled]
     *    [vm.custom_emulated_machine]
     *    [vm.custom_cpu_model]
     *    [vm.use_latest_template_version]
     *    [vm.payloads.payload]
     *    [vm.cpu.cpu_tune.vcpu_pins.vcpu_pin]
     *    [vm.serial_number.policy]
     *    [vm.serial_number.value]
     *    [vm.bios.boot_menu.enabled]
     *    [vm.numa_tune_mode]
     *    [vm.start_paused]
     *    [vm.cpu_profile.id]
     *    [vm.migration.auto_converge]
     *    [vm.migration.compressed]
     *    [vm.external_host_provider.id]
     *    [vm.small_icon.id]
     *    [vm.large_icon.id]
     *    [vm.large_icon.media_type]
     *    [vm.large_icon.data]
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
     *     {@link Vm }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public Vm update(Boolean async, String correlationId) throws ClientProtocolException,
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
                org.ovirt.engine.sdk.entities.Vm.class,
                Vm.class,
                headers);
    }
    /**
     * Updates Vm object.
     *
     * @param vm {@link org.ovirt.engine.sdk.entities.Vm}
     *    <pre>
     *    [vm.instance_type.id|name]
     *    [vm.name]
     *    [vm.cluster.id|name]
     *    [vm.time_zone.name]
     *    [vm.os.boot]
     *    [vm.custom_properties.custom_property]
     *    [vm.os.type]
     *    [vm.usb.enabled]
     *    [vm.usb.type]
     *    [vm.type]
     *    [vm.os.initRd]
     *    [vm.display.monitors]
     *    [vm.display.single_qxl_pci]
     *    [vm.display.type]
     *    [vm.display.allow_override]
     *    [vm.display.smartcard_enabled]
     *    [vm.display.file_transfer_enabled]
     *    [vm.display.copy_paste_enabled]
     *    [vm.display.keyboard_layout]
     *    [vm.os.cmdline]
     *    [vm.cpu.mode]
     *    [vm.cpu.architecture]
     *    [vm.cpu.topology.cores]
     *    [vm.cpu_shares]
     *    [vm.memory]
     *    [vm.io.threads]
     *    [vm.memory_policy.guaranteed]
     *    [vm.memory_policy.ballooning]
     *    [vm.high_availability.priority]
     *    [vm.high_availability.enabled]
     *    [vm.domain.name]
     *    [vm.description]
     *    [vm.comment]
     *    [vm.stateless]
     *    [vm.delete_protected]
     *    [vm.sso.methods.method]
     *    [vm.rng_device.rate.bytes]
     *    [vm.rng_device.rate.period]
     *    [vm.rng_device.source]
     *    [vm.console.enabled]
     *    [vm.cpu.topology.sockets]
     *    [vm.placement_policy.affinity]
     *    [vm.placement_policy.hosts.host]
     *    [vm.origin]
     *    [vm.os.kernel]
     *    [vm.tunnel_migration]
     *    [vm.migration_downtime]
     *    [vm.virtio_scsi.enabled]
     *    [vm.soundcard_enabled]
     *    [vm.custom_emulated_machine]
     *    [vm.custom_cpu_model]
     *    [vm.use_latest_template_version]
     *    [vm.payloads.payload]
     *    [vm.cpu.cpu_tune.vcpu_pins.vcpu_pin]
     *    [vm.serial_number.policy]
     *    [vm.serial_number.value]
     *    [vm.bios.boot_menu.enabled]
     *    [vm.numa_tune_mode]
     *    [vm.start_paused]
     *    [vm.cpu_profile.id]
     *    [vm.migration.auto_converge]
     *    [vm.migration.compressed]
     *    [vm.external_host_provider.id]
     *    [vm.small_icon.id]
     *    [vm.large_icon.id]
     *    [vm.large_icon.media_type]
     *    [vm.large_icon.data]
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
     *     {@link Vm }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public Vm update(Boolean async, String correlationId, String expect) throws ClientProtocolException,
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
                org.ovirt.engine.sdk.entities.Vm.class,
                Vm.class,
                headers);
    }
    /**
     * Updates Vm object.
     *
     * @param vm {@link org.ovirt.engine.sdk.entities.Vm}
     *    <pre>
     *    [vm.instance_type.id|name]
     *    [vm.name]
     *    [vm.cluster.id|name]
     *    [vm.time_zone.name]
     *    [vm.os.boot]
     *    [vm.custom_properties.custom_property]
     *    [vm.os.type]
     *    [vm.usb.enabled]
     *    [vm.usb.type]
     *    [vm.type]
     *    [vm.os.initRd]
     *    [vm.display.monitors]
     *    [vm.display.single_qxl_pci]
     *    [vm.display.type]
     *    [vm.display.allow_override]
     *    [vm.display.smartcard_enabled]
     *    [vm.display.file_transfer_enabled]
     *    [vm.display.copy_paste_enabled]
     *    [vm.display.keyboard_layout]
     *    [vm.os.cmdline]
     *    [vm.cpu.mode]
     *    [vm.cpu.architecture]
     *    [vm.cpu.topology.cores]
     *    [vm.cpu_shares]
     *    [vm.memory]
     *    [vm.io.threads]
     *    [vm.memory_policy.guaranteed]
     *    [vm.memory_policy.ballooning]
     *    [vm.high_availability.priority]
     *    [vm.high_availability.enabled]
     *    [vm.domain.name]
     *    [vm.description]
     *    [vm.comment]
     *    [vm.stateless]
     *    [vm.delete_protected]
     *    [vm.sso.methods.method]
     *    [vm.rng_device.rate.bytes]
     *    [vm.rng_device.rate.period]
     *    [vm.rng_device.source]
     *    [vm.console.enabled]
     *    [vm.cpu.topology.sockets]
     *    [vm.placement_policy.affinity]
     *    [vm.placement_policy.hosts.host]
     *    [vm.origin]
     *    [vm.os.kernel]
     *    [vm.tunnel_migration]
     *    [vm.migration_downtime]
     *    [vm.virtio_scsi.enabled]
     *    [vm.soundcard_enabled]
     *    [vm.custom_emulated_machine]
     *    [vm.custom_cpu_model]
     *    [vm.use_latest_template_version]
     *    [vm.payloads.payload]
     *    [vm.cpu.cpu_tune.vcpu_pins.vcpu_pin]
     *    [vm.serial_number.policy]
     *    [vm.serial_number.value]
     *    [vm.bios.boot_menu.enabled]
     *    [vm.numa_tune_mode]
     *    [vm.start_paused]
     *    [vm.cpu_profile.id]
     *    [vm.migration.auto_converge]
     *    [vm.migration.compressed]
     *    [vm.external_host_provider.id]
     *    [vm.small_icon.id]
     *    [vm.large_icon.id]
     *    [vm.large_icon.media_type]
     *    [vm.large_icon.data]
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
     * @param nextRun
     *    <pre>
     *    [true|false]
     *    </pre>
     * @return
     *     {@link Vm }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public Vm update(Boolean async, String correlationId, String expect, Boolean nextRun) throws ClientProtocolException,
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

        if (nextRun != null) {
            urlBuilder.add("next_run", nextRun, UrlParameterType.MATRIX);
        }

        url = urlBuilder.build();

        return getProxy().update(
                url,
                this,
                org.ovirt.engine.sdk.entities.Vm.class,
                Vm.class,
                headers);
    }

}
