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

package org.ovirt.engine.sdk.codegen.documentation;

import org.ovirt.engine.sdk.entities.DetailedLink;
import org.ovirt.engine.sdk.entities.Parameter;
import org.ovirt.engine.sdk.entities.ParametersSet;

/**
 * Provides documentation related codegen capabilities
 */
public class DocsGen {

    private static final String SPACE = " ";
    private static final String BREACKS_OPEN = "[";
    private static final String BREACKS_CLOSE = "]";
    private static final String NEW_LINE = "\n";
    private static final String PRE_CLOSE = " </pre>";
    private static final String PRE_OPEN = " <pre>";
    private static final String OVERLOAD = " Overload ";
    private static final String PREFIX = "     *";
    private static final String PARAM = PREFIX + " @param ";

    /**
     * Generate doc string from DetailedLink params
     * 
     * @param detailedLink
     * 
     * @return doc string
     */
    public static String generate(DetailedLink detailedLink) {
        String offset = "    ";
        StringBuffer docParams = new StringBuffer();
        docParams.append(PREFIX);

        if (detailedLink.getRequest() != null && detailedLink.getRequest().getBody() != null) {
            docParams.append(NEW_LINE + PARAM + detailedLink.getRequest().getBody()
                    .getType().toLowerCase() + NEW_LINE + PREFIX);
            if (detailedLink.getRequest().getBody().getParametersSets().size() > 1) {
                docParams.append(NEW_LINE + PREFIX + PRE_OPEN);
                int i = 1;
                for (ParametersSet ps : detailedLink.getRequest().getBody().getParametersSets()) {
                    docParams.append(NEW_LINE + PREFIX + OVERLOAD + i + ": " + NEW_LINE);
                    for (Parameter param : ps.getParameters()) {
                        if (param.isRequired() != null && param.isRequired().equals(Boolean.TRUE)) {
                            docParams.append(PREFIX + offset + param.getName() + NEW_LINE);
                        } else {
                            docParams.append(PREFIX + offset + BREACKS_OPEN + param.getName() +
                                    BREACKS_CLOSE + NEW_LINE);
                        }
                    }
                    docParams.append(PREFIX);
                    i++;
                }
                docParams.append(PRE_CLOSE + NEW_LINE + PREFIX);
            } else {
                if (detailedLink.getRequest().getBody().getParametersSets().size() == 1) {
                    docParams.append(NEW_LINE + PREFIX + PRE_OPEN);
                    for (Parameter param : detailedLink.getRequest()
                            .getBody().getParametersSets().get(0).getParameters()) {
                        if (param.isRequired() != null && param.isRequired().equals(Boolean.TRUE)) {
                            docParams.append(NEW_LINE + PREFIX + SPACE + param.getName());
                        } else {
                            docParams.append(NEW_LINE + PREFIX + SPACE + BREACKS_OPEN + param.getName() +
                                    BREACKS_CLOSE);
                        }
                    }
                    docParams.append(NEW_LINE + PREFIX + PRE_CLOSE);
                    docParams.append(NEW_LINE + PREFIX);
                }
            }
        }
        return docParams.toString();
    }

    /**
     * Appends URL and Http headers docs
     * 
     * @param docParams
     *            documentation to append to
     * @param dl
     *            detailed link
     * 
     * @return doc string
     */
    public static String appendHttpDocs(String docParams, DetailedLink dl) {
        StringBuffer docParamsBuffer = new StringBuffer(docParams);
        // TODO Auto-generated method stub
        return docParamsBuffer.toString();
    }

}
