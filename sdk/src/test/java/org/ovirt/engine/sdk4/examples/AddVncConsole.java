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
import static org.ovirt.engine.sdk4.builders.Builders.graphicsConsole;

import java.util.List;

import org.ovirt.engine.sdk4.Connection;
import org.ovirt.engine.sdk4.services.VmGraphicsConsolesService;
import org.ovirt.engine.sdk4.services.VmService;
import org.ovirt.engine.sdk4.services.VmsService;
import org.ovirt.engine.sdk4.types.GraphicsConsole;
import org.ovirt.engine.sdk4.types.GraphicsType;
import org.ovirt.engine.sdk4.types.Vm;

// This example checks if a virtual machine has a VNC console, and adds it if it doesn't.
public class AddVncConsole {
    public static void main(String[] args) throws Exception {
        // Create the connection to the server:
        Connection connection = connection()
            .url("https://engine40.example.com/ovirt-engine/api")
            .user("admin@internal")
            .password("redhat123")
            .trustStoreFile("truststore.jks")
            .build();

        // Find the virtual machine:
        VmsService vmsService = connection.systemService().vmsService();
        Vm vm = vmsService.list()
            .search("name=myvm")
            .send()
            .vms()
            .get(0);
        VmService vmService = vmsService.vmService(vm.id());

        // Find the graphics consoles of the virtual machine:
        VmGraphicsConsolesService consolesService = vmService.graphicsConsolesService();
        List<GraphicsConsole> consoles = consolesService.list()
            .send()
            .consoles();

        // Add a VNC console if it doesn't exist:
        GraphicsConsole console = null;
        for (GraphicsConsole c : consoles) {
            if (c.protocol() == GraphicsType.VNC) {
                console = c;
                break;
            }
        }
        if (console == null) {
            consolesService.add()
                .console(
                    graphicsConsole()
                    .protocol(GraphicsType.VNC)
                )
                .send();
        }

        // Close the connection to the server:
        connection.close();
    }
}
