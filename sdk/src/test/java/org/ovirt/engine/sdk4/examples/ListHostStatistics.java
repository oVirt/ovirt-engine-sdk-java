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
import org.ovirt.engine.sdk4.services.HostsService;
import org.ovirt.engine.sdk4.types.Host;
import org.ovirt.engine.sdk4.types.Statistic;

// This example shows to to get host statistics.
public class ListHostStatistics {
    public static void main(String[] args) throws Exception {
        // Create the connection to the server:
        Connection connection = connection()
            .url("https://engine40.example.com/ovirt-engine/api")
            .user("admin@internal")
            .password("redhat123")
            .trustStoreFile("truststore.jks")
            .build();

        // Find the host:
        HostsService hostsService = connection.systemService().hostsService();
        Host host = hostsService.list()
            .search("name=myhost")
            .send()
            .hosts()
            .get(0);

        // Follow the link to the statistics and print their names and values:
        List<Statistic> stats = connection.followLink(host.statistics());
        for (Statistic stat : stats) {
            System.out.printf("%s: %s\n", stat.name(), stat.values().get(0).datum());
        }

        // Close the connection to the server:
        connection.close();
    }
}
