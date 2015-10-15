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
 * <p>Java class for CpuTune complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="CpuTune">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}vcpu_pins" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CpuTune", propOrder = {
    "vcpuPins"
})
public class CpuTune {

    @XmlElement(name = "vcpu_pins")
    protected VcpuPins vcpuPins;

    /**
     * Gets the value of the vcpuPins property.
     *
     * @return
     *     possible object is
     *     {@link VcpuPins }
     *
     */
    public VcpuPins getVcpuPins() {
        return vcpuPins;
    }

    /**
     * Sets the value of the vcpuPins property.
     *
     * @param value
     *     allowed object is
     *     {@link VcpuPins }
     *
     */
    public void setVcpuPins(VcpuPins value) {
        this.vcpuPins = value;
    }

    public boolean isSetVcpuPins() {
        return (this.vcpuPins!= null);
    }

}
