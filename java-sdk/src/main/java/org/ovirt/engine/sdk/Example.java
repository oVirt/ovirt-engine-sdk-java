//
// Copyright (c) 2012 Red Hat, Inc.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//           http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
//

package org.ovirt.engine.sdk;

import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.apache.http.client.ClientProtocolException;
import org.ovirt.engine.sdk.decorators.VM;
import org.ovirt.engine.sdk.decorators.VMStatistic;
import org.ovirt.engine.sdk.entities.Action;
import org.ovirt.engine.sdk.exceptions.ServerException;
import org.ovirt.engine.sdk.exceptions.UnsecuredConnectionAttemptError;

public class Example {
    private static final String URL = "http://localhost:8080/api";

    public static void main(String[] args) throws ClientProtocolException, ServerException,
            UnsecuredConnectionAttemptError, IOException, JAXBException {
        Api api = new Api(URL, "admin@internal", "123456");

        // #1
        @SuppressWarnings("unused")
        List<VM> vms = api.getVMs().list();

        // #2
        VM vm = api.getVMs().get("test");

        // #3
        vm.setDescription("java_sdk_test");
        @SuppressWarnings("unused")
        VM newVM = vm.update();

        // #4
        @SuppressWarnings("unused")
        Action res = vm.start(new Action() {
            {
                setVm(new org.ovirt.engine.sdk.entities.VM());
            }
        });

        // #5
        @SuppressWarnings("unused")
        List<VMStatistic> vmstatistics = vm.getStatistics().list();

        // #6
        @SuppressWarnings("unused")
        VMStatistic vmstatistic = vm.getStatistics().get("5a89a1d2-32be-33f7-a0d1-f8b5bc974ff6");

        // #7
        vm.delete();
    }
}
