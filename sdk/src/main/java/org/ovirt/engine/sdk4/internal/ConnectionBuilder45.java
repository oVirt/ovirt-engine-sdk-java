package org.ovirt.engine.sdk4.internal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import java.net.Proxy;
import org.apache.http.HttpHost;
import org.apache.http.auth.*;
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
import org.apache.http.conn.ssl.DefaultHostnameVerifier;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.auth.SPNegoSchemeFactory;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.ProxyAuthenticationStrategy;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.protocol.HttpContext;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.SSLContexts;
import org.ovirt.engine.sdk4.ConnectionBuilder;
import org.ovirt.engine.sdk4.Error;
import org.ovirt.engine.sdk4.HttpClient;
import org.ovirt.engine.sdk4.ProxyInfo;

public class ConnectionBuilder45 extends ConnectionBuilder {

    public ConnectionBuilder45() {
    }

    /**
     * Creates HttpClient
     */
    @Override
    protected HttpClient createHttpClient() {
        int port = getPort();
        Lookup<AuthSchemeProvider> authSchemeProvider = null;
        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        AuthScope authScope = new AuthScope(getHost(), port, AuthScope.ANY_REALM, AuthScope.ANY_SCHEME);

        if (user != null && user.length() > 0) {
            credsProvider.setCredentials(
                authScope,
                new UsernamePasswordCredentials(user, password)
            );
        }
        else if (kerberos) {
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
            .setCookieSpec(CookieSpecs.IGNORE_COOKIES)
            .setConnectTimeout(timeout==-1 ? -1 : timeout*1000)
            .build();
        HttpClientBuilder clientBuilder = HttpClientBuilder.create()
            .setConnectionManager(new PoolingHttpClientConnectionManager(createConnectionSocketFactoryRegistry()))
            .setDefaultRequestConfig(globalConfig)
            .setDefaultCredentialsProvider(credsProvider)
            .setDefaultAuthSchemeRegistry(authSchemeProvider);

        if (!compress) {
            clientBuilder.disableContentCompression();
        }

        if(proxyInfo != null) {
            if(proxyInfo.getProxyType() == ProxyInfo.ProxyType.HTTP) {
                if(proxyInfo.getHost() != null && proxyInfo.getProxyPort() != null) {
                    clientBuilder.setProxy(new HttpHost(proxyInfo.getHost(), proxyInfo.getProxyPort()));
                    if(proxyInfo.getUser() != null) { //authenticated proxy
                        NTCredentials ntCreds = new NTCredentials(proxyInfo.getUser(), proxyInfo.getPassword(), proxyInfo.getProxyWorkstation(), proxyInfo.getProxyDomain());
                        credsProvider.setCredentials(new AuthScope(proxyInfo.getHost(), proxyInfo.getProxyPort()), ntCreds);
                        clientBuilder.setDefaultCredentialsProvider(credsProvider);
                        clientBuilder.setProxyAuthenticationStrategy(new ProxyAuthenticationStrategy());
                    }
                }
            } else if(proxyInfo.getProxyType() == ProxyInfo.ProxyType.SOCKS) {
                //this has to be handled in the Connection Factory createSocket
            }
        }

        return new HttpClient45(clientBuilder.build());
    }

    private Registry createConnectionSocketFactoryRegistry() {
        String protocol = getProtocol();
        Registry registry = null;

        // Create SSL/TLS or plain connection:
        if (HTTP_PROTOCOL.equals(protocol)) {
            ConnectionSocketFactory plainsf = new PlainConnectionSocketFactory() {
                @Override
                public Socket createSocket(final HttpContext context) throws IOException {
                    if (proxyInfo != null && proxyInfo.getProxyType() == ProxyInfo.ProxyType.SOCKS) {
                        if (proxyInfo.getHost() != null && proxyInfo.getProxyPort() != null) {
                            InetSocketAddress socksaddr = new InetSocketAddress(proxyInfo.getHost(), proxyInfo.getProxyPort());
                            Proxy proxy = new Proxy(Proxy.Type.SOCKS, socksaddr);
                            return new Socket(proxy);
                        }
                    }
                    return super.createSocket(context);
                }
            };

            registry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register(HTTP_PROTOCOL, plainsf)
                .build();
        }
        else if (HTTPS_PROTOCOL.equals(protocol)) {
            try {
                LayeredConnectionSocketFactory sslsf = null;
                if (this.insecure) {
                    SSLContext sslcontext = SSLContext.getInstance("TLS");
                    sslcontext.init(null, new TrustManager[]{noCaTrustManager}, null);
                    sslsf = new SSLConnectionSocketFactory(sslcontext, NoopHostnameVerifier.INSTANCE) {
                        @Override
                        public Socket createSocket(final HttpContext context) throws IOException {
                            if(proxyInfo != null && proxyInfo.getProxyType() == ProxyInfo.ProxyType.SOCKS) {
                                if(proxyInfo.getHost() != null && proxyInfo.getProxyPort() != null) {
                                    InetSocketAddress socksaddr = new InetSocketAddress(proxyInfo.getHost(), proxyInfo.getProxyPort());
                                    Proxy proxy = new Proxy(Proxy.Type.SOCKS, socksaddr);
                                    return new Socket(proxy);
                                }
                            }
                            return super.createSocket(context);
                        }
                    };
                }
                else {
                    SSLContextBuilder sslContextBuilder = SSLContexts.custom();
                    if (trustStoreFile != null) {
                        sslContextBuilder.loadTrustMaterial(
                            new File(trustStoreFile),
                            this.trustStorePassword != null ? this.trustStorePassword.toCharArray() : null
                        );
                    }
                    SSLContext sslContext = sslContextBuilder.build();
                    sslsf = new SSLConnectionSocketFactory(sslContext, new DefaultHostnameVerifier());
                }
                registry = RegistryBuilder.<ConnectionSocketFactory>create()
                    .register(HTTPS_PROTOCOL, sslsf)
                    .build();
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

        }
        else {
            throw new Error(BAD_PROTOCOL_ERROR + protocol);
        }

        return registry;
    }
}
