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
import java.util.List;
import java.util.Map;

import static org.ovirt.engine.sdk.codegen.utils.StringUtils.concatenateValues;

public class ResourceTemplate extends AbstractTemplate {
    public String evaluate(Tree<Location> entityTree) {
        String brokerType = BrokerRules.getBrokerType(entityTree);
        String entityType = SchemaRules.getSchemaType(entityTree);

        // We need to store the declarations of methods and fields indexed by name in order to be able to sort them by
        // name before generating the code, so that the resulting code will have a predictable order:
        Map<String, String> fieldsMap = new HashMap<>();
        Map<String, String> gettersMap = new HashMap<>();
        Map<String, String> methodsMap = new HashMap<>();

        // Find the sub-collections:
        List<Tree<Location>> collectionTrees = entityTree.getChildren(LocationRules::isCollection);

        // Generate the code for the collection fields:
        for (Tree<Location> collectionTree : collectionTrees) {
            String fieldType = BrokerRules.getBrokerType(collectionTree);
            String fieldName = Character.toLowerCase(fieldType.charAt(0)) + fieldType.substring(1);
            String fieldCode = new VariableTemplate().evaluate(fieldType, fieldName);
            fieldsMap.put(fieldName, fieldCode);
        }

        // Generate the code for the collection getters:
        for (Tree<Location> collectionTree : collectionTrees) {
            String getterName = LocationRules.getName(collectionTree);
            String getterCode = new SubCollectionGetterTemplate().evaluate(collectionTree);
            gettersMap.put(getterName, getterCode);
        }

        // Generate the code for the methods:
        for (DetailedLink methodLink : entityTree.get().getLinks()) {
            String methodName = methodLink.getRel();
            switch (methodName) {
            case "delete":
                String deleteMethod = new DeleteMethodTemplate().evaluate(entityTree, methodLink);
                methodsMap.put(methodName, deleteMethod);
                break;
            case "update":
                String updateMethod = new UpdateMethodTemplate().evaluate(entityTree, methodLink);
                methodsMap.put(methodName, updateMethod);
                break;
            }
        }

        // Generate the code for the actions:
        for (Tree<Location> actionTree : entityTree.getChildren(LocationRules::isAction)) {
            String actionName = LocationRules.getName(actionTree);
            String actionMethod = new ResourceActionMethodTemplate().evaluate(actionTree);
            methodsMap.put(actionName, actionMethod);
        }

        // Populate the template:
        set("broker_type", brokerType);
        set("entity_type", entityType);
        set("sub_collection_variables", concatenateValues(fieldsMap));
        set("sub_collection_getters", concatenateValues(gettersMap));
        set("methods", concatenateValues(methodsMap));

        return evaluate();
    }
}