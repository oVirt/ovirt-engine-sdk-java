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

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OperatingSystem complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="OperatingSystem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="boot" type="{}Boot" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="kernel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="initrd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cmdline" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="version" type="{}Version" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OperatingSystem", propOrder = {
    "boot",
    "kernel",
    "initrd",
    "cmdline",
    "version"
})
public class OperatingSystem {

    protected List<Boot> boot;
    protected String kernel;
    protected String initrd;
    protected String cmdline;
    protected Version version;
    @XmlAttribute(name = "type")
    protected String type;

    /**
     * Gets the value of the boot property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the boot property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBoot().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Boot }
     *
     *
     */
    public List<Boot> getBoot() {
        if (boot == null) {
            boot = new ArrayList<Boot>();
        }
        return this.boot;
    }

    public boolean isSetBoot() {
        return ((this.boot!= null)&&(!this.boot.isEmpty()));
    }

    public void unsetBoot() {
        this.boot = null;
    }

    /**
     * Gets the value of the kernel property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getKernel() {
        return kernel;
    }

    /**
     * Sets the value of the kernel property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setKernel(String value) {
        this.kernel = value;
    }

    public boolean isSetKernel() {
        return (this.kernel!= null);
    }

    /**
     * Gets the value of the initrd property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getInitrd() {
        return initrd;
    }

    /**
     * Sets the value of the initrd property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setInitrd(String value) {
        this.initrd = value;
    }

    public boolean isSetInitrd() {
        return (this.initrd!= null);
    }

    /**
     * Gets the value of the cmdline property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCmdline() {
        return cmdline;
    }

    /**
     * Sets the value of the cmdline property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCmdline(String value) {
        this.cmdline = value;
    }

    public boolean isSetCmdline() {
        return (this.cmdline!= null);
    }

    /**
     * Gets the value of the version property.
     *
     * @return
     *     possible object is
     *     {@link Version }
     *
     */
    public Version getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     *
     * @param value
     *     allowed object is
     *     {@link Version }
     *
     */
    public void setVersion(Version value) {
        this.version = value;
    }

    public boolean isSetVersion() {
        return (this.version!= null);
    }

    /**
     * Gets the value of the type property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setType(String value) {
        this.type = value;
    }

    public boolean isSetType() {
        return (this.type!= null);
    }

}

