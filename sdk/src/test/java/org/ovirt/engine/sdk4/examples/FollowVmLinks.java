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
import org.ovirt.engine.sdk4.services.VmsService;
import org.ovirt.engine.sdk4.types.Cluster;
import org.ovirt.engine.sdk4.types.Permission;
import org.ovirt.engine.sdk4.types.Template;
import org.ovirt.engine.sdk4.types.Vm;

// This example will connect to the server, retrieve the detail of a virtual machine and then it will follow the links
// to the permissions of the virtual machine:
public class FollowVmLinks {
    public static void main(String[] args) throws Exception {
        // Create the connection to the server:
        Connection connection = connection()
            .url("https://engine40.example.com/ovirt-engine/api")
            .user("admin@internal")
            .password("redhat123")
            .trustStoreFile("truststore.jks")
            .build();

        // Get the reference to the service that manages virtual machines:
        VmsService vmsService = connection.systemService().vmsService();

        // Find the virtual machine:
        Vm vm = vmsService.list()
            .search("name=myvm")
            .send()
            .vms()
            .get(0);

        // When the server returns a virtual machine it will return links to related objects, like the cluster,
        // template and permissions something like this:
        //
        // <link href="/api/vms/123/permissions" rel="permissions"/>
        // ...
        // <cluster id="123" href="/api/clusters/123"/>
        // <template id="456" href="/api/templates/456"/>
        //
        // The SDK provides a "followLink" method that can be used to retrieve the complete content of these related
        // objects.
        Cluster cluster = connection.followLink(vm.cluster());
        Template template = connection.followLink(vm.template());
        List<Permission> permissions = connection.followLink(vm.permissions());

        // Now we can use the details of the cluster, template and permissions:
        System.out.printf("cluster: %s\n", cluster.name());
        System.out.printf("template: %s\n", template.name());
        for (Permission permission : permissions) {
            System.out.printf("role: %s\n", permission.role().id());
        }

        // Close the connection to the server:
        connection.close();
    }
}
