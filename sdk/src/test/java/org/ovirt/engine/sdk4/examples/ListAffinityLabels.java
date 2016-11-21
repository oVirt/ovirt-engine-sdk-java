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

import java.util.List;

import org.ovirt.engine.sdk4.Connection;
import org.ovirt.engine.sdk4.services.AffinityLabelsService;
import org.ovirt.engine.sdk4.types.AffinityLabel;
import org.ovirt.engine.sdk4.types.Vm;

// This example will connect to the server and print the names
// and virtual machines of all affinity labels in system:
public class ListAffinityLabels {
    public static void main(String[] args) throws Exception {
        // Create the connection to the server:
        Connection connection = connection()
            .url("https://engine40.example.com/ovirt-engine/api")
            .user("admin@internal")
            .password("redhat123")
            .trustStoreFile("truststore.jks")
            .build();

        // Get the reference to the affinity labels service:
        AffinityLabelsService affinityLabelsService = connection.systemService().affinityLabelsService();

        // Use the "list" method of the affinity labels service
        // to list all the affinity labels of the system:
        List<AffinityLabel> affinityLabels = affinityLabelsService.list().send().labels();

        // Print all affinity labels names and virtual machines
        // which has assigned that affinity label:
        for (AffinityLabel affinityLabel : affinityLabels) {
            System.out.printf("%s:\n", affinityLabel.name());
            for (Vm vm_link : connection.followLink(affinityLabel.vms())) {
                System.out.printf(" - %s\n", connection.followLink(vm_link).name());
            }
        }

        // Close the connection to the server:
        connection.close();
    }
}