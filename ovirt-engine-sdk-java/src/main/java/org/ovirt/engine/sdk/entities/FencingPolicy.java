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
 * <p>Java class for FencingPolicy complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="FencingPolicy">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="enabled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element ref="{}skip_if_sd_active" minOccurs="0"/>
 *         &lt;element ref="{}skip_if_connectivity_broken" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FencingPolicy", propOrder = {
    "enabled",
    "skipIfSdActive",
    "skipIfConnectivityBroken"
})
public class FencingPolicy {

    protected Boolean enabled;
    @XmlElement(name = "skip_if_sd_active")
    protected SkipIfSDActive skipIfSdActive;
    @XmlElement(name = "skip_if_connectivity_broken")
    protected SkipIfConnectivityBroken skipIfConnectivityBroken;

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
     * Gets the value of the skipIfSdActive property.
     *
     * @return
     *     possible object is
     *     {@link SkipIfSDActive }
     *
     */
    public SkipIfSDActive getSkipIfSdActive() {
        return skipIfSdActive;
    }

    /**
     * Sets the value of the skipIfSdActive property.
     *
     * @param value
     *     allowed object is
     *     {@link SkipIfSDActive }
     *
     */
    public void setSkipIfSdActive(SkipIfSDActive value) {
        this.skipIfSdActive = value;
    }

    public boolean isSetSkipIfSdActive() {
        return (this.skipIfSdActive!= null);
    }

    /**
     * Gets the value of the skipIfConnectivityBroken property.
     *
     * @return
     *     possible object is
     *     {@link SkipIfConnectivityBroken }
     *
     */
    public SkipIfConnectivityBroken getSkipIfConnectivityBroken() {
        return skipIfConnectivityBroken;
    }

    /**
     * Sets the value of the skipIfConnectivityBroken property.
     *
     * @param value
     *     allowed object is
     *     {@link SkipIfConnectivityBroken }
     *
     */
    public void setSkipIfConnectivityBroken(SkipIfConnectivityBroken value) {
        this.skipIfConnectivityBroken = value;
    }

    public boolean isSetSkipIfConnectivityBroken() {
        return (this.skipIfConnectivityBroken!= null);
    }

}

