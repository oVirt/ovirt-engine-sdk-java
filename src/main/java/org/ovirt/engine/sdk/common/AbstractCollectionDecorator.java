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

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.ovirt.engine.api.model.BaseResource;
import org.ovirt.engine.api.model.BaseResources;
import org.ovirt.engine.sdk.utils.Mapper;
import org.ovirt.engine.sdk.utils.SerializationHelper;
import org.ovirt.engine.sdk.web.HttpProxy;

public abstract class AbstractCollectionDecorator<R extends BaseResource, Q extends BaseResources, Z extends R>
        extends AbstractDecorator {

    private HttpProxy proxy;

    public AbstractCollectionDecorator(HttpProxy proxy) {
        super();
        this.proxy = proxy;
    }

    abstract public List<Z> list() throws Exception;

    abstract public Z get(String id) throws Exception;

    protected List<Z> unmarshallCollection(Class<Q> from, Class<Z> to, String xml) throws JAXBException {
        List<Z> toColl = new ArrayList<Z>();
        Q collection = SerializationHelper.unmarshall(from, xml);
        List<R> fromColl = fetchCollection(collection);
        if (fromColl != null && !fromColl.isEmpty()) {
            for (R res : fromColl) {
                toColl.add(Mapper.map(res, to, getProxy()));
            }
        }

        return toColl;
    }

    protected Z unmarshallResource(Class<R> from, Class<Z> to, String xml) throws JAXBException {
        R res = SerializationHelper.unmarshall(from, xml);
        return Mapper.map(res, to, getProxy());
        // return Mapper.map(from, to, xml, getProxy());
    }

    @SuppressWarnings("unchecked")
    private List<R> fetchCollection(Q collection) {
        for (Method m : collection.getClass().getMethods()) {
            // TODO: make sure this is a right getter method
            if (m.getName().startsWith("get") && m.getReturnType().equals(List.class)) {
                try {
                    return (List<R>) m.invoke(collection);
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                    // TODO: log exception
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    // TODO: log exception
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                    // TODO: log exception
                }
            }
        }
        return null;
    }

    public HttpProxy getProxy() {
        return proxy;
    }
}
