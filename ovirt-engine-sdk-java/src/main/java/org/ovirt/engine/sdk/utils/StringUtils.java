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

import java.nio.charset.Charset;

public class StringUtils {
    /**
     * Reference to the UTF-8 charset used to avoid looking it up every time it is needed.
     */
    public static final Charset UTF8 = Charset.forName("UTF-8");

    /**
     * Removes trailing and leading brackets from the string
     * 
     * @param txt
     *            input string
     * 
     * @return string
     */
    public static String removeBrackets(String txt) {
        if (txt != null && txt.length() >= 1 && txt.startsWith("[") && txt.endsWith("]")) {
            return txt.substring(1, txt.length() - 1);
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
        if (candidate.length() >= 1)
            return Character.toUpperCase(candidate.charAt(0)) + candidate.substring(1);
        return candidate;
    }

    /**
     * Wraps to LowerCase first char in candidate
     * 
     * @param candidate
     * 
     * @return candidate
     */
    public static String toLowerCase(String candidate) {
        if (candidate.length() >= 1)
            return Character.toLowerCase(candidate.charAt(0)) + candidate.substring(1);
        return candidate;
    }

    /**
     * Converts string to singular form
     * 
     * @param candidate
     * 
     * @return singular string
     */
    public static String toSingular(String candidate) {
        if (candidate.length() >= 1 && candidate.endsWith("s")) {
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
        if (candidate.length() >= 1 && !candidate.endsWith("s")) {
            return candidate + "s";
        }
        return candidate;
    }

    /**
     * Right trim
     * 
     * @param str
     * 
     * @return trimmed string
     */
    public static String trimRight(String str) {
        if (str == null)
            return null;

        char[] originalArray = str.toCharArray();
        char[] newArray = new char[1];
        int pos = 0;

        for (int i = 0; i < originalArray.length; i++) {
            pos = (originalArray.length - 1) - i;
            if (originalArray[pos] != ' ') {
                newArray = new char[pos + 1];
                System.arraycopy(originalArray, 0, newArray, 0, pos + 1);
                break;
            }

        }

        return new String(newArray);
    }

    /**
     * Checks if string is null or empty
     * 
     * @param string
     * 
     * @return if string is null or empty true else false
     */
    public static boolean isNulOrEmpty(String string) {
        return isNull(string) || string.isEmpty();
    }

    /**
     * Checks if string is null
     * 
     * @param string
     * 
     * @return if string is null true else false
     */
    public static boolean isNull(String string) {
        return string == null;
    }
}
