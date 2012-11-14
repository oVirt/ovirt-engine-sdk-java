package org.ovirt.engine.sdk.codegen.templates;

public class CopyrightTemplate extends Template {

    private static String NAME = "Copyright";

    public CopyrightTemplate() {
        super(NAME);
    }

    public String getCopyright() {
        return loadTemplate();
    }
}
