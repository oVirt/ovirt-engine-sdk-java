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

package org.ovirt.engine.sdk4;

import static org.junit.Assert.assertEquals;
import static org.ovirt.engine.sdk4.builders.Builders.bonding;
import static org.ovirt.engine.sdk4.builders.Builders.hostNic;
import static org.ovirt.engine.sdk4.builders.Builders.option;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.ovirt.engine.sdk4.services.HostService;


public class SetupNetworksTest extends ServerTest {

    private Connection connection;
    private HostService hostService;

    @Before
    public void setUp() {
        setXmlResponse("hosts/123/setupnetworks", 200, "<action/>");
        startServer();
        connection = testConnection();
        hostService = connection.systemService().hostsService().hostService("123");
    }

    @After
    public void tearDown() throws Exception {
        connection.close();
        stopServer();
    }
    /**
     * Test if action parameters are constructed in correct way.
     */
    @Test
    public void testActionParameters() {
        hostService.setupNetworks()
            .modifiedBonds(
                hostNic()
                    .name("bond0")
                    .bonding(
                        bonding()
                            .options(
                                option()
                                    .name("mode")
                                    .type("4")
                            )
                            .slaves(
                                hostNic()
                                    .name("eth1"),
                                hostNic()
                                    .name("eth2")
                            )
                    )
            ).send();
        assertEquals(
            "<action>" +
                "<modified_bonds>" +
                    "<host_nic>" +
                        "<bonding>" +
                            "<options>" +
                                "<option>" +
                                    "<name>mode</name>" +
                                    "<type>4</type>" +
                                "</option>" +
                            "</options>" +
                            "<slaves>" +
                                "<host_nic>" +
                                    "<name>eth1</name>" +
                                "</host_nic>" +
                                "<host_nic>" +
                                    "<name>eth2</name>" +
                                "</host_nic>" +
                            "</slaves>" +
                        "</bonding>" +
                        "<name>bond0</name>" +
                    "</host_nic>" +
                "</modified_bonds>" +
            "</action>",
            getLastRequestContent()
        );
    }
}
