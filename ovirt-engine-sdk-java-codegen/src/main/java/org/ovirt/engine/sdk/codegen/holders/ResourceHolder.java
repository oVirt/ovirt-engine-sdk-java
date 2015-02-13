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

package org.ovirt.engine.sdk.codegen.holders;

import org.ovirt.engine.sdk.codegen.templates.SubCollectionGetterTemplate;
import org.ovirt.engine.sdk.codegen.templates.ResourceTemplate;
import org.ovirt.engine.sdk.codegen.templates.SubResourceTemplate;
import org.ovirt.engine.sdk.codegen.templates.VariableTemplate;
import org.ovirt.engine.sdk.codegen.utils.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Holds sub-resources
 */
public class ResourceHolder extends AbstractResourceHolder {

    private VariableTemplate variableTemplate;
    private SubCollectionGetterTemplate subCollectionGetterTemplate;

    /**
     * @param decoratorResourceName
     * @param publicEntityName
     * @param subResourceTemplate
     * @param variableTemplate
     * @param getterTemplate
     */
    public ResourceHolder(
            String decoratorResourceName,
            String publicEntityName,
            SubResourceTemplate subResourceTemplate,
            VariableTemplate variableTemplate,
            SubCollectionGetterTemplate getterTemplate) {
        super(decoratorResourceName, publicEntityName, subResourceTemplate);

        this.variableTemplate = variableTemplate;
        this.subCollectionGetterTemplate = getterTemplate;
    }

    /**
     * @param decoratorResourceName
     * @param publicEntityName
     * @param resourceTemplate
     * @param variableTemplate
     * @param getterTemplate
     */
    public ResourceHolder(
            String decoratorResourceName,
            String publicEntityName,
            ResourceTemplate resourceTemplate,
            VariableTemplate variableTemplate,
            SubCollectionGetterTemplate getterTemplate) {
        super(decoratorResourceName, publicEntityName, resourceTemplate);

        this.variableTemplate = variableTemplate;
        this.subCollectionGetterTemplate = getterTemplate;
    }

    /**
     * Returns sub-resource getters
     */
    @Override
    String getSubCollectionsGetters() {
        Map<String, CollectionHolder> subCollections = getSubcollections();

        List<String> keys = new ArrayList<>(subCollections.keySet());
        Collections.sort(keys);

        StringBuilder buffer = new StringBuilder();
        for (String key : keys) {
            CollectionHolder ch = subCollections.get(key);
            String name = ch.getName();
            String publicName = ch.getPublicCollectionName();
            buffer.append(subCollectionGetterTemplate.getTemplate(name, StringUtils.toLowerCase(name), publicName));
        }
        return buffer.toString();
    }

    /**
     * Returns sub-resource variables
     */
    @Override
    String getSubCollectionsVariables() {
        Map<String, CollectionHolder> subCollections = getSubcollections();
        List<String> keys = new ArrayList<>(subCollections.keySet());
        Collections.sort(keys);

        StringBuilder buffer = new StringBuilder();
        for (String key : keys) {
            CollectionHolder ch = subCollections.get(key);
            String name = ch.getName();
            buffer.append(variableTemplate.getTemplate(name, StringUtils.toLowerCase(name)));
        }
        return buffer.toString();
    }
}
