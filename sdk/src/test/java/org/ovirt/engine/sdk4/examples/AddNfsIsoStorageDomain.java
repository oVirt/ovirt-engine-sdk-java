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
import static org.ovirt.engine.sdk4.builders.Builders.host;
import static org.ovirt.engine.sdk4.builders.Builders.hostStorage;
import static org.ovirt.engine.sdk4.builders.Builders.storageDomain;

import org.ovirt.engine.sdk4.Connection;
import org.ovirt.engine.sdk4.services.StorageDomainService;
import org.ovirt.engine.sdk4.services.StorageDomainsService;
import org.ovirt.engine.sdk4.types.StorageDomain;
import org.ovirt.engine.sdk4.types.StorageDomainType;
import org.ovirt.engine.sdk4.types.StorageType;

// This example will connect to the server and create a new NFS ISO storage domain:
public class AddNfsIsoStorageDomain {
    public static void main(String[] args) throws Exception {
        // Create the connection to the server:
        Connection connection = connection()
            .url("https://engine40.example.com/ovirt-engine/api")
            .user("admin@internal")
            .password("redhat123")
            .keyStorePath("keystore.jks")
            .build();

        // Get the reference to the storage domains service:
        StorageDomainsService sdsService = connection.systemService().storageDomainsService();

        // Create a new NFS storage domain:
        StorageDomain sd = sdsService.add()
            .storageDomain(
                storageDomain()
                .name("myiso")
                .description("My ISO")
                .type(StorageDomainType.ISO)
                .host(
                    host()
                    .name("myhost")
                )
                .storage(
                    hostStorage()
                    .type(StorageType.NFS)
                    .address("server0.example.com")
                    .path("/nfs/ovirt/40/myiso")
                )
            )
            .send()
            .storageDomain();

        // Wait till the storage domain is unattached:
        StorageDomainService sdService = sdsService.storageDomainService(sd.id());
        for (;;) {
            Thread.sleep(5 * 1000);
            sd = sdService.get().send().storageDomain();
            String state = sd.status().state();
            if ("unattached".equals(state)) {
                break;
            }
        }

        // Close the connection to the server:
        connection.close();
    }
}
