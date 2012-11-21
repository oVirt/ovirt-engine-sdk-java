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
 * Provides SubCollection templating services
 */
public class SubCollectionTemplate extends AbstractTemplate {

    public SubCollectionTemplate() {
        super();
    }

    /**
     * Formats template in to the decorator class
     * 
     * @param decoratorSubCollectionName
     * @param publicEntityName
     * @param publicCollectionName
     * @param parentDecoratorName
     * @param decoratorEntityName
     * @param urlCollectionName
     * @param methods
     * 
     * @return
     */
    public String getTemplate(String decoratorSubCollectionName,
            String publicEntityName,
            String publicCollectionName,
            String parentDecoratorName,
            String decoratorEntityName,
            String methods,
            String urlCollectionName) {

        StringTemplateWrapper templateWrapper =
                new StringTemplateWrapper(getCopyrightTemplate()
                                   +
                                   getTemplate());

        templateWrapper.set("decoratorSubCollectionName", decoratorSubCollectionName);
        templateWrapper.set("publicEntityName", publicEntityName);
        templateWrapper.set("publicCollectionName", publicCollectionName);
        templateWrapper.set("parentDecoratorName", parentDecoratorName);
        templateWrapper.set("decoratorEntityName", decoratorEntityName);
        templateWrapper.set("methods", methods);
        templateWrapper.set("urlCollectionName", urlCollectionName);

        return templateWrapper.toString();
    }
}
