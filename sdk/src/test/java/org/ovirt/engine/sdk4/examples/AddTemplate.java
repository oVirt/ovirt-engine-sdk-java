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
import static org.ovirt.engine.sdk4.builders.Builders.disk;
import static org.ovirt.engine.sdk4.builders.Builders.diskAttachment;
import static org.ovirt.engine.sdk4.builders.Builders.template;
import static org.ovirt.engine.sdk4.builders.Builders.vm;

import java.util.ArrayList;
import java.util.List;

import org.ovirt.engine.sdk4.Connection;
import org.ovirt.engine.sdk4.services.SystemService;
import org.ovirt.engine.sdk4.services.TemplateService;
import org.ovirt.engine.sdk4.services.TemplatesService;
import org.ovirt.engine.sdk4.services.VmsService;
import org.ovirt.engine.sdk4.types.DiskAttachment;
import org.ovirt.engine.sdk4.types.DiskFormat;
import org.ovirt.engine.sdk4.types.Template;
import org.ovirt.engine.sdk4.types.TemplateStatus;
import org.ovirt.engine.sdk4.types.Vm;

// This example shows how to add a new template, customizing some of its characteristics, like the format of the disks.
public class AddTemplate {
    public static void main(String[] args) throws Exception {
        // Create the connection to the server:
        Connection connection = connection()
            .url("https://engine40.example.com/ovirt-engine/api")
            .user("admin@internal")
            .password("redhat123")
            .trustStoreFile("truststore.jks")
            .build();

        // Get the reference to the root of the services tree:
        SystemService systemService = connection.systemService();

        // Find the original virtual machine:
        VmsService vmsService = systemService.vmsService();
        Vm vm = vmsService.list()
            .search("name=myvm")
            .send()
            .vms()
            .get(0);

        // Get the identifiers of the disks attached to the virtual machine. We # need this because we want to tell the
        // server to create the disks of the template using a format different to the format used by the original disks.
        List<String> diskIds = new ArrayList<>();
        for (DiskAttachment attachment : connection.followLink(vm.diskAttachments())) {
            diskIds.add(attachment.disk().id());
        }

        // Create a customized list of disk attachments, explicitly indicating that we want COW disks, regardless of
        // format the original disks had:
        List<DiskAttachment> attachments = new ArrayList<>();
        for (String diskId : diskIds) {
            attachments.add(
                diskAttachment()
                .disk(
                    disk()
                    .id(diskId)
                    .format(DiskFormat.COW)
                )
                .build()
            );
        }

        // Send the request to create the template. Note that the way to specify the original virtual machine, and the
        // customizations, is to use the 'vm' attribute of the 'Template' type.
        TemplatesService templatesService = systemService.templatesService();
        Template template = templatesService.add()
            .template(
                template()
                .name("mytemplate")
                .vm(
                    vm()
                    .id(vm.id())
                    .diskAttachments(attachments)
                )
            )
            .send()
            .template();

        // Wait till the status of the template is OK, as that means that it is completely created and ready to use:
        TemplateService templateService = templatesService.templateService(template.id());
        for (;;) {
            Thread.sleep(5 * 1000);
            template = templateService.get().send().template();
            if (template.status() == TemplateStatus.OK) {
                break;
            }
        }

        // Close the connection to the server:
        connection.close();
    }
}
