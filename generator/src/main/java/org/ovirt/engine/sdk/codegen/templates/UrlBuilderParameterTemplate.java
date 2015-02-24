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
 * Provides url builder parameter templating services
 */
public class UrlBuilderParameterTemplate extends AbstractTemplate {

    public UrlBuilderParameterTemplate() {
        super();
    }

    /**
     * Formats string in to url parameter builder variable
     * 
     * @param realUrlParamName
     * @param urlParamName
     * @param urlParamType
     * 
     * @return formated string
     */
    public String getTemplate(String realUrlParamName, String urlParamName, String urlParamType) {

        StringTemplateWrapper templateWrapper =
                new StringTemplateWrapper(getTemplate());

        templateWrapper.set("realUrlParamName", realUrlParamName);
        templateWrapper.set("urlParamName", urlParamName);
        templateWrapper.set("urlParamType", urlParamType);

        return templateWrapper.toString();
    }
}
