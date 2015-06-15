//
// Copyright (c) 2015 Red Hat, Inc.
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

import java.util.Comparator;
import java.util.List;

/**
 * This class is a comparator that takes into account exceptional ordering. For example, lets say that we need to sort
 * a list of strings but we need to make sure that the strings {@code mary} and {@code joe} are always the first
 * elements of the list, and they appear exactly in that order. To do so we could use this comparator as follows:
 *
 * <pre>
 * List<String> names = ...;
 * List<String> exceptions = Arrays.asList("mary", "joe");
 * names.sort(new ExceptionsComparator<>(Person::getJavaName, String::compareTo, exceptions);
 * </pre>
 *
 * @param <T> the type of the objects to compare
 */
public class ExceptionsAwareComparator<T> implements Comparator<T> {
    /**
     * The comparator used to compare normal (non exceptional) objects.
     */
    private Comparator<? super T> normal;

    /**
     * The list of objects whose order must be preserved.
     */
    private List<? super T> exceptions;

    /**
     * Creates a new comparator that supports exceptions.
     *
     * @param normal the normal comparator to use for objects that aren't exceptions
     * @param exceptions the exceptions that will always be put at the very beginning of the result
     */
    public ExceptionsAwareComparator(Comparator<? super T> normal, List<? super T> exceptions) {
        this.normal = normal;
        this.exceptions = exceptions;
    }

    @Override
    public int compare(T left, T right) {
        // Check if the objects to compare are exceptions:
        int leftIndex = exceptions.indexOf(left);
        int rightIndex = exceptions.indexOf(right);

        // If both keys are exceptions then sort them according to their index in the exceptions list:
        if (leftIndex != -1 && rightIndex != -1) {
            return Integer.compare(leftIndex, rightIndex);
        }

        // If no key is an exception then just compare them as usual:
        if (leftIndex == -1 && rightIndex == -1) {
            return normal.compare(left, right);
        }

        // If one key is an exception and the other isn't, then the one that is an exception should always go first:
        if (leftIndex != -1) {
            return -1;
        }
        if (rightIndex != -1) {
            return 1;
        }
        return 0;
    }

    /**
     * This is a convenience method to avoid using directly the constructor, so that the resulting code looks more
     * 8-ish.
     *
     * @param normal the normal comparator to use for objects that aren't exceptions
     * @param exceptions the exceptions that will always be put at the very beginning of the result
     * @param <T> the type of the objects to compare
     * @return a comparator that takes into account the given exceptions
     */
    public static <T> Comparator<T> exceptions(Comparator<? super T> normal, List<? super T> exceptions) {
        return new ExceptionsAwareComparator<T>(normal ,exceptions);
    }
}
