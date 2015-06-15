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

package org.ovirt.engine.sdk.generator.java.templates;

import java.util.List;

import org.ovirt.engine.sdk.generator.java.documentation.DocsGen;
import org.ovirt.engine.sdk.generator.BrokerRules;
import org.ovirt.engine.sdk.generator.Location;
import org.ovirt.engine.sdk.generator.LocationRules;
import org.ovirt.engine.sdk.generator.SchemaRules;
import org.ovirt.engine.sdk.generator.java.ParameterData;
import org.ovirt.engine.sdk.generator.java.utils.LinkUtils;
import org.ovirt.engine.sdk.generator.java.utils.MethodUtils;
import org.ovirt.engine.sdk.generator.java.utils.StringUtils;
import org.ovirt.engine.sdk.generator.utils.Tree;
import org.ovirt.engine.sdk.entities.DetailedLink;

public class ListMethodTemplate extends AbstractOverloadableTemplate {
    private String evaluate(
            List<ParameterData> parameters,
            String decoratorName,
            String publicCollectionName,
            String docParams) {
        // Generate the code that populates the list of URL parameters to send tot the server:
        String urlBuilderCode = getUrlBuilderCode(parameters);
        String headerBuilderCode = getHeaderBuilderCode(parameters);

        // Generate the method:
        set("decoratorName", decoratorName);
        set("publicCollectionName", publicCollectionName);
        set("docParams", docParams);
        set("paramList", MethodUtils.formatParameters(parameters));
        set("headersToBuild", headerBuilderCode);
        set("urlParamsToBuild", urlBuilderCode);
        return evaluate();
    }

    public String evaluate(String className, Tree<Location> collectionTree, DetailedLink dl) {
        Tree<Location> entityTree = collectionTree.getChild(LocationRules::isEntity);

        String brokerType = BrokerRules.getBrokerType(entityTree);
        String collectionType = SchemaRules.getSchemaType(collectionTree);

        String docParams = DocsGen.generateBodyParams(dl);

        StringBuilder buffer = new StringBuilder();

        // Get the list of parameters:
        List<ParameterData> parameters = LinkUtils.getParameters(dl);

        // Reorder the parameters declarations for backwards compatibility:
        parameters = MethodUtils.reorderParameters(className, "list", parameters);

        // Generate a version of the method for each prefix of the list of parameter declarations, not including the
        // empty list, as that is already part of the template:
        for (int i = 1; i <= parameters.size(); i++) {
            List<ParameterData> prefix = parameters.subList(0, i);
            buffer.append(
                evaluate(
                    prefix,
                    brokerType,
                    collectionType,
                    StringUtils.combine(docParams, DocsGen.generateParameters(prefix))
                )
            );
        }

        return buffer.toString();
    }
}
