package org.ovirt.engine.sdk4.internal;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DecompressingHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * * This class implements methods to work with httpclient version 4.2
 */
public class HttpClient42 implements org.ovirt.engine.sdk4.HttpClient {

    private HttpClient client;

    public HttpClient42(DefaultHttpClient client) {
        this.client = client;
    }

    public HttpClient42(DecompressingHttpClient client) {
        this.client = client;
    }

    @Override
    public HttpResponse execute(HttpUriRequest request) throws Exception {
        return client.execute(request);
    }

    @Override
    public void close() throws Exception {
        client.getConnectionManager().shutdown();
    }
}