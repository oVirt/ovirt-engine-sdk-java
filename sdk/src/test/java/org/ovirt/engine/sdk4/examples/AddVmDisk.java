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
import static org.ovirt.engine.sdk4.builders.Builders.disk;
import static org.ovirt.engine.sdk4.builders.Builders.diskAttachment;
import static org.ovirt.engine.sdk4.builders.Builders.storageDomain;

import java.math.BigInteger;

import org.ovirt.engine.sdk4.Connection;
import org.ovirt.engine.sdk4.services.DiskAttachmentsService;
import org.ovirt.engine.sdk4.services.DiskService;
import org.ovirt.engine.sdk4.services.DisksService;
import org.ovirt.engine.sdk4.services.VmsService;
import org.ovirt.engine.sdk4.types.Disk;
import org.ovirt.engine.sdk4.types.DiskAttachment;
import org.ovirt.engine.sdk4.types.DiskFormat;
import org.ovirt.engine.sdk4.types.DiskInterface;
import org.ovirt.engine.sdk4.types.DiskStatus;
import org.ovirt.engine.sdk4.types.Vm;

// This example will connect to the server and attach a disk to an existing virtual machine:
public class AddVmDisk {
    public static void main(String[] args) throws Exception {
        // Create the connection to the server:
        Connection connection = connection()
            .url("https://engine40.example.com/ovirt-engine/api")
            .user("admin@internal")
            .password("redhat123")
            .trustStoreFile("truststore.jks")
            .build();

        // Locate the virtual machines service and use it to find the virtual machine:
        VmsService vmsService = connection.systemService().vmsService();
        Vm vm = vmsService.list().search("name=myvm").send().vms().get(0);

        // Locate the service that manages the disk attachments of the virtual machine:
        DiskAttachmentsService diskAttachmentsService = vmsService.vmService(vm.id()).diskAttachmentsService();

        // Use the `add` method of the disk attachments service to add the disk. Note that the size of the disk,
        // the `provionedSize` attribute, is specified in bytes, so to create a disk of 10 GiB the value should
        // be 10 * 2^30.
        DiskAttachment diskAttachment = diskAttachmentsService.add()
            .attachment(
                diskAttachment()
                .disk(
                    disk()
                    .name("mydisk")
                    .description("My disk")
                    .format(DiskFormat.COW)
                    .provisionedSize(BigInteger.valueOf(10).multiply(BigInteger.valueOf(2).pow(30)))
                    .storageDomains(
                        storageDomain()
                        .name("mydata")
                    )
                )
                .interface_(DiskInterface.VIRTIO)
                .bootable(false)
                .active(true)
            )
            .send()
            .attachment();

        // Wait till the disk is OK:
        DisksService disksService = connection.systemService().disksService();
        DiskService diskService = disksService.diskService(diskAttachment.disk().id());
        for (;;) {
            Thread.sleep(5 * 1000);
            Disk disk = diskService.get().send().disk();
            if (disk.status() == DiskStatus.OK) {
                break;
            }
        }

        // Close the connection to the server:
        connection.close();
    }
}
