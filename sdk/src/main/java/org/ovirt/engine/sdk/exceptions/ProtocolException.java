package org.ovirt.engine.sdk.exceptions;

/**
 * Thrown during any kind of protocol failures
 */
public class ProtocolException extends OvirtSdkRuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 6566413883513675015L;

    /**
     * Constructs an <code>ProtocolException</code> without a detail message.
     */
    public ProtocolException() {
        super();
    }

    /**
     * @param message
     *            exception message
     * @param cause
     *            exception cause
     */
    public ProtocolException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param message
     *            exception message
     */
    public ProtocolException(String message) {
        super(message);
    }

    /**
     * @param cause
     *            exception cause
     */
    public ProtocolException(Throwable cause) {
        super(cause);
    }
}
