package org.ovirt.engine.sdk4.internal;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.ovirt.engine.sdk4.HttpClient;

/**
 * This class implements methods to work with httpclient version 4.5
 */
public class HttpClient45 implements HttpClient {

    private CloseableHttpClient client;

    public HttpClient45(CloseableHttpClient client) {
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
        client.close();
    }
}