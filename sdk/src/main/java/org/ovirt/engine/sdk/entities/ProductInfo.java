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
 * <p>Java class for ProductInfo complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ProductInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseResource">
 *       &lt;sequence>
 *         &lt;element name="vendor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="version" type="{}Version" minOccurs="0"/>
 *         &lt;element name="full_version" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProductInfo", propOrder = {
    "vendor",
    "version",
    "fullVersion"
})
public class ProductInfo
    extends BaseResource
{

    protected String vendor;
    protected Version version;
    @XmlElement(name = "full_version")
    protected String fullVersion;

    /**
     * Gets the value of the vendor property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getVendor() {
        return vendor;
    }

    /**
     * Sets the value of the vendor property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setVendor(String value) {
        this.vendor = value;
    }

    public boolean isSetVendor() {
        return (this.vendor!= null);
    }

    /**
     * Gets the value of the version property.
     *
     * @return
     *     possible object is
     *     {@link Version }
     *
     */
    public Version getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     *
     * @param value
     *     allowed object is
     *     {@link Version }
     *
     */
    public void setVersion(Version value) {
        this.version = value;
    }

    public boolean isSetVersion() {
        return (this.version!= null);
    }

    /**
     * Gets the value of the fullVersion property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getFullVersion() {
        return fullVersion;
    }

    /**
     * Sets the value of the fullVersion property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setFullVersion(String value) {
        this.fullVersion = value;
    }

    public boolean isSetFullVersion() {
        return (this.fullVersion!= null);
    }

}

