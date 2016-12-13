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
import org.ovirt.engine.sdk4.services.TagsService;
import org.ovirt.engine.sdk4.types.Tag;

// This example will connect to the server and then list the names and descriptions of all the available tags.
public class ListTags {
    public static void main(String[] args) throws Exception {
        Connection connection = connection()
            .url("https://engine40.example.com/ovirt-engine/api")
            .user("admin@internal")
            .password("redhat123")
            .trustStoreFile("truststore.jks")
            .build();

        // Find the service that manages tags:
        TagsService tagsService = connection.systemService().tagsService();

        // Retrieve the tags:
        List<Tag> tags = tagsService.list().send().tags();

        // For each tag print its name and description:
        for (Tag tag : tags) {
            System.out.printf("%s: %s\n", tag.name(), tag.description());
        }

        // Close the connection to the server:
        connection.close();
    }
}
