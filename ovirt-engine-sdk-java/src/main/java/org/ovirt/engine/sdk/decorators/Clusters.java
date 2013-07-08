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
 * <p>Clusters providing relation and functional services
 * <p>to {@link org.ovirt.engine.sdk.entities.Clusters }.
 */
@SuppressWarnings("unused")
public class Clusters extends
        CollectionDecorator<org.ovirt.engine.sdk.entities.Cluster,
                            org.ovirt.engine.sdk.entities.Clusters,
                            Cluster> {

    /**
     * @param proxy HttpProxyBroker
     */
    public Clusters(HttpProxyBroker proxy) {
        super(proxy, "clusters");
    }

    /**
     * Lists Cluster objects.
     *
     * @return
     *     List of {@link Cluster }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    @Override
    public List<Cluster> list() throws ClientProtocolException,
            ServerException, IOException {
        String url = SLASH + getName();
        return list(url, org.ovirt.engine.sdk.entities.Clusters.class, Cluster.class);
    }

    /**
     * Fetches Cluster object by id.
     *
     * @return {@link Cluster }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    @Override
    public Cluster get(UUID id) throws ClientProtocolException,
            ServerException, IOException {
        String url = SLASH + getName() + SLASH + id.toString();
        return getProxy().get(url, org.ovirt.engine.sdk.entities.Cluster.class, Cluster.class);
    }

    /**
     * Lists Cluster objects.
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
     * @return List of {@link Cluster }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public List<Cluster> list(String query, Boolean caseSensitive, Integer max) throws ClientProtocolException,
            ServerException, IOException {

        List<Header> headers = new HttpHeaderBuilder()
                .build();

        String url = new UrlBuilder(SLASH + getName())
                .add("search", query, UrlParameterType.QUERY)
                .add("case_sensitive", caseSensitive, UrlParameterType.MATRIX)
                .add("max", max, UrlParameterType.MATRIX)
                .build();

        return list(url, org.ovirt.engine.sdk.entities.Clusters.class,
                Cluster.class, headers);
    }
    /**
     * Adds Cluster object.
     *
     * @param cluster {@link org.ovirt.engine.sdk.entities.Cluster}
     *    <pre>
     *    cluster.data_center.id|name
     *    cluster.name
     *    cluster.version.major
     *    cluster.version.minor
     *    cluster.cpu.id
     *    [cluster.description]
     *    [cluster.memory_policy.overcommit.percent]
     *    [cluster.memory_policy.transparent_hugepages.enabled]
     *    [cluster.scheduling_policy.policy]
     *    [cluster.scheduling_policy.thresholds.low]
     *    [cluster.scheduling_policy.thresholds.high]
     *    [cluster.scheduling_policy.thresholds.duration]
     *    [cluster.error_handling.on_error]
     *    [cluster.virt_service]
     *    [cluster.gluster_service]
     *    [cluster.threads_as_cores]
     *    [cluster.tunnel_migration]
     *    [cluster.trusted_service]
     *    </pre>
     *
     * @return
     *     {@link Cluster }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public Cluster add(org.ovirt.engine.sdk.entities.Cluster cluster) throws
            ClientProtocolException, ServerException, IOException {
        String url = SLASH + getName();

        List<Header> headers = new HttpHeaderBuilder()
                .build();

        url = new UrlBuilder(url)
                .build();

        return getProxy().add(url, cluster,
                org.ovirt.engine.sdk.entities.Cluster.class,
                Cluster.class, headers);
    }
    /**
     * Adds Cluster object.
     *
     * @param cluster {@link org.ovirt.engine.sdk.entities.Cluster}
     *    <pre>
     *    cluster.data_center.id|name
     *    cluster.name
     *    cluster.version.major
     *    cluster.version.minor
     *    cluster.cpu.id
     *    [cluster.description]
     *    [cluster.memory_policy.overcommit.percent]
     *    [cluster.memory_policy.transparent_hugepages.enabled]
     *    [cluster.scheduling_policy.policy]
     *    [cluster.scheduling_policy.thresholds.low]
     *    [cluster.scheduling_policy.thresholds.high]
     *    [cluster.scheduling_policy.thresholds.duration]
     *    [cluster.error_handling.on_error]
     *    [cluster.virt_service]
     *    [cluster.gluster_service]
     *    [cluster.threads_as_cores]
     *    [cluster.tunnel_migration]
     *    [cluster.trusted_service]
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
     *     {@link Cluster }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public Cluster add(org.ovirt.engine.sdk.entities.Cluster cluster, String expect, String correlationId) throws
            ClientProtocolException, ServerException, IOException {
        String url = SLASH + getName();

        List<Header> headers = new HttpHeaderBuilder()
                .add("Expect", expect)
                .add("Correlation-Id", correlationId)
                .build();

        url = new UrlBuilder(url)
                .build();

        return getProxy().add(url, cluster,
                org.ovirt.engine.sdk.entities.Cluster.class,
                Cluster.class, headers);
    }

}

