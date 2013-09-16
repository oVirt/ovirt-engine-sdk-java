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
import org.ovirt.engine.sdk.codegen.utils.FormatUtils;
import org.ovirt.engine.sdk.codegen.utils.TypeUtils;
import org.ovirt.engine.sdk.codegen.utils.UrlUtils;
import org.ovirt.engine.sdk.entities.DetailedLink;
import org.ovirt.engine.sdk.entities.Header;
import org.ovirt.engine.sdk.entities.Parameter;
import org.ovirt.engine.sdk.utils.ArrayUtils;

/**
 * Abstract Overloadable-Template class
 */
public abstract class AbstractOverloadableTemplate extends AbstractTemplate {
    private static final String XSD_STRING_TYPE = "xs:string";
    protected static final String DOC_SEPARATOR = "     *";

    private static HeaderBuilderParameterTemplate headerBuilderParameterTemplate;
    private static ExtraMethodParameterTemplate extraMethodParameterTemplate;
    private static UrlBuilderParameterTemplate urlBuilderParameterTemplate;

    /**
     * Abstract Overloadable-Template class default constructor
     */
    public AbstractOverloadableTemplate() {
        initResources();
    }

    /**
     * Initializes AbstractOverloadableTemplate resources
     */
    public static synchronized void initResources() {
        if (headerBuilderParameterTemplate == null) {
            headerBuilderParameterTemplate = new HeaderBuilderParameterTemplate();
        }
        if (extraMethodParameterTemplate == null) {
            extraMethodParameterTemplate = new ExtraMethodParameterTemplate();
        }
        if (urlBuilderParameterTemplate == null) {
            urlBuilderParameterTemplate = new UrlBuilderParameterTemplate();
        }
    }

    /**
     * Appends url params
     * 
     * @param methodExtraParamsDef
     *            extra method params definitions
     * @param urlParamsToBuild
     *            url params to build
     * @param parameter
     *            parameter to discover
     */
    protected void addUrlParams(StringBuffer methodExtraParamsDef, StringBuffer urlParamsToBuild, Parameter parameter) {
        methodExtraParamsDef.append(extraMethodParameterTemplate.getTemplate(
                TypeUtils.toJava(parameter.getType()),
                UrlUtils.toQueryParam(parameter.getName())));

        urlParamsToBuild.append("\n" + urlBuilderParameterTemplate.getTemplate(
                parameter.getName(),
                UrlUtils.toQueryParam(parameter.getName()),
                UrlUtils.toParamType(parameter.getContext())));
    }

    /**
     * Appends header params
     * 
     * @param dl
     *            DetailedLink
     * @param methodExtraParamsDef
     *            extra method params definitions
     * @param headersToBuild
     *            headers to build
     * @param urlParamsToBuild
     *            url params to build
     * @param templateBuff
     *            template container
     * 
     * @return StringBuffer
     */
    protected StringBuffer addHeaderParams(DetailedLink dl, StringBuffer methodExtraParamsDef,
            StringBuffer headersToBuild, StringBuffer urlParamsToBuild, StringBuffer templateBuff) {
        // header params
        if (dl.isSetRequest() && dl.getRequest().isSetHeaders() &&
                dl.getRequest().getHeaders().isSetHeaders() &&
                !dl.getRequest().getHeaders().getHeaders().isEmpty()) {
            for (Header header : dl.getRequest().getHeaders().getHeaders()) {

                if (!ArrayUtils.contains(DocsGen.HEADERS_EXCEPTIONS, header.getName())) {
                    methodExtraParamsDef.append(extraMethodParameterTemplate.getTemplate(
                            TypeUtils.toJava(XSD_STRING_TYPE),
                            FormatUtils.toJava(header.getName())));

                    headersToBuild.append("\n" + headerBuilderParameterTemplate.getTemplate(
                            header.getName(),
                            FormatUtils.toJava(header.getName())));
                }
            }

        }

        return methodExtraParamsDef;
    }
}
