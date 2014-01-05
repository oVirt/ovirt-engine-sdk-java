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
 * <p>DataCenterClusterGlusterVolumeGlusterBrick providing relation and functional services
 * <p>to {@link org.ovirt.engine.sdk.entities.GlusterBrick }.
 */
@SuppressWarnings("unused")
public class DataCenterClusterGlusterVolumeGlusterBrick extends
        org.ovirt.engine.sdk.entities.GlusterBrick {

    private HttpProxyBroker proxy;
    private final Object LOCK = new Object();

    private volatile DataCenterClusterGlusterVolumeGlusterBrickStatistics dataCenterClusterGlusterVolumeGlusterBrickStatistics;


    /**
     * @param proxy HttpProxyBroker
     */
    public DataCenterClusterGlusterVolumeGlusterBrick(HttpProxyBroker proxy) {
        this.proxy = proxy;
    }

    /**
     * @return HttpProxyBroker
     */
    private HttpProxyBroker getProxy() {
        return proxy;
    }

    /**
     * Gets the value of the DataCenterClusterGlusterVolumeGlusterBrickStatistics property.
     *
     * @return
     *     {@link DataCenterClusterGlusterVolumeGlusterBrickStatistics }
     */
    public DataCenterClusterGlusterVolumeGlusterBrickStatistics getStatistics() {
        if (this.dataCenterClusterGlusterVolumeGlusterBrickStatistics == null) {
            synchronized (this.LOCK) {
                if (this.dataCenterClusterGlusterVolumeGlusterBrickStatistics == null) {
                    this.dataCenterClusterGlusterVolumeGlusterBrickStatistics = new DataCenterClusterGlusterVolumeGlusterBrickStatistics(proxy, this);
                }
            }
        }
        return dataCenterClusterGlusterVolumeGlusterBrickStatistics;
    }


    /**
     * Performs replace action.
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
    public Action replace(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/replace";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

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

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().delete(url, Response.class, headers);
    }

}

