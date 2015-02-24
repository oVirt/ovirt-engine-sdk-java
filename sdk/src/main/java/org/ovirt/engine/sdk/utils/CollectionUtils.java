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

package org.ovirt.engine.sdk.utils;

import java.util.List;

import org.ovirt.engine.sdk.entities.BaseResource;

/**
 * Provides collection related services
 */
public class CollectionUtils {
    /**
     * Fetches item from the collection by name
     * 
     * @param name
     *            item name
     * @param collection
     *            collection to look at
     * 
     * @return T or null
     */
    public static <T extends BaseResource> T getItemByName(String name, List<T> collection) {
        for (T item : collection) {
            if (!StringUtils.isNull(item.getName()) && item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }

    /**
     * Fetches first item from the collection
     * 
     * @param collection
     *            collection to look at
     * 
     * @return T or null
     */
    public static <T extends BaseResource> T getFirstItem(List<T> collection) {
        return collection != null && collection.size() > 0 ? collection.get(0) : null;
    }
}
