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

    private volatile HostHooks hostHooks;
    private volatile HostNICs hostNICs;
    private volatile HostTags hostTags;
    private volatile HostPermissions hostPermissions;
    private volatile HostStatistics hostStatistics;


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
     *
     *    Overload 2:
     *
     *      install vdsm and other
     *      packages required to get the
     *      host ready to be used in the
     *      engine providing thre ssh
     *      password
     *
     *      [action.ssh.password]
     *      [action.image]
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
    public Action install(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/install";

        List<Header> headers = new HttpHeaderBuilder()
                .build();

        url = new UrlBuilder(url)
                .build();

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
     *
     *    Overload 2:
     *
     *      install vdsm and other
     *      packages required to get the
     *      host ready to be used in the
     *      engine providing thre ssh
     *      password
     *
     *      [action.ssh.password]
     *      [action.image]
     *    </pre>
     *
     * @param correlationId
     *    <pre>
     *    [any string]
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
    public Action install(Action action, String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/install";

        List<Header> headers = new HttpHeaderBuilder()
                .add("Correlation-Id", correlationId)
                .build();

        url = new UrlBuilder(url)
                .build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs activate action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
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

        List<Header> headers = new HttpHeaderBuilder()
                .build();

        url = new UrlBuilder(url)
                .build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs activate action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     * @param correlationId
     *    <pre>
     *    [any string]
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
    public Action activate(Action action, String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/activate";

        List<Header> headers = new HttpHeaderBuilder()
                .add("Correlation-Id", correlationId)
                .build();

        url = new UrlBuilder(url)
                .build();

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
     *      [host.storage_manager.priority]
     *      [host.power_management.type]
     *      [host.power_management.enabled]
     *      [host.power_management.address]
     *      [host.power_management.username]
     *      [host.power_management.password]
     *      [host.power_management.options.option]
     *      [host.power_management.pm_proxy]
     *      [host.power_management.agents.agent]
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
     *      [host.storage_manager.priority]
     *      [host.power_management.type]
     *      [host.power_management.enabled]
     *      [host.power_management.address]
     *      [host.power_management.username]
     *      [host.power_management.password]
     *      [host.power_management.options.option]
     *      [host.power_management.pm_proxy]
     *      [host.power_management.agents.agent]
     *    </pre>
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

        List<Header> headers = new HttpHeaderBuilder()
                .build();

        url = new UrlBuilder(url)
                .build();

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
     *      [host.storage_manager.priority]
     *      [host.power_management.type]
     *      [host.power_management.enabled]
     *      [host.power_management.address]
     *      [host.power_management.username]
     *      [host.power_management.password]
     *      [host.power_management.options.option]
     *      [host.power_management.pm_proxy]
     *      [host.power_management.agents.agent]
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
     *      [host.storage_manager.priority]
     *      [host.power_management.type]
     *      [host.power_management.enabled]
     *      [host.power_management.address]
     *      [host.power_management.username]
     *      [host.power_management.password]
     *      [host.power_management.options.option]
     *      [host.power_management.pm_proxy]
     *      [host.power_management.agents.agent]
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

        List<Header> headers = new HttpHeaderBuilder()
                .add("Correlation-Id", correlationId)
                .build();

        url = new UrlBuilder(url)
                .add("async", async, UrlParameterType.MATRIX)
                .build();

        return getProxy().update(
                url,
                this,
                org.ovirt.engine.sdk.entities.Host.class,
                Host.class,
                headers);
    }
    /**
     * Performs fence action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    action.fence_type
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
    public Action fence(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/fence";

        List<Header> headers = new HttpHeaderBuilder()
                .build();

        url = new UrlBuilder(url)
                .build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs fence action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    action.fence_type
     *    </pre>
     *
     * @param correlationId
     *    <pre>
     *    [any string]
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
    public Action fence(Action action, String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/fence";

        List<Header> headers = new HttpHeaderBuilder()
                .add("Correlation-Id", correlationId)
                .build();

        url = new UrlBuilder(url)
                .build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs iscsidiscover action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    action.iscsi.address
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
    public Action iscsidiscover(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/iscsidiscover";

        List<Header> headers = new HttpHeaderBuilder()
                .build();

        url = new UrlBuilder(url)
                .build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs iscsidiscover action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    action.iscsi.address
     *    </pre>
     *
     * @param correlationId
     *    <pre>
     *    [any string]
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
    public Action iscsidiscover(Action action, String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/iscsidiscover";

        List<Header> headers = new HttpHeaderBuilder()
                .add("Correlation-Id", correlationId)
                .build();

        url = new UrlBuilder(url)
                .build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs approve action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    [action.cluster.id|name]
     *    [action.async]
     *    [action.grace_period.expiry]
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
    public Action approve(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/approve";

        List<Header> headers = new HttpHeaderBuilder()
                .build();

        url = new UrlBuilder(url)
                .build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs approve action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    [action.cluster.id|name]
     *    [action.async]
     *    [action.grace_period.expiry]
     *    </pre>
     *
     * @param correlationId
     *    <pre>
     *    [any string]
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
    public Action approve(Action action, String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/approve";

        List<Header> headers = new HttpHeaderBuilder()
                .add("Correlation-Id", correlationId)
                .build();

        url = new UrlBuilder(url)
                .build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs iscsilogin action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    action.iscsi.address
     *    action.iscsi.target
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
    public Action iscsilogin(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/iscsilogin";

        List<Header> headers = new HttpHeaderBuilder()
                .build();

        url = new UrlBuilder(url)
                .build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs iscsilogin action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    action.iscsi.address
     *    action.iscsi.target
     *    </pre>
     *
     * @param correlationId
     *    <pre>
     *    [any string]
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
    public Action iscsilogin(Action action, String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/iscsilogin";

        List<Header> headers = new HttpHeaderBuilder()
                .add("Correlation-Id", correlationId)
                .build();

        url = new UrlBuilder(url)
                .build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs forceselectspm action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
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

        List<Header> headers = new HttpHeaderBuilder()
                .build();

        url = new UrlBuilder(url)
                .build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs forceselectspm action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     * @param correlationId
     *    <pre>
     *    [any string]
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
    public Action forceselectspm(Action action, String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/forceselectspm";

        List<Header> headers = new HttpHeaderBuilder()
                .add("Correlation-Id", correlationId)
                .build();

        url = new UrlBuilder(url)
                .build();

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
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    [action.force]
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
    public Response delete(org.ovirt.engine.sdk.entities.Action action, Boolean async, String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref();

        List<Header> headers = new HttpHeaderBuilder()
                .add("Correlation-Id", correlationId)
                .build();

        url = new UrlBuilder(url)
                .add("async", async, UrlParameterType.MATRIX)
                .build();

        return getProxy().delete(url, action,
                org.ovirt.engine.sdk.entities.Action.class, Response.class, headers);
    }
    /**
     * Performs deactivate action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
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

        List<Header> headers = new HttpHeaderBuilder()
                .build();

        url = new UrlBuilder(url)
                .build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs deactivate action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     * @param correlationId
     *    <pre>
     *    [any string]
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
    public Action deactivate(Action action, String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/deactivate";

        List<Header> headers = new HttpHeaderBuilder()
                .add("Correlation-Id", correlationId)
                .build();

        url = new UrlBuilder(url)
                .build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs commitnetconfig action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
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

        List<Header> headers = new HttpHeaderBuilder()
                .build();

        url = new UrlBuilder(url)
                .build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs commitnetconfig action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     * @param correlationId
     *    <pre>
     *    [any string]
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
    public Action commitnetconfig(Action action, String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/commitnetconfig";

        List<Header> headers = new HttpHeaderBuilder()
                .add("Correlation-Id", correlationId)
                .build();

        url = new UrlBuilder(url)
                .build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }

}

