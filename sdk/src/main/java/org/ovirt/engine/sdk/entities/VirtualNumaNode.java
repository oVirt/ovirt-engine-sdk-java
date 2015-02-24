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
 * <p>Java class for VirtualNumaNode complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="VirtualNumaNode">
 *   &lt;complexContent>
 *     &lt;extension base="{}NumaNode">
 *       &lt;sequence>
 *         &lt;element ref="{}vm" minOccurs="0"/>
 *         &lt;element name="numa_node_pins" type="{}NumaNodePins" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualNumaNode", propOrder = {
    "vm",
    "numaNodePins"
})
public class VirtualNumaNode
    extends NumaNode
{

    protected VM vm;
    @XmlElement(name = "numa_node_pins")
    protected NumaNodePins numaNodePins;

    /**
     * Gets the value of the vm property.
     *
     * @return
     *     possible object is
     *     {@link VM }
     *
     */
    public VM getVm() {
        return vm;
    }

    /**
     * Sets the value of the vm property.
     *
     * @param value
     *     allowed object is
     *     {@link VM }
     *
     */
    public void setVm(VM value) {
        this.vm = value;
    }

    public boolean isSetVm() {
        return (this.vm!= null);
    }

    /**
     * Gets the value of the numaNodePins property.
     *
     * @return
     *     possible object is
     *     {@link NumaNodePins }
     *
     */
    public NumaNodePins getNumaNodePins() {
        return numaNodePins;
    }

    /**
     * Sets the value of the numaNodePins property.
     *
     * @param value
     *     allowed object is
     *     {@link NumaNodePins }
     *
     */
    public void setNumaNodePins(NumaNodePins value) {
        this.numaNodePins = value;
    }

    public boolean isSetNumaNodePins() {
        return (this.numaNodePins!= null);
    }

}
