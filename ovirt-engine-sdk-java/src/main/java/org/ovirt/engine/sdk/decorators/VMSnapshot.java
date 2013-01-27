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


/**
 * <p>VMSnapshot providing relation and functional services
 * <p>to {@link org.ovirt.engine.sdk.entities.Snapshot }. 
 */
@SuppressWarnings("unused")
public class VMSnapshot extends
        org.ovirt.engine.sdk.entities.Snapshot {

    private HttpProxyBroker proxy;

    private VMSnapshotNics vMSnapshotNics;
    private VMSnapshotDisks vMSnapshotDisks;
    private VMSnapshotCdRoms vMSnapshotCdRoms;


    /**
     * @param proxy HttpProxyBroker
     */
    public VMSnapshot(HttpProxyBroker proxy) {
        this.proxy = proxy;
    }

    /**
     * @return HttpProxyBroker
     */
    private HttpProxyBroker getProxy() {
        return proxy;
    }

    /**
     * Gets the value of the VMSnapshotNics property.
     *
     * @return
     *     {@link VMSnapshotNics }
     */
    public synchronized VMSnapshotNics getNics() {
        if (this.vMSnapshotNics == null) {
            this.vMSnapshotNics = new VMSnapshotNics(proxy, this);
        }
        return vMSnapshotNics;
    }
    /**
     * Gets the value of the VMSnapshotDisks property.
     *
     * @return
     *     {@link VMSnapshotDisks }
     */
    public synchronized VMSnapshotDisks getDisks() {
        if (this.vMSnapshotDisks == null) {
            this.vMSnapshotDisks = new VMSnapshotDisks(proxy, this);
        }
        return vMSnapshotDisks;
    }
    /**
     * Gets the value of the VMSnapshotCdRoms property.
     *
     * @return
     *     {@link VMSnapshotCdRoms }
     */
    public synchronized VMSnapshotCdRoms getCdRoms() {
        if (this.vMSnapshotCdRoms == null) {
            this.vMSnapshotCdRoms = new VMSnapshotCdRoms(proxy, this);
        }
        return vMSnapshotCdRoms;
    }


    /**
     * Performs restore action.
     *
     * @param action
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
    public Action restore(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/restore";

        List<Header> headers = new HttpHeaderBuilder()
                .build();

        url = new UrlBuilder(url)
                .build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs restore action.
     *
     * @param action
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
    public Action restore(Action action, String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/restore";

        List<Header> headers = new HttpHeaderBuilder()
                .add("Correlation-Id", correlationId)
                .build();

        url = new UrlBuilder(url)
                .build();

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
        return getProxy().delete(url, Response.class);
    }

}

