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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.ovirt.engine.sdk4.services.VmService;
import org.ovirt.engine.sdk4.services.VmsService;
import org.ovirt.engine.sdk4.types.Vm;

public class VmsServiceTest extends ServerTest {

    private Connection connection;
    private VmsService vmsService;

    @Before
    public void setUp() {
        setXmlResponse("vms", 200, "<vms/>");
        setXmlResponse("vms/123", 200, "<vm id=\"123\"><name>testvm</name></vm>");
        setXmlResponse("vms/456", 404, "");
        setXmlResponse(
            "vms/123/start",
            400,
            "<fault>" +
              "<reason>myreason</reason>" +
            "</fault>"
        );
        setXmlResponse(
            "vms/456/start",
            400,
            "<action>" +
              "<fault>" +
                "<reason>myreason</reason>" +
              "</fault>" +
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
     * Test we don't get null vms service
     */
    @Test
    public void testGetService() {
        assertNotNull(vmsService);
    }

    /**
     * Test returning empty vms list
     */
    @Test
    public void testEmptyListResponse() {
        List<Vm> vms = vmsService.list().send().vms();
        assertNotNull(vms);
        assertEquals(new ArrayList<Vm>(), vms);
    }

    /**
     * Test list vms with query
     */
    @Test
    public void testEmptyListResponseWithQuery() {
        List<Vm> vms = vmsService.list().search("name=ugly").send().vms();
        assertNotNull(vms);
        assertEquals(new ArrayList<Vm>(), vms);
    }

    /**
     * Test we don't get null vm service for existing vm id and correct object
     */
    @Test
    public void testGetObjectFromStorageDomainService() {
        VmService vmService = vmsService.vmService("123");
        Vm vm = vmService.get().send().vm();
        assertEquals("123", vm.id());
        assertEquals("testvm", vm.name());
        assertNull(vm.description());
    }

    /**
     * Test we don get null VM object for non-existing VM id.
     */
    @Test
    public void testNullObjectForNonExistingID() {
        boolean raised = false;
        VmService vmService = vmsService.vmService("456");
        try {
            vmService.get().send().vm();
        } catch (Error e) {
            assertTrue(e.getMessage().contains("404"));
            raised = true;
        }
        assertTrue(raised);
    }

    /**
     * Test SDK won't crash if there are multiple threads using to VmsService
     */
    @Test
    public void testConnectionFromMultipleThreads() throws Exception {
        int numberOfThreads = 3;
        Thread[] threads = new Thread[numberOfThreads];
        for (int i = 0; i < numberOfThreads; i++) {
            threads[i] = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        vmsService.list().send().vms();
                    }
                }
            );
            threads[i].start();
        }

        for (int i = 0; i < numberOfThreads; i++) {
            threads[i].join();
        }
    }

    /**
     * When the server returns an action containing a fault
     * raises an error containing the information of the fault.
     */
    @Test
    public void testFaultReaderWithoutAction() {
        boolean raised = false;
        VmService vmService = vmsService.vmService("123");
        try {
            vmService.start().send();
        } catch (Error e) {
            assertTrue(e.getMessage().contains("myreason"));
            raised = true;
        }
        assertTrue(raised);
    }

    /**
     * When the server returns an fault instead of an action it
     * raises an error containing the information of the fault.
     */
    @Test
    public void testFaultReaderWithAction() {
        boolean raised = false;
        VmService vmService = vmsService.vmService("456");
        try {
            vmService.start().send();
        } catch (Error e) {
            assertTrue(e.getMessage().contains("myreason"));
            raised = true;
        }
        assertTrue(raised);
    }

    /**
     * Test when user send all-content query with value true,
     * also All-content header is sent with value set to `true`.
     */
    @Test
    public void testAllContentTrue() {
        vmsService.list().allContent(true).send();
        assertTrue(Boolean.valueOf(getLastRequestHeaders().get("All-Content").getFirst()));
    }

    /**
     * Test when user send all-content query with value false,
     * also All-content header is sent with value set to `false`.
     */
    @Test
    public void testAllContentFalse() {
        vmsService.list().allContent(false).send();
        assertFalse(Boolean.valueOf(getLastRequestHeaders().get("All-Content").getFirst()));
    }
}
