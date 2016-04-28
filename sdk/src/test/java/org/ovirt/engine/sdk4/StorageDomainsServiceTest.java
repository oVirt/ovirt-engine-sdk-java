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
import org.ovirt.engine.sdk4.services.StorageDomainService;
import org.ovirt.engine.sdk4.services.StorageDomainsService;
import org.ovirt.engine.sdk4.types.StorageDomain;

public class StorageDomainsServiceTest extends ServerTest {

    private Connection connection;
    private StorageDomainsService storageDomainsService;

    @Before
    public void setUp() {
        setXmlResponse("storagedomains", 200, "<storage_domains/>");
        setXmlResponse("storagedomains/123", 200, "<storage_domain id=\"123\"><name>testsd</name></storage_domain>");
        startServer();
        connection = testConnection();
        storageDomainsService = connection.systemService().storageDomainsService();
    }

    @After
    public void tearDown() throws Exception {
        connection.close();
        stopServer();
    }

    /**
     * Test we don't get null storage domains service
     */
    @Test
    public void testGetService() {
        assertNotNull(storageDomainsService);
    }

    /**
     * Test returning empty storage domains list
     */
    @Test
    public void testEmptyListResponse() {
        List<StorageDomain> storageDomains = storageDomainsService.list().send().storageDomains();
        assertNotNull(storageDomains);
        assertEquals(new ArrayList<StorageDomain>(), storageDomains);
    }

    /**
     * Test list storage domains with query
     */
    @Test
    public void testEmptyListResponseWithQuery() {
        List<StorageDomain> storageDomains = storageDomainsService.list().search("name=ugly").send().storageDomains();
        assertNotNull(storageDomains);
        assertEquals(new ArrayList<StorageDomain>(), storageDomains);
    }

    /**
     * Test we don't get null storage service for existing storage id and correct object
     */
    @Test
    public void testGetObjectFromStorageDomainService() {
        StorageDomainService sdService = storageDomainsService.storageDomainService("123");
        StorageDomain sd = sdService.get().send().storageDomain();
        assertEquals("123", sd.id());
        assertEquals("testsd", sd.name());
        assertNull(sd.description());
    }
}
