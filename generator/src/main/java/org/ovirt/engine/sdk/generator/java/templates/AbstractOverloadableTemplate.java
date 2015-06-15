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

import java.util.List;

import org.ovirt.engine.sdk.generator.java.ParameterData;
import org.ovirt.engine.sdk.generator.java.ParameterType;
import org.ovirt.engine.sdk.generator.templates.AbstractTemplate;

/**
 * Abstract Overloadable-Template class
 */
public abstract class AbstractOverloadableTemplate extends AbstractTemplate {
    protected static final String DOC_SEPARATOR = "     *";

    /**
     * Generate the code that checks the value of URL parameters and adds it to the list of parameters to actually send
     * to the server.
     *
     * @param parameters the list of parameters to add
     */
    protected String getUrlBuilderCode(List<ParameterData> parameters) {
        StringBuilder buffer = new StringBuilder();
        for (ParameterData parameter : parameters) {
            if (parameter.getType() == ParameterType.URL) {
                UrlBuilderParameterTemplate template = new UrlBuilderParameterTemplate();
                buffer.append("\n");
                buffer.append(template.evaluate(parameter));
            }
        }
        return buffer.toString();
    }

    /**
     * Generates the code that adds to the request the given header parameters.
     *
     * @param parameters the list of header parameters to add
     */
    protected String getHeaderBuilderCode(List<ParameterData> parameters) {
        StringBuilder buffer = new StringBuilder();
        for (ParameterData parameter : parameters) {
            if (parameter.getType() == ParameterType.HEADER) {
                HeaderBuilderParameterTemplate template = new HeaderBuilderParameterTemplate();
                buffer.append("\n");
                buffer.append(template.evaluate(parameter));
            }
        }
        return buffer.toString();
    }
}
