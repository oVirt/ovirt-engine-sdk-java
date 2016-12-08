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
import static org.ovirt.engine.sdk4.builders.Builders.sshPublicKey;

import org.ovirt.engine.sdk4.Connection;
import org.ovirt.engine.sdk4.services.SshPublicKeysService;
import org.ovirt.engine.sdk4.services.SystemService;
import org.ovirt.engine.sdk4.services.UserService;
import org.ovirt.engine.sdk4.services.UsersService;
import org.ovirt.engine.sdk4.types.User;

// This example will connect to the server, find a user by name and add a public SSH key.
public class AddUserPublicSshKey {
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

        // Get the reference to the service that manages the users:
        UsersService usersService = systemService.usersService();

        // Find the user:
        User user = usersService.list()
            .search("name=myuser")
            .send()
            .users()
            .get(0);

        // Get the reference to the service that manages the user that we found in the previous step:
        UserService userService = usersService.userService(user.id());

        // Get a reference to the service that manages the public SSH keys of the user:
        SshPublicKeysService keysService = userService.sshPublicKeysService();

        // Add a new SSH public key:
        keysService.add()
            .key(
                sshPublicKey()
                .content("ssh-rsa AAA...mu9 myuser@example.com")
            )
            .send();

        // Note that the above operation will fail because the example SSH public key is not valid, make sure to use a
        // valid key.

        // Close the connection to the server:
        connection.close();
    }
}
