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

import org.ovirt.engine.sdk.generator.Location;
import org.ovirt.engine.sdk.generator.java.ParameterData;
import org.ovirt.engine.sdk.generator.java.documentation.DocsGen;
import org.ovirt.engine.sdk.generator.java.utils.LinkUtils;
import org.ovirt.engine.sdk.generator.java.utils.MethodUtils;
import org.ovirt.engine.sdk.generator.utils.Tree;
import org.ovirt.engine.sdk.entities.DetailedLink;

public class DeleteMethodTemplate extends AbstractOverloadableTemplate {
    private String evaluate(List<ParameterData> parameters) {
        // Generate the code that populates the list of URL parameters to send tot the server:
        String urlBuilderCode = getUrlBuilderCode(parameters);
        String headerBuilderCode = getHeaderBuilderCode(parameters);

        // Generate the method:
        set("docParams", DocsGen.generateParameters(parameters));
        set("paramList", MethodUtils.formatParameters(parameters));
        set("headersToBuild", headerBuilderCode);
        set("urlParamsToBuild", urlBuilderCode);

        return evaluate();
    }

    public String evaluate(String className, Tree<Location> entityTree, DetailedLink dl) {
        StringBuilder buffer = new StringBuilder();

        if (dl.isSetRequest() && dl.getRequest().isSetBody() && dl.getRequest().getBody().isSetType() && !
                dl.getRequest().getBody().getType().equals("") && dl.getRequest().getBody().isRequired() != null
                && dl.getRequest().getBody().isRequired().equals(Boolean.TRUE)) {
            // add delete() with body overload (body is mandatory)
            buffer.append(new DeleteMethodWithBodyTemplate().evaluate(className, dl));
        }
        else {
            // Get the list of parameters:
            List<ParameterData> parameters = LinkUtils.getParameters(dl);

            // Reorder the parameters declarations for backwards compatibility:
            parameters = MethodUtils.reorderParameters(className, "delete", parameters);

            // Generate a version of the method for each prefix of the list of parameter declarations, including the
            // empty prefix and the complete list:
            for (int i = 0; i <= parameters.size(); i++) {
                List<ParameterData> prefix = parameters.subList(0, i);
                buffer.append(evaluate(prefix));
            }

            // add delete() with body overload (body is optional)
            if (dl.isSetRequest() && dl.getRequest().isSetBody() && dl.getRequest().getBody().isSetType()
                    && !dl.getRequest().getBody().getType().equals("")
                    && ((dl.getRequest().getBody().isRequired() != null
                    && !dl.getRequest().getBody().isRequired().equals(Boolean.TRUE))
                    ||
                    dl.getRequest().getBody().isRequired() == null)) {
                buffer.append(new DeleteMethodWithBodyTemplate().evaluate(className, dl));
            }
        }

        return buffer.toString();
    }
}
