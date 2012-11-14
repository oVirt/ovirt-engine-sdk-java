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


/**
 * Provides HttpProxy building services
 */
public class HttpProxyBuilder {

    private ConnectionsPool pool;
    private boolean persistentAuth = true;
    private boolean insecure = false;
    private boolean filter = false;
    private boolean debug = false;

    /**
     * @param pool
     *            ConnectionsPool pool
     */
    public HttpProxyBuilder(ConnectionsPool pool) {
        super();
        this.pool = pool;
    }

    /**
     * @param persistentAuth
     *            persistent authentication flag
     */
    public HttpProxyBuilder persistentAuth(boolean persistentAuth) {
        this.persistentAuth = persistentAuth;
        return this;
    }

    /**
     * @param insecure
     *            flag
     */
    public HttpProxyBuilder insecure(boolean insecure) {
        this.insecure = insecure;
        return this;
    }

    /**
     * @param filter
     *            flag
     */
    public HttpProxyBuilder filter(boolean filter) {
        this.filter = filter;
        return this;
    }

    /**
     * @param debug
     *            flag
     */
    public HttpProxyBuilder debug(boolean debug) {
        this.debug = debug;
        return this;
    }

    /**
     * builds the proxy
     */
    public HttpProxy build() {
        return new HttpProxy(pool, persistentAuth, insecure, filter, debug);
    }
}
