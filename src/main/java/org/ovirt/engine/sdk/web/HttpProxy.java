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

package org.ovirt.engine.sdk.web;

import java.io.IOException;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.util.EntityUtils;
import org.ovirt.engine.sdk.exceptions.RequestException;

public class HttpProxy {

    private ConnectionsPool pool;
    private static int BAD_REQUEST = 400;

    public HttpProxy(ConnectionsPool pool) {
        this.pool = pool;
    }

    private String execute(HttpUriRequest request, List<Header> headers, Boolean last)
            throws IOException, ClientProtocolException, RequestException {

        if (headers != null && !headers.isEmpty()) {
            request.setHeaders(headers.toArray(new Header[headers.size()]));
        }

        // TODO: fetch + inject cookie

        HttpResponse response = this.pool.execute(request, new BasicHttpContext());

        // TODO: save cookie

        if (response.getStatusLine().getStatusCode() < BAD_REQUEST) {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                return EntityUtils.toString(entity);
            } else {
                return null;
            }
        }
        throw new RequestException(response.getStatusLine().getReasonPhrase());
    }

    public String update(String url, String entity)
            throws IOException, ClientProtocolException, RequestException {
        return update(url, null);
    }

    public String update(String url, String entity, List<Header> headers)
            throws IOException, ClientProtocolException, RequestException {

        HttpPut httpput = new HttpPut(url);
        HttpEntity httpentity = new StringEntity(entity);
        httpput.setEntity(httpentity);
        return execute(httpput, headers, null);
    }

    public String action(String url, String entity)
            throws IOException, ClientProtocolException, RequestException {
        return action(url, entity);
    }

    public String action(String url, String entity, List<Header> headers)
            throws IOException, ClientProtocolException, RequestException {
        return add(url, entity, headers);
    }

    public String add(String url, String entity)
            throws IOException, ClientProtocolException, RequestException {
        return add(url, entity, null);
    }

    public String add(String url, String entity, List<Header> headers)
            throws IOException, ClientProtocolException, RequestException {

        HttpPost httpost = new HttpPost(url);
        HttpEntity httpentity = new StringEntity(entity);
        httpost.setEntity(httpentity);
        return execute(httpost, headers, null);
    }

    public String delete(String url, String entity)
            throws IOException, ClientProtocolException, RequestException {
        return delete(url, entity, null);
    }

    public String delete(String url, String entity, List<Header> headers)
            throws IOException, ClientProtocolException, RequestException {

        HttpPost httpost = new HttpPost(url);
        HttpEntity httpentity = new StringEntity(entity);
        httpost.setEntity(httpentity);
        return execute(httpost, headers, null);
    }

    public String get(String url)
            throws IOException, ClientProtocolException, RequestException {
        return get(url, null);
    }

    public String get(String url, List<Header> headers)
            throws IOException, ClientProtocolException, RequestException {

        HttpGet httpget = new HttpGet(url);
        return execute(httpget, headers, null);
    }
}
