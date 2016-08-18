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
import static org.ovirt.engine.sdk4.builders.Builders.cluster;
import static org.ovirt.engine.sdk4.builders.Builders.template;
import static org.ovirt.engine.sdk4.builders.Builders.vm;

import org.ovirt.engine.sdk4.Connection;
import org.ovirt.engine.sdk4.services.VmsService;

// This example will connect to the server and create a new virtual
// machine from a template. The disks of the new virtual machine will
// be cloned, so that it will be independent of the template.
public class AddIndependentVm {
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

        // Use the "clone" parameter of the "add" method to request that the
        // disks of the new virtual machine are independent of the template.
        vmsService.add()
            .vm(
                vm()
                    .name("myvm")
                    .cluster(
                        cluster()
                            .name("mycluster")
                    )
                    .template(
                        template()
                            .name("mytemplate")
                    )
            )
            .clone_(true)
            .send();

        // Close the connection to the server:
        connection.close();
    }
}