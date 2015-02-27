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

import org.ovirt.engine.sdk.generator.java.utils.FormatUtils;
import org.ovirt.engine.sdk.generator.java.utils.TypeUtils;
import org.ovirt.engine.sdk.generator.java.utils.UrlUtils;
import org.ovirt.engine.sdk.generator.templates.AbstractTemplate;
import org.ovirt.engine.sdk.entities.Header;
import org.ovirt.engine.sdk.entities.Parameter;

/**
 * Abstract Overloadable-Template class
 */
public abstract class AbstractOverloadableTemplate extends AbstractTemplate {
    private static final String XSD_STRING_TYPE = "xs:string";
    protected static final String DOC_SEPARATOR = "     *";

    /**
     * Generate the code that checks the value of URL parameters and adds it to the list of parameters to actually send
     * to the server.
     *
     * @param parameters the list of parameters to add
     */
    protected String getUrlBuilderCode(List<Parameter> parameters) {
        StringBuilder buffer = new StringBuilder();
        for (Parameter parameter : parameters) {
            UrlBuilderParameterTemplate template = new UrlBuilderParameterTemplate();
            buffer.append("\n");
            buffer.append(
                template.evaluate(
                    parameter.getName(),
                    UrlUtils.toQueryParam(parameter.getName()),
                    UrlUtils.toParamType(parameter.getContext())
                )
            );
        }
        return buffer.toString();
    }

    /**
     * Get a list of the method parameter declarations that corresponding to the given URL parameters.
     *
     * @param params a list containing the URL parameters
     */
    protected List<String> getUrlParameterDeclarations(List<Parameter> params) {
        List<String> paramDecls = new ArrayList<>();
        for (Parameter param : params) {
            String paramName = UrlUtils.toQueryParam(param.getName());
            String paramType = TypeUtils.toJava(param.getType());
            MethodParameterTemplate paramDeclTemplate = new MethodParameterTemplate();
            String paramDecl = paramDeclTemplate.evaluate(paramType, paramName);
            paramDecls.add(paramDecl);
        }
        return paramDecls;
    }

    /**
     * Get a list of the method parameter declarations that corresponding to the given headers.
     *
     * @param headers a list containing the headers
     */
    protected List<String> getHeaderDeclarations(List<Header> headers) {
        List<String> paramDecls = new ArrayList<>();
        for (Header header : headers) {
            String paramName = FormatUtils.toJava(header.getName());
            String paramType = TypeUtils.toJava(XSD_STRING_TYPE);
            MethodParameterTemplate paramDeclTemplate = new MethodParameterTemplate();
            String paramDecl = paramDeclTemplate.evaluate(paramType, paramName);
            paramDecls.add(paramDecl);
        }
        return paramDecls;
    }

    /**
     * Appends header params
     *
     * @param headers the list of headers
     */
    protected String getHeaderBuilderCode(List<Header> headers) {
        StringBuilder buffer = new StringBuilder();
        for (Header header : headers) {
            String headerName = header.getName();
            HeaderBuilderParameterTemplate template = new HeaderBuilderParameterTemplate();
            buffer.append("\n");
            buffer.append(
                template.evaluate(
                    headerName,
                    FormatUtils.toJava(headerName)
                )
            );
        }
        return buffer.toString();
    }
}
