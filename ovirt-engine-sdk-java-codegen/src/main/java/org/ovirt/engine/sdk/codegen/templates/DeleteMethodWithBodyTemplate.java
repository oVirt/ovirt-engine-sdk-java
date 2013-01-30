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

import org.ovirt.engine.sdk.codegen.documentation.DocsGen;
import org.ovirt.engine.sdk.codegen.utils.StringTemplateWrapper;
import org.ovirt.engine.sdk.codegen.utils.StringUtils;
import org.ovirt.engine.sdk.entities.DetailedLink;
import org.ovirt.engine.sdk.entities.Parameter;
import org.ovirt.engine.sdk.entities.ParametersSet;

/**
 * Provides Resource delete with body templating services
 */
public class DeleteMethodWithBodyTemplate extends AbstractOverloadableTemplate {

    public DeleteMethodWithBodyTemplate() {
        super();
    }

    /**
     * Formats template in to the resource delete template
     * 
     * @param docParams
     *            documentation params
     * @param methodExtraParamsDef
     *            method parameters (url/header encapsulations)
     * @param headersToBuild
     *            headers to build with HttpHeaderBuilder
     * @param urlParamsToBuild
     *            url Params To Build with UrlParamsBuilder
     * 
     * @return formated add template
     */
    private String getTemplate(String deleteBody, String docParams, String methodExtraParamsDef,
            String headersToBuild, String urlParamsToBuild) {

        StringTemplateWrapper templateWrapper =
                new StringTemplateWrapper(super.getTemplate());

        templateWrapper.set("deleteBody", deleteBody);
        templateWrapper.set("deleteBodyLowerCase", deleteBody.toLowerCase());

        templateWrapper.set("docParams", docParams);
        templateWrapper.set("methodExtraParamsDef", methodExtraParamsDef);
        templateWrapper.set("headersToBuild", headersToBuild);
        templateWrapper.set("urlParamsToBuild", urlParamsToBuild);

        return templateWrapper.toString();
    }

    /**
     * Formats template in to the resource add template
     * 
     * @param docParams
     *            documentation params
     * @param detailedLink
     *            a DetailedLink
     * 
     * @return formated add template
     */
    public String getTemplate(String docParams, DetailedLink detailedLink) {

        StringBuffer methodExtraParamsDef = new StringBuffer();
        StringBuffer headersToBuild = new StringBuffer();
        StringBuffer urlParamsToBuild = new StringBuffer();
        StringBuffer templateBuff = new StringBuffer();

        if (detailedLink.isSetRequest() && detailedLink.getRequest().isSetUrl() &&
                detailedLink.getRequest().getUrl().isSetParametersSets() &&
                !detailedLink.getRequest().getUrl().getParametersSets().isEmpty()) {

            // add url params
            for (ParametersSet parametersSet : detailedLink.getRequest().getUrl().getParametersSets()) {
                for (Parameter parameter : parametersSet.getParameters()) {
                    addUrlParams(methodExtraParamsDef, urlParamsToBuild, parameter);
                }
                // add header params
                methodExtraParamsDef =
                        addHeaderParams(detailedLink, methodExtraParamsDef,
                                headersToBuild, urlParamsToBuild, templateBuff);
            }
        } else {
            // add header params
            methodExtraParamsDef =
                    addHeaderParams(detailedLink, methodExtraParamsDef,
                            headersToBuild, urlParamsToBuild, templateBuff);
        }

        // add method overload containing url/matrix params
        if (methodExtraParamsDef.length() > 0) {
            templateBuff.append(getTemplate(
                    detailedLink.getRequest().getBody().getType(),
                    StringUtils.combine(docParams, DocsGen.generateUrlAndHeadersParams(detailedLink)),
                    methodExtraParamsDef.toString(),
                    headersToBuild.toString(),
                    urlParamsToBuild.toString()));
        }

        return templateBuff.toString();
    }
}
