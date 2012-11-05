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

package org.ovirt.engine.sdk;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
//import org.apache.http.auth.AuthScope;
//import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
//import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.ovirt.engine.sdk.web.ConnectionsPool;

public class Test {
    private static final String URL = "http://localhost:8080/api";

    public static void main(String[] args) throws ClientProtocolException, IOException {
        ConnectionsPool pool = null;
        try {
//            httpclient.getCredentialsProvider().setCredentials(
//                        new AuthScope("localhost", 8080),
//                        new UsernamePasswordCredentials("admin@internal", "123456"));

            pool = new Api(URL,"admin@internal", "123456").getConnectionsPool();
            HttpGet httpget = new HttpGet(URL);

            System.out.println("executing request" + httpget.getRequestLine());
            HttpResponse response = pool.execute(httpget);
            HttpEntity entity = response.getEntity();

            System.out.println("----------------------------------------");
            System.out.println(response.getStatusLine());
            if (entity != null) {

                long len = entity.getContentLength();
                System.out.println("Response content length: " + len);
                System.out.println(EntityUtils.toString(entity));
            }
//            EntityUtils.consume(entity);
        } finally {
            // When HttpClient instance is no longer needed,
            // shut down the connection manager to ensure
            // immediate deallocation of all system resources
            pool.getConnectionManager().shutdown();
        }
    }
}
