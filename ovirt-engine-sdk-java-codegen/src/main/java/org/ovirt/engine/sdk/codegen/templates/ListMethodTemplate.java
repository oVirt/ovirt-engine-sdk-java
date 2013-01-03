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

import org.ovirt.engine.sdk.codegen.utils.StringTemplateWrapper;
import org.ovirt.engine.sdk.entities.Parameter;
import org.ovirt.engine.sdk.entities.ParametersSet;
import org.ovirt.engine.sdk.entities.Url;
import org.ovirt.engine.sdk.utils.StringUtils;
import org.ovirt.engine.sdk.web.UrlParameterType;

/**
 * Provides list templating services
 */
public class ListMethodTemplate extends AbstractTemplate {

    public ListMethodTemplate() {
        super();
    }

    /**
     * Formats template in to the Collection.list method
     * 
     * @param decoratorName
     *            collection item decoarator name
     * @param paramsDoc
     *            parameters documentation
     * @param paramsDef
     *            parameters method declarations
     * @param paramsAdd
     *            parameters to add via Urlbuilder
     * @param publicCollectionName
     *            public collection name
     * 
     * @return formated Collection.list method
     */
    private String getTemplate(String decoratorName,
            String paramsDoc,
            String paramsDef,
            String paramsAdd,
            String publicCollectionName) {

        StringTemplateWrapper templateWrapper =
                new StringTemplateWrapper(getTemplate());

        templateWrapper.set("decoratorName", decoratorName);
        templateWrapper.set("paramsDoc", paramsDoc);
        templateWrapper.set("paramsDef", paramsDef);
        templateWrapper.set("paramsAdd", paramsAdd);
        templateWrapper.set("publicCollectionName", publicCollectionName);

        return templateWrapper.toString();
    }

    /**
     * Formats template in to the Collection.list method
     * 
     * @param decoratorName
     *            collection item decoarator name
     * @param publicCollectionName
     *            public collection name
     * @param url
     *            url parameters holder
     * 
     * @return formated Collection.list method
     */
    public String getTemplate(String decoratorName,
            String publicCollectionName, Url url) {

        StringBuffer effectiveTemplate = new StringBuffer();
        StringBuffer paramsDoc = new StringBuffer();
        StringBuffer paramsDef = new StringBuffer();
        StringBuffer paramsAdd = new StringBuffer();

        for (ParametersSet parametersSet : url.getParametersSets()) {
            for (Parameter parameter : parametersSet.getParameters()) {
                StringTemplateWrapper PARAMS_DOC_TEMPLATE =
                        new StringTemplateWrapper("\n     * @param $urlParamName$" +
                                "\n     *            $urlParamDescription$");
                StringTemplateWrapper PARAMS_DEF_TEMPLATE =
                        new StringTemplateWrapper("$urlParamType$ $urlParamName$");
                StringTemplateWrapper PARAMS_ADD_TEMPLATE =
                        new StringTemplateWrapper("\n                .add(\"$realUrlParamName$\", $urlParamName$, UrlParameterType.$urlParamType$)");

                PARAMS_DOC_TEMPLATE.set("urlParamName", wrapParameterName(parameter.getName()));
                PARAMS_DOC_TEMPLATE.set("urlParamDescription", parameter.getValue());
                paramsDoc.append(PARAMS_DOC_TEMPLATE.toString());

                PARAMS_DEF_TEMPLATE.set("urlParamType", toJavaType(parameter.getType()));
                PARAMS_DEF_TEMPLATE.set("urlParamName", wrapParameterName(parameter.getName()));
                paramsDef.append(PARAMS_DEF_TEMPLATE.toString() + ", ");

                PARAMS_ADD_TEMPLATE.set("realUrlParamName", parameter.getName());
                PARAMS_ADD_TEMPLATE.set("urlParamName", wrapParameterName(parameter.getName()));
                PARAMS_ADD_TEMPLATE.set("urlParamType", toUrlParamType(parameter.getContext()));
                paramsAdd.append(PARAMS_ADD_TEMPLATE).toString();

            }
            effectiveTemplate.append(getTemplate(decoratorName,
                    paramsDoc.toString(),
                    paramsDef.toString().substring(0, paramsDef.length() - 2),
                    paramsAdd.toString(),
                    publicCollectionName) + "\n");
        }
        return effectiveTemplate.toString();
    }

    /**
     * Decorates parameters names
     * 
     * @param parameterName
     *            actual name
     * 
     * @return converted name
     */
    private String wrapParameterName(String parameterName) {
        if (parameterName.equals("search")) {
            return "query";
        } else if (parameterName.contains("_")) {
            return toJavaFormat(parameterName);
        }
        return parameterName;
    }

    /**
     * Converts parameter name according Java naming convention
     * 
     * @param parameterName
     *            parameter to convert
     * 
     * @return converted parameter
     */
    private String toJavaFormat(String parameterName) {
        String[] periods = parameterName.split("_");
        StringBuffer newName = new StringBuffer();
        if (periods.length > 0) {
            newName.append(periods[0]);
            for (int i = 1; i < periods.length; i++) {
                newName.append(StringUtils.toUpperCase(periods[i]));
            }
            return newName.toString();
        }
        return parameterName;
    }

    /**
     * Formats type in to java type
     * 
     * @param type
     *            the type to convert
     * 
     * @return java type
     */
    private String toJavaType(String type) {
        String desieredType = type.replace("xs:", "");
        if (desieredType.equals("string")) {
            return String.class.getSimpleName();
        } else if (desieredType.equals("boolean")) {
            return Boolean.class.getSimpleName();
        } else if (desieredType.equals("int")) {
            return Integer.class.getSimpleName();
        } else if (desieredType.equals("long")) {
            return Long.class.getSimpleName();
        }
        throw new RuntimeException("Unsupported parameter type \"" + type + "\".");
    }

    /**
     * Formats parameter context in to UrlParameterType member
     * 
     * @param context
     *            context to format
     * 
     * @return UrlParameterType
     */
    private String toUrlParamType(final String context) {
        if (context.equals("query")) {
            return UrlParameterType.QUERY.toString();
        } else if (context.equals("matrix")) {
            return UrlParameterType.MATRIX.toString();
        }
        throw new RuntimeException("Unsupported url parameter type \"" + context + "\".");
    }
}
