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

import java.io.FileNotFoundException;

import org.ovirt.engine.sdk.codegen.utils.FileUtils;
import org.ovirt.engine.sdk.codegen.utils.OsUtil;

/**
 * Base Template class
 */
public abstract class AbstractTemplate implements ITemplate {

    private String name;
    private String template;
    private String copyrightTemplate;

    private static final String NX_TEMPLATES_PATH =
            "/src/main/java/org/ovirt/engine/sdk/codegen/templates/";
    private static final String WINDOWS_TEMPLATES_PATH =
            "\\src\\main\\java\\org\\ovirt\\engine\\sdk\\codegen\\templates\\";

    /**
     * Generic .ctr
     */
    public AbstractTemplate() {
        this.name = getClass().getSimpleName();
        this.template = loadTemplate();
        this.copyrightTemplate = new CopyrightTemplate(true).getTemplate();
    }

    /**
     * Invoke this .ctr when no need to fetch CopyrightTemplate
     * 
     * @param noCopyrightTemplate
     *            true/false
     */
    public AbstractTemplate(boolean noCopyrightTemplate) {
        this.name = getClass().getSimpleName();
        this.template = loadTemplate();
        if (!noCopyrightTemplate) {
            this.copyrightTemplate = new CopyrightTemplate(true).getTemplate();
        }
    }

    /**
     * Loads template in given context
     * 
     * @return template
     */
    @Override
    public String loadTemplate() {
        try {
            return readFileTemplate();
        } catch (FileNotFoundException e) {
            // TODO: Log error
            e.printStackTrace();
            throw new RuntimeException("Template \"" + getName() + "\" not found.", e);
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
        return FileUtils.getFileContent(getTemplatePath() + getName());
    }

    /**
     * @return this template path
     */
    private String getTemplatePath() {
        String path;

        if (OsUtil.isWindows()) {
            path = System.getProperty("user.dir") + WINDOWS_TEMPLATES_PATH;
        } else if (OsUtil.isMac() || OsUtil.isUnix() || OsUtil.isSolaris()) {
            path = System.getProperty("user.dir") + NX_TEMPLATES_PATH;
        } else {
            throw new RuntimeException("unsupported OS.");
        }
        return path;
    }

    /**
     * @return template name
     */
    protected String getName() {
        return this.name;
    }

    /**
     * @return CopyrightTemplate
     */
    protected String getCopyrightTemplate() {
        return this.copyrightTemplate;
    }

    /**
     * @return abstract template form
     */
    public String getTemplate() {
        return this.template;
    }
}
