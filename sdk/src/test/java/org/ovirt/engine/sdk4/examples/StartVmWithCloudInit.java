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
import static org.ovirt.engine.sdk4.builders.Builders.initialization;
import static org.ovirt.engine.sdk4.builders.Builders.ip;
import static org.ovirt.engine.sdk4.builders.Builders.nicConfiguration;
import static org.ovirt.engine.sdk4.builders.Builders.vm;

import org.ovirt.engine.sdk4.Connection;
import org.ovirt.engine.sdk4.services.VmService;
import org.ovirt.engine.sdk4.services.VmsService;
import org.ovirt.engine.sdk4.types.BootProtocol;
import org.ovirt.engine.sdk4.types.IpVersion;
import org.ovirt.engine.sdk4.types.Vm;

// This example will connect to the server and start a virtual machine with cloud-init, in order to automatically
// configure the network and the password of the `root` user.
public class StartVmWithCloudInit {
    public static void main(String[] args) throws Exception {
        // Create the connection to the server:
        Connection connection = connection()
            .url("https://engine40.example.com/ovirt-engine/api")
            .user("admin@internal")
            .password("redhat123")
            .trustStoreFile("truststore.jks")
            .build();

        // Find the virtual machine:
        VmsService vmsService = connection.systemService().vmsService();
        Vm vm = vmsService.list()
            .search("name=myvm")
            .send()
            .vms()
            .get(0);

        // Find the service that manages the virtual machine:
        VmService vmService = vmsService.vmService(vm.id());

        // Start the virtual machine enabling cloud-init and providing the password for the `root` user and the network
        // configuration:
        vmService.start()
            .useCloudInit(true)
            .vm(
                vm()
                .initialization(
                    initialization()
                    .userName("root")
                    .rootPassword("redhat123")
                    .hostName("myvm.example.com")
                    .nicConfigurations(
                        nicConfiguration()
                        .name("eth0")
                        .onBoot(true)
                        .bootProtocol(BootProtocol.STATIC)
                        .ip(
                            ip()
                            .version(IpVersion.V4)
                            .address("192.168.0.100")
                            .netmask("255.255.255.0")
                            .gateway("192.168.0.1")
                        )
                    )
                    .dnsServers("192.168.0.1 192.168.0.2 192.168.0.3")
                    .dnsSearch("example.com")
                )
            )
            .send();

        // Close the connection to the server:
        connection.close();
    }
}
