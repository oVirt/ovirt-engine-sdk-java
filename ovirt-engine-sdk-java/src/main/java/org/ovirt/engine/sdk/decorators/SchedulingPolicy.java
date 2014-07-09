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
 * <p>SchedulingPolicy providing relation and functional services
 * <p>to {@link org.ovirt.engine.sdk.entities.SchedulingPolicy }.
 */
@SuppressWarnings("unused")
public class SchedulingPolicy extends
        org.ovirt.engine.sdk.entities.SchedulingPolicy {

    private HttpProxyBroker proxy;
    private final Object LOCK = new Object();

    private volatile SchedulingPolicyWeights schedulingPolicyWeights;
    private volatile SchedulingPolicyBalances schedulingPolicyBalances;
    private volatile SchedulingPolicyFilters schedulingPolicyFilters;


    /**
     * @param proxy HttpProxyBroker
     */
    public SchedulingPolicy(HttpProxyBroker proxy) {
        this.proxy = proxy;
    }

    /**
     * @return HttpProxyBroker
     */
    private HttpProxyBroker getProxy() {
        return proxy;
    }

    /**
     * Gets the value of the SchedulingPolicyWeights property.
     *
     * @return
     *     {@link SchedulingPolicyWeights }
     */
    public SchedulingPolicyWeights getWeights() {
        if (this.schedulingPolicyWeights == null) {
            synchronized (this.LOCK) {
                if (this.schedulingPolicyWeights == null) {
                    this.schedulingPolicyWeights = new SchedulingPolicyWeights(proxy, this);
                }
            }
        }
        return schedulingPolicyWeights;
    }
    /**
     * Gets the value of the SchedulingPolicyBalances property.
     *
     * @return
     *     {@link SchedulingPolicyBalances }
     */
    public SchedulingPolicyBalances getBalances() {
        if (this.schedulingPolicyBalances == null) {
            synchronized (this.LOCK) {
                if (this.schedulingPolicyBalances == null) {
                    this.schedulingPolicyBalances = new SchedulingPolicyBalances(proxy, this);
                }
            }
        }
        return schedulingPolicyBalances;
    }
    /**
     * Gets the value of the SchedulingPolicyFilters property.
     *
     * @return
     *     {@link SchedulingPolicyFilters }
     */
    public SchedulingPolicyFilters getFilters() {
        if (this.schedulingPolicyFilters == null) {
            synchronized (this.LOCK) {
                if (this.schedulingPolicyFilters == null) {
                    this.schedulingPolicyFilters = new SchedulingPolicyFilters(proxy, this);
                }
            }
        }
        return schedulingPolicyFilters;
    }


    /**
     * Updates SchedulingPolicy object.
     *
     * @param schedulingpolicy {@link org.ovirt.engine.sdk.entities.SchedulingPolicy}
     * @return
     *     {@link SchedulingPolicy }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public SchedulingPolicy update() throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().update(
                url,
                this,
                org.ovirt.engine.sdk.entities.SchedulingPolicy.class,
                SchedulingPolicy.class,
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

}

