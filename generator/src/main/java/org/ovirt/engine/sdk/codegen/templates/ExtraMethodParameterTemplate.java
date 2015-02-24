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
 * Template to generate a method parameter declaration that goes at the end of the list of parameters, including a comma
 * to separate it from the previous declaration.
 */
public class ExtraMethodParameterTemplate extends AbstractTemplate {
    public ExtraMethodParameterTemplate() {
        super();
    }

    public String getTemplate(String type, String name) {
        // Generate the parameter declaration, without the separator from the previous parameter:
        MethodParameterTemplate paramTemplate = new MethodParameterTemplate();
        String param = paramTemplate.getTemplate(type, name);

        // Add the separation from the previous parameter:
        StringTemplateWrapper templateWrapper = new StringTemplateWrapper(getTemplate());
        templateWrapper.set("param", param);
        return templateWrapper.toString();
    }
}
