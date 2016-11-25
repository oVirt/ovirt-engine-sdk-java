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

import java.util.HashMap;
import java.util.Map;

import org.ovirt.engine.sdk4.Connection;
import org.ovirt.engine.sdk4.services.SnapshotDisksService;
import org.ovirt.engine.sdk4.services.SnapshotService;
import org.ovirt.engine.sdk4.services.SnapshotsService;
import org.ovirt.engine.sdk4.services.StorageDomainsService;
import org.ovirt.engine.sdk4.services.SystemService;
import org.ovirt.engine.sdk4.services.VmService;
import org.ovirt.engine.sdk4.services.VmsService;
import org.ovirt.engine.sdk4.types.Disk;
import org.ovirt.engine.sdk4.types.Snapshot;
import org.ovirt.engine.sdk4.types.StorageDomain;
import org.ovirt.engine.sdk4.types.Vm;

/*
 This example will connect to the server and list all the snapshots that exist on the system. The output will be
 similar to this:

 myvm:My first snapshot:mydisk:mydata
 myvm:My second snapshot:mydisk:mydata
 yourvm:Your first snapshot:yourdisk:yourdata
 ...

 The first column is the name of the virtual machine. The second is the name of the snapshot. The third one is the
 name of the disk. The fourth one is the name of the storage domain where the disk is stored.
*/
public class ListVmSnapshots {
    public static void main(String[] args) throws Exception {
        // Create the connection to the server:
        Connection connection = connection()
            .url("https://engine40.example.com/ovirt-engine/api")
            .user("admin@internal")
            .password("redhat123")
            .trustStoreFile("truststore.jks")
            .build();

        // Get the reference to the root service:
        SystemService systemService = connection.systemService();

        // Find all the virtual machines and store the id and name in a
        // map, so that looking them up later will be faster:
        VmsService vmsService = systemService.vmsService();
        Map<String, String> vmsMap = new HashMap<>();
        for (Vm vm : vmsService.list().send().vms()) {
            vmsMap.put(vm.id(), vm.name());
        }

        // Same for storage domains:
        StorageDomainsService storageDomainsService = systemService.storageDomainsService();
        Map<String, String> storageDomainsMap = new HashMap<>();
        for (StorageDomain sd : storageDomainsService.list().send().storageDomains()) {
            storageDomainsMap.put(sd.id(), sd.name());
        }

        // For each virtual machine find its snapshots, then for each snapshot
        // find its disks:
        for (Map.Entry<String, String> vm : vmsMap.entrySet()) {
            VmService vmService = vmsService.vmService(vm.getKey());
            SnapshotsService snapshotsService = vmService.snapshotsService();
            Map<String, String> snapshotsMap = new HashMap<>();
            for (Snapshot snapshot : snapshotsService.list().send().snapshots()) {
                snapshotsMap.put(snapshot.id(), snapshot.description());
            }

            for (Map.Entry<String, String> snapshot : snapshotsMap.entrySet()) {
                SnapshotService snapshotService = snapshotsService.snapshotService(snapshot.getKey());
                SnapshotDisksService snapshotDisksService = snapshotService.disksService();
                for (Disk disk : snapshotDisksService.list().send().disks()) {
                    if (disk.storageDomains().size() > 0) {
                        String storageDomainId = disk.storageDomains().get(0).id();
                        String storageDomainName = storageDomainsMap.get(storageDomainId);
                        System.out.printf(
                            "%s:%s:%s:%s\n",
                            vm.getValue(),
                            snapshot.getValue(),
                            disk.alias(),
                            storageDomainName
                        );
                    }
                }
            }
        }

        // Close the connection to the server:
        connection.close();
    }
}