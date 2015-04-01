//
// Copyright (c) 2015 Red Hat, Inc.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
//

package org.ovirt.engine.sdk.generator;

import org.ovirt.engine.sdk.entities.DetailedLink;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

/**
 * This class stores information that the generator needs to remember. Thss information will be loaded when the
 * generator starts (usually from an {@code memory.properties} file), potentially updated during the execution, and
 * saved when the generator finishes. In addition to the typical methods to get and put properties this class also
 * provides some methods to simplify handling properties associated to instances of the {@link DetailedLink} class, as
 * that is what the generator will actually use.
 */
public class Memory {
    /**
     * This is a singleton, and this is the reference to the instance.
     */
    private static final Memory instance = new Memory();

    /**
     * Get the reference to the instance of this singleton.
     */
    public static Memory getInstance() {
        return instance;
    }

    /**
     * The properties stored in the memory.
     */
    private Properties properties = new Properties();

    /**
     * Loads the contents of the memory.
     *
     * @param file the file that contains the memory
     * @throws IOException if something fails while loading the memory
     */
    public void load(File file) throws IOException {
        try (InputStream in = new FileInputStream(file)) {
            properties.load(in);
        }
    }

    /**
     * Saves the contents of the memory.
     *
     * @param file the file that will contain the memory
     * @throws IOException if something fails while saving the memory
     */
    public void save(File file) throws IOException {
        // We need to write the properties sorted by key, to make sure that the order is predictable and that the result
        // is diff friendly:
        try (PrintWriter writer = new PrintWriter(file)) {
            List<String> keys = new ArrayList<>(properties.stringPropertyNames());
            Collections.sort(keys);
            for (String key : keys) {
                String value = properties.getProperty(key);
                writer.printf("%s=%s\n", key, value);
            }
        }
    }

    /**
     * Clears the contents of the memory.
     */
    public void clear() {
        properties.clear();
    }

    /**
     * Returns the value associated with the given key.
     *
     * @param key the key
     * @return the value associated with the given key, or {@code null} if there is no value associated with that key
     */
    public String get(String key) {
        return properties.getProperty(key);
    }

    /**
     * Associates a value with a key. If the key was associated with another value before, that value will be replaced
     * with the new one.
     *
     * @param key the key
     * @param value the value
     */
    public void put(String key, String value) {
        properties.setProperty(key, value);
    }

    /**
     * Returns the value associated with the given prefix and link. This is intended to store multiple items related
     * to a link, for example, to store the order of header parameters for a link the file will contain the following
     * properties:
     *
     * <pre>
     * link.vms.vm_id..get.headers=Expect Correlation-Id
     * </pre>
     *
     * Then the caller will be able to retrieve this as follows:
     *
     * <pre>
     * DetailedLink link = ...;
     * Memory memory = Memory.getInstance();
     * String headers = memory.get(link, "headers");
     * </pre>
     *
     * @param link the link
     * @param key the prefix
     * @return value associated with the given link and key, or {@code null} if there is no such value
     */
    public String get(DetailedLink link, String key) {
        return get(makeKey(link, key));
    }

    /**
     * Associates a value to a given link and key.
     *
     * @param link the link
     * @param key the key
     * @param value the new value
     */
    public void put(DetailedLink link, String key, String value) {
        put(makeKey(link, key), value);
    }

    /**
     * Returns the list of values associated with a given link and key.
     *
     * @param link the link
     * @param key the key
     * @return the list of values associated with the given link and key, or an empty list if no such key exists or
     *     the list of values is empty, will never return {@code null}
     */
    public List<String> getList(DetailedLink link, String key) {
        String value = get(link, key);
        if (value == null || value.isEmpty()) {
            return Collections.emptyList();
        }
        return Arrays.asList(value.split("\\s"));
    }

    /**
     * Associates a list of values associated with the given link and key.
     *
     * @param link the link
     * @param key the key
     */
    public void putList(DetailedLink link, String key, List<String> values) {
        if (values == null) {
            values = Collections.emptyList();
        }
        String value = String.join(" ", values);
        put(link, key, value);
    }

    /**
     * Generates a unique key for a link and a non-unique key.
     *
     * @param link the link
     * @param key the key
     * @returns the unique key
     */
    private String makeKey(DetailedLink link, String key) {
        String href = link.getHref();
        href = href.replaceAll("/", ".");
        href = href.replaceAll("[{}]", "");
        href = href.replaceAll(":", "_");
        return "link." + href + "." + link.getRel() + "." + key;
    }
}
