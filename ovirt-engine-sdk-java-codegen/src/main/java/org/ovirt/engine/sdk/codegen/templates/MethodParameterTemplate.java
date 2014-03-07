//
// Copyright (c) 2014 Red Hat, Inc.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
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
 * Template to generate the declaration of a method parameter given its type and its name.
 */
public class MethodParameterTemplate extends AbstractTemplate {

    public MethodParameterTemplate() {
        super();
    }

    public String getTemplate(String type, String name) {
        StringTemplateWrapper templateWrapper = new StringTemplateWrapper(getTemplate(), true);
        templateWrapper.set("type", type);
        templateWrapper.set("name", name);
        return templateWrapper.toString();
    }
}
