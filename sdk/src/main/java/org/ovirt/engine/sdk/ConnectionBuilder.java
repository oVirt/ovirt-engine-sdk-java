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

package org.ovirt.engine.sdk;

import org.apache.http.ProtocolException;
import org.apache.http.auth.AuthSchemeProvider;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.AuthSchemes;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Lookup;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.impl.auth.SPNegoSchemeFactory;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;
import org.ovirt.engine.sdk.internal.HttpConnection;
import org.ovirt.engine.sdk.internal.NoCaTrustManager;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.cert.CertificateException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * This class is used to build connections to the API server.
 */
public class ConnectionBuilder {
    private static final String BAD_PROTOCOL_ERROR = "Unsupported protocol ";
    private static final String BAD_KEY_ERROR = "SSL context initiation has failed because of key error.";
    private static final String NO_TLS_ERROR = "SSL context initiation has failed locating TLS slgorithm.";
    private static final String KEY_STORE_ERROR = "CA certeficate keystore initiation has failed.";
    private static final String KEY_STORE_FILE_NOT_FOUND_ERROR = "CA certificate keystore was not found.";
    private static final String CERTIFICATE_ERROR = "CA certificate error.";
    private static final String IO_ERROR = "I/O error occurred, is your keystore password correct?";

    private static String HTTP_PROTOCOL = "http";
    private static String HTTPS_PROTOCOL = "https";

    private String url;
    private String user;
    private String password;
    private boolean insecure = false;
    private boolean debug = false;
    private boolean kerberos = false;
    private String log;
    private int timeout = 0;
    private boolean compress = false;
    private String ssoUrl;
    private boolean ssoInsecure;
    private boolean ssoDebug;
    private String ssoLog;
    private int ssoTimeout;
    private String ssoTokenName;

    private String keyStorePath;
    private URL urlobj;
    private String keyStorePassword;

    NoCaTrustManager noCaTrustManager = new NoCaTrustManager();


    class SocketFactoryException extends Exception {
        public SocketFactoryException(String msg, Exception e) {
            super(msg, e);
        }
    }

    private ConnectionBuilder() {
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
            connection.setClient(createDefaultHttpClient());
            connection.setUrl(url);
            connection.setUser(user);
            connection.setPassword(password);
            connection.setInsecure(insecure);
            connection.setDebug(debug);
            connection.setKerberos(kerberos);
            return connection;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Creates CloseableHttpClient
     *
     * @return {@link CloseableHttpClient}
     */
    private CloseableHttpClient createDefaultHttpClient() throws ProtocolException, SocketFactoryException {
        int port = getPort();
        Lookup<AuthSchemeProvider> authSchemeProvider = null;
        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        AuthScope authScope = new AuthScope(getHost(), port, AuthScope.ANY_REALM, AuthScope.ANY_SCHEME);

        if (user != null && user.length() > 0) {
            credsProvider.setCredentials(
                authScope,
                new UsernamePasswordCredentials(user, password)
            );
        } else if (kerberos) {
            authSchemeProvider = RegistryBuilder.<AuthSchemeProvider>create()
                .register(AuthSchemes.SPNEGO, new SPNegoSchemeFactory(true))
                .build();
            credsProvider.setCredentials(
                authScope,
                new Credentials() {
                    @Override
                    public Principal getUserPrincipal() {
                        return null;
                    }

                    @Override
                    public String getPassword() {
                        return null;
                    }
                }
            );
        }

        RequestConfig globalConfig = RequestConfig.custom()
            .setCookieSpec(CookieSpecs.BEST_MATCH)
            .setConnectionRequestTimeout(timeout)
            .build();
        CloseableHttpClient client = HttpClientBuilder.create()
            .setConnectionManager(new BasicHttpClientConnectionManager(createConnectionSocketFactoryRegistry()))
            .setDefaultRequestConfig(globalConfig)
            .setDefaultCredentialsProvider(credsProvider)
            .setDefaultAuthSchemeRegistry(authSchemeProvider)
            // TODO: set Keep Alive Strategy?
            .build();

        return client;
    }

    /**
     * Creates ConnectionSocketFactory Registry
     *
     * @return {@link Registry}
     */
    private Registry createConnectionSocketFactoryRegistry() throws ProtocolException, SocketFactoryException {
        String protocol = getProtocol();
        Registry registry = null;

        // Create SSL/TLS or plain connection:
        if (HTTP_PROTOCOL.equals(protocol)) {
            ConnectionSocketFactory plainsf = PlainConnectionSocketFactory.getSocketFactory();
            registry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register(HTTP_PROTOCOL, plainsf)
                .build();
        } else if (HTTPS_PROTOCOL.equals(protocol)) {
            try {
                LayeredConnectionSocketFactory sslsf = null;
                if (this.insecure) {
                    SSLContext sslcontext = SSLContext.getInstance("TLS");
                    sslcontext.init(null, new TrustManager[]{noCaTrustManager}, null);
                    sslsf = new SSLConnectionSocketFactory(
                        sslcontext,
                        SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER
                    );
                } else {
                    InputStream in = null;
                    KeyStore truststore = KeyStore.getInstance(KeyStore.getDefaultType());
                    try {
                        in = new FileInputStream(this.keyStorePath);
                        truststore.load(
                            in,
                            this.keyStorePassword != null ? this.keyStorePassword.toCharArray() : null
                        );
                    } finally {
                        if (in != null) {
                            in.close();
                        }
                    }

                    SSLContext sslContext = SSLContexts.custom()
                        .loadTrustMaterial(truststore)
                        .useTLS()
                        .build();
                    sslsf = new SSLConnectionSocketFactory(
                        sslContext,
                        SSLConnectionSocketFactory.STRICT_HOSTNAME_VERIFIER
                    );
                }
                registry = RegistryBuilder.<ConnectionSocketFactory>create()
                    .register(HTTPS_PROTOCOL, sslsf)
                    .build();
            } catch (NoSuchAlgorithmException e) {
                throw new SocketFactoryException(NO_TLS_ERROR, e);
            } catch (KeyManagementException e) {
                throw new SocketFactoryException(BAD_KEY_ERROR, e);
            } catch (KeyStoreException e) {
                throw new SocketFactoryException(KEY_STORE_ERROR, e);
            } catch (FileNotFoundException e) {
                throw new SocketFactoryException(KEY_STORE_FILE_NOT_FOUND_ERROR, e);
            } catch (CertificateException e) {
                throw new SocketFactoryException(CERTIFICATE_ERROR, e);
            } catch (IOException e) {
                throw new SocketFactoryException(IO_ERROR, e);
            }

        } else {
            throw new ProtocolException(BAD_PROTOCOL_ERROR + protocol);
        }

        return registry;
    }

    private String getHost() {
        return urlobj.getHost();
    }

    private String getProtocol() {
        return urlobj.getProtocol();
    }

    private int getPort() {
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
        return new ConnectionBuilder();
    }
}
