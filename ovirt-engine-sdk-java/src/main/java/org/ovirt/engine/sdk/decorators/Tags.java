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
import org.ovirt.engine.sdk.utils.HttpHeaderUtils;
import org.ovirt.engine.sdk.utils.UrlBuilder;
import org.ovirt.engine.sdk.utils.UrlHelper;
import org.ovirt.engine.sdk.web.HttpProxyBroker;
import org.ovirt.engine.sdk.web.UrlParameterType;
import org.ovirt.engine.sdk.entities.Action;

/**
 * <p>Tags providing relation and functional services
 * <p>to {@link org.ovirt.engine.sdk.entities.Tags } .
 */
@SuppressWarnings("unused")
public class Tags extends
        CollectionDecorator<org.ovirt.engine.sdk.entities.Tag, 
                            org.ovirt.engine.sdk.entities.Tags, 
                            Tag> {

    /**
     * @param proxy HttpProxyBroker
     */
    public Tags(HttpProxyBroker proxy) {
        super(proxy, "tags");
    }

    /**
     * Lists Tag objects.
     *
     * @return
     *     List of {@link Tag }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    @Override
    public List<Tag> list() throws ClientProtocolException,
            ServerException, IOException {
        String url = SLASH + getName();
        return list(url, org.ovirt.engine.sdk.entities.Tags.class, Tag.class);
    }

    /**
     * Fetches Tag object by id.
     *
     * @return {@link Tag }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    @Override
    public Tag get(UUID id) throws ClientProtocolException,
            ServerException, IOException {
        String url = SLASH + getName() + SLASH + id.toString();
        return getProxy().get(url, org.ovirt.engine.sdk.entities.Tag.class, Tag.class);
    }

    /**
     * Lists Tag objects.
     *
     * @param max
     *            max results
     *
     * @return List of {@link Tag }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public List<Tag> list(Integer max) throws ClientProtocolException,
            ServerException, IOException {
        String url = new UrlBuilder(SLASH + getName())
                .add("max", max, UrlParameterType.MATRIX)
                .build();
        return list(url, org.ovirt.engine.sdk.entities.Tags.class, Tag.class);
    }

    /**
     * Adds Tag object.
     *
     * @param tag
     *
     * <pre>
     * tag.name
     * [tag.description]
     * [tag.parent.name]
     * </pre>
     *
     * @return
     *     {@link Tag }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public Tag add(org.ovirt.engine.sdk.entities.Tag tag) throws 
            ClientProtocolException, ServerException, IOException {
        String url = SLASH + getName();
        return getProxy().add(url, tag, org.ovirt.engine.sdk.entities.Tag.class, Tag.class);
    }

}

