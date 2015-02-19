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
import java.util.UUID;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.ovirt.engine.sdk.common.CollectionDecorator;
import org.ovirt.engine.sdk.exceptions.ServerException;
import org.ovirt.engine.sdk.utils.CollectionUtils;
import org.ovirt.engine.sdk.utils.HttpHeaderBuilder;
import org.ovirt.engine.sdk.utils.HttpHeaderUtils;
import org.ovirt.engine.sdk.utils.UrlBuilder;
import org.ovirt.engine.sdk.utils.UrlBuilder;
import org.ovirt.engine.sdk.utils.UrlHelper;
import org.ovirt.engine.sdk.web.HttpProxyBroker;
import org.ovirt.engine.sdk.web.UrlParameterType;
import org.ovirt.engine.sdk.entities.Action;

/**
 * <p>Hosts providing relation and functional services
 * <p>to {@link org.ovirt.engine.sdk.entities.Hosts }.
 */
@SuppressWarnings("unused")
public class Hosts extends
        CollectionDecorator<org.ovirt.engine.sdk.entities.Host,
                            org.ovirt.engine.sdk.entities.Hosts,
                            Host> {

    /**
     * @param proxy HttpProxyBroker
     */
    public Hosts(HttpProxyBroker proxy) {
        super(proxy, "hosts");
    }

    /**
     * Lists Host objects.
     *
     * @return
     *     List of {@link Host }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    @Override
    public List<Host> list() throws ClientProtocolException,
            ServerException, IOException {
        String url = SLASH + getName();
        return list(url, org.ovirt.engine.sdk.entities.Hosts.class, Host.class);
    }

    /**
     * Fetches Host object by id.
     *
     * @return {@link Host }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    @Override
    public Host get(UUID id) throws ClientProtocolException,
            ServerException, IOException {
        String url = SLASH + getName() + SLASH + id.toString();
        return getProxy().get(url, org.ovirt.engine.sdk.entities.Host.class, Host.class);
    }

    /**
     * Fetches Host object by id.
     *
     * @return {@link Host }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    @Override
    public Host getById(String id) throws ClientProtocolException,
            ServerException, IOException {
        String url = SLASH + getName() + SLASH + id;
        return getProxy().get(url, org.ovirt.engine.sdk.entities.Host.class, Host.class);
    }

    /**
     * Lists Host objects.
     *
     * @param query
     *    <pre>
     *    [search query]
     *    </pre>
     * @param caseSensitive
     *    <pre>
     *    [true|false]
     *    </pre>
     * @param max
     *    <pre>
     *    [max results]
     *    </pre>
     *
     *
     * @return List of {@link Host }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public List<Host> list(String query, Boolean caseSensitive, Integer max) throws ClientProtocolException,
            ServerException, IOException {

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(SLASH + getName());
        if (query != null) {
            urlBuilder.add("search", query, UrlParameterType.QUERY);
        }
        if (caseSensitive != null) {
            urlBuilder.add("case_sensitive", caseSensitive, UrlParameterType.MATRIX);
        }
        if (max != null) {
            urlBuilder.add("max", max, UrlParameterType.MATRIX);
        }
        String url = urlBuilder.build();

        return list(url, org.ovirt.engine.sdk.entities.Hosts.class,
                Host.class, headers);
    }
    /**
     * Lists Host objects.
     *
     * @param allContent
     *    <pre>
     *    [true|false]
     *    </pre>
     *
     * @param query
     *    <pre>
     *    [search query]
     *    </pre>
     * @param caseSensitive
     *    <pre>
     *    [true|false]
     *    </pre>
     * @param max
     *    <pre>
     *    [max results]
     *    </pre>
     *
     *
     * @return List of {@link Host }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public List<Host> list(String query, Boolean caseSensitive, Integer max, String allContent) throws ClientProtocolException,
            ServerException, IOException {

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        if (allContent != null) {
            headersBuilder.add("All-Content", allContent);
        }
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(SLASH + getName());
        if (query != null) {
            urlBuilder.add("search", query, UrlParameterType.QUERY);
        }
        if (caseSensitive != null) {
            urlBuilder.add("case_sensitive", caseSensitive, UrlParameterType.MATRIX);
        }
        if (max != null) {
            urlBuilder.add("max", max, UrlParameterType.MATRIX);
        }
        String url = urlBuilder.build();

        return list(url, org.ovirt.engine.sdk.entities.Hosts.class,
                Host.class, headers);
    }
    /**
     * Adds Host object.
     *
     * @param host {@link org.ovirt.engine.sdk.entities.Host}
     *    <pre>
     *    Overload 1:
     *
     *      add a new host to the system
     *      providing the host root
     *      password. This has been
     *      deprecated and provided for
     *      backwards compatibility
     *
     *      host.name
     *      host.address
     *      host.root_password
     *      host.cluster.id|name
     *      [host.comment]
     *      [host.port]
     *      [host.display.address]
     *      [host.spm.priority]
     *      [host.power_management.type]
     *      [host.power_management.enabled]
     *      [host.power_management.address]
     *      [host.power_management.username]
     *      [host.power_management.automatic_pm_enabled]
     *      [host.power_management.password]
     *      [host.power_management.options.option]
     *      [host.power_management.pm_proxy]
     *      [host.power_management.agents.agent]
     *      [host.reboot_after_installation]
     *      [host.override_iptables]
     *      [host.power_management.kdump_detection]
     *      [host.protocol]
     *
     *    Overload 2:
     *
     *      add a new host to the system
     *      providing the ssh password or
     *      fingerprint
     *
     *      host.name
     *      host.address
     *      host.cluster.id|name
     *      [host.comment]
     *      [host.ssh.port]
     *      [host.ssh.fingerprint]
     *      [host.ssh.authentication_method]
     *      [host.ssh.user.user_name]
     *      [host.ssh.user.password]
     *      [host.port]
     *      [host.display.address]
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
     *      [host.reboot_after_installation]
     *      [host.override_iptables]
     *      [host.power_management.kdump_detection]
     *      [host.protocol]
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
    public Host add(org.ovirt.engine.sdk.entities.Host host) throws
            ClientProtocolException, ServerException, IOException {
        String url = SLASH + getName();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().add(url, host,
                org.ovirt.engine.sdk.entities.Host.class,
                Host.class, headers);
    }
    /**
     * Adds Host object.
     *
     * @param host {@link org.ovirt.engine.sdk.entities.Host}
     *    <pre>
     *    Overload 1:
     *
     *      add a new host to the system
     *      providing the host root
     *      password. This has been
     *      deprecated and provided for
     *      backwards compatibility
     *
     *      host.name
     *      host.address
     *      host.root_password
     *      host.cluster.id|name
     *      [host.comment]
     *      [host.port]
     *      [host.display.address]
     *      [host.spm.priority]
     *      [host.power_management.type]
     *      [host.power_management.enabled]
     *      [host.power_management.address]
     *      [host.power_management.username]
     *      [host.power_management.automatic_pm_enabled]
     *      [host.power_management.password]
     *      [host.power_management.options.option]
     *      [host.power_management.pm_proxy]
     *      [host.power_management.agents.agent]
     *      [host.reboot_after_installation]
     *      [host.override_iptables]
     *      [host.power_management.kdump_detection]
     *      [host.protocol]
     *
     *    Overload 2:
     *
     *      add a new host to the system
     *      providing the ssh password or
     *      fingerprint
     *
     *      host.name
     *      host.address
     *      host.cluster.id|name
     *      [host.comment]
     *      [host.ssh.port]
     *      [host.ssh.fingerprint]
     *      [host.ssh.authentication_method]
     *      [host.ssh.user.user_name]
     *      [host.ssh.user.password]
     *      [host.port]
     *      [host.display.address]
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
     *      [host.reboot_after_installation]
     *      [host.override_iptables]
     *      [host.power_management.kdump_detection]
     *      [host.protocol]
     *    </pre>
     *
     * @param expect
     *    <pre>
     *    [201-created]
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
    public Host add(org.ovirt.engine.sdk.entities.Host host, String expect) throws
            ClientProtocolException, ServerException, IOException {
        String url = SLASH + getName();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        if (expect != null) {
            headersBuilder.add("Expect", expect);
        }
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().add(url, host,
                org.ovirt.engine.sdk.entities.Host.class,
                Host.class, headers);
    }
    /**
     * Adds Host object.
     *
     * @param host {@link org.ovirt.engine.sdk.entities.Host}
     *    <pre>
     *    Overload 1:
     *
     *      add a new host to the system
     *      providing the host root
     *      password. This has been
     *      deprecated and provided for
     *      backwards compatibility
     *
     *      host.name
     *      host.address
     *      host.root_password
     *      host.cluster.id|name
     *      [host.comment]
     *      [host.port]
     *      [host.display.address]
     *      [host.spm.priority]
     *      [host.power_management.type]
     *      [host.power_management.enabled]
     *      [host.power_management.address]
     *      [host.power_management.username]
     *      [host.power_management.automatic_pm_enabled]
     *      [host.power_management.password]
     *      [host.power_management.options.option]
     *      [host.power_management.pm_proxy]
     *      [host.power_management.agents.agent]
     *      [host.reboot_after_installation]
     *      [host.override_iptables]
     *      [host.power_management.kdump_detection]
     *      [host.protocol]
     *
     *    Overload 2:
     *
     *      add a new host to the system
     *      providing the ssh password or
     *      fingerprint
     *
     *      host.name
     *      host.address
     *      host.cluster.id|name
     *      [host.comment]
     *      [host.ssh.port]
     *      [host.ssh.fingerprint]
     *      [host.ssh.authentication_method]
     *      [host.ssh.user.user_name]
     *      [host.ssh.user.password]
     *      [host.port]
     *      [host.display.address]
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
     *      [host.reboot_after_installation]
     *      [host.override_iptables]
     *      [host.power_management.kdump_detection]
     *      [host.protocol]
     *    </pre>
     *
     * @param expect
     *    <pre>
     *    [201-created]
     *    </pre>
     * @param correlationId
     *    <pre>
     *    [any string]
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
    public Host add(org.ovirt.engine.sdk.entities.Host host, String expect, String correlationId) throws
            ClientProtocolException, ServerException, IOException {
        String url = SLASH + getName();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        if (expect != null) {
            headersBuilder.add("Expect", expect);
        }
        if (correlationId != null) {
            headersBuilder.add("Correlation-Id", correlationId);
        }
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().add(url, host,
                org.ovirt.engine.sdk.entities.Host.class,
                Host.class, headers);
    }

}

