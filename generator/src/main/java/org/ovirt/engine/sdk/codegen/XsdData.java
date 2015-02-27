//
// Copyright (c) 2015 Red Hat, Inc.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
//

package org.ovirt.engine.sdk.codegen;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.xml.XMLConstants;
import javax.xml.namespace.NamespaceContext;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class XsdData {
    /**
     * This is a singleton, and this is the reference to the instance.
     */
    private static final XsdData instance = new XsdData();

    /**
     * Get the reference to the instance of this singleton.
     */
    public static XsdData getInstance() {
        return instance;
    }

    /**
     * The file containing the RSDL metadata.
     */
    private File file;

    /**
     * This map contains the DOM trees of all the top level element definitions that appear in the XML schema, indexed
     * by name.
     */
    private Map<String, Element> elementsIndex = new HashMap<>();

    /**
     * This map contains the DOM trees of all the complex types that appear in the XML schema, indexed by name.
     */
    private Map<String, Element> complexTypesIndex = new HashMap<>();

    /**
     * We will create and reuse this XPath expression.
     */
    private XPath xpath;

    /**
     * Returns the file that contains the XML schema.
     */
    public File getFile() {
        return file;
    }

    /**
     * Loads the XML schema from a file.
     *
     * @param file the file that contains the XML schema
     * @throws IOException if something fails while loading the schema
     */
    public void load(File file) throws IOException {
        // Save the reference to the file:
        this.file = file;

        // Parse the XML schema document:
        Document schema;
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            DocumentBuilder parser = factory.newDocumentBuilder();
            schema = parser.parse(file);
        }
        catch (Exception exception) {
            throw new IOException("Can't parse XML schema.", exception);
        }

        // Prepare the xpath engine with the required namespace mapping:
        xpath = XPathFactory.newInstance().newXPath();
        xpath.setNamespaceContext(
            new NamespaceContext() {
                @Override
                public String getNamespaceURI(String prefix) {
                    switch (prefix) {
                    case "xs":
                        return "http://www.w3.org/2001/XMLSchema";
                    default:
                        return XMLConstants.NULL_NS_URI;
                    }
                }

                @Override
                public String getPrefix(String namespaceURI) {
                    throw new UnsupportedOperationException();
                }

                @Override
                public Iterator getPrefixes(String namespaceURI) {
                    throw new UnsupportedOperationException();
                }
            }
        );

        // Populate the indexes:
        populateElementsIndex(schema);
        populateComplexTypesIndex(schema);
    }

    private void populateElementsIndex(Document schema) {
        NodeList nodes = (NodeList) evaluate("/xs:schema/xs:element", schema, XPathConstants.NODESET);
        for (int i = 0; i < nodes.getLength(); i++) {
            Element node = (Element) nodes.item(i);
            String name = node.getAttribute("name");
            if (!name.isEmpty()) {
                elementsIndex.put(name, node);
            }
        }
    }

    private void populateComplexTypesIndex(Document schema) {
        NodeList nodes = (NodeList) evaluate("/xs:schema/xs:complexType", schema, XPathConstants.NODESET);
        for (int i = 0; i < nodes.getLength(); i++) {
            Element node = (Element) nodes.item(i);
            String name = node.getAttribute("name");
            if (!name.isEmpty()) {
                complexTypesIndex.put(name, node);
            }
        }
    }

    private Object evaluate(String expression, Object item, QName returnType) {
        try {
            return xpath.evaluate(expression, item, returnType);
        }
        catch (XPathExpressionException exception) {
            throw new RuntimeException("Can't evaluate XPath expression \"" + expression + "\".");
        }
    }

    public Element getElement(String name) {
        return elementsIndex.get(name);
    }

    public Element getComplexType(String name) {
        return complexTypesIndex.get(name);
    }

    public String getEntityTypeForCollectionType(String collectionType) {
        Element collectionTypeNode = getComplexType(collectionType);
        if (collectionTypeNode == null) {
            return null;
        }
        return getEntityTypeForCollectionType(collectionTypeNode);
    }

    private String getEntityTypeForCollectionType(Element collectionTypeNode) {
        NodeList contentNodes = (NodeList) evaluate(
            "xs:complexContent/" +
            "xs:extension/" +
            "xs:sequence/" +
            "xs:element",
            collectionTypeNode,
            XPathConstants.NODESET
        );
        String entityType = null;
        for (int i = 0; entityType == null && i < contentNodes.getLength(); i++) {
            Element contentNode = (Element) contentNodes.item(i);
            String ref = contentNode.getAttribute("ref");
            if (!ref.isEmpty()) {
                Element elementNode = getElement(ref);
                if (elementNode != null) {
                    String type = elementNode.getAttribute("type");
                    if (!type.isEmpty()) {
                        entityType = type;
                    }
                }
            }
        }
        if (entityType == null) {
            for (int i = 0; entityType == null && i < contentNodes.getLength(); i++) {
                Element element = (Element) contentNodes.item(i);
                String name = element.getAttribute("name");
                String type = element.getAttribute("type");
                if (!name.isEmpty() && !type.isEmpty()) {
                    entityType = type;
                }
            }
        }
        return entityType;
    }
}
