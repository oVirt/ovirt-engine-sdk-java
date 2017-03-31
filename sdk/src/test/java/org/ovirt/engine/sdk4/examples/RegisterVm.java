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
import static org.ovirt.engine.sdk4.builders.Builders.cluster;
import static org.ovirt.engine.sdk4.builders.Builders.vm;
import static org.ovirt.engine.sdk4.builders.Builders.vnicProfile;
import static org.ovirt.engine.sdk4.builders.Builders.vnicProfileMapping;

import java.util.List;

import org.ovirt.engine.sdk4.Connection;
import org.ovirt.engine.sdk4.services.StorageDomainService;
import org.ovirt.engine.sdk4.services.StorageDomainVmService;
import org.ovirt.engine.sdk4.services.StorageDomainVmsService;
import org.ovirt.engine.sdk4.services.StorageDomainsService;
import org.ovirt.engine.sdk4.types.StorageDomain;
import org.ovirt.engine.sdk4.types.Vm;

// This example will connect to the server and register a virtual machine.
public class RegisterVm {
    public static void main(String[] args) throws Exception {
        // Create the connection to the server:
        Connection connection = connection()
            .url("https://engine/ovirt-engine/api")
            .user("admin@internal")
            .password("redhat123")
            .trustStoreFile("truststore.jks")
            .build();

        // Get the reference to the "StorageDomains" service:
        StorageDomainsService storageDomainsService = connection.systemService().storageDomainsService();

        // Find the storage domain with unregistered VM:
        StorageDomain sd = storageDomainsService.list().search("name=mysd").send().storageDomains().get(0);

        // Locate the service that manages the storage domain, as that is where the action methods are defined:
        StorageDomainService storageDomainService = storageDomainsService.storageDomainService(sd.id());

        // Locate the service that manages the VMs in storage domain:
        StorageDomainVmsService storageDomainVmsService = storageDomainService.vmsService();

        // Find the the unregistered VM we want to register:
        List<Vm> unregisteredVms = storageDomainVmsService.list().unregistered(true).send().vm();
        Vm vm = null;
        for (Vm x : unregisteredVms) {
            if ("myvm".equals(x.name())) {
                vm = x;
                break;
            }
        }

        // Locate the service that manages virtual machine in the storage domain, as that is where the action methods
        // are defined:
        StorageDomainVmService storageDomainVmService = storageDomainVmsService.vmService(vm.id());

        // Register the VM into the system:
         storageDomainVmService.register()
             .vm(
                 vm()
                 .name("exported_myvm")

             )
             .cluster(
                 cluster()
                 .name("mycluster")
             )
             .vnicProfileMappings(
                 vnicProfileMapping()
                 .sourceNetworkName("mynetwork")
                 .sourceNetworkProfileName("mynetwork")
                 .targetVnicProfile(
                     vnicProfile()
                     .name("mynetwork")
                 )
             )
             .reassignBadMacs(true)
             .send();

        // Close the connection to the server:
        connection.close();
    }
}
