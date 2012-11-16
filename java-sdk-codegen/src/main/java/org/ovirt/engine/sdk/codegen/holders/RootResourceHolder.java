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

import org.ovirt.engine.sdk.codegen.templates.ResourceTemplate;

/**
 * Holds root-resources
 */
public class RootResourceHolder extends AbstractResourceHolder {

    private ResourceTemplate resourceTemplate;
    private String decoratorResourceName;
    private String publicEntityName;

    /**
     * @param decoratorResourceName
     * @param publicEntityName
     * @param resourceTemplate
     */
    public RootResourceHolder(
            String decoratorResourceName,
            String publicEntityName,
            ResourceTemplate resourceTemplate) {
        this.resourceTemplate = resourceTemplate;
        this.decoratorResourceName = decoratorResourceName;
        this.publicEntityName = publicEntityName;
    }

    /**
     * Returns sub-collections getters
     */
    @Override
    public String getSubCollectionsGetters() {
        // TODO: implement this when templates are ready.
        return "";
    }

    /**
     * Returns sub-collections variables
     */
    @Override
    public String getSubCollectionsVariables() {
        // TODO: implement this when templates are ready.
        return "";
    }

    /**
     * Produces this holder content
     */
    @Override
    public String toString() {
        return resourceTemplate.getTemplate(decoratorResourceName,
                publicEntityName,
                getSubCollectionsVariables(),
                getSubCollectionsGetters(),
                getMethods());
    }
}
