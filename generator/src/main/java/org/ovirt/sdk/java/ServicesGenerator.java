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

/**
 * This class is responsible for generating the classes that represent the services of the model.
 */
public class ServicesGenerator extends JavaGenerator {
    // The base package:
    private String BASE_PACKAGE = "org.ovirt.engine.sdk4";

    // Reference to the objects used to generate the code:
    @Inject private JavaNames javaNames;
    @Inject private JavaTypes javaTypes;

    // The buffer used to generate the code:
    private JavaClassBuffer buffer;

    public void generate(Model model) {
        model.services().forEach(this::generateServiceInterface);
    }

    private void generateServiceInterface(Service service) {
        // Prepare the buffer:
        buffer = new JavaClassBuffer();
        JavaClassName serviceName = getServiceName(service);
        buffer.setClassName(serviceName);

        // Generate the code:
        generateServiceInterfaceSource(service);

        // Write the file:
        try {
            buffer.write(outDir);
        }
        catch (IOException exception) {
            throw new IllegalStateException("Error writing service interface", exception);
        }
    }

    private void generateServiceInterfaceSource(Service service) {
        // Generate imports for the base classes:
        buffer.addImport(BASE_PACKAGE, "Request");
        buffer.addImport(BASE_PACKAGE, "Response");
        buffer.addImport(BASE_PACKAGE, "Service");
        buffer.addImport(IOException.class);

        // Begin class:
        JavaClassName serviceName = getServiceName(service);
        buffer.addLine("public interface %1$s extends Service {", serviceName.getSimpleName());

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
        buffer.addLine("}");
        buffer.addLine();
    }

    private void generateMethodInterface(Method method) {
        Name name = method.getName();

        // Generate the request and response interfaces:
        generateRequestInterface(method);
        generateResponseInterface(method);

        // Generate the method:
        String request = getRequestName(method);
        String member = javaNames.getJavaMemberStyleName(name);
        buffer.addLine("%1$s %2$s();", request, member);
        buffer.addLine();
    }

    private void generateRequestInterface(Method method) {
        // Begin interface:
        String request = getRequestName(method);
        String response = getResponseName(method);
        buffer.addLine("public interface %1$s extends Request<%1$s, %2$s> {", request, response);

        // Generate the methods to set input parameters:
        method.parameters()
            .filter(Parameter::isIn)
            .sorted()
            .forEach(this::generateRequestParameterInterface);

        // End interface:
        buffer.addLine("}");
        buffer.addLine();
    }

    private void generateRequestParameterInterface(Parameter parameter) {
        Method method = parameter.getDeclaringMethod();
        Type type = parameter.getType();
        Name name = parameter.getName();
        String member = javaNames.getJavaMemberStyleName(name);
        String request = getRequestName(method);
        if (type instanceof PrimitiveType) {
            Model model = type.getModel();
            if (type == model.getBooleanType()) {
                buffer.addLine("%1s %2$s(Boolean %2$s);", request, member);
            }
            else if (type == model.getStringType()) {
                buffer.addLine("%1s %2$s(String %2$s);", request, member);
            }
            else if (type == model.getIntegerType()) {
                buffer.addImport(BigInteger.class);
                buffer.addLine("%1s %2$s(Integer %2$s);", request, member);
                buffer.addLine("%1s %2$s(Long %2$s);", request, member);
                buffer.addLine("%1s %2$s(BigInteger %2$s);", request, member);
            }
            else if (type == model.getDecimalType()) {
                buffer.addImport(BigDecimal.class);
                buffer.addLine("%1s %2$s(Float %2$s);", request, member);
                buffer.addLine("%1s %2$s(Double %2$s);", request, member);
                buffer.addLine("%1s %2$s(BigDecimal %2$s);", request, member);
            }
            else if (type == model.getDateType()) {
                buffer.addImport(Date.class);
                buffer.addLine("%1s %2$s(Date %2$s);", request, member);
            }
        }
        else if (type instanceof StructType) {
            // Method taking an object:
            JavaClassName typeName = javaTypes.getInterfaceName(type);
            buffer.addImport(typeName);
            buffer.addLine("%1s %2$s(%3$s %2$s);", request, member, typeName.getSimpleName());

            // Method taking a builder:
            JavaClassName builderName = javaTypes.getBuilderName(type);
            buffer.addImport(builderName);
            buffer.addLine("%1s %2$s(%3$s %2$s);", request, member, builderName.getSimpleName());
        }
        else if (type instanceof ListType) {
            ListType listType = (ListType) type;
            Type elementType = listType.getElementType();

            // Method taking a list of objects:
            JavaClassName elementName = javaTypes.getInterfaceName(elementType);
            buffer.addImport(elementName);
            buffer.addImport(List.class);
            buffer.addLine("%1s %2$s(List<%3$s> %2$s);", request, member, elementName.getSimpleName());

            // Method taking an array of objects:
            buffer.addImport(elementName);
            buffer.addLine("%1s %2$s(%3$s... %2$s);", request, member, elementName.getSimpleName());

            // Method taking an array of builders:
            JavaClassName builderName = javaTypes.getBuilderName(elementType);
            buffer.addImport(builderName);
            buffer.addLine("%1s %2$s(%3$s... %2$s);", request, member, builderName.getSimpleName());
        }
    }

    private void generateResponseInterface(Method method) {
        // Begin interface:
        String response = getResponseName(method);
        buffer.addLine("public interface %1$s extends Response {", response);

        // Generate the methods to get the output parameters:
        method.parameters()
            .filter(Parameter::isOut)
            .sorted()
            .forEach(this::generateResponseParameterInterface);

        // End interface:
        buffer.addLine("}");
        buffer.addLine();
    }

    private void generateResponseParameterInterface(Parameter parameter) {
        Type type = parameter.getType();
        Name name = parameter.getName();
        String property = javaNames.getJavaMemberStyleName(name);
        JavaTypeReference reference = javaTypes.getTypeReference(type, true);
        buffer.addImports(reference.getImports());
        buffer.addLine("%1$s %2$s();", reference.getText(), property);
    }

    private void generateLocator(Locator locator) {
        Name name = locator.getName();
        Service service = locator.getService();

        JavaClassName serviceName = getServiceName(service);
        buffer.addImport(serviceName);
        String locatorName = javaNames.getJavaMemberStyleName(name);
        if (locator.getParameters().isEmpty()) {
            buffer.addLine("%1$s %2$sService();", serviceName.getSimpleName(), locatorName);
        }
        else {
            buffer.addLine("%1$s %2$sService(String id);", serviceName.getSimpleName(), locatorName);
        }
    }

    private void generatePathLocator() {
        buffer.addImport(BASE_PACKAGE + ".Service");

        buffer.addLine("Service service(String path);");
    }

    private JavaClassName getServiceName(Service service) {
        JavaClassName serviceName = new JavaClassName();
        serviceName.setPackageName(BASE_PACKAGE + ".services");
        serviceName.setSimpleName(javaNames.getJavaClassStyleName(service.getName()) + "Service");
        return serviceName;
    }

    private String getRequestName(Method method) {
        return javaNames.getJavaClassStyleName(method.getName()) + "Request";
    }

    private String getResponseName(Method method) {
        return javaNames.getJavaClassStyleName(method.getName()) + "Response";
    }
}
