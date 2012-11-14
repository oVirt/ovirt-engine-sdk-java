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

import org.ovirt.engine.sdk.codegen.utils.StringTemplate;

public class CollectionTemplate extends Template {

    private static String NAME = "Collection";

    public CollectionTemplate(String name) {
        super(NAME);
    }

    public String getTemplate(String collectionName,
            String publicEntity,
            String publicCollection,
            String decoratorEntity,
            String methods) {

        StringTemplate template =
                new StringTemplate(
                        getCopyrightTemplate()
                                +
                                loadTemplate()
                );

        template.set("collectionName", collectionName);
        template.set("publicEntity", publicEntity);
        template.set("publicCollection", publicCollection);
        template.set("decoratorEntity", decoratorEntity);
        template.set("methods", methods);

        return template.toString();
    }
}
