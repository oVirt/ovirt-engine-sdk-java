/*
Copyright (c) 2017 Red Hat, Inc.

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
import static org.ovirt.engine.sdk4.builders.Builders.cluster;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.ovirt.engine.sdk4.internal.HttpConnection;
import org.ovirt.engine.sdk4.services.ClusterService;
import org.ovirt.engine.sdk4.services.ClustersService;

public class GlobalHeadersTest extends ServerTest {

    private HttpConnection connection;
    private ClustersService clustersService;
    private ClusterService clusterService;

    @Before
    public void setUp() {
        setXmlResponse("clusters", 200, "<clusters/>");
        setXmlResponse("clusters/123", 200, "<cluster id=\"123\"><name>test</name></cluster>");
        startServer();
        connection = (HttpConnection) testConnectionBuilder().header("my", "value").build();
        clustersService = connection.systemService().clustersService();
        clusterService = clustersService.clusterService("123");
    }

    @After
    public void tearDown() throws Exception {
        connection.close();
        stopServer();
    }

    /**
     * Test sending the custom global header with listing the clusters.
     */
    @Test
    public void testListWithCustomGlobalHeader() {
        clustersService.list().send();
        assertEquals("value", getLastRequestHeaders().get("my").getFirst());
    }

    /**
     * Test sending the custom global header with getting the clusters.
     */
    @Test
    public void testLGetWithCustomGlobalHeader() {
        clusterService.get().send();
        assertEquals("value", getLastRequestHeaders().get("my").getFirst());
    }

    /**
     * Test sending the custom global header when adding a cluster.
     */
    @Test
    public void testAddWithCustomGlobalHeader() {
        clustersService.add().cluster(cluster()).send();
        assertEquals("value", getLastRequestHeaders().get("my").getFirst());
    }

    /**
     * Test sending the custom global header when removing a cluster.
     */
    @Test
    public void testRemoveWithCustomGlobalHeader() {
        clusterService.remove().send();
        assertEquals("value", getLastRequestHeaders().get("my").getFirst());
    }
}