//
// Copyright (c) 2015 Red Hat, Inc.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
//

package org.ovirt.engine.sdk.generator;

import org.ovirt.engine.sdk.generator.utils.Tree;

import java.util.HashSet;
import java.util.Set;

import static java.util.stream.Collectors.joining;

/**
 * This class contains methods that implements various rules and calculations associated with broker class names, like
 * calculating the name of the broker class corresponding to a location.
 */
public class BrokerRules {
    /**
     * Calculate the name of the broker class that will be generated for the entity or collection represented by the
     * given location.
     *
     * @param tree the location whose broker name will be calculated
     * @return the name of the broker class, or {@code null} if it can't be determined
     */
    public static String getBrokerType(Tree<Location> tree) {
        // The name of a broker type is calculated concatenating the types of all the parent entity resources (not the
        // collections, as they are redundant) and the name of the resource itself:
        return tree.getBranch().stream()
            .skip(1)
            .filter(x -> LocationRules.isEntity(x) || x == tree)
            .map(SchemaRules::getSchemaType)
            .collect(joining());
    }

    /**
     * Returns the name of the method corresponding to an action.
     *
     * @param tree the location of the action
     * @return the name of the method
     */
    public static String getActionMethod(Tree<Location> tree) {
        // Usually the name of the method will just be the name of the tree:
        String name = LocationRules.getName(tree);

        // But in some cases there may be a conflict with Java reserved words. In these cases we add the name of the
        // parent as a suffix. For example, the action to import a disk should be named "import", but that conflicts
        // with the Java "import" reserved word, so it will be renamed to "importDisk".
        if (ACTION_METHOD_EXCEPTIONS.contains(name)) {
            String parent = LocationRules.getName(tree.getParent());
            name += Character.toUpperCase(parent.charAt(0)) + parent.substring(1);
        }

        return name;
    }

    /**
     * These exceptions are needed in order to avoid clashes between the action names and the Java reserved
     * words. The world {@code export} isn't actually a Java reserved word, but it has been considered as such
     * in the past, so it can't be removed now as it would change the name of the {@code exportDisk} action.
     */
    private static final Set<String> ACTION_METHOD_EXCEPTIONS = new HashSet<>();

    static {
        ACTION_METHOD_EXCEPTIONS.add("export");
        ACTION_METHOD_EXCEPTIONS.add("import");
    }
}
