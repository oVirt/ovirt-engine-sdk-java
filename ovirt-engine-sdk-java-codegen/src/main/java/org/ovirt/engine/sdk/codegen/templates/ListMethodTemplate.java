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
import org.ovirt.engine.sdk.codegen.utils.TypeUtils;
import org.ovirt.engine.sdk.codegen.utils.UrlUtils;
import org.ovirt.engine.sdk.entities.Parameter;
import org.ovirt.engine.sdk.entities.ParametersSet;
import org.ovirt.engine.sdk.entities.Url;

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
            String publicCollectionName,
            Url url) {

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

                PARAMS_DOC_TEMPLATE.set("urlParamName", UrlUtils.toQueryParam(parameter.getName()));
                PARAMS_DOC_TEMPLATE.set("urlParamDescription", parameter.getValue());
                paramsDoc.append(PARAMS_DOC_TEMPLATE.toString());

                PARAMS_DEF_TEMPLATE.set("urlParamType", TypeUtils.toJava(parameter.getType()));
                PARAMS_DEF_TEMPLATE.set("urlParamName", UrlUtils.toQueryParam(parameter.getName()));
                paramsDef.append(PARAMS_DEF_TEMPLATE.toString() + ", ");

                PARAMS_ADD_TEMPLATE.set("realUrlParamName", parameter.getName());
                PARAMS_ADD_TEMPLATE.set("urlParamName", UrlUtils.toQueryParam(parameter.getName()));
                PARAMS_ADD_TEMPLATE.set("urlParamType", UrlUtils.toParamType(parameter.getContext()));
                paramsAdd.append(PARAMS_ADD_TEMPLATE.toString());

            }
            effectiveTemplate.append(getTemplate(
                    decoratorName,
                    paramsDoc.toString(),
                    paramsDef.toString().substring(0, paramsDef.length() - 2),
                    paramsAdd.toString(),
                    publicCollectionName) + "\n");
        }
        return effectiveTemplate.toString();
    }
}
