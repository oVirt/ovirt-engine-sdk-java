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
import static org.ovirt.engine.sdk4.builders.Builders.storageDomain;

import org.ovirt.engine.sdk4.Connection;
import org.ovirt.engine.sdk4.services.DiskService;
import org.ovirt.engine.sdk4.services.DisksService;
import org.ovirt.engine.sdk4.types.Disk;
import org.ovirt.engine.sdk4.types.DiskFormat;
import org.ovirt.engine.sdk4.types.DiskStatus;

// This example will connect to the server and create a new `floating` disk, one that isn't attached to any virtual
// machine.
public class AddFloatingDisk {
    public static void main(String[] args) throws Exception {
        // Create the connection to the server:
        Connection connection = connection()
            .url("https://engine40.example.com/ovirt-engine/api")
            .user("admin@internal")
            .password("redhat123")
            .trustStoreFile("truststore.jks")
            .build();

        // Get the reference to the disks service:
        DisksService disksService = connection.systemService().disksService();

        // Add the disk. Note that the size of the disk, the `provisionedSize` attribute, is specified in bytes,
        // so to create a disk of 10 GiB the value should be 10 * 2^30.
        Disk disk = disksService.add()
            .disk(
                disk()
                .name("mydisk")
                .description("My disk")
                .format(DiskFormat.COW)
                .provisionedSize(10 * (int) Math.pow(2, 30))
                .storageDomains(
                    storageDomain()
                    .name("mydata")
                )
            )
            .send()
            .disk();

        // Wait till the disk is completely created:
        DiskService diskService = disksService.diskService(disk.id());
        for (;;) {
            Thread.sleep(5 * 1000);
            disk = diskService.get().send().disk();
            if (disk.status() == DiskStatus.OK) {
                break;
            }
        }

        // Close the connection to the server:
        connection.close();
    }
}
