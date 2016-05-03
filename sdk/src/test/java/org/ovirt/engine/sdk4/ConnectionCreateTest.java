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

import org.junit.Test;

public class ConnectionCreateTest extends ServerTest {

    /**
     * Test exception is thrown when no CA is provided to connection
     */
    @Test(expected = Error.class)
    public void testSecureModeWithoutCA() {
        connection()
            .url(testUrl())
            .user(testUser())
            .password(testPassword())
            .build();
    }

    /**
     * Test exception isn't thrown when CA is provided to connection
     */
    @Test
    public void testSecureModeWithCA() throws Exception {
        Connection connection = testConnection();
        connection.close();
    }

    /**
     * Test that CA isn't required in insecure mode
     */
    @Test
    public void testInsecureModeWithoutCA() throws Exception {
        Connection connection = connection()
            .url(testUrl())
            .user(testUser())
            .password(testPassword())
            .insecure(true)
            .build();
        connection.close();
    }

    /**
     * Test creation of kerberos connection
     */
    @Test
    public void testKerberosAuth() throws Exception {
        Connection connection = connection()
            .url(testUrl())
            .kerberos(true)
            .trustStoreFile(testTrustStoreFile())
            .trustStorePassword(testTrustStorePassword())
            .build();
        connection.close();
    }
}