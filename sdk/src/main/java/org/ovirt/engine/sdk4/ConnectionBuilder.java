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

import java.io.File;
import java.net.URL;

import org.apache.http.HttpHost;
import org.apache.http.ProtocolException;
import org.ovirt.engine.sdk4.internal.HttpConnection;
import org.ovirt.engine.sdk4.internal.NoCaTrustManager;

/**
 * This class is used to build connections to the API server.
 */
public abstract class ConnectionBuilder {
    protected static final String BAD_PROTOCOL_ERROR = "Unsupported protocol ";
    protected static final String BAD_KEY_ERROR = "SSL context initiation has failed because of key error.";
    protected static final String NO_TLS_ERROR = "SSL context initiation has failed locating TLS slgorithm.";
    protected static final String KEY_STORE_ERROR = "CA certeficate keystore initiation has failed.";
    protected static final String KEY_STORE_FILE_NOT_FOUND_ERROR = "CA certificate keystore was not found.";
    protected static final String CERTIFICATE_ERROR = "CA certificate error.";
    protected static final String IO_ERROR = "I/O error occurred, is your keystore password correct?";

    protected static String HTTP_PROTOCOL = "http";
    protected static String HTTPS_PROTOCOL = "https";

    protected String url;
    protected String user;
    protected String password;
    protected boolean insecure = false;
    protected boolean kerberos = false;
    protected int timeout = 0;
    protected boolean compress = false;

    protected String keyStorePath;
    protected URL urlobj;
    protected String keyStorePassword;

    protected NoCaTrustManager noCaTrustManager = new NoCaTrustManager();


    public ConnectionBuilder() {
    }

    /**
     * Set a Url of connection.
     *
     * @param url A string containing the base URL of the server, usually something like
     *            'https://server.example.com/ovirt-engine/api'
     * @return ConnectionBuilder
     */
    public ConnectionBuilder url(String url) {
        this.url = url;
        return this;
    }

    /**
     * Set user
     *
     * @param user
     * @return ConnectionBuilder
     */
    public ConnectionBuilder user(String user) {
        this.user = user;
        return this;
    }

    /**
     * Set password
     *
     * @param password The password of the user
     * @return ConnectionBuilder
     */
    public ConnectionBuilder password(String password) {
        this.password = password;
        return this;
    }

    /**
     * Set insecure flag
     *
     * @param insecure A boolean flag that indicates if the server TLS certificate and host
     *                 name should be checked.
     * @return ConnectionBuilder
     */
    public ConnectionBuilder insecure(boolean insecure) {
        this.insecure = insecure;
        return this;
    }

    /**
     * Set kerberos flag
     *
     * @param kerberos A boolean flag indicating if Kerberos authentication should be used
     *                 instead of the default basic authentication. Default is false.
     * @return ConnectionBuilder
     */
    public ConnectionBuilder kerberos(boolean kerberos) {
        this.kerberos = kerberos;
        return this;
    }

    /**
     * Set timeout
     *
     * @param timeout The maximum total time to wait for the response, in
     *                seconds. A value of zero (the default) means wait for ever. If
     *                the timeout expires before the response is received an exception
     *                will be raised.
     * @return
     */
    public ConnectionBuilder timeout(int timeout) {
        this.timeout = timeout;
        return this;
    }

    /**
     * Set a compress flag
     *
     * @param compress A flag indicating if the SDK should ask
     *                 the server to send compressed responses. The default is `false`.
     *                 Note that this is a hint for the server, and that it may return
     *                 uncompressed data even when this parameter is set to `true`.
     * @return
     */
    public ConnectionBuilder compress(boolean compress) {
        this.compress = compress;
        return this;
    }

    /**
     * Set keystore password
     *
     * @param keyStorePassword
     * @return
     */
    public ConnectionBuilder keyStorePassword(String keyStorePassword) {
        this.keyStorePassword = keyStorePassword;
        return this;
    }

    /**
     * Set keystore path
     *
     * @param keyStorePath
     * @return
     */
    public ConnectionBuilder keyStorePath(String keyStorePath) {
        this.keyStorePath = keyStorePath;
        return this;
    }


    /**
     * Checks the values of the parameters given so far, checks that they are valid, and builds a connection using
     * them.
     *
     * @return the new connection
     */
    public Connection build() {
        try {
            // Check the parameters:
            if (url == null) {
                throw new RuntimeException("The 'url' parameter is mandatory");
            }
            if (!insecure && keyStorePath == null) {
                throw new RuntimeException("The 'keyStorePath' is mandatory in secure mode");
            }
            if (keyStorePath != null && !new File(keyStorePath).exists()) {
                throw new RuntimeException(
                    String.format("The keystore file '%s' doesn't exist'", keyStorePath)
                );
            }
            urlobj = new URL(url);

            // If all the checks pass, then create the connection:
            HttpConnection connection = new HttpConnection();
            connection.setClient(createHttpClient());
            connection.setUrl(url);
            connection.setUser(user);
            connection.setPassword(password);
            connection.setInsecure(insecure);
            connection.setKerberos(kerberos);
            return connection;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected abstract HttpClient createHttpClient() throws ProtocolException;

    protected String getHost() {
        return urlobj.getHost();
    }

    protected String getProtocol() {
        return urlobj.getProtocol();
    }

    protected int getPort() {
        return urlobj.getPort();
    }

    /**
     * @return entry point URI
     */
    public String getUrl() {
        return this.url.toString();
    }

    /**
     * Creates a new connection builder.
     */
    public static ConnectionBuilder connection() {
        Class<? extends ConnectionBuilder> clazz = null;
        try {
            clazz = (Class<ConnectionBuilder>) Class.forName("org.ovirt.engine.sdk4.internal.ConnectionBuilder45");
        }
        catch (ClassNotFoundException ex) {
            try {
                clazz = (Class<ConnectionBuilder>) Class.forName("org.ovirt.engine.sdk4.internal.ConnectionBuilder42");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(ex);
            }
        }

        try {
            return clazz.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}