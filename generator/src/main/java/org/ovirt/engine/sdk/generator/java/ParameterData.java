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

package org.ovirt.engine.sdk.generator.java;

/**
 * This class stores data associated to a method parameter, including where it comes from (URL or HTTP header), its
 * name, and the Java type and name.
 */
public class ParameterData {
    private String name;
    private ParameterType type;
    private ParameterContext context;
    private boolean required;
    private String values;
    private String javaType;
    private String javaName;

    /**
     * Returns the name of the URL parameter or HTTP header where this parameter is included.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the URL parameter or HTTP header where this parameter is included.
     */
    public void setName(String newName) {
        name = newName;
    }

    /**
     * Returns the type of this parameter.
     */
    public ParameterType getType() {
        return type;
    }

    /**
     * Sets the type of this parameter.
     */
    public void setType(ParameterType newType) {
        type = newType;
    }

    /**
     * Returns the context (query or matrix) of this parameter.
     */
    public ParameterContext getContext() {
        return context;
    }

    /**
     * Sets the context (query or matrix) of this parameter.
     */
    public void setContext(ParameterContext newContext) {
        context = newContext;
    }

    /**
     * Returns {@code true} if this parameter is required, {@code false} otherwise.
     */
    public boolean isRequired() {
        return required;
    }

    /**
     * Sets the flag that indicates if this parameter is required.
     */
    public void setRequired(boolean newRequired) {
        required = newRequired;
    }

    /**
     * Returns the allowed values of this parameter.
     */
    public String getValues() {
        return values;
    }

    /**
     * Sets the allowed valeus of this parameter.
     */
    public void setValues(String newValues) {
        values = newValues;
    }

    /**
     * Returns the Java type of the parameter.
     */
    public String getJavaType() {
        return javaType;
    }

    /**
     * Sets the Java type of the parameter.
     */
    public void setJavaType(String newType) {
        javaType = newType;
    }

    /**
     * Returns the Java name of the parameter.
     */
    public String getJavaName() {
        return javaName;
    }

    /**
     * Sets the Java name of the parameter.
     */
    public void setJavaName(String newName) {
        javaName = newName;
    }
}
