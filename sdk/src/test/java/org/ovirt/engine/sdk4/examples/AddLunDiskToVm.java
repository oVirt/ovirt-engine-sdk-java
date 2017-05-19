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
import static org.ovirt.engine.sdk4.builders.Builders.hostStorage;
import static org.ovirt.engine.sdk4.builders.Builders.logicalUnit;

import org.ovirt.engine.sdk4.Connection;
import org.ovirt.engine.sdk4.services.DiskAttachmentsService;
import org.ovirt.engine.sdk4.services.VmsService;
import org.ovirt.engine.sdk4.types.DiskInterface;
import org.ovirt.engine.sdk4.types.StorageType;
import org.ovirt.engine.sdk4.types.Vm;

// This example will connect to the server and add LUN disk to virtual machine:
public class AddLunDiskToVm {
    public static void main(String[] args) throws Exception {
        // Create the connection to the server:
        Connection connection = connection()
            .url("https://engine/ovirt-engine/api")
            .user("admin@internal")
            .password("123456")
            .trustStoreFile("truststore.jks")
            .build();

        // Locate the virtual machines service and use it to find the virtual machine:
        VmsService vmsService = connection.systemService().vmsService();
        Vm vm = vmsService.list().search("name=myvm").send().vms().get(0);

        // Locate the service that manages the disk attachments of the virtual machine:
        DiskAttachmentsService diskAttachmentsService = vmsService.vmService(vm.id()).diskAttachmentsService();

        // Use the "add" method of the disk attachments service to add the LUN disk.
        diskAttachmentsService.add()
            .attachment(
                diskAttachment()
                .disk(
                    disk()
                    .name("myiscsidisk")
                    .lunStorage(
                        hostStorage()
                        .type(StorageType.ISCSI)
                        .logicalUnits(
                            logicalUnit()
                            .address("192.168.200.3")
                            .port(3260)
                            .target("iqn.2014-07.org.ovirt:storage")
                            .id("36001405e793bf9c57a840f58c9a8a220")
                            .username("username")
                            .password("password")
                        )
                    )
                )
                .interface_(DiskInterface.VIRTIO)
                .bootable(false)
                .active(true)
            )
            .send()
            .attachment();

        // Close the connection to the server:
        connection.close();
    }
}
