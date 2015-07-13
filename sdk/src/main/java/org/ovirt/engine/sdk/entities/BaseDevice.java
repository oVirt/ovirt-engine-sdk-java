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
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BaseDevice complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="BaseDevice">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseResource">
 *       &lt;sequence>
 *         &lt;element ref="{}template" minOccurs="0"/>
 *         &lt;element ref="{}instance_type" minOccurs="0"/>
 *         &lt;element ref="{}vms" minOccurs="0"/>
 *         &lt;element ref="{}vm" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BaseDevice", propOrder = {
    "template",
    "instanceType",
    "vms",
    "vm"
})
@XmlSeeAlso({
    NIC.class,
    CdRom.class,
    WatchDog.class,
    Floppy.class,
    Disk.class
})
public class BaseDevice
    extends BaseResource
{

    protected Template template;
    @XmlElement(name = "instance_type")
    protected InstanceType instanceType;
    protected VMs vms;
    protected VM vm;

    /**
     * Gets the value of the template property.
     *
     * @return
     *     possible object is
     *     {@link Template }
     *
     */
    public Template getTemplate() {
        return template;
    }

    /**
     * Sets the value of the template property.
     *
     * @param value
     *     allowed object is
     *     {@link Template }
     *
     */
    public void setTemplate(Template value) {
        this.template = value;
    }

    public boolean isSetTemplate() {
        return (this.template!= null);
    }

    /**
     * Gets the value of the instanceType property.
     *
     * @return
     *     possible object is
     *     {@link InstanceType }
     *
     */
    public InstanceType getInstanceType() {
        return instanceType;
    }

    /**
     * Sets the value of the instanceType property.
     *
     * @param value
     *     allowed object is
     *     {@link InstanceType }
     *
     */
    public void setInstanceType(InstanceType value) {
        this.instanceType = value;
    }

    public boolean isSetInstanceType() {
        return (this.instanceType!= null);
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

}
