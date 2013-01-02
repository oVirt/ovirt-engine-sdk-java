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
 * Provides Resource add templating services
 */
public class CollectionAddMethodTemplate extends AbstractTemplate {

    public CollectionAddMethodTemplate() {
        super();
    }

    /**
     * Formats template in to the resource add template
     * 
     * @param decoratorName
     *            decorator entity name
     * @param publicEntityName
     *            public entity name
     * @param docParams
     *            documentation params
     * 
     * @return formated add template
     */
    public String getTemplate(String decoratorName, String publicEntityName, String docParams) {

        StringTemplateWrapper templateWrapper =
                new StringTemplateWrapper(getTemplate());

        templateWrapper.set("decoratorName", decoratorName);
        templateWrapper.set("publicEntityName", publicEntityName);
        templateWrapper.set("publicEntityNameLowerCase", publicEntityName.toLowerCase());
        templateWrapper.set("docParams", docParams);

        return templateWrapper.toString();
    }
}
