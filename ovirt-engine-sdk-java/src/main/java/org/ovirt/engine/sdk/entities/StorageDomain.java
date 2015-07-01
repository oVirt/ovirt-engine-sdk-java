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
 * <p>Java class for StorageDomain complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="StorageDomain">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseResource">
 *       &lt;sequence>
 *         &lt;element ref="{}data_center" minOccurs="0"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element ref="{}status" minOccurs="0"/>
 *         &lt;element name="master" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element ref="{}storage" minOccurs="0"/>
 *         &lt;element ref="{}host" minOccurs="0"/>
 *         &lt;element name="format" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="destroy" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="available" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="used" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="committed" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="storage_format" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="import" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StorageDomain", propOrder = {
    "dataCenter",
    "type",
    "status",
    "master",
    "storage",
    "host",
    "format",
    "destroy",
    "available",
    "used",
    "committed",
    "storageFormat",
    "_import"
})
public class StorageDomain
    extends BaseResource
{

    @XmlElement(name = "data_center")
    protected DataCenter dataCenter;
    protected String type;
    protected Status status;
    protected Boolean master;
    protected Storage storage;
    protected Host host;
    protected Boolean format;
    protected Boolean destroy;
    protected Long available;
    protected Long used;
    protected Long committed;
    @XmlElement(name = "storage_format")
    protected String storageFormat;
    @XmlElement(name = "import")
    protected Boolean _import;

    /**
     * Gets the value of the dataCenter property.
     *
     * @return
     *     possible object is
     *     {@link DataCenter }
     *
     */
    public DataCenter getDataCenter() {
        return dataCenter;
    }

    /**
     * Sets the value of the dataCenter property.
     *
     * @param value
     *     allowed object is
     *     {@link DataCenter }
     *
     */
    public void setDataCenter(DataCenter value) {
        this.dataCenter = value;
    }

    public boolean isSetDataCenter() {
        return (this.dataCenter!= null);
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
     * Gets the value of the master property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getMaster() {
        return master;
    }

    /**
     * Sets the value of the master property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setMaster(Boolean value) {
        this.master = value;
    }

    public boolean isSetMaster() {
        return (this.master!= null);
    }

    /**
     * Gets the value of the storage property.
     *
     * @return
     *     possible object is
     *     {@link Storage }
     *
     */
    public Storage getStorage() {
        return storage;
    }

    /**
     * Sets the value of the storage property.
     *
     * @param value
     *     allowed object is
     *     {@link Storage }
     *
     */
    public void setStorage(Storage value) {
        this.storage = value;
    }

    public boolean isSetStorage() {
        return (this.storage!= null);
    }

    /**
     * Gets the value of the host property.
     *
     * @return
     *     possible object is
     *     {@link Host }
     *
     */
    public Host getHost() {
        return host;
    }

    /**
     * Sets the value of the host property.
     *
     * @param value
     *     allowed object is
     *     {@link Host }
     *
     */
    public void setHost(Host value) {
        this.host = value;
    }

    public boolean isSetHost() {
        return (this.host!= null);
    }

    /**
     * Gets the value of the format property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getFormat() {
        return format;
    }

    /**
     * Sets the value of the format property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setFormat(Boolean value) {
        this.format = value;
    }

    public boolean isSetFormat() {
        return (this.format!= null);
    }

    /**
     * Gets the value of the destroy property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getDestroy() {
        return destroy;
    }

    /**
     * Sets the value of the destroy property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setDestroy(Boolean value) {
        this.destroy = value;
    }

    public boolean isSetDestroy() {
        return (this.destroy!= null);
    }

    /**
     * Gets the value of the available property.
     *
     * @return
     *     possible object is
     *     {@link Long }
     *
     */
    public Long getAvailable() {
        return available;
    }

    /**
     * Sets the value of the available property.
     *
     * @param value
     *     allowed object is
     *     {@link Long }
     *
     */
    public void setAvailable(Long value) {
        this.available = value;
    }

    public boolean isSetAvailable() {
        return (this.available!= null);
    }

    /**
     * Gets the value of the used property.
     *
     * @return
     *     possible object is
     *     {@link Long }
     *
     */
    public Long getUsed() {
        return used;
    }

    /**
     * Sets the value of the used property.
     *
     * @param value
     *     allowed object is
     *     {@link Long }
     *
     */
    public void setUsed(Long value) {
        this.used = value;
    }

    public boolean isSetUsed() {
        return (this.used!= null);
    }

    /**
     * Gets the value of the committed property.
     *
     * @return
     *     possible object is
     *     {@link Long }
     *
     */
    public Long getCommitted() {
        return committed;
    }

    /**
     * Sets the value of the committed property.
     *
     * @param value
     *     allowed object is
     *     {@link Long }
     *
     */
    public void setCommitted(Long value) {
        this.committed = value;
    }

    public boolean isSetCommitted() {
        return (this.committed!= null);
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
     * Gets the value of the import property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getImport() {
        return _import;
    }

    /**
     * Sets the value of the import property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setImport(Boolean value) {
        this._import = value;
    }

    public boolean isSetImport() {
        return (this._import!= null);
    }

}
