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
 * <p>ClusterCpuProfiles providing relation and functional services
 * <p>to {@link org.ovirt.engine.sdk.entities.CpuProfiles }.
 */
@SuppressWarnings("unused")
public class ClusterCpuProfiles extends
        CollectionDecorator<org.ovirt.engine.sdk.entities.CpuProfile,
                            org.ovirt.engine.sdk.entities.CpuProfiles,
                            ClusterCpuProfile> {

    private Cluster parent;

    /**
     * @param proxy HttpProxyBroker
     * @param parent Cluster
     */
    public ClusterCpuProfiles(HttpProxyBroker proxy, Cluster parent) {
        super(proxy, "cpuprofiles");
        this.parent = parent;
    }

    /**
     * Lists ClusterCpuProfile objects.
     *
     * @return
     *     List of {@link ClusterCpuProfile }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    @Override
    public List<ClusterCpuProfile> list() throws ClientProtocolException,
            ServerException, IOException {
        String url = this.parent.getHref() + SLASH + getName();
        return list(url, org.ovirt.engine.sdk.entities.CpuProfiles.class, ClusterCpuProfile.class);
    }

    /**
     * Fetches ClusterCpuProfile object by id.
     *
     * @return
     *     {@link ClusterCpuProfile }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    @Override
    public ClusterCpuProfile get(UUID id) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.parent.getHref() + SLASH + getName() + SLASH + id.toString();
        return getProxy().get(url, org.ovirt.engine.sdk.entities.CpuProfile.class, ClusterCpuProfile.class);
    }

    /**
     * Fetches ClusterCpuProfile object by id.
     *
     * @return
     *     {@link ClusterCpuProfile }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    @Override
    public ClusterCpuProfile getById(String id) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.parent.getHref() + SLASH + getName() + SLASH + id;
        return getProxy().get(url, org.ovirt.engine.sdk.entities.CpuProfile.class, ClusterCpuProfile.class);
    }

    /**
     * Lists ClusterCpuProfile objects.
     *
     * @param max
     *    <pre>
     *    [max results]
     *    </pre>
     *
     *
     * @return List of {@link ClusterCpuProfile }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public List<ClusterCpuProfile> list(Integer max) throws ClientProtocolException,
            ServerException, IOException {

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(this.parent.getHref() + SLASH + getName());
        if (max != null) {
            urlBuilder.add("max", max, UrlParameterType.MATRIX);
        }
        String url = urlBuilder.build();

        return list(url, org.ovirt.engine.sdk.entities.CpuProfiles.class,
                ClusterCpuProfile.class, headers);
    }
    /**
     * Adds CpuProfile object.
     *
     * @param cpuprofile {@link org.ovirt.engine.sdk.entities.CpuProfile}
     *    <pre>
     *    cpuprofile.name
     *    [cpuprofile.description]
     *    [cpuprofile.qos.id]
     *    </pre>
     *
     * @return
     *     {@link ClusterCpuProfile }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public ClusterCpuProfile add(org.ovirt.engine.sdk.entities.CpuProfile cpuprofile) throws
            ClientProtocolException, ServerException, IOException {
        String url = this.parent.getHref() + SLASH + getName();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().add(url, cpuprofile,
                org.ovirt.engine.sdk.entities.CpuProfile.class,
                ClusterCpuProfile.class, headers);
    }
    /**
     * Adds CpuProfile object.
     *
     * @param cpuprofile {@link org.ovirt.engine.sdk.entities.CpuProfile}
     *    <pre>
     *    cpuprofile.name
     *    [cpuprofile.description]
     *    [cpuprofile.qos.id]
     *    </pre>
     *
     * @param expect
     *    <pre>
     *    [201-created]
     *    </pre>
     *
     * @return
     *     {@link ClusterCpuProfile }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public ClusterCpuProfile add(org.ovirt.engine.sdk.entities.CpuProfile cpuprofile, String expect) throws
            ClientProtocolException, ServerException, IOException {
        String url = this.parent.getHref() + SLASH + getName();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        if (expect != null) {
            headersBuilder.add("Expect", expect);
        }
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().add(url, cpuprofile,
                org.ovirt.engine.sdk.entities.CpuProfile.class,
                ClusterCpuProfile.class, headers);
    }
    /**
     * Adds CpuProfile object.
     *
     * @param cpuprofile {@link org.ovirt.engine.sdk.entities.CpuProfile}
     *    <pre>
     *    cpuprofile.name
     *    [cpuprofile.description]
     *    [cpuprofile.qos.id]
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
     *     {@link ClusterCpuProfile }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public ClusterCpuProfile add(org.ovirt.engine.sdk.entities.CpuProfile cpuprofile, String expect, String correlationId) throws
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
        url = urlBuilder.build();

        return getProxy().add(url, cpuprofile,
                org.ovirt.engine.sdk.entities.CpuProfile.class,
                ClusterCpuProfile.class, headers);
    }

}

