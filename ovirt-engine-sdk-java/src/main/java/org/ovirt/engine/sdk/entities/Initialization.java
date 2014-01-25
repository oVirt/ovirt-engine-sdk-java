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


package org.ovirt.engine.sdk.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Initialization complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Initialization">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="configuration" type="{}Configuration" minOccurs="0"/>
 *         &lt;element name="cloud_init" type="{}CloudInit" minOccurs="0"/>
 *         &lt;element name="host_name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="domain" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="timezone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="authorized_ssh_keys" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="regenerate_ssh_keys" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="dns_servers" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dns_search" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nics" type="{}GuestNicsConfiguration" minOccurs="0"/>
 *         &lt;element name="windows_license_key" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="root_password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="custom_script" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Initialization", propOrder = {
    "configuration",
    "cloudInit",
    "hostName",
    "domain",
    "timezone",
    "authorizedSshKeys",
    "regenerateSshKeys",
    "dnsServers",
    "dnsSearch",
    "nics",
    "windowsLicenseKey",
    "rootPassword",
    "customScript"
})
public class Initialization {

    protected Configuration configuration;
    @XmlElement(name = "cloud_init")
    protected CloudInit cloudInit;
    @XmlElement(name = "host_name")
    protected String hostName;
    protected String domain;
    protected String timezone;
    @XmlElement(name = "authorized_ssh_keys")
    protected String authorizedSshKeys;
    @XmlElement(name = "regenerate_ssh_keys")
    protected Boolean regenerateSshKeys;
    @XmlElement(name = "dns_servers")
    protected String dnsServers;
    @XmlElement(name = "dns_search")
    protected String dnsSearch;
    protected GuestNicsConfiguration nics;
    @XmlElement(name = "windows_license_key")
    protected String windowsLicenseKey;
    @XmlElement(name = "root_password")
    protected String rootPassword;
    @XmlElement(name = "custom_script")
    protected String customScript;

    /**
     * Gets the value of the configuration property.
     *
     * @return
     *     possible object is
     *     {@link Configuration }
     *
     */
    public Configuration getConfiguration() {
        return configuration;
    }

    /**
     * Sets the value of the configuration property.
     *
     * @param value
     *     allowed object is
     *     {@link Configuration }
     *
     */
    public void setConfiguration(Configuration value) {
        this.configuration = value;
    }

    public boolean isSetConfiguration() {
        return (this.configuration!= null);
    }

    /**
     * Gets the value of the cloudInit property.
     *
     * @return
     *     possible object is
     *     {@link CloudInit }
     *
     */
    public CloudInit getCloudInit() {
        return cloudInit;
    }

    /**
     * Sets the value of the cloudInit property.
     *
     * @param value
     *     allowed object is
     *     {@link CloudInit }
     *
     */
    public void setCloudInit(CloudInit value) {
        this.cloudInit = value;
    }

    public boolean isSetCloudInit() {
        return (this.cloudInit!= null);
    }

    /**
     * Gets the value of the hostName property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getHostName() {
        return hostName;
    }

    /**
     * Sets the value of the hostName property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setHostName(String value) {
        this.hostName = value;
    }

    public boolean isSetHostName() {
        return (this.hostName!= null);
    }

    /**
     * Gets the value of the domain property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDomain() {
        return domain;
    }

    /**
     * Sets the value of the domain property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDomain(String value) {
        this.domain = value;
    }

    public boolean isSetDomain() {
        return (this.domain!= null);
    }

    /**
     * Gets the value of the timezone property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getTimezone() {
        return timezone;
    }

    /**
     * Sets the value of the timezone property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTimezone(String value) {
        this.timezone = value;
    }

    public boolean isSetTimezone() {
        return (this.timezone!= null);
    }

    /**
     * Gets the value of the authorizedSshKeys property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAuthorizedSshKeys() {
        return authorizedSshKeys;
    }

    /**
     * Sets the value of the authorizedSshKeys property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAuthorizedSshKeys(String value) {
        this.authorizedSshKeys = value;
    }

    public boolean isSetAuthorizedSshKeys() {
        return (this.authorizedSshKeys!= null);
    }

    /**
     * Gets the value of the regenerateSshKeys property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getRegenerateSshKeys() {
        return regenerateSshKeys;
    }

    /**
     * Sets the value of the regenerateSshKeys property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setRegenerateSshKeys(Boolean value) {
        this.regenerateSshKeys = value;
    }

    public boolean isSetRegenerateSshKeys() {
        return (this.regenerateSshKeys!= null);
    }

    /**
     * Gets the value of the dnsServers property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDnsServers() {
        return dnsServers;
    }

    /**
     * Sets the value of the dnsServers property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDnsServers(String value) {
        this.dnsServers = value;
    }

    public boolean isSetDnsServers() {
        return (this.dnsServers!= null);
    }

    /**
     * Gets the value of the dnsSearch property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDnsSearch() {
        return dnsSearch;
    }

    /**
     * Sets the value of the dnsSearch property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDnsSearch(String value) {
        this.dnsSearch = value;
    }

    public boolean isSetDnsSearch() {
        return (this.dnsSearch!= null);
    }

    /**
     * Gets the value of the nics property.
     *
     * @return
     *     possible object is
     *     {@link GuestNicsConfiguration }
     *
     */
    public GuestNicsConfiguration getNics() {
        return nics;
    }

    /**
     * Sets the value of the nics property.
     *
     * @param value
     *     allowed object is
     *     {@link GuestNicsConfiguration }
     *
     */
    public void setNics(GuestNicsConfiguration value) {
        this.nics = value;
    }

    public boolean isSetNics() {
        return (this.nics!= null);
    }

    /**
     * Gets the value of the windowsLicenseKey property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getWindowsLicenseKey() {
        return windowsLicenseKey;
    }

    /**
     * Sets the value of the windowsLicenseKey property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setWindowsLicenseKey(String value) {
        this.windowsLicenseKey = value;
    }

    public boolean isSetWindowsLicenseKey() {
        return (this.windowsLicenseKey!= null);
    }

    /**
     * Gets the value of the rootPassword property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getRootPassword() {
        return rootPassword;
    }

    /**
     * Sets the value of the rootPassword property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setRootPassword(String value) {
        this.rootPassword = value;
    }

    public boolean isSetRootPassword() {
        return (this.rootPassword!= null);
    }

    /**
     * Gets the value of the customScript property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCustomScript() {
        return customScript;
    }

    /**
     * Sets the value of the customScript property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCustomScript(String value) {
        this.customScript = value;
    }

    public boolean isSetCustomScript() {
        return (this.customScript!= null);
    }

}

