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

import java.util.List;

import org.ovirt.engine.api.model.Action;
import org.ovirt.engine.api.model.VM;
import org.ovirt.engine.sdk.decorators.Vm;

public class Example {
    private static final String URL = "http://localhost:8080/api";

    public static void main(String[] args) throws Exception {
        Api api = new Api(URL, "admin@internal", "123456");

        // #1
        @SuppressWarnings("unused")
        List<Vm> vms = api.getVms().list();

        // #2
        Vm vm = api.getVms().get("f409c734-65f2-4d7c-b25b-3e285d8d5a76");

        // #3
        vm.setDescription(vm.getDescription() + "_12345");
        Vm newVM = vm.update();

        // #4
        @SuppressWarnings("unused")
        Action res = vm.start(new Action() {
            {
                setVm(new VM());
            }
        });

        // #5
        vm.delete();
    }
}
