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

import java.util.ArrayList;
import java.util.List;

import org.ovirt.engine.sdk.generator.java.documentation.DocsGen;
import org.ovirt.engine.sdk.generator.BrokerRules;
import org.ovirt.engine.sdk.generator.Location;
import org.ovirt.engine.sdk.generator.LocationRules;
import org.ovirt.engine.sdk.generator.java.utils.LinkUtils;
import org.ovirt.engine.sdk.generator.java.utils.StringUtils;
import org.ovirt.engine.sdk.generator.utils.Tree;
import org.ovirt.engine.sdk.entities.DetailedLink;
import org.ovirt.engine.sdk.entities.Header;
import org.ovirt.engine.sdk.entities.Parameter;

public class CollectionActionMethodTemplate extends AbstractOverloadableTemplate {
    private String evaluate(
            List<Parameter> urlParameters,
            List<Header> headers,
            String methodName,
            String actionName,
            String docParams) {
        // Generate the parameter declarations, for both URL parameters and headers:
        List<String> paramDecls = new ArrayList<>();
        paramDecls.addAll(getUrlParameterDeclarations(urlParameters));
        paramDecls.addAll(getHeaderDeclarations(headers));
        String paramList = "";
        if (!paramDecls.isEmpty()) {
            paramList = ", " + StringUtils.formatList(paramDecls, ", ");
        }

        // Generate the code that populates the list of URL parameters to send tot the server:
        String urlBuilderCode = getUrlBuilderCode(urlParameters);
        String headerBuilderCode = getHeaderBuilderCode(headers);

        // Generate the method:
        set("methodName", methodName);
        set("actionName", actionName);
        set("docParams", docParams);
        set("paramList", paramList);
        set("headersToBuild", headerBuilderCode);
        set("urlParamsToBuild", urlBuilderCode);

        return evaluate();
    }

    public String evaluate(Tree<Location> actionTree) {
        DetailedLink dl = actionTree.get().getLinks().get(0);

        String docParams = DocsGen.generateBodyParams(dl);

        String actionName = LocationRules.getName(actionTree);
        String methodName = BrokerRules.getActionMethod(actionTree);

        StringBuilder buffer = new StringBuilder();

        // Generate URL and header parameters:
        List<Parameter> urlParameters = LinkUtils.getUrlParameters(dl);
        List<Header> headers = LinkUtils.getHeaders(dl);

        // Add default method, without URL or header parameters:
        buffer.append(
            evaluate(
                    new ArrayList<>(0),
                    new ArrayList<>(0),
                    methodName,
                    actionName,
                    docParams
            )
        );

        // Add method overload containing all the URL parameters but none of the header parameters:
        if (!urlParameters.isEmpty()) {
            buffer.append(
                evaluate(
                        urlParameters,
                        new ArrayList<>(0),
                        methodName,
                        actionName,
                        StringUtils.combine(
                                docParams,
                                DocsGen.generateUrlParameters(dl)
                        )
                )
            );
        }

        // Add method overloads containg all the URL parameters and all the sublists of the header parameters:
        if (!headers.isEmpty()) {
            for (int i = 1; i <= headers.size(); i++) {
                List<Header> headerSublist = headers.subList(0, i);
                buffer.append(
                    evaluate(
                            urlParameters,
                            headerSublist,
                            methodName,
                            actionName,
                            StringUtils.combine(
                                    docParams,
                                    DocsGen.generateHeaders(headerSublist),
                                    DocsGen.generateUrlParameters(dl)
                            )
                    )
                );
            }
        }

        return buffer.toString();
    }
}
