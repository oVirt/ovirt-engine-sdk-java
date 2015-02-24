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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VmSummary complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="VmSummary">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="active" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="migrating" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="total" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VmSummary", propOrder = {
    "active",
    "migrating",
    "total"
})
public class VmSummary {

    protected Integer active;
    protected Integer migrating;
    protected Integer total;

    /**
     * Gets the value of the active property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getActive() {
        return active;
    }

    /**
     * Sets the value of the active property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setActive(Integer value) {
        this.active = value;
    }

    public boolean isSetActive() {
        return (this.active!= null);
    }

    /**
     * Gets the value of the migrating property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getMigrating() {
        return migrating;
    }

    /**
     * Sets the value of the migrating property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setMigrating(Integer value) {
        this.migrating = value;
    }

    public boolean isSetMigrating() {
        return (this.migrating!= null);
    }

    /**
     * Gets the value of the total property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getTotal() {
        return total;
    }

    /**
     * Sets the value of the total property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setTotal(Integer value) {
        this.total = value;
    }

    public boolean isSetTotal() {
        return (this.total!= null);
    }

}

