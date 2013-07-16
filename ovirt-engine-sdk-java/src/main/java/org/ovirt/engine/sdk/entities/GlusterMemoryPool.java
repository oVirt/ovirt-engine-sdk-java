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
 * <p>Java class for GlusterMemoryPool complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="GlusterMemoryPool">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hot_count" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="cold_count" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="padded_size" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="alloc_count" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="max_alloc" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="pool_misses" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="max_stdalloc" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GlusterMemoryPool", propOrder = {
    "name",
    "hotCount",
    "coldCount",
    "paddedSize",
    "allocCount",
    "maxAlloc",
    "poolMisses",
    "maxStdalloc"
})
public class GlusterMemoryPool {

    protected String name;
    @XmlElement(name = "hot_count")
    protected Integer hotCount;
    @XmlElement(name = "cold_count")
    protected Integer coldCount;
    @XmlElement(name = "padded_size")
    protected Integer paddedSize;
    @XmlElement(name = "alloc_count")
    protected Integer allocCount;
    @XmlElement(name = "max_alloc")
    protected Integer maxAlloc;
    @XmlElement(name = "pool_misses")
    protected Integer poolMisses;
    @XmlElement(name = "max_stdalloc")
    protected Integer maxStdalloc;

    /**
     * Gets the value of the name property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setName(String value) {
        this.name = value;
    }

    public boolean isSetName() {
        return (this.name!= null);
    }

    /**
     * Gets the value of the hotCount property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getHotCount() {
        return hotCount;
    }

    /**
     * Sets the value of the hotCount property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setHotCount(Integer value) {
        this.hotCount = value;
    }

    public boolean isSetHotCount() {
        return (this.hotCount!= null);
    }

    /**
     * Gets the value of the coldCount property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getColdCount() {
        return coldCount;
    }

    /**
     * Sets the value of the coldCount property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setColdCount(Integer value) {
        this.coldCount = value;
    }

    public boolean isSetColdCount() {
        return (this.coldCount!= null);
    }

    /**
     * Gets the value of the paddedSize property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getPaddedSize() {
        return paddedSize;
    }

    /**
     * Sets the value of the paddedSize property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setPaddedSize(Integer value) {
        this.paddedSize = value;
    }

    public boolean isSetPaddedSize() {
        return (this.paddedSize!= null);
    }

    /**
     * Gets the value of the allocCount property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getAllocCount() {
        return allocCount;
    }

    /**
     * Sets the value of the allocCount property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setAllocCount(Integer value) {
        this.allocCount = value;
    }

    public boolean isSetAllocCount() {
        return (this.allocCount!= null);
    }

    /**
     * Gets the value of the maxAlloc property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getMaxAlloc() {
        return maxAlloc;
    }

    /**
     * Sets the value of the maxAlloc property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setMaxAlloc(Integer value) {
        this.maxAlloc = value;
    }

    public boolean isSetMaxAlloc() {
        return (this.maxAlloc!= null);
    }

    /**
     * Gets the value of the poolMisses property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getPoolMisses() {
        return poolMisses;
    }

    /**
     * Sets the value of the poolMisses property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setPoolMisses(Integer value) {
        this.poolMisses = value;
    }

    public boolean isSetPoolMisses() {
        return (this.poolMisses!= null);
    }

    /**
     * Gets the value of the maxStdalloc property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getMaxStdalloc() {
        return maxStdalloc;
    }

    /**
     * Sets the value of the maxStdalloc property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setMaxStdalloc(Integer value) {
        this.maxStdalloc = value;
    }

    public boolean isSetMaxStdalloc() {
        return (this.maxStdalloc!= null);
    }

}

