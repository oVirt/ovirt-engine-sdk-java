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
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Disk complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Disk">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseDevice">
 *       &lt;sequence>
 *         &lt;element name="alias" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="image_id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element ref="{}storage_domain" minOccurs="0"/>
 *         &lt;element ref="{}storage_domains" minOccurs="0"/>
 *         &lt;element name="size" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="provisioned_size" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="actual_size" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element ref="{}status" minOccurs="0"/>
 *         &lt;element name="interface" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="format" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sparse" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="bootable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="shareable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="wipe_after_delete" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="propagate_errors" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="statistics" type="{}Statistics" minOccurs="0"/>
 *         &lt;element name="active" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="read_only" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element ref="{}quota" minOccurs="0"/>
 *         &lt;element name="lun_storage" type="{}Storage" minOccurs="0"/>
 *         &lt;element name="sgio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element ref="{}snapshot" minOccurs="0"/>
 *         &lt;element ref="{}disk_profile" minOccurs="0"/>
 *         &lt;element name="logical_name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Disk", propOrder = {
    "alias",
    "imageId",
    "storageDomain",
    "storageDomains",
    "size",
    "type",
    "provisionedSize",
    "actualSize",
    "status",
    "_interface",
    "format",
    "sparse",
    "bootable",
    "shareable",
    "wipeAfterDelete",
    "propagateErrors",
    "statistics",
    "active",
    "readOnly",
    "quota",
    "lunStorage",
    "sgio",
    "snapshot",
    "diskProfile",
    "logicalName"
})
@XmlSeeAlso({
    DiskSnapshot.class
})
public class Disk
    extends BaseDevice
{

    protected String alias;
    @XmlElement(name = "image_id")
    protected String imageId;
    @XmlElement(name = "storage_domain")
    protected StorageDomain storageDomain;
    @XmlElement(name = "storage_domains")
    protected StorageDomains storageDomains;
    protected Long size;
    protected String type;
    @XmlElement(name = "provisioned_size")
    protected Long provisionedSize;
    @XmlElement(name = "actual_size")
    protected Long actualSize;
    protected Status status;
    @XmlElement(name = "interface")
    protected String _interface;
    protected String format;
    protected Boolean sparse;
    protected Boolean bootable;
    protected Boolean shareable;
    @XmlElement(name = "wipe_after_delete")
    protected Boolean wipeAfterDelete;
    @XmlElement(name = "propagate_errors")
    protected Boolean propagateErrors;
    protected Statistics statistics;
    protected Boolean active;
    @XmlElement(name = "read_only")
    protected Boolean readOnly;
    protected Quota quota;
    @XmlElement(name = "lun_storage")
    protected Storage lunStorage;
    protected String sgio;
    protected Snapshot snapshot;
    @XmlElement(name = "disk_profile")
    protected DiskProfile diskProfile;
    @XmlElement(name = "logical_name")
    protected String logicalName;

    /**
     * Gets the value of the alias property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAlias() {
        return alias;
    }

    /**
     * Sets the value of the alias property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAlias(String value) {
        this.alias = value;
    }

    public boolean isSetAlias() {
        return (this.alias!= null);
    }

    /**
     * Gets the value of the imageId property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getImageId() {
        return imageId;
    }

    /**
     * Sets the value of the imageId property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setImageId(String value) {
        this.imageId = value;
    }

    public boolean isSetImageId() {
        return (this.imageId!= null);
    }

    /**
     * Gets the value of the storageDomain property.
     *
     * @return
     *     possible object is
     *     {@link StorageDomain }
     *
     */
    public StorageDomain getStorageDomain() {
        return storageDomain;
    }

    /**
     * Sets the value of the storageDomain property.
     *
     * @param value
     *     allowed object is
     *     {@link StorageDomain }
     *
     */
    public void setStorageDomain(StorageDomain value) {
        this.storageDomain = value;
    }

    public boolean isSetStorageDomain() {
        return (this.storageDomain!= null);
    }

    /**
     * Gets the value of the storageDomains property.
     *
     * @return
     *     possible object is
     *     {@link StorageDomains }
     *
     */
    public StorageDomains getStorageDomains() {
        return storageDomains;
    }

    /**
     * Sets the value of the storageDomains property.
     *
     * @param value
     *     allowed object is
     *     {@link StorageDomains }
     *
     */
    public void setStorageDomains(StorageDomains value) {
        this.storageDomains = value;
    }

    public boolean isSetStorageDomains() {
        return (this.storageDomains!= null);
    }

    /**
     * Gets the value of the size property.
     *
     * @return
     *     possible object is
     *     {@link Long }
     *
     */
    public Long getSize() {
        return size;
    }

    /**
     * Sets the value of the size property.
     *
     * @param value
     *     allowed object is
     *     {@link Long }
     *
     */
    public void setSize(Long value) {
        this.size = value;
    }

    public boolean isSetSize() {
        return (this.size!= null);
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
     * Gets the value of the provisionedSize property.
     *
     * @return
     *     possible object is
     *     {@link Long }
     *
     */
    public Long getProvisionedSize() {
        return provisionedSize;
    }

    /**
     * Sets the value of the provisionedSize property.
     *
     * @param value
     *     allowed object is
     *     {@link Long }
     *
     */
    public void setProvisionedSize(Long value) {
        this.provisionedSize = value;
    }

    public boolean isSetProvisionedSize() {
        return (this.provisionedSize!= null);
    }

    /**
     * Gets the value of the actualSize property.
     *
     * @return
     *     possible object is
     *     {@link Long }
     *
     */
    public Long getActualSize() {
        return actualSize;
    }

    /**
     * Sets the value of the actualSize property.
     *
     * @param value
     *     allowed object is
     *     {@link Long }
     *
     */
    public void setActualSize(Long value) {
        this.actualSize = value;
    }

    public boolean isSetActualSize() {
        return (this.actualSize!= null);
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
     * Gets the value of the interface property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getInterface() {
        return _interface;
    }

    /**
     * Sets the value of the interface property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setInterface(String value) {
        this._interface = value;
    }

    public boolean isSetInterface() {
        return (this._interface!= null);
    }

    /**
     * Gets the value of the format property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getFormat() {
        return format;
    }

    /**
     * Sets the value of the format property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setFormat(String value) {
        this.format = value;
    }

    public boolean isSetFormat() {
        return (this.format!= null);
    }

    /**
     * Gets the value of the sparse property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getSparse() {
        return sparse;
    }

    /**
     * Sets the value of the sparse property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setSparse(Boolean value) {
        this.sparse = value;
    }

    public boolean isSetSparse() {
        return (this.sparse!= null);
    }

    /**
     * Gets the value of the bootable property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getBootable() {
        return bootable;
    }

    /**
     * Sets the value of the bootable property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setBootable(Boolean value) {
        this.bootable = value;
    }

    public boolean isSetBootable() {
        return (this.bootable!= null);
    }

    /**
     * Gets the value of the shareable property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getShareable() {
        return shareable;
    }

    /**
     * Sets the value of the shareable property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setShareable(Boolean value) {
        this.shareable = value;
    }

    public boolean isSetShareable() {
        return (this.shareable!= null);
    }

    /**
     * Gets the value of the wipeAfterDelete property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getWipeAfterDelete() {
        return wipeAfterDelete;
    }

    /**
     * Sets the value of the wipeAfterDelete property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setWipeAfterDelete(Boolean value) {
        this.wipeAfterDelete = value;
    }

    public boolean isSetWipeAfterDelete() {
        return (this.wipeAfterDelete!= null);
    }

    /**
     * Gets the value of the propagateErrors property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getPropagateErrors() {
        return propagateErrors;
    }

    /**
     * Sets the value of the propagateErrors property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setPropagateErrors(Boolean value) {
        this.propagateErrors = value;
    }

    public boolean isSetPropagateErrors() {
        return (this.propagateErrors!= null);
    }

    /**
     * Gets the value of the statistics property.
     *
     * @return
     *     possible object is
     *     {@link Statistics }
     *
     */
    public Object getStatistics() {
        return statistics;
    }

    /**
     * Sets the value of the statistics property.
     *
     * @param value
     *     allowed object is
     *     {@link Statistics }
     *
     */
    public void setStatistics(Statistics value) {
        this.statistics = value;
    }

    public boolean isSetStatistics() {
        return (this.statistics!= null);
    }

    /**
     * Gets the value of the active property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getActive() {
        return active;
    }

    /**
     * Sets the value of the active property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setActive(Boolean value) {
        this.active = value;
    }

    public boolean isSetActive() {
        return (this.active!= null);
    }

    /**
     * Gets the value of the readOnly property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getReadOnly() {
        return readOnly;
    }

    /**
     * Sets the value of the readOnly property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setReadOnly(Boolean value) {
        this.readOnly = value;
    }

    public boolean isSetReadOnly() {
        return (this.readOnly!= null);
    }

    /**
     * Gets the value of the quota property.
     *
     * @return
     *     possible object is
     *     {@link Quota }
     *
     */
    public Quota getQuota() {
        return quota;
    }

    /**
     * Sets the value of the quota property.
     *
     * @param value
     *     allowed object is
     *     {@link Quota }
     *
     */
    public void setQuota(Quota value) {
        this.quota = value;
    }

    public boolean isSetQuota() {
        return (this.quota!= null);
    }

    /**
     * Gets the value of the lunStorage property.
     *
     * @return
     *     possible object is
     *     {@link Storage }
     *
     */
    public Storage getLunStorage() {
        return lunStorage;
    }

    /**
     * Sets the value of the lunStorage property.
     *
     * @param value
     *     allowed object is
     *     {@link Storage }
     *
     */
    public void setLunStorage(Storage value) {
        this.lunStorage = value;
    }

    public boolean isSetLunStorage() {
        return (this.lunStorage!= null);
    }

    /**
     * Gets the value of the sgio property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSgio() {
        return sgio;
    }

    /**
     * Sets the value of the sgio property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSgio(String value) {
        this.sgio = value;
    }

    public boolean isSetSgio() {
        return (this.sgio!= null);
    }

    /**
     * Gets the value of the snapshot property.
     *
     * @return
     *     possible object is
     *     {@link Snapshot }
     *
     */
    public Snapshot getSnapshot() {
        return snapshot;
    }

    /**
     * Sets the value of the snapshot property.
     *
     * @param value
     *     allowed object is
     *     {@link Snapshot }
     *
     */
    public void setSnapshot(Snapshot value) {
        this.snapshot = value;
    }

    public boolean isSetSnapshot() {
        return (this.snapshot!= null);
    }

    /**
     * Gets the value of the diskProfile property.
     *
     * @return
     *     possible object is
     *     {@link DiskProfile }
     *
     */
    public DiskProfile getDiskProfile() {
        return diskProfile;
    }

    /**
     * Sets the value of the diskProfile property.
     *
     * @param value
     *     allowed object is
     *     {@link DiskProfile }
     *
     */
    public void setDiskProfile(DiskProfile value) {
        this.diskProfile = value;
    }

    public boolean isSetDiskProfile() {
        return (this.diskProfile!= null);
    }

    /**
     * Gets the value of the logicalName property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getLogicalName() {
        return logicalName;
    }

    /**
     * Sets the value of the logicalName property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setLogicalName(String value) {
        this.logicalName = value;
    }

    public boolean isSetLogicalName() {
        return (this.logicalName!= null);
    }

}
