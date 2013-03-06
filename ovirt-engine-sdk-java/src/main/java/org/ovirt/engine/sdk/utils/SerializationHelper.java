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

package org.ovirt.engine.sdk.utils;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.transform.stream.StreamSource;

import org.ovirt.engine.sdk.entities.DataCenter;
import org.ovirt.engine.sdk.entities.ObjectFactory;
import org.ovirt.engine.sdk.exceptions.MarshallingException;

/**
 * Provides serialization services.
 * 
 */
public class SerializationHelper {
    private final static Map<Class<?>, JAXBContextHolder> contexts = new HashMap<Class<?>, JAXBContextHolder>();
    private static String PACKAGE_CONTEXT = "org.ovirt.engine.sdk.entities";
    private static JAXBContext JAXB_CONTEXT = null;
    private static ObjectFactory factory = new ObjectFactory();
    private static Map<String, Method> factoryMethods = new HashMap<String, Method>();

    private SerializationHelper() {
    }

    /**
     * Marshalls object to XML
     * 
     * @param element
     * @return XML String
     * 
     * @throws JAXBException
     */
    private static <S> String marshall(JAXBElement<S> element) throws JAXBException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        marshall(baos, element);
        return new String(baos.toByteArray());
    }

    /**
     * Marshalls object to XML
     * 
     * @param clz
     *            Actual object class
     * @param obj
     *            Resource to marshall
     * 
     * @return XML string
     */
    public static <S> String marshall(Class<S> clz, S obj) {
        try {
            JAXBElement<S> element = getElement(clz, obj);
            if (element != null)
                return marshall(element);
            throw new MarshallingException(
                    "Coresponding JAXBElement for \"" + clz.getSimpleName() +
                            "\" is not found.");
        } catch (JAXBException e) {
            // TODO: log error
            throw new MarshallingException(e);
        }
    }

    /**
     * Produces JAXBElement
     * 
     * @param clz
     *            class to initiate the JAXBElement for
     * @param obj
     *            object to initiate the JAXBElement from
     * @return
     */
    @SuppressWarnings("unchecked")
    private static <S> JAXBElement<S> getElement(Class<S> clz, S obj) {
        Method m = getCreateMethod(clz);
        if (m != null) {
            try {
                return (JAXBElement<S>) m.invoke(factory, obj);
            } catch (IllegalArgumentException e) {
                // TODO: should never happen, but log error anyway
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                // TODO: should never happen, but log error anyway
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                // TODO: should never happen, but log error anyway
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * Fetches factory method to create the corresponding JAXBElement
     * 
     * @param clz
     *            class to create the JAXBElement from
     * 
     * @return factory method or null
     */
    public static synchronized <S> Method getCreateMethod(Class<S> clz) {
        String createMethod = "create" + clz.getSimpleName();

        if (factoryMethods.isEmpty()) {
            for (Method m : factory.getClass().getMethods()) {
                if (m.getParameterTypes().length > 0)
                    factoryMethods.put(m.getName(), m);
            }
        }

        if (factoryMethods.containsKey(createMethod)) {
            return factoryMethods.get(createMethod);
        }
        return null;
    }

    /**
     * Marshalls object to XML
     * 
     * @param os
     * @param element
     * 
     * @throws JAXBException
     */
    private static <S> void marshall(OutputStream os, JAXBElement<S> element) throws JAXBException {
        Marshaller marshaller = getContext(element.getDeclaredType()).getMarshaller();
        synchronized (marshaller) {
            marshaller.marshal(element, os);
        }
    }

    /**
     * Unmarshall object from the XML string
     * 
     * @param clz
     *            class to unmarshall to
     * @param xml
     *            string to unmarshall from
     * 
     * @return S
     */
    public static <S> S unmarshall(Class<S> clz, String xml) {
        if (StringUtils.isNulOrEmpty(xml)) {
            return null;
        } else {
            try {
                Unmarshaller unmarshaller = getContext(clz).getUnmarshaller();
                synchronized (unmarshaller) {
                    JAXBElement<S> root = unmarshaller.unmarshal(new StreamSource(new StringReader(xml)), clz);
                    return root.getValue();
                }
            } catch (JAXBException e) {
                // TODO: log error
                throw new MarshallingException(e);
            }
        }
    }

    /**
     * Fetches JAXB context.
     * 
     * @param clz
     * @return JAXBContextHolder
     * 
     * @throws JAXBException
     */
    private synchronized static JAXBContextHolder getContext(Class<?> clz) throws JAXBException {
        if (JAXB_CONTEXT == null) {
            ClassLoader cl = ObjectFactory.class.getClassLoader();
            JAXB_CONTEXT = JAXBContext.newInstance(PACKAGE_CONTEXT, cl);
        }
        if (!contexts.containsKey(clz)) {
            contexts.put(clz, new JAXBContextHolder(JAXB_CONTEXT));
        }
        return contexts.get(clz);
    }

    /**
     * JAXBContextHolder
     */
    private static class JAXBContextHolder {
        Unmarshaller unmarshaller;
        Marshaller marshaller;
        JAXBContext context;

        public JAXBContextHolder(JAXBContext context) {
            this.context = context;
        }

        public Unmarshaller getUnmarshaller() throws JAXBException {
            if (unmarshaller == null) {
                unmarshaller = this.context.createUnmarshaller();
            }
            return unmarshaller;
        }

        public Marshaller getMarshaller() throws JAXBException {
            if (marshaller == null) {
                marshaller = context.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            }
            return marshaller;
        }
    }
}
