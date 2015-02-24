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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PowerManagement complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="PowerManagement">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="enabled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="address" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="username" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="options" type="{}Options" minOccurs="0"/>
 *         &lt;element ref="{}status" minOccurs="0"/>
 *         &lt;element ref="{}pm_proxies" minOccurs="0"/>
 *         &lt;element ref="{}agents" minOccurs="0"/>
 *         &lt;element name="automatic_pm_enabled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="kdump_detection" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PowerManagement", propOrder = {
    "enabled",
    "address",
    "username",
    "password",
    "options",
    "status",
    "pmProxies",
    "agents",
    "automaticPmEnabled",
    "kdumpDetection"
})
public class PowerManagement {

    protected Boolean enabled;
    protected String address;
    protected String username;
    protected String password;
    protected Options options;
    protected Status status;
    @XmlElement(name = "pm_proxies")
    protected PmProxies pmProxies;
    protected Agents agents;
    @XmlElement(name = "automatic_pm_enabled")
    protected Boolean automaticPmEnabled;
    @XmlElement(name = "kdump_detection")
    protected Boolean kdumpDetection;
    @XmlAttribute(name = "type")
    protected String type;

    /**
     * Gets the value of the enabled property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getEnabled() {
        return enabled;
    }

    /**
     * Sets the value of the enabled property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setEnabled(Boolean value) {
        this.enabled = value;
    }

    public boolean isSetEnabled() {
        return (this.enabled!= null);
    }

    /**
     * Gets the value of the address property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAddress(String value) {
        this.address = value;
    }

    public boolean isSetAddress() {
        return (this.address!= null);
    }

    /**
     * Gets the value of the username property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the value of the username property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setUsername(String value) {
        this.username = value;
    }

    public boolean isSetUsername() {
        return (this.username!= null);
    }

    /**
     * Gets the value of the password property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setPassword(String value) {
        this.password = value;
    }

    public boolean isSetPassword() {
        return (this.password!= null);
    }

    /**
     * Gets the value of the options property.
     *
     * @return
     *     possible object is
     *     {@link Options }
     *
     */
    public Options getOptions() {
        return options;
    }

    /**
     * Sets the value of the options property.
     *
     * @param value
     *     allowed object is
     *     {@link Options }
     *
     */
    public void setOptions(Options value) {
        this.options = value;
    }

    public boolean isSetOptions() {
        return (this.options!= null);
    }

    /**
     * Gets the value of the status property.
     *
     * @return
     *     possible object is
     *     {@link Status }
     *
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     *
     * @param value
     *     allowed object is
     *     {@link Status }
     *
     */
    public void setStatus(Status value) {
        this.status = value;
    }

    public boolean isSetStatus() {
        return (this.status!= null);
    }

    /**
     * Gets the value of the pmProxies property.
     *
     * @return
     *     possible object is
     *     {@link PmProxies }
     *
     */
    public PmProxies getPmProxies() {
        return pmProxies;
    }

    /**
     * Sets the value of the pmProxies property.
     *
     * @param value
     *     allowed object is
     *     {@link PmProxies }
     *
     */
    public void setPmProxies(PmProxies value) {
        this.pmProxies = value;
    }

    public boolean isSetPmProxies() {
        return (this.pmProxies!= null);
    }

    /**
     * Gets the value of the agents property.
     *
     * @return
     *     possible object is
     *     {@link Agents }
     *
     */
    public Agents getAgents() {
        return agents;
    }

    /**
     * Sets the value of the agents property.
     *
     * @param value
     *     allowed object is
     *     {@link Agents }
     *
     */
    public void setAgents(Agents value) {
        this.agents = value;
    }

    public boolean isSetAgents() {
        return (this.agents!= null);
    }

    /**
     * Gets the value of the automaticPmEnabled property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getAutomaticPmEnabled() {
        return automaticPmEnabled;
    }

    /**
     * Sets the value of the automaticPmEnabled property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setAutomaticPmEnabled(Boolean value) {
        this.automaticPmEnabled = value;
    }

    public boolean isSetAutomaticPmEnabled() {
        return (this.automaticPmEnabled!= null);
    }

    /**
     * Gets the value of the kdumpDetection property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getKdumpDetection() {
        return kdumpDetection;
    }

    /**
     * Sets the value of the kdumpDetection property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setKdumpDetection(Boolean value) {
        this.kdumpDetection = value;
    }

    public boolean isSetKdumpDetection() {
        return (this.kdumpDetection!= null);
    }

    /**
     * Gets the value of the type property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setType(String value) {
        this.type = value;
    }

    public boolean isSetType() {
        return (this.type!= null);
    }

}

