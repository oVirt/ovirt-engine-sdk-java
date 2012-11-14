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
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.xml.bind.JAXBException;

import org.apache.http.client.ClientProtocolException;
import org.ovirt.engine.sdk.codegen.common.ICodegen;
import org.ovirt.engine.sdk.exceptions.ServerException;
import org.ovirt.engine.sdk.web.HttpProxyBroker;

/**
 * Provides XSD schema related services
 */
public class XsdCodegen implements ICodegen {

    private static final String SCHEMA_URL = "?schema";
    private static final String OS = System.getProperty("os.name").toLowerCase();

    private static final String WINDOWS_XJC_PATH = "%java_home%\\bin\\xjc";
    private static final String NX_XJC_PATH = "xjc";

    private static final String WINDOWS_ENTITIES_PACKAGE = "..\\java-sdk\\src\\main\\java\\";
    private static final String NX_ENTITIES_PACKAGE = "../java-sdk/src/main/java/";

    private static final String ENTITIES_PACKAGE = "org.ovirt.engine.sdk.entities";
    private static final String SCHEMA_FILE_NAME = "api.xsd";
    private static final String XJC_FLAGS = " -extension -no-header ";

    private HttpProxyBroker httpProxy;

    public XsdCodegen(HttpProxyBroker httpProxy) {
        this.httpProxy = httpProxy;
    }

    /**
     * Generates Java classes from the schema
     * 
     * @param httpProxy
     *            HttpProxy to use for schema download
     * 
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws IOException
     * @throws JAXBException
     */
    public void generate() throws ClientProtocolException,
            ServerException, IOException, JAXBException {

        String xjcOutput = null;

        fetchScema(this.httpProxy);

        if (isWindows()) {
            xjcOutput = runCommand(WINDOWS_XJC_PATH + " -d " + WINDOWS_ENTITIES_PACKAGE +
                    " -p " + ENTITIES_PACKAGE + XJC_FLAGS + SCHEMA_FILE_NAME);
        } else if (isMac() || isUnix() || isSolaris()) {
            xjcOutput = runCommand(NX_XJC_PATH + " -d " + NX_ENTITIES_PACKAGE +
                    " -p " + ENTITIES_PACKAGE + XJC_FLAGS + SCHEMA_FILE_NAME);
        } else {
            throw new RuntimeException("unsupported OS.");
        }

        if (!xjcOutput.startsWith("parsing a schema...compiling a schema...")) {
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

    private boolean isWindows() {

        return (OS.indexOf("win") >= 0);

    }

    private boolean isMac() {

        return (OS.indexOf("mac") >= 0);

    }

    private boolean isUnix() {

        return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0);

    }

    private boolean isSolaris() {

        return (OS.indexOf("sunos") >= 0);

    }
}
