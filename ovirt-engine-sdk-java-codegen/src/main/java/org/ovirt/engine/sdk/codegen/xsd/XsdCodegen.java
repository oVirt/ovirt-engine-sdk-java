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

package org.ovirt.engine.sdk.codegen.xsd;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.ovirt.engine.sdk.codegen.templates.CopyrightTemplate;
import org.ovirt.engine.sdk.codegen.utils.FileUtils;

/**
 * Provides XSD schema related services
 */
public class XsdCodegen {
    private static final String ENTITIES_PACKAGE = "org.ovirt.engine.sdk.entities";

    private static final String copyrightTemplate = new CopyrightTemplate().getTemplate();

    /**
     * The location of the XSD file.
     */
    private String xsdPath;

    /**
     * The location of the JAXB bindings file.
     */
    private String xjbPath;

    public XsdCodegen(String xsdPath, String xjbPath) {
        this.xsdPath = xsdPath;
        this.xjbPath = xjbPath;
    }

    /**
     * Generates entity classes.
     *
     * @param distPath directory to generates the code at
     */
    public void generate(String distPath) throws IOException {
        // Remove all the previously generate classes, so that classes corresponding to types that have been
        // removed from the XML schema will be later removed from the source code repository:
        String packagePath = distPath + File.separatorChar + ENTITIES_PACKAGE.replace('.', File.separatorChar);
        FileUtils.deleteAllFiles(packagePath);

        // Run the XJC compiler to generate all the classes:
        System.setProperty("javax.xml.accessExternalSchema", "all");
        try {
            com.sun.tools.xjc.Driver.run(
                new String[] {
                    "-extension",
                    "-no-header",
                    "-enableIntrospection",
                    "-d", distPath,
                    "-p", ENTITIES_PACKAGE,
                    "-b", xjbPath,
                    xsdPath
                },
                System.out,
                System.err
            );
        }
        catch (Exception exception) {
            throw new IOException(exception);
        }
    }

    /**
     * Modifies public getters to return {@code Object} so inheriting classes could override them with different
     * signature.
     *
     * @param distPath the top level directory of the source code
     * @param accessors a list of possible getter types
     */
    public static void modifyGetters(String distPath, Map<String, List<String>> accessors) {
        StringBuffer finalContent, tempContent = new StringBuffer();
        List<String> accessorsToCheck;
        String templateOriginal = "    public $accessor$ get$accessor$() {" + "\n";
        String templateReplace = "    public Object get$accessor$() {" + "\n";
        String placeHolder = "$accessor$";
        boolean isInAccessor = false;

        // change shadowed getters
        String entitiesPath = distPath + File.separator + ENTITIES_PACKAGE.replace('.', File.separatorChar);
        for (File file : FileUtils.list(entitiesPath)) {
            finalContent = new StringBuffer();
            finalContent.append(copyrightTemplate);
            tempContent = new StringBuffer();
            accessorsToCheck = new ArrayList<String>();

            List<String> accessorsContent = accessors.get(file.getName().replace(".java", ""));
            if (accessorsContent != null) {
                accessorsToCheck.addAll(accessorsContent);
            } else {
                injectCopyrightHeader(file);
                continue;
            }

            try {
                List<String> strings = FileUtils.getFileContentAsList(file.getAbsolutePath());
                for (int i = 1; i < strings.size(); i++) {
                    String str = strings.get(i);
                    if (str.equals("\n")) {
                        isInAccessor = false;
                        finalContent.append("\n");
                        finalContent.append(tempContent.toString());
                        tempContent = new StringBuffer();
                    } else if (str.equals("}\n")) {
                        isInAccessor = false;
                        finalContent.append("\n}");
                    } else {
                        if (!isInAccessor) {
                            for (String accessor : accessorsToCheck) {
                                if (str.toLowerCase().equals(templateOriginal.replace(placeHolder, accessor)
                                        .toLowerCase())) {
                                    isInAccessor = true;
                                    tempContent.append(templateReplace.replace(placeHolder, accessor));
                                    break;
                                }
                            }
                            if (!isInAccessor) {
                                tempContent.append(str);
                            } else {
                                isInAccessor = false;
                            }
                        }
                    }
                }

            } catch (FileNotFoundException e) {
                // TODO: Log error
                e.printStackTrace();
                continue;
            }
            // save new content
            FileUtils.saveFile(file.getAbsolutePath(),
                    finalContent.toString());
        }
    }

    /**
     * Inject CopyrightHeader in to file
     *
     * @param file
     *            file to inject to
     */
    private static void injectCopyrightHeader(File file) {
        StringBuffer content = new StringBuffer();
        try {
            content.append(copyrightTemplate);
            content.append(FileUtils.getFileContent(file.getAbsolutePath()));
            FileUtils.saveFile(file.getAbsolutePath(), content.toString());
        } catch (FileNotFoundException e) {
            // TODO: Log error
            e.printStackTrace();
        }
    }
}
