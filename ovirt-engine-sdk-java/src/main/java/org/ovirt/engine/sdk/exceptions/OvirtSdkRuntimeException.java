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
 * Base oVirt runtime exception
 */
public abstract class OvirtSdkRuntimeException extends RuntimeException {

    private static final long serialVersionUID = -6243028486635352502L;

    /**
     * Constructs a new OvirtSdkRuntimeException with {@code null} as its detail message.
     * The cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     */
    public OvirtSdkRuntimeException() {
        super();
    }

    /**
     * @param message
     *            exception message
     */
    public OvirtSdkRuntimeException(String message) {
        super(message);
    }

    /**
     * @param throwable
     *            exception cause
     */
    public OvirtSdkRuntimeException(Throwable throwable) {
        super(throwable);
    }

    /**
     * @param message
     *            exception message
     * @param cause
     *            exception cause
     */
    public OvirtSdkRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }
}
