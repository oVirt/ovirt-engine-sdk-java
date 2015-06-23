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
 * <p>Java class for Quota complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Quota">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseResource">
 *       &lt;sequence>
 *         &lt;element ref="{}data_center" minOccurs="0"/>
 *         &lt;element ref="{}vms" minOccurs="0"/>
 *         &lt;element ref="{}disks" minOccurs="0"/>
 *         &lt;element ref="{}users" minOccurs="0"/>
 *         &lt;element name="cluster_soft_limit_pct" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="cluster_hard_limit_pct" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="storage_soft_limit_pct" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="storage_hard_limit_pct" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Quota", propOrder = {
    "dataCenter",
    "vms",
    "disks",
    "users",
    "clusterSoftLimitPct",
    "clusterHardLimitPct",
    "storageSoftLimitPct",
    "storageHardLimitPct"
})
public class Quota
    extends BaseResource
{

    @XmlElement(name = "data_center")
    protected DataCenter dataCenter;
    protected VMs vms;
    protected Disks disks;
    protected Users users;
    @XmlElement(name = "cluster_soft_limit_pct")
    protected Integer clusterSoftLimitPct;
    @XmlElement(name = "cluster_hard_limit_pct")
    protected Integer clusterHardLimitPct;
    @XmlElement(name = "storage_soft_limit_pct")
    protected Integer storageSoftLimitPct;
    @XmlElement(name = "storage_hard_limit_pct")
    protected Integer storageHardLimitPct;

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
     * Gets the value of the vms property.
     *
     * @return
     *     possible object is
     *     {@link VMs }
     *
     */
    public VMs getVms() {
        return vms;
    }

    /**
     * Sets the value of the vms property.
     *
     * @param value
     *     allowed object is
     *     {@link VMs }
     *
     */
    public void setVms(VMs value) {
        this.vms = value;
    }

    public boolean isSetVms() {
        return (this.vms!= null);
    }

    /**
     * Gets the value of the disks property.
     *
     * @return
     *     possible object is
     *     {@link Disks }
     *
     */
    public Disks getDisks() {
        return disks;
    }

    /**
     * Sets the value of the disks property.
     *
     * @param value
     *     allowed object is
     *     {@link Disks }
     *
     */
    public void setDisks(Disks value) {
        this.disks = value;
    }

    public boolean isSetDisks() {
        return (this.disks!= null);
    }

    /**
     * Gets the value of the users property.
     *
     * @return
     *     possible object is
     *     {@link Users }
     *
     */
    public Users getUsers() {
        return users;
    }

    /**
     * Sets the value of the users property.
     *
     * @param value
     *     allowed object is
     *     {@link Users }
     *
     */
    public void setUsers(Users value) {
        this.users = value;
    }

    public boolean isSetUsers() {
        return (this.users!= null);
    }

    /**
     * Gets the value of the clusterSoftLimitPct property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getClusterSoftLimitPct() {
        return clusterSoftLimitPct;
    }

    /**
     * Sets the value of the clusterSoftLimitPct property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setClusterSoftLimitPct(Integer value) {
        this.clusterSoftLimitPct = value;
    }

    public boolean isSetClusterSoftLimitPct() {
        return (this.clusterSoftLimitPct!= null);
    }

    /**
     * Gets the value of the clusterHardLimitPct property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getClusterHardLimitPct() {
        return clusterHardLimitPct;
    }

    /**
     * Sets the value of the clusterHardLimitPct property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setClusterHardLimitPct(Integer value) {
        this.clusterHardLimitPct = value;
    }

    public boolean isSetClusterHardLimitPct() {
        return (this.clusterHardLimitPct!= null);
    }

    /**
     * Gets the value of the storageSoftLimitPct property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getStorageSoftLimitPct() {
        return storageSoftLimitPct;
    }

    /**
     * Sets the value of the storageSoftLimitPct property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setStorageSoftLimitPct(Integer value) {
        this.storageSoftLimitPct = value;
    }

    public boolean isSetStorageSoftLimitPct() {
        return (this.storageSoftLimitPct!= null);
    }

    /**
     * Gets the value of the storageHardLimitPct property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getStorageHardLimitPct() {
        return storageHardLimitPct;
    }

    /**
     * Sets the value of the storageHardLimitPct property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setStorageHardLimitPct(Integer value) {
        this.storageHardLimitPct = value;
    }

    public boolean isSetStorageHardLimitPct() {
        return (this.storageHardLimitPct!= null);
    }

}
