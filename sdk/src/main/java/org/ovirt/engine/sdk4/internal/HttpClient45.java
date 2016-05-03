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
    public HttpResponse execute(HttpUriRequest request) throws Exception {
        return client.execute(request);
    }

    @Override
    public void close() throws Exception {
        client.close();
    }
}