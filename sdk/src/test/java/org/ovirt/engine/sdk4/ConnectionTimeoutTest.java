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

import static org.ovirt.engine.sdk4.ConnectionBuilder.connection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.ovirt.engine.sdk4.services.VmsService;

public class ConnectionTimeoutTest extends ServerTest {

    private Connection connection;
    private VmsService vmsService;

    @Before
    public void setUp() {
        setXmlResponse("vms", 200, "<vms/>", 2);
        startServer();
        connection = connection()
            .url(testUrl())
            .user(testUser())
            .password(testPassword())
            .timeout(1)
            .trustStoreFile(testTrustStoreFile())
            .trustStorePassword(testTrustStorePassword())
            .build();
        vmsService = connection.systemService().vmsService();
    }

    @After
    public void tearDown() throws Exception {
        connection.close();
        stopServer();
    }
    /**
     * Test when timeout is set, request fail with timeout error
     */
    @Test(expected = RuntimeException.class)
    public void testConnectionTimeout() {
        vmsService.list().send().vms();
    }

}
