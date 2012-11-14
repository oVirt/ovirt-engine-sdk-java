package org.ovirt.engine.sdk.codegen.templates;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public abstract class Template implements ITemplate {

    private String name;
    private CopyrightTemplate copyrightTemplate;

    public Template(String name) {
        this.name = name;
        copyrightTemplate = new CopyrightTemplate();
    }

    public String loadTemplate() {
        try {
            return readFileTemplate();
        } catch (FileNotFoundException e) {
            // TODO: Log error
            e.printStackTrace();
            return null;
        }
    }

    private String readFileTemplate() throws FileNotFoundException {
        StringBuilder text = new StringBuilder();
        String NL = System.getProperty("line.separator");
        Scanner scanner = new Scanner(new FileInputStream(this.name), "UTF-8");
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

    protected String getName() {
        return name;
    }

    protected String getCopyrightTemplate() {
        return copyrightTemplate.getCopyright();
    }
}
