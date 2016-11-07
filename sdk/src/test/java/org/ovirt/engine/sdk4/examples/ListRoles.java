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

import java.util.List;

import org.ovirt.engine.sdk4.Connection;
import org.ovirt.engine.sdk4.services.RolesService;
import org.ovirt.engine.sdk4.types.Role;

// This example will connect to the server and then list the names and descriptions of all the available roles.
public class ListRoles {
    public static void main(String[] args) throws Exception {
        // Create the connection to the server:
        Connection connection = connection()
            .url("https://engine41.example.com/ovirt-engine/api")
            .user("admin@internal")
            .password("redhat123")
            .trustStoreFile("truststore.jks")
            .build();

        // Get the reference to the service that manages the roles:
        RolesService rolesService = connection.systemService().rolesService();

        // Retrieve the roles:
        List<Role> roles = rolesService.list().send().roles();

        // For each role print its name and description:
        for (Role role : roles) {
            System.out.printf("%s: %s\n", role.name(), role.description());
        }

        // Close the connection to the server:
        connection.close();
    }
}
