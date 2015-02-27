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

package org.ovirt.engine.sdk.generator.java.utils;

import org.apache.commons.io.FileUtils;
import org.ovirt.engine.sdk.generator.java.templates.CopyrightTemplate;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Utilities for handling class files.
 */
public class ClassUtils {
    /**
     * The lines of the copyright statement, which will be added to all the generated classes.
     */
    private static final List<String> COPYRIGHT = Arrays.asList(new CopyrightTemplate().evaluate().split("\n"));

    /**
     * Saves the code of a class file.
     *
     * @param distPath the top level directory of the java sources
     * @param className the fully qualified name of the class
     * @param classCode the source code of the class
     */
    public static void saveClass(String distPath, String className, String classCode) throws IOException {
        File classFile = new File(distPath, className.replace('.', File.separatorChar) + ".java");
        List<String> classLines = new ArrayList<>(COPYRIGHT);
        classLines.add("");
        Collections.addAll(classLines, classCode.split("\n"));
        classLines = StringUtils.removeTrailingWhitespace(classLines);
        FileUtils.writeLines(classFile, classLines);
    }
}
