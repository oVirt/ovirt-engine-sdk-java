package org.ovirt.engine.sdk4.internal;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

import org.apache.http.auth.AuthSchemeRegistry;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.params.AuthPolicy;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.client.params.CookiePolicy;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.auth.BasicSchemeFactory;
import org.apache.http.impl.auth.SPNegoSchemeFactory;
import org.apache.http.impl.client.DecompressingHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.params.HttpConnectionParams;
import org.ovirt.engine.sdk4.ConnectionBuilder;
import org.ovirt.engine.sdk4.Error;
import org.ovirt.engine.sdk4.HttpClient;

public class ConnectionBuilder42 extends ConnectionBuilder {

    private static final String UNRECOVERABLE_KEY_ERROR = "Unrecoverable key error has occured.";


    public ConnectionBuilder42() {
    }

    /**
     * Creates HttpClient
     */
    @Override
    protected HttpClient createHttpClient() {
        int port = getPort();
        Credentials credentials = null;
        AuthSchemeRegistry schemeRegistry = new AuthSchemeRegistry();
        AuthScope authScope = new AuthScope(getHost(), port, AuthScope.ANY_REALM, AuthScope.ANY_SCHEME);

        // Create credentials:
        if (user != null && user.length() > 0) {
            schemeRegistry.register(AuthPolicy.BASIC, new BasicSchemeFactory());
            credentials = new UsernamePasswordCredentials(user, password);
        }
        else if (kerberos) {
            schemeRegistry.register(AuthPolicy.SPNEGO, new SPNegoSchemeFactory(true));
            credentials = new Credentials() {
                @Override
                public Principal getUserPrincipal() {
                    return null;
                }

                @Override
                public String getPassword() {
                    return null;
                }
            };
        }
        // Create http client:
        DefaultHttpClient client = new DefaultHttpClient(
            new PoolingClientConnectionManager(createConnectionSocketFactoryRegistry())
        );
        client.setAuthSchemes(schemeRegistry);
        client.getCredentialsProvider().setCredentials(authScope, credentials);
        client.getParams().setParameter(ClientPNames.COOKIE_POLICY, CookiePolicy.IGNORE_COOKIES);

        // Set request timeout:
        if (timeout != -1) {
            HttpConnectionParams.setSoTimeout(client.getParams(), timeout*1000);
        }
        // Compress/decompress entities if compressing enabled:
        if (compress) {
            return new HttpClient42(new DecompressingHttpClient(client));
        }
        return new HttpClient42(client);
    }

    private SchemeRegistry createConnectionSocketFactoryRegistry() {
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        SSLSocketFactory sf;

        // Create SSL/TLS or plain connection:
        if (HTTP_PROTOCOL.equals(getProtocol())) {
            schemeRegistry.register(
                new Scheme(
                    HTTP_PROTOCOL,
                    getPort(),
                    PlainSocketFactory.getSocketFactory()
                )
            );
        }
        else if (HTTPS_PROTOCOL.equals(getProtocol())) {
            try {
                if (this.insecure) {
                    SSLContext sslcontext = SSLContext.getInstance("TLS");
                    sslcontext.init(null, new TrustManager[]{noCaTrustManager}, null);
                    sf = new SSLSocketFactory(
                        sslcontext,
                        SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER
                    );
                }
                else {
                    KeyStore truststore = null;
                    InputStream in = null;

                    if (this.trustStoreFile != null) {
                        truststore = KeyStore.getInstance(KeyStore.getDefaultType());
                        try {
                            in = new FileInputStream(this.trustStoreFile);
                            truststore.load(
                                in,
                                this.trustStorePassword != null ?
                                    this.trustStorePassword.toCharArray()
                                    :
                                    null);

                        }
                        finally {
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
                schemeRegistry.register(new Scheme(HTTPS_PROTOCOL, getPort(), sf));
            }
            catch (NoSuchAlgorithmException e) {
                throw new Error(NO_TLS_ERROR, e);
            }
            catch (KeyManagementException e) {
                throw new Error(BAD_KEY_ERROR, e);
            }
            catch (KeyStoreException e) {
                throw new Error(KEY_STORE_ERROR, e);
            }
            catch (FileNotFoundException e) {
                throw new Error(KEY_STORE_FILE_NOT_FOUND_ERROR, e);
            }
            catch (CertificateException e) {
                throw new Error(CERTIFICATE_ERROR, e);
            }
            catch (IOException e) {
                throw new Error(IO_ERROR, e);
            }
            catch (UnrecoverableKeyException e) {
                throw new Error(UNRECOVERABLE_KEY_ERROR, e);
            }
        }

        return schemeRegistry;
    }
}
