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
 * <p>Cluster providing relation and functional services
 * <p>to {@link org.ovirt.engine.sdk.entities.Cluster }.
 */
@SuppressWarnings("unused")
public class Cluster extends
        org.ovirt.engine.sdk.entities.Cluster {

    private HttpProxyBroker proxy;
    private final Object LOCK = new Object();

    private volatile ClusterGlusterHooks clusterGlusterHooks;
    private volatile ClusterAffinityGroups clusterAffinityGroups;
    private volatile ClusterGlusterVolumes clusterGlusterVolumes;
    private volatile ClusterNetworks clusterNetworks;
    private volatile ClusterCpuProfiles clusterCpuProfiles;
    private volatile ClusterPermissions clusterPermissions;


    /**
     * @param proxy HttpProxyBroker
     */
    public Cluster(HttpProxyBroker proxy) {
        this.proxy = proxy;
    }

    /**
     * @return HttpProxyBroker
     */
    private HttpProxyBroker getProxy() {
        return proxy;
    }

    /**
     * Gets the value of the ClusterGlusterHooks property.
     *
     * @return
     *     {@link ClusterGlusterHooks }
     */
    public ClusterGlusterHooks getGlusterHooks() {
        if (this.clusterGlusterHooks == null) {
            synchronized (this.LOCK) {
                if (this.clusterGlusterHooks == null) {
                    this.clusterGlusterHooks = new ClusterGlusterHooks(proxy, this);
                }
            }
        }
        return clusterGlusterHooks;
    }
    /**
     * Gets the value of the ClusterAffinityGroups property.
     *
     * @return
     *     {@link ClusterAffinityGroups }
     */
    public ClusterAffinityGroups getAffinityGroups() {
        if (this.clusterAffinityGroups == null) {
            synchronized (this.LOCK) {
                if (this.clusterAffinityGroups == null) {
                    this.clusterAffinityGroups = new ClusterAffinityGroups(proxy, this);
                }
            }
        }
        return clusterAffinityGroups;
    }
    /**
     * Gets the value of the ClusterGlusterVolumes property.
     *
     * @return
     *     {@link ClusterGlusterVolumes }
     */
    public ClusterGlusterVolumes getGlusterVolumes() {
        if (this.clusterGlusterVolumes == null) {
            synchronized (this.LOCK) {
                if (this.clusterGlusterVolumes == null) {
                    this.clusterGlusterVolumes = new ClusterGlusterVolumes(proxy, this);
                }
            }
        }
        return clusterGlusterVolumes;
    }
    /**
     * Gets the value of the ClusterNetworks property.
     *
     * @return
     *     {@link ClusterNetworks }
     */
    public ClusterNetworks getNetworks() {
        if (this.clusterNetworks == null) {
            synchronized (this.LOCK) {
                if (this.clusterNetworks == null) {
                    this.clusterNetworks = new ClusterNetworks(proxy, this);
                }
            }
        }
        return clusterNetworks;
    }
    /**
     * Gets the value of the ClusterCpuProfiles property.
     *
     * @return
     *     {@link ClusterCpuProfiles }
     */
    public ClusterCpuProfiles getCpuProfiles() {
        if (this.clusterCpuProfiles == null) {
            synchronized (this.LOCK) {
                if (this.clusterCpuProfiles == null) {
                    this.clusterCpuProfiles = new ClusterCpuProfiles(proxy, this);
                }
            }
        }
        return clusterCpuProfiles;
    }
    /**
     * Gets the value of the ClusterPermissions property.
     *
     * @return
     *     {@link ClusterPermissions }
     */
    public ClusterPermissions getPermissions() {
        if (this.clusterPermissions == null) {
            synchronized (this.LOCK) {
                if (this.clusterPermissions == null) {
                    this.clusterPermissions = new ClusterPermissions(proxy, this);
                }
            }
        }
        return clusterPermissions;
    }


    /**
     * Updates Cluster object.
     *
     * @param cluster {@link org.ovirt.engine.sdk.entities.Cluster}
     *    <pre>
     *    [cluster.name]
     *    [cluster.description]
     *    [cluster.comment]
     *    [cluster.data_center.id]
     *    [cluster.cpu.id]
     *    [cluster.version.major]
     *    [cluster.version.minor]
     *    [cluster.memory_policy.overcommit.percent]
     *    [cluster.memory_policy.transparent_hugepages.enabled]
     *    [cluster.scheduling_policy.policy]
     *    [cluster.scheduling_policy.thresholds.low]
     *    [cluster.scheduling_policy.thresholds.high]
     *    [cluster.scheduling_policy.thresholds.duration]
     *    [cluster.scheduling_policy.id]
     *    [cluster.scheduling_policy.properties.property]
     *    [cluster.error_handling.on_error]
     *    [cluster.virt_service]
     *    [cluster.gluster_service]
     *    [cluster.threads_as_cores]
     *    [cluster.tunnel_migration]
     *    [cluster.ballooning_enabled]
     *    [cluster.cpu.architecture]
     *    [cluster.display.proxy]
     *    [cluster.ksm.enabled]
     *    [cluster.fencing_policy.enabled]
     *    [cluster.fencing_policy.skip_if_sd_active.enabled]
     *    [cluster.fencing_policy.skip_if_connectivity_broken.enabled]
     *    [cluster.fencing_policy.skip_if_connectivity_broken.threshold]
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
    public Cluster update() throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().update(
                url,
                this,
                org.ovirt.engine.sdk.entities.Cluster.class,
                Cluster.class,
                headers);
    }
    /**
     * Updates Cluster object.
     *
     * @param cluster {@link org.ovirt.engine.sdk.entities.Cluster}
     *    <pre>
     *    [cluster.name]
     *    [cluster.description]
     *    [cluster.comment]
     *    [cluster.data_center.id]
     *    [cluster.cpu.id]
     *    [cluster.version.major]
     *    [cluster.version.minor]
     *    [cluster.memory_policy.overcommit.percent]
     *    [cluster.memory_policy.transparent_hugepages.enabled]
     *    [cluster.scheduling_policy.policy]
     *    [cluster.scheduling_policy.thresholds.low]
     *    [cluster.scheduling_policy.thresholds.high]
     *    [cluster.scheduling_policy.thresholds.duration]
     *    [cluster.scheduling_policy.id]
     *    [cluster.scheduling_policy.properties.property]
     *    [cluster.error_handling.on_error]
     *    [cluster.virt_service]
     *    [cluster.gluster_service]
     *    [cluster.threads_as_cores]
     *    [cluster.tunnel_migration]
     *    [cluster.ballooning_enabled]
     *    [cluster.cpu.architecture]
     *    [cluster.display.proxy]
     *    [cluster.ksm.enabled]
     *    [cluster.fencing_policy.enabled]
     *    [cluster.fencing_policy.skip_if_sd_active.enabled]
     *    [cluster.fencing_policy.skip_if_connectivity_broken.enabled]
     *    [cluster.fencing_policy.skip_if_connectivity_broken.threshold]
     *    </pre>
     *
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
    public Cluster update(String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        if (correlationId != null) {
            headersBuilder.add("Correlation-Id", correlationId);
        }
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().update(
                url,
                this,
                org.ovirt.engine.sdk.entities.Cluster.class,
                Cluster.class,
                headers);
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

}

