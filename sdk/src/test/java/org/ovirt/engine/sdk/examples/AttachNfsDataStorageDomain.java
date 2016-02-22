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
import static org.ovirt.engine.sdk.builders.Builders.storageDomain;

import org.ovirt.engine.sdk.Connection;
import org.ovirt.engine.sdk.services.AttachedStorageDomainsService;
import org.ovirt.engine.sdk.services.DataCenterService;
import org.ovirt.engine.sdk.services.DataCentersService;
import org.ovirt.engine.sdk.services.StorageDomainService;
import org.ovirt.engine.sdk.services.StorageDomainsService;
import org.ovirt.engine.sdk.types.DataCenter;
import org.ovirt.engine.sdk.types.StorageDomain;

// This example will connect to the server and attach an existing NFS data storage domain to a data center:
public class AttachNfsDataStorageDomain {
    public static void main(String[] args) throws Exception {
        // Create the connection to the server:
        Connection connection = connection()
            .url("https://engine40.example.com/ovirt-engine/api")
            .user("admin@internal")
            .password("redhat123")
            .keyStorePath("keystore.jks")
            .build();

        // Locate the service that manages the storage domains, and use it to search for the storage domain:
        StorageDomainsService sdsService = connection.systemService().storageDomainsService();
        StorageDomain sd = sdsService.list().search("name=mydata").send().storageDomain().get(0);

        // Locate the service that manages the data centers and use it to search for the data center:
        DataCentersService dcsService = connection.systemService().dataCentersService();
        DataCenter dc = dcsService.list().search("name=mydc").send().dataCenters().get(0);

        // Locate the service that manages the data center where we want to attach the storage domain:
        DataCenterService dcService = dcsService.dataCenterService(dc.id());

        // Locate the service that manages the storage domains that are attached to the data center:
        AttachedStorageDomainsService attachedSdsService = dcService.storageDomainsService();

        // Use the "add" method of the service that manages the attached storage domains to attach it:
        attachedSdsService.add()
            .storageDomain(
                storageDomain()
                .id(sd.id())
            )
            .send();

        // Wait till the storage domain is active:
        StorageDomainService sdService = sdsService.storageDomainService(sd.id());
        for (;;) {
            Thread.sleep(5 * 1000);
            sd = sdService.get().send().storageDomain();
            String state = sd.status().state();
            if ("active".equals(state)) {
                break;
            }
        }

        // Close the connection to the server:
        connection.close();
    }
}
