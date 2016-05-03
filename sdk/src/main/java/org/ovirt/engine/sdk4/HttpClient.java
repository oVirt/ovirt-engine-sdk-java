package org.ovirt.engine.sdk4;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;

/**
 * This interface defines methods which should implement HttpClient class of specific http client version.
 */
public interface HttpClient {

    /**
     * This method will send http request
     *
     * @param request request which should be send to host
     * @return response returned by host
     */
    HttpResponse execute(HttpUriRequest request) throws Exception;

    /**
     * Close http connection
     *
     * @throws Exception
     */
    void close() throws Exception;

}
