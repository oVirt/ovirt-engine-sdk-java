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
import static org.ovirt.engine.sdk.builders.Builders.dataCenter;

import org.ovirt.engine.sdk.Connection;
import org.ovirt.engine.sdk.services.DataCenterService;
import org.ovirt.engine.sdk.services.DataCentersService;
import org.ovirt.engine.sdk.types.DataCenter;

// This example will connect to the server and update the description of  a data center:
public class UpdateDataCenter {
    public static void main(String[] args) throws Exception {
        // Create the connection to the server:
        Connection connection = connection()
            .url("https://engine40.example.com/ovirt-engine/api")
            .user("admin@internal")
            .password("redhat123")
            .keyStorePath("keystore.jks")
            .build();

        // Get the reference to the data centers service:
        DataCentersService dcsService = connection.systemService().dataCentersService();

        // Retrieve the description of the data center:
        DataCenter dc = dcsService.list()
            .search("name=mydc")
            .send()
            .dataCenters()
            .get(0);

        // In order to update the data center we need a reference to the service that manages it, then we can call the
        // "update" method passing the update:
        DataCenterService dcService = dcsService.dataCenterService(dc.id());
        dc = dcService.update()
            .dataCenter(
                dataCenter()
                .description("Updated description")
            )
            .send()
            .dataCenter();

        // Print the description of the result of the update:
        System.out.printf("%s: %s", dc.name(), dc.description());

        // Close the connection to the server:
        connection.close();
    }
}

