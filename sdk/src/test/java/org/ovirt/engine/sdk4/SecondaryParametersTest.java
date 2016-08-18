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
import static org.ovirt.engine.sdk4.builders.Builders.vm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.ovirt.engine.sdk4.services.VmsService;

public class SecondaryParametersTest extends ServerTest {

    private Connection connection;
    private VmsService vmsService;

    @Before
    public void setUp() {
        setXmlResponse("vms", 201, "<vm/>");
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
     * Test we don't get null vms service
     */
    @Test
    public void testGetService() {
        assertNotNull(vmsService);
    }

    /**
     * Test when adding clone vm the query with this parameter is sent.
     */
    @Test
    public void testSecondaryParamenters() {
        vmsService.add().vm(vm()).clone_(true).send();
        assertEquals("clone=true", getLastRequestQuery());
    }

    /**
     * Test when adding vm clone and clone_permissions the query with
     * those parameters is sent.
     */
    @Test
    public void testMultipleSecondaryParameters() {
        vmsService.add().vm(vm()).clone_(true).clonePermissions(true).send();
        assertEquals("clone=true&clone_permissions=true", getLastRequestQuery());
    }
}