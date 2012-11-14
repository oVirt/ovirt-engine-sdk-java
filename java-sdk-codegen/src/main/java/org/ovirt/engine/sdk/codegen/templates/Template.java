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

package org.ovirt.engine.sdk.codegen.templates;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Base Template class
 */
public abstract class Template implements ITemplate {

    private String name;
    private CopyrightTemplate copyrightTemplate;

    private static final String ENCODING = "UTF-8";
    private static final String LINE_SEPARATOR = "line.separator";

    public Template(String name) {
        this.name = name;
        copyrightTemplate = new CopyrightTemplate();
    }

    /**
     * Loads template in given context
     */
    public String loadTemplate() {
        try {
            return readFileTemplate();
        } catch (FileNotFoundException e) {
            // TODO: Log error
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Reads actual template file
     * 
     * @return template content
     * 
     * @throws FileNotFoundException
     */
    private String readFileTemplate() throws FileNotFoundException {
        StringBuilder text = new StringBuilder();
        String NL = System.getProperty(LINE_SEPARATOR);
        Scanner scanner = new Scanner(new FileInputStream(this.name), ENCODING);
        try {
            while (scanner.hasNextLine()) {
                text.append(scanner.nextLine() + NL);
            }
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
        return text.toString();
    }

    /**
     * @return template name
     */
    protected String getName() {
        return name;
    }

    /**
     * @return CopyrightTemplate
     */
    protected String getCopyrightTemplate() {
        return copyrightTemplate.getCopyright();
    }
}
