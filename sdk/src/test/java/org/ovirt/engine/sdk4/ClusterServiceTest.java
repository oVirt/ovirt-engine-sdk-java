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
import org.ovirt.engine.sdk4.services.ClusterService;
import org.ovirt.engine.sdk4.services.ClustersService;
import org.ovirt.engine.sdk4.types.Cluster;

public class ClusterServiceTest extends ServerTest {

    private Connection connection;
    private ClustersService clustersService;

    @Before
    public void setUp() {
        setXmlResponse("clusters", 200, "<clusters/>");
        setXmlResponse("clusters/123", 200, "<cluster id=\"123\"><name>testcluster</name></cluster>");
        startServer();
        connection = testConnection();
        clustersService = connection.systemService().clustersService();
    }

    @After
    public void tearDown() throws Exception {
        connection.close();
        stopServer();
    }

    /**
     * Test we don't get null clusters service
     */
    @Test
    public void testGetService() {
        assertNotNull(clustersService);
    }

    /**
     * Test returning empty clusters list
     */
    @Test
    public void testEmptyListResponse() {
        List<Cluster> clusters = clustersService.list().send().clusters();
        assertNotNull(clusters);
        assertEquals(new ArrayList<Cluster>(), clusters);
    }

    /**
     * Test list clusters with query
     */
    @Test
    public void testEmptyListResponseWithQuery() {
        List<Cluster> clusters = clustersService.list().search("name=ugly").send().clusters();
        assertNotNull(clusters);
        assertEquals(new ArrayList<Cluster>(), clusters);
    }

    /**
     * Test we don't get null cluster service for existing cluster id and correct object
     */
    @Test
    public void testGetObjectFromClusterService() {
        ClusterService clusterService = clustersService.clusterService("123");
        Cluster cluster = clusterService.get().send().cluster();
        assertEquals("123", cluster.id());
        assertEquals("testcluster", cluster.name());
        assertNull(cluster.description());
    }
}