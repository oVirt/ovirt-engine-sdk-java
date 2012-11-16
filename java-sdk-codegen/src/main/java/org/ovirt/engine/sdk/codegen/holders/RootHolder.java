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

package org.ovirt.engine.sdk.codegen.holders;

import java.util.HashMap;
import java.util.Map;

/**
 * Holds root-collections holders
 */
public class RootHolder implements IHolder {

    private Map<String, RootCollectionHolder> collections;

    public RootHolder() {
        this.collections = new HashMap<String, RootCollectionHolder>();
    }

    /**
     * Adds root collection
     * 
     * @param name
     *            collection name
     * @param collection
     *            root collection
     */
    public void addCollection(String name, RootCollectionHolder collection) {
        this.collections.put(name, collection);
    }

    /**
     * Return all collections
     */
    public Map<String, RootCollectionHolder> getCollections() {
        return collections;
    }
}
