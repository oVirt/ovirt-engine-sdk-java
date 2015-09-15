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
 * <p>UserSSHPublicKeys providing relation and functional services
 * <p>to {@link org.ovirt.engine.sdk.entities.SSHPublicKeys }.
 */
@SuppressWarnings("unused")
public class UserSSHPublicKeys extends
        CollectionDecorator<org.ovirt.engine.sdk.entities.SSHPublicKey,
                            org.ovirt.engine.sdk.entities.SSHPublicKeys,
                            UserSSHPublicKey> {

    private User parent;

    /**
     * @param proxy HttpProxyBroker
     * @param parent User
     */
    public UserSSHPublicKeys(HttpProxyBroker proxy, User parent) {
        super(proxy, "sshpublickeys");
        this.parent = parent;
    }

    /**
     * Lists UserSSHPublicKey objects.
     *
     * @return
     *     List of {@link UserSSHPublicKey }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    @Override
    public List<UserSSHPublicKey> list() throws ClientProtocolException,
            ServerException, IOException {
        String url = this.parent.getHref() + SLASH + getName();
        return list(url, org.ovirt.engine.sdk.entities.SSHPublicKeys.class, UserSSHPublicKey.class);
    }

    /**
     * Fetches UserSSHPublicKey object by id.
     *
     * @return
     *     {@link UserSSHPublicKey }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    @Override
    public UserSSHPublicKey get(UUID id) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.parent.getHref() + SLASH + getName() + SLASH + id.toString();
        return getProxy().get(url, org.ovirt.engine.sdk.entities.SSHPublicKey.class, UserSSHPublicKey.class);
    }

    /**
     * Fetches UserSSHPublicKey object by id.
     *
     * @return
     *     {@link UserSSHPublicKey }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    @Override
    public UserSSHPublicKey getById(String id) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.parent.getHref() + SLASH + getName() + SLASH + id;
        return getProxy().get(url, org.ovirt.engine.sdk.entities.SSHPublicKey.class, UserSSHPublicKey.class);
    }

    /**
     * Adds SSHPublicKey object.
     *
     * @param sshpublickey {@link org.ovirt.engine.sdk.entities.SSHPublicKey}
     *    <pre>
     *    ssh_public_key.id|name
     *    </pre>
     *
     *
     * @return
     *     {@link UserSSHPublicKey }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public UserSSHPublicKey add(org.ovirt.engine.sdk.entities.SSHPublicKey sshpublickey) throws
            ClientProtocolException, ServerException, IOException {
        String url = this.parent.getHref() + SLASH + getName();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().add(url, sshpublickey,
                org.ovirt.engine.sdk.entities.SSHPublicKey.class,
                UserSSHPublicKey.class, headers);
    }
    /**
     * Adds SSHPublicKey object.
     *
     * @param sshpublickey {@link org.ovirt.engine.sdk.entities.SSHPublicKey}
     *    <pre>
     *    ssh_public_key.id|name
     *    </pre>
     *
     * @param correlationId
     *    <pre>
     *    [any string]
     *    </pre>
     * @return
     *     {@link UserSSHPublicKey }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public UserSSHPublicKey add(org.ovirt.engine.sdk.entities.SSHPublicKey sshpublickey, String correlationId) throws
            ClientProtocolException, ServerException, IOException {
        String url = this.parent.getHref() + SLASH + getName();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        if (correlationId != null) {
            headersBuilder.add("Correlation-Id", correlationId);
        }
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().add(url, sshpublickey,
                org.ovirt.engine.sdk.entities.SSHPublicKey.class,
                UserSSHPublicKey.class, headers);
    }
    /**
     * Adds SSHPublicKey object.
     *
     * @param sshpublickey {@link org.ovirt.engine.sdk.entities.SSHPublicKey}
     *    <pre>
     *    ssh_public_key.id|name
     *    </pre>
     *
     * @param correlationId
     *    <pre>
     *    [any string]
     *    </pre>
     * @param expect
     *    <pre>
     *    [201-created]
     *    </pre>
     * @return
     *     {@link UserSSHPublicKey }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public UserSSHPublicKey add(org.ovirt.engine.sdk.entities.SSHPublicKey sshpublickey, String correlationId, String expect) throws
            ClientProtocolException, ServerException, IOException {
        String url = this.parent.getHref() + SLASH + getName();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        if (correlationId != null) {
            headersBuilder.add("Correlation-Id", correlationId);
        }
        if (expect != null) {
            headersBuilder.add("Expect", expect);
        }
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().add(url, sshpublickey,
                org.ovirt.engine.sdk.entities.SSHPublicKey.class,
                UserSSHPublicKey.class, headers);
    }
    /**
     * Lists UserSSHPublicKey objects.
     *
     * @param max
     *    <pre>
     *    [max results]
     *    </pre>
     *
     * @return List of {@link UserSSHPublicKey }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public List<UserSSHPublicKey> list(Integer max) throws ClientProtocolException,
            ServerException, IOException {

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(this.parent.getHref() + SLASH + getName());
        if (max != null) {
            urlBuilder.add("max", max, UrlParameterType.MATRIX);
        }

        String url = urlBuilder.build();

        return list(url, org.ovirt.engine.sdk.entities.SSHPublicKeys.class,
                UserSSHPublicKey.class, headers);
    }

}
