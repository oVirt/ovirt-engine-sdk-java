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

package org.ovirt.engine.sdk.generator.java.templates;

import org.ovirt.engine.sdk.generator.BrokerRules;
import org.ovirt.engine.sdk.generator.Location;
import org.ovirt.engine.sdk.generator.LocationRules;
import org.ovirt.engine.sdk.generator.SchemaRules;
import org.ovirt.engine.sdk.generator.templates.AbstractTemplate;
import org.ovirt.engine.sdk.generator.utils.Tree;

public class SubCollectionGetterTemplate extends AbstractTemplate {
    public String evaluate(Tree<Location> collectionTree) {
        String brokerType = BrokerRules.getBrokerType(collectionTree);
        String fieldName = Character.toLowerCase(brokerType.charAt(0)) + brokerType.substring(1);

        // Some resource have multiple subcollections with different names but the same type. For example, the host
        // NIC resource has two collections named "labels" and "virtualfunctionallowedlabels", and both of type
        // "Labels". This results in duplicated getter names, as the name of the getter is derived from the type, not
        // from the name of the collection. To avoid that issue we need to explicitly handle the exceptions here.
        String getterName = SchemaRules.getSchemaType(collectionTree);
        String collectionName = LocationRules.getName(collectionTree);
        if (collectionName.equals("virtualfunctionallowedlabels")) {
            getterName = "VirtualFunctionAllowedLabels";
        }

        set("broker_type", brokerType);
        set("getter_name", getterName);
        set("field_name", fieldName);

        return evaluate();
    }
}
