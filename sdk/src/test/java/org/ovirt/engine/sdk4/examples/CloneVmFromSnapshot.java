/*
Copyright (c) 2017 Red Hat, Inc.

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
import static org.ovirt.engine.sdk4.builders.Builders.cluster;
import static org.ovirt.engine.sdk4.builders.Builders.snapshot;
import static org.ovirt.engine.sdk4.builders.Builders.vm;

import java.util.List;
import java.util.Objects;

import org.ovirt.engine.sdk4.Connection;
import org.ovirt.engine.sdk4.services.SnapshotsService;
import org.ovirt.engine.sdk4.services.SystemService;
import org.ovirt.engine.sdk4.services.VmService;
import org.ovirt.engine.sdk4.services.VmsService;
import org.ovirt.engine.sdk4.types.Snapshot;
import org.ovirt.engine.sdk4.types.Vm;
import org.ovirt.engine.sdk4.types.VmStatus;

// This example shows how to clone a virtual machine from an snapshot.
public class CloneVmFromSnapshot {
    public static void main(String[] args) throws Exception {
        // Create the connection to the server:
        Connection connection = connection()
            .url("https://engine40.example.com/ovirt-engine/api")
            .user("admin@internal")
            .password("redhat123")
            .trustStoreFile("truststore.jks")
            .build();

        // Get the reference to the root of the tree of services:
        SystemService systemService = connection.systemService();

        // Find the virtual machine:
        VmsService vmsService = systemService.vmsService();
        Vm vm = vmsService.list()
            .search("name=myvm")
            .send()
            .vms()
            .get(0);

        // Find the service that manages the virtual machine:
        VmService vmService = vmsService.vmService(vm.id());

        // Find the snapshot. Note that the snapshots collection doesn't support search, so we need to retrieve the
        // complete list and the look for the snapshot that has the description that we are looking for.
        SnapshotsService snapsService = vmService.snapshotsService();
        List<Snapshot> snaps = snapsService.list()
            .send()
            .snapshots();
        Snapshot snap = null;
        for (Snapshot s : snaps) {
            if (Objects.equals(s.description(), "mysnap")) {
                snap = s;
                break;
            }
        }

        // Create a new virtual machine, cloning it from the snapshot:
        Vm clonedVm = vmsService.add()
            .vm(
                vm()
                .name("myclonedvm")
                .snapshots(
                    snapshot()
                    .id(snap.id())
                )
                .cluster(
                    cluster()
                    .name("mycluster")
                )
            )
            .send()
            .vm();

        // Find the service that manages the cloned virtual machine:
        VmService clonedVmService = vmsService.vmService(clonedVm.id());

        // Wait till the virtual machine is down, as that means that the creation of the disks has been completed:
        for (;;) {
            Thread.sleep(5 * 1000);
            clonedVm = clonedVmService.get().send().vm();
            if (clonedVm.status() == VmStatus.DOWN) {
                break;
            }
        }

        // Close the connection to the server:
        connection.close();
    }
}
