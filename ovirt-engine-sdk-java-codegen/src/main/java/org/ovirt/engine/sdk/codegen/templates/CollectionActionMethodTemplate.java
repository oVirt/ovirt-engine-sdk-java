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
 * Provides Resource action templating services
 */
public class CollectionActionMethodTemplate extends AbstractOverloadableTemplate {

    public CollectionActionMethodTemplate() {
        super();
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
     * 
     * @return Formated template
     */
    private String getTemplate(String methodName, String actionName, String docParams) {
        return getTemplate(methodName, actionName, docParams, "", "", "");
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
     * @param methodExtraParamsDef
     *            method parameters (url/header encapsulations)
     * @param headersToBuild
     *            headers to build with HttpHeaderBuilder
     * @param urlParamsToBuild
     *            url Params To Build with UrlParamsBuilder
     * 
     * @return formated template
     */
    private String getTemplate(String methodName,
            String actionName,
            String docParams,
            String methodExtraParamsDef,
            String headersToBuild,
            String urlParamsToBuild) {

        StringTemplateWrapper templateWrapper =
                new StringTemplateWrapper(getTemplate());

        templateWrapper.set("methodName", methodName);
        templateWrapper.set("actionName", actionName);
        templateWrapper.set("docParams", docParams);
        templateWrapper.set("methodExtraParamsDef", methodExtraParamsDef);
        templateWrapper.set("headersToBuild", headersToBuild);
        templateWrapper.set("urlParamsToBuild", urlParamsToBuild);

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
    public String getTemplate(String methodName, String actionName,
            String docParams, DetailedLink dl) {

        StringBuffer methodExtraParamsDef = new StringBuffer();
        StringBuffer headersToBuild = new StringBuffer();
        StringBuffer urlParamsToBuild = new StringBuffer();
        StringBuffer templateBuff = new StringBuffer();

        if (dl.isSetRequest() && dl.getRequest().isSetUrl() &&
                dl.getRequest().getUrl().isSetParametersSets() &&
                !dl.getRequest().getUrl().getParametersSets().isEmpty()) {

            // url params
            for (ParametersSet parametersSet : dl.getRequest().getUrl().getParametersSets()) {
                for (Parameter parameter : parametersSet.getParameters()) {
                    addUrlParams(methodExtraParamsDef, urlParamsToBuild, parameter);
                }
                methodExtraParamsDef =
                        addHeaderParams(methodName, actionName, docParams, dl,
                                methodExtraParamsDef, headersToBuild, urlParamsToBuild, templateBuff);
            }
        } else {
            methodExtraParamsDef =
                    addHeaderParams(methodName, actionName, docParams, dl,
                            methodExtraParamsDef, headersToBuild, urlParamsToBuild, templateBuff);
        }

        // add default method
        templateBuff.append(getTemplate(methodName,
                actionName,
                docParams));

        // add method overload containing url/matrix params
        if (methodExtraParamsDef.length() > 0) {
            templateBuff.append(getTemplate(methodName,
                    actionName,
                    StringUtils.combine(docParams, DocsGen.generateUrlAndHeadersParams(dl)),
                    methodExtraParamsDef.toString(),
                    headersToBuild.toString(),
                    urlParamsToBuild.toString()));
        }

        return templateBuff.toString();
    }
}
