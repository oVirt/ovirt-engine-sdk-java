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
import static org.ovirt.engine.sdk4.builders.Builders.dataCenter;
import static org.ovirt.engine.sdk4.builders.Builders.network;
import static org.ovirt.engine.sdk4.builders.Builders.vlan;

import java.util.Arrays;

import org.ovirt.engine.sdk4.Connection;
import org.ovirt.engine.sdk4.services.NetworksService;
import org.ovirt.engine.sdk4.types.NetworkUsage;

// This example will connect to the server and create new logical network.
public class AddLogicalNetwork {
    public static void main(String[] args) throws Exception {
        // Create the connection to the server:
        Connection connection = connection()
            .url("https://engine40.example.com/ovirt-engine/api")
            .user("admin@internal")
            .password("redhat123")
            .trustStoreFile("truststore.jks")
            .build();

        // Get the reference to the "networks" service:
        NetworksService networksService = connection.systemService().networksService();

        // Use the "add" method to create new VM logical network in data center called "mydatacenter", with VLAN tag
        // 100 and MTU 1500.
        networksService.add()
            .network(
                network()
                .name("mynetwork")
                .description("My logical network")
                .dataCenter(
                    dataCenter()
                    .name("mydatacenter")
                )
                .vlan(
                    vlan()
                    .id(100)
                )
                .usages(Arrays.asList(NetworkUsage.DISPLAY))
                .mtu(1500)
            )
            .send();

        // Close the connection to the server:
        connection.close();
    }
}
