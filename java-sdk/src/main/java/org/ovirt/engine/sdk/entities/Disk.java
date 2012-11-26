
package org.ovirt.engine.sdk.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element ref="{}quota" minOccurs="0"/>
 *         &lt;element name="lun_storage" type="{}Storage" minOccurs="0"/>
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
    "quota",
    "lunStorage"
})
public class Disk
    extends BaseDevice
{

    protected String alias;
    @XmlElement(name = "image_id")
    protected String imageId;
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
    protected Quota quota;
    @XmlElement(name = "lun_storage")
    protected Storage lunStorage;

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
    public Boolean isSparse() {
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
    public Boolean isBootable() {
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
    public Boolean isShareable() {
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
    public Boolean isWipeAfterDelete() {
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
    public Boolean isPropagateErrors() {
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
     * Gets the value of the active property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isActive() {
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

}
