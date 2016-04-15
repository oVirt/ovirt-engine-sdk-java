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

import org.ovirt.engine.sdk4.Connection;
import org.ovirt.engine.sdk4.services.VmService;
import org.ovirt.engine.sdk4.services.VmsService;
import org.ovirt.engine.sdk4.types.Vm;

// This example will connect to the server and stop a virtual machine:
public class StopVm {
    public static void main(String[] args) throws Exception {
        // Create the connection to the server:
        Connection connection = connection()
            .url("https://engine40.example.com/ovirt-engine/api")
            .user("admin@internal")
            .password("redhat123")
            .keyStorePath("keystore.jks")
            .build();

        // Get the reference to the "vms" service:
        VmsService vmsService = connection.systemService().vmsService();

        // Find the virtual machine:
        Vm vm = vmsService.list().search("name=myvm").send().vms().get(0);

        // Locate the service that manages the virtual machine, as that is where the action methods are defined:
        VmService vmService = vmsService.vmService(vm.id());

        // Call the "stop" method of the service to stop it:
        vmService.stop().send();

        // What till the virtual machine is up:
        for (;;) {
            Thread.sleep(5 * 1000);
            vm = vmService.get().send().vm();
            String state = vm.status().state();
            if ("down".equals(state)) {
                break;
            }
        }

        // Close the connection to the server:
        connection.close();
    }
}
