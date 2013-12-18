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

import java.util.concurrent.TimeUnit;
import org.apache.http.conn.ClientConnectionManager;

/**
 * Connections watch dog, used to closes idle connections
 */
public class IdleConnectionMonitorThread extends Thread {

    private final ClientConnectionManager connMgr;
    private volatile boolean shutdown;
    long waitTtl;
    long closeTtl;

    /**
     * 
     * @param connMgr
     *            ClientConnectionManager to watch at
     * @param waitTtl
     *            work cycle
     * @param closeTtl
     *            close ttl
     */
    public IdleConnectionMonitorThread(ClientConnectionManager connMgr, long waitTtl, long closeTtl) {
        super();
        this.connMgr = connMgr;
        this.waitTtl = waitTtl;
        this.closeTtl = closeTtl;
    }

    @Override
    public void run() {
        try {
            while (!shutdown) {
                synchronized (this) {
                    wait(this.waitTtl);
                    connMgr.closeExpiredConnections();
                    connMgr.closeIdleConnections(this.closeTtl, TimeUnit.SECONDS);
                }
            }
        } catch (InterruptedException ex) {
            // terminate
        }
    }

    /**
     * Shuts down ConnectionMonitorThread
     */
    public void shutdown() {
        shutdown = true;
        synchronized (this) {
            notifyAll();
        }
    }
}
