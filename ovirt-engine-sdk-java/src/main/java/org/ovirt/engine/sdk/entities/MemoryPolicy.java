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
 * <p>Java class for MemoryPolicy complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="MemoryPolicy">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="guaranteed" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="ballooning" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="overcommit" type="{}MemoryOverCommit" minOccurs="0"/>
 *         &lt;element ref="{}transparent_hugepages" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MemoryPolicy", propOrder = {
    "guaranteed",
    "ballooning",
    "overCommit",
    "transparentHugepages"
})
public class MemoryPolicy {

    protected Long guaranteed;
    protected Boolean ballooning;
    @XmlElement(name = "overcommit")
    protected MemoryOverCommit overCommit;
    @XmlElement(name = "transparent_hugepages")
    protected TransparentHugePages transparentHugepages;

    /**
     * Gets the value of the guaranteed property.
     *
     * @return
     *     possible object is
     *     {@link Long }
     *
     */
    public Long getGuaranteed() {
        return guaranteed;
    }

    /**
     * Sets the value of the guaranteed property.
     *
     * @param value
     *     allowed object is
     *     {@link Long }
     *
     */
    public void setGuaranteed(Long value) {
        this.guaranteed = value;
    }

    public boolean isSetGuaranteed() {
        return (this.guaranteed!= null);
    }

    /**
     * Gets the value of the ballooning property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getBallooning() {
        return ballooning;
    }

    /**
     * Sets the value of the ballooning property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setBallooning(Boolean value) {
        this.ballooning = value;
    }

    public boolean isSetBallooning() {
        return (this.ballooning!= null);
    }

    /**
     * Gets the value of the overCommit property.
     *
     * @return
     *     possible object is
     *     {@link MemoryOverCommit }
     *
     */
    public MemoryOverCommit getOverCommit() {
        return overCommit;
    }

    /**
     * Sets the value of the overCommit property.
     *
     * @param value
     *     allowed object is
     *     {@link MemoryOverCommit }
     *
     */
    public void setOverCommit(MemoryOverCommit value) {
        this.overCommit = value;
    }

    public boolean isSetOverCommit() {
        return (this.overCommit!= null);
    }

    /**
     * Gets the value of the transparentHugepages property.
     *
     * @return
     *     possible object is
     *     {@link TransparentHugePages }
     *
     */
    public TransparentHugePages getTransparentHugepages() {
        return transparentHugepages;
    }

    /**
     * Sets the value of the transparentHugepages property.
     *
     * @param value
     *     allowed object is
     *     {@link TransparentHugePages }
     *
     */
    public void setTransparentHugepages(TransparentHugePages value) {
        this.transparentHugepages = value;
    }

    public boolean isSetTransparentHugepages() {
        return (this.transparentHugepages!= null);
    }

}

