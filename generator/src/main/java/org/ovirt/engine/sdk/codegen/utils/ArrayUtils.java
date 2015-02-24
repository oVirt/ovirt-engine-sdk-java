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
 * Provides array services
 */
public class ArrayUtils {
    /**
     * Checkes if candidate in arr
     *
     * @param arr
     *            array to look at
     * @param candidate
     *            candidate to check
     *
     * @return True if candidate in array
     */
    public static <T> boolean contains(T[] arr, T candidate) {
        for (T item : arr) {
            if (item.equals(candidate)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if an array starts with another array, similar to how the {@link String#startsWith(String)} checks
     * strings, but comparing objects instead of characters.
     *
     * @param array the array to be checked
     * @param prefix the prefix to look for
     */
    public static <T> boolean startsWith(T[] array, T[] prefix) {
        if (array.length < prefix.length) {
            return false;
        }
        for (int i = 0; i < prefix.length; i++) {
            if (!array[i].equals(prefix[i])) {
                return false;
            }
        }
        return true;
    }
}
