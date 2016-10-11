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

import static org.ovirt.engine.sdk4.builders.Builders.vm;

import org.junit.Test;
import org.ovirt.engine.sdk4.services.VmsService;

public class ResponseCodeTest extends ServerTest {

    /**
     * Test when server return response with 200 code,
     * the SDK don't raise exception.
     */
    @Test
    public void test200codeDontThrowException() throws Exception {
        setXmlResponse("vms", 200, "<vms/>");
        startServer();
        Connection connection = testConnection();
        VmsService vmsService = connection.systemService().vmsService();
        vmsService.add().vm(vm()).send();
        connection.close();
        stopServer();
    }

    /**
     * Test when server return response with 201 code,
     * the SDK don't raise exception.
     */
    @Test
    public void test201codeDontThrowException() throws Exception {
        setXmlResponse("vms", 201, "<vms/>");
        startServer();
        Connection connection = testConnection();
        VmsService vmsService = connection.systemService().vmsService();
        vmsService.add().vm(vm()).send();
        connection.close();
        stopServer();
    }

    /**
     * Test when server return response with 202 code,
     * the SDK don't raise exception.
     */
    @Test
    public void test202codeDontThrowException() throws Exception {
        setXmlResponse("vms", 202, "<vms/>");
        startServer();
        Connection connection = testConnection();
        VmsService vmsService = connection.systemService().vmsService();
        vmsService.add().vm(vm()).send();
        connection.close();
        stopServer();
    }

}
