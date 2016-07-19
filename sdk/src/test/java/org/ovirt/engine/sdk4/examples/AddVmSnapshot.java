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
import static org.ovirt.engine.sdk4.builders.Builders.snapshot;

import org.ovirt.engine.sdk4.Connection;
import org.ovirt.engine.sdk4.services.SnapshotsService;
import org.ovirt.engine.sdk4.services.VmsService;
import org.ovirt.engine.sdk4.types.Vm;

// This example will connect to the server and add a snapshot to an existing virtual machine:
public class AddVmSnapshot {
    public static void main(String[] args) throws Exception {
        // Create the connection to the server:
        Connection connection = connection()
            .url("https://engine40.example.com/ovirt-engine/api")
            .user("admin@internal")
            .password("redhat123")
            .trustStoreFile("truststore.jks")
            .build();

        // Locate the virtual machines service and use it to find the virtual machine:
        VmsService vmsService = connection.systemService().vmsService();
        Vm vm = vmsService.list().search("name=myvm").send().vms().get(0);

        // Locate the service that manages the snapshots of the virtual machine:
        SnapshotsService snapshotsService = vmsService.vmService(vm.id()).snapshotsService();

        // Add the snapshot:
        snapshotsService.add()
            .snapshot(
                snapshot()
                .description("My snapshot")
            )
            .send();

        // Close the connection to the server:
        connection.close();
    }
}
