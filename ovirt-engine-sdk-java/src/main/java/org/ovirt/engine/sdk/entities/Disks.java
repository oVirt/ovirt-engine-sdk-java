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

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Disks complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Disks">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseDevices">
 *       &lt;sequence>
 *         &lt;element ref="{}disk" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="clone" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="detach_only" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Disks", propOrder = {
    "disks",
    "clone",
    "detachOnly"
})
public class Disks
    extends BaseDevices
{

    @XmlElement(name = "disk")
    protected List<Disk> disks;
    protected Boolean clone;
    @XmlElement(name = "detach_only")
    protected Boolean detachOnly;

    /**
     * Gets the value of the disks property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the disks property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDisks().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Disk }
     *
     *
     */
    public List<Disk> getDisks() {
        if (disks == null) {
            disks = new ArrayList<Disk>();
        }
        return this.disks;
    }

    public boolean isSetDisks() {
        return ((this.disks!= null)&&(!this.disks.isEmpty()));
    }

    public void unsetDisks() {
        this.disks = null;
    }

    /**
     * Gets the value of the clone property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getClone() {
        return clone;
    }

    /**
     * Sets the value of the clone property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setClone(Boolean value) {
        this.clone = value;
    }

    public boolean isSetClone() {
        return (this.clone!= null);
    }

    /**
     * Gets the value of the detachOnly property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getDetachOnly() {
        return detachOnly;
    }

    /**
     * Sets the value of the detachOnly property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setDetachOnly(Boolean value) {
        this.detachOnly = value;
    }

    public boolean isSetDetachOnly() {
        return (this.detachOnly!= null);
    }

}

