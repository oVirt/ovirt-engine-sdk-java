package org.ovirt.engine.sdk.exceptions;

/**
 * Thrown during internals SDK failures
 */
public class MarshallingException extends OvirtSdkRuntimeException {

    private static final long serialVersionUID = -7751946172143424807L;

    /**
     * Constructs an <code>MarshallingException</code> without a detail message.
     */
    public MarshallingException() {
        super();
    }

    /**
     * @param message
     *            exception message
     * @param cause
     *            exception cause
     */
    public MarshallingException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param message
     *            exception message
     */
    public MarshallingException(String message) {
        super(message);
    }

    /**
     * @param cause
     *            exception cause
     */
    public MarshallingException(Throwable cause) {
        super(cause);
    }
}
