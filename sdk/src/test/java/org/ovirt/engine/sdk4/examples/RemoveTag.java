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

import org.ovirt.engine.sdk4.Connection;
import org.ovirt.engine.sdk4.services.TagService;
import org.ovirt.engine.sdk4.services.TagsService;
import org.ovirt.engine.sdk4.types.Tag;

// This example will connect to the server, search for a tag by name and remove it:
public class RemoveTag {
    public static void main(String[] args) throws Exception {
        // Create the connection to the server:
        Connection connection = connection()
            .url("https://engine40.example.com/ovirt-engine/api")
            .user("admin@internal")
            .password("redhat123")
            .trustStoreFile("truststore.jks")
            .build();

        // Find the service that manages tags:
        TagsService tagsService = connection.systemService().tagsService();

        // Find the tag id:
        String tagId = null;
        for (Tag tag : tagsService.list().send().tags()) {
            if (tag.name().equals("mytag")) {
                tagId = tag.id();
                break;
            }
        }

        // Find the service that manages the tag:
        TagService tagService = tagsService.tagService(tagId);

        // Remove the tag:
        tagService.remove().send();

        // Close the connection to the server:
        connection.close();
    }
}
