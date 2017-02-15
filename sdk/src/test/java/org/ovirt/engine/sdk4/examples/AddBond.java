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
import static org.ovirt.engine.sdk4.builders.Builders.bonding;
import static org.ovirt.engine.sdk4.builders.Builders.hostNic;
import static org.ovirt.engine.sdk4.builders.Builders.ip;
import static org.ovirt.engine.sdk4.builders.Builders.ipAddressAssignment;
import static org.ovirt.engine.sdk4.builders.Builders.network;
import static org.ovirt.engine.sdk4.builders.Builders.networkAttachment;
import static org.ovirt.engine.sdk4.builders.Builders.option;

import org.ovirt.engine.sdk4.Connection;
import org.ovirt.engine.sdk4.services.HostService;
import org.ovirt.engine.sdk4.services.HostsService;
import org.ovirt.engine.sdk4.types.BootProtocol;
import org.ovirt.engine.sdk4.types.Host;

// This example configures the networking of a host, adding a bonded interface and attaching it to a network with an
// static IP address.
public class AddBond {
    public static void main(String[] args) throws Exception {
        // Create the connection to the server:
        Connection connection = connection()
            .url("https://engine42.example.com/ovirt-engine/api")
            .user("admin@internal")
            .password("redhat123")
            //.trustStoreFile("truststore.jks")
            .insecure(true)
            .build();

        // Find the service that manages the collection of hosts:
        HostsService hostsService = connection.systemService().hostsService();

        // Find the host:
        Host host = hostsService.list()
            .search("name=myhost")
            .send()
            .hosts()
            .get(0);

        // Find the service that manages the host:
        HostService hostService = hostsService.hostService(host.id());

        // Configure the host adding a bond with two slaves, and attaching it to a network with an static IP address:
        hostService.setupNetworks()
            .modifiedBonds(
                hostNic()
                .name("bond0")
                .bonding(
                    bonding()
                    .options(
                        option().name("mode").value("1"),
                        option().name("miimon").value("100")
                    )
                    .slaves(
                        hostNic().name("eth0"),
                        hostNic().name("eth1")
                    )
                )
            )
            .modifiedNetworkAttachments(
                networkAttachment()
                .network(
                    network().name("mynetwork")
                )
                .ipAddressAssignments(
                    ipAddressAssignment()
                    .assignmentMethod(BootProtocol.STATIC)
                    .ip(
                        ip()
                        .address("192.168.122.100")
                        .netmask("255.255.255.0")
                    )
                )
            )
            .send();

        // After modifying the network configuration it is very important to make it persistent:
        hostService.commitNetConfig().send();

        // Close the connection to the server:
        connection.close();
    }
}
