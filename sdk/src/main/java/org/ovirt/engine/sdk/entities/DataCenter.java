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
 * <p>Java class for DataCenter complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="DataCenter">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseResource">
 *       &lt;sequence>
 *         &lt;element name="local" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="storage_format" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="version" type="{}Version" minOccurs="0"/>
 *         &lt;element name="supported_versions" type="{}Versions" minOccurs="0"/>
 *         &lt;element ref="{}status" minOccurs="0"/>
 *         &lt;element ref="{}mac_pool" minOccurs="0"/>
 *         &lt;element name="quota_mode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataCenter", propOrder = {
    "local",
    "storageFormat",
    "version",
    "supportedVersions",
    "status",
    "macPool",
    "quotaMode"
})
public class DataCenter
    extends BaseResource
{

    protected Boolean local;
    @XmlElement(name = "storage_format")
    protected String storageFormat;
    protected Version version;
    @XmlElement(name = "supported_versions")
    protected Versions supportedVersions;
    protected Status status;
    @XmlElement(name = "mac_pool")
    protected MacPool macPool;
    @XmlElement(name = "quota_mode")
    protected String quotaMode;

    /**
     * Gets the value of the local property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getLocal() {
        return local;
    }

    /**
     * Sets the value of the local property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setLocal(Boolean value) {
        this.local = value;
    }

    public boolean isSetLocal() {
        return (this.local!= null);
    }

    /**
     * Gets the value of the storageFormat property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getStorageFormat() {
        return storageFormat;
    }

    /**
     * Sets the value of the storageFormat property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setStorageFormat(String value) {
        this.storageFormat = value;
    }

    public boolean isSetStorageFormat() {
        return (this.storageFormat!= null);
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
     * Gets the value of the supportedVersions property.
     *
     * @return
     *     possible object is
     *     {@link Versions }
     *
     */
    public Versions getSupportedVersions() {
        return supportedVersions;
    }

    /**
     * Sets the value of the supportedVersions property.
     *
     * @param value
     *     allowed object is
     *     {@link Versions }
     *
     */
    public void setSupportedVersions(Versions value) {
        this.supportedVersions = value;
    }

    public boolean isSetSupportedVersions() {
        return (this.supportedVersions!= null);
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
     * Gets the value of the macPool property.
     *
     * @return
     *     possible object is
     *     {@link MacPool }
     *
     */
    public MacPool getMacPool() {
        return macPool;
    }

    /**
     * Sets the value of the macPool property.
     *
     * @param value
     *     allowed object is
     *     {@link MacPool }
     *
     */
    public void setMacPool(MacPool value) {
        this.macPool = value;
    }

    public boolean isSetMacPool() {
        return (this.macPool!= null);
    }

    /**
     * Gets the value of the quotaMode property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getQuotaMode() {
        return quotaMode;
    }

    /**
     * Sets the value of the quotaMode property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setQuotaMode(String value) {
        this.quotaMode = value;
    }

    public boolean isSetQuotaMode() {
        return (this.quotaMode!= null);
    }

}
