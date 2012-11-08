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
import java.util.List;

import javax.xml.bind.JAXBException;

import org.ovirt.engine.api.model.BaseResource;
import org.ovirt.engine.api.model.BaseResources;
import org.ovirt.engine.sdk.utils.SerializationHelper;

public abstract class AbstractBackendCollection<R extends BaseResource, Q extends BaseResources> {

    abstract public List<R> list() throws Exception;

    abstract public R get(String id) throws Exception;

    protected List<R> unmarshallCollection(Class<Q> clz, String xml) throws JAXBException {
        Q collection = SerializationHelper.unmarshall(clz, xml);
        return fetchCollection(collection);
    }

    protected R unmarshallResource(Class<R> clz, String xml) throws JAXBException {
        return SerializationHelper.unmarshall(clz, xml);
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
}
