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

import org.ovirt.engine.sdk.codegen.rsdl.BrokerRules;
import org.ovirt.engine.sdk.codegen.rsdl.Location;
import org.ovirt.engine.sdk.codegen.rsdl.SchemaRules;
import org.ovirt.engine.sdk.codegen.utils.Tree;

public class SubCollectionGetterTemplate extends AbstractTemplate {
    public String evaluate(Tree<Location> collectionTree) {
        String brokerType = BrokerRules.getBrokerType(collectionTree);
        String collectionType = SchemaRules.getSchemaType(collectionTree);
        String fieldName = Character.toLowerCase(brokerType.charAt(0)) + brokerType.substring(1);

        set("broker_type", brokerType);
        set("collection_type", collectionType);
        set("field_name", fieldName);

        return evaluate();
    }
}
