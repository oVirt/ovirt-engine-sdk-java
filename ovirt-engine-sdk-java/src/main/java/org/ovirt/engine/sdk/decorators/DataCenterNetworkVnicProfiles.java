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
 * <p>DataCenterNetworkVnicProfiles providing relation and functional services
 * <p>to {@link org.ovirt.engine.sdk.entities.VnicProfiles }.
 */
@SuppressWarnings("unused")
public class DataCenterNetworkVnicProfiles extends
        CollectionDecorator<org.ovirt.engine.sdk.entities.VnicProfile,
                            org.ovirt.engine.sdk.entities.VnicProfiles,
                            DataCenterNetworkVnicProfile> {

    private DataCenterNetwork parent;

    /**
     * @param proxy HttpProxyBroker
     * @param parent DataCenterNetwork
     */
    public DataCenterNetworkVnicProfiles(HttpProxyBroker proxy, DataCenterNetwork parent) {
        super(proxy, "vnicprofiles");
        this.parent = parent;
    }

    /**
     * Lists DataCenterNetworkVnicProfile objects.
     *
     * @return
     *     List of {@link DataCenterNetworkVnicProfile }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    @Override
    public List<DataCenterNetworkVnicProfile> list() throws ClientProtocolException,
            ServerException, IOException {
        String url = this.parent.getHref() + SLASH + getName();
        return list(url, org.ovirt.engine.sdk.entities.VnicProfiles.class, DataCenterNetworkVnicProfile.class);
    }

    /**
     * Fetches DataCenterNetworkVnicProfile object by id.
     *
     * @return
     *     {@link DataCenterNetworkVnicProfile }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    @Override
    public DataCenterNetworkVnicProfile get(UUID id) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.parent.getHref() + SLASH + getName() + SLASH + id.toString();
        return getProxy().get(url, org.ovirt.engine.sdk.entities.VnicProfile.class, DataCenterNetworkVnicProfile.class);
    }

    /**
     * Fetches DataCenterNetworkVnicProfile object by id.
     *
     * @return
     *     {@link DataCenterNetworkVnicProfile }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    @Override
    public DataCenterNetworkVnicProfile getById(String id) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.parent.getHref() + SLASH + getName() + SLASH + id;
        return getProxy().get(url, org.ovirt.engine.sdk.entities.VnicProfile.class, DataCenterNetworkVnicProfile.class);
    }

    /**
     * Adds VnicProfile object.
     *
     * @param vnicprofile {@link org.ovirt.engine.sdk.entities.VnicProfile}
     * @return
     *     {@link DataCenterNetworkVnicProfile }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public DataCenterNetworkVnicProfile add(org.ovirt.engine.sdk.entities.VnicProfile vnicprofile) throws
            ClientProtocolException, ServerException, IOException {
        String url = this.parent.getHref() + SLASH + getName();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().add(url, vnicprofile,
                org.ovirt.engine.sdk.entities.VnicProfile.class,
                DataCenterNetworkVnicProfile.class, headers);
    }

}

