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
import java.util.HashMap;
import java.util.Map;

import org.ovirt.engine.sdk4.internal.HttpConnection;
import org.ovirt.engine.sdk4.internal.NoCaTrustManager;

/**
 * This class is used to build connections to the API server.
 */
public abstract class ConnectionBuilder {
    protected static final String BAD_PROTOCOL_ERROR = "Unsupported protocol ";
    protected static final String BAD_KEY_ERROR = "SSL context initiation has failed because of key error.";
    protected static final String NO_TLS_ERROR = "SSL context initiation has failed locating TLS algorithm.";
    protected static final String KEY_STORE_ERROR = "CA certificate keystore initiation has failed.";
    protected static final String KEY_STORE_FILE_NOT_FOUND_ERROR = "CA certificate keystore was not found.";
    protected static final String CERTIFICATE_ERROR = "CA certificate error.";
    protected static final String IO_ERROR = "I/O error occurred, is your keystore password correct?";

    protected static String HTTP_PROTOCOL = "http";
    protected static String HTTPS_PROTOCOL = "https";

    protected String url;
    protected String user;
    protected String password;
    protected String token;
    protected boolean insecure = false;
    protected boolean kerberos = false;
    protected int timeout = 0;
    protected boolean compress = true;
    protected Map<String, String> headers = new HashMap<>();
    protected String trustStoreFile;
    protected URL urlobj;
    protected String trustStorePassword;
    protected NoCaTrustManager noCaTrustManager = new NoCaTrustManager();
    // SSO attributes:
    private String ssoUrl;
    private String ssoRevokeUrl;
    private String ssoTokenName = "access_token";


    public ConnectionBuilder() {
    }

    /**
     * Creates a new connection builder.
     */
    public static ConnectionBuilder connection() {
        Class<? extends ConnectionBuilder> clazz = null;
        try {
            clazz = (Class<ConnectionBuilder>) Class.forName("org.ovirt.engine.sdk4.internal.ConnectionBuilder45");
        }
        catch (Throwable ex) {
            try {
                clazz = (Class<ConnectionBuilder>) Class.forName("org.ovirt.engine.sdk4.internal.ConnectionBuilder42");
            }
            catch (Throwable e) {
                throw new Error("No connection implementation found", e);
            }
        }

        try {
            return clazz.newInstance();
        }
        catch (Exception e) {
            throw new Error("Failed to initialize connection implementation", e);
        }
    }

    /**
     * Set a Url of connection.
     *
     * @param url A string containing the base URL of the server, usually something like
     * 'https://server.example.com/ovirt-engine/api'
     */
    public ConnectionBuilder url(String url) {
        this.url = url;
        return this;
    }

    /**
     * Set user
     *
     * @param user
     */
    public ConnectionBuilder user(String user) {
        this.user = user;
        return this;
    }

    /**
     * Set password
     *
     * @param password The password of the user
     */
    public ConnectionBuilder password(String password) {
        this.password = password;
        return this;
    }

    /**
     * The token to be used to access API. Optionally, user can
     * use token, instead of username and password to access API. If user
     * don't specify `token` parameter, SDK will automatically create one.
     */
    public ConnectionBuilder token(String token) {
        this.token = token;
        return this;
    }

    /**
     * Set insecure flag
     *
     * @param insecure A boolean flag that indicates if the server TLS certificate and host
     * name should be checked.
     */
    public ConnectionBuilder insecure(boolean insecure) {
        this.insecure = insecure;
        return this;
    }

    /**
     * Set kerberos flag
     *
     * @param kerberos A boolean flag indicating if Kerberos authentication should be used
     * instead of the default basic authentication. Default is false.
     */
    public ConnectionBuilder kerberos(boolean kerberos) {
        this.kerberos = kerberos;
        return this;
    }

    /**
     * Set timeout
     *
     * @param timeout The maximum total time to wait for the response, in
     * seconds. A value of zero (the default) means wait for ever. If
     * the timeout expires before the response is received an exception
     * will be raised.
     */
    public ConnectionBuilder timeout(int timeout) {
        this.timeout = timeout;
        return this;
    }

    /**
     * Set a compress flag
     *
     * @param compress A flag indicating if the SDK should ask
     * the server to send compressed responses. The default is `true`.
     * Note that this is a hint for the server, and that it may return
     * uncompressed data even when this parameter is set to `true`.
     */
    public ConnectionBuilder compress(boolean compress) {
        this.compress = compress;
        return this;
    }

    /**
     * Set the password that is required to open the file containing the CA certificates. Note that for Java key store
     * files the password is used only to check the integrity of the file, so it is optional.
     */
    public ConnectionBuilder trustStorePassword(String trustStorePassword) {
        this.trustStorePassword = trustStorePassword;
        return this;
    }

    /**
     * Set the path of the file containing the trusted CA certificates. This file must be a valid Java key store,
     * using the Java `JKS` format, usually contained within files ending with the `.jks` extension.
     * If `trustStoreFile` parameter is not set, then default Java trust store location is used, which is defined by
     * `javax.net.ssl.trustStore` system property.
     */
    public ConnectionBuilder trustStoreFile(String trustStoreFile) {
        this.trustStoreFile = trustStoreFile;
        return this;
    }

    /**
     * Set SSO url
     *
     * @param ssoUrl A string containing the base SSO URL of the server, usually something like
     * `\https://server.example.com/ovirt-engine/sso/oauth/token?`
     * `\grant_type=password&scope=ovirt-app-api` for password authentication or
     * `\https://server.example.com/ovirt-engine/sso/oauth/token-http-auth?`
     * `\grant_type=urn:ovirt:params:oauth:grant-type:http&scope=ovirt-app-api` for kerberos authentication
     * Default SSO url is computed from the `url` if no `sso_url` is provided.
     */
    public ConnectionBuilder ssoUrl(String ssoUrl) {
        this.ssoUrl = ssoUrl;
        return this;
    }

    /**
     * Set SSO revoke url
     *
     * @param ssoRevokeUrl A string containing the base URL of the SSO revoke service. This needs to be specified only
     * when using an external authentication service. By default this URL is automatically
     * calculated from the value of the `url` parameter, so that SSO token revoke will be performed
     * using the SSO service that is part of the engine.
     */
    public ConnectionBuilder ssoRevokeUrl(String ssoRevokeUrl) {
        this.ssoRevokeUrl = ssoRevokeUrl;
        return this;
    }

    /**
     * Set SSO token name
     *
     * @param ssoTokenName The token name in the JSON SSO response returned from the SSO
     * server. Default value is `access_token`.
     */
    public ConnectionBuilder ssoTokenName(String ssoTokenName) {
        this.ssoTokenName = ssoTokenName;
        return this;
    }

    /**
     * Custom HTTP headers to send with all requests. The keys of the map can be strings of symbols, and they will be
     * used as the names of the headers. The values of the map will be used as the names of the headers. If the same
     * header is provided here and in the `headers` parameter of a specific method call, then the `headers` parameter
     * of the specific method call will have precedence.
     */
    public ConnectionBuilder header(String name, String value) {
        headers.put(name, value);
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
                throw new IllegalArgumentException("The 'url' parameter is mandatory");
            }
            if (trustStoreFile != null && !new File(trustStoreFile).exists()) {
                throw new IllegalArgumentException(
                    String.format("The truststore file '%s' doesn't exist'", trustStoreFile)
                );
            }
            urlobj = new URL(url);

            // If all the checks pass, then create the connection:
            HttpConnection connection = new HttpConnection();
            connection.setClient(createHttpClient());
            connection.setUrl(url);
            connection.setUser(user);
            connection.setPassword(password);
            connection.setSsoToken(token);
            connection.setKerberos(kerberos);
            connection.setSsoUrl(ssoUrl);
            connection.setSsoTokenName(ssoTokenName);
            connection.setSsoRevokeUrl(ssoRevokeUrl);
            connection.setHeaders(headers);
            return connection;
        }
        catch (Exception e) {
            throw new Error("Failed to build connection", e);
        }
    }

    protected abstract HttpClient createHttpClient();

    protected String getHost() {
        return urlobj.getHost();
    }

    protected String getProtocol() {
        return urlobj.getProtocol();
    }

    protected int getPort() {
        return urlobj.getPort() == -1 ? urlobj.getDefaultPort() : urlobj.getPort();
    }

    /**
     * @return entry point URI
     */
    public String getUrl() {
        return this.url.toString();
    }
}