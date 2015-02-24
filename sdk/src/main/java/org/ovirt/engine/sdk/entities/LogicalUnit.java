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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LogicalUnit complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="LogicalUnit">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{}IscsiTarget"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LogicalUnit", propOrder = {
    "port",
    "target",
    "username",
    "password",
    "portal",
    "address",
    "serial",
    "vendorId",
    "productId",
    "lunMapping",
    "size",
    "paths",
    "status",
    "volumeGroupId",
    "storageDomainId",
    "diskId"
})
public class LogicalUnit {

    @XmlSchemaType(name = "unsignedShort")
    protected Integer port;
    protected String target;
    protected String username;
    protected String password;
    protected String portal;
    protected String address;
    protected String serial;
    @XmlElement(name = "vendor_id")
    protected String vendorId;
    @XmlElement(name = "product_id")
    protected String productId;
    @XmlElement(name = "lun_mapping")
    protected Integer lunMapping;
    protected Long size;
    protected Integer paths;
    protected String status;
    @XmlElement(name = "volume_group_id")
    protected String volumeGroupId;
    @XmlElement(name = "storage_domain_id")
    protected String storageDomainId;
    @XmlElement(name = "disk_id")
    protected String diskId;
    @XmlAttribute(name = "id")
    protected String id;

    /**
     * Gets the value of the port property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getPort() {
        return port;
    }

    /**
     * Sets the value of the port property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setPort(Integer value) {
        this.port = value;
    }

    public boolean isSetPort() {
        return (this.port!= null);
    }

    /**
     * Gets the value of the target property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getTarget() {
        return target;
    }

    /**
     * Sets the value of the target property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTarget(String value) {
        this.target = value;
    }

    public boolean isSetTarget() {
        return (this.target!= null);
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
     * Gets the value of the portal property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getPortal() {
        return portal;
    }

    /**
     * Sets the value of the portal property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setPortal(String value) {
        this.portal = value;
    }

    public boolean isSetPortal() {
        return (this.portal!= null);
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
     * Gets the value of the serial property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSerial() {
        return serial;
    }

    /**
     * Sets the value of the serial property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSerial(String value) {
        this.serial = value;
    }

    public boolean isSetSerial() {
        return (this.serial!= null);
    }

    /**
     * Gets the value of the vendorId property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getVendorId() {
        return vendorId;
    }

    /**
     * Sets the value of the vendorId property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setVendorId(String value) {
        this.vendorId = value;
    }

    public boolean isSetVendorId() {
        return (this.vendorId!= null);
    }

    /**
     * Gets the value of the productId property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getProductId() {
        return productId;
    }

    /**
     * Sets the value of the productId property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setProductId(String value) {
        this.productId = value;
    }

    public boolean isSetProductId() {
        return (this.productId!= null);
    }

    /**
     * Gets the value of the lunMapping property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getLunMapping() {
        return lunMapping;
    }

    /**
     * Sets the value of the lunMapping property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setLunMapping(Integer value) {
        this.lunMapping = value;
    }

    public boolean isSetLunMapping() {
        return (this.lunMapping!= null);
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
     * Gets the value of the paths property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getPaths() {
        return paths;
    }

    /**
     * Sets the value of the paths property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setPaths(Integer value) {
        this.paths = value;
    }

    public boolean isSetPaths() {
        return (this.paths!= null);
    }

    /**
     * Gets the value of the status property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setStatus(String value) {
        this.status = value;
    }

    public boolean isSetStatus() {
        return (this.status!= null);
    }

    /**
     * Gets the value of the volumeGroupId property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getVolumeGroupId() {
        return volumeGroupId;
    }

    /**
     * Sets the value of the volumeGroupId property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setVolumeGroupId(String value) {
        this.volumeGroupId = value;
    }

    public boolean isSetVolumeGroupId() {
        return (this.volumeGroupId!= null);
    }

    /**
     * Gets the value of the storageDomainId property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getStorageDomainId() {
        return storageDomainId;
    }

    /**
     * Sets the value of the storageDomainId property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setStorageDomainId(String value) {
        this.storageDomainId = value;
    }

    public boolean isSetStorageDomainId() {
        return (this.storageDomainId!= null);
    }

    /**
     * Gets the value of the diskId property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDiskId() {
        return diskId;
    }

    /**
     * Sets the value of the diskId property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDiskId(String value) {
        this.diskId = value;
    }

    public boolean isSetDiskId() {
        return (this.diskId!= null);
    }

    /**
     * Gets the value of the id property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setId(String value) {
        this.id = value;
    }

    public boolean isSetId() {
        return (this.id!= null);
    }

}

