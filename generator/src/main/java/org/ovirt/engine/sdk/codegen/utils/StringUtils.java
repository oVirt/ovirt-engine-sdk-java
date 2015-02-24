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

package org.ovirt.engine.sdk.codegen.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Provides String related services
 */
public class StringUtils {
    /**
     * The rules for forming plurals are not as simple as adding an {@code s} to the end, so we should implement them
     * correctly or have a table of exceptions. For simplicity, we are using a table.
     */
    private static Map<String, String> SINGULAR_EXCEPTIONS = new HashMap<>();
    private static Map<String, String> PLURAL_EXCEPTIONS = new HashMap<>();

    static {
        SINGULAR_EXCEPTIONS.put("SchedulingPolicies", "SchedulingPolicy");
        for (Map.Entry<String, String> exception : SINGULAR_EXCEPTIONS.entrySet()) {
            PLURAL_EXCEPTIONS.put(exception.getValue(), exception.getKey());
        }
    }

    /**
     * Determinates if given string is in plural form
     * 
     * @param candidate
     *            candidate to check
     * 
     * @return boolean
     */
    public static boolean isPlural(String candidate) {
        return candidate.endsWith("s");
    }

    /**
     * Determinates if given string is in singular form
     * 
     * @param candidate
     *            candidate to check
     * 
     * @return boolean
     */
    public static boolean isSingular(String candidate) {
        return !StringUtils.isPlural(candidate);
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
     * Removes leading string
     * 
     * @param string
     *            string to process
     * @param string
     *            leading string to remove
     * 
     * @return string with no leadingString
     */
    public static String removeLeadingString(String string, String leadingString) {
        if (string != null && leadingString != null) {
            if (string.startsWith(leadingString)) {
                if (string.length() > leadingString.length()) {
                    string = string.substring(leadingString.length());
                } else {
                    string = new String("");
                }
            }
        }
        return string;
    }

    /**
     * Combines strings
     * 
     * @param source
     *            source to combine to
     * @param strings
     *            strings to combine
     * @return
     */
    public static String combine(String source, String... strings) {
        StringBuffer buffer = new StringBuffer(source);
        if (strings != null) {
            for (String str : strings) {
                buffer.append(str);
            }
        }
        return buffer.toString();
    }

    /**
     * Combines strings appending suffix
     * 
     * @param source
     *            source to combine to
     * @param suffix
     *            suffix to add to every line (except last one)
     * @param strings
     *            strings to combine
     * @return
     */
    public static String combineWithSuffix(String source, String suffix, String... strings) {
        StringBuffer buffer = new StringBuffer(source);
        if (strings != null) {
            for (String str : strings) {
                buffer.append(str);
                buffer.append(suffix);
            }
        }
        String result = buffer.toString();
        return result.substring(0, result.lastIndexOf(suffix));
    }

    /**
     * Cuts the given string in to the List of strings according to the defined string length
     * 
     * @param str
     *            string to format
     * @param length
     *            max string length
     * @param linePrefix
     *            new string prefix
     * @param splitBy
     *            the string to split by
     * 
     * @return List of strings
     */
    public static List<String> formatLength(String str, int length, String linePrefix, String splitBy) {
        List<String> strings = new ArrayList<String>();

        if (str.length() > length) {
            String[] portions = str.split(" ");
            String newString = "";
            for (int i = 0; i < portions.length; i++) {
                if ((linePrefix + newString + portions[i]).length() <= length) {
                    newString += (portions[i] + splitBy);
                    if (i + 1 == portions.length) {
                        strings.add(linePrefix +
                                newString.substring(0, newString.lastIndexOf(splitBy)));
                    }
                } else {
                    strings.add(linePrefix +
                            newString.substring(0, newString.lastIndexOf(splitBy)));
                    newString = portions[i] + splitBy;
                    if (i + 1 == portions.length) {
                        strings.add(linePrefix +
                                newString.substring(0, newString.lastIndexOf(splitBy)));
                    }
                }
            }
        } else {
            strings.add(linePrefix + str);
        }

        return strings;
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
     * @return singular string
     */
    public static String toSingular(String plural) {
        String singular = SINGULAR_EXCEPTIONS.get(plural);
        if (singular == null) {
            if (plural.length() >= 1 && plural.endsWith("s")) {
                singular = plural.substring(0, plural.length() - 1);
            }
            else {
                singular = plural;
            }
        }
        return singular;
    }

    /**
     * Converts string to plural form
     *
     * @return plural string
     */
    public static String toPlural(String singular) {
        String plural = PLURAL_EXCEPTIONS.get(singular);
        if (plural == null) {
            if (singular.length() >= 1 && !singular.endsWith("s")) {
                plural = singular + "s";
            }
            else {
                plural = singular;
            }
        }
        return plural;
    }

    /**
     * Formats a collection of objects separating their string representation with the given separator.
     */
    public static String formatList(Collection<?> collection, String separator) {
        StringBuilder buffer = new StringBuilder();
        boolean first = true;
        for (Object item : collection) {
            if (!first) {
                buffer.append(separator);
            }
            buffer.append(item);
            first = false;
        }
        return buffer.toString();
    }

    /**
     * Remove trailing whitespace from the given lines. The result will be a new list, the one passed as parameter
     * won't be modified.
     *
     * @param lines the lines to be processed
     * @return a new list containing the result of removing trailing whitespace from the given lines
     */
    public static List<String> removeTrailingWhitespace(List<String> lines) {
        if (lines == null) {
            return null;
        }
        List<String> result = new ArrayList<>(lines);
        for (int i = 0; i < result.size(); i++) {
            String line = result.get(i);
            if (line != null) {
                line = line.replaceAll("\\s+$", "");
                result.set(i, line);
            }
        }
        return result;
    }
}
