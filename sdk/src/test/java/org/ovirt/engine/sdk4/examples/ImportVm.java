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
import static org.ovirt.engine.sdk4.builders.Builders.storageDomain;
import static org.ovirt.engine.sdk4.builders.Builders.vm;

import org.ovirt.engine.sdk4.Connection;
import org.ovirt.engine.sdk4.services.ClustersService;
import org.ovirt.engine.sdk4.services.StorageDomainVmsService;
import org.ovirt.engine.sdk4.services.StorageDomainsService;
import org.ovirt.engine.sdk4.types.Cluster;
import org.ovirt.engine.sdk4.types.StorageDomain;
import org.ovirt.engine.sdk4.types.Vm;

// This example will import an exported VM
public class ImportVm {
    public static void main(String[] args) throws Exception {

        // Create connection to the oVirt engine server:
        Connection connection = connection()
            .url("https://engine40.example.com/ovirt-engine/api")
            .user("admin@internal")
            .password("redhat123")
            .trustStoreFile("truststore.jks")
            .build();

        // Get storage domains service
        StorageDomainsService storageDomainsService = connection.systemService().storageDomainsService();

        // Get export storage domain
        StorageDomain exportDomain = storageDomainsService.list()
            .search("name=myexport")
            .send()
            .storageDomains()
            .get(0);

        // Get target storage domain
        StorageDomain targetStorageDomain = storageDomainsService.list()
            .search("name=mydata")
            .send()
            .storageDomains()
            .get(0);

        // Get cluster service
        ClustersService clustersService = connection.systemService().clustersService();

        // Get the cluster we import the VM to
        Cluster cluster = clustersService.list()
            .search("name=mycluster")
            .send()
            .clusters()
            .get(0);

        // Get VM service for export storage domain
        StorageDomainVmsService vmsService = storageDomainsService
            .storageDomainService(exportDomain.id())
            .vmsService();

        // Get the first exported VM, assuming we have one
        Vm exportedVm = vmsService.list()
            .send()
            .vm()
            .get(0);

        // Import the exported VM into target storage domain, 'mydata'
        vmsService.vmService(exportedVm.id())
            .import_()
            .storageDomain(
                storageDomain()
                .id(targetStorageDomain.id())
            )
            .cluster(
                cluster()
                .id(cluster.id())
            )
            .vm(
                vm()
                .id(exportedVm.id())
            )
            .send();

        // Close the connection
        connection.close();
    }
}
