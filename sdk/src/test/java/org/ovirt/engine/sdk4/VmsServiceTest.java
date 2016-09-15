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
import static org.junit.Assert.assertNull;

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
        VmService vmService = vmsService.vmService("456");
        Vm vm = vmService.get().send().vm();
        assertNull(vm);
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
}
