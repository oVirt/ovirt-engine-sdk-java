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

import org.ovirt.engine.sdk.codegen.utils.StringTemplateWrapper;

/**
 * Provides SubResource templating services
 */
public class SubResourceTemplate extends AbstractTemplate {

    public SubResourceTemplate() {
        super();
    }

    /**
     * Formats template in to the decorator class
     * 
     * @param subResourceDecoratorName
     * @param publicEntityName
     * @param subCollectionsVariables
     * @param subCollectionsGetters
     * @param methods
     * 
     * @return java class txt
     */
    public String getTemplate(String subResourceDecoratorName,
            String publicEntityName,
            String subCollectionsVariables,
            String subCollectionsGetters,
            String methods) {

        StringTemplateWrapper templateWrapper =
                new StringTemplateWrapper(getCopyrightTemplate()
                                   +
                                   getTemplate());

        templateWrapper.set("subResourceDecoratorName", subResourceDecoratorName);
        templateWrapper.set("publicEntityName", publicEntityName);
        templateWrapper.set("subCollectionsVariables", subCollectionsVariables);
        templateWrapper.set("subCollectionsGetters", subCollectionsGetters);
        templateWrapper.set("methods", methods);

        return templateWrapper.toString();
    }
}
