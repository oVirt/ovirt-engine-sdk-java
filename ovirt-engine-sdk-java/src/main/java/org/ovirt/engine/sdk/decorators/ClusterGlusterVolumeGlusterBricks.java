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
 * <p>ClusterGlusterVolumeGlusterBricks providing relation and functional services
 * <p>to {@link org.ovirt.engine.sdk.entities.GlusterBricks }.
 */
@SuppressWarnings("unused")
public class ClusterGlusterVolumeGlusterBricks extends
        CollectionDecorator<org.ovirt.engine.sdk.entities.GlusterBrick,
                            org.ovirt.engine.sdk.entities.GlusterBricks,
                            ClusterGlusterVolumeGlusterBrick> {

    private ClusterGlusterVolume parent;

    /**
     * @param proxy HttpProxyBroker
     * @param parent ClusterGlusterVolume
     */
    public ClusterGlusterVolumeGlusterBricks(HttpProxyBroker proxy, ClusterGlusterVolume parent) {
        super(proxy, "bricks");
        this.parent = parent;
    }

    /**
     * Lists ClusterGlusterVolumeGlusterBrick objects.
     *
     * @return
     *     List of {@link ClusterGlusterVolumeGlusterBrick }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    @Override
    public List<ClusterGlusterVolumeGlusterBrick> list() throws ClientProtocolException,
            ServerException, IOException {
        String url = this.parent.getHref() + SLASH + getName();
        return list(url, org.ovirt.engine.sdk.entities.GlusterBricks.class, ClusterGlusterVolumeGlusterBrick.class);
    }

    /**
     * Fetches ClusterGlusterVolumeGlusterBrick object by id.
     *
     * @return
     *     {@link ClusterGlusterVolumeGlusterBrick }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    @Override
    public ClusterGlusterVolumeGlusterBrick get(UUID id) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.parent.getHref() + SLASH + getName() + SLASH + id.toString();
        return getProxy().get(url, org.ovirt.engine.sdk.entities.GlusterBrick.class, ClusterGlusterVolumeGlusterBrick.class);
    }

    /**
     * Fetches ClusterGlusterVolumeGlusterBrick object by id.
     *
     * @return
     *     {@link ClusterGlusterVolumeGlusterBrick }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    @Override
    public ClusterGlusterVolumeGlusterBrick getById(String id) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.parent.getHref() + SLASH + getName() + SLASH + id;
        return getProxy().get(url, org.ovirt.engine.sdk.entities.GlusterBrick.class, ClusterGlusterVolumeGlusterBrick.class);
    }

    /**
     * Performs activate action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    action.bricks
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
    public Action activate(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.parent.getHref() + SLASH + getName() +
                     SLASH +  "activate";

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
     *    action.bricks
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
    public Action activate(Action action, String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.parent.getHref() + SLASH + getName() +
                     SLASH +  "activate";

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
     * Performs stopmigrate action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    action.bricks
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
    public Action stopmigrate(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.parent.getHref() + SLASH + getName() +
                     SLASH +  "stopmigrate";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs stopmigrate action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    action.bricks
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
    public Action stopmigrate(Action action, String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.parent.getHref() + SLASH + getName() +
                     SLASH +  "stopmigrate";

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
     * Performs migrate action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    action.bricks
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
    public Action migrate(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.parent.getHref() + SLASH + getName() +
                     SLASH +  "migrate";

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
     *    action.bricks
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
    public Action migrate(Action action, String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.parent.getHref() + SLASH + getName() +
                     SLASH +  "migrate";

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
     * Lists ClusterGlusterVolumeGlusterBrick objects.
     *
     * @param max
     *    <pre>
     *    [max results]
     *    </pre>
     *
     *
     * @return List of {@link ClusterGlusterVolumeGlusterBrick }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public List<ClusterGlusterVolumeGlusterBrick> list(Integer max) throws ClientProtocolException,
            ServerException, IOException {

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(this.parent.getHref() + SLASH + getName());
        if (max != null) {
            urlBuilder.add("max", max, UrlParameterType.MATRIX);
        }
        String url = urlBuilder.build();

        return list(url, org.ovirt.engine.sdk.entities.GlusterBricks.class,
                ClusterGlusterVolumeGlusterBrick.class, headers);
    }
    /**
     * Adds GlusterBrick object.
     *
     * @param glusterbricks {@link org.ovirt.engine.sdk.entities.GlusterBricks}
     *    <pre>
     *    brick
     *    [replica_count]
     *    [stripe_count]
     *    </pre>
     *
     * @return
     *     {@link ClusterGlusterVolumeGlusterBrick }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public ClusterGlusterVolumeGlusterBrick add(org.ovirt.engine.sdk.entities.GlusterBrick glusterbrick) throws
            ClientProtocolException, ServerException, IOException {
        String url = this.parent.getHref() + SLASH + getName();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().add(url, glusterbrick,
                org.ovirt.engine.sdk.entities.GlusterBrick.class,
                ClusterGlusterVolumeGlusterBrick.class, headers);
    }
    /**
     * Adds GlusterBrick object.
     *
     * @param glusterbricks {@link org.ovirt.engine.sdk.entities.GlusterBricks}
     *    <pre>
     *    brick
     *    [replica_count]
     *    [stripe_count]
     *    </pre>
     *
     * @param force
     *    <pre>
     *    [true|false]
     *    </pre>
     *
     * @return
     *     {@link ClusterGlusterVolumeGlusterBrick }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public ClusterGlusterVolumeGlusterBrick add(org.ovirt.engine.sdk.entities.GlusterBrick glusterbrick, Boolean force) throws
            ClientProtocolException, ServerException, IOException {
        String url = this.parent.getHref() + SLASH + getName();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        if (force != null) {
            urlBuilder.add("force", force, UrlParameterType.MATRIX);
        }
        url = urlBuilder.build();

        return getProxy().add(url, glusterbrick,
                org.ovirt.engine.sdk.entities.GlusterBrick.class,
                ClusterGlusterVolumeGlusterBrick.class, headers);
    }
    /**
     * Adds GlusterBrick object.
     *
     * @param glusterbricks {@link org.ovirt.engine.sdk.entities.GlusterBricks}
     *    <pre>
     *    brick
     *    [replica_count]
     *    [stripe_count]
     *    </pre>
     *
     * @param expect
     *    <pre>
     *    [201-created]
     *    </pre>
     *
     * @param force
     *    <pre>
     *    [true|false]
     *    </pre>
     *
     * @return
     *     {@link ClusterGlusterVolumeGlusterBrick }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public ClusterGlusterVolumeGlusterBrick add(org.ovirt.engine.sdk.entities.GlusterBrick glusterbrick, Boolean force, String expect) throws
            ClientProtocolException, ServerException, IOException {
        String url = this.parent.getHref() + SLASH + getName();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        if (expect != null) {
            headersBuilder.add("Expect", expect);
        }
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        if (force != null) {
            urlBuilder.add("force", force, UrlParameterType.MATRIX);
        }
        url = urlBuilder.build();

        return getProxy().add(url, glusterbrick,
                org.ovirt.engine.sdk.entities.GlusterBrick.class,
                ClusterGlusterVolumeGlusterBrick.class, headers);
    }
    /**
     * Adds GlusterBrick object.
     *
     * @param glusterbricks {@link org.ovirt.engine.sdk.entities.GlusterBricks}
     *    <pre>
     *    brick
     *    [replica_count]
     *    [stripe_count]
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
     * @param force
     *    <pre>
     *    [true|false]
     *    </pre>
     *
     * @return
     *     {@link ClusterGlusterVolumeGlusterBrick }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public ClusterGlusterVolumeGlusterBrick add(org.ovirt.engine.sdk.entities.GlusterBrick glusterbrick, Boolean force, String expect, String correlationId) throws
            ClientProtocolException, ServerException, IOException {
        String url = this.parent.getHref() + SLASH + getName();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        if (expect != null) {
            headersBuilder.add("Expect", expect);
        }
        if (correlationId != null) {
            headersBuilder.add("Correlation-Id", correlationId);
        }
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        if (force != null) {
            urlBuilder.add("force", force, UrlParameterType.MATRIX);
        }
        url = urlBuilder.build();

        return getProxy().add(url, glusterbrick,
                org.ovirt.engine.sdk.entities.GlusterBrick.class,
                ClusterGlusterVolumeGlusterBrick.class, headers);
    }

}

