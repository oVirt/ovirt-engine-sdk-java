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
import static org.ovirt.engine.sdk4.builders.Builders.quota;
import static org.ovirt.engine.sdk4.builders.Builders.quotaStorageLimit;
import static org.ovirt.engine.sdk4.builders.Builders.storageDomain;

import java.util.List;
import java.util.Objects;

import org.ovirt.engine.sdk4.Connection;
import org.ovirt.engine.sdk4.services.DataCenterService;
import org.ovirt.engine.sdk4.services.DataCentersService;
import org.ovirt.engine.sdk4.services.QuotaService;
import org.ovirt.engine.sdk4.services.QuotaStorageLimitService;
import org.ovirt.engine.sdk4.services.QuotaStorageLimitsService;
import org.ovirt.engine.sdk4.services.QuotasService;
import org.ovirt.engine.sdk4.services.StorageDomainService;
import org.ovirt.engine.sdk4.services.StorageDomainsService;
import org.ovirt.engine.sdk4.services.SystemService;
import org.ovirt.engine.sdk4.types.DataCenter;
import org.ovirt.engine.sdk4.types.Quota;
import org.ovirt.engine.sdk4.types.QuotaStorageLimit;
import org.ovirt.engine.sdk4.types.StorageDomain;

// This example shows how to update the storage quota limits of a specific storage domain.
public class UpdateQuotaLimits {
    public static void main(String[] args) throws Exception {
        // Create the connection to the server:
        Connection connection = connection()
            .url("https://engine40.example.com/ovirt-engine/api")
            .user("admin@internal")
            .password("redhat123")
            .trustStoreFile("truststore.jks")
            .build();

        // Find the reference to the root of the tree of services:
        SystemService systemService = connection.systemService();

        // Find the data center and the service that manages it:
        DataCentersService dcsService = systemService.dataCentersService();
        DataCenter dc = dcsService.list()
            .search("name=mydc")
            .send()
            .dataCenters()
            .get(0);
        DataCenterService dcService = dcsService.dataCenterService(dc.id());

        // Find the storage domain and the service that manages it:
        StorageDomainsService sdsService = systemService.storageDomainsService();
        StorageDomain sd = sdsService.list()
            .search("name=mydata")
            .send()
            .storageDomains()
            .get(0);
        StorageDomainService sdService = sdsService.storageDomainService(sd.id());

        // Find the quota and the service that manages it. Note that the service that manages the quota doesn't support
        // search, so we need to retrieve all the quotas and filter explicitly. If the quota doesn't exist, create it.
        QuotasService quotasService = dcService.quotasService();
        List<Quota> quotas = quotasService.list().send().quotas();
        Quota quota = null;
        for (Quota q : quotas) {
            if (Objects.equals(q.id(), "myquota")) {
                quota = q;
                break;
            }
        }
        if (quota == null) {
            quota = quotasService.add()
                .quota(
                    quota()
                    .name("myquota")
                    .description("My quota")
                    .clusterHardLimitPct(20)
                    .clusterSoftLimitPct(80)
                    .storageHardLimitPct(20)
                    .storageSoftLimitPct(80)
                )
                .send()
                .quota();
        }
        QuotaService quotaService = quotasService.quotaService(quota.id());

        // Find the quota limits for the storage domain that we are interested on:
        QuotaStorageLimitsService limitsService = quotaService.quotaStorageLimitsService();
        List<QuotaStorageLimit> limits = limitsService.list().send().limits();
        QuotaStorageLimit limit = null;
        for (QuotaStorageLimit l : limits) {
            if (Objects.equals(l.id(), sd.id())) {
                limit = l;
                break;
            }
        }

        // If that limit exists we will delete it:
        if (limit != null) {
            QuotaStorageLimitService limitService = limitsService.limitService(limit.id());
            limitService.remove();
        }

        // Create the limit again with the desired values, in this example it will be 100 GiB:
        limitsService.add()
            .limit(
                quotaStorageLimit()
                .name("mydatalimit")
                .description("My storage domain limit")
                .limit(100)
                .storageDomain(
                    storageDomain()
                    .id(sd.id())
                )
            )
            .send();

        // Close the connection to the server:
        connection.close();
    }
}
