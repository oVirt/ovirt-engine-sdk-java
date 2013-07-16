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
    "users"
})
public class Quota
    extends BaseResource
{

    @XmlElement(name = "data_center")
    protected DataCenter dataCenter;
    protected VMs vms;
    protected Disks disks;
    protected Users users;

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

}
