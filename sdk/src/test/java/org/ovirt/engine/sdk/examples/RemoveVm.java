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

package org.ovirt.engine.sdk.examples;

import static org.ovirt.engine.sdk.ConnectionBuilder.connection;

import org.ovirt.engine.sdk.Connection;
import org.ovirt.engine.sdk.services.VmService;
import org.ovirt.engine.sdk.services.VmsService;
import org.ovirt.engine.sdk.types.Vm;

// This example will connect to the server, search for a VM by name and remove it:
public class RemoveVm {
    public static void main(String[] args) throws Exception {
        // Create the connection to the server:
        Connection connection = connection()
            .url("https://engine40.example.com/ovirt-engine/api")
            .user("admin@internal")
            .password("redhat123")
            .keyStorePath("keystore.jks")
            .build();

        // Find the service that manages VMs:
        VmsService vmsService = connection.systemService().vmsService();

        // Find the VM:
        Vm vm = vmsService.list()
            .search("name=myvm")
            .send()
            .vms()
            .get(0);

        // Note that the "vm" variable that we assigned above contains only the data of the VM, it doesn't have any
        // method like "remove". Methods are defined in the services. So now that we have the description of the VM
        // we can find the service that manages it, calling the locator method "vmService" defined in the "vms"
        // service. This locator method receives as parameter the identifier of the VM and returns a reference to the
        // service that manages that VM.
        VmService vmService = vmsService.vmService(vm.id());

        // Now that we have the reference to the service that manages the VM we can use it to remove the VM. Note that
        // this method doesn't need any parameter, as the identifier of the VM is already known by the service that we
        // located in the previous step.
        vmService.remove().send();

        // Close the connection to the server:
        connection.close();
    }
}
