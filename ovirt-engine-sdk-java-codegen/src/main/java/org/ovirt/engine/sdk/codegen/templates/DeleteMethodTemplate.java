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
 * Provides Resource delete templating services
 */
public class DeleteMethodTemplate extends AbstractOverloadableTemplate {

    private static final String DOC_SEPARATOR = "     *";
    private static DeleteMethodWithBodyTemplate deleteMethodWithBodyTemplate;

    public DeleteMethodTemplate() {
        super();
        initStaticContext();
    }

    /**
     * Initalises static context
     */
    private static synchronized void initStaticContext() {
        deleteMethodWithBodyTemplate = new DeleteMethodWithBodyTemplate();
    }

    /**
     * Formats template in to the resource delete template
     * 
     * @return DeleteMethodTemplate
     */
    @Override
    public String getTemplate() {
        return getTemplate(DOC_SEPARATOR, "", "", "");
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
    private String getTemplate(String docParams, String methodExtraParamsDef,
            String headersToBuild, String urlParamsToBuild) {

        StringTemplateWrapper templateWrapper =
                new StringTemplateWrapper(super.getTemplate());

        if (methodExtraParamsDef.startsWith(", ") && methodExtraParamsDef.length() > 2) {
            methodExtraParamsDef =
                    methodExtraParamsDef.substring(2, methodExtraParamsDef.length());
        }

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
     * @param dl
     *            a DetailedLink
     * 
     * @return formated add template
     */
    public String getTemplate(String docParams, DetailedLink dl) {

        StringBuffer methodExtraParamsDef = new StringBuffer();
        StringBuffer headersToBuild = new StringBuffer();
        StringBuffer urlParamsToBuild = new StringBuffer();
        StringBuffer templateBuff = new StringBuffer();

        if (dl.isSetRequest() && dl.getRequest().isSetBody() && dl.getRequest().getBody().isSetType() && !
                dl.getRequest().getBody().getType().equals("") && dl.getRequest().getBody().getRequired() != null
                && dl.getRequest().getBody().getRequired().equals(Boolean.TRUE)) {
            // add delete() with body overload (body is mandatory)
            templateBuff.append(deleteMethodWithBodyTemplate.getTemplate(docParams, dl));
        } else {
            if (dl.isSetRequest() && dl.getRequest().isSetUrl() &&
                    dl.getRequest().getUrl().isSetParametersSets() &&
                    !dl.getRequest().getUrl().getParametersSets().isEmpty()) {

                // add url params
                for (ParametersSet parametersSet : dl.getRequest().getUrl().getParametersSets()) {
                    for (Parameter parameter : parametersSet.getParameters()) {
                        addUrlParams(methodExtraParamsDef, urlParamsToBuild, parameter);
                    }
                    // add header params
                    methodExtraParamsDef =
                            addHeaderParams(dl, methodExtraParamsDef,
                                    headersToBuild, urlParamsToBuild, templateBuff);
                }
            } else {
                // add header params
                methodExtraParamsDef =
                        addHeaderParams(dl, methodExtraParamsDef,
                                headersToBuild, urlParamsToBuild, templateBuff);
            }

            // add default method
            templateBuff.append(getTemplate());

            // add delete() overload with url/header params
            if (methodExtraParamsDef.length() > 0) {
                templateBuff.append(getTemplate(
                        StringUtils.combine(DOC_SEPARATOR, DocsGen.generateUrlAndHeadersParams(dl)),
                        methodExtraParamsDef.toString(),
                        headersToBuild.toString(),
                        urlParamsToBuild.toString()));
            }

            // add delete() with body overload (body is optional)
            if (dl.isSetRequest() && dl.getRequest().isSetBody() && dl.getRequest().getBody().isSetType()
                    && !dl.getRequest().getBody().getType().equals("")
                    && ((dl.getRequest().getBody().getRequired() != null
                    && !dl.getRequest().getBody().getRequired().equals(Boolean.TRUE))
                    ||
                    dl.getRequest().getBody().getRequired() == null)) {
                templateBuff.append(deleteMethodWithBodyTemplate.getTemplate(docParams, dl));
            }
        }

        return templateBuff.toString();
    }
}
