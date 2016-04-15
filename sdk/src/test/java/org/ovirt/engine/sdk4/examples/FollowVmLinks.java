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
import org.ovirt.engine.sdk4.services.VmsService;
import org.ovirt.engine.sdk4.types.Cluster;
import org.ovirt.engine.sdk4.types.Template;
import org.ovirt.engine.sdk4.types.Vm;

// This example will connect to the server, retrieve the detail of a virtual machine and then it will follow the link to
// the disks of the virtual machine:
public class FollowVmLinks {
    public static void main(String[] args) throws Exception {
        // Create the connection to the server:
        Connection connection = connection()
            .url("https://engine40.example.com/ovirt-engine/api")
            .user("admin@internal")
            .password("redhat123")
            .keyStorePath("keystore.jks")
            .build();

        // Get the reference to the service that manages virtual machines:
        VmsService vmsService = connection.systemService().vmsService();

        // Find the virtual machine:
        Vm vm = vmsService.list()
            .search("name=myvm")
            .send()
            .vms()
            .get(0);

        // When the server returns a virtual machine it will return links to related objects, like the cluster and the
        // template, something like this:
        //
        // <cluster id="123" href="/api/clusters/123"/>
        // <template id="456" href="/api/templates/456"/>
        //
        // The SDK provides a "followLink" method that can be used to retrieve the complete content of these related
        // objects.
        Cluster cluster = connection.followLink(vm.cluster());
        Template template = connection.followLink(vm.template());

        // Now we can use the details of the cluster and the template:
        System.out.printf("cluster: %s", cluster.name());
        System.out.printf("template: %s", template.name());

        // Close the connection to the server:
        connection.close();
    }
}
