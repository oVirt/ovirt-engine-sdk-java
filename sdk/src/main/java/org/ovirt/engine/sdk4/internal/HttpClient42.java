package org.ovirt.engine.sdk4.internal;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.ovirt.engine.sdk4.HttpClient;

/**
 * * This class implements methods to work with httpclient version 4.2
 */
public class HttpClient42 implements HttpClient {

    private DefaultHttpClient client;

    public HttpClient42(DefaultHttpClient client) {
        this.client = client;
    }

    @Override
    public HttpResponse execute(HttpUriRequest request) {
        try {
            return client.execute(request);
        }
        catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() throws Exception {
        client.getConnectionManager().shutdown();
    }
}