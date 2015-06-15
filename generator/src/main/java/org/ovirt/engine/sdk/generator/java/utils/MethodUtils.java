/*
Copyright (c) 2012 Red Hat, Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package org.ovirt.engine.sdk.generator.java.utils;

import org.ovirt.engine.sdk.generator.Memory;
import org.ovirt.engine.sdk.generator.java.ParameterData;

import java.util.ArrayList;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import static org.ovirt.engine.sdk.generator.java.utils.ExceptionsAwareComparator.exceptions;

/**
 * This class contains a collection of methods useful when working with generated methods.
 */
public class MethodUtils {
    /**
     * Generates the Java code for a method parameter declaration.
     *
     * @param parameter the parameter data
     * @return the Java code for the method parameter declaration
     */
    public static String formatParameter(ParameterData parameter) {
        return parameter.getJavaType() + " " + parameter.getJavaName();
    }

    /**
     * Generates the Java code for a list of method parameter declarations.
     *
     * @param parameters the data of the parameters
     * @return the Java code for the list of method parameter declarations
     */
    public static String formatParameters(List<ParameterData> parameters) {
        return parameters.stream().map(MethodUtils::formatParameter).collect(joining(", "));
    }

    /**
     * Given a list of parameter declarations reorder it so that new parameters are at the end of the list.
     *
     * @param className the name of the class
     * @param methodName the name of the method
     * @param parameters the parameter declarations
     */
    public static List<ParameterData> reorderParameters(
            String className,
            String methodName,
            List<ParameterData> parameters) {
        // Get the names of old parameters, as they were in the previous version of the SDK:
        Memory memory = Memory.getInstance();
        String key = className + "." + methodName + ".parameters";
        List<String> oldOrder = memory.getList(key);

        // Reorder the list using the old list of parameters as exceptions, so that old parameters are always at the
        // beginning and new parameters at the end:
        List<ParameterData> result = new ArrayList<>(parameters);
        result.sort(comparing(ParameterData::getJavaName, exceptions(String::compareTo, oldOrder)));

        // Save the new list of parameter names to the memory, for use in when generating the next version of
        // the SDK:
        List<String> newOrder = result.stream().map(ParameterData::getJavaName).collect(toList());
        memory.putList(key, newOrder);

        return result;
    }
}
