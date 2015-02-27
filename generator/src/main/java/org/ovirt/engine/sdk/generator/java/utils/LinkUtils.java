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
     * Get the list of URL parameters that are available in the given link.
     */
    public static List<Parameter> getUrlParameters(DetailedLink dl) {
        List<Parameter> result = new ArrayList<>();
        if (dl.isSetRequest() && dl.getRequest().isSetUrl() &&
            dl.getRequest().getUrl().isSetParametersSets() &&
            !dl.getRequest().getUrl().getParametersSets().isEmpty()) {
            for (ParametersSet parametersSet : dl.getRequest().getUrl().getParametersSets()) {
                result.addAll(parametersSet.getParameters());
            }
        }
        return result;
    }

    /**
     * Get the list of headers available in the given link, filtering out the ones that should be ignored.
     */
    public static List<Header> getHeaders(DetailedLink dl) {
        List<Header> result = new ArrayList<>();
        Request request = dl.getRequest();
        if (request != null) {
            Headers headers = request.getHeaders();
            if (headers != null) {
                for (Header header : headers.getHeaders()) {
                    if (!HEADERS_EXCEPTIONS.contains(header.getName())) {
                        result.add(header);
                    }
                }
            }
        }
        return result;
    }
}
