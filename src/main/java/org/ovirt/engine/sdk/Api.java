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

import java.net.MalformedURLException;
import org.ovirt.engine.sdk.web.ConnectionsPool;
import org.ovirt.engine.sdk.web.HttpProxy;
import org.ovirt.engine.sdk.utils.ConnectionsPoolBuilder;

public class Api {

    private HttpProxy proxy = null;

    public Api(String url, String username, String password) throws MalformedURLException {

        ConnectionsPool pool = new ConnectionsPoolBuilder(url, username, password)
            .build();
        this.proxy = new HttpProxy(pool);
    }

    public Api(String url, String username, String password, boolean insecure) throws MalformedURLException {

        ConnectionsPool pool = new ConnectionsPoolBuilder(url, username, password)
            .insecure(insecure)
            .build();
        this.proxy = new HttpProxy(pool);
    }

    public Api(String url, String username, String password, String ca_file, boolean filter) throws MalformedURLException {

        ConnectionsPool pool = new ConnectionsPoolBuilder(url, username, password)
            .ca_file(ca_file)
            .filter(filter)
            .build();
        this.proxy = new HttpProxy(pool);
    }

    public Api(String url, String username, String password, String key_file,
              String cert_file, String ca_file, Integer port, Integer timeout,
              Boolean persistent_auth, Boolean insecure, Boolean filter, Boolean debug) throws MalformedURLException {

        ConnectionsPool pool = new ConnectionsPoolBuilder(url, username, password)
            .key_file(key_file)
            .cert_file(cert_file)
            .ca_file(ca_file)
            .port(port)
            .timeout(timeout)
            .persistent_auth(persistent_auth)
            .insecure(insecure)
            .filter(filter).debug(debug)
            .build();
        this.proxy = new HttpProxy(pool);
    }

    public HttpProxy getProxy() {
        return this.proxy;
    }
}
