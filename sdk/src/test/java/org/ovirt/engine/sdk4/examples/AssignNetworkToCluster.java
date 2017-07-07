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
import static org.ovirt.engine.sdk4.builders.Builders.network;

import org.ovirt.engine.sdk4.Connection;
import org.ovirt.engine.sdk4.services.ClusterNetworksService;
import org.ovirt.engine.sdk4.services.ClusterService;
import org.ovirt.engine.sdk4.services.ClustersService;
import org.ovirt.engine.sdk4.services.NetworksService;
import org.ovirt.engine.sdk4.types.Cluster;
import org.ovirt.engine.sdk4.types.Network;

// This example will connect to the server and assign 'mynetwork' network to cluster 'mycluster':
public class AssignNetworkToCluster {
    public static void main(String[] args) throws Exception {
        // Create the connection to the server:
        Connection connection = connection()
            .url("https://engine40.example.com/ovirt-engine/api")
            .user("admin@internal")
            .password("redhat123")
            .trustStoreFile("truststore.jks")
            .build();

        // Locate the networks service and use it to find the network:
        NetworksService networksService = connection.systemService().networksService();
        Network network = networksService.list().search(
            "name=mynetwork and datacenter=mydatacenter"
        ).send().networks().get(0);

        // Locate the clusters service and use it to find the cluster:
        ClustersService clustersService = connection.systemService().clustersService();
        Cluster cluster = clustersService.list().search("name=mycluster").send().clusters().get(0);

        // Locate the service that manages the networks of the cluster:
        ClusterService clusterService = clustersService.clusterService(cluster.id());
        ClusterNetworksService clusterNetworksService = clusterService.networksService();

        // Use the "add" method to assign network to cluster:
        clusterNetworksService.add()
            .network(
                network()
                .id(network.id())
                .required(true)
            )
            .send();

        // Close the connection to the server:
        connection.close();
    }
}
