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
import static org.ovirt.engine.sdk4.builders.Builders.iscsiDetails;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.ovirt.engine.sdk4.services.HostService;
import org.ovirt.engine.sdk4.services.HostsService;
import org.ovirt.engine.sdk4.services.VmsService;

public class IscsiDiscoverTest extends ServerTest {

    private Connection connection;
    private VmsService vmsService;

    @Before
    public void setUp() {
        setXmlResponse("hosts/123/iscsidiscover", 200, "<action/>");
        startServer();
        connection = testConnection();
        vmsService = connection.systemService().vmsService();
    }

    @After
    public void tearDown() throws Exception {
        connection.close();
        stopServer();
    }

    /**
     * Test we don't get null vm service for existing vm id and correct object
     */
    @Test
    public void testActionParameters() {
        HostsService hostsService = connection.systemService().hostsService();
        HostService hostService = hostsService.hostService("123");
        hostService.iscsiDiscover()
            .iscsi(
                iscsiDetails()
                    .address("iscsi.example.com")
                    .port(3260)
            )
            .send();
        assertEquals(
            "<action>" +
                "<iscsi>" +
                    "<address>iscsi.example.com</address>" +
                    "<port>3260</port>" +
                "</iscsi>" +
            "</action>",
            getLastRequestContent()
        );
    }
}
