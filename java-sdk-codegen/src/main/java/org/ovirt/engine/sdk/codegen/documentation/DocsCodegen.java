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
public class DocsCodegen {

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
        String offset = "   ";
        StringBuffer docParams = new StringBuffer();
        docParams.append(PREFIX);

        if (detailedLink.getRequest() != null && detailedLink.getRequest().getBody() != null) {
            docParams.append("\n" + PARAM + detailedLink.getRequest().getBody().getType() + "\n" + PREFIX);
            if (detailedLink.getRequest().getBody().getParametersSets().size() > 1) {
                int i = 1;
                for (ParametersSet ps : detailedLink.getRequest().getBody().getParametersSets()) {
                    docParams.append("\n" + PREFIX + OVERLOAD + i + ": \n");
                    for (Parameter param : ps.getParameters()) {
                        docParams.append(PREFIX + offset + param.getName() + "\n");
                    }
                    docParams.append(PREFIX);
                    i++;
                }
            } else {
                if (detailedLink.getRequest().getBody().getParametersSets().size() == 1) {
                    for (Parameter param : detailedLink.getRequest()
                            .getBody().getParametersSets().get(0).getParameters()) {
                        docParams.append("\n" + PREFIX + " " + param.getName());
                    }
                    docParams.append("\n" + PREFIX);
                }
            }
        }

        return docParams.toString();
    }
}
