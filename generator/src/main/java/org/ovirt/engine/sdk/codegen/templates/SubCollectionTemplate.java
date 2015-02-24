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

package org.ovirt.engine.sdk.codegen.templates;

import org.ovirt.engine.sdk.codegen.rsdl.BrokerRules;
import org.ovirt.engine.sdk.codegen.rsdl.Location;
import org.ovirt.engine.sdk.codegen.rsdl.LocationRules;
import org.ovirt.engine.sdk.codegen.rsdl.SchemaRules;
import org.ovirt.engine.sdk.codegen.utils.Tree;
import org.ovirt.engine.sdk.entities.DetailedLink;

import java.util.HashMap;
import java.util.Map;

import static org.ovirt.engine.sdk.codegen.utils.StringUtils.concatenateValues;

public class SubCollectionTemplate extends AbstractTemplate {
    public String evaluate(Tree<Location> collectionTree) {
        Tree<Location> parentTree = collectionTree.getParent();
        Tree<Location> entityTree = collectionTree.getChild(LocationRules::isEntity);

        String parentBrokerType = BrokerRules.getBrokerType(parentTree);
        String collectionBrokerType = BrokerRules.getBrokerType(collectionTree);
        String entityBrokerType = BrokerRules.getBrokerType(entityTree);
        String collectionType = SchemaRules.getSchemaType(collectionTree);
        String collectionName = LocationRules.getName(collectionTree);
        String entityType = SchemaRules.getSchemaType(entityTree);

        // We need to store the body of the methods indexed by name in order to be able to sort them by name before
        // generating the code, so that the resulting code will have a predictable order:
        Map<String, String> methodsMap = new HashMap<>();

        // Generate the code for the "add" and "list" methods:
        for (DetailedLink methodLink : collectionTree.get().getLinks()) {
            String methodName = methodLink.getRel();
            switch (methodName) {
            case "add":
                String addMethod = new SubCollectionAddMethodTemplate().evaluate(collectionTree, methodLink);
                methodsMap.put(methodName, addMethod);
                break;
            case "get":
                String listMethod = new SubCollectionListMethodTemplate().evaluate(collectionTree, methodLink);
                methodsMap.put(methodName, listMethod);
                break;
            }
        }

        // Generate the code for the action methods:
        for (Tree<Location> actionTree : collectionTree.getChildren(LocationRules::isAction)) {
            String actionName = LocationRules.getName(actionTree);
            String actionMethod = new CollectionActionMethodTemplate().evaluate(actionTree);
            methodsMap.put(actionName, actionMethod);
        }

        // Populate the template:
        set("parent_broker_type", parentBrokerType);
        set("collection_broker_type", collectionBrokerType);
        set("entity_broker_type", entityBrokerType);
        set("collection_type", collectionType);
        set("collection_name", collectionName);
        set("entity_type", entityType);
        set("methods", concatenateValues(methodsMap));

        return evaluate();
    }
}