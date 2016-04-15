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

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.io.FileUtils;
import org.ovirt.api.metamodel.analyzer.ModelAnalyzer;
import org.ovirt.api.metamodel.concepts.Attribute;
import org.ovirt.api.metamodel.concepts.Model;
import org.ovirt.api.metamodel.concepts.NameParser;
import org.ovirt.api.metamodel.concepts.StructType;
import org.ovirt.api.metamodel.tool.BuiltinTypes;
import org.ovirt.api.metamodel.tool.EnumGenerator;
import org.ovirt.api.metamodel.tool.JavaGenerator;
import org.ovirt.api.metamodel.tool.JavaPackages;
import org.ovirt.api.metamodel.tool.StructsGenerator;
import org.ovirt.api.metamodel.tool.XmlSupportGenerator;


@ApplicationScoped
public class Tool {
    // The name of the base package:
    private static final String BASE_PACKAGE = "org.ovirt.engine.sdk4";

    // The names of the command line options:
    private static final String MODEL_OPTION = "model";
    private static final String OUT_OPTION = "out";

    // Reference to the objects used to calculate Python names:
    @Inject private JavaPackages javaPackages;

    // References to the generators:
    @Inject private StructsGenerator structsGenerator;
    @Inject private XmlSupportGenerator xmlSupportGenerator;
    @Inject private ServicesGenerator servicesGenerator;
    @Inject private ServicesImplGenerator servicesImplGenerator;
    @Inject private EnumGenerator enumGenerator;
    @Inject private BuiltinTypes builtinTypes;

    public void run(String[] args) throws Exception {
        // Create the command line options:
        Options options = new Options();

        // Options for the locations of files and directories:
        options.addOption(Option.builder()
            .longOpt(MODEL_OPTION)
            .desc("The directory or .jar file containing the source model files.")
            .type(File.class)
            .required(true)
            .hasArg(true)
            .argName("DIRECTORY|JAR")
            .build()
        );

        // Options for the location of the generated sources:
        options.addOption(Option.builder()
            .longOpt(OUT_OPTION)
            .desc("The directory where the generated source will be created.")
            .type(File.class)
            .required(false)
            .hasArg(true)
            .argName("DIRECTORY")
            .build()
        );

        // Parse the command line:
        CommandLineParser parser = new DefaultParser();
        CommandLine line = null;
        try {
            line = parser.parse(options, args);
        }
        catch (ParseException exception) {
            HelpFormatter formatter = new HelpFormatter();
            formatter.setSyntaxPrefix("Usage: ");
            formatter.printHelp("sdk-tool [OPTIONS]", options);
            System.exit(1);
        }

        // Extract the locations of files and directories from the command line:
        File modelFile = (File) line.getParsedOptionValue(MODEL_OPTION);
        File outDir = (File) line.getParsedOptionValue(OUT_OPTION);

        // Analyze the model files:
        Model model = new Model();
        ModelAnalyzer modelAnalyzer = new ModelAnalyzer();
        modelAnalyzer.setModel(model);
        modelAnalyzer.analyzeSource(modelFile);

        // Generate href attribute to Identified type:
        addHrefAttributeToIdentifiedType(model);

        // Add the built-in types:
        builtinTypes.addBuiltinTypes(model);

        // Set the names of the packages:
        javaPackages.setTypesPackageName(BASE_PACKAGE + ".types");
        javaPackages.setContainersPackageName(BASE_PACKAGE + ".internal.containers");
        javaPackages.setBuildersPackageName(BASE_PACKAGE + ".builders");
        javaPackages.setXmlPackageName(BASE_PACKAGE + ".internal.xml");

        // Run the generators:
        if (outDir != null) {
            List<JavaGenerator> generators = new ArrayList<>();
            generators.add(structsGenerator);
            generators.add(xmlSupportGenerator);
            generators.add(enumGenerator);
            generators.add(servicesGenerator);
            generators.add(servicesImplGenerator);
            FileUtils.forceMkdir(outDir);
            for (JavaGenerator generator : generators) {
                generator.setOutDir(outDir);
                generator.generate(model);
            }
        }
    }

    private void addHrefAttributeToIdentifiedType(Model model) {
        StructType identified = (StructType)model.getType(NameParser.parseUsingCase("Identified"));
        Attribute href = new Attribute();
        href.setType(model.getStringType());
        href.setName(NameParser.parseUsingCase("Href"));
        href.setDeclaringType(identified);
        identified.addAttribute(href);
    }
}
