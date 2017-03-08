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

import java.util.List;

import org.ovirt.engine.sdk4.Connection;
import org.ovirt.engine.sdk4.services.SystemService;
import org.ovirt.engine.sdk4.services.VmGraphicsConsoleService;
import org.ovirt.engine.sdk4.services.VmGraphicsConsolesService;
import org.ovirt.engine.sdk4.services.VmService;
import org.ovirt.engine.sdk4.services.VmsService;
import org.ovirt.engine.sdk4.types.GraphicsConsole;
import org.ovirt.engine.sdk4.types.GraphicsType;
import org.ovirt.engine.sdk4.types.Ticket;
import org.ovirt.engine.sdk4.types.Vm;

// This example shows how to get a display ticket for a virtual machine. Note that a virtual machine may have multiple
// graphics consoles, each one implementing a different access protocol. For example, the same machine may have VNC
// and SPICE graphics consoles enabled simultaneously. In order to get a ticket the access protocol has to be selected
// explicitly.
public class GetDisplayTicket {
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

        // Find the service that manages the graphics consoles of the virtual machine:
        VmService vmService = vmsService.vmService(vm.id());
        VmGraphicsConsolesService consolesService = vmService.graphicsConsolesService();

        // The method that lists the graphics consoles doesn't support search, so in order to find the console
        // corresponding to the access protocol that we are interested on (SPICE in this example) we need to get all of
        // them and filter explicitly. In addition the `current` parameter must be `true`, as otherwise you will *not*
        // get important values like the `address` and `port` where the console is available.
        List<GraphicsConsole> consoles = consolesService.list()
            .current(true)
            .send()
            .consoles();
        GraphicsConsole console = null;
        for (GraphicsConsole c : consoles) {
            if (c.protocol() == GraphicsType.SPICE) {
                console = c;
                break;
            }
        }

        // Find the service that manages the graphics console that was selected in the previous step:
        VmGraphicsConsoleService consoleService = consolesService.consoleService(console.id());

        // Request the ticket. The virtual machine must be up and running, as it doesn't make sense to get a console
        // ticket for a virtual machine that is down. If you try that, the request will fail.
        Ticket ticket = consoleService.ticket()
            .send()
            .ticket();

        // Print the details needed to connect to the console (the ticket value is the password):
        System.out.printf("address: %s\n", console.address());
        System.out.printf("port: %d\n", console.port());
        System.out.printf("tls_port: %d\n", console.tlsPort());
        System.out.printf("password: %s\n", ticket.value());

        // Close the connection to the server:
        connection.close();
    }
}
