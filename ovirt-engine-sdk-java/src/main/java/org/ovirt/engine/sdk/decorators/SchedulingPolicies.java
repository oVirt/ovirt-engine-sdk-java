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
 * <p>SchedulingPolicies providing relation and functional services
 * <p>to {@link org.ovirt.engine.sdk.entities.SchedulingPolicies }.
 */
@SuppressWarnings("unused")
public class SchedulingPolicies extends
        CollectionDecorator<org.ovirt.engine.sdk.entities.SchedulingPolicy,
                            org.ovirt.engine.sdk.entities.SchedulingPolicies,
                            SchedulingPolicy> {

    /**
     * @param proxy HttpProxyBroker
     */
    public SchedulingPolicies(HttpProxyBroker proxy) {
        super(proxy, "schedulingpolicies");
    }

    /**
     * Lists SchedulingPolicy objects.
     *
     * @return
     *     List of {@link SchedulingPolicy }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    @Override
    public List<SchedulingPolicy> list() throws ClientProtocolException,
            ServerException, IOException {
        String url = SLASH + getName();
        return list(url, org.ovirt.engine.sdk.entities.SchedulingPolicies.class, SchedulingPolicy.class);
    }

    /**
     * Fetches SchedulingPolicy object by id.
     *
     * @return {@link SchedulingPolicy }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    @Override
    public SchedulingPolicy get(UUID id) throws ClientProtocolException,
            ServerException, IOException {
        String url = SLASH + getName() + SLASH + id.toString();
        return getProxy().get(url, org.ovirt.engine.sdk.entities.SchedulingPolicy.class, SchedulingPolicy.class);
    }

    /**
     * Fetches SchedulingPolicy object by id.
     *
     * @return {@link SchedulingPolicy }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    @Override
    public SchedulingPolicy getById(String id) throws ClientProtocolException,
            ServerException, IOException {
        String url = SLASH + getName() + SLASH + id;
        return getProxy().get(url, org.ovirt.engine.sdk.entities.SchedulingPolicy.class, SchedulingPolicy.class);
    }

    /**
     * Lists SchedulingPolicy objects.
     *
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
     * @return List of {@link SchedulingPolicy }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public List<SchedulingPolicy> list(Boolean caseSensitive, Integer max) throws ClientProtocolException,
            ServerException, IOException {

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(SLASH + getName());
        if (caseSensitive != null) {
            urlBuilder.add("case_sensitive", caseSensitive, UrlParameterType.MATRIX);
        }
        if (max != null) {
            urlBuilder.add("max", max, UrlParameterType.MATRIX);
        }
        String url = urlBuilder.build();

        return list(url, org.ovirt.engine.sdk.entities.SchedulingPolicies.class,
                SchedulingPolicy.class, headers);
    }
    /**
     * Adds SchedulingPolicy object.
     *
     * @param schedulingpolicy {@link org.ovirt.engine.sdk.entities.SchedulingPolicy}
     *    <pre>
     *    schedulingpolicy.name
     *    [schedulingpolicy.description]
     *    [schedulingpolicy.properties.property]
     *    </pre>
     *
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
    public SchedulingPolicy add(org.ovirt.engine.sdk.entities.SchedulingPolicy schedulingpolicy) throws
            ClientProtocolException, ServerException, IOException {
        String url = SLASH + getName();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().add(url, schedulingpolicy,
                org.ovirt.engine.sdk.entities.SchedulingPolicy.class,
                SchedulingPolicy.class, headers);
    }
    /**
     * Adds SchedulingPolicy object.
     *
     * @param schedulingpolicy {@link org.ovirt.engine.sdk.entities.SchedulingPolicy}
     *    <pre>
     *    schedulingpolicy.name
     *    [schedulingpolicy.description]
     *    [schedulingpolicy.properties.property]
     *    </pre>
     *
     * @param expect
     *    <pre>
     *    [201-created]
     *    </pre>
     *
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
    public SchedulingPolicy add(org.ovirt.engine.sdk.entities.SchedulingPolicy schedulingpolicy, String expect) throws
            ClientProtocolException, ServerException, IOException {
        String url = SLASH + getName();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        if (expect != null) {
            headersBuilder.add("Expect", expect);
        }
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().add(url, schedulingpolicy,
                org.ovirt.engine.sdk.entities.SchedulingPolicy.class,
                SchedulingPolicy.class, headers);
    }
    /**
     * Adds SchedulingPolicy object.
     *
     * @param schedulingpolicy {@link org.ovirt.engine.sdk.entities.SchedulingPolicy}
     *    <pre>
     *    schedulingpolicy.name
     *    [schedulingpolicy.description]
     *    [schedulingpolicy.properties.property]
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
     *     {@link SchedulingPolicy }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public SchedulingPolicy add(org.ovirt.engine.sdk.entities.SchedulingPolicy schedulingpolicy, String expect, String correlationId) throws
            ClientProtocolException, ServerException, IOException {
        String url = SLASH + getName();

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

        return getProxy().add(url, schedulingpolicy,
                org.ovirt.engine.sdk.entities.SchedulingPolicy.class,
                SchedulingPolicy.class, headers);
    }

}

