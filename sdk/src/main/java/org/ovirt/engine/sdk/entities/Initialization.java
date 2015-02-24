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
 *         &lt;element name="regenerate_ids" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="dns_servers" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dns_search" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element ref="{}nic_configurations" minOccurs="0"/>
 *         &lt;element name="windows_license_key" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="root_password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="custom_script" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="input_locale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ui_language" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="system_locale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="user_locale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="user_name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="active_directory_ou" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="org_name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "regenerateIds",
    "dnsServers",
    "dnsSearch",
    "nicConfigurations",
    "windowsLicenseKey",
    "rootPassword",
    "customScript",
    "inputLocale",
    "uiLanguage",
    "systemLocale",
    "userLocale",
    "userName",
    "activeDirectoryOu",
    "orgName"
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
    @XmlElement(name = "regenerate_ids")
    protected Boolean regenerateIds;
    @XmlElement(name = "dns_servers")
    protected String dnsServers;
    @XmlElement(name = "dns_search")
    protected String dnsSearch;
    @XmlElement(name = "nic_configurations")
    protected GuestNicsConfiguration nicConfigurations;
    @XmlElement(name = "windows_license_key")
    protected String windowsLicenseKey;
    @XmlElement(name = "root_password")
    protected String rootPassword;
    @XmlElement(name = "custom_script")
    protected String customScript;
    @XmlElement(name = "input_locale")
    protected String inputLocale;
    @XmlElement(name = "ui_language")
    protected String uiLanguage;
    @XmlElement(name = "system_locale")
    protected String systemLocale;
    @XmlElement(name = "user_locale")
    protected String userLocale;
    @XmlElement(name = "user_name")
    protected String userName;
    @XmlElement(name = "active_directory_ou")
    protected String activeDirectoryOu;
    @XmlElement(name = "org_name")
    protected String orgName;

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
     * Gets the value of the regenerateIds property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getRegenerateIds() {
        return regenerateIds;
    }

    /**
     * Sets the value of the regenerateIds property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setRegenerateIds(Boolean value) {
        this.regenerateIds = value;
    }

    public boolean isSetRegenerateIds() {
        return (this.regenerateIds!= null);
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
     * Gets the value of the nicConfigurations property.
     *
     * @return
     *     possible object is
     *     {@link GuestNicsConfiguration }
     *
     */
    public GuestNicsConfiguration getNicConfigurations() {
        return nicConfigurations;
    }

    /**
     * Sets the value of the nicConfigurations property.
     *
     * @param value
     *     allowed object is
     *     {@link GuestNicsConfiguration }
     *
     */
    public void setNicConfigurations(GuestNicsConfiguration value) {
        this.nicConfigurations = value;
    }

    public boolean isSetNicConfigurations() {
        return (this.nicConfigurations!= null);
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

    /**
     * Gets the value of the inputLocale property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getInputLocale() {
        return inputLocale;
    }

    /**
     * Sets the value of the inputLocale property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setInputLocale(String value) {
        this.inputLocale = value;
    }

    public boolean isSetInputLocale() {
        return (this.inputLocale!= null);
    }

    /**
     * Gets the value of the uiLanguage property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getUiLanguage() {
        return uiLanguage;
    }

    /**
     * Sets the value of the uiLanguage property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setUiLanguage(String value) {
        this.uiLanguage = value;
    }

    public boolean isSetUiLanguage() {
        return (this.uiLanguage!= null);
    }

    /**
     * Gets the value of the systemLocale property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSystemLocale() {
        return systemLocale;
    }

    /**
     * Sets the value of the systemLocale property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSystemLocale(String value) {
        this.systemLocale = value;
    }

    public boolean isSetSystemLocale() {
        return (this.systemLocale!= null);
    }

    /**
     * Gets the value of the userLocale property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getUserLocale() {
        return userLocale;
    }

    /**
     * Sets the value of the userLocale property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setUserLocale(String value) {
        this.userLocale = value;
    }

    public boolean isSetUserLocale() {
        return (this.userLocale!= null);
    }

    /**
     * Gets the value of the userName property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the value of the userName property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setUserName(String value) {
        this.userName = value;
    }

    public boolean isSetUserName() {
        return (this.userName!= null);
    }

    /**
     * Gets the value of the activeDirectoryOu property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getActiveDirectoryOu() {
        return activeDirectoryOu;
    }

    /**
     * Sets the value of the activeDirectoryOu property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setActiveDirectoryOu(String value) {
        this.activeDirectoryOu = value;
    }

    public boolean isSetActiveDirectoryOu() {
        return (this.activeDirectoryOu!= null);
    }

    /**
     * Gets the value of the orgName property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getOrgName() {
        return orgName;
    }

    /**
     * Sets the value of the orgName property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setOrgName(String value) {
        this.orgName = value;
    }

    public boolean isSetOrgName() {
        return (this.orgName!= null);
    }

}

