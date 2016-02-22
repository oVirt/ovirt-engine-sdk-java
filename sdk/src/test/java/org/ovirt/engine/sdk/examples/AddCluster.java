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

package org.ovirt.engine.sdk.examples;

import static org.ovirt.engine.sdk.ConnectionBuilder.connection;
import static org.ovirt.engine.sdk.builders.Builders.cluster;
import static org.ovirt.engine.sdk.builders.Builders.cpu;
import static org.ovirt.engine.sdk.builders.Builders.dataCenter;

import org.ovirt.engine.sdk.Connection;
import org.ovirt.engine.sdk.services.ClustersService;
import org.ovirt.engine.sdk.types.Architecture;

// This example will connect to the server and create a new cluster:
public class AddCluster {
    public static void main(String[] args) throws Exception {
        // Create the connection to the server:
        Connection connection = connection()
            .url("https://engine40.example.com/ovirt-engine/api")
            .user("admin@internal")
            .password("redhat123")
            .keyStorePath("keystore.jks")
            .build();

        // Get the reference to the clusters service:
        ClustersService clustersService = connection.systemService().clustersService();

        // Use the "add" method to create a new data center:
        clustersService.add()
            .cluster(
                cluster()
                .name("mycluster")
                .description("My cluster")
                .cpu(
                    cpu()
                    .architecture(Architecture.X86_64)
                    .type("Intel Conroe Family")
                )
                .dataCenter(
                    dataCenter()
                    .name("mydc")
                )
            )
            .send();

        // Close the connection to the server:
        connection.close();
    }
}
