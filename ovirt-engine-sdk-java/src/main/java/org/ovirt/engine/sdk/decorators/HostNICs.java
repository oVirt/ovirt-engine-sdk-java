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
 * <p>HostNICs providing relation and functional services
 * <p>to {@link org.ovirt.engine.sdk.entities.HostNics }.
 */
@SuppressWarnings("unused")
public class HostNICs extends
        CollectionDecorator<org.ovirt.engine.sdk.entities.HostNIC,
                            org.ovirt.engine.sdk.entities.HostNics,
                            HostNIC> {

    private Host parent;

    /**
     * @param proxy HttpProxyBroker
     * @param parent Host
     */
    public HostNICs(HttpProxyBroker proxy, Host parent) {
        super(proxy, "nics");
        this.parent = parent;
    }

    /**
     * Lists HostNIC objects.
     *
     * @return
     *     List of {@link HostNIC }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    @Override
    public List<HostNIC> list() throws ClientProtocolException,
            ServerException, IOException {
        String url = this.parent.getHref() + SLASH + getName();
        return list(url, org.ovirt.engine.sdk.entities.HostNics.class, HostNIC.class);
    }

    /**
     * Fetches HostNIC object by id.
     * 
     * @return
     *     {@link HostNIC }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    @Override
    public HostNIC get(UUID id) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.parent.getHref() + SLASH + getName() + SLASH + id.toString();
        return getProxy().get(url, org.ovirt.engine.sdk.entities.HostNIC.class, HostNIC.class);
    }

    /**
     * Performs setupnetworks action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    [action.host_nics.host_nic]
     *    [action.checkConnectivity]
     *    [action.connectivityTimeout]
     *    [action.force]
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
    public Action setupnetworks(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.parent.getHref() + SLASH + "setupnetworks";

        List<Header> headers = new HttpHeaderBuilder()
                .build();

        url = new UrlBuilder(url)
                .build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs setupnetworks action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     *    <pre>
     *    [action.host_nics.host_nic]
     *    [action.checkConnectivity]
     *    [action.connectivityTimeout]
     *    [action.force]
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
    public Action setupnetworks(Action action, String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.parent.getHref() + SLASH + "setupnetworks";

        List<Header> headers = new HttpHeaderBuilder()
                .add("Correlation-Id", correlationId)
                .build();

        url = new UrlBuilder(url)
                .build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Lists HostNIC objects.
     *
     * @param max
     *            max results
     *
     * @return List of {@link HostNIC }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public List<HostNIC> list(Integer max) throws ClientProtocolException,
            ServerException, IOException {
        String url = new UrlBuilder(this.parent.getHref() + SLASH + getName())
                .add("max", max, UrlParameterType.MATRIX)
                .build();
        return list(url, org.ovirt.engine.sdk.entities.HostNics.class, HostNIC.class);
    }

    /**
     * Adds HostNIC object.
     *
     * @param hostnic {@link org.ovirt.engine.sdk.entities.HostNIC}
     *    <pre>
     *    hostnic.network.id|name
     *    hostnic.name
     *    hostnic.bonding.slaves.host_nic
     *    [hostnic.bonding.options.option]
     *    </pre>
     *
     * @return
     *     {@link HostNIC }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public HostNIC add(org.ovirt.engine.sdk.entities.HostNIC hostnic) throws 
            ClientProtocolException, ServerException, IOException {
        String url = this.parent.getHref() + SLASH + getName();
        return getProxy().add(url, hostnic, org.ovirt.engine.sdk.entities.HostNIC.class, HostNIC.class);
    }

}

