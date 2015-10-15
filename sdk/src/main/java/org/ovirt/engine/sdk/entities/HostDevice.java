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
 * <p>Java class for HostDevice complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="HostDevice">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseResource">
 *       &lt;sequence>
 *         &lt;element ref="{}host" minOccurs="0"/>
 *         &lt;element name="parent_device" type="{}HostDevice" minOccurs="0"/>
 *         &lt;element name="capability" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element ref="{}product" minOccurs="0"/>
 *         &lt;element ref="{}vendor" minOccurs="0"/>
 *         &lt;element name="iommu_group" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="physical_function" type="{}HostDevice" minOccurs="0"/>
 *         &lt;element name="virtual_functions" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="placeholder" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
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
@XmlType(name = "HostDevice", propOrder = {
    "host",
    "parentDevice",
    "capability",
    "product",
    "vendor",
    "iommuGroup",
    "physicalFunction",
    "virtualFunctions",
    "placeholder",
    "vm"
})
public class HostDevice
    extends BaseResource
{

    protected Host host;
    @XmlElement(name = "parent_device")
    protected HostDevice parentDevice;
    protected String capability;
    protected Product product;
    protected Vendor vendor;
    @XmlElement(name = "iommu_group")
    protected Integer iommuGroup;
    @XmlElement(name = "physical_function")
    protected HostDevice physicalFunction;
    @XmlElement(name = "virtual_functions")
    protected Integer virtualFunctions;
    protected Boolean placeholder;
    protected Vm vm;

    /**
     * Gets the value of the host property.
     *
     * @return
     *     possible object is
     *     {@link Host }
     *
     */
    public Host getHost() {
        return host;
    }

    /**
     * Sets the value of the host property.
     *
     * @param value
     *     allowed object is
     *     {@link Host }
     *
     */
    public void setHost(Host value) {
        this.host = value;
    }

    public boolean isSetHost() {
        return (this.host!= null);
    }

    /**
     * Gets the value of the parentDevice property.
     *
     * @return
     *     possible object is
     *     {@link HostDevice }
     *
     */
    public HostDevice getParentDevice() {
        return parentDevice;
    }

    /**
     * Sets the value of the parentDevice property.
     *
     * @param value
     *     allowed object is
     *     {@link HostDevice }
     *
     */
    public void setParentDevice(HostDevice value) {
        this.parentDevice = value;
    }

    public boolean isSetParentDevice() {
        return (this.parentDevice!= null);
    }

    /**
     * Gets the value of the capability property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCapability() {
        return capability;
    }

    /**
     * Sets the value of the capability property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCapability(String value) {
        this.capability = value;
    }

    public boolean isSetCapability() {
        return (this.capability!= null);
    }

    /**
     * Gets the value of the product property.
     *
     * @return
     *     possible object is
     *     {@link Product }
     *
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Sets the value of the product property.
     *
     * @param value
     *     allowed object is
     *     {@link Product }
     *
     */
    public void setProduct(Product value) {
        this.product = value;
    }

    public boolean isSetProduct() {
        return (this.product!= null);
    }

    /**
     * Gets the value of the vendor property.
     *
     * @return
     *     possible object is
     *     {@link Vendor }
     *
     */
    public Vendor getVendor() {
        return vendor;
    }

    /**
     * Sets the value of the vendor property.
     *
     * @param value
     *     allowed object is
     *     {@link Vendor }
     *
     */
    public void setVendor(Vendor value) {
        this.vendor = value;
    }

    public boolean isSetVendor() {
        return (this.vendor!= null);
    }

    /**
     * Gets the value of the iommuGroup property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getIommuGroup() {
        return iommuGroup;
    }

    /**
     * Sets the value of the iommuGroup property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setIommuGroup(Integer value) {
        this.iommuGroup = value;
    }

    public boolean isSetIommuGroup() {
        return (this.iommuGroup!= null);
    }

    /**
     * Gets the value of the physicalFunction property.
     *
     * @return
     *     possible object is
     *     {@link HostDevice }
     *
     */
    public HostDevice getPhysicalFunction() {
        return physicalFunction;
    }

    /**
     * Sets the value of the physicalFunction property.
     *
     * @param value
     *     allowed object is
     *     {@link HostDevice }
     *
     */
    public void setPhysicalFunction(HostDevice value) {
        this.physicalFunction = value;
    }

    public boolean isSetPhysicalFunction() {
        return (this.physicalFunction!= null);
    }

    /**
     * Gets the value of the virtualFunctions property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getVirtualFunctions() {
        return virtualFunctions;
    }

    /**
     * Sets the value of the virtualFunctions property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setVirtualFunctions(Integer value) {
        this.virtualFunctions = value;
    }

    public boolean isSetVirtualFunctions() {
        return (this.virtualFunctions!= null);
    }

    /**
     * Gets the value of the placeholder property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getPlaceholder() {
        return placeholder;
    }

    /**
     * Sets the value of the placeholder property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setPlaceholder(Boolean value) {
        this.placeholder = value;
    }

    public boolean isSetPlaceholder() {
        return (this.placeholder!= null);
    }

    /**
     * Gets the value of the vm property.
     *
     * @return
     *     possible object is
     *     {@link Vm }
     *
     */
    public Vm getVm() {
        return vm;
    }

    /**
     * Sets the value of the vm property.
     *
     * @param value
     *     allowed object is
     *     {@link Vm }
     *
     */
    public void setVm(Vm value) {
        this.vm = value;
    }

    public boolean isSetVm() {
        return (this.vm!= null);
    }

}
