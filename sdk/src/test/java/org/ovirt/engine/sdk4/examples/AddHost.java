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
import static org.ovirt.engine.sdk4.builders.Builders.host;

import org.ovirt.engine.sdk4.Connection;
import org.ovirt.engine.sdk4.services.HostService;
import org.ovirt.engine.sdk4.services.HostsService;
import org.ovirt.engine.sdk4.types.Host;

// This example will connect to the server and add a new host:
public class AddHost {
    public static void main(String[] args) throws Exception {
        // Create the connection to the server:
        Connection connection = connection()
            .url("https://engine40.example.com/ovirt-engine/api")
            .user("admin@internal")
            .password("redhat123")
            .keyStorePath("keystore.jks")
            .build();

        // Get the reference to the hosts service:
        HostsService hostsService = connection.systemService().hostsService();

        // Add the host:
        Host host = hostsService.add()
            .host(
                host()
                .name("myhost")
                .description("My host")
                .address("node40.example.com")
                .rootPassword("readhat123")
                .cluster(
                    cluster()
                    .name("mycluster")
                )
            )
            .send()
            .host();

        // Wait till the host is up:
        HostService hostService = hostsService.hostService(host.id());
        for (;;) {
            Thread.sleep(5 * 1000);
            host = hostService.get().send().host();
            String state = host.status().state();
            if ("up".equals(state)) {
                break;
            }
        }

        // Close the connection to the server:
        connection.close();
    }
}
