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

package org.ovirt.engine.sdk.utils;

import org.ovirt.engine.sdk.web.ConnectionsPool;
import org.ovirt.engine.sdk.web.HttpProxy;

public class HttpProxyBuilder {

    private ConnectionsPool pool;
    private boolean persistent_auth = true;
    private boolean insecure = false;
    private boolean filter = false;
    private boolean debug = false;

    public HttpProxyBuilder(ConnectionsPool pool) {
        super();
        this.pool = pool;
    }

    public HttpProxyBuilder persistent_auth(boolean persistent_auth) {
        this.persistent_auth = persistent_auth;
        return this;
    }

    public HttpProxyBuilder insecure(boolean insecure) {
        this.insecure = insecure;
        return this;
    }

    public HttpProxyBuilder filter(boolean filter) {
        this.filter = filter;
        return this;
    }

    public HttpProxyBuilder debug(boolean debug) {
        this.debug = debug;
        return this;
    }

    public HttpProxy build() {
        return new HttpProxy(pool, persistent_auth, insecure, filter, debug);
    }
}
