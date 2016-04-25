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
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.ovirt.engine.sdk4.internal.HttpConnection;
import org.ovirt.engine.sdk4.services.ClustersService;
import org.ovirt.engine.sdk4.services.VmDisksService;
import org.ovirt.engine.sdk4.services.VmService;
import org.ovirt.engine.sdk4.services.VmsService;

public class ConnectionUseTest extends ServerTest {

    private HttpConnection connection;
    private ClustersService clustersService;

    @Before
    public void setUp() {
        setXmlResponse("", 200, "<api/>");
        startServer();
        connection = (HttpConnection) testConnection();
        clustersService = connection.systemService().clustersService();
    }

    @After
    public void tearDown() throws Exception {
        connection.close();
        stopServer();
    }

    /**
     * Test when connection is created URL can be obtained
     */
    @Test
    public void testBuildUrlBase() {
        assertEquals(testUrl(), connection.getUrl());
    }

    /**
     * Test get root
     */
    @Test
    public void testGetRoot() throws Exception {
        assertNotNull(connection.systemService().get().send());
    }

    /**
     * Test given 'vms' returns a reference to the virtual machines service
     */
    @Test
    public void testReturnVmsService() {
        assertTrue(connection.systemService().service("vms") instanceof VmsService);
    }

    /**
     * Test given 'vms/123' returns a reference to the virtual machine service
     */
    @Test
    public void testReturnVmService() {
        assertTrue(connection.systemService().service("vms/123") instanceof VmService);
    }

    /**
     * Test given 'vms/123/disks' returns a reference to the virtual machine disks service
     */
    @Test
    public void testReturnVmDisksService() {
        assertTrue(connection.systemService().service("vms/123/disks") instanceof VmDisksService);
    }
}
