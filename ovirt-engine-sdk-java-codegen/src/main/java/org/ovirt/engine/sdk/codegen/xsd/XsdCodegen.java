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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBException;

import org.apache.http.client.ClientProtocolException;
import org.ovirt.engine.sdk.codegen.common.AbstractCodegen;
import org.ovirt.engine.sdk.codegen.templates.CopyrightTemplate;
import org.ovirt.engine.sdk.codegen.utils.FileUtils;
import org.ovirt.engine.sdk.codegen.utils.OsUtil;
import org.ovirt.engine.sdk.exceptions.ServerException;
import org.ovirt.engine.sdk.web.HttpProxyBroker;

/**
 * Provides XSD schema related services
 */
public class XsdCodegen extends AbstractCodegen {

    private static final String SCHEMA_URL = "?schema";

    private static final String WINDOWS_XJC_PATH = "%java_home%\\bin\\xjc";
    private static final String NX_XJC_PATH = "xjc";

    private static final String WINDOWS_ENTITIES_PATH = "..\\java-sdk\\src\\main\\java\\";
    private static final String NX_ENTITIES_PATH = "../java-sdk/src/main/java/";

    private static final String ENTITIES_PACKAGE = "org.ovirt.engine.sdk.entities";
    private static final String SCHEMA_FILE_NAME = "api.xsd";
    private static final String XJC_FLAGS = " -extension -no-header ";

    private static final String copyrightTemplate = new CopyrightTemplate().getTemplate();

    private HttpProxyBroker httpProxy;

    /**
     * @param httpProxy
     */
    public XsdCodegen(HttpProxyBroker httpProxy) {
        super(getEntitiesPath());

        this.httpProxy = httpProxy;
    }

    /**
     * Generates entities classes
     * 
     * @param distPath
     *            directory to generates the code at
     * 
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws IOException
     * @throws JAXBException
     */
    @Override
    public void doGenerate(String distPath) throws ClientProtocolException,
            ServerException, IOException, JAXBException {

        String xjcOutput = null;

        fetchScema(this.httpProxy);

        if (OsUtil.isWindows()) {
            xjcOutput = runCommand(WINDOWS_XJC_PATH + " -d " + distPath +
                    " -p " + ENTITIES_PACKAGE + XJC_FLAGS + SCHEMA_FILE_NAME);
        } else if (OsUtil.isMac() || OsUtil.isUnix() || OsUtil.isSolaris()) {
            xjcOutput = runCommand(NX_XJC_PATH + " -d " + distPath +
                    " -p " + ENTITIES_PACKAGE + XJC_FLAGS + SCHEMA_FILE_NAME);
        } else {
            throw new RuntimeException("unsupported OS.");
        }

        if (xjcOutput == null ||
                !xjcOutput.startsWith("parsing a schema...compiling a schema...")) {
            throw new RuntimeException("xjc codegen failed: " + xjcOutput);
        }
    }

    private void fetchScema(HttpProxyBroker httpProxy) throws ServerException,
            JAXBException, IOException {
        PrintWriter out = null;
        String schema = httpProxy.get(SCHEMA_URL);
        if (schema != null && !schema.equals("")) {
            try {
                out = new PrintWriter(SCHEMA_FILE_NAME);
                out.println(schema);
            } finally {
                if (out != null) {
                    out.close();
                }
            }
        } else {
            throw new RuntimeException("xsd schema download failed.");
        }
    }

    /**
     * Runs system command
     * 
     * @param command
     *            command to run
     * 
     * @return command output
     * 
     * @throws IOException
     */
    private String runCommand(String command) throws IOException {
        String stdout = "";
        String stderr = "";
        String s = null;

        Process p = Runtime.getRuntime().exec(command);

        BufferedReader stdInput = new BufferedReader(new
                InputStreamReader(p.getInputStream()));

        BufferedReader stdError = new BufferedReader(new
                InputStreamReader(p.getErrorStream()));

        while ((s = stdInput.readLine()) != null) {
            stdout += s;
        }

        while ((s = stdError.readLine()) != null) {
            stderr += s;
        }

        if (!stderr.equals(""))
            throw new RuntimeException(stderr);

        return stdout;
    }

    /**
     * Deletes all entities files
     * 
     * @param dir
     *            directory to clean
     */
    @Override
    public void doCleanPackage(String dir) {
        ;
        // delete of the /entities content will
        // break compilation of this project as
        // it has refernces to this package
    }

    /**
     * @return Entities path according to OS
     */
    private static String getEntitiesPath() {
        if (OsUtil.isWindows()) {
            return WINDOWS_ENTITIES_PATH;
        } else if (OsUtil.isMac() || OsUtil.isUnix() || OsUtil.isSolaris()) {
            return NX_ENTITIES_PATH;
        } else {
            throw new RuntimeException("unsupported OS.");
        }
    }

    /**
     * @return Entities absolete path according to OS
     */
    private static String getAbsoleteEntitiesPath() {
        if (OsUtil.isWindows()) {
            return WINDOWS_ENTITIES_PATH + "org\\ovirt\\engine\\sdk\\entities\\";
        } else if (OsUtil.isMac() || OsUtil.isUnix() || OsUtil.isSolaris()) {
            return NX_ENTITIES_PATH + "org/ovirt/engine/sdk/entities/";
        } else {
            throw new RuntimeException("unsupported OS.");
        }
    }

    /**
     * Modifies public getters to return Object so inheriting classes could override them with different signature
     * 
     * @param accessors
     *            a list of possible getter types
     */
    public static void modifyGetters(Map<String, List<String>> accessors) {
        String path = getAbsoleteEntitiesPath();
        processFiles(accessors, path);
    }

    /**
     * Modifies public getters (decorators shadows public getters with own ones)
     * 
     * @param accessors
     *            accessors to be removed (get/set/is)
     * @param path
     *            directory to loook at
     */
    private static void processFiles(Map<String, List<String>> accessors, String path) {
        StringBuffer finalContent, tempContent = new StringBuffer();
        List<String> accessorsToCheck;
        String templateOriginal = "    public $accessor$ get$accessor$() {" + "\n";
        String templateReplace = "    public Object get$accessor$() {" + "\n";
        String placeHolder = "$accessor$";
        boolean isInAccessor = false;

        // change shadowed getters
        for (File file : FileUtils.list(path)) {
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
