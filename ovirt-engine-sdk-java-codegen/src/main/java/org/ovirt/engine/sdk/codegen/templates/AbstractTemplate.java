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

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Base Template class
 */
public abstract class AbstractTemplate implements ITemplate {

    private String name;
    private String template;
    private String copyrightTemplate;

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
        try (InputStream in = this.getClass().getResourceAsStream(name)) {
            if (in == null) {
                throw new RuntimeException("Template \"" + name + "\" not found.");
            }
            try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
                byte[] buffer = new byte[1024];
                int count;
                while ((count = in.read(buffer)) != -1) {
                    out.write(buffer, 0, count);
                }
                return new String(out.toByteArray(), "UTF-8");
            }
        }
        catch (IOException exception) {
            throw new RuntimeException("Error loading template \"" + name + "\".", exception);
        }
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
