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

package org.ovirt.engine.sdk.codegen.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Provides String related services
 */
public class StringUtils {
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
     * Removes trailing NewLine
     * 
     * @param string
     * 
     * @return string with no trailing NewLine
     */
    public static String removeTrailingNewLine(String string) {
        if (string.endsWith(FileUtils.NEW_LINE)) {
            return string.substring(0,
                    string.length() - FileUtils.NEW_LINE.length());
        }
        return string;
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
     * @param lengh
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
}
