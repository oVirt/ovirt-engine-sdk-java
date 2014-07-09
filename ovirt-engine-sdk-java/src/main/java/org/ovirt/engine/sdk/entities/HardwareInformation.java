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
 * <p>Java class for HardwareInformation complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="HardwareInformation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="manufacturer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="version" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="serial_number" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="product_name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="uuid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="family" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="supported_rng_sources" type="{}RngSources" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HardwareInformation", propOrder = {
    "manufacturer",
    "version",
    "serialNumber",
    "productName",
    "uuid",
    "family",
    "supportedRngSources"
})
public class HardwareInformation {

    protected String manufacturer;
    protected String version;
    @XmlElement(name = "serial_number")
    protected String serialNumber;
    @XmlElement(name = "product_name")
    protected String productName;
    protected String uuid;
    protected String family;
    @XmlElement(name = "supported_rng_sources")
    protected RngSources supportedRngSources;

    /**
     * Gets the value of the manufacturer property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * Sets the value of the manufacturer property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setManufacturer(String value) {
        this.manufacturer = value;
    }

    public boolean isSetManufacturer() {
        return (this.manufacturer!= null);
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

    /**
     * Gets the value of the serialNumber property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSerialNumber() {
        return serialNumber;
    }

    /**
     * Sets the value of the serialNumber property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSerialNumber(String value) {
        this.serialNumber = value;
    }

    public boolean isSetSerialNumber() {
        return (this.serialNumber!= null);
    }

    /**
     * Gets the value of the productName property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Sets the value of the productName property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setProductName(String value) {
        this.productName = value;
    }

    public boolean isSetProductName() {
        return (this.productName!= null);
    }

    /**
     * Gets the value of the uuid property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * Sets the value of the uuid property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setUuid(String value) {
        this.uuid = value;
    }

    public boolean isSetUuid() {
        return (this.uuid!= null);
    }

    /**
     * Gets the value of the family property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getFamily() {
        return family;
    }

    /**
     * Sets the value of the family property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setFamily(String value) {
        this.family = value;
    }

    public boolean isSetFamily() {
        return (this.family!= null);
    }

    /**
     * Gets the value of the supportedRngSources property.
     *
     * @return
     *     possible object is
     *     {@link RngSources }
     *
     */
    public RngSources getSupportedRngSources() {
        return supportedRngSources;
    }

    /**
     * Sets the value of the supportedRngSources property.
     *
     * @param value
     *     allowed object is
     *     {@link RngSources }
     *
     */
    public void setSupportedRngSources(RngSources value) {
        this.supportedRngSources = value;
    }

    public boolean isSetSupportedRngSources() {
        return (this.supportedRngSources!= null);
    }

}

