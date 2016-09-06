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
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import org.junit.Test;
import org.ovirt.api.metamodel.runtime.xml.XmlReader;
import org.ovirt.engine.sdk4.internal.xml.XmlClusterReader;
import org.ovirt.engine.sdk4.types.Cluster;
import org.ovirt.engine.sdk4.types.SwitchType;

public class ClusterReaderTest {

    /**
     * Test given switch type after empty RNG source both are read correctly.
     */
    @Test
    public void testReadValueAfterEmptyList() throws Exception {
        String response =
            "<cluster>" +
              "<required_rng_sources/>" +
              "<switch_type>legacy</switch_type>" +
            "</cluster>";
        try (
            InputStream stream = new ByteArrayInputStream(response.getBytes(StandardCharsets.UTF_8));
            XmlReader reader = new XmlReader(stream)
        ) {
            Cluster cluster = XmlClusterReader.readOne(reader);
            assertEquals(Arrays.asList(), cluster.requiredRngSources());
            assertEquals(SwitchType.LEGACY, cluster.switchType());
        }
    }

}
