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
import org.ovirt.engine.sdk4.services.DataCenterService;
import org.ovirt.engine.sdk4.services.DataCentersService;
import org.ovirt.engine.sdk4.types.DataCenter;

public class DataCentersServiceTest extends ServerTest {

    private Connection connection;
    private DataCentersService dataCentersService;

    @Before
    public void setUp() {
        setXmlResponse("datacenters", 200, "<data_centers/>");
        setXmlResponse("datacenters/123", 200, "<data_center id=\"123\"><name>testdc</name></data_center>");
        startServer();
        connection = testConnection();
        dataCentersService = connection.systemService().dataCentersService();
    }

    @After
    public void tearDown() throws Exception {
        connection.close();
        stopServer();
    }

    /**
     * Test we don't get null data centers service
     */
    @Test
    public void testGetDataCentersService() {
        assertNotNull(dataCentersService);
    }

    /**
     * Test returning empty data centers list
     */
    @Test
    public void testEmptyListResponse() {
        List<DataCenter> dataCenters = dataCentersService.list().send().dataCenters();
        assertNotNull(dataCenters);
        assertEquals(new ArrayList<DataCenter>(), dataCenters);
    }

    /**
     * Test list data centers with query
     */
    @Test
    public void testEmptyListResponseWithQuery() {
        List<DataCenter> dataCenters = dataCentersService.list().search("name=ugly").send().dataCenters();
        assertNotNull(dataCenters);
        assertEquals(new ArrayList<DataCenter>(), dataCenters);
    }

    /**
     * Test we don't get null data center service for existing data center id and correct object
     */
    @Test
    public void testGetObjectFromDataCenterService() {
        DataCenterService dcService = dataCentersService.dataCenterService("123");
        DataCenter dc = dcService.get().send().dataCenter();
        assertEquals("123", dc.id());
        assertEquals("testdc", dc.name());
        assertNull(dc.description());
    }
}
