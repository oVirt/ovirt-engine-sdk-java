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
import org.ovirt.engine.sdk4.services.VmDisksService;
import org.ovirt.engine.sdk4.services.VmService;
import org.ovirt.engine.sdk4.services.VmsService;
import org.ovirt.engine.sdk4.types.Disk;
import org.ovirt.engine.sdk4.types.Vm;

// This example will connect to the server and list the disks attached to a virtual machine:
public class ListVmDisks {
    public static void main(String[] args) throws Exception {
        // Create the connection to the server:
        Connection connection = connection()
            .url("https://engine40.example.com/ovirt-engine/api")
            .user("admin@internal")
            .password("redhat123")
            .insecure(true)
            .build();

        // Get the reference to the "vms" service:
        VmsService vmsService = connection.systemService().vmsService();

        // Find the virtual machine:
        Vm vm = vmsService.list().search("name=myvm").send().vms().get(0);

        // Locate the service that manages the virtual machine:
        VmService vmService = vmsService.vmService(vm.id());

        // Locate the service that manages the disks of the virtual machine:
        VmDisksService disksService = vmService.disksService();

        // Retrieve the list of disks, and print them:
        List<Disk> disks = disksService.list().send().disks();
        for (Disk disk : disks) {
            System.out.println(disk.id());
        }

        // Close the connection to the server:
        connection.close();
    }
}
