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

package org.ovirt.engine.sdk.codegen.rsdl;

import java.io.IOException;

import org.ovirt.engine.sdk.codegen.templates.ApiTemplate;
import org.ovirt.engine.sdk.codegen.utils.ClassUtils;
import org.ovirt.engine.sdk.codegen.utils.Tree;

/**
 * Provides SDK entry point codegen capabilities
 */
public class ApiCodegen {
    /**
     * The name of the API entry point class.
     */
    private static final String API_CLASS = "org.ovirt.engine.sdk.Api";

    /**
     * The root of the tree of locations.
     */
    private Tree<Location> root = new Tree<>();

    public ApiCodegen(Tree<Location> root) {
        this.root = root;
    }

    /**
     * Generates SDK entry point class.
     */
    protected void generate(String distPath) throws IOException {
        String apiCode = new ApiTemplate().evaluate(root);
        ClassUtils.saveClass(distPath, API_CLASS, apiCode);
    }
}
