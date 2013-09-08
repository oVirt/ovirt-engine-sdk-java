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

package org.ovirt.engine.sdk.exceptions;

/**
 * Base oVirt exception
 */
public abstract class OvirtSdkException extends Exception {
    private static final long serialVersionUID = -5983358219123325129L;

    /**
     * Constructs a new OvirtSdkException with {@code null} as its detail message.
     * The cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     */
    public OvirtSdkException() {
        super();
    }

    /**
     * @param message
     *            exception message
     */
    public OvirtSdkException(String message) {
        super(message);
    }

    /**
     * @param throwable
     *            exception cause
     */
    public OvirtSdkException(Throwable throwable) {
        super(throwable);
    }
}
