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

package org.ovirt.engine.sdk.internal;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.ovirt.engine.sdk.Connection;
import org.ovirt.engine.sdk.Service;
import org.ovirt.engine.sdk.services.SystemService;
import org.ovirt.engine.sdk.services.internal.SystemServiceImpl;
import org.ovirt.engine.sdk.types.Identified;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;
import java.util.logging.Logger;

/**
 * This class is the HTTP implementation of the connection contract. Refrain from using it directly, as backwards
 * compatibility isn't guaranteed, use the {@link org.ovirt.engine.sdk.ConnectionBuilder} class instead.
 */
public class HttpConnection implements Connection {

    private CloseableHttpClient client;
    private String url;
    private String user;
    private String password;
    private boolean insecure = false;
    private boolean debug = false;
    private boolean kerberos = false;
    private String log;
    private int timeout = 0;
    private boolean compress = false;


    public CloseableHttpClient getClient() {
        return client;
    }

    public void setClient(CloseableHttpClient client) {
        this.client = client;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setInsecure(boolean insecure) {
        this.insecure = insecure;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    public boolean isKerberos() {
        return kerberos;
    }

    public void setKerberos(boolean kerberos) {
        this.kerberos = kerberos;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public boolean isCompress() {
        return compress;
    }

    public void setCompress(boolean compress) {
        this.compress = compress;
    }

    @Override
    public SystemService systemService() {
        return new SystemServiceImpl(this, "");
    }

    @Override
    public boolean isLink(Object object) {
        if (object instanceof Identified) {
            return ((Identified) object).href() != null;
        }
        return false;
    }

    @Override
    public <TYPE> TYPE followLink(TYPE object) {
        if (!isLink(object)) {
            throw new RuntimeException("Can't follow link because object don't have any.");
        }
        try {
            String href = ((Identified) object).href();
            if (href == null) {
                throw new RuntimeException("Can't follow link because the 'href' attribute does't have a value");
            }

            URL url = new URL(getUrl());
            String prefix = url.getPath();
            if (!prefix.endsWith("/")) {
                prefix += "/";
            }
            if (!href.startsWith(prefix)) {
                throw new RuntimeException("The URL '" + href + "' isn't compatible with the base URL of the connection");
            }

            // Get service based on path
            String path = href.substring(prefix.length());
            Service service = systemService().service(path);

            // Obtain method which provides result object and invoke it:
            Method get = service.getClass().getMethod("get");
            Object getRequest = get.invoke(service);
            Method send = getRequest.getClass().getMethod("send");
            send.setAccessible(true);
            Object getResponse = send.invoke(getRequest);
            Method obtainObject = getResponse.getClass().getDeclaredMethods()[0];
            obtainObject.setAccessible(true);
            return (TYPE) obtainObject.invoke(getResponse);
        } catch (NoSuchMethodException ex) {
            throw new RuntimeException(ex);
        } catch (IllegalAccessException ex) {
            throw new RuntimeException(ex);
        } catch (InvocationTargetException ex) {
            throw new RuntimeException(ex);
        } catch (MalformedURLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void close() throws Exception {
        // Send the last request to indicate the server that the session should be closed:
        HttpGet request = new HttpGet(url);
        this.send(request, true);

        // close log
        for (Handler handler : Logger.getLogger("org.apache.http").getHandlers()) {
            if(handler != null) {
                handler.close();
            }
        }

        // Close HttpClient connection:
        if(client != null) {
            client.close();
        }
    }

    public HttpResponse send(HttpUriRequest request) {
        return send(request, false);
    }

    private HttpResponse send(HttpUriRequest request, boolean last) {
        try {
            injectHeaders(request, last);
            return client.execute(request);
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Injects HTTP headers in to request
     *
     * @param request
     */
    private void injectHeaders(HttpUriRequest request, boolean last) {
        List<Header> updated = excludeNullHeaders(request.getAllHeaders());
        if (updated != null && !updated.isEmpty()) {
            request.setHeaders(updated.toArray(new Header[updated.size()]));
        }

        request.addHeader("Version", "4");
        request.addHeader("Content-type", "application/xml");
        request.addHeader("User-Agent", "JavaSDK");
        request.addHeader("Accept", "application/xml");

        if (!last) {
            // inject PERSISTENT_AUTH_HEADER
            request.addHeader("Prefer", "persistent-auth");
        }
    }

    private List<Header> excludeNullHeaders(Header[] headers) {
        if (headers != null && headers.length > 0) {
            List<Header> updated = new ArrayList<Header>();
            for (Header header : headers) {
                if (header.getValue() != null) {
                    updated.add(header);
                }
            }
            return updated;
        }

        return null;
    }
}
