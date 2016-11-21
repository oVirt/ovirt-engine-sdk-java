/*
Copyright (c) 2016 Red Hat, Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package org.ovirt.engine.sdk4.examples;

import static org.ovirt.engine.sdk4.ConnectionBuilder.connection;
import static org.ovirt.engine.sdk4.builders.Builders.vm;

import org.ovirt.engine.sdk4.Connection;
import org.ovirt.engine.sdk4.services.AffinityLabelService;
import org.ovirt.engine.sdk4.services.AffinityLabelVmsService;
import org.ovirt.engine.sdk4.services.AffinityLabelsService;
import org.ovirt.engine.sdk4.services.VmsService;
import org.ovirt.engine.sdk4.types.AffinityLabel;
import org.ovirt.engine.sdk4.types.Vm;

// This example will connect to the server and assign affinity label to virtual machine:
public class AssignAffinityLabelToVm {
    public static void main(String[] args) throws Exception {
        // Create the connection to the server:
        Connection connection = connection()
            .url("https://engine40.example.com/ovirt-engine/api")
            .user("admin@internal")
            .password("redhat123")
            .trustStoreFile("truststore.jks")
            .build();

        // Get the reference to the "vms" service:
        VmsService vmsService = connection.systemService().vmsService();

        // Find the virtual machine:
        Vm vm = vmsService.list().search("name=myvm").send().vms().get(0);

        // Get the reference to the affinity labels service:
        AffinityLabelsService affinityLabelsService = connection.systemService().affinityLabelsService();

        // Find the id of the affinity label:
        String affinityLabelId = null;
        for (AffinityLabel affinityLabel : affinityLabelsService.list().send().labels()) {
            if (affinityLabel.name().equals("my_affinity_label")) {
                affinityLabelId = affinityLabel.id();
                break;
            }
        }

        // Locate the service that manages the affinity label named `my_affinity_label`:
        AffinityLabelService affinityLabelService = affinityLabelsService.labelService(affinityLabelId);

        // Get the reference to the service that manages the set of virtual machines that have the affinity label
        // named `my_affinity_label` assigned:
        AffinityLabelVmsService affinityLabelVmsService = affinityLabelService.vmsService();

        // Assign affinity label to virtual machine:
        affinityLabelVmsService.add()
            .vm(
                vm()
                .id(vm.id())
            )
            .send();

        // Close the connection to the server:
        connection.close();
    }
}