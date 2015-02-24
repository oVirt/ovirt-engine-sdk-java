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

import java.util.ArrayList;
import java.util.List;

import org.ovirt.engine.sdk.codegen.documentation.DocsGen;
import org.ovirt.engine.sdk.codegen.rsdl.Location;
import org.ovirt.engine.sdk.codegen.utils.LinkUtils;
import org.ovirt.engine.sdk.codegen.utils.StringUtils;
import org.ovirt.engine.sdk.codegen.utils.Tree;
import org.ovirt.engine.sdk.entities.DetailedLink;
import org.ovirt.engine.sdk.entities.Header;
import org.ovirt.engine.sdk.entities.Parameter;

public class DeleteMethodTemplate extends AbstractOverloadableTemplate {
    private String evaluate(List<Parameter> urlParameters, List<Header> headers, String docParams) {
        // Generate the parameter declarations, for both URL parameters and headers:
        List<String> paramDecls = new ArrayList<>();
        paramDecls.addAll(getUrlParameterDeclarations(urlParameters));
        paramDecls.addAll(getHeaderDeclarations(headers));
        String paramList = StringUtils.formatList(paramDecls, ", ");

        // Generate the code that populates the list of URL parameters to send tot the server:
        String urlBuilderCode = getUrlBuilderCode(urlParameters);
        String headerBuilderCode = getHeaderBuilderCode(headers);

        // Generate the method:
        set("docParams", docParams);
        set("paramList", paramList);
        set("headersToBuild", headerBuilderCode);
        set("urlParamsToBuild", urlBuilderCode);

        return evaluate();
    }

    public String evaluate(Tree<Location> entityTree, DetailedLink dl) {
        StringBuilder buffer = new StringBuilder();

        if (dl.isSetRequest() && dl.getRequest().isSetBody() && dl.getRequest().getBody().isSetType() && !
                dl.getRequest().getBody().getType().equals("") && dl.getRequest().getBody().isRequired() != null
                && dl.getRequest().getBody().isRequired().equals(Boolean.TRUE)) {
            // add delete() with body overload (body is mandatory)
            buffer.append(new DeleteMethodWithBodyTemplate().evaluate(dl));
        } else {
            // Generate URL and header parameters:
            List<Parameter> urlParameters = LinkUtils.getUrlParameters(dl);
            List<Header> headers = LinkUtils.getHeaders(dl);

            // Add default method, without URL or header parameters:
            buffer.append(
                evaluate(
                    new ArrayList<>(0),
                    new ArrayList<>(0),
                    DOC_SEPARATOR
                )
            );

            // Add method overload containing all the URL parameters but none of the header parameters:
            if (!urlParameters.isEmpty()) {
                buffer.append(
                    evaluate(
                        urlParameters,
                        new ArrayList<>(0),
                        StringUtils.combine(
                            DOC_SEPARATOR,
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
                            StringUtils.combine(
                                DOC_SEPARATOR,
                                DocsGen.generateHeaders(headerSublist),
                                DocsGen.generateUrlParameters(dl)
                            )
                        )
                    );
                }
            }

            // add delete() with body overload (body is optional)
            if (dl.isSetRequest() && dl.getRequest().isSetBody() && dl.getRequest().getBody().isSetType()
                    && !dl.getRequest().getBody().getType().equals("")
                    && ((dl.getRequest().getBody().isRequired() != null
                    && !dl.getRequest().getBody().isRequired().equals(Boolean.TRUE))
                    ||
                    dl.getRequest().getBody().isRequired() == null)) {
                buffer.append(new DeleteMethodWithBodyTemplate().evaluate(dl));
            }
        }

        return buffer.toString();
    }
}
