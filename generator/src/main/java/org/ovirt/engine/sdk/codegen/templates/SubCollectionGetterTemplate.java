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
 * Provides class variable getter templating services
 */
public class SubCollectionGetterTemplate extends AbstractTemplate {

    public SubCollectionGetterTemplate() {
        super();
    }

    /**
     * Formates string in to class variable getter
     * 
     * @param decoratorCollectionName
     * @param decoratorCollectionVariableName
     * 
     * @return formated string
     */
    public String getTemplate(String decoratorCollectionName,
            String decoratorCollectionVariableName, String publicCollecionName) {

        StringTemplateWrapper templateWrapper =
                new StringTemplateWrapper(getTemplate());

        templateWrapper.set("decoratorCollectionName", decoratorCollectionName);
        templateWrapper.set("decoratorCollectionVariableName", decoratorCollectionVariableName);
        templateWrapper.set("publicCollecionName", publicCollecionName);

        return templateWrapper.toString();
    }
}
