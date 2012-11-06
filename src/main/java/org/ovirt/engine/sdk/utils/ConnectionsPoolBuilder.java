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

package org.ovirt.engine.sdk.utils;

import java.net.MalformedURLException;
import java.net.URL;

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
import org.ovirt.engine.sdk.web.ConnectionsPool;
import org.ovirt.engine.sdk.web.IdleConnectionMonitorThread;

public class ConnectionsPoolBuilder {

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
    private int timeout = -1;

    private URL urlobj = null;

    public ConnectionsPoolBuilder(String url, String username, String password) throws MalformedURLException {
        url(url);
        username(username);
        password(password);
    }

    private ConnectionsPoolBuilder url(String url) throws MalformedURLException {
        this.url = url;
        this.urlobj = createURL(url);
        return this;
    }

    private ConnectionsPoolBuilder username(String username) {
        this.username = username;
        return this;
    }

    private ConnectionsPoolBuilder password(String password) {
        this.password = password;
        return this;
    }

    public ConnectionsPoolBuilder key_file(String key_file) {
        this.key_file = key_file;
        return this;
    }

    public ConnectionsPoolBuilder cert_file(String cert_file) {
        this.cert_file = cert_file;
        return this;
    }

    public ConnectionsPoolBuilder ca_file(String ca_file) {
        this.ca_file = ca_file;
        return this;
    }

    public ConnectionsPoolBuilder port(int port) {
        this.port = port;
        return this;
    }

    public ConnectionsPoolBuilder timeout(int timeout) {
        this.timeout = timeout;
        return this;
    }

    private DefaultHttpClient createDefaultHttpClient(String url, String username, String password, String key_file,
            String cert_file, String ca_file, Integer port, Integer timeout) {

        DefaultHttpClient client =
                new DefaultHttpClient(createPoolingClientConnectionManager(url, port));

        client.getCredentialsProvider().setCredentials(
                new AuthScope(getHost(url), getPort(url, port)),
                new UsernamePasswordCredentials(username, password));

        // FIXME: use all .ctr params

        return client;
    }

    private ClientConnectionManager createPoolingClientConnectionManager(String url, Integer port) {
        SchemeRegistry schemeRegistry = createSchemeRegistry(url, port);

        PoolingClientConnectionManager cm =
                new PoolingClientConnectionManager(schemeRegistry);
        cm.setMaxTotal(MAX_CONNECTIONS);
        cm.setDefaultMaxPerRoute(MAX_CONNECTIONS_PER_ROUTE);
        cm.setMaxPerRoute(new HttpRoute(new HttpHost(getHost(url),
                                                     getPort(url, port))),
                         MAX_CONNECTIONS_PER_HOST);

        new IdleConnectionMonitorThread(cm, WAIT_IDLE_CHECK_TTL, WAIT_IDLE_CLOSE_TTL).start();

        return cm;
    }

    private SchemeRegistry createSchemeRegistry(String url, Integer port) {
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        String protocol = getProtocol(url);
        if (HTTP_PROTOCOL.equals(protocol)) {
            schemeRegistry.register(
                    new Scheme(HTTP_PROTOCOL,
                            getPort(url, port),
                            PlainSocketFactory.getSocketFactory()));
        } else {
            schemeRegistry.register(
                    new Scheme(HTTPS_PROTOCOL,
                            getPort(url, port),
                            SSLSocketFactory.getSocketFactory()));
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

    public String getUrl() {
        return this.url.toString();
    }

    private URL createURL(String url) throws MalformedURLException {
        return new URL(url);
    }

    public ConnectionsPool build() {
        return new ConnectionsPool(createDefaultHttpClient(url, username, password, key_file,
                                        cert_file, ca_file, port, timeout),
                                   this.urlobj);
    }
}
