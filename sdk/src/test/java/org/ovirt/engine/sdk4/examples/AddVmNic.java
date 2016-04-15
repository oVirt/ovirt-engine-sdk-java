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
import static org.ovirt.engine.sdk4.builders.Builders.disk;
import static org.ovirt.engine.sdk4.builders.Builders.storageDomain;

import org.ovirt.engine.sdk4.Connection;
import org.ovirt.engine.sdk4.services.VmDiskService;
import org.ovirt.engine.sdk4.services.VmDisksService;
import org.ovirt.engine.sdk4.services.VmsService;
import org.ovirt.engine.sdk4.types.Disk;
import org.ovirt.engine.sdk4.types.DiskFormat;
import org.ovirt.engine.sdk4.types.DiskInterface;
import org.ovirt.engine.sdk4.types.Vm;

// This example will connect to the server and add a disk to an existing virtual machine:
public class AddVmNic {
    public static void main(String[] args) throws Exception {
        // Create the connection to the server:
        Connection connection = connection()
            .url("https://engine40.example.com/ovirt-engine/api")
            .user("admin@internal")
            .password("redhat123")
            .keyStorePath("keystore.jks")
            .build();

        // Locate the virtual machines service and use it to find the virtual machine:
        VmsService vmsService = connection.systemService().vmsService();
        Vm vm = vmsService.list().search("name=myvm").send().vms().get(0);

        // Locate the service that manages the disks of the virtual machine:
        VmDisksService disksService = vmsService.vmService(vm.id()).disksService();

        // Use the "add" method of the disks service to add the disk:
        Disk disk = disksService.add()
            .disk(
                disk()
                .name("mydisk")
                .description("My disk")
                .interface_(DiskInterface.VIRTIO)
                .format(DiskFormat.COW)
                .provisionedSize(1 * (int) Math.pow(2, 20))
                .storageDomains(
                    storageDomain()
                    .name("myadata")
                )
            )
            .send()
            .disk();

        // Wait till the disk is OK:
        VmDiskService diskService = disksService.diskService(disk.id());
        for (;;) {
            Thread.sleep(5 * 1000);
            disk = diskService.get().send().disk();
            String state = disk.status().state();
            if ("unattached".equals(state)) {
                break;
            }
        }

        // Close the connection to the server:
        connection.close();
    }
}
