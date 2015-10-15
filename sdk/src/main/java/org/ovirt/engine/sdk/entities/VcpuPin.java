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
 * <p>Java class for VcpuPin complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="VcpuPin">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="vcpu" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="cpu_set" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VcpuPin", propOrder = {
    "vcpu",
    "cpuSet"
})
public class VcpuPin {

    protected Integer vcpu;
    @XmlElement(name = "cpu_set")
    protected String cpuSet;

    /**
     * Gets the value of the vcpu property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getVcpu() {
        return vcpu;
    }

    /**
     * Sets the value of the vcpu property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setVcpu(Integer value) {
        this.vcpu = value;
    }

    public boolean isSetVcpu() {
        return (this.vcpu!= null);
    }

    /**
     * Gets the value of the cpuSet property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCpuSet() {
        return cpuSet;
    }

    /**
     * Sets the value of the cpuSet property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCpuSet(String value) {
        this.cpuSet = value;
    }

    public boolean isSetCpuSet() {
        return (this.cpuSet!= null);
    }

}
