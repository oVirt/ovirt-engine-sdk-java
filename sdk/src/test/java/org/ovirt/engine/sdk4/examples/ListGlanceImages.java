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

import java.util.List;

import org.ovirt.engine.sdk4.Connection;
import org.ovirt.engine.sdk4.services.ImagesService;
import org.ovirt.engine.sdk4.services.StorageDomainService;
import org.ovirt.engine.sdk4.services.StorageDomainsService;
import org.ovirt.engine.sdk4.services.SystemService;
import org.ovirt.engine.sdk4.types.Image;
import org.ovirt.engine.sdk4.types.StorageDomain;

// This example will connect to the server list the images available in the 'ovirt-image-repository' Glance storge
// domain that is available by default in every oVirt installation.
public class ListGlanceImages {
    public static void main(String[] args) throws Exception {
        // Create the connection to the server:
        Connection connection = connection()
            .url("https://engine40.example.com/ovirt-engine/api")
            .user("admin@internal")
            .password("redhat123")
            .trustStoreFile("truststore.jks")
            .build();

        // Get the root of the services tree:
        SystemService systemService = connection.systemService();

        // Find the Glance storage domain that is available for default in any oVirt installation:
        StorageDomainsService sdsService = systemService.storageDomainsService();
        StorageDomain sd = sdsService.list()
            .search("name=ovirt-image-repository")
            .send()
            .storageDomains()
            .get(0);

        // Find the service that manages the Glance storage domain:
        StorageDomainService sdService = sdsService.storageDomainService(sd.id());

        // Find the service that manages the images available in that storage domain:
        ImagesService imagesService = sdService.imagesService();

        // List the images available in the storage domain:
        List<Image> images = imagesService.list()
            .send()
            .images();
        for (Image image : images) {
            System.out.println(image.name());
        }

        // Close the connection to the server:
        connection.close();
    }
}
