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

package org.ovirt.engine.sdk.common;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.ovirt.engine.sdk.entities.BaseResource;
import org.ovirt.engine.sdk.entities.BaseResources;
import org.ovirt.engine.sdk.exceptions.ServerException;
import org.ovirt.engine.sdk.mapping.Mapper;
import org.ovirt.engine.sdk.utils.CollectionUtils;
import org.ovirt.engine.sdk.utils.SerializationHelper;
import org.ovirt.engine.sdk.web.HttpProxyBroker;

/**
 * CollectionDecorator
 * 
 * @param <R>
 *            entity type
 * @param <Q>
 *            entity collection type
 * @param <Z>
 *            decorator type
 */
public abstract class CollectionDecorator<R extends BaseResource, Q extends BaseResources, Z extends R>
        extends Decorator {

    private String NAME;

    protected static final String SLASH = "/";

    /**
     * CollectionDecorator
     * 
     * @param proxy
     *            HttpProxy proxy
     * @param urlCollectionName
     *            collection name in URI context
     */
    public CollectionDecorator(HttpProxyBroker proxy, String urlCollectionName) {
        super(proxy);
        this.NAME = urlCollectionName;
    }

    /**
     * List entities in collection
     * 
     * @return List<Z>
     * 
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    abstract public List<Z> list() throws ClientProtocolException, ServerException, IOException;

    /**
     * Fetches entity from the collection by id
     * 
     * @param id
     *            entity id
     * 
     * @return Z
     * 
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    abstract public Z get(UUID id) throws ClientProtocolException, ServerException, IOException;

    /**
     * Fetches entity from the collection by id
     *
     * @param id
     *            entity id
     *
     * @return Z
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    abstract public Z getById(String id) throws ClientProtocolException, ServerException, IOException;

    /**
     * Fetches object by name.
     * 
     * @param name
     *            entity name
     * 
     * @return entity
     * 
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public Z get(String name) throws ClientProtocolException, ServerException, IOException {
        List<Z> collection = list();
        return CollectionUtils.getItemByName(name, collection);
    }

    /**
     * List entities in collection
     * 
     * @param url
     *            url to get the collection from
     * @param from
     *            convert from type
     * @param to
     *            convert to type
     * 
     * @return collection of items
     * 
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    protected List<Z> list(String url, Class<Q> from, Class<Z> to) throws ClientProtocolException,
            ServerException, IOException {
        return this.list(url, from, to, null);
    }

    /**
     * List entities in collection
     * 
     * @param url
     *            url to get the collection from
     * @param from
     *            convert from type
     * @param to
     *            convert to type
     * @param headers
     *            http headers to send
     * 
     * @return collection of items
     * 
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    protected List<Z> list(String url, Class<Q> from, Class<Z> to, List<Header> headers)
            throws ClientProtocolException, ServerException, IOException {
        String resXml = getProxy().get(url, headers);
        return unmarshall(from, to, resXml);
    }

    /**
     * Unmarshales collection of items from xml
     * 
     * @param from
     *            model type
     * @param to
     *            decorator type
     * @param xml
     *            string
     * 
     * @return List<Z> where Z is a decorator type
     */
    private List<Z> unmarshall(Class<Q> from, Class<Z> to, String xml) {
        List<Z> toColl = new ArrayList<Z>();
        Q collObj = SerializationHelper.unmarshall(from, xml);
        List<R> fromColl = fetchCollection(collObj);
        if (fromColl != null && !fromColl.isEmpty()) {
            for (R res : fromColl) {
                toColl.add(Mapper.map(res, to, getProxy()));
            }
        }
        return toColl;
    }

    /**
     * Fetches collection of items from server response
     * 
     * @param collection
     *            of public entities
     * 
     * @return List<R> where Z is a decorator type
     */
    @SuppressWarnings("unchecked")
    private List<R> fetchCollection(Q collection) {
        for (Method m : collection.getClass().getMethods()) {
            // TODO: make sure this is a right getter method
            if (m.getName().startsWith("get") && m.getReturnType().equals(List.class)) {
                try {
                    return (List<R>) m.invoke(collection);
                } catch (Exception e) {
                    e.printStackTrace();
                    // TODO: log exception
                }
            }
        }
        return null;
    }

    /**
     * @return collection name in URI context
     */
    protected String getName() {
        return this.NAME;
    }
}
