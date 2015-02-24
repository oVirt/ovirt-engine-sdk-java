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
 * Provides list templating services
 */
public class ListMethodTemplate extends AbstractOverloadableTemplate {

    public ListMethodTemplate() {
        super();
    }

    /**
     * Formats template in to the resource delete template
     *
     * @param urlParameters
     *            the list of URL parameters
     * @param headers
     *            the list of headers
     * @param publicCollectionName
     *            public collection name
     * @param decoratorName
     *            collection item decoarator name
     * @param docParams
     *            documentation params
     * 
     * @return formated Collection.list method
     */
    private String getTemplate(
            List<Parameter> urlParameters,
            List<Header> headers,
            String decoratorName,
            String publicCollectionName,
            String docParams) {

        // Generate the parameter declarations, for both URL parameters and headers:
        List<String> paramDecls = new ArrayList<>();
        paramDecls.addAll(getUrlParameterDeclarations(urlParameters));
        paramDecls.addAll(getHeaderDeclarations(headers));
        String paramList = StringUtils.formatList(paramDecls, ", ");

        // Generate the code that populates the list of URL parameters to send tot the server:
        String urlBuilderCode = getUrlBuilderCode(urlParameters);
        String headerBuilderCode = getHeaderBuilderCode(headers);

        // Generate the method:
        StringTemplateWrapper templateWrapper =  new StringTemplateWrapper(getTemplate());
        templateWrapper.set("decoratorName", decoratorName);
        templateWrapper.set("publicCollectionName", publicCollectionName);
        templateWrapper.set("docParams", docParams);
        templateWrapper.set("paramList", paramList);
        templateWrapper.set("headersToBuild", headerBuilderCode);
        templateWrapper.set("urlParamsToBuild", urlBuilderCode);
        return templateWrapper.toString();
    }

    /**
     * Formats template in to the Collection.list method
     * 
     * @param decoratorName
     *            collection item decoarator name
     * @param publicCollectionName
     *            public collection name
     * @param docParams
     *            documentation params
     * @param dl
     *            a DetailedLink
     * 
     * @return formated Collection.list method
     */
    public String getTemplate(String decoratorName, String publicCollectionName, String docParams, DetailedLink dl) {
        StringBuilder buffer = new StringBuilder();

        // Generate URL and header parameters:
        List<Parameter> urlParameters = LinkUtils.getUrlParameters(dl);
        List<Header> headers = LinkUtils.getHeaders(dl);

        // Add method overload containing all the URL parameters but none of the header parameters:
        if (!urlParameters.isEmpty()) {
            buffer.append(
                getTemplate(
                    urlParameters,
                    new ArrayList<Header>(0),
                    decoratorName,
                    publicCollectionName,
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
                        decoratorName,
                        publicCollectionName,
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
