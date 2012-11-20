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

public class StringUtils {
    /**
     * Removes trailing and leading brackets from the string
     * 
     * @param txt
     *            input string
     * 
     * @return string
     */
    public static String removeBrackets(String txt) {
        if (txt != null & txt.startsWith("[") && txt.endsWith("]")) {
            return txt.substring(1, txt.length() - 2);
        }
        return txt;
    }

    /**
     * Wraps to UpperCase first char in candidate
     * 
     * @param candidate
     * 
     * @return candidate
     */
    public static String toUpperCase(String candidate) {
        return Character.toUpperCase(candidate.charAt(0)) + candidate.substring(1);
    }

    /**
     * Converts string to singular form
     * 
     * @param candidate
     * 
     * @return singular string
     */
    public static String toSingular(String candidate) {
        if (candidate.endsWith("s")) {
            return candidate.substring(0, candidate.length() - 1);
        }
        return candidate;
    }

    /**
     * Converts string to plural form
     * 
     * @param candidate
     * 
     * @return plural string
     */
    public static String toPlural(String candidate) {
        if (!candidate.endsWith("s")) {
            return candidate + "s";
        }
        return candidate;
    }
}
