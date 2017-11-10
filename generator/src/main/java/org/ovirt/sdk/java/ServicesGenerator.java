/*
Copyright (c) 2016 Red Hat, Inc.

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

package org.ovirt.sdk.java;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

import org.ovirt.api.metamodel.concepts.ListType;
import org.ovirt.api.metamodel.concepts.Locator;
import org.ovirt.api.metamodel.concepts.Method;
import org.ovirt.api.metamodel.concepts.Model;
import org.ovirt.api.metamodel.concepts.Name;
import org.ovirt.api.metamodel.concepts.Parameter;
import org.ovirt.api.metamodel.concepts.PrimitiveType;
import org.ovirt.api.metamodel.concepts.Service;
import org.ovirt.api.metamodel.concepts.StructType;
import org.ovirt.api.metamodel.concepts.Type;
import org.ovirt.api.metamodel.tool.JavaClassBuffer;
import org.ovirt.api.metamodel.tool.JavaClassName;
import org.ovirt.api.metamodel.tool.JavaGenerator;
import org.ovirt.api.metamodel.tool.JavaNames;
import org.ovirt.api.metamodel.tool.JavaTypeReference;
import org.ovirt.api.metamodel.tool.JavaTypes;
import org.ovirt.api.metamodel.tool.Names;

/**
 * This class is responsible for generating the classes that represent the services of the model.
 */
public class ServicesGenerator extends JavaGenerator {
    // The base package:
    private String BASE_PACKAGE = "org.ovirt.engine.sdk4";

    // Reference to the objects used to generate the code:
    @Inject private Names names;
    @Inject private JavaNames javaNames;
    @Inject private JavaTypes javaTypes;

    public void generate(Model model) {
        model.services().forEach(this::generateServiceInterface);
    }

    private void generateServiceInterface(Service service) {
        // Prepare the javaBuffer:
        javaBuffer = new JavaClassBuffer();
        JavaClassName serviceName = getServiceName(service);
        javaBuffer.setClassName(serviceName);

        // Generate the code:
        generateServiceInterfaceSource(service);

        // Write the file:
        try {
            javaBuffer.write(outDir);
        }
        catch (IOException exception) {
            throw new IllegalStateException("Error writing service interface", exception);
        }
    }

    private void generateServiceInterfaceSource(Service service) {
        // Generate imports for the base classes:
        javaBuffer.addImport(BASE_PACKAGE, "Request");
        javaBuffer.addImport(BASE_PACKAGE, "Response");
        javaBuffer.addImport(BASE_PACKAGE, "Service");
        javaBuffer.addImport(IOException.class);

        // Add service documentation:
        generateDoc(service);

        // Begin class:
        JavaClassName serviceName = getServiceName(service);
        Service base = service.getBase();
        String baseName = "Service";
        if (base != null) {
            baseName = getServiceName(base).getSimpleName();
        }
        javaBuffer.addLine("public interface %1$s extends %2$s {", serviceName.getSimpleName(), baseName);

        // Generate the code for the methods:
        service.declaredMethods()
            .sorted()
            .forEach(this::generateMethodInterface);

        // Generate the code for the locators:
        service.declaredLocators()
            .sorted()
            .forEach(this::generateLocator);
        generatePathLocator();

        // End class:
        javaBuffer.addLine("}");
        javaBuffer.addLine();
    }

    private void generateMethodInterface(Method method) {
        Name name = getFullName(method);

        // Generate the request and response interfaces:
        generateRequestInterface(method);
        generateResponseInterface(method);

        // Add method documentation:
        generateDoc(method);

        // Generate the method:
        String request = getRequestName(method);
        String member = javaNames.getJavaMemberStyleName(name);
        javaBuffer.addLine("%1$s %2$s();", request, member);
        javaBuffer.addLine();
    }

    private void generateRequestInterface(Method method) {
        // Add method documentation:
        generateDoc(method);

        // Begin interface:
        String request = getRequestName(method);
        String response = getResponseName(method);
        javaBuffer.addLine("public interface %1$s extends Request<%1$s, %2$s> {", request, response);

        // Generate the methods to set input parameters:
        method.parameters()
            .filter(Parameter::isIn)
            .sorted()
            .forEach(this::generateRequestParameterInterface);

        // End interface:
        javaBuffer.addLine("}");
        javaBuffer.addLine();
    }

    private void generateRequestParameterInterface(Parameter parameter) {
        // Add parameter declaration:
        Method method = parameter.getDeclaringMethod();
        Type type = parameter.getType();
        Name name = parameter.getName();
        String member = javaNames.getJavaMemberStyleName(name);
        String request = getRequestName(method);
        if (type instanceof PrimitiveType) {
            generateDoc(parameter);
            Model model = type.getModel();
            if (type == model.getBooleanType()) {
                javaBuffer.addLine("%1s %2$s(Boolean %2$s);", request, member);
            }
            else if (type == model.getStringType()) {
                javaBuffer.addLine("%1s %2$s(String %2$s);", request, member);
            }
            else if (type == model.getIntegerType()) {
                javaBuffer.addImport(BigInteger.class);
                javaBuffer.addLine("%1s %2$s(Integer %2$s);", request, member);
                generateDoc(parameter);
                javaBuffer.addLine("%1s %2$s(Long %2$s);", request, member);
                generateDoc(parameter);
                javaBuffer.addLine("%1s %2$s(BigInteger %2$s);", request, member);
            }
            else if (type == model.getDecimalType()) {
                javaBuffer.addImport(BigDecimal.class);
                javaBuffer.addLine("%1s %2$s(Float %2$s);", request, member);
                generateDoc(parameter);
                javaBuffer.addLine("%1s %2$s(Double %2$s);", request, member);
                generateDoc(parameter);
                javaBuffer.addLine("%1s %2$s(BigDecimal %2$s);", request, member);
            }
            else if (type == model.getDateType()) {
                javaBuffer.addImport(Date.class);
                javaBuffer.addLine("%1s %2$s(Date %2$s);", request, member);
            }
        }
        else if (type instanceof StructType) {
            // Method taking an object:
            JavaClassName typeName = javaTypes.getInterfaceName(type);
            javaBuffer.addImport(typeName);
            javaBuffer.addLine("%1s %2$s(%3$s %2$s);", request, member, typeName.getSimpleName());

            // Method taking a builder:
            generateDoc(parameter);
            JavaClassName builderName = javaTypes.getBuilderName(type);
            javaBuffer.addImport(builderName);
            javaBuffer.addLine("%1s %2$s(%3$s %2$s);", request, member, builderName.getSimpleName());
        }
        else if (type instanceof ListType) {
            ListType listType = (ListType) type;
            Type elementType = listType.getElementType();

            // Method taking a list of objects:
            JavaClassName elementName = javaTypes.getInterfaceName(elementType);
            javaBuffer.addImport(elementName);
            javaBuffer.addImport(List.class);
            javaBuffer.addLine("%1s %2$s(List<%3$s> %2$s);", request, member, elementName.getSimpleName());

            // Method taking an array of objects:
            generateDoc(parameter);
            javaBuffer.addImport(elementName);
            javaBuffer.addLine("%1s %2$s(%3$s... %2$s);", request, member, elementName.getSimpleName());

            // Method taking an array of builders:
            generateDoc(parameter);
            JavaClassName builderName = javaTypes.getBuilderName(elementType);
            javaBuffer.addImport(builderName);
            javaBuffer.addLine("%1s %2$s(%3$s... %2$s);", request, member, builderName.getSimpleName());
        }
    }

    private void generateResponseInterface(Method method) {
        // Add method documentation:
        generateDoc(method);

        // Begin interface:
        String response = getResponseName(method);
        javaBuffer.addLine("public interface %1$s extends Response {", response);

        // Generate the methods to get the output parameters:
        method.parameters()
            .filter(Parameter::isOut)
            .sorted()
            .forEach(this::generateResponseParameterInterface);

        // End interface:
        javaBuffer.addLine("}");
        javaBuffer.addLine();
    }

    private void generateResponseParameterInterface(Parameter parameter) {
        // Add parameter documentation:
        generateDoc(parameter);

        // Add parameter declaration:
        Type type = parameter.getType();
        Name name = parameter.getName();
        String property = javaNames.getJavaMemberStyleName(name);
        JavaTypeReference reference = javaTypes.getTypeReference(type, true);
        javaBuffer.addImports(reference.getImports());
        javaBuffer.addLine("%1$s %2$s();", reference.getText(), property);
    }

    private void generateLocator(Locator locator) {
        // Add locator documentation:
        generateDoc(locator);

        // Add locator declaration:
        Name name = locator.getName();
        Service service = locator.getService();

        JavaClassName serviceName = getServiceName(service);
        javaBuffer.addImport(serviceName);
        String locatorName = javaNames.getJavaMemberStyleName(name);
        if (locator.getParameters().isEmpty()) {
            javaBuffer.addLine("%1$s %2$sService();", serviceName.getSimpleName(), locatorName);
        }
        else {
            javaBuffer.addLine("%1$s %2$sService(String id);", serviceName.getSimpleName(), locatorName);
        }
    }

    private void generatePathLocator() {
        javaBuffer.addImport(BASE_PACKAGE + ".Service");
        javaBuffer.addDocComment("Service locator method, returns individual service on which the URI is dispatched.");
        javaBuffer.addLine("Service service(String path);");
    }

    private JavaClassName getServiceName(Service service) {
        JavaClassName serviceName = new JavaClassName();
        serviceName.setPackageName(BASE_PACKAGE + ".services");
        serviceName.setSimpleName(javaNames.getJavaClassStyleName(service.getName()) + "Service");
        return serviceName;
    }

    private String getRequestName(Method method) {
        return javaNames.getJavaClassStyleName(getFullName(method)) + "Request";
    }

    private String getResponseName(Method method) {
        return javaNames.getJavaClassStyleName(getFullName(method)) + "Response";
    }

    /**
     * Calculates the full name of a method, taking into account that the method may extend other method. For this kind
     * of methods the full name wil be the name of the base, followed by the name of the method. For example, if the
     * name of the base is {@code Add} and the name of the method is {@code FromSnapsot} then the full method name will
     * be {@code AddFromSnapshot}.
     */
    private Name getFullName(Method method) {
        Method base = method.getBase();
        if (base == null) {
            return method.getName();
        }
        return names.concatenate(getFullName(base), method.getName());
    }
}
