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
import org.ovirt.engine.sdk4.services.AssignedTagsService;
import org.ovirt.engine.sdk4.services.VmService;
import org.ovirt.engine.sdk4.services.VmsService;
import org.ovirt.engine.sdk4.types.Tag;
import org.ovirt.engine.sdk4.types.Vm;

// This example will connect to the server and list all tags of the virtual machine:
public class ListVmTags {
    public static void main(String[] args) throws Exception {
        // Create the connection to the server:
        Connection connection = connection()
            .url("https://engine40.example.com/ovirt-engine/api")
            .user("admin@internal")
            .password("redhat123")
            .trustStoreFile("truststore.jks")
            .build();

        // Get the reference to the "vms" service:
        VmsService vmsService = connection.systemService().vmsService();

        // Find the virtual machine:
        Vm vm = vmsService.list().search("name=myvm0").send().vms().get(0);

        // Find the service that manages the vm:
        VmService vmService = vmsService.vmService(vm.id());

        // Locate the service that manages the tags of the vm:
        AssignedTagsService tagsService = vmService.tagsService();

        // For each tag print its name and description:
        for (Tag tag : tagsService.list().send().tags()) {
            System.out.printf("%s: %s\n", tag.name(), tag.description());
        }

        // Close the connection to the server:
        connection.close();
    }
}
