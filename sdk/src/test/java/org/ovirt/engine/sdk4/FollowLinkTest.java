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

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.ovirt.engine.sdk4.services.ClusterService;
import org.ovirt.engine.sdk4.services.ClustersService;
import org.ovirt.engine.sdk4.types.Cluster;
import org.ovirt.engine.sdk4.types.DataCenter;

public class FollowLinkTest extends ServerTest {

    private Connection connection;
    private ClustersService clustersService;

    @Before
    public void setUp() {
        setXmlResponse("clusters/123", 200, "<cluster><data_center href=\"/ovirt-engine/api/datacenters/123\"/></cluster>");
        setXmlResponse("datacenters/123", 200, "<data_center><name>testdc</name></data_center>");
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
     * Test follow link to data center from cluster
     */
    @Test
    public void testFollowLinkToDatacenter() {
        ClusterService clusterService = clustersService.clusterService("123");
        Cluster cluster = clusterService.get().send().cluster();
        DataCenter dc = connection.followLink(cluster.dataCenter());
        assertEquals("testdc", dc.name());
    }
}