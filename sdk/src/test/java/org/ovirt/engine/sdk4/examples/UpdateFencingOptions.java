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
import static org.ovirt.engine.sdk4.builders.Builders.agent;
import static org.ovirt.engine.sdk4.builders.Builders.option;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.ovirt.engine.sdk4.Connection;
import org.ovirt.engine.sdk4.services.FenceAgentService;
import org.ovirt.engine.sdk4.services.FenceAgentsService;
import org.ovirt.engine.sdk4.services.HostService;
import org.ovirt.engine.sdk4.services.HostsService;
import org.ovirt.engine.sdk4.types.Agent;
import org.ovirt.engine.sdk4.types.Host;
import org.ovirt.engine.sdk4.types.Option;

// This example will connect to the server and change the value of the 'lanplus' option of the 'ipmilan' fencing agent
// of a host.
public class UpdateFencingOptions {
    public static void main(String[] args) throws Exception {
        // Create the connection to the server:
        Connection connection = connection()
            .url("https://engine40.example.com/ovirt-engine/api")
            .user("admin@internal")
            .password("redhat123")
            .trustStoreFile("truststore.jks")
            .build();

        // The name and value of the option that we want to add or update:
        String name = "lanplus";
        String value = "1";

        // Get the reference to the service that manages the hosts:
        HostsService hostsService = connection.systemService().hostsService();

        // Find the host:
        Host host = hostsService.list()
            .search("name=myhost")
            .send()
            .hosts()
            .get(0);

        // Get the reference to the service that manages the fencing agents used by the host that we found in the
        // previous step:
        HostService hostService = hostsService.hostService(host.id());
        FenceAgentsService agentsService = hostService.fenceAgentsService();

        // The host may have multiple fencing agents, so we need to locate the first of type 'ipmilan':
        List<Agent> agents = agentsService.list()
            .send()
            .agents();
        Agent agent = null;
        for (Agent x : agents) {
            if ("ipmlan".equals(x.type())) {
                agent = x;
                break;
            }
        }

        // Get the options of the fencing agent. There may be no options, in that case we need to use an empty list.
        List<Option> original = agent.options();
        if (original == null) {
            original = Collections.emptyList();
        }

        // Create a list of modified options, containing all the original options except the one with the name we want
        // to modify, as we will add that with the right value later:
        List<Option> modified = new ArrayList<>();
        for (Option option : original) {
            if (!name.equals(option.name())) {
                modified.add(option);
            }
        }

        // Add the modified option to the list of modified options:
        Option option = option()
            .name(name)
            .value(value)
            .build();
        modified.add(option);

        // Find the service that manages the fence agent:
        FenceAgentService agentService = agentsService.agentService(agent.id());

        // Send the update request containing the modified list of options:
        agentService.update()
            .agent(
                agent()
                .options(modified)
            )
            .send();

        // Close the connection to the server:
        connection.close();
    }
}
