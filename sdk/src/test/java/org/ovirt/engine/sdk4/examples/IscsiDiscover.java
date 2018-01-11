/*
Copyright (c) 2018 Red Hat, Inc.

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
import static org.ovirt.engine.sdk4.builders.Builders.iscsiDetails;

import org.ovirt.engine.sdk4.Connection;
import org.ovirt.engine.sdk4.services.HostService;
import org.ovirt.engine.sdk4.services.HostsService;
import org.ovirt.engine.sdk4.types.Host;
import org.ovirt.engine.sdk4.types.IscsiDetails;

// This example will connect to the server and call iscsiDiscover method of host,
// to discover iSCSI targets of the host.
public class IscsiDiscover {
    public static void main(String[] args) throws Exception {
        // Create the connection to the server:
        Connection connection = connection()
            .url("https://engine40.example.com/ovirt-engine/api")
            .user("admin@internal")
            .password("redhat123")
            .trustStoreFile("truststore.jks")
            .build();

        // Get the reference to the hosts service:
        HostsService hostsService = connection.systemService().hostsService();

        // Find the host:
        Host host = hostsService.list().search("name=myhost").send().hosts().get(0);

        // Locate the service that manages the host, as that is where the action methods are defined:
        HostService hostService = hostsService.hostService(host.id());

        // Call the "iscsiDiscover" method of the service to start it:
        HostService.IscsiDiscoverResponse response = hostService.iscsiDiscover()
            .iscsi(
                iscsiDetails()
                .address("myaddress")
            )
            .send();

        // Print only targets:
        for (String target : response.iscsiTargets()) {
            System.out.println(target);
        }

        // Print only address corresponding to target:
        for (IscsiDetails detail : response.discoveredTargets()) {
            System.out.println(detail.address() + ":" + detail.target());
        }

        // Close the connection to the server:
        connection.close();
    }
}
