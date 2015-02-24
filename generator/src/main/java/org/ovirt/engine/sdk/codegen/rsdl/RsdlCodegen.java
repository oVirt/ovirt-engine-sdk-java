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

package org.ovirt.engine.sdk.codegen.rsdl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import org.apache.commons.io.FileUtils;
import org.ovirt.engine.sdk.codegen.templates.CollectionTemplate;
import org.ovirt.engine.sdk.codegen.templates.ResourceTemplate;
import org.ovirt.engine.sdk.codegen.templates.SubCollectionTemplate;
import org.ovirt.engine.sdk.codegen.templates.SubResourceTemplate;
import org.ovirt.engine.sdk.codegen.utils.ClassUtils;
import org.ovirt.engine.sdk.codegen.utils.Tree;
import org.ovirt.engine.sdk.codegen.xsd.XsdCodegen;
import org.ovirt.engine.sdk.entities.DetailedLink;
import org.ovirt.engine.sdk.entities.RSDL;
import org.ovirt.engine.sdk.entities.Response;

import static java.util.stream.Collectors.toList;
import static org.ovirt.engine.sdk.codegen.rsdl.LocationRules.isCollection;
import static org.ovirt.engine.sdk.codegen.rsdl.LocationRules.isEntity;
import static org.ovirt.engine.sdk.codegen.rsdl.LocationRules.isSubCollection;
import static org.ovirt.engine.sdk.codegen.rsdl.LocationRules.isSubEntity;

/**
 * Provides RSDL related codegen capabilities
 */
public class RsdlCodegen {
    /**
     * The location of the RSDL file.
     */
    private String rsdlPath;

    /**
     * The name of the Java package that will contain the generated decorator classes.
     */
    private static final String DECORATORS_PACKAGE = "org.ovirt.engine.sdk.decorators";

    /**
     * Create a code generator for the decorator classes.
     *
     * @param rsdlPath the path of the file containing the RSDL document
     */
    public RsdlCodegen(String rsdlPath) {
        this.rsdlPath = rsdlPath;
    }

    /**
     * The keys of this map are the names of the broker types, and the content is the generated code.
     */
    private Map<String, String> code = new HashMap<>();

    /**
     * The root of the tree of locations.
     */
    private Tree<Location> root = new Tree<>();

    public void generate(String distPath) throws IOException {
        // Remove all the previously generate classes, so that classes corresponding to types that have been
        // removed from the XML schema will be later removed from the source code repository:
        File packageDir = new File(distPath, DECORATORS_PACKAGE.replace('.', File.separatorChar));
        if (packageDir.exists()) {
            FileUtils.cleanDirectory(packageDir);
        }

        // Load the RSDL document:
        RSDL rsdl = loadRsdl(rsdlPath);

        // The RSDL provided by the server doesn't include some links that are needed by the code generator, so we need
        // to add them explicitly:
        addMissingLinks(rsdl);

        // Build the tree of URLs scanning all the links:
        root.set(new Location());
        for (DetailedLink link : rsdl.getLinks().getLinks()) {
            List<String> path = Arrays.asList(link.getHref().split("/"));
            Tree<Location> tree = root.getDescendant(path);
            if (tree == null) {
                tree = root.addDescendant(path);
            }
            Location location = tree.get();
            if (location == null) {
                location = new Location();
                tree.set(location);
            }
            location.addLink(link);
        }

        // Get all the tree nodes:
        List<Tree<Location>> locations = root.getDescendants();

        // The previous process may have created intermediate nodes without a location object associated, and that may
        // cause null pointer exceptions later, so to avoid that we need to make sure that all the nodes of the tree
        // have a location, even if it is empty:
        for (Tree<Location> tree : locations) {
            Location location = tree.get();
            if (location == null) {
                location = new Location();
                tree.set(location);
            }
        }

        // Generate decorator classes:
        locations.forEach(this::generateCode);

        // Save the generated decorator classes:
        for (Map.Entry<String, String> entry : code.entrySet()) {
            ClassUtils.saveClass(distPath, DECORATORS_PACKAGE + "." + entry.getKey(), entry.getValue());
        }

        // Generate the entry point class:
        new ApiCodegen(root).generate(distPath);

        // Remove collection getters/setters from the public entities, as they being shadowed by the decorators getters:
        XsdCodegen.modifyGetters(distPath, getPublicAccessors());
    }

    private void addMissingLinks(RSDL rsdl) {
        addMissingLink(rsdl, "users/{user:id}/roles/{role:id}", "Role");
        addMissingLink(rsdl, "users/{user:id}/roles/{role:id}/permits/{permit:id}", "Permit");
        addMissingLink(rsdl, "groups/{group:id}/roles/{role:id}", "Role");
        addMissingLink(rsdl, "groups/{group:id}/roles/{role:id}/permits/{permit:id}", "Permit");
    }

    private void addMissingLink(RSDL rsdl, String href, String type) {
        DetailedLink link = new DetailedLink();
        link.setHref(href);
        link.setRel("get");
        Response response = new Response();
        response.setType(type);
        link.setResponse(response);
        rsdl.getLinks().getLinks().add(link);
    }

    private void generateCode(Tree<Location> tree) {
        if (isEntity(tree)) {
            if (isSubEntity(tree)) {
                addSubResource(tree);
            }
            else {
                addResource(tree);
            }
        }
        else if (isCollection(tree)) {
            if (isSubCollection(tree)) {
                addSubCollection(tree);
            }
            else {
                addCollection(tree);
            }
        }
    }

    private void addResource(Tree<Location> entityTree) {
        String className = BrokerRules.getBrokerType(entityTree);
        String classCode = new ResourceTemplate().evaluate(entityTree);
        code.put(className, classCode);
    }

    private void addSubResource(Tree<Location> entityTree) {
        String className = BrokerRules.getBrokerType(entityTree);
        String classCode = new SubResourceTemplate().evaluate(entityTree);
        code.put(className, classCode);
    }

    private void addCollection(Tree<Location> collectionTree) {
        String className = BrokerRules.getBrokerType(collectionTree);
        String classCode = new CollectionTemplate().evaluate(collectionTree);
        code.put(className, classCode);
    }

    private void addSubCollection(Tree<Location> collectionTree) {
        String className = BrokerRules.getBrokerType(collectionTree);
        String classCode = new SubCollectionTemplate().evaluate(collectionTree);
        code.put(className, classCode);
    }

    private Map<String, List<String>> getPublicAccessors() {
        Map<String, List<String>> publicAccessors = new HashMap<>();
        List<Tree<Location>> entityTrees = root.getDescendants().stream()
            .filter(LocationRules::isEntity)
            .collect(toList());
        for (Tree<Location> entityTree : entityTrees) {
            String entityType = SchemaRules.getSchemaType(entityTree);
            List<String> entityAccessors = publicAccessors.get(entityType);
            if (entityAccessors == null) {
                entityAccessors = new ArrayList<>();
                publicAccessors.put(entityType, entityAccessors);
            }
            for (Tree<Location> collectionTree : entityTree.getChildren(LocationRules::isCollection)) {
                String collectionType = SchemaRules.getSchemaType(collectionTree);
                entityAccessors.add(collectionType);
            }
        }
        return publicAccessors;
    }

    private RSDL loadRsdl(String rsdlPath) throws IOException {
        try {
            JAXBContext context = JAXBContext.newInstance(RSDL.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Source source = new StreamSource(new File(rsdlPath));
            JAXBElement<RSDL> element = unmarshaller.unmarshal(source, RSDL.class);
            return element.getValue();
        }
        catch (JAXBException exception) {
            throw new IOException(exception);
        }
    }
}
