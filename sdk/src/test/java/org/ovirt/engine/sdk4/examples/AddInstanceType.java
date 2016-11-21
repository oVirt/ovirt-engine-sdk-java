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
import static org.ovirt.engine.sdk4.builders.Builders.cpu;
import static org.ovirt.engine.sdk4.builders.Builders.cpuTopology;
import static org.ovirt.engine.sdk4.builders.Builders.highAvailability;
import static org.ovirt.engine.sdk4.builders.Builders.instanceType;

import java.math.BigInteger;

import org.ovirt.engine.sdk4.Connection;
import org.ovirt.engine.sdk4.services.InstanceTypesService;

// This example will connect to the server and create a new instance type
public class AddInstanceType {
    public static void main(String[] args) throws Exception {
        // Create the connection to the server:
        Connection connection = connection()
            .url("https://engine40.example.com/ovirt-engine/api")
            .user("admin@internal")
            .password("redhat123")
            .trustStoreFile("truststore.jks")
            .build();

        // Get the reference to the instance types service:
        InstanceTypesService instanceTypesService = connection.systemService().instanceTypesService();

        // Add the instance type. Note that the size of the memory, the `memory`
        // attribute, is specified in bytes, so to create a instance type with
        // 2 GiB of memory the value should be 2 * 2^30.
        instanceTypesService.add()
            .instanceType(
                instanceType()
                .name("myinstancetype")
                .description("My instance type")
                .memory(BigInteger.valueOf(2).multiply(BigInteger.valueOf(2).pow(30)))
                .highAvailability(
                    highAvailability()
                    .enabled(true)
                )
                .cpu(
                    cpu()
                    .topology(
                        cpuTopology()
                        .cores(2)
                        .sockets(2)
                    )
                )
            )
            .send();

        // Close the connection to the server:
        connection.close();
    }
}
