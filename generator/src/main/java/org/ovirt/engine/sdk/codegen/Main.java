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

package org.ovirt.engine.sdk.codegen;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.ovirt.engine.sdk.codegen.rsdl.RsdlCodegen;
import org.ovirt.engine.sdk.codegen.xsd.XsdCodegen;
import org.ovirt.engine.sdk.codegen.xsd.XsdData;

public class Main {
    private static final String DIST_PATH = "../sdk/src/main/java";

    public static void main(String[] args) throws IOException, JAXBException {
        // Parse the command line parameters:
        String xsdPath = null;
        String xjbPath = null;
        String rsdlPath = null;
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
            case "--xsd":
                i++;
                if (i < args.length) {
                    xsdPath = args[i];
                }
                break;
            case "--xjb":
                i++;
                if (i < args.length) {
                    xjbPath = args[i];
                }
                break;
            case "--rsdl":
                i++;
                if (i < args.length) {
                    rsdlPath = args[i];
                }
                break;
            default:
                System.err.println("Unknown command line parameter \"" + args[i] + "\".");
                System.exit(1);
            }
        }
        if (xsdPath == null || xjbPath == null || rsdlPath == null) {
            System.err.println("Missing required parameters.");
            System.exit(1);
        }

        // Adjust the destination path to the platform:
        String distPath = DIST_PATH.replace('/', File.separatorChar);

        // Load and analyze the XML schema:
        XsdData.getInstance().load(xsdPath);

        // Generate entities classes:
        new XsdCodegen(xsdPath, xjbPath).generate(distPath);

        // Generate decorator classes:
        new RsdlCodegen(rsdlPath).generate(distPath);
    }
}
