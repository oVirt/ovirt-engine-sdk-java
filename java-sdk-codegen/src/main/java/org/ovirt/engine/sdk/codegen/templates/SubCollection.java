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

public class SubCollection {
    public static String getTemplate(String subCollectionName,
            String publicEntity,
            String publicCollection,
            String decoratorEntity,
            String parentType) {

        StringTemplate template =
                new StringTemplate(
                        CopyrightTemplate.getCopyright()
                                +
                                "\n"
                                +
                                "package org.ovirt.engine.sdk.decorators;\n"
                                +
                                "\n"
                                +
                                "import java.io.IOException;\n"
                                +
                                "import java.util.List;\n"
                                +
                                "\n"
                                +
                                "import javax.xml.bind.JAXBException;\n"
                                +
                                "\n"
                                +
                                "import org.apache.http.client.ClientProtocolException;\n"
                                +
                                "import org.ovirt.engine.sdk.common.CollectionDecorator;\n"
                                +
                                "import org.ovirt.engine.sdk.exceptions.ServerException;\n"
                                +
                                "import org.ovirt.engine.sdk.web.HttpProxyBroker;\n"
                                +
                                "\n"
                                +
                                "public class $subCollectionName$ extends CollectionDecorator<org.ovirt.engine.sdk.entities.$publicEntity$, org.ovirt.engine.sdk.entities.$publicCollection$, $decoratorEntity$> {\n"
                                +
                                "\n" +
                                "    private $parentType$ parent;\n" +
                                "\n" +
                                "    public $subCollectionName$(HttpProxyBroker proxy, $parentType$ parent) {\n" +
                                "        super(proxy);\n" +
                                "        this.parent = parent;\n" +
                                "    }\n" +
                                "}\n"
                );

        template.set("subCollectionName", subCollectionName);
        template.set("publicEntity", publicEntity);
        template.set("publicCollection", publicCollection);
        template.set("decoratorEntity", decoratorEntity);
        template.set("parentType", parentType);

        return template.toString();
    }

}
