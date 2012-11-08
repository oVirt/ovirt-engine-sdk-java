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
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.transform.stream.StreamSource;

public class SerializationHelper {
    private final static Map<Class<?>, JAXBContextHolder> contexts = new HashMap<Class<?>, JAXBContextHolder>();

    private SerializationHelper() {
    }

    private static <S> String marshall(JAXBElement<S> element) throws JAXBException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        marshall(baos, element);
        return new String(baos.toByteArray());
    }

    public static <S> String marshall(Class<S> clz, S obj) throws JAXBException {
        return marshall(new JAXBElement<S>(new QName("", clz.getSimpleName()), clz, null, obj));
    }

    private static <S> void marshall(OutputStream os, JAXBElement<S> element) throws JAXBException {
        Marshaller marshaller = getContext(element.getDeclaredType()).getMarshaller();
        synchronized (marshaller) {
            marshaller.marshal(element, os);
        }
    }

    public static <S> S unmarshall(Class<S> clz, String xml) throws JAXBException {
        Unmarshaller unmarshaller = getContext(clz).getUnmarshaller();
        synchronized (unmarshaller) {
            JAXBElement<S> root = unmarshaller.unmarshal(new StreamSource(new StringReader(xml)), clz);
            return root.getValue();
        }
    }

    private synchronized static JAXBContextHolder getContext(Class<?> clz) throws JAXBException {
        if (!contexts.containsKey(clz)) {
            contexts.put(clz, new JAXBContextHolder(JAXBContext.newInstance(clz)));
        }
        return contexts.get(clz);
    }

    private static class JAXBContextHolder {
        Unmarshaller unmarshaller;
        Marshaller marshaller;

        public JAXBContextHolder(JAXBContext context) throws JAXBException {
            marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            unmarshaller = context.createUnmarshaller();
        }

        public Unmarshaller getUnmarshaller() {
            return unmarshaller;
        }

        public Marshaller getMarshaller() {
            return marshaller;
        }
    }
}
