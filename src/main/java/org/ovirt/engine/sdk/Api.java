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

import org.apache.http.client.ClientProtocolException;
import org.ovirt.engine.sdk.web.ConnectionsPool;
import org.ovirt.engine.sdk.web.HttpProxy;
import org.ovirt.engine.sdk.decorators.Vms;
import org.ovirt.engine.sdk.exceptions.RequestException;
import org.ovirt.engine.sdk.exceptions.UnsecuredConnectionAttemptError;
import org.ovirt.engine.sdk.utils.ConnectionsPoolBuilder;
import org.ovirt.engine.sdk.utils.HttpProxyBuilder;

public class Api {

    private HttpProxy proxy = null;
    private Object entryPoint = null;

    private Vms vms;

    public Api(String url, String username, String password) throws ClientProtocolException, RequestException,
            IOException, UnsecuredConnectionAttemptError {

        ConnectionsPool pool = new ConnectionsPoolBuilder(url, username, password)
                .build();
        this.proxy = new HttpProxyBuilder(pool)
                .build();
        this.initResources();
    }

    public Api(String url, String username, String password, boolean insecure) throws ClientProtocolException,
            RequestException, UnsecuredConnectionAttemptError, IOException {

        ConnectionsPool pool = new ConnectionsPoolBuilder(url, username, password)
                .build();
        this.proxy = new HttpProxyBuilder(pool)
                .insecure(insecure)
                .build();
        initResources();
    }

    public Api(String url, String username, String password, String ca_file, boolean filter)
            throws ClientProtocolException, RequestException, UnsecuredConnectionAttemptError, IOException {

        ConnectionsPool pool = new ConnectionsPoolBuilder(url, username, password)
                .ca_file(ca_file)
                .build();
        this.proxy = new HttpProxyBuilder(pool)
                .filter(filter)
                .build();
        initResources();
    }

    public Api(String url, String username, String password, String key_file,
              String cert_file, String ca_file, Integer port, Integer timeout,
              Boolean persistentAuth, Boolean insecure, Boolean filter, Boolean debug) throws ClientProtocolException,
            RequestException, UnsecuredConnectionAttemptError, IOException {

        ConnectionsPool pool = new ConnectionsPoolBuilder(url, username, password)
                .key_file(key_file)
                .cert_file(cert_file)
                .ca_file(ca_file)
                .port(port)
                .timeout(timeout)
                .build();
        this.proxy = new HttpProxyBuilder(pool)
                .persistentAuth(persistentAuth)
                .insecure(insecure)
                .filter(filter)
                .debug(debug)
                .build();
        initResources();
    }

    private String getEntryPoint() throws ClientProtocolException, RequestException, IOException,
            UnsecuredConnectionAttemptError {
        String entryPoint = this.proxy.getRootResource();
        // TODO: return type should be API
        if (!entryPoint.equals("")) {
            return entryPoint;
        }
        throw new UnsecuredConnectionAttemptError();
    }

    public void setFilter(boolean filter) {
        this.proxy.setFilter(filter);
    }

    private void initResources() throws ClientProtocolException, RequestException, UnsecuredConnectionAttemptError,
            IOException {
        this.entryPoint = getEntryPoint();
        this.vms = new Vms(this.proxy);
    }

    public Vms getVms() {
        return vms;
    }
}
