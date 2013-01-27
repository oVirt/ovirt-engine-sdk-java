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
 * Provides method variable templating services
 */
public class ExtraMethodParameterTemplate extends AbstractTemplate {

    public ExtraMethodParameterTemplate() {
        super();
    }

    /**
     * Formats string in to method variable
     * 
     * @param headerParamType
     * @param headerParamName
     * 
     * @return formated string
     */
    public String getTemplate(String headerParamType, String headerParamName) {

        StringTemplateWrapper templateWrapper =
                new StringTemplateWrapper(getTemplate(), true);

        templateWrapper.set("headerParamType", headerParamType);
        templateWrapper.set("headerParamName", headerParamName);

        return templateWrapper.toString();
    }
}
