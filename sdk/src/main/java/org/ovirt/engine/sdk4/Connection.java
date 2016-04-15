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

import org.ovirt.engine.sdk4.services.SystemService;

/**
 * This interface represents a connection to the API server.
 */
public interface Connection extends AutoCloseable {
    /**
     * Returns a reference to the root of the services tree.
     */
    SystemService systemService();

    /**
     * Indicates if the given object is a link. An object is a link if it has an `href` attribute.
     *
     * @param object the object to check
     * @return {@code true} iff the object is a link
     */
    boolean isLink(Object object);

    /**
     * Follows the `href` attribute of the given object, retrieves the target object and returns it.
     *
     * @param object the object containing the `href` attribute
     * @param <TYPE> the type of the target of the link
     * @return the object retrieved from the `href`
     */
    <TYPE> TYPE followLink(TYPE object);
}