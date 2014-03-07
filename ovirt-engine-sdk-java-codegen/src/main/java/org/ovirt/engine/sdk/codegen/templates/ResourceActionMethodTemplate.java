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
import org.ovirt.engine.sdk.codegen.utils.LinkUtils;
import org.ovirt.engine.sdk.codegen.utils.StringTemplateWrapper;
import org.ovirt.engine.sdk.codegen.utils.StringUtils;
import org.ovirt.engine.sdk.entities.DetailedLink;
import org.ovirt.engine.sdk.entities.Header;
import org.ovirt.engine.sdk.entities.Parameter;

/**
 * Provides Resource action templating services
 */
public class ResourceActionMethodTemplate extends AbstractOverloadableTemplate {

    public ResourceActionMethodTemplate() {
        super();
    }

    /**
     * Formats template in to the resource action template
     *
     * @param urlParameters
     *            the list of URL parameters
     * @param headers
     *            the list of headers
     * @param methodName
     *            name of java method
     * @param actionName
     *            name of api action
     * @param docParams
     *            documentation params
     * 
     * @return formated template
     */
    private String getTemplate(
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
        StringTemplateWrapper templateWrapper = new StringTemplateWrapper(getTemplate());
        templateWrapper.set("methodName", methodName);
        templateWrapper.set("actionName", actionName);
        templateWrapper.set("docParams", docParams);
        templateWrapper.set("paramList", paramList);
        templateWrapper.set("headersToBuild", headerBuilderCode);
        templateWrapper.set("urlParamsToBuild", urlBuilderCode);
        return templateWrapper.toString();
    }

    /**
     * Formats template in to the resource action template
     * 
     * @param methodName
     *            name of java method
     * @param actionName
     *            name of api action
     * @param docParams
     *            documentation params
     * @param dl
     *            DetailedLink
     * 
     * @return formated template
     */
    public String getTemplate(String methodName, String actionName, String docParams, DetailedLink dl) {
        StringBuilder buffer = new StringBuilder();

        // Generate URL and header parameters:
        List<Parameter> urlParameters = LinkUtils.getUrlParameters(dl);
        List<Header> headers = LinkUtils.getHeaders(dl);

        // Add default method, without URL or header parameters:
        buffer.append(
            getTemplate(
                new ArrayList<Parameter>(0),
                new ArrayList<Header>(0),
                methodName,
                actionName,
                docParams
            )
        );

        // Add method overload containing all the URL parameters but none of the header parameters:
        if (!urlParameters.isEmpty()) {
            buffer.append(
                getTemplate(
                    urlParameters,
                    new ArrayList<Header>(0),
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
                    getTemplate(
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
