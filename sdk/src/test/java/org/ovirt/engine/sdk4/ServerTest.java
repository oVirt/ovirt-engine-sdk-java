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

import static io.undertow.Handlers.path;
import static org.ovirt.engine.sdk4.ConnectionBuilder.connection;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

import io.undertow.Undertow;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.server.handlers.BlockingHandler;
import io.undertow.server.handlers.PathHandler;
import io.undertow.util.HeaderMap;
import io.undertow.util.Headers;

/**
 * This class is intended to be used as the base class for the rest of the tests of the SDK. It provides methods to
 * start, configure and stop an embedded web server.
 */
public abstract class ServerTest {
    // The authentication details used by the embedded tests web server:
    private static final String USER = "admin@internal";
    private static final String PASSWORD = "vzhJgfyaDPHRhg";
    private static final String TOKEN = "bvY7txV9ltmmRQ";

    // The host and port and path used by the embedded tests web server:
    private static final String HOST = "localhost";
    private static final String PREFIX = "/ovirt-engine";

    // The range of ports used by the tests:
    private static final int PORT_FIRST = 60000;
    private static final int PORT_LAST = 61000;

    // Testing path handler:
    private static final PathHandler PATH_HANDLER = path();

    // The port used for the tests:
    private int port;

    // The embedded web server:
    private Undertow.Builder builder = Undertow.builder();
    private Undertow server;

    // Helper attributes for unit tests:
    private String lastRequestQuery;
    private HeaderMap lastRequestHeaders;
    private String lastRequestContent;

    public HeaderMap getLastRequestHeaders() {
        return lastRequestHeaders;
    }

    public String getLastRequestQuery() {
        return lastRequestQuery;
    }

    public String getLastRequestContent() {
        return lastRequestContent;
    }

    protected String testUser() {
        return USER;
    }

    protected String testPassword() {
        return PASSWORD;
    }

    protected String testHost() {
        return HOST;
    }

    protected int testPort() {
        if (port == 0) {
            String host = testHost();
            InetAddress address;
            try {
                address = InetAddress.getByName(host);
            }
            catch (UnknownHostException exception) {
                throw new RuntimeException(String.format("Can't find address for host '%s'", host), exception);
            }
            for (port = PORT_FIRST; port <= PORT_LAST; port++) {
                ServerSocket socket = null;
                try {
                    socket = new ServerSocket(port, 0, address);
                    break;
                }
                catch (Exception exception) {
                    System.out.printf("Can't use port %d\n", port);
                }
                finally {
                    if (socket != null) {
                        try {
                            socket.close();
                        }
                        catch (IOException exception) {
                            System.out.printf("Can't close socket for port %d\n", port);
                        }
                    }
                }
            }
            if (port > PORT_LAST) {
                throw new RuntimeException(
                    String.format("Can't find a free port in rage %d..%d", PORT_FIRST, PORT_LAST)
                );
            }
        }
        return port;
    }

    protected String testPrefix() {
        return PREFIX;
    }

    protected String testUrl() {
        return String.format("https://%s:%d%s/api", testHost(), testPort(), testPrefix());
    }

    protected String testTrustStoreFile() {
        return "src/test/resources/pki/ca.jks";
    }

    protected String testTrustStorePassword() {
        return "mypass";
    }

    protected Connection testConnection() {
        return connection()
            .url(testUrl())
            .user(testUser())
            .password(testPassword())
            .trustStoreFile(testTrustStoreFile())
            .trustStorePassword(testTrustStorePassword())
            .build();
    }

    protected PathHandler testHandler() {
        return PATH_HANDLER;
    }

    protected void startServer() {
        startServer("localhost");
    }

    private KeyStore loadKeyStore(String name) {
        try {
            KeyStore ks = KeyStore.getInstance("JKS");
            try (InputStream in = new FileInputStream(String.format("src/test/resources/pki/%s.jks", name))) {
                ks.load(in, "mypass".toCharArray());
            }
            return ks;
        }
        catch (Exception exception) {
            throw new RuntimeException(String.format("Can't load server key store '%s'", name), exception);
        }
    }

    private KeyManager[] loadKeyManagers(String host) {
        String algorithm = KeyManagerFactory.getDefaultAlgorithm();
        KeyManagerFactory factory;
        try {
            factory = KeyManagerFactory.getInstance(algorithm);
        }
        catch (NoSuchAlgorithmException exception) {
            throw new RuntimeException(
                String.format("Can't find key manager factory for algorithm '%s'", algorithm),
                exception
            );
        }
        KeyStore ks = loadKeyStore(host);
        try {
            factory.init(ks, "mypass".toCharArray());
        }
        catch (Exception exception) {
            throw new RuntimeException(
                String.format("Can't create key manager for host '%s'", host),
                exception
            );
        }
        return factory.getKeyManagers();
    }

    private TrustManager[] loadTrustManagers() {
        String algorithm = TrustManagerFactory.getDefaultAlgorithm();
        TrustManagerFactory factory;
        try {
            factory = TrustManagerFactory.getInstance(algorithm);
        }
        catch (NoSuchAlgorithmException exception) {
            throw new RuntimeException(
                String.format("Can't find trust manager factory for algorithm '%s'", algorithm),
                exception
            );
        }
        KeyStore ks = loadKeyStore("ca");
        try {
            factory.init(ks);
        }
        catch (Exception exception) {
            throw new RuntimeException("Can't create trust manager", exception);
        }
        return factory.getTrustManagers();
    }

    private SSLContext createSslContext(String host) {
        KeyManager[] keyManagers = loadKeyManagers(host);
        TrustManager[] trustManagers = loadTrustManagers();
        String protocol = "TLS";
        SSLContext sslContext;
        try {
            sslContext = SSLContext.getInstance(protocol);
        }
        catch (NoSuchAlgorithmException exception) {
            throw new RuntimeException(
                String.format("Can't create SSL context for protocol '%host'", host),
                exception
            );
        }
        try {
            sslContext.init(keyManagers, trustManagers, null);
        }
        catch (KeyManagementException exception) {
            throw new RuntimeException(
                String.format("Can't initialize SSL context for host '%s'", host),
                exception
            );
        }
        return sslContext;
    }

    protected void setXmlResponse(String path, final int code, final String body) {
        setXmlResponse(path, code, body, 0);
    }

    private String getRequestContent(HttpServerExchange exchange) {
        exchange.startBlocking();
        Scanner scanner = new Scanner(exchange.getInputStream()).useDelimiter("\\A");
        String requestBody = scanner.hasNext() ? scanner.next() : "";
        requestBody = requestBody.replaceAll(">\\s+<", "><");
        return requestBody;
    }

    protected void setXmlResponse(String path, final int code, final String body, final int delay) {
        HttpHandler xmlResponseHandler = new BlockingHandler(
            new HttpHandler() {
                @Override
                public void handleRequest(HttpServerExchange exchange) throws Exception {
                    lastRequestQuery = exchange.getQueryString();
                    lastRequestHeaders = exchange.getRequestHeaders();
                    lastRequestContent = getRequestContent(exchange);

                    if (!exchange.getRequestHeaders().getFirst("Authorization").equals("Bearer " + TOKEN)) {
                        exchange.setStatusCode(401);
                        exchange.getResponseSender().send("");
                    }
                    else {
                        Thread.sleep(delay);
                        exchange.setStatusCode(code);
                        exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "application/xml");
                        exchange.getResponseSender().send(body);
                    }
                }
            }
        );

        testHandler().addPrefixPath(testPrefix() + "/api/" + path, xmlResponseHandler);
    }

    protected void startServer(String host) {
        // Create the handler that returns a valid authentication token:
        HttpHandler ssoLoginHandler = new HttpHandler() {
            @Override
            public void handleRequest(HttpServerExchange exchange) throws Exception {
                exchange.setStatusCode(200);
                exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "application/json");
                exchange.getResponseSender().send(String.format("{\"access_token\":\"%s\"}", TOKEN));
            }
        };
        HttpHandler ssoLogoutHandler = new HttpHandler() {
            @Override
            public void handleRequest(HttpServerExchange exchange) throws Exception {
                exchange.setStatusCode(200);
                exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "application/json");
                exchange.getResponseSender().send("{}");
            }
        };

        // Configure the handlers for password and Kerberos authentication:
        testHandler().addPrefixPath(testPrefix() + "/sso/oauth/token", ssoLoginHandler);
        testHandler().addPrefixPath(testPrefix() + "/sso/oauth/token-http-auth", ssoLoginHandler);
        testHandler().addPrefixPath(testPrefix() + "/services/sso-logout", ssoLogoutHandler);
        builder.setHandler(testHandler());

        // Create and start the web server:
        SSLContext context = createSslContext(host);
        builder.addHttpsListener(testPort(), host, context);
        server = builder.build();
        server.start();
    }

    protected void stopServer() {
        server.stop();
    }
}
