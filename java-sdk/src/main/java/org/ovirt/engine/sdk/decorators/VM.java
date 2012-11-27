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
 * VM decorator.
 */
@SuppressWarnings("unused")
public class VM extends
        org.ovirt.engine.sdk.entities.VM {

    private HttpProxyBroker proxy;

    private VMPermissions vMPermissions;
    private VMTags vMTags;
    private VMSnapshots vMSnapshots;
    private VMStatistics vMStatistics;
    private VMDisks vMDisks;
    private VMNICs vMNICs;
    private VMCdRoms vMCdRoms;


    /**
     * @param proxy HttpProxyBroker
     */
    public VM(HttpProxyBroker proxy) {
        this.proxy = proxy;
    }

    /**
     * @return HttpProxyBroker
     */
    private HttpProxyBroker getProxy() {
        return proxy;
    }

    /**
     * Gets the value of the VMPermissions property.
     * 
     * @return
     *     possible object is
     *     {@link VMPermissions }
     *     
     */
    public synchronized VMPermissions getPermissions() {
        if (this.vMPermissions == null) {
            this.vMPermissions = new VMPermissions(proxy, this);
        }
        return vMPermissions;
    }
    /**
     * Gets the value of the VMTags property.
     * 
     * @return
     *     possible object is
     *     {@link VMTags }
     *     
     */
    public synchronized VMTags getTags() {
        if (this.vMTags == null) {
            this.vMTags = new VMTags(proxy, this);
        }
        return vMTags;
    }
    /**
     * Gets the value of the VMSnapshots property.
     * 
     * @return
     *     possible object is
     *     {@link VMSnapshots }
     *     
     */
    public synchronized VMSnapshots getSnapshots() {
        if (this.vMSnapshots == null) {
            this.vMSnapshots = new VMSnapshots(proxy, this);
        }
        return vMSnapshots;
    }
    /**
     * Gets the value of the VMStatistics property.
     * 
     * @return
     *     possible object is
     *     {@link VMStatistics }
     *     
     */
    public synchronized VMStatistics getStatistics() {
        if (this.vMStatistics == null) {
            this.vMStatistics = new VMStatistics(proxy, this);
        }
        return vMStatistics;
    }
    /**
     * Gets the value of the VMDisks property.
     * 
     * @return
     *     possible object is
     *     {@link VMDisks }
     *     
     */
    public synchronized VMDisks getDisks() {
        if (this.vMDisks == null) {
            this.vMDisks = new VMDisks(proxy, this);
        }
        return vMDisks;
    }
    /**
     * Gets the value of the VMNICs property.
     * 
     * @return
     *     possible object is
     *     {@link VMNICs }
     *     
     */
    public synchronized VMNICs getNics() {
        if (this.vMNICs == null) {
            this.vMNICs = new VMNICs(proxy, this);
        }
        return vMNICs;
    }
    /**
     * Gets the value of the VMCdRoms property.
     * 
     * @return
     *     possible object is
     *     {@link VMCdRoms }
     *     
     */
    public synchronized VMCdRoms getCdRoms() {
        if (this.vMCdRoms == null) {
            this.vMCdRoms = new VMCdRoms(proxy, this);
        }
        return vMCdRoms;
    }


   /**
    * Performs suspend action.
    *  
    * @param action Action
     *
    * @return
    *     {@link Action }
    *
    * @throws ClientProtocolException
    * @throws ServerException
    * @throws IOException
    * @throws JAXBException
    */
   public Action suspend(Action action) throws ClientProtocolException,
            ServerException, IOException, JAXBException {
        String url = this.getHref() + "/suspend";
        return getProxy().action(url, action, Action.class, Action.class);
    }
    /**
     * Updates VM object.
     *
     * @return
     *     possible object is
     *     {@link VM }
     *
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws IOException
     * @throws JAXBException
     */
    public VM update() throws ClientProtocolException,
            ServerException, IOException, JAXBException {
        String url = this.getHref();
        return getProxy().update(url, this, org.ovirt.engine.sdk.entities.VM.class, VM.class);
    }
   /**
    * Performs stop action.
    *  
    * @param action Action
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
    * Performs cancelmigration action.
    *  
    * @param action Action
     *
    * @return
    *     {@link Action }
    *
    * @throws ClientProtocolException
    * @throws ServerException
    * @throws IOException
    * @throws JAXBException
    */
   public Action cancelmigration(Action action) throws ClientProtocolException,
            ServerException, IOException, JAXBException {
        String url = this.getHref() + "/cancelmigration";
        return getProxy().action(url, action, Action.class, Action.class);
    }
   /**
    * Performs export action.
    *  
    * @param action Action
     *
    * @return
    *     {@link Action }
    *
    * @throws ClientProtocolException
    * @throws ServerException
    * @throws IOException
    * @throws JAXBException
    */
   public Action export(Action action) throws ClientProtocolException,
            ServerException, IOException, JAXBException {
        String url = this.getHref() + "/export";
        return getProxy().action(url, action, Action.class, Action.class);
    }
   /**
    * Performs detach action.
    *  
    * @param action Action
     *
    * @return
    *     {@link Action }
    *
    * @throws ClientProtocolException
    * @throws ServerException
    * @throws IOException
    * @throws JAXBException
    */
   public Action detach(Action action) throws ClientProtocolException,
            ServerException, IOException, JAXBException {
        String url = this.getHref() + "/detach";
        return getProxy().action(url, action, Action.class, Action.class);
    }
   /**
    * Performs ticket action.
    *  
    * @param action Action
     *
    * @return
    *     {@link Action }
    *
    * @throws ClientProtocolException
    * @throws ServerException
    * @throws IOException
    * @throws JAXBException
    */
   public Action ticket(Action action) throws ClientProtocolException,
            ServerException, IOException, JAXBException {
        String url = this.getHref() + "/ticket";
        return getProxy().action(url, action, Action.class, Action.class);
    }
   /**
    * Performs start action.
    *  
    * @param action Action
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
    * Performs migrate action.
    *  
    * @param action Action
     *
    * @return
    *     {@link Action }
    *
    * @throws ClientProtocolException
    * @throws ServerException
    * @throws IOException
    * @throws JAXBException
    */
   public Action migrate(Action action) throws ClientProtocolException,
            ServerException, IOException, JAXBException {
        String url = this.getHref() + "/migrate";
        return getProxy().action(url, action, Action.class, Action.class);
    }
    /**
     * Deletes resource.
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
    * Performs move action.
    *  
    * @param action Action
     *
    * @return
    *     {@link Action }
    *
    * @throws ClientProtocolException
    * @throws ServerException
    * @throws IOException
    * @throws JAXBException
    */
   public Action move(Action action) throws ClientProtocolException,
            ServerException, IOException, JAXBException {
        String url = this.getHref() + "/move";
        return getProxy().action(url, action, Action.class, Action.class);
    }
   /**
    * Performs shutdown action.
    *  
    * @param action Action
     *
    * @return
    *     {@link Action }
    *
    * @throws ClientProtocolException
    * @throws ServerException
    * @throws IOException
    * @throws JAXBException
    */
   public Action shutdown(Action action) throws ClientProtocolException,
            ServerException, IOException, JAXBException {
        String url = this.getHref() + "/shutdown";
        return getProxy().action(url, action, Action.class, Action.class);
    }

}

