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

import java.util.HashMap;
import java.util.Map;

import org.ovirt.engine.sdk.codegen.templates.ResourceTemplate;
import org.ovirt.engine.sdk.codegen.templates.SubResourceTemplate;

/**
 * Holds resources
 */
public abstract class AbstractResourceHolder extends AbstractCollectionHolder {

    private Map<String, CollectionHolder> subcollections;

    private SubResourceTemplate subResourceTemplate;
    private ResourceTemplate resourceTemplate;
    private String decoratorResourceName;
    private String publicEntityName;

    /**
     * @param decoratorResourceName
     * @param publicEntityName
     * @param subResourceTemplate
     */
    public AbstractResourceHolder(
            String decoratorResourceName,
            String publicEntityName,
            SubResourceTemplate subResourceTemplate) {

        this.subcollections = new HashMap<String, CollectionHolder>();

        this.subResourceTemplate = subResourceTemplate;
        this.decoratorResourceName = decoratorResourceName;
        this.publicEntityName = publicEntityName;
    }

    /**
     * @param decoratorResourceName
     * @param publicEntityName
     * @param resourceTemplate
     */
    public AbstractResourceHolder(
            String decoratorResourceName,
            String publicEntityName,
            ResourceTemplate resourceTemplate) {

        this.subcollections = new HashMap<String, CollectionHolder>();

        this.resourceTemplate = resourceTemplate;
        this.decoratorResourceName = decoratorResourceName;
        this.publicEntityName = publicEntityName;
    }

    /**
     * @return Subcollections
     */
    public Map<String, CollectionHolder> getSubcollections() {
        return subcollections;
    }

    /**
     * Adds sub-collection
     * 
     * @param name
     *            sub-collection name
     * @param subcollection
     *            sub-collection holder
     */
    public void addSubCollection(String name, CollectionHolder subcollection) {
        this.subcollections.put(name, subcollection);
    }

    /**
     * Produces this holder content
     */
    @Override
    public String produce() {
        return toString();
    }

    /**
     * Returns getters
     */
    abstract String getSubCollectionsGetters();

    /**
     * Returns variables
     */
    abstract String getSubCollectionsVariables();

    /**
     * toString() override
     */
    @Override
    public String toString() {
        if (resourceTemplate == null)
            return subResourceTemplate.getTemplate(decoratorResourceName,
                    publicEntityName,
                    getSubCollectionsVariables(),
                    getSubCollectionsGetters(),
                    getMethods());
        return resourceTemplate.getTemplate(decoratorResourceName,
                publicEntityName,
                getSubCollectionsVariables(),
                getSubCollectionsGetters(),
                getMethods());
    }

    /**
     * @return Resource name
     */
    @Override
    public String getName() {
        return this.decoratorResourceName;
    }

    /**
     * @return PublicEntityName
     */
    public String getPublicEntityName() {
        return publicEntityName;
    }
}
