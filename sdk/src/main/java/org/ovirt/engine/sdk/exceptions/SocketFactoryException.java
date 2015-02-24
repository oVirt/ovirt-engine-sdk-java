package org.ovirt.engine.sdk.exceptions;

/**
 * Thrown during socket initialization failures
 */
public class SocketFactoryException extends OvirtSdkRuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = -6815039672561541599L;

    /**
     * Constructs an <code>SocketFactoryException</code> without a detail message.
     */
    public SocketFactoryException() {
        super();
    }

    /**
     * @param message
     *            exception message
     * @param cause
     *            exception cause
     */
    public SocketFactoryException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param message
     *            exception message
     */
    public SocketFactoryException(String message) {
        super(message);
    }

    /**
     * @param cause
     *            exception cause
     */
    public SocketFactoryException(Throwable cause) {
        super(cause);
    }

}