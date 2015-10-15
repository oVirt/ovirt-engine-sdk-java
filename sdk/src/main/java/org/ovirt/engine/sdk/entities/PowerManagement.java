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
 *         &lt;element ref="{}status" minOccurs="0"/>
 *         &lt;element ref="{}pm_proxies" minOccurs="0"/>
 *         &lt;element name="automatic_pm_enabled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="kdump_detection" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
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
    "status",
    "pmProxies",
    "automaticPmEnabled",
    "kdumpDetection"
})
public class PowerManagement {

    protected Boolean enabled;
    protected Status status;
    @XmlElement(name = "pm_proxies")
    protected PmProxies pmProxies;
    @XmlElement(name = "automatic_pm_enabled")
    protected Boolean automaticPmEnabled;
    @XmlElement(name = "kdump_detection")
    protected Boolean kdumpDetection;

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

}
