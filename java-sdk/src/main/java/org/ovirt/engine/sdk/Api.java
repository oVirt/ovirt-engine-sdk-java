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

import javax.xml.bind.JAXBException;

import org.apache.http.client.ClientProtocolException;
import org.ovirt.engine.sdk.web.ConnectionsPool;
import org.ovirt.engine.sdk.web.ConnectionsPoolBuilder;
import org.ovirt.engine.sdk.web.HttpProxy;
import org.ovirt.engine.sdk.web.HttpProxyBroker;
import org.ovirt.engine.sdk.web.HttpProxyBuilder;
// TODO: import root-collections here
//import org.ovirt.engine.sdk.decorators.Vms;
import org.ovirt.engine.sdk.entities.API;
import org.ovirt.engine.sdk.entities.ProductInfo;
import org.ovirt.engine.sdk.exceptions.ServerException;
import org.ovirt.engine.sdk.exceptions.UnsecuredConnectionAttemptError;
import org.ovirt.engine.sdk.utils.SerializationHelper;

/**
 * oVirt virtualization Java SDK
 */
public class Api {

    private HttpProxyBroker proxy = null;
    private API entryPoint = null;

    // TODO: create root-collection variables herer
    // private Vms vms;

    /**
     * @param url
     *            oVirt api url
     * @param username
     *            oVirt api username
     * @param password
     *            oVirt api password
     * @throws ClientProtocolException
     * @throws ServerException
     *             oVirt api error
     * @throws IOException
     * @throws UnsecuredConnectionAttemptError
     * @throws JAXBException
     */
    public Api(String url, String username, String password) throws ClientProtocolException, ServerException,
            IOException, UnsecuredConnectionAttemptError, JAXBException {

        // FIXME: do not throw ClientProtocolException/JAXBException

        ConnectionsPool pool = new ConnectionsPoolBuilder(url, username, password).build();
        HttpProxy httpProxy = new HttpProxyBuilder(pool).build();
        this.proxy = new HttpProxyBroker(httpProxy);
        this.initResources();
    }

    /**
     * @param url
     *            oVirt api url
     * @param username
     *            oVirt api username
     * @param password
     *            oVirt api password
     * @param insecure
     *            do not throw error when accessing SSL sites without certificate
     * @throws ClientProtocolException
     * @throws ServerException
     *             oVirt api error
     * @throws UnsecuredConnectionAttemptError
     * @throws IOException
     * @throws JAXBException
     */
    public Api(String url, String username, String password, boolean insecure) throws ClientProtocolException,
            ServerException, UnsecuredConnectionAttemptError, IOException, JAXBException {

        // FIXME: do not throw ClientProtocolException/JAXBException

        ConnectionsPool pool = new ConnectionsPoolBuilder(url, username, password)
                                 .build();
        HttpProxy httpProxy = new HttpProxyBuilder(pool)
                                 .insecure(insecure)
                                 .build();
        this.proxy = new HttpProxyBroker(httpProxy);
        initResources();
    }

    /**
     * @param url
     *            oVirt api url
     * @param username
     *            oVirt api username
     * @param password
     *            oVirt api password
     * @param ca_file
     *            CA certificate to validate the server identity
     * @param filter
     *            enables filtering based on user's permissions
     * @throws ClientProtocolException
     * @throws ServerException
     *             oVirt api error
     * @throws UnsecuredConnectionAttemptError
     * @throws IOException
     * @throws JAXBException
     */
    public Api(String url, String username, String password, String ca_file, boolean filter)
            throws ClientProtocolException, ServerException, UnsecuredConnectionAttemptError, IOException,
            JAXBException {

        // FIXME: do not throw ClientProtocolException/JAXBException

        ConnectionsPool pool = new ConnectionsPoolBuilder(url, username, password)
                                   .ca_file(ca_file)
                                   .build();
        HttpProxy httpProxy = new HttpProxyBuilder(pool)
                                   .filter(filter)
                                   .build();
        this.proxy = new HttpProxyBroker(httpProxy);
        initResources();
    }

    /**
     * @param url
     *            oVirt api url
     * @param username
     *            oVirt api username
     * @param password
     *            oVirt api password
     * @param key_file
     *            user key file to validate client identity
     * @param cert_file
     *            user certificate file to validate client identity
     * @param ca_file
     *            CA certificate to validate the server identity
     * @param port
     *            oVirt api port
     * @param timeout
     *            request timeout
     * @param persistentAuth
     *            disable persistent authetication (will be used auth. per request)
     * @param insecure
     *            do not throw error when accessing SSL sites without certificate
     * @param filter
     *            enables filtering based on user's permissions
     * @param debug
     *            enables debug mode
     * @throws ClientProtocolException
     * @throws ServerException
     *             oVirt api error
     * @throws UnsecuredConnectionAttemptError
     * @throws IOException
     * @throws JAXBException
     */
    public Api(String url, String username, String password, String key_file,
              String cert_file, String ca_file, Integer port, Integer timeout,
              Boolean persistentAuth, Boolean insecure, Boolean filter, Boolean debug) throws ClientProtocolException,
            ServerException, UnsecuredConnectionAttemptError, IOException, JAXBException {

        // FIXME: do not throw ClientProtocolException/JAXBException

        ConnectionsPool pool = new ConnectionsPoolBuilder(url, username, password)
                                .key_file(key_file)
                                .cert_file(cert_file)
                                .ca_file(ca_file)
                                .port(port)
                                .timeout(timeout)
                                .build();
        HttpProxy httpProxy = new HttpProxyBuilder(pool)
                                .persistentAuth(persistentAuth)
                                .insecure(insecure)
                                .filter(filter)
                                .debug(debug)
                                .build();
        this.proxy = new HttpProxyBroker(httpProxy);
        initResources();
    }

    private API getEntryPoint() throws ClientProtocolException, ServerException, IOException,
            UnsecuredConnectionAttemptError, JAXBException {
        String entryPointXML = this.proxy.get(this.proxy.getRoot());
        if (entryPointXML != null && !entryPointXML.equals("")) {
            return SerializationHelper.unmarshall(API.class, entryPointXML);
        }
        throw new UnsecuredConnectionAttemptError();
    }

    private void initResources() throws ClientProtocolException, ServerException, UnsecuredConnectionAttemptError,
            IOException, JAXBException {
        this.entryPoint = getEntryPoint();
        // TODO: init root-collections here
        // this.vms = new Vms(this.proxy);
    }

    /**
     * Enable/Disable client permissions based filtering (default is False)
     * 
     * @param filter
     */
    public void setFilter(boolean filter) {
        this.proxy.setFilter(filter);
    }

    /**
     * Enable/Disable debug mode (default is False)
     * 
     * @param debug
     */
    public void setDebug(boolean debug) {
        this.proxy.setDebug(debug);
    }

    /**
     * Enable/Disable accessing SSL sites without validating host identity (default is False)
     * 
     * @param insecure
     */
    public void setInsecure(boolean insecure) {
        this.proxy.setInsecure(insecure);
    }

    /**
     * Enable/Disable persistent authentication (default is True)
     * 
     * @param persistentAuth
     */
    public void setPersistentAuth(boolean persistentAuth) {
        this.proxy.setPersistentAuth(persistentAuth);
    }

    /**
     * @return persistent authentication flag
     */
    public boolean isPersistentAuth() {
        return this.proxy.isPersistentAuth();
    }

    /**
     * @return Insecure flag
     */
    public boolean isInsecure() {
        return this.proxy.isInsecure();
    }

    /**
     * @return Filter flag
     */
    public boolean isFilter() {
        return this.proxy.isFilter();
    }

    /**
     * @return Debug flag
     */
    public boolean isDebug() {
        return this.proxy.isDebug();
    }

    // TODO: create root-collection getters here
    // /**
    // * Returns collection of vms
    // *
    // * @return Vms
    // */
    // public Vms getVms() {
    // return vms;
    // }

    // TODO: add all root collections

    /**
     * Returns oVirt API product info
     * 
     * @return ProductInfo
     */
    public ProductInfo getProductInfo() {
        if (!entryPoint.equals(null)) {
            return this.entryPoint.getProductInfo();
        }
        return null;
    }

    // TODO: add all getX() root resources properties
}
