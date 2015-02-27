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

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ovirt.engine.sdk.codegen.templates.CollectionTemplate;
import org.ovirt.engine.sdk.codegen.templates.ResourceTemplate;
import org.ovirt.engine.sdk.codegen.templates.SubCollectionTemplate;
import org.ovirt.engine.sdk.codegen.templates.SubResourceTemplate;
import org.ovirt.engine.sdk.codegen.utils.ClassUtils;
import org.ovirt.engine.sdk.codegen.utils.Tree;
import org.ovirt.engine.sdk.codegen.xsd.XsdCodegen;

import static java.util.stream.Collectors.toList;
import static org.ovirt.engine.sdk.codegen.rsdl.LocationRules.isCollection;
import static org.ovirt.engine.sdk.codegen.rsdl.LocationRules.isEntity;
import static org.ovirt.engine.sdk.codegen.rsdl.LocationRules.isSubCollection;
import static org.ovirt.engine.sdk.codegen.rsdl.LocationRules.isSubEntity;

/**
 * Provides RSDL related generator capabilities.
 */
public class RsdlCodegen {
    /**
     * The name of the Java package that will contain the generated decorator classes.
     */
    private static final String DECORATORS_PACKAGE = "org.ovirt.engine.sdk.decorators";

    /**
     * The keys of this map are the names of the broker types, and the content is the generated code.
     */
    private Map<String, String> code = new HashMap<>();

    public void generate(String distPath) throws IOException {
        // Get the root of the tree of locations:
        Tree<Location> root = RsdlData.getInstance().getRoot();

        // Generate the code:
        root.getDescendants().forEach(this::generateCode);

        // Save the generated decorator classes:
        for (Map.Entry<String, String> entry : code.entrySet()) {
            ClassUtils.saveClass(distPath, DECORATORS_PACKAGE + "." + entry.getKey(), entry.getValue());
        }

        // Generate the entry point class:
        new ApiCodegen(root).generate(distPath);

        // Remove collection getters/setters from the public entities, as they being shadowed by the decorators getters:
        XsdCodegen.modifyGetters(distPath, getPublicAccessors());
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
        List<Tree<Location>> entityTrees = RsdlData.getInstance().getRoot().getDescendants().stream()
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
}
