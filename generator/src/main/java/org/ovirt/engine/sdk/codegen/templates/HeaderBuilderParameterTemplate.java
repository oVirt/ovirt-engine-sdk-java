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
 * Provides http header builder variable templating services
 */
public class HeaderBuilderParameterTemplate extends AbstractTemplate {

    public HeaderBuilderParameterTemplate() {
        super();
    }

    /**
     * Formats string in to http header builder variable
     * 
     * @param realUrlParamName
     * @param headerParamName
     * 
     * @return formated string
     */
    public String getTemplate(String realUrlParamName, String headerParamName) {

        StringTemplateWrapper templateWrapper =
                new StringTemplateWrapper(getTemplate());

        templateWrapper.set("realUrlParamName", realUrlParamName);
        templateWrapper.set("headerParamName", headerParamName);

        return templateWrapper.toString();
    }
}
