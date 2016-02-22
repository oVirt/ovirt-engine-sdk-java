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

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.util.EntityUtils;
import org.ovirt.api.metamodel.concepts.ListType;
import org.ovirt.api.metamodel.concepts.Locator;
import org.ovirt.api.metamodel.concepts.Method;
import org.ovirt.api.metamodel.concepts.Model;
import org.ovirt.api.metamodel.concepts.Name;
import org.ovirt.api.metamodel.concepts.NameParser;
import org.ovirt.api.metamodel.concepts.Parameter;
import org.ovirt.api.metamodel.concepts.PrimitiveType;
import org.ovirt.api.metamodel.concepts.Service;
import org.ovirt.api.metamodel.concepts.StructType;
import org.ovirt.api.metamodel.concepts.Type;
import org.ovirt.api.metamodel.runtime.xml.XmlReader;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.api.metamodel.tool.JavaClassBuffer;
import org.ovirt.api.metamodel.tool.JavaClassName;
import org.ovirt.api.metamodel.tool.JavaGenerator;
import org.ovirt.api.metamodel.tool.JavaNames;
import org.ovirt.api.metamodel.tool.JavaTypeReference;
import org.ovirt.api.metamodel.tool.JavaTypes;
import org.ovirt.api.metamodel.tool.SchemaNames;

import javax.inject.Inject;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

/**
 * This class is responsible for generating the classes that represent the implementation of services of the model.
 */
public class ServicesImplGenerator extends JavaGenerator {
    // The base package:
    private String BASE_PACKAGE = "org.ovirt.engine.sdk";

    // Service implementation suffix
    private String IMPL_SUFFIX = "Impl";

    // Reference to the objects used to generate the code:
    @Inject private JavaNames javaNames;
    @Inject private JavaTypes javaTypes;

    // Reference to the object used to calculate XML schema names:
    @Inject private SchemaNames schemaNames;

    // The buffer used to generate the code:
    private JavaClassBuffer buffer;

    private static final Name ADD = NameParser.parseUsingCase("Add");
    private static final Name GET = NameParser.parseUsingCase("Get");
    private static final Name LIST = NameParser.parseUsingCase("List");
    private static final Name REMOVE = NameParser.parseUsingCase("Remove");
    private static final Name UPDATE = NameParser.parseUsingCase("Update");


    public void generate(Model model) {
        model.services().forEach(this::generateServicesImplementation);
    }

    private void generateServicesImplementation(Service service) {
        // Prepare the buffer:
        buffer = new JavaClassBuffer();
        JavaClassName serviceName = getServiceImplName(service);
        buffer.setClassName(serviceName);

        // Generate the code:
        generateServiceImplementationSource(service);

        // Write the file:
        try {
            buffer.write(outDir);
        }
        catch (IOException exception) {
            throw new IllegalStateException("Error writing service implementation", exception);
        }
    }

    private void generateServiceImplementationSource(Service service) {
        // Begin class:
        JavaClassName serviceName = getServiceName(service);
        JavaClassName serviceImplName = getServiceImplName(service);

        buffer.addImport(serviceName);
        buffer.addLine("public class %1$s extends ServiceImpl implements %2$s {",
            serviceImplName.getSimpleName(), serviceName.getSimpleName());
        buffer.addLine();

        // Generate constructors
        generateConstructorsImplementation(serviceImplName.getSimpleName());

        // Generate the code for the methods:
        service.declaredMethods()
                .sorted()
                .forEach(this::generateMethodImplementation);

        // Generate the code for the locators:
        service.locators()
                .sorted()
                .forEach(this::generateLocator);
        generatePathLocator(service);

        // Generate toString
        generatetoString(service);

        // End class:
        buffer.addLine("}");
        buffer.addLine();
    }

    private void generateConstructorsImplementation(String serviceImplName) {
        buffer.addImport(BASE_PACKAGE + ".internal.HttpConnection");

        buffer.addLine("public %1$s(HttpConnection connection, String path) {", serviceImplName);
        buffer.addLine(  "super(connection, path);");
        buffer.addLine("}");
        buffer.addLine();
    }


    private void generateMethodImplementation(Method method) {
        Name name = method.getName();

        // Generate the request and response implementation of interfaces:
        generateRequestImplementation(method);
        generateResponseImplementation(method);

        // Generate the method:
        String request = getRequestName(method);
        String requestImpl = getRequestImplName(method);
        String member = javaNames.getJavaMemberStyleName(name);
        buffer.addLine("public %1$s %2$s() {", request, member);
        buffer.addLine(  "return new %1$s();", requestImpl);
        buffer.addLine("}");
        buffer.addLine();
    }

    private void generateRequestImplementation(Method method) {
        // Begin class:
        Name name = method.getName();
        String request = getRequestName(method);
        String requestImpl = getRequestImplName(method);
        buffer.addLine("private class %1$s implements %2$s {", requestImpl, request);

        // Generate the methods to set input parameters:
        method.parameters()
            .filter(Parameter::isIn)
            .sorted()
            .forEach(this::generateRequestParameterImplementation);

        // Generate send method:
        buffer.addLine("public %1$s send() {", getResponseName(method));
        // Generate method code based on response type:
        if(ADD.equals(name)) {
            generateAddRequestImplementaion(method);
        }
        else if(GET.equals(name) || LIST.equals(name)) {
            generateListRequestImplementaion(method);
        }
        else if(REMOVE.equals(name)) {
            generateRemoveRequestImplementaion(method);
        }
        else if(UPDATE.equals(name)) {
            generateUpdateRequestImplementaion(method);
        }
        else {
            generateActionRequestImplementation(method);
        }

        // End method:
        buffer.addLine("}");
        buffer.addLine();

        // End class:
        buffer.addLine("}");
        buffer.addLine();
    }

    private void generateListRequestImplementaion(Method method) {
        buffer.addImport(URIBuilder.class);
        buffer.addImport(URISyntaxException.class);
        buffer.addImport(HttpGet.class);

        buffer.addLine("HttpGet request = null;");
        buffer.addLine("try {");
        buffer.addLine(  "URIBuilder uriBuilder = new URIBuilder(getConnection().getUrl() + getPath());");

        method.parameters()
            .filter(Parameter::isIn)
            .sorted()
            .forEach(this::generateRequestParameterQueryBuilder);

        buffer.addLine(  "request = new HttpGet(uriBuilder.build());");
        buffer.addLine("}");
        buffer.addLine("catch (URISyntaxException ex) {");
        buffer.addLine(  "throw new RuntimeException(ex);");
        buffer.addLine("}");
        generateCommonRequestImplementation(method, new String[]{"200"});
    }

    private void generateRequestParameterQueryBuilder(Parameter parameter) {
        buffer.addLine("if(%1$s != null) {", javaNames.getJavaMemberStyleName(parameter.getName()));

        buffer.addLine(  "uriBuilder.addParameter(\"%1$s\", String.valueOf(%2$s));", // FIXME: don't use String.valueOf
            parameter.getName().toString().replaceAll("-", "_"), javaNames.getJavaMemberStyleName(parameter.getName()));
        buffer.addLine("}");
    }

    private void generateAddRequestImplementaion(Method method) {
        buffer.addImport(HttpPost.class);
        buffer.addImport(XmlWriter.class);
        buffer.addImport(IOException.class);
        buffer.addImport(ByteArrayEntity.class);
        buffer.addImport(ByteArrayOutputStream.class);

        buffer.addLine("HttpPost request = null;");
        buffer.addLine("try {");
        buffer.addLine(  "URIBuilder uriBuilder = new URIBuilder(getConnection().getUrl() + getPath());");

        method.parameters()
            .filter(Parameter::isIn)
            .filter(p -> p.getType() instanceof PrimitiveType)
            .sorted()
            .forEach(this::generateRequestParameterQueryBuilder);

        buffer.addLine(  "request = new HttpPost(uriBuilder.build());");
        buffer.addLine("}");
        buffer.addLine("catch (URISyntaxException ex) {");
        buffer.addLine(  "throw new RuntimeException(ex);");
        buffer.addLine("}");

        Parameter param = method.parameters()
            .filter(Parameter::isIn)
            .filter(p -> p.getType() instanceof StructType)
            .findFirst().orElse(null);

        if (param != null) {
            JavaClassName writerName = javaTypes.getXmlWriterName(param.getType());
            buffer.addImport(writerName);
            buffer.addLine("try (");
            buffer.addLine("  ByteArrayOutputStream output = new ByteArrayOutputStream();");
            buffer.addLine("  XmlWriter xmlWriter = new XmlWriter(output, true)");
            buffer.addLine(") {");
            buffer.addLine(  "%1$s.writeOne(%2$s, xmlWriter);",
                writerName.getSimpleName(), javaNames.getJavaMemberStyleName(param.getName()));
            buffer.addLine(  "xmlWriter.flush();");
            buffer.addLine(  "request.setEntity(new ByteArrayEntity(output.toByteArray()));");
            buffer.addLine("}");
            buffer.addLine("catch (IOException ex) {");
            buffer.addLine(  "throw new RuntimeException(ex);");
            buffer.addLine("}");
        }

        generateCommonRequestImplementation(method, new String[]{"200", "201"});
    }

    public void generateRemoveRequestImplementaion(Method method) {
        buffer.addImport(HttpDelete.class);
        buffer.addImport(URIBuilder.class);
        buffer.addImport(URISyntaxException.class);

        buffer.addLine("HttpDelete request = null;");
        buffer.addLine("try {");
        buffer.addLine(  "URIBuilder uriBuilder = new URIBuilder(getConnection().getUrl() + getPath());");

        method.parameters()
            .filter(Parameter::isIn)
            .sorted()
            .forEach(this::generateRequestParameterQueryBuilder);

        buffer.addLine(  "request = new HttpDelete(uriBuilder.build());");
        buffer.addLine("}");
        buffer.addLine("catch (URISyntaxException ex) {");
        buffer.addLine(  "throw new RuntimeException(ex);");
        buffer.addLine("}");
        generateCommonRequestImplementation(method, new String[]{"200"});
    }

    public void generateUpdateRequestImplementaion(Method method) {
        buffer.addImport(HttpPut.class);
        buffer.addImport(XmlWriter.class);
        buffer.addImport(IOException.class);
        buffer.addImport(ByteArrayEntity.class);
        buffer.addImport(ByteArrayOutputStream.class);

        buffer.addLine("HttpPut request = null;");
        buffer.addLine("try {");
        buffer.addLine(  "URIBuilder uriBuilder = new URIBuilder(getConnection().getUrl() + getPath());");

        method.parameters()
            .filter(Parameter::isIn)
            .filter(p -> p.getType() instanceof PrimitiveType)
            .sorted()
            .forEach(this::generateRequestParameterQueryBuilder);

        buffer.addLine(  "request = new HttpPut(uriBuilder.build());");
        buffer.addLine("}");
        buffer.addLine("catch (URISyntaxException ex) {");
        buffer.addLine(  "throw new RuntimeException(ex);");
        buffer.addLine("}");

        Parameter param = method.parameters()
            .filter(Parameter::isIn)
            .filter(p -> p.getType() instanceof StructType)
            .findFirst().orElse(null);

        if (param != null) {
            JavaClassName writerName = javaTypes.getXmlWriterName(param.getType());
            buffer.addImport(writerName);
            buffer.addLine("try (");
            buffer.addLine("  ByteArrayOutputStream output = new ByteArrayOutputStream();");
            buffer.addLine("  XmlWriter xmlWriter = new XmlWriter(output, true)");
            buffer.addLine(") {");
            buffer.addLine(  "%1$s.writeOne(%2$s, xmlWriter);",
                writerName.getSimpleName(), javaNames.getJavaMemberStyleName(param.getName()));
            buffer.addLine(  "xmlWriter.flush();");
            buffer.addLine(  "request.setEntity(new ByteArrayEntity(output.toByteArray()));");
            buffer.addLine("}");
            buffer.addLine("catch (IOException ex) {");
            buffer.addLine(  "throw new RuntimeException(ex);");
            buffer.addLine("}");
        }

        generateCommonRequestImplementation(method, new String[]{"200"});
    }

    private void generateActionRequestImplementation(Method method) {
        buffer.addImport(HttpPost.class);
        buffer.addImport(XmlWriter.class);
        buffer.addImport(IOException.class);
        buffer.addImport(ByteArrayEntity.class);
        buffer.addImport(ByteArrayOutputStream.class);

        buffer.addLine("HttpPost request = new HttpPost(getConnection().getUrl() + getPath());");

        buffer.addLine("try (");
        buffer.addLine("  ByteArrayOutputStream output = new ByteArrayOutputStream();");
        buffer.addLine("  XmlWriter xmlWriter = new XmlWriter(output, true)");
        buffer.addLine(") {");
        buffer.addLine(  "xmlWriter.writeStartElement(\"action\");");

        method.parameters()
            .filter(Parameter::isIn)
            .forEach(this::generateActionParamsWriters);

        buffer.addLine(  "xmlWriter.writeEndElement();");
        buffer.addLine(  "xmlWriter.flush();");
        buffer.addLine(  "request.setEntity(new ByteArrayEntity(output.toByteArray()));");
        buffer.addLine("}");
        buffer.addLine("catch (IOException ex) {");
        buffer.addLine(  "throw new RuntimeException(ex);");
        buffer.addLine("}");

        generateCommonRequestImplementation(method, new String[]{"200"});
    }

    private void generateActionParamsWriters(Parameter parameter) {
        Type type = parameter.getType();
        String name = javaNames.getJavaMemberStyleName(parameter.getName());

        buffer.addLine("if (%1$s != null) {", name);
        if (type instanceof PrimitiveType) {
            buffer.addLine("xmlWriter.writeElement(\"%1$s\", String.valueOf(%2$s));", // FIXME: don't use String.valueOf
                schemaNames.getSchemaTagName(parameter.getName()), name);
        }
        else if (type instanceof StructType) {
            JavaClassName xmlWriterName = javaTypes.getXmlWriterName(type);
            buffer.addImport(xmlWriterName);
            buffer.addLine("%1$s.writeOne(%2$s, xmlWriter);", xmlWriterName.getSimpleName(), name);
        }
        else if (type instanceof ListType) {
            ListType listType = (ListType) type;
            Type elementType = listType.getElementType();
            JavaClassName xmlWriterName = javaTypes.getXmlWriterName(elementType);
            buffer.addImport(xmlWriterName);
            buffer.addLine("%1$s.writeMany(%2$s.iterator(), xmlWriter);", xmlWriterName.getSimpleName(), name);
        }
        buffer.addLine("}");
    }

    private void generateCommonRequestImplementation(Method method, String[] codes) {
        buffer.addImport(IOException.class);
        buffer.addImport(EntityUtils.class);
        buffer.addImport(HttpResponse.class);
        buffer.addImport(XmlReader.class);

        buffer.addLine();
        buffer.addLine("HttpResponse response = getConnection().send(request);");
        buffer.addLine("if (");
        buffer.addLine("  response.getStatusLine().getStatusCode() == %1$s", codes[0]);
        for (int i = 1; i < codes.length; i++) {
            buffer.addLine("  || response.getStatusLine().getStatusCode() == %1$s", codes[i]);
        }

        buffer.addLine(") {");
        buffer.addLine(  "try (");
        buffer.addLine(  "  XmlReader reader = new XmlReader(response.getEntity().getContent())");
        buffer.addLine(  ") {");

        // Generate the methods and appropriate constructors to get the output parameters:
        List<Parameter> parameters = method.parameters().filter(Parameter::isOut).collect(Collectors.toList());
        if (parameters.isEmpty()) {
            buffer.addLine("return new %1$s();", getResponseImplName(method));
        } else {
            parameters.stream()
                .sorted()
                .forEach(this::generateRequestReaderImplementation);
        }

        buffer.addLine(  "}");
        buffer.addLine(  "catch (IOException ex) {");
        buffer.addLine(    "throw new RuntimeException(ex);");
        buffer.addLine(  "}");
        buffer.addLine(  "finally {");
        buffer.addLine(    "EntityUtils.consumeQuietly(response.getEntity());");
        buffer.addLine(  "}");
        buffer.addLine("}");
        buffer.addLine("else {");
        buffer.addLine(  "checkFault(response);");
        buffer.addLine(  "return null;");
        buffer.addLine("}");
    }

    private void generateRequestReaderImplementation(Parameter parameter) {
        Type type = parameter.getType();
        String responseImplName = getResponseImplName(parameter.getDeclaringMethod());

        if (type instanceof PrimitiveType) {
            buffer.addLine("return new %1$s(reader.read%2$s());",
                responseImplName, javaNames.getJavaClassStyleName(type.getName()));
        }
        else if (type instanceof StructType) {
            JavaClassName xmlReaderName = javaTypes.getXmlReaderName(type);
            buffer.addImport(xmlReaderName);
            buffer.addLine("return new %1$s(%2$s.readOne(reader));", responseImplName, xmlReaderName.getSimpleName());
        }
        else if (type instanceof ListType) {
            ListType listType = (ListType) type;
            Type elementType = listType.getElementType();
            if (elementType instanceof PrimitiveType) {
                // TODO: once added support to readMany in XmlReader fix this
                buffer.addLine("return new %1$s(null);", responseImplName);
            } else {
                JavaClassName xmlReaderName = javaTypes.getXmlReaderName(elementType);
                buffer.addImport(xmlReaderName);
                buffer.addLine("return new %1$s(%2$s.readMany(reader));", responseImplName, xmlReaderName.getSimpleName());
            }
        }
    }

    private void generateRequestParameterImplementation(Parameter parameter) {
        Method method = parameter.getDeclaringMethod();
        Type type = parameter.getType();
        Name name = parameter.getName();
        String member = javaNames.getJavaMemberStyleName(name);
        String request = getRequestName(method);
        if (type instanceof PrimitiveType) {
            Model model = type.getModel();
            if (type == model.getBooleanType()) {
                generateRequestParameterMethodImplementation("public %1s %2$s(%3$s %2$s) {", request, member, "Boolean");
            }
            else if (type == model.getStringType()) {
                generateRequestParameterMethodImplementation("public %1s %2$s(%3$s %2$s) {", request, member, "String");
            }
            else if (type == model.getIntegerType()) {
                buffer.addImport(BigInteger.class);
                generateRequestParameterMethodImplementation("public %1s %2$s(%3$s %2$s) {", request, member, "BigInteger");
                generateRequestParameterMultiMethodImplementation("public %1s %2$s(%3$s %2$s) {", request, member, "BigInteger", "Integer", "Long");
            }
            else if (type == model.getDecimalType()) {
                buffer.addImport(BigDecimal.class);
                generateRequestParameterMethodImplementation("public %1s %2$s(%3$s %2$s) {", request, member, "BigDecimal");
                generateRequestParameterMultiMethodImplementation("public %1s %2$s(%3$s %2$s) {", request, member, "BigDecimal", "Float", "Double");
            }
            else if (type == model.getDateType()) {
                buffer.addImport(Date.class);
                generateRequestParameterMethodImplementation("public %1s %2$s(%3$s %2$s) {", request, member, "Date");
            }
        }
        else if (type instanceof StructType) {
            // Method taking an object:
            JavaClassName typeName = javaTypes.getInterfaceName(type);
            buffer.addImport(typeName);
            generateRequestParameterMethodImplementation("public %1s %2$s(%3$s %2$s) {", request, member, typeName.getSimpleName());

            // Method taking a builder:
            JavaClassName builderName = javaTypes.getBuilderName(type);
            buffer.addImport(builderName);
            generateRequestParameterBuilderMethodImplementation("public %1s %2$s(%3$s %2$s) {", request, member, builderName.getSimpleName());
        }
        else if (type instanceof ListType) {
            ListType listType = (ListType) type;
            Type elementType = listType.getElementType();

            // Method taking a list of objects:
            JavaClassName elementName = javaTypes.getInterfaceName(elementType);
            buffer.addImport(elementName);
            buffer.addImport(List.class);
            generateRequestParameterMethodImplementation("public %1s %2$s(%3$s %2$s) {", request, member, "List<" + elementName.getSimpleName() + ">");

            // Method taking an array of objects:
            buffer.addImport(elementName);
            buffer.addImport(Arrays.class);
            generateRequestParameterArgsMethodImplementation("public %1s %2$s(%3$s %2$s) {", request, member, elementName.getSimpleName() + "...");

            // Method taking an array of builders:
            JavaClassName builderName = javaTypes.getBuilderName(elementType);
            buffer.addImport(builderName);
            buffer.addImport(Collectors.class);
            generateRequestParameterArgsBuilderMethodImplementation("public %1s %2$s(%3$s %2$s) {", request, member, builderName.getSimpleName() + "...");
        }
    }

    private void generateRequestParameterArgsMethodImplementation(String format, String request, String member, String type) {
        buffer.addLine(format, request, member, type);
        buffer.addLine(  "this.%1$s = Arrays.asList(%1$s);", member);
        buffer.addLine(  "return this;");
        buffer.addLine("}");
        buffer.addLine();
    }

    private void generateRequestParameterArgsBuilderMethodImplementation(String format, String request, String member, String type) {
        buffer.addLine(format, request, member, type);
        buffer.addLine(  "this.%1$s = Arrays.stream(%1$s).map(e -> e.build()).collect(Collectors.toList());", member);
        buffer.addLine(  "return this;");
        buffer.addLine("}");
        buffer.addLine();
    }

    private void generateRequestParameterBuilderMethodImplementation(String format, String request, String member, String type) {
        buffer.addLine(format, request, member, type);
        buffer.addLine(  "this.%1$s = %1$s.build();", member);
        buffer.addLine(  "return this;");
        buffer.addLine("}");
        buffer.addLine();
    }

    private void generateRequestParameterMultiMethodImplementation(String format, String request, String member, String type, String ... otherTypes) {
        for (String _type : otherTypes) {
            buffer.addLine(format, request, member, _type);
            buffer.addLine(  "this.%1$s = %2$s.valueOf(%1$s);", member, type);
            buffer.addLine(  "return this;");
            buffer.addLine("}");
            buffer.addLine();
        }
    }

    private void generateRequestParameterMethodImplementation(String format, String request, String member, String type) {
        buffer.addLine("private %1$s %2$s;", type, member);
        buffer.addLine(format, request, member, type);
        buffer.addLine(  "this.%1$s = %1$s;", member);
        buffer.addLine("return this;");
        buffer.addLine("}");
        buffer.addLine();
    }

    private void generateResponseImplementation(Method method) {
        // Begin interface implementation:
        String response = getResponseName(method);
        String responseImpl = getResponseImplName(method);
        buffer.addLine("private class %1$s implements %2$s {", responseImpl, response);

        // Generate the methods and appropriate constructors to get the output parameters:
        method.parameters()
                .filter(Parameter::isOut)
                .sorted()
                .forEach(this::generateResponseParameterImplementation);

        // End interface implementation:
        buffer.addLine("}");
        buffer.addLine();
    }

    private void generateResponseParameterImplementation(Parameter parameter) {
        Type type = parameter.getType();
        Name name = parameter.getName();
        String property = javaNames.getJavaMemberStyleName(name);
        JavaTypeReference reference = javaTypes.getTypeReference(type, true);
        for (JavaClassName clazz : reference.getImports()) {
            buffer.addImport(clazz);
        }

        // Add appropriate constructor to type reference
        buffer.addLine("private %1$s %2$s;", reference.getText(), property);
        buffer.addLine();
        buffer.addLine("public %1$s(%2$s %3$s) {",
            getResponseImplName(parameter.getDeclaringMethod()), reference.getText(), property);
        buffer.addLine(  "this.%1$s = %1$s;", property);
        buffer.addLine("}");
        buffer.addLine();

        buffer.addLine("public %1$s %2$s() {", reference.getText(), property);
        buffer.addLine(  "return %1$s;", property);
        buffer.addLine("}");
        buffer.addLine();
    }

    private void generateLocator(Locator locator) {
        Name name = locator.getName();
        Service service = locator.getService();
        String urlSegment = getPath(locator.getName());
        JavaClassName serviceName = getServiceName(service);
        JavaClassName serviceImplName = getServiceImplName(service);
        String locatorName = javaNames.getJavaMemberStyleName(name);

        buffer.addImport(serviceName);
        if (locator.getParameters().isEmpty()) {
            buffer.addLine("public %1$s %2$sService() {", serviceName.getSimpleName(), locatorName);
            buffer.addLine(  "return new %1$s(getConnection(), getPath() + \"/%2$s\");", serviceImplName.getSimpleName(), urlSegment);
        }
        else {
            buffer.addLine("public %1$s %2$sService(String id) {", serviceName.getSimpleName(), locatorName);
            buffer.addLine("return new %1$s(getConnection(), getPath() + \"/\" + id);", serviceImplName.getSimpleName());
        }
        buffer.addLine("}");
        buffer.addLine();
    }

    private void generatePathLocator(Service service) {
        buffer.addImport(BASE_PACKAGE + ".Service");

        buffer.addLine("public Service service(String path) {");
        buffer.addLine(  "if (path == null) {");
        buffer.addLine(    "return this;");
        buffer.addLine(  "}");
        buffer.addLine();
        // Generate the code that checks if the path corresponds to any of the locators without parameters:
        service.locators().filter(x -> x.getParameters().isEmpty()).sorted().forEach(locator -> {
            Name name = locator.getName();
            String segment = getPath(name);
            buffer.addLine("if (path.equals(\"%1$s\")) {", segment);
            buffer.addLine(  "return %1$sService();", javaNames.getJavaMemberStyleName(name));
            buffer.addLine("}");
            buffer.addLine("if (path.startsWith(\"%1$s/\")) {", segment);
            buffer.addLine(
                "return %1$sService().service(path.substring(%2$d));",
                javaNames.getJavaMemberStyleName(name),
                segment.length() + 1
            );
            buffer.addLine("}");
        });

        // If the path doesn't correspond to a locator without parameters, then it will correspond to the locator
        // with parameters, otherwise it is an error:
        Optional<Locator> optional = service.locators().filter(x -> !x.getParameters().isEmpty()).findAny();
        if (optional.isPresent()) {
            Locator locator = optional.get();
            Name name = locator.getName();
            buffer.addLine("int index = path.indexOf('/');");
            buffer.addLine("if (index == -1) {");
            buffer.addLine("return %1$sService(path);", javaNames.getJavaMemberStyleName(name));
            buffer.addLine("}");
            buffer.addLine(
                "return %1$sService(path.substring(0, index - 1)).service(path.substring(index + 1));",
                javaNames.getJavaMemberStyleName(name)
            );
        }
        else {
            buffer.addLine("throw new RuntimeException(\"The path \" + path + \" doesn't correspond to any service\");");
        }
        buffer.addLine("}");
        buffer.addLine();
    }

    private void generatetoString(Service service) {
        JavaClassName serviceName = getServiceName(service);
        buffer.addLine("public String toString() {");
        buffer.addLine(  "return \"%1$s:\" + getPath();", serviceName.getSimpleName());
        buffer.addLine("}");
        buffer.addLine();
    }

    private JavaClassName getServiceImplName(Service service) {
        JavaClassName serviceName = new JavaClassName();
        serviceName.setPackageName(BASE_PACKAGE + ".services.internal");
        serviceName.setSimpleName(javaNames.getJavaClassStyleName(service.getName()) + "ServiceImpl");
        return serviceName;
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

    private String getRequestImplName(Method method) {
        return getRequestName(method) + IMPL_SUFFIX;
    }

    private String getResponseName(Method method) {
        return javaNames.getJavaClassStyleName(method.getName()) + "Response";
    }

    private String getResponseImplName(Method method) {
        return getResponseName(method) + IMPL_SUFFIX;
    }

    private String getPath(Name name) {
        return name.words().map(String::toLowerCase).collect(joining());
    }
}
