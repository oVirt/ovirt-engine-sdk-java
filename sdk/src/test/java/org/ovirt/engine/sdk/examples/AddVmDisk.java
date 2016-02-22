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

package org.ovirt.engine.sdk.examples;

import static org.ovirt.engine.sdk.ConnectionBuilder.connection;
import static org.ovirt.engine.sdk.builders.Builders.nic;
import static org.ovirt.engine.sdk.builders.Builders.vnicProfile;

import org.ovirt.engine.sdk.Connection;
import org.ovirt.engine.sdk.services.VmNicsService;
import org.ovirt.engine.sdk.services.VmsService;
import org.ovirt.engine.sdk.services.VnicProfilesService;
import org.ovirt.engine.sdk.types.Vm;
import org.ovirt.engine.sdk.types.VnicProfile;

// This example will connect to the server and add a NIC to an existing virtual machine:
public class AddVmDisk {
    public static void main(String[] args) throws Exception {
        // Create the connection to the server:
        Connection connection = connection()
            .url("https://engine40.example.com/ovirt-engine/api")
            .user("admin@internal")
            .password("redhat123")
            .keyStorePath("keystore.jks")
            .build();

        // Locate the virtual machines service and use it to find the virtual machine:
        VmsService vmsService = connection.systemService().vmsService();
        Vm vm = vmsService.list().search("name=myvm").send().vms().get(0);

        // In order to specify the network that the new interface will be connected to we need to specifiy the
        // identifier of the virtual network interface profile, so we need to find it:
        VnicProfilesService profilesService = connection.systemService().vnicProfilesService();
        String profileId = null;
        for (VnicProfile profile : profilesService.list().send().profiles()) {
            if ("mynetwork".equals(profile.name())) {
                profileId = profile.id();
            }
        }

        // Locate the service that manages the network interface cards of the virtual machine:
        VmNicsService nicsService = vmsService.vmService(vm.id()).nicsService();

        // Use the "add" method of the network interfface cards service to add the new network interface card:
        nicsService.add()
            .nic(
                nic()
                .name("mynic")
                .description("My network interface card")
                .vnicProfile(
                    vnicProfile()
                    .id(profileId)
                )
            )
            .send();

        // Close the connection to the server:
        connection.close();
    }
}
