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

import java.util.Arrays;

/**
 * Provides array services
 */
public class ArrayUtils {
    /**
     * Concats two arrays in to one
     * 
     * @param first
     *            array
     * @param second
     *            array
     * 
     * @return unified array
     */
    public static <T> T[] concat(T[] first, T[] second) {
        T[] result = Arrays.copyOf(first, first.length + second.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        return result;
    }

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
}
