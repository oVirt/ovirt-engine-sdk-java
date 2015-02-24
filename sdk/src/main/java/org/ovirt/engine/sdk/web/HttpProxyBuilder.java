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
    private String sessionid;
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
    public HttpProxyBuilder persistentAuth(Boolean persistentAuth) {
        if (persistentAuth != null) {
            this.persistentAuth = persistentAuth.booleanValue();
        }
        return this;
    }

    /**
     * @param sessionid
     *            oVirt api sessionid to authenticate the user with
     *            (used as SSO solution instead of username+password)
     */
    public HttpProxyBuilder sessionid(String sessionid) {
        this.sessionid = sessionid;
        return this;
    }

    /**
     * @param filter
     *            flag
     */
    public HttpProxyBuilder filter(Boolean filter) {
        if (filter != null) {
            this.filter = filter.booleanValue();
        }
        return this;
    }

    /**
     * @param debug
     *            flag
     */
    public HttpProxyBuilder debug(Boolean debug) {
        if (debug != null) {
            this.debug = debug.booleanValue();
        }
        return this;
    }

    /**
     * builds the proxy
     */
    public HttpProxy build() {
        return new HttpProxy(pool, persistentAuth, sessionid, filter, debug);
    }
}
