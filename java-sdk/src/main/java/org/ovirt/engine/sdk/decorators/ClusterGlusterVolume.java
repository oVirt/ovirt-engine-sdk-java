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

// *********************************************************************
// ********************* GENERATED CODE - DO NOT MODIFY ****************
// *********************************************************************

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

/**
 * GlusterVolume decorator.
 */
@SuppressWarnings("unused")
public class ClusterGlusterVolume extends
        org.ovirt.engine.sdk.entities.GlusterVolume {

    private HttpProxyBroker proxy;

    private ClusterGlusterVolumeGlusterBricks clusterGlusterVolumeGlusterBricks;


    /**
     * @param proxy HttpProxyBroker
     */
    public ClusterGlusterVolume(HttpProxyBroker proxy) {
        this.proxy = proxy;
    }

    /**
     * @return HttpProxyBroker
     */
    private HttpProxyBroker getProxy() {
        return proxy;
    }

    /**
     * Gets the value of the ClusterGlusterVolumeGlusterBricks property.
     * 
     * @return
     *     possible object is
     *     {@link ClusterGlusterVolumeGlusterBricks }
     *     
     */
    public synchronized ClusterGlusterVolumeGlusterBricks getGlusterBricks() {
        if (this.clusterGlusterVolumeGlusterBricks == null) {
            this.clusterGlusterVolumeGlusterBricks = new ClusterGlusterVolumeGlusterBricks(proxy, this);
        }
        return clusterGlusterVolumeGlusterBricks;
    }


    /**
     * Performs stop action.
     *
     * @param action
     *
     * <pre>
     * [action.force]
     * </pre>
     *
     * @return
     *     {@link Action }
     *
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws IOException
     * @throws JAXBException
     */
    public Action stop(Action action) throws ClientProtocolException,
            ServerException, IOException, JAXBException {
        String url = this.getHref() + "/stop";
        return getProxy().action(url, action, Action.class, Action.class);
    }
    /**
     * Performs start action.
     *
     * @param action
     *
     * <pre>
     * [action.force]
     * </pre>
     *
     * @return
     *     {@link Action }
     *
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws IOException
     * @throws JAXBException
     */
    public Action start(Action action) throws ClientProtocolException,
            ServerException, IOException, JAXBException {
        String url = this.getHref() + "/start";
        return getProxy().action(url, action, Action.class, Action.class);
    }
    /**
     * Performs resetalloptions action.
     *
     * @param action
     *
     * <pre>
     * </pre>
     *
     * @return
     *     {@link Action }
     *
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws IOException
     * @throws JAXBException
     */
    public Action resetalloptions(Action action) throws ClientProtocolException,
            ServerException, IOException, JAXBException {
        String url = this.getHref() + "/resetalloptions";
        return getProxy().action(url, action, Action.class, Action.class);
    }
    /**
     * Deletes object.
     *
     * @return
     *     {@link Response }
     *
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws IOException
     * @throws JAXBException
     */
    public Response delete() throws ClientProtocolException,
            ServerException, IOException, JAXBException {
        String url = this.getHref();
        return getProxy().delete(url, Response.class);
    }
    /**
     * Performs resetoption action.
     *
     * @param action
     *
     * <pre>
     * action.option.name
     * action.force
     * </pre>
     *
     * @return
     *     {@link Action }
     *
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws IOException
     * @throws JAXBException
     */
    public Action resetoption(Action action) throws ClientProtocolException,
            ServerException, IOException, JAXBException {
        String url = this.getHref() + "/resetoption";
        return getProxy().action(url, action, Action.class, Action.class);
    }
    /**
     * Performs setoption action.
     *
     * @param action
     *
     * <pre>
     * action.option.name
     * action.option.value
     * </pre>
     *
     * @return
     *     {@link Action }
     *
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws IOException
     * @throws JAXBException
     */
    public Action setoption(Action action) throws ClientProtocolException,
            ServerException, IOException, JAXBException {
        String url = this.getHref() + "/setoption";
        return getProxy().action(url, action, Action.class, Action.class);
    }
    /**
     * Performs rebalance action.
     *
     * @param action
     *
     * <pre>
     * [action.fix_layout]
     * [action.force]
     * </pre>
     *
     * @return
     *     {@link Action }
     *
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws IOException
     * @throws JAXBException
     */
    public Action rebalance(Action action) throws ClientProtocolException,
            ServerException, IOException, JAXBException {
        String url = this.getHref() + "/rebalance";
        return getProxy().action(url, action, Action.class, Action.class);
    }

}

