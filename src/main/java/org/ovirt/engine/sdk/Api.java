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
import org.ovirt.engine.api.model.API;
import org.ovirt.engine.api.model.ProductInfo;
import org.ovirt.engine.sdk.web.ConnectionsPool;
import org.ovirt.engine.sdk.web.HttpProxy;
import org.ovirt.engine.sdk.decorators.Vms;
import org.ovirt.engine.sdk.exceptions.ServerException;
import org.ovirt.engine.sdk.exceptions.UnsecuredConnectionAttemptError;
import org.ovirt.engine.sdk.utils.ConnectionsPoolBuilder;
import org.ovirt.engine.sdk.utils.HttpProxyBuilder;
import org.ovirt.engine.sdk.utils.SerializationHelper;

public class Api {
    /**
     * oVirt SDK proxy
     */

    private HttpProxy proxy = null;
    private API entryPoint = null;

    private Vms vms;

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

        ConnectionsPool pool = new ConnectionsPoolBuilder(url, username, password)
                .build();
        this.proxy = new HttpProxyBuilder(pool)
                .build();
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

        ConnectionsPool pool = new ConnectionsPoolBuilder(url, username, password)
                .build();
        this.proxy = new HttpProxyBuilder(pool)
                .insecure(insecure)
                .build();
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

        ConnectionsPool pool = new ConnectionsPoolBuilder(url, username, password)
                .ca_file(ca_file)
                .build();
        this.proxy = new HttpProxyBuilder(pool)
                .filter(filter)
                .build();
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

        ConnectionsPool pool = new ConnectionsPoolBuilder(url, username, password)
                .key_file(key_file)
                .cert_file(cert_file)
                .ca_file(ca_file)
                .port(port)
                .timeout(timeout)
                .build();
        this.proxy = new HttpProxyBuilder(pool)
                .persistentAuth(persistentAuth)
                .insecure(insecure)
                .filter(filter)
                .debug(debug)
                .build();
        initResources();
    }

    private API getEntryPoint() throws ClientProtocolException, ServerException, IOException,
            UnsecuredConnectionAttemptError, JAXBException {
        String entryPointXML = this.proxy.getRootResource();
        if (entryPointXML != null && !entryPointXML.equals("")) {
            return SerializationHelper.unmarshall(API.class, entryPointXML);
        }
        throw new UnsecuredConnectionAttemptError();
    }

    /**
     * Sets filter property
     * 
     * @param filter
     */
    public void setFilter(boolean filter) {
        this.proxy.setFilter(filter);
    }

    private void initResources() throws ClientProtocolException, ServerException, UnsecuredConnectionAttemptError,
            IOException, JAXBException {
        this.entryPoint = getEntryPoint();
        this.vms = new Vms(this.proxy);
    }

    /**
     * Returns collection of vms
     * 
     * @return Vms
     */
    public Vms getVms() {
        return vms;
    }

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
}
