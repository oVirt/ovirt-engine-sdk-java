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
import static org.ovirt.engine.sdk4.builders.Builders.cluster;
import static org.ovirt.engine.sdk4.builders.Builders.disk;
import static org.ovirt.engine.sdk4.builders.Builders.diskAttachment;
import static org.ovirt.engine.sdk4.builders.Builders.storageDomain;
import static org.ovirt.engine.sdk4.builders.Builders.template;
import static org.ovirt.engine.sdk4.builders.Builders.vm;

import java.math.BigInteger;
import java.util.List;

import org.ovirt.engine.sdk4.Connection;
import org.ovirt.engine.sdk4.services.StorageDomainsService;
import org.ovirt.engine.sdk4.services.SystemService;
import org.ovirt.engine.sdk4.services.TemplateService;
import org.ovirt.engine.sdk4.services.TemplatesService;
import org.ovirt.engine.sdk4.services.VmsService;
import org.ovirt.engine.sdk4.types.Disk;
import org.ovirt.engine.sdk4.types.DiskAttachment;
import org.ovirt.engine.sdk4.types.DiskFormat;
import org.ovirt.engine.sdk4.types.StorageDomain;
import org.ovirt.engine.sdk4.types.Template;

// This example will connect to the server, and create a virtual machine
// from a specific version of a template and specify storage domain where
// virtual machine disk should be created.
public class AddVmFromTemplateVersion {
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

        // Get the reference to the service that manages the storage domains:
        StorageDomainsService storageDomainsService = systemService.storageDomainsService();

        // Find the storage domain we want to be used for virtual machine disks:
        StorageDomain storageDomain = storageDomainsService.list()
            .search("name=mydata")
            .send()
            .storageDomains()
            .get(0);

        // Get the reference to the service that manages the templates:
        TemplatesService templatesService = systemService.templatesService();

        // When a template has multiple versions they all have the same name, so we need to explicitly find the one that
        // has the version name or version number that we want to use. In this case we want to use version 3 of the
        // template.
        List<Template> templates = templatesService.list()
            .search("name=mytemplate")
            .send()
            .templates();
        String templateId = null;
        for (Template template : templates) {
            if (template.version().versionNumber().equals(BigInteger.valueOf(3))) {
                templateId = template.id();
                break;
            }
        }

        // Find the template disk we want be created on specific storage domain
        // for our virtual machine:
        TemplateService templateService = templatesService.templateService(templateId);
        List<DiskAttachment> diskAttachments = connection.followLink(
            templateService.get().send().template().diskAttachments()
        );
        Disk disk = diskAttachments.get(0).disk();

        // Get the reference to the service that manages the virtual machines:
        VmsService vmsService = connection.systemService().vmsService();

        // Add a new virtual machine explicitly indicating the identifier of the template version that we want to use:
        vmsService.add()
            .vm(
                vm()
                .name("myvm")
                .cluster(
                    cluster()
                    .name("mycluster")
                )
                .template(
                    template()
                    .id(templateId)
                )
                .diskAttachments(
                    diskAttachment()
                    .disk(
                        disk()
                        .id(disk.id())
                        .format(DiskFormat.COW)
                        .storageDomains(
                            storageDomain()
                            .id(storageDomain.id())
                        )
                    )
                )
            )
            .send();

        // Close the connection to the server:
        connection.close();
    }
}
