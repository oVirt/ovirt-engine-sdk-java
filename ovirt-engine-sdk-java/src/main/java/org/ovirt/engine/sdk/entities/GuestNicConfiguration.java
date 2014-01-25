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
 * <p>Java class for GuestNicConfiguration complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="GuestNicConfiguration">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element ref="{}ip" minOccurs="0"/>
 *         &lt;element name="boot_protocol" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="on_boot" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GuestNicConfiguration", propOrder = {
    "name",
    "ip",
    "bootProtocol",
    "onBoot"
})
public class GuestNicConfiguration {

    protected String name;
    protected IP ip;
    @XmlElement(name = "boot_protocol")
    protected String bootProtocol;
    @XmlElement(name = "on_boot")
    protected Boolean onBoot;

    /**
     * Gets the value of the name property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setName(String value) {
        this.name = value;
    }

    public boolean isSetName() {
        return (this.name!= null);
    }

    /**
     * Gets the value of the ip property.
     *
     * @return
     *     possible object is
     *     {@link IP }
     *
     */
    public IP getIp() {
        return ip;
    }

    /**
     * Sets the value of the ip property.
     *
     * @param value
     *     allowed object is
     *     {@link IP }
     *
     */
    public void setIp(IP value) {
        this.ip = value;
    }

    public boolean isSetIp() {
        return (this.ip!= null);
    }

    /**
     * Gets the value of the bootProtocol property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getBootProtocol() {
        return bootProtocol;
    }

    /**
     * Sets the value of the bootProtocol property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setBootProtocol(String value) {
        this.bootProtocol = value;
    }

    public boolean isSetBootProtocol() {
        return (this.bootProtocol!= null);
    }

    /**
     * Gets the value of the onBoot property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getOnBoot() {
        return onBoot;
    }

    /**
     * Sets the value of the onBoot property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setOnBoot(Boolean value) {
        this.onBoot = value;
    }

    public boolean isSetOnBoot() {
        return (this.onBoot!= null);
    }

}

