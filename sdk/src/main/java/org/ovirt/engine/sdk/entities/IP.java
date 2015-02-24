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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IP complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="IP">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="address" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="netmask" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="gateway" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="version" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IP")
public class IP {

    @XmlAttribute(name = "address")
    protected String address;
    @XmlAttribute(name = "netmask")
    protected String netmask;
    @XmlAttribute(name = "gateway")
    protected String gateway;
    @XmlAttribute(name = "version")
    protected String version;

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
     * Gets the value of the netmask property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getNetmask() {
        return netmask;
    }

    /**
     * Sets the value of the netmask property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setNetmask(String value) {
        this.netmask = value;
    }

    public boolean isSetNetmask() {
        return (this.netmask!= null);
    }

    /**
     * Gets the value of the gateway property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getGateway() {
        return gateway;
    }

    /**
     * Sets the value of the gateway property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setGateway(String value) {
        this.gateway = value;
    }

    public boolean isSetGateway() {
        return (this.gateway!= null);
    }

    /**
     * Gets the value of the version property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setVersion(String value) {
        this.version = value;
    }

    public boolean isSetVersion() {
        return (this.version!= null);
    }

}

