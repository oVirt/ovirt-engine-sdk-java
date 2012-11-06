package org.ovirt.engine.sdk.exceptions;

public class UnsecuredConnectionAttemptError extends OvirtSdkException {

    private static final long serialVersionUID = -6960146611526056754L;
    private static String MESSAGE =
            "No response returned from server. If you're using HTTP protocol\n" +
                    "against a SSL secured server, then try using HTTPS instead.";

    public UnsecuredConnectionAttemptError() {
        super(MESSAGE);
    }
}
