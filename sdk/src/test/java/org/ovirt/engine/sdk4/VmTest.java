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

import java.util.Arrays;

import org.junit.Test;
import org.ovirt.engine.sdk4.internal.containers.DiskAttachmentContainer;
import org.ovirt.engine.sdk4.internal.containers.VmContainer;
import org.ovirt.engine.sdk4.types.DiskAttachment;

public class VmTest {

    /**
     * Check when creating null vm disks it creates empty list
     */
    @Test
    public void testVmDiskIsEmpty() {
        VmContainer vm = new VmContainer();
        vm.diskAttachments(null);
        assertNotNull(vm.diskAttachments());
        assertEquals(0, vm.diskAttachments().size());
    }

    /**
     * Check when creating list of vm disks it creates that list
     */
    @Test
    public void testVmDiskWithValues() {
        VmContainer vm = new VmContainer();
        vm.diskAttachments(Arrays.asList((DiskAttachment) new DiskAttachmentContainer()));
        assertNotNull(vm.diskAttachments());
        assertEquals(1, vm.diskAttachments().size());
        assertNotNull(vm.diskAttachments().get(0));
    }
}
