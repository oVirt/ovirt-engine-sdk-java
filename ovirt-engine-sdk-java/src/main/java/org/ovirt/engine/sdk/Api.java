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

package org.ovirt.engine.sdk;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.ovirt.engine.sdk.web.ConnectionsPool;
import org.ovirt.engine.sdk.web.ConnectionsPoolBuilder;
import org.ovirt.engine.sdk.web.HttpProxy;
import org.ovirt.engine.sdk.web.HttpProxyBroker;
import org.ovirt.engine.sdk.web.HttpProxyBuilder;
import org.ovirt.engine.sdk.decorators.*;
import org.ovirt.engine.sdk.entities.API;
import org.ovirt.engine.sdk.exceptions.ServerException;
import org.ovirt.engine.sdk.exceptions.UnsecuredConnectionAttemptError;
import org.ovirt.engine.sdk.utils.SerializationHelper;

/**
 * oVirt virtualization Java SDK.
 */
public class Api implements AutoCloseable {

    private volatile HttpProxyBroker proxy = null;
    private volatile API entryPoint = null;
    private final Object LOCK = new Object();

    private volatile Tags tags;
    private volatile Networks networks;
    private volatile Users users;
    private volatile Jobs jobs;
    private volatile Templates templates;
    private volatile Events events;
    private volatile Domains domains;
    private volatile Disks disks;
    private volatile VnicProfiles vnicProfiles;
    private volatile Clusters clusters;
    private volatile DataCenters dataCenters;
    private volatile Roles roles;
    private volatile Hosts hosts;
    private volatile VMs vMs;
    private volatile StorageConnections storageConnections;
    private volatile VmPools vmPools;
    private volatile StorageDomains storageDomains;
    private volatile Capabilities capabilities;
    private volatile Groups groups;


    /**
     * @param url
     *            oVirt api url
     * @param username
     *            oVirt api username
     * @param password
     *            oVirt api password
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     * @throws UnsecuredConnectionAttemptError
     *             Signals that attempt of connecting to SSL secured site using
     *             HTTP protocol has occurred.
     */
    public Api(String url, String username, String password) throws ClientProtocolException, ServerException,
            IOException, UnsecuredConnectionAttemptError {

        configureLog4J();
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
     * @param keyStorePath
     *            path to CA certificate KeyStore
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     * @throws UnsecuredConnectionAttemptError
     *             Signals that attempt of connecting to SSL secured site
     *             using HTTP protocol has occurred.
     */
    public Api(String url, String username, String password, String keyStorePath)
            throws ClientProtocolException, ServerException, IOException,
                   UnsecuredConnectionAttemptError {

        configureLog4J();
        ConnectionsPool pool = new ConnectionsPoolBuilder(url, username, password)
                .keyStorePath(keyStorePath)
                .build();
        HttpProxy httpProxy = new HttpProxyBuilder(pool)
                .build();
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
     * @param keyStorePath
     *            path to CA certificate KeyStore
     * @param keyStorePassword
     *            password for the CA certificate KeyStore
     * @param filter
     *            enables filtering based on user's permissions
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     * @throws UnsecuredConnectionAttemptError
     *             Signals that attempt of connecting to SSL secured site
     *             using HTTP protocol has occurred.
     */
    public Api(String url, String username, String password, String keyStorePath, String keyStorePassword, Boolean filter)
            throws ClientProtocolException, ServerException, UnsecuredConnectionAttemptError, IOException {

        configureLog4J();
        ConnectionsPool pool = new ConnectionsPoolBuilder(url, username, password)
                .keyStorePath(keyStorePath)
                .keyStorePassword(keyStorePassword)
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
     * @param sessionid
     *            oVirt api sessionid to authenticate the user with
     *            (used as SSO solution instead of username+password)
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     * @throws UnsecuredConnectionAttemptError
     *             Signals that attempt of connecting to SSL secured site
     *             using HTTP protocol has occurred.
     */
    public Api(String url, String sessionid) throws ClientProtocolException, ServerException,
            IOException, UnsecuredConnectionAttemptError {

        configureLog4J();
        ConnectionsPool pool = new ConnectionsPoolBuilder(url).build();
        HttpProxy httpProxy = new HttpProxyBuilder(pool)
                .sessionid(sessionid)
                .persistentAuth(true)
                .build();
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
     * @param noHostVerification
     *            turns hostname verification off
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     * @throws UnsecuredConnectionAttemptError
     *             Signals that attempt of connecting to SSL secured site
     *             using HTTP protocol has occurred.
     */
    public Api(String url, String username, String password, boolean noHostVerification)
            throws ClientProtocolException, ServerException, UnsecuredConnectionAttemptError, IOException {

        configureLog4J();
        ConnectionsPool pool = new ConnectionsPoolBuilder(url, username, password)
                .noHostVerification(noHostVerification)
                .build();
        HttpProxy httpProxy = new HttpProxyBuilder(pool)
                .build();
        this.proxy = new HttpProxyBroker(httpProxy);
        initResources();
    }

    /**
     * @param url
     *            oVirt api url
     * @param sessionid
     *            oVirt api sessionid to authenticate the user with
     *            (used as SSO solution instead of username+password)
     * @param noHostVerification
     *            turns hostname verification off
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     * @throws UnsecuredConnectionAttemptError
     *             Signals that attempt of connecting to SSL secured site
     *             using HTTP protocol has occurred.
     */
    public Api(String url, String sessionid, boolean noHostVerification)
            throws ClientProtocolException, ServerException, UnsecuredConnectionAttemptError, IOException {

        configureLog4J();
        ConnectionsPool pool = new ConnectionsPoolBuilder(url)
                .noHostVerification(noHostVerification)
                .build();
        HttpProxy httpProxy = new HttpProxyBuilder(pool)
                .sessionid(sessionid)
                .persistentAuth(true)
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
     * @param noHostVerification
     *            turns hostname verification off
     * @param filter
     *            enables filtering based on user's permissions
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     * @throws UnsecuredConnectionAttemptError
     *             Signals that attempt of connecting to SSL secured site
     *             using HTTP protocol has occurred.
     */
    public Api(String url, String username, String password, Boolean noHostVerification, Boolean filter)
            throws ClientProtocolException, ServerException, UnsecuredConnectionAttemptError, IOException {

        configureLog4J();
        ConnectionsPool pool = new ConnectionsPoolBuilder(url, username, password)
                .noHostVerification(noHostVerification)
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
     * @param sessionid
     *            oVirt api sessionid to authenticate the user with
     *            (used as SSO solution instead of username+password)
     * @param port
     *            oVirt api port
     * @param timeout
     *            request timeout
     * @param persistentAuth
     *            disable persistent authentication (will be used auth. per request)
     * @param noHostVerification
     *            turns hostname verification off
     * @param filter
     *            enables filtering based on user's permissions
     * @param debug
     *            enables debug mode
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     * @throws UnsecuredConnectionAttemptError
     *             Signals that attempt of connecting to SSL secured site
     *             using HTTP protocol has occurred.
     */
    public Api(String url, String username, String password, String sessionid, Integer port, Integer timeout,
            Boolean persistentAuth, Boolean noHostVerification, Boolean filter, Boolean debug)
            throws ClientProtocolException, ServerException, UnsecuredConnectionAttemptError, IOException {

        configureLog4J(debug);
        ConnectionsPool pool = new ConnectionsPoolBuilder(url, username, password)
                .port(port)
                .timeout(timeout)
                .noHostVerification(noHostVerification)
                .build();
        HttpProxy httpProxy = new HttpProxyBuilder(pool)
                .sessionid(sessionid)
                .persistentAuth(persistentAuth)
                .filter(filter)
                .debug(debug)
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
     * @param sessionid
     *            oVirt api sessionid to authenticate the user with
     *            (used as SSO solution instead of username+password)
     * @param port
     *            oVirt api port
     * @param timeout
     *            request timeout
     * @param persistentAuth
     *            disable persistent authentication
     *            (will be used auth. per request)
     * @param keyStorePath
     *            path to CA certificate KeyStore
     * @param keyStorePassword
     *            password for the CA certificate KeyStore
     * @param filter
     *            enables filtering based on user's permissions
     * @param debug
     *            enables debug mode
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     * @throws UnsecuredConnectionAttemptError
     *             Signals that attempt of connecting to SSL secured
     *             site using HTTP protocol has occurred.
     */
    public Api(String url, String username, String password, String sessionid, Integer port, Integer timeout,
            Boolean persistentAuth, String keyStorePath, String keyStorePassword, Boolean filter, Boolean debug)
            throws ClientProtocolException, ServerException, UnsecuredConnectionAttemptError, IOException {

        configureLog4J(debug);
        ConnectionsPool pool = new ConnectionsPoolBuilder(url, username, password)
                .port(port)
                .timeout(timeout)
                .keyStorePath(keyStorePath)
                .keyStorePassword(keyStorePassword)
                .build();
        HttpProxy httpProxy = new HttpProxyBuilder(pool)
                .sessionid(sessionid)
                .persistentAuth(persistentAuth)
                .filter(filter)
                .debug(debug)
                .build();
        this.proxy = new HttpProxyBroker(httpProxy);
        initResources();
    }

    /**
     * Configures log4j
     */
    private void configureLog4J() {
        configureLog4J(Boolean.FALSE);
    }

    /**
     * Configures log4j
     *
     * @param debug
     */
    private void configureLog4J(Boolean debug) {
        String patternLayout = "%d %-5p [%c] %m%n";
        if (debug != null && Boolean.TRUE.equals(debug)) {

            Logger rootLogger = Logger.getRootLogger();
            if (!rootLogger.getAllAppenders().hasMoreElements()) {
                rootLogger.setLevel(Level.INFO);
                rootLogger.addAppender(new ConsoleAppender(
                        new PatternLayout(patternLayout)));

            }
            Logger pkgLogger =
                    rootLogger.getLoggerRepository()
                            .getLogger("org.apache.http");
            pkgLogger.setLevel(Level.DEBUG);
            pkgLogger.addAppender(new ConsoleAppender(
                    new PatternLayout(patternLayout)));

        } else {
            Logger rootLogger = Logger.getRootLogger();
            if (!rootLogger.getAllAppenders().hasMoreElements()) {
                rootLogger.setLevel(Level.OFF);
                rootLogger.addAppender(new ConsoleAppender(
                        new PatternLayout(patternLayout)));
            }
        }
    }

    /**
     * Fetches /api entry point
     *
     * @return API object instance
     */
    private API getEntryPoint() throws ClientProtocolException, ServerException, IOException,
            UnsecuredConnectionAttemptError {
        String entryPointXML = this.proxy.get(this.proxy.getRoot());
        if (entryPointXML != null && !entryPointXML.equals("")) {
            return SerializationHelper.unmarshall(API.class, entryPointXML);
        }
        throw new UnsecuredConnectionAttemptError();
    }

    /**
     * initializes resources
     */
    private synchronized void initResources() throws ClientProtocolException, ServerException, UnsecuredConnectionAttemptError,
            IOException {
        this.entryPoint = getEntryPoint();
    }

    /**
     * Enable/Disable client permissions based filtering (default is False)
     *
     * @param filter
     */
    public synchronized void setFilter(boolean filter) {
        this.proxy.setFilter(filter);
    }

    /**
     * Enable/Disable persistent authentication (default is True)
     *
     * @param persistentAuth
     */
    public synchronized void setPersistentAuth(boolean persistentAuth) {
        this.proxy.setPersistentAuth(persistentAuth);
    }

    /**
     * @return persistent authentication flag
     */
    public boolean isPersistentAuth() {
        return this.proxy.isPersistentAuth();
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

    /**
     * @param sessionid
     *            oVirt api sessionid to authenticate the user with
     *            (used as SSO solution instead of username+password)
     */
    public synchronized void setSessionid(String sessionid) {
        this.proxy.setSessionid(sessionid);
    }

    /**
    * oVirt api sessionid to authenticate the user with
    * (used as SSO solution instead of username+password)
     */
    public boolean isSetSessionid() {
        return this.proxy.isSetSessionid();
    }

    /**
     * When SDK instance is no longer needed, shut down the connection
     * manager/httpproxy to ensure immediate deallocation of all system
     * resources.
     */
    public synchronized void shutdown() {
        proxy.shutdown();
    }

    /**
     * Closes this resource, relinquishing any underlying resources.
     * This method is invoked automatically on objects managed by the
     * try-with-resources statement.
     */
    @Override
    public void close() throws Exception {
        shutdown();
    }

    /**
     * Gets the value of the Tags property.
     *
     * @return
     *     {@link Tags }
     *
     */
    public Tags getTags() {
        if (this.tags == null) {
            synchronized (this.LOCK) {
                if (this.tags == null) {
                    this.tags = new Tags(proxy);
                }
            }
        }
        return tags;
    }
    /**
     * Gets the value of the Networks property.
     *
     * @return
     *     {@link Networks }
     *
     */
    public Networks getNetworks() {
        if (this.networks == null) {
            synchronized (this.LOCK) {
                if (this.networks == null) {
                    this.networks = new Networks(proxy);
                }
            }
        }
        return networks;
    }
    /**
     * Gets the value of the Users property.
     *
     * @return
     *     {@link Users }
     *
     */
    public Users getUsers() {
        if (this.users == null) {
            synchronized (this.LOCK) {
                if (this.users == null) {
                    this.users = new Users(proxy);
                }
            }
        }
        return users;
    }
    /**
     * Gets the value of the Jobs property.
     *
     * @return
     *     {@link Jobs }
     *
     */
    public Jobs getJobs() {
        if (this.jobs == null) {
            synchronized (this.LOCK) {
                if (this.jobs == null) {
                    this.jobs = new Jobs(proxy);
                }
            }
        }
        return jobs;
    }
    /**
     * Gets the value of the Templates property.
     *
     * @return
     *     {@link Templates }
     *
     */
    public Templates getTemplates() {
        if (this.templates == null) {
            synchronized (this.LOCK) {
                if (this.templates == null) {
                    this.templates = new Templates(proxy);
                }
            }
        }
        return templates;
    }
    /**
     * Gets the value of the Events property.
     *
     * @return
     *     {@link Events }
     *
     */
    public Events getEvents() {
        if (this.events == null) {
            synchronized (this.LOCK) {
                if (this.events == null) {
                    this.events = new Events(proxy);
                }
            }
        }
        return events;
    }
    /**
     * Gets the value of the Domains property.
     *
     * @return
     *     {@link Domains }
     *
     */
    public Domains getDomains() {
        if (this.domains == null) {
            synchronized (this.LOCK) {
                if (this.domains == null) {
                    this.domains = new Domains(proxy);
                }
            }
        }
        return domains;
    }
    /**
     * Gets the value of the Disks property.
     *
     * @return
     *     {@link Disks }
     *
     */
    public Disks getDisks() {
        if (this.disks == null) {
            synchronized (this.LOCK) {
                if (this.disks == null) {
                    this.disks = new Disks(proxy);
                }
            }
        }
        return disks;
    }
    /**
     * Gets the value of the VnicProfiles property.
     *
     * @return
     *     {@link VnicProfiles }
     *
     */
    public VnicProfiles getVnicProfiles() {
        if (this.vnicProfiles == null) {
            synchronized (this.LOCK) {
                if (this.vnicProfiles == null) {
                    this.vnicProfiles = new VnicProfiles(proxy);
                }
            }
        }
        return vnicProfiles;
    }
    /**
     * Gets the value of the Clusters property.
     *
     * @return
     *     {@link Clusters }
     *
     */
    public Clusters getClusters() {
        if (this.clusters == null) {
            synchronized (this.LOCK) {
                if (this.clusters == null) {
                    this.clusters = new Clusters(proxy);
                }
            }
        }
        return clusters;
    }
    /**
     * Gets the value of the DataCenters property.
     *
     * @return
     *     {@link DataCenters }
     *
     */
    public DataCenters getDataCenters() {
        if (this.dataCenters == null) {
            synchronized (this.LOCK) {
                if (this.dataCenters == null) {
                    this.dataCenters = new DataCenters(proxy);
                }
            }
        }
        return dataCenters;
    }
    /**
     * Gets the value of the Roles property.
     *
     * @return
     *     {@link Roles }
     *
     */
    public Roles getRoles() {
        if (this.roles == null) {
            synchronized (this.LOCK) {
                if (this.roles == null) {
                    this.roles = new Roles(proxy);
                }
            }
        }
        return roles;
    }
    /**
     * Gets the value of the Hosts property.
     *
     * @return
     *     {@link Hosts }
     *
     */
    public Hosts getHosts() {
        if (this.hosts == null) {
            synchronized (this.LOCK) {
                if (this.hosts == null) {
                    this.hosts = new Hosts(proxy);
                }
            }
        }
        return hosts;
    }
    /**
     * Gets the value of the VMs property.
     *
     * @return
     *     {@link VMs }
     *
     */
    public VMs getVMs() {
        if (this.vMs == null) {
            synchronized (this.LOCK) {
                if (this.vMs == null) {
                    this.vMs = new VMs(proxy);
                }
            }
        }
        return vMs;
    }
    /**
     * Gets the value of the StorageConnections property.
     *
     * @return
     *     {@link StorageConnections }
     *
     */
    public StorageConnections getStorageConnections() {
        if (this.storageConnections == null) {
            synchronized (this.LOCK) {
                if (this.storageConnections == null) {
                    this.storageConnections = new StorageConnections(proxy);
                }
            }
        }
        return storageConnections;
    }
    /**
     * Gets the value of the VmPools property.
     *
     * @return
     *     {@link VmPools }
     *
     */
    public VmPools getVmPools() {
        if (this.vmPools == null) {
            synchronized (this.LOCK) {
                if (this.vmPools == null) {
                    this.vmPools = new VmPools(proxy);
                }
            }
        }
        return vmPools;
    }
    /**
     * Gets the value of the StorageDomains property.
     *
     * @return
     *     {@link StorageDomains }
     *
     */
    public StorageDomains getStorageDomains() {
        if (this.storageDomains == null) {
            synchronized (this.LOCK) {
                if (this.storageDomains == null) {
                    this.storageDomains = new StorageDomains(proxy);
                }
            }
        }
        return storageDomains;
    }
    /**
     * Gets the value of the Capabilities property.
     *
     * @return
     *     {@link Capabilities }
     *
     */
    public Capabilities getCapabilities() {
        if (this.capabilities == null) {
            synchronized (this.LOCK) {
                if (this.capabilities == null) {
                    this.capabilities = new Capabilities(proxy);
                }
            }
        }
        return capabilities;
    }
    /**
     * Gets the value of the Groups property.
     *
     * @return
     *     {@link Groups }
     *
     */
    public Groups getGroups() {
        if (this.groups == null) {
            synchronized (this.LOCK) {
                if (this.groups == null) {
                    this.groups = new Groups(proxy);
                }
            }
        }
        return groups;
    }


    /**
     * Gets the value of the Time property.
     *
     * @return {@link javax.xml.datatype.XMLGregorianCalendar }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     * @throws UnsecuredConnectionAttemptError
     *             Signals that attempt of connecting to SSL secured site using HTTP protocol has occurred.
     */
    public javax.xml.datatype.XMLGregorianCalendar getTime() throws ClientProtocolException, ServerException,
            UnsecuredConnectionAttemptError, IOException {
        return getEntryPoint().getTime();
    }
    /**
     * Gets the value of the SpecialObjects property.
     *
     * @return {@link org.ovirt.engine.sdk.entities.SpecialObjects }
     *
     */
    public org.ovirt.engine.sdk.entities.SpecialObjects getSpecialObjects() {
        if (this.entryPoint != null) {
            return this.entryPoint.getSpecialObjects();
        }
        return null;
    }
    /**
     * Gets the value of the ProductInfo property.
     *
     * @return {@link org.ovirt.engine.sdk.entities.ProductInfo }
     *
     */
    public org.ovirt.engine.sdk.entities.ProductInfo getProductInfo() {
        if (this.entryPoint != null) {
            return this.entryPoint.getProductInfo();
        }
        return null;
    }
    /**
     * Gets the value of the Summary property.
     *
     * @return {@link org.ovirt.engine.sdk.entities.ApiSummary }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     * @throws UnsecuredConnectionAttemptError
     *             Signals that attempt of connecting to SSL secured site using HTTP protocol has occurred.
     */
    public org.ovirt.engine.sdk.entities.ApiSummary getSummary() throws ClientProtocolException, ServerException,
            UnsecuredConnectionAttemptError, IOException {
        return getEntryPoint().getSummary();
    }
    /**
     * Gets the value of the Comment property.
     *
     * @return {@link java.lang.String }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     * @throws UnsecuredConnectionAttemptError
     *             Signals that attempt of connecting to SSL secured site using HTTP protocol has occurred.
     */
    public java.lang.String getComment() throws ClientProtocolException, ServerException,
            UnsecuredConnectionAttemptError, IOException {
        return getEntryPoint().getComment();
    }

}

