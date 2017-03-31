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
import static org.ovirt.engine.sdk4.builders.Builders.macPool;
import static org.ovirt.engine.sdk4.builders.Builders.range;

import org.ovirt.engine.sdk4.Connection;
import org.ovirt.engine.sdk4.services.ClusterService;
import org.ovirt.engine.sdk4.services.ClustersService;
import org.ovirt.engine.sdk4.services.MacPoolsService;
import org.ovirt.engine.sdk4.types.Cluster;
import org.ovirt.engine.sdk4.types.MacPool;

// This example will connect to the server, create a new MAC address pool and assign it to a cluster:
public class AddMacPool {
    public static void main(String[] args) throws Exception {
        // Create the connection to the server:
        Connection connection = connection()
            .url("https://engine40.example.com/ovirt-engine/api")
            .user("admin@internal")
            .password("redhat123")
            .trustStoreFile("truststore.jks")
            .build();

        // Get the reference to the service that manages the MAC address pools:
        MacPoolsService poolsService = connection.systemService().macPoolsService();

        // Add a new MAC address pool:
        MacPool pool = poolsService.add()
            .pool(
                macPool()
                .name("mymacpool")
                .ranges(
                    range()
                    .from("02:00:00:00:00:00")
                    .to("02:00:00:01:00:00")
                )
            )
            .send()
            .pool();

        // Find the service that manages clusters, as we need it in order to find the cluster where we wnt to set the
        // MAC address pool:
        ClustersService clustersService = connection.systemService().clustersService();

        // Find the cluster:
        Cluster cluster = clustersService.list()
            .search("name=mycluster")
            .send()
            .clusters()
            .get(0);

        // Find the service that manages the cluster, as we need it in order to do the update:
        ClusterService clusterService = clustersService.clusterService(cluster.id());

        // Update the service so that it uses the new MAC pool:
        clusterService.update()
            .cluster(
                cluster()
                .macPool(
                    macPool()
                    .id(pool.id())
                )
            )
            .send();

        // Close the connection to the server:
        connection.close();
    }
}
