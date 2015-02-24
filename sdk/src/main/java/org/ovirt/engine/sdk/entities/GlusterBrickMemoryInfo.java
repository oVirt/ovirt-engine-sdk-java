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
 * <p>Java class for GlusterBrickMemoryInfo complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="GlusterBrickMemoryInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}memory_pools" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GlusterBrickMemoryInfo", propOrder = {
    "memoryPools"
})
public class GlusterBrickMemoryInfo {

    @XmlElement(name = "memory_pools")
    protected GlusterMemoryPools memoryPools;

    /**
     * Gets the value of the memoryPools property.
     *
     * @return
     *     possible object is
     *     {@link GlusterMemoryPools }
     *
     */
    public GlusterMemoryPools getMemoryPools() {
        return memoryPools;
    }

    /**
     * Sets the value of the memoryPools property.
     *
     * @param value
     *     allowed object is
     *     {@link GlusterMemoryPools }
     *
     */
    public void setMemoryPools(GlusterMemoryPools value) {
        this.memoryPools = value;
    }

    public boolean isSetMemoryPools() {
        return (this.memoryPools!= null);
    }

}

