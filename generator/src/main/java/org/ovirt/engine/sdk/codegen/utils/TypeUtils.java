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
 * Provides type related services
 */
public class TypeUtils {

    /**
     * Formats XML type to java type
     * 
     * @param type
     *            XML the type to convert
     * 
     * @return java type name
     */
    public static String toJava(String type) {
        String desieredType = type.replace("xs:", "");
        if (desieredType.equals("string")) {
            return String.class.getSimpleName();
        } else if (desieredType.equals("boolean")) {
            return Boolean.class.getSimpleName();
        } else if (desieredType.equals("int")) {
            return Integer.class.getSimpleName();
        } else if (desieredType.equals("long")) {
            return Long.class.getSimpleName();
        }
        throw new RuntimeException("Unsupported parameter type \"" + type + "\".");
    }
}
