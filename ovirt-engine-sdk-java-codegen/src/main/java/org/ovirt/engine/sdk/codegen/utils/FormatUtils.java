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

/**
 * Provides format related services
 */
public class FormatUtils {

    /**
     * Converts string to Java naming convention
     * 
     * @param string
     *            string to convert
     * 
     * @return converted string
     */
    public static String toJava(String string) {

        StringBuffer newName = new StringBuffer();
        String[] DELIMITERS = new String[] { "_", "-" };
        String[] periods;

        for (String delimiter : DELIMITERS) {
            periods = string.split(delimiter);
            if (periods != null && periods.length > 1) {
                combinePeriods(periods, newName);
            }
        }

        return StringUtils.toLowerCase(newName.length() > 0 ? newName.toString() : string);
    }

    /**
     * Combines given periods to the Java formated string
     * 
     * @param periods
     *            periods to combine
     * @param newString
     *            new string to append to
     */
    private static void combinePeriods(String[] periods, StringBuffer newString) {
        if (periods.length > 0) {
            newString.append(periods[0]);
            for (int i = 1; i < periods.length; i++) {
                newString.append(StringUtils.toUpperCase(periods[i]));
            }
        }
    }
}
