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
import static org.ovirt.engine.sdk4.builders.Builders.console;
import static org.ovirt.engine.sdk4.builders.Builders.vm;

import org.ovirt.engine.sdk4.Connection;
import org.ovirt.engine.sdk4.services.VmService;
import org.ovirt.engine.sdk4.services.VmsService;
import org.ovirt.engine.sdk4.types.Vm;

// This example will connect to the server, find a virtual machine and enable the serial console if it isn't
// enabled yet:
public class EnableSerialConsole {
    public static void main(String[] args) throws Exception {
        // Create the connection to the server:
        Connection connection = connection()
            .url("https://engine40.example.com/ovirt-engine/api")
            .user("admin@internal")
            .password("redhat123")
            .trustStoreFile("truststore.jks")
            .build();

        // Find the virtual machine. Note the use of the  `all_content` parameter, it is required in order to obtain
        // additional information that isn't retrieved by default, like the configuration of the serial console.
        VmsService vmsService = connection.systemService().vmsService();
        Vm vm = vmsService.list()
            .search("name=myvm")
            .allContent(true)
            .send()
            .vms()
            .get(0);

        // Check if the serial console is enabled, and if it isn't then update the virtual machine to enable it:
        if (!vm.console().enabled()) {
            VmService vmService = vmsService.vmService(vm.id());
            vmService.update()
                .vm(
                    vm()
                    .console(
                        console()
                        .enabled(true)
                    )
                )
                .send();
        }

        // Close the connection to the server:
        connection.close();
    }
}
