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
 * <p>DataCenterCluster providing relation and functional services
 * <p>to {@link org.ovirt.engine.sdk.entities.Cluster }.
 */
@SuppressWarnings("unused")
public class DataCenterCluster extends
        org.ovirt.engine.sdk.entities.Cluster {

    private HttpProxyBroker proxy;

    private DataCenterClusterPermissions dataCenterClusterPermissions;
    private DataCenterClusterGlusterVolumes dataCenterClusterGlusterVolumes;
    private DataCenterClusterNetworks dataCenterClusterNetworks;


    /**
     * @param proxy HttpProxyBroker
     */
    public DataCenterCluster(HttpProxyBroker proxy) {
        this.proxy = proxy;
    }

    /**
     * @return HttpProxyBroker
     */
    private HttpProxyBroker getProxy() {
        return proxy;
    }

    /**
     * Gets the value of the DataCenterClusterPermissions property.
     *
     * @return
     *     {@link DataCenterClusterPermissions }
     */
    public synchronized DataCenterClusterPermissions getPermissions() {
        if (this.dataCenterClusterPermissions == null) {
            this.dataCenterClusterPermissions = new DataCenterClusterPermissions(proxy, this);
        }
        return dataCenterClusterPermissions;
    }
    /**
     * Gets the value of the DataCenterClusterGlusterVolumes property.
     *
     * @return
     *     {@link DataCenterClusterGlusterVolumes }
     */
    public synchronized DataCenterClusterGlusterVolumes getGlusterVolumes() {
        if (this.dataCenterClusterGlusterVolumes == null) {
            this.dataCenterClusterGlusterVolumes = new DataCenterClusterGlusterVolumes(proxy, this);
        }
        return dataCenterClusterGlusterVolumes;
    }
    /**
     * Gets the value of the DataCenterClusterNetworks property.
     *
     * @return
     *     {@link DataCenterClusterNetworks }
     */
    public synchronized DataCenterClusterNetworks getNetworks() {
        if (this.dataCenterClusterNetworks == null) {
            this.dataCenterClusterNetworks = new DataCenterClusterNetworks(proxy, this);
        }
        return dataCenterClusterNetworks;
    }


    /**
     * Updates DataCenterCluster object.
     *
     * @param cluster {@link org.ovirt.engine.sdk.entities.Cluster}
     *    <pre>
     *    [cluster.name]
     *    [cluster.description]
     *    [cluster.cpu.id]
     *    [cluster.version.major]
     *    [cluster.version.minor]
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
     *    </pre>
     *
     * @return
     *     {@link DataCenterCluster }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public DataCenterCluster update() throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref();
        return getProxy().update(url, this, org.ovirt.engine.sdk.entities.Cluster.class, DataCenterCluster.class);
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

}

