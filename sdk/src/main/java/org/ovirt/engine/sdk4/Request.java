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

/**
 * This class represents a request that can be sent to the API server. This interface isn't intended to be used
 * directly, applications should instead use the extensions for specific operations.
 *
 * @param <REQUEST> the specific request type
 * @param <RESPONSE> the specific response type
 */
public interface Request <REQUEST extends Request, RESPONSE extends Response> {
    /**
     * Sends the request to the server, and waits for the response.
     *
     * @return the response received from the server
     */
    RESPONSE send();

    /**
     * Add additional HTTP header.
     *
     * @return the request
     */
    REQUEST header(String name, String value);

    /**
     * Add additional URL query parameter.
     *
     * @return the request
     */
    REQUEST query(String name, String value);
}
