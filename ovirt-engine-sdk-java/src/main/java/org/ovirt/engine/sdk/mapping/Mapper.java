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

package org.ovirt.engine.sdk.mapping;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import javax.xml.bind.JAXBException;

import org.apache.commons.beanutils.PropertyUtils;
import org.ovirt.engine.sdk.utils.SerializationHelper;
import org.ovirt.engine.sdk.web.HttpProxyBroker;

/**
 * Provides model2decorator mapping services
 */
public class Mapper {

    private static String[] MAPPING_EXCEPTIONS = new String[] { "links", "actions" };

    /**
     * Maps model object to defined decorator
     * 
     * @param from
     *            model object
     * @param to
     *            decorator object
     * @param proxy
     *            HttpProxyDecorator to inject
     * 
     * @return Decorator instance
     */
    @SuppressWarnings("unchecked")
    public static synchronized <F, T> T map(F from, Class<T> to, HttpProxyBroker proxy) {
        T dstobj = null;
        try {
            if (proxy != null) {
                dstobj = (T) getConstracor(to).newInstance(proxy);
            } else {
                dstobj = to.newInstance();
            }
            if (dstobj != null) {
                PropertyUtils.copyProperties(dstobj, from);
                excludeExceptions(dstobj);
            }
        } catch (InstantiationException e) {
            // TODO: log error
            e.printStackTrace();
        } catch (IllegalAccessException | NoSuchMethodException |
                InvocationTargetException e) {
            // do nothing (PropertyUtils exceptions treatment #1007266)
        } catch (IllegalArgumentException e) {
            // TODO: log error
            e.printStackTrace();
        }

        return dstobj;
    }

    /**
     * Excludes mapping exceptions
     * 
     * @param dstobj
     */
    private static <T> void excludeExceptions(T dstobj) {
        for (String field : MAPPING_EXCEPTIONS) {
            try {
                PropertyUtils.setProperty(dstobj, field, null);
            } catch (IllegalAccessException | InvocationTargetException |
                    NoSuchMethodException e) {
                // do nothing (PropertyUtils exceptions treatment #1007266)
            }
        }
    }

    /**
     * Maps model object to defined decorator
     * 
     * @param from
     *            model object
     * @param to
     *            decorator object
     * 
     * @return Decorator instance
     */
    public static synchronized <F, T> T map(F from, Class<T> to) {
        return Mapper.map(from, to, null);
    }

    /**
     * Fetches class contractor for mapping context
     * 
     * @param to
     *            class to look at
     * 
     * @return .ctr
     * 
     * @throws NoSuchMethodException
     */
    private static <T> Constructor<?> getConstracor(Class<T> to) throws NoSuchMethodException {
        for (Constructor<?> ctr : to.getConstructors()) {
            if (ctr.getParameterTypes().length > 0 &&
                    ctr.getParameterTypes()[0].equals(HttpProxyBroker.class)) {
                return ctr;
            }
        }
        throw new NoSuchMethodException("HttpProxyBroker");
    }

    /**
     * Maps model object to defined decorator
     * 
     * @param from
     *            model object
     * @param to
     *            decorator object
     * @param xml
     *            string to unmarshall
     * @param proxy
     *            HttpProxyDecorator to inject
     * 
     * @return Decorator instance
     */
    public static <R, Z> Z map(Class<R> from, Class<Z> to, String xml, HttpProxyBroker proxy) throws JAXBException {
        R res = SerializationHelper.unmarshall(from, xml);
        return Mapper.map(res, to, proxy);
    }
}
