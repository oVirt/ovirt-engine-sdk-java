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
 * <p>DataCenterClusterGlusterVolumes providing relation and functional services
 * <p>to {@link org.ovirt.engine.sdk.entities.GlusterVolumes }.
 */
@SuppressWarnings("unused")
public class DataCenterClusterGlusterVolumes extends
        CollectionDecorator<org.ovirt.engine.sdk.entities.GlusterVolume,
                            org.ovirt.engine.sdk.entities.GlusterVolumes,
                            DataCenterClusterGlusterVolume> {

    private DataCenterCluster parent;

    /**
     * @param proxy HttpProxyBroker
     * @param parent DataCenterCluster
     */
    public DataCenterClusterGlusterVolumes(HttpProxyBroker proxy, DataCenterCluster parent) {
        super(proxy, "glustervolumes");
        this.parent = parent;
    }

    /**
     * Lists DataCenterClusterGlusterVolume objects.
     *
     * @return
     *     List of {@link DataCenterClusterGlusterVolume }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    @Override
    public List<DataCenterClusterGlusterVolume> list() throws ClientProtocolException,
            ServerException, IOException {
        String url = this.parent.getHref() + SLASH + getName();
        return list(url, org.ovirt.engine.sdk.entities.GlusterVolumes.class, DataCenterClusterGlusterVolume.class);
    }

    /**
     * Fetches DataCenterClusterGlusterVolume object by id.
     *
     * @return
     *     {@link DataCenterClusterGlusterVolume }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    @Override
    public DataCenterClusterGlusterVolume get(UUID id) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.parent.getHref() + SLASH + getName() + SLASH + id.toString();
        return getProxy().get(url, org.ovirt.engine.sdk.entities.GlusterVolume.class, DataCenterClusterGlusterVolume.class);
    }

    /**
     * Fetches DataCenterClusterGlusterVolume object by id.
     *
     * @return
     *     {@link DataCenterClusterGlusterVolume }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    @Override
    public DataCenterClusterGlusterVolume getById(String id) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.parent.getHref() + SLASH + getName() + SLASH + id;
        return getProxy().get(url, org.ovirt.engine.sdk.entities.GlusterVolume.class, DataCenterClusterGlusterVolume.class);
    }

    /**
     * Adds GlusterVolume object.
     *
     * @param glustervolume {@link org.ovirt.engine.sdk.entities.GlusterVolume}
     * @return
     *     {@link DataCenterClusterGlusterVolume }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public DataCenterClusterGlusterVolume add(org.ovirt.engine.sdk.entities.GlusterVolume glustervolume) throws
            ClientProtocolException, ServerException, IOException {
        String url = this.parent.getHref() + SLASH + getName();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().add(url, glustervolume,
                org.ovirt.engine.sdk.entities.GlusterVolume.class,
                DataCenterClusterGlusterVolume.class, headers);
    }

}

