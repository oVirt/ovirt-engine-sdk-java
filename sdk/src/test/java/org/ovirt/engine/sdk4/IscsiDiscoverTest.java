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

import java.math.BigInteger;

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
        setXmlResponse(
            "hosts/123/iscsidiscover",
            200,
            "<action>" +
                  "<iscsi>" +
                    "<address>iscsi.example.com</address>" +
                    "<port>3260</port>" +
                  "</iscsi>" +
                  "<iscsi_targets>" +
                    "<iscsi_target>myiqn</iscsi_target>" +
                  "</iscsi_targets>" +
                  "<discovered_targets>" +
                    "<iscsi_details>" +
                      "<address>192.168.121.102</address>" +
                      "<port>3260</port>" +
                    "</iscsi_details>" +
                  "</discovered_targets>" +
                "</action>"
        );
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
        HostService.IscsiDiscoverResponse response = hostService.iscsiDiscover()
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

        assertEquals("192.168.121.102", response.discoveredTargets().get(0).address());
        assertEquals(BigInteger.valueOf(3260), response.discoveredTargets().get(0).port());
        assertEquals("myiqn", response.iscsiTargets().get(0));
    }
}
