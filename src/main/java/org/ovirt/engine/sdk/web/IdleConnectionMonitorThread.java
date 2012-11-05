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

public class IdleConnectionMonitorThread extends Thread {

    private final ClientConnectionManager connMgr;
    private volatile boolean shutdown;
    long wait_ttl;
    long close_ttl;

    public IdleConnectionMonitorThread(ClientConnectionManager connMgr, long wait_ttl, long close_ttl) {
        super();
        this.connMgr = connMgr;
        this.wait_ttl = wait_ttl;
        this.close_ttl = close_ttl;
    }

    @Override
    public void run() {
        try {
            while (!shutdown) {
                synchronized (this) {
                    wait(this.wait_ttl);
                    connMgr.closeExpiredConnections();
                    connMgr.closeIdleConnections(this.close_ttl, TimeUnit.SECONDS);
                }
            }
        } catch (InterruptedException ex) {
            // terminate
        }
    }

    public void shutdown() {
        shutdown = true;
        synchronized (this) {
            notifyAll();
        }
    }
}
