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

package org.ovirt.engine.sdk.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.ovirt.engine.sdk.exceptions.ProtocolException;
import org.ovirt.engine.sdk.exceptions.SocketFactoryException;
import org.ovirt.engine.sdk.utils.StringUtils;

/**
 * Provides ConnectionsPool building services
 */
public class ConnectionsPoolBuilder {

    private static final String DEFAULT_KEYSTORE_TRUSTSTORE = "ovirtsdk-keystore.truststore";
    private static final String BAD_PROTOCOL_ERROR = "Unsupported protocol ";
    private static final String BAD_KEY_ERROR = "SSL context initiation has failed because of key error.";
    private static final String NO_TLS_ERROR = "SSL context initiation has failed locating TLS slgorithm.";
    private static final String KEY_STORE_ERROR = "CA certeficate keysotore initiation has failed.";
    private static final String KEY_STORE_FILE_NOT_FOUND_ERROR = "CA certeficate keysotore was not found.";
    private static final String CERTEFICATE_ERROR = "CA certeficate error.";
    private static final String IO_ERROR = "I/O error occured, is your keysotore password correct?";
    private static final String UNRECOVERABLE_KEY_ERROR = "Unrecoverable key error has occured.";

    private static int MAX_CONNECTIONS = 20;
    private static int MAX_CONNECTIONS_PER_HOST = 50;
    private static int MAX_CONNECTIONS_PER_ROUTE = 5;

    private static long WAIT_IDLE_CHECK_TTL = 5000;
    private static long WAIT_IDLE_CLOSE_TTL = 30;

    private static String HTTP_PROTOCOL = "http";
    private static String HTTPS_PROTOCOL = "https";

    private String url;
    private String username;
    private String password;
    private String key_file;
    private String cert_file;
    private String ca_file;
    private int port = -1;
    private Integer requestTimeout;
    private Integer sessionTimeout;
    private boolean noHostVerification = false;
    private String keyStorePath;
    private String keyStorePassword;

    private URL urlobj = null;

    /**
     * @param url
     *            oVirt API url
     * @param username
     *            oVirt API user name
     * @param password
     *            oVirt API password
     * 
     * @throws MalformedURLException
     */
    public ConnectionsPoolBuilder(String url, String username, String password) throws MalformedURLException {
        url(url);
        username(username);
        password(password);
    }

    /**
     * @param url
     *            oVirt API url
     * 
     * @throws MalformedURLException
     */
    public ConnectionsPoolBuilder(String url) throws MalformedURLException {
        url(url);
    }

    /**
     * 
     * @param url
     *            oVirt API url
     * 
     * @throws MalformedURLException
     */
    private ConnectionsPoolBuilder url(String url) throws MalformedURLException {
        this.url = url;
        this.urlobj = createURL(url);
        return this;
    }

    /**
     * @param username
     *            oVirt API user name
     */
    private ConnectionsPoolBuilder username(String username) {
        this.username = username;
        return this;
    }

    /**
     * @param password
     *            oVirt API password
     */
    private ConnectionsPoolBuilder password(String password) {
        this.password = password;
        return this;
    }

    /**
     * @param key_file
     *            client key
     */
    public ConnectionsPoolBuilder key_file(String key_file) {
        this.key_file = key_file;
        return this;
    }

    /**
     * @param cert_file
     *            client cert file
     */
    public ConnectionsPoolBuilder cert_file(String cert_file) {
        this.cert_file = cert_file;
        return this;
    }

    /**
     * @param ca_file
     *            server CA cert.
     */
    public ConnectionsPoolBuilder ca_file(String ca_file) {
        this.ca_file = ca_file;
        return this;
    }

    /**
     * @param keyStorePath
     *            path to server CA KeyStore
     */
    public ConnectionsPoolBuilder keyStorePath(String keyStorePath) {
        this.keyStorePath = keyStorePath;
        return this;
    }

    /**
     * @param keyStorePassword
     *            server CA KeyStore password
     */
    public ConnectionsPoolBuilder keyStorePassword(String keyStorePassword) {
        this.keyStorePassword = keyStorePassword;
        return this;
    }

    /**
     * @param port
     *            oVirt API port
     * 
     */
    public ConnectionsPoolBuilder port(Integer port) {
        if (port != null) {
            this.port = port.intValue();
        }
        return this;
    }

    /**
     * @param requestTimeout
     *            request timeout
     */
    public ConnectionsPoolBuilder requestTimeout(Integer requestTimeout) {
        if (requestTimeout != null) {
            this.requestTimeout = requestTimeout;
        }
        return this;
    }

    /**
     * @param sessionTimeout
     *            authentication session inactivity timeout
     */
    public ConnectionsPoolBuilder sessionTimeout(Integer sessionTimeout) {
        if (sessionTimeout != null) {
            this.sessionTimeout = sessionTimeout;
        }
        return this;
    }

    /**
     * @param noHostVerification
     *            flag
     */
    public ConnectionsPoolBuilder noHostVerification(Boolean noHostVerification) {
        if (noHostVerification != null) {
            this.noHostVerification = noHostVerification.booleanValue();
        }
        return this;
    }

    /**
     * Creates DefaultHttpClient
     *
     * @param url
     * @param username
     * @param password
     * @param key_file
     * @param cert_file
     * @param ca_file
     * @param port
     * @param requestTimeout
     *
     * @return {@link DefaultHttpClient}
     */
    private DefaultHttpClient createDefaultHttpClient(String url, String username, String password, String key_file,
            String cert_file, String ca_file, Integer port, Integer requestTimeout) {

        int port_ = getPort(url, port);

        DefaultHttpClient client =
                new DefaultHttpClient(createPoolingClientConnectionManager(url, port_));

        if (requestTimeout != null && requestTimeout.intValue() != -1) {
            HttpParams httpParams = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(httpParams, requestTimeout.intValue());
            DefaultHttpClient.setDefaultHttpParams(httpParams);
        }

        if (!StringUtils.isNulOrEmpty(username))
            client.getCredentialsProvider().setCredentials(
                    new AuthScope(getHost(url), port_),
                    new UsernamePasswordCredentials(username, password));

        // FIXME: use all .ctr params

        return client;
    }

    /**
     * Creates PoolingClientConnectionManager
     *
     * @param url
     * @param port
     *
     * @return {@link ClientConnectionManager}
     */
    private ClientConnectionManager createPoolingClientConnectionManager(String url, int port) {
        SchemeRegistry schemeRegistry = createSchemeRegistry(url, port);

        PoolingClientConnectionManager cm =
                new PoolingClientConnectionManager(schemeRegistry);
        cm.setMaxTotal(MAX_CONNECTIONS);
        cm.setDefaultMaxPerRoute(MAX_CONNECTIONS_PER_ROUTE);
        cm.setMaxPerRoute(new HttpRoute(new HttpHost(getHost(url),
                getPort(url, port))),
                MAX_CONNECTIONS_PER_HOST);

        return cm;
    }

    /**
     * Creates SchemeRegistry
     *
     * @param url
     * @param port
     *
     * @return {@link SchemeRegistry}
     */
    private SchemeRegistry createSchemeRegistry(String url, int port) {
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        String protocol = getProtocol(url);
        SSLSocketFactory sf;

        if (HTTP_PROTOCOL.equals(protocol)) {
            schemeRegistry.register(
                    new Scheme(HTTP_PROTOCOL,
                            port,
                            PlainSocketFactory.getSocketFactory()));
        } else if (HTTPS_PROTOCOL.equals(protocol)) {
            try {
                if (this.noHostVerification) {
                    SSLContext sslcontext = SSLContext.getInstance("TLS");
                    sslcontext.init(null, new TrustManager[] { noCaTrustManager }, null);
                    sf = new SSLSocketFactory(
                            sslcontext,
                            SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
                } else {
                    KeyStore truststore = null;
                    InputStream in = null;

                    if (this.keyStorePath != null) {
                        truststore = KeyStore.getInstance(KeyStore.getDefaultType());
                        try {
                            in = new FileInputStream(this.keyStorePath);
                            truststore.load(
                                    in,
                                    this.keyStorePassword != null ?
                                            this.keyStorePassword.toCharArray()
                                            :
                                            null);

                        } finally {
                            if (in != null) {
                                in.close();
                            }
                        }
                    }
                    sf = new SSLSocketFactory(SSLSocketFactory.TLS,
                            null,
                            null,
                            truststore,
                            null,
                            null,
                            SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                }

                schemeRegistry.register(
                        new Scheme(HTTPS_PROTOCOL, port, sf));

            } catch (NoSuchAlgorithmException e) {
                throw new SocketFactoryException(NO_TLS_ERROR, e);
            } catch (KeyManagementException e) {
                throw new SocketFactoryException(BAD_KEY_ERROR, e);
            } catch (KeyStoreException e) {
                throw new SocketFactoryException(KEY_STORE_ERROR, e);
            } catch (FileNotFoundException e) {
                throw new SocketFactoryException(KEY_STORE_FILE_NOT_FOUND_ERROR, e);
            } catch (CertificateException e) {
                throw new SocketFactoryException(CERTEFICATE_ERROR, e);
            } catch (IOException e) {
                throw new SocketFactoryException(IO_ERROR, e);
            } catch (UnrecoverableKeyException e) {
                throw new SocketFactoryException(UNRECOVERABLE_KEY_ERROR, e);
            }
        } else {
            throw new ProtocolException(BAD_PROTOCOL_ERROR + protocol);
        }

        return schemeRegistry;
    }

    private int getPort(String url, Integer port) {
        return port == null || port == -1 ? this.urlobj.getPort() : port;
    }

    private String getHost(String url) {
        return this.urlobj.getHost();
    }

    private String getProtocol(String url) {
        return this.urlobj.getProtocol();
    }

    /**
     * @return entry point URI
     */
    public String getUrl() {
        return this.url.toString();
    }

    private URL createURL(String url) throws MalformedURLException {
        return new URL(url);
    }

    /**
     * Builds ConnectionPool
     *
     * @return ConnectionsPool
     */
    public ConnectionsPool build() {
        this.keyStorePath = resolveKeyStorePath();
        return new ConnectionsPool(
                createDefaultHttpClient(url,
                        username,
                        password,
                        key_file,
                        cert_file,
                        ca_file,
                        port,
                        requestTimeout
                ),
                this.urlobj,
                this.sessionTimeout,
                WAIT_IDLE_CHECK_TTL,
                WAIT_IDLE_CLOSE_TTL);
    }

    /**
     * Trying to resolve keyStorePath if it's not defined
     * according to the DEFAULT_KEYSTORE_TRUSTSTORE
     *
     * on NX environment it may look like:
     * /home/mpastern/.ovirtsdk/ovirtsdk-keystore.truststore
     *
     * @return keyStorePath or original this.keyStorePath content
     */
    private String resolveKeyStorePath() {
        if (this.keyStorePath == null) {
            String keyStorePathCandidate =
                    System.getProperty("user.home") +
                            File.separator + ".ovirtsdk" +
                            File.separator + DEFAULT_KEYSTORE_TRUSTSTORE;

            try {
                if (new File(keyStorePathCandidate).exists()) {
                    return keyStorePathCandidate;
                }
            } catch (SecurityException ex) {
                ex.printStackTrace();
                // TODO: log error when exposed logger
            }
        }
        return this.keyStorePath;
    }

    /**
     * This TrustManager used to ignore CA cert validation
     * and should not be used unless user explicitly asks to ignore
     * host identity validation.
     */
    X509TrustManager noCaTrustManager = new X509TrustManager() {

        @Override
        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType)
                throws java.security.cert.CertificateException {
            // do nothing
        }

        @Override
        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType)
                throws java.security.cert.CertificateException {
            // do nothing

        }

        @Override
        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    };
}
