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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NumaNodePin complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="NumaNodePin">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}host_numa_node" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="pinned" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="index" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NumaNodePin", propOrder = {
    "hostNumaNode"
})
public class NumaNodePin {

    @XmlElement(name = "host_numa_node")
    protected NumaNode hostNumaNode;
    @XmlAttribute(name = "pinned")
    protected Boolean pinned;
    @XmlAttribute(name = "index", required = true)
    protected int index;

    /**
     * Gets the value of the hostNumaNode property.
     *
     * @return
     *     possible object is
     *     {@link NumaNode }
     *
     */
    public NumaNode getHostNumaNode() {
        return hostNumaNode;
    }

    /**
     * Sets the value of the hostNumaNode property.
     *
     * @param value
     *     allowed object is
     *     {@link NumaNode }
     *
     */
    public void setHostNumaNode(NumaNode value) {
        this.hostNumaNode = value;
    }

    public boolean isSetHostNumaNode() {
        return (this.hostNumaNode!= null);
    }

    /**
     * Gets the value of the pinned property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getPinned() {
        return pinned;
    }

    /**
     * Sets the value of the pinned property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setPinned(Boolean value) {
        this.pinned = value;
    }

    /**
     * Gets the value of the index property.
     *
     */
    public int getIndex() {
        return index;
    }

    /**
     * Sets the value of the index property.
     *
     */
    public void setIndex(int value) {
        this.index = value;
    }

    public boolean isSetIndex() {
        return true;
    }

}

