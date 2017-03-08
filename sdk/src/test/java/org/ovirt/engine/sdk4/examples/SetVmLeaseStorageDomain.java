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
import static org.ovirt.engine.sdk4.builders.Builders.highAvailability;
import static org.ovirt.engine.sdk4.builders.Builders.storageDomain;
import static org.ovirt.engine.sdk4.builders.Builders.storageDomainLease;
import static org.ovirt.engine.sdk4.builders.Builders.vm;

import org.ovirt.engine.sdk4.Connection;
import org.ovirt.engine.sdk4.services.StorageDomainsService;
import org.ovirt.engine.sdk4.services.SystemService;
import org.ovirt.engine.sdk4.services.VmService;
import org.ovirt.engine.sdk4.services.VmsService;
import org.ovirt.engine.sdk4.types.StorageDomain;
import org.ovirt.engine.sdk4.types.Vm;

// This example shows how to set the storage domain where the lease of a virtual machine should be created:
public class SetVmLeaseStorageDomain {
    public static void main(String[] args) throws Exception {
        // Create the connection to the server:
        Connection connection = connection()
            .url("https://engine40.example.com/ovirt-engine/api")
            .user("admin@internal")
            .password("redhat123")
            .trustStoreFile("truststore.jks")
            .build();

        // Get the reference to the root of the tree of services:
        SystemService systemService = connection.systemService();

        // Find the virtual machine:
        VmsService vmsService = systemService.vmsService();
        Vm vm = vmsService.list()
            .search("name=myvm")
            .send()
            .vms()
            .get(0);

        // Find the storage domain:
        StorageDomainsService sdsService = systemService.storageDomainsService();
        StorageDomain sd = sdsService.list()
            .search("name=mydata")
            .send()
            .storageDomains()
            .get(0);

        // Update the virtual machine so that high availability is enabled and the lease is created in the selected
        // storage domain:
        VmService vmService = vmsService.vmService(vm.id());
        vmService.update()
            .vm(
                vm()
                .highAvailability(
                    highAvailability()
                    .enabled(true)
                )
                .lease(
                    storageDomainLease()
                    .storageDomain(
                        storageDomain()
                        .id(sd.id())
                    )
                )
            )
            .send();

        // Close the connection to the server:
        connection.close();
    }
}
