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

package org.ovirt.engine.sdk.codegen.compile;

import org.apache.maven.cli.MavenCli;

/**
 * Provides compilation services
 */
public class CodeCompiler implements ICompiler {

    private static final String GOAL = "compile";

    private final String path;
    private final MavenCli mavenCli;

    public CodeCompiler(String path) {
        super();
        this.path = path;
        this.mavenCli = new MavenCli();
    }

    /**
     * Compiles java code where default goal is compile.
     *
     * @return compilation status.
     */
    @Override
    public int compile() {
        return compile(GOAL);
    }

    /**
     * Compiles java code
     *
     * @param goal
     *            compilation goal
     *
     * @return compilation status.
     */
    public int compile(String goal) {
        return this.mavenCli.doMain(
                new String[] { goal },
                this.path,
                System.out,
                System.out);
    }
}
