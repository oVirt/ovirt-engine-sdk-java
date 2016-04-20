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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.junit.Test;
import org.ovirt.api.metamodel.runtime.xml.XmlReader;
import org.ovirt.engine.sdk4.internal.xml.XmlActionReader;
import org.ovirt.engine.sdk4.types.Action;

public class ActionReaderTest {

    /**
     * Checks that having fault action empty is handled correctly
     */
    @Test
    public void testFaultActionNoValue() throws Exception {
        try (
            InputStream stream = new ByteArrayInputStream("<fault/>".getBytes(StandardCharsets.UTF_8));
            XmlReader reader = new XmlReader(stream)
        ) {
            Action action = XmlActionReader.readOne(reader);
            assertFalse(action.statusPresent());
            assertFalse(action.faultPresent());
            assertNull(action.fault());
            assertNull(action.status());
        }
    }

    /**
     * Checks that having action with state is handled correctly
     */
    @Test
    public void testActionWithState() throws Exception {
        String response = "<action><status><state>mystate</state></status></action>";
        try (
            InputStream stream = new ByteArrayInputStream(response.getBytes(StandardCharsets.UTF_8));
            XmlReader reader = new XmlReader(stream)
        ) {
            Action action = XmlActionReader.readOne(reader);
            assertTrue(action.statusPresent());
            assertTrue(action.status().statePresent());
            assertEquals("mystate", action.status().state());
        }
    }

    /**
     * Checks that having fault action with reason and detail is handled correctly
     */
    @Test
    public void testFaultActionWithReason() throws Exception {
        String response = "<action><fault><reason>myreason</reason><detail>mydetail</detail></fault></action>";
        try (
            InputStream stream = new ByteArrayInputStream(response.getBytes(StandardCharsets.UTF_8));
            XmlReader reader = new XmlReader(stream)
        ) {
            Action action = XmlActionReader.readOne(reader);
            assertTrue(action.faultPresent());
            assertTrue(action.fault().reasonPresent());
            assertEquals("myreason", action.fault().reason());
            assertTrue(action.fault().detailPresent());
            assertEquals("mydetail", action.fault().detail());
        }
    }

    /**
     * Checks that having fault and status action is handled correctly
     */
    @Test
    public void testFaultAndStatusActionW() throws Exception {
        String response =
            "<action><status><state>mystate</state></status><fault><reason>myreason</reason></fault></action>";
        try (
            InputStream stream = new ByteArrayInputStream(response.getBytes(StandardCharsets.UTF_8));
            XmlReader reader = new XmlReader(stream)
        ) {
            Action action = XmlActionReader.readOne(reader);
            // Check state:
            assertTrue(action.statusPresent());
            assertTrue(action.status().statePresent());
            assertEquals("mystate", action.status().state());
            // Check reason:
            assertTrue(action.faultPresent());
            assertTrue(action.fault().reasonPresent());
            assertEquals("myreason", action.fault().reason());
        }
    }
}