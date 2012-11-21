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

package org.ovirt.engine.sdk.decorators;

import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.ovirt.engine.sdk.entities.Action;
import org.ovirt.engine.sdk.entities.Response;
import org.ovirt.engine.sdk.exceptions.ServerException;
import org.ovirt.engine.sdk.utils.HttpHeaderUtils;
import org.ovirt.engine.sdk.web.HttpProxyBroker;

public class Cluster extends
        org.ovirt.engine.sdk.entities.Cluster {

    private HttpProxyBroker proxy;

    private ClusterGlusterVolumes clusterGlusterVolumes;
    private ClusterNetworks clusterNetworks;
    private ClusterGlusterBricks clusterGlusterBricks;
    private ClusterPermissions clusterPermissions;


    public Cluster(HttpProxyBroker proxy) {
        this.proxy = proxy;
    }

    private HttpProxyBroker getProxy() {
        return proxy;
    }

    public synchronized ClusterGlusterVolumes getClusterGlusterVolumes() {
        if (this.clusterGlusterVolumes == null) {
            this.clusterGlusterVolumes = new ClusterGlusterVolumes(proxy, this);
        }
        return clusterGlusterVolumes;
    }

    public synchronized ClusterNetworks getClusterNetworks() {
        if (this.clusterNetworks == null) {
            this.clusterNetworks = new ClusterNetworks(proxy, this);
        }
        return clusterNetworks;
    }

    public synchronized ClusterGlusterBricks getClusterGlusterBricks() {
        if (this.clusterGlusterBricks == null) {
            this.clusterGlusterBricks = new ClusterGlusterBricks(proxy, this);
        }
        return clusterGlusterBricks;
    }

    public synchronized ClusterPermissions getClusterPermissions() {
        if (this.clusterPermissions == null) {
            this.clusterPermissions = new ClusterPermissions(proxy, this);
        }
        return clusterPermissions;
    }



    
}

