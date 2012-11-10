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

package org.ovirt.engine.sdk.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Provides entity2entity conversion services
 */
public class ConversionHelper {

    /**
     * Converts k,v string to Map
     * 
     * @param input
     *            (format: k1:v1;k2:v2;...)
     * @return Map<String, String>
     */
    public static synchronized Map<String, String> toMap(final String input) {
        return new HashMap<String, String>() {
            private static final long serialVersionUID = -3309952775559222863L;
            {
                for (String header : input.split(";")) {
                    String[] kv = header.split(":");
                    if (kv.length == 2) {
                        put(kv[0], kv[1]);
                    }
                }
            }
        };
    }
}
