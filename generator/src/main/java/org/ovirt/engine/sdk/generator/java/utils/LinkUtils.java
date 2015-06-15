//
// Copyright (c) 2014 Red Hat, Inc.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
//

package org.ovirt.engine.sdk.generator.java.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.ovirt.engine.sdk.entities.DetailedLink;
import org.ovirt.engine.sdk.entities.Header;
import org.ovirt.engine.sdk.entities.Headers;
import org.ovirt.engine.sdk.entities.Parameter;
import org.ovirt.engine.sdk.entities.ParametersSet;
import org.ovirt.engine.sdk.entities.Request;
import org.ovirt.engine.sdk.generator.java.ParameterContext;
import org.ovirt.engine.sdk.generator.java.ParameterData;
import org.ovirt.engine.sdk.generator.java.ParameterType;

public class LinkUtils {
    /**
     * Names of headers that are ignored for code generation purposes.
     */
    private static final Set<String> HEADERS_EXCEPTIONS = new HashSet<>();

    static {
        HEADERS_EXCEPTIONS.add("Content-Type");
        HEADERS_EXCEPTIONS.add("Filter");
    }

    /**
     * Get the list of parameters that are available in the given link.
     */
    public static List<ParameterData> getParameters(DetailedLink dl) {
        List<ParameterData> result = new ArrayList<>();
        result.addAll(getUrlParameters(dl));
        result.addAll(getHeaderParameters(dl));
        return result;
    }

    /**
     * Get the list of URL parameters that are available in the given link.
     */
    public static List<ParameterData> getUrlParameters(DetailedLink dl) {
        List<ParameterData> result = new ArrayList<>();
        if (dl.isSetRequest() && dl.getRequest().isSetUrl() &&
            dl.getRequest().getUrl().isSetParametersSets() &&
            !dl.getRequest().getUrl().getParametersSets().isEmpty()) {
            for (ParametersSet parametersSet : dl.getRequest().getUrl().getParametersSets()) {
                for (Parameter parameter : parametersSet.getParameters()) {
                    ParameterData parameterData = new ParameterData();
                    parameterData.setName(parameter.getName());
                    parameterData.setType(ParameterType.URL);
                    switch (parameter.getContext()) {
                    case "query":
                        parameterData.setContext(ParameterContext.QUERY);
                        break;
                    case "matrix":
                        parameterData.setContext(ParameterContext.MATRIX);
                        break;
                    default:
                        throw new IllegalArgumentException(
                            "The value \"" + parameter.getContext() + "\" isn't a valid URL parameter context."
                        );
                    }
                    parameterData.setRequired(parameter.isRequired() != null && parameter.isRequired());
                    parameterData.setValues(parameter.getValue());
                    parameterData.setJavaName(UrlUtils.toQueryParam(parameter.getName()));
                    parameterData.setJavaType(TypeUtils.toJava(parameter.getType()));
                    result.add(parameterData);
                }
            }
        }
        return result;
    }

    /**
     * Get the list of headers available in the given link, filtering out the ones that should be ignored.
     */
    public static List<ParameterData> getHeaderParameters(DetailedLink dl) {
        List<ParameterData> result = new ArrayList<>();
        Request request = dl.getRequest();
        if (request != null) {
            Headers headers = request.getHeaders();
            if (headers != null) {
                for (Header header : headers.getHeaders()) {
                    if (!HEADERS_EXCEPTIONS.contains(header.getName())) {
                        ParameterData parameterData = new ParameterData();
                        parameterData.setName(header.getName());
                        parameterData.setType(ParameterType.HEADER);
                        parameterData.setJavaName(FormatUtils.toJava(header.getName()));
                        parameterData.setRequired(header.isRequired() != null && header.isRequired());
                        parameterData.setValues(header.getValue());
                        parameterData.setJavaType("String");
                        result.add(parameterData);
                    }
                }
            }
        }
        return result;
    }
}
