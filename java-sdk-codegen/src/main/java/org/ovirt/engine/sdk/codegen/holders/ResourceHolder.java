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
import org.ovirt.engine.sdk.codegen.templates.SubResourceTemplate;

/**
 * Holds sub-resources
 */
public class ResourceHolder extends AbstractResourceHolder {

    /**
     * @param decoratorResourceName
     * @param publicEntityName
     * @param subResourceTemplate
     */
    public ResourceHolder(
            String decoratorResourceName,
            String publicEntityName,
            SubResourceTemplate subResourceTemplate) {
        super(decoratorResourceName, publicEntityName, subResourceTemplate);
    }

    /**
     * @param decoratorResourceName
     * @param publicEntityName
     * @param resourceTemplate
     */
    public ResourceHolder(
            String decoratorResourceName,
            String publicEntityName,
            ResourceTemplate resourceTemplate) {
        super(decoratorResourceName, publicEntityName, resourceTemplate);
    }

    /**
     * Returns sub-resource getters
     */
    @Override
    String getSubCollectionsGetters() {
        // TODO: implement this when templates are ready.
        return "\r";
    }

    /**
     * Returns sub-resource variables
     */
    @Override
    String getSubCollectionsVariables() {
        // TODO: implement this when templates are ready.
        return "\r";
    }
}
