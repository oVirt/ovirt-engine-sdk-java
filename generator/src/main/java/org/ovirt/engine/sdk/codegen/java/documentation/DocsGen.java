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

package org.ovirt.engine.sdk.codegen.java.documentation;

import java.util.List;

import org.ovirt.engine.sdk.codegen.java.utils.FormatUtils;
import org.ovirt.engine.sdk.codegen.java.utils.StringUtils;
import org.ovirt.engine.sdk.codegen.java.utils.UrlUtils;
import org.ovirt.engine.sdk.entities.DetailedLink;
import org.ovirt.engine.sdk.entities.Header;
import org.ovirt.engine.sdk.entities.Parameter;
import org.ovirt.engine.sdk.entities.ParametersSet;

/**
 * Provides documentation related codegen capabilities
 */
public class DocsGen {

    private static final int DOC_LENGH = 42;
    private static final String BREACKS_OPEN = "[";
    private static final String BREACKS_CLOSE = "]";
    private static final String NEW_LINE = "\n";
    private static final String PRE_CLOSE = "</pre>";
    private static final String PRE_OPEN = "<pre>";
    private static final String OVERLOAD = "Overload ";
    private static final String OVERLOAD_OFFSET = "  ";
    private static final String PREFIX = "     *";
    private static final String SPACE = " ";
    private static final String PARAM_DETAILS_OFFSET = "    ";
    private static final String AT = "@param ";
    private static final String PARAM = PREFIX + " " + AT;
    private static final String LINK = " {@link $TYPE$}";
    private static final String NAMESPACE = "org.ovirt.engine.sdk.entities.";

    /**
     * Generate doc string from DetailedLink params
     * 
     * @param detailedLink
     * 
     * @return doc string
     */
    public static String generateBodyParams(DetailedLink detailedLink) {
        StringBuffer docParams = new StringBuffer();
        docParams.append(PREFIX);

        if (detailedLink.isSetRequest() && detailedLink.getRequest().isSetBody()
                && detailedLink.getRequest().getBody().isSetType()) {
            docParams.append(NEW_LINE + PARAM + detailedLink.getRequest().getBody()
                    .getType().toLowerCase() + LINK.replace("$TYPE$",
                    NAMESPACE + detailedLink.getRequest().getBody().getType()));

            if (detailedLink.getRequest().getBody().getParametersSets().size() > 1) {
                docParams.append(NEW_LINE + PREFIX + PARAM_DETAILS_OFFSET + PRE_OPEN);
                int i = 1;
                for (ParametersSet ps : detailedLink.getRequest().getBody().getParametersSets()) {
                    docParams.append(NEW_LINE + PREFIX + PARAM_DETAILS_OFFSET + OVERLOAD + i + ":" + NEW_LINE);
                    addParameterSetDescription(docParams, ps);
                    for (Parameter param : ps.getParameters()) {
                        if (param.isRequired() != null && param.isRequired().equals(Boolean.TRUE)) {
                            docParams.append(PREFIX + PARAM_DETAILS_OFFSET + OVERLOAD_OFFSET + param.getName()
                                    + NEW_LINE);
                        } else {
                            docParams.append(PREFIX + PARAM_DETAILS_OFFSET + OVERLOAD_OFFSET + BREACKS_OPEN
                                    + param.getName() +
                                    BREACKS_CLOSE + NEW_LINE);
                        }
                    }
                    docParams.append(PREFIX);
                    i++;
                }
                docParams.append(PARAM_DETAILS_OFFSET + PRE_CLOSE + NEW_LINE + PREFIX);
            } else if (detailedLink.getRequest().getBody().getParametersSets().size() == 1) {
                docParams.append(NEW_LINE + PREFIX + PARAM_DETAILS_OFFSET + PRE_OPEN);
                for (Parameter param : detailedLink.getRequest()
                        .getBody().getParametersSets().get(0).getParameters()) {
                    if (param.isRequired() != null && param.isRequired().equals(Boolean.TRUE)) {
                        docParams.append(NEW_LINE + PREFIX + PARAM_DETAILS_OFFSET + param.getName());
                    } else {
                        docParams.append(NEW_LINE + PREFIX + PARAM_DETAILS_OFFSET + BREACKS_OPEN
                                + param.getName() +
                                BREACKS_CLOSE);
                    }
                }
                docParams.append(NEW_LINE + PREFIX + PARAM_DETAILS_OFFSET + PRE_CLOSE);
                docParams.append(NEW_LINE + PREFIX);
            }
        }
        return docParams.toString();
    }

    /**
     * Generates the documentation for the list of headers given.
     */
    public static String generateHeaders(List<Header> headers) {
        StringBuilder buffer = new StringBuilder();
        for (Header header : headers) {
            if (header.isRequired() != null && header.isRequired()) {
                buffer.append(
                    NEW_LINE + PARAM + FormatUtils.toJava(header.getName()) +
                    NEW_LINE + PREFIX + PARAM_DETAILS_OFFSET + PRE_OPEN +
                    NEW_LINE + PREFIX + PARAM_DETAILS_OFFSET + header.getValue() +
                    NEW_LINE + PREFIX + PARAM_DETAILS_OFFSET + PRE_CLOSE
                );
            }
            else {
                buffer.append(
                    NEW_LINE + PARAM + FormatUtils.toJava(header.getName()) +
                    NEW_LINE + PREFIX + PARAM_DETAILS_OFFSET + PRE_OPEN +
                    NEW_LINE + PREFIX + PARAM_DETAILS_OFFSET +
                    BREACKS_OPEN + header.getValue() + BREACKS_CLOSE +
                    NEW_LINE + PREFIX + PARAM_DETAILS_OFFSET + PRE_CLOSE
                );
            }
        }
        buffer.append(NEW_LINE + PREFIX);
        return buffer.toString();
    }

    /**
     * Generates the docuemntation for the URL parameters available in the given link.
     */
    public static String generateUrlParameters(DetailedLink detailedLink) {
        StringBuffer docParams = new StringBuffer();

        // url params
        if (detailedLink.getRequest() != null && detailedLink.getRequest().isSetUrl()
                && detailedLink.getRequest().getUrl().isSetParametersSets()
                && !detailedLink.getRequest().getUrl().getParametersSets().isEmpty()) {

            if (detailedLink.getRequest().getUrl().getParametersSets().size() > 1) {
                int i = 1;
                for (ParametersSet ps : detailedLink.getRequest().getUrl().getParametersSets()) {
                    docParams.append(NEW_LINE + PREFIX + OVERLOAD + i + ": " + NEW_LINE);
                    addParameterSetDescription(docParams, ps);
                    for (Parameter param : ps.getParameters()) {
                        if (param.isRequired() != null && param.isRequired().equals(Boolean.TRUE)) {
                            docParams.append(PARAM + FormatUtils.toJava(param.getName()) +
                                    NEW_LINE + PREFIX + PARAM_DETAILS_OFFSET + PRE_OPEN +
                                    NEW_LINE + PREFIX + PARAM_DETAILS_OFFSET + param.getValue() +
                                    NEW_LINE + PREFIX + PARAM_DETAILS_OFFSET + PRE_CLOSE);
                        } else {
                            docParams.append(PARAM + FormatUtils.toJava(param.getName()) +
                                    NEW_LINE + PREFIX + PARAM_DETAILS_OFFSET + PRE_OPEN +
                                    NEW_LINE + PREFIX + PARAM_DETAILS_OFFSET +
                                    BREACKS_OPEN + param.getValue() + BREACKS_CLOSE +
                                    NEW_LINE + PREFIX + PARAM_DETAILS_OFFSET + PRE_CLOSE);
                        }
                    }
                    docParams.append(PREFIX);
                    i++;
                }
            } else if (detailedLink.getRequest().getUrl().getParametersSets().size() == 1) {
                for (Parameter param : detailedLink.getRequest().getUrl().getParametersSets().get(0).getParameters()) {
                    if (param.isRequired() != null && param.isRequired().equals(Boolean.TRUE)) {
                        docParams.append(NEW_LINE + PARAM + UrlUtils.toQueryParam(param.getName()) +
                                NEW_LINE + PREFIX + PARAM_DETAILS_OFFSET + PRE_OPEN +
                                NEW_LINE + PREFIX + PARAM_DETAILS_OFFSET + param.getValue() +
                                NEW_LINE + PREFIX + PARAM_DETAILS_OFFSET + PRE_CLOSE);
                    } else {
                        docParams.append(NEW_LINE + PARAM + UrlUtils.toQueryParam(param.getName()) +
                                NEW_LINE + PREFIX + PARAM_DETAILS_OFFSET + PRE_OPEN +
                                NEW_LINE + PREFIX + PARAM_DETAILS_OFFSET +
                                BREACKS_OPEN + param.getValue() + BREACKS_CLOSE +
                                NEW_LINE + PREFIX + PARAM_DETAILS_OFFSET + PRE_CLOSE);
                    }
                }
            }
        }

        if (docParams.length() > 0) {
            docParams.append(NEW_LINE + PREFIX);
        }

        return docParams.toString();
    }

    /**
     * Adds ParameterSet description if avaliable
     * 
     * @param docParams
     *            params to add to
     * @param ps
     *            ParametersSet to describe
     */
    private static void addParameterSetDescription(StringBuffer docParams, ParametersSet ps) {
        if (ps.isSetDescription()) {
            List<String> descriptions = StringUtils.formatLength(
                    ps.getDescription(),
                    DOC_LENGH,
                    PREFIX + PARAM_DETAILS_OFFSET + OVERLOAD_OFFSET,
                    SPACE);

            String description = StringUtils.combineWithSuffix(
                    "",
                    NEW_LINE,
                    descriptions.toArray(new String[descriptions.size()]));

            docParams.append(
                    PREFIX + NEW_LINE +
                            description +
                            NEW_LINE + PREFIX + NEW_LINE);
        }
    }

    public String generate(DetailedLink detailedLink) {
        StringBuffer docParamsBuffer = new StringBuffer();

        docParamsBuffer.append(generateBodyParams(detailedLink));
        docParamsBuffer.append(generateUrlParameters(detailedLink));

        return docParamsBuffer.toString();
    }
}
