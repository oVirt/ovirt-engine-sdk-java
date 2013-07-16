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
 * <p>Java class for GlusterBrickAdvancedDetails complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="GlusterBrickAdvancedDetails">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseResource">
 *       &lt;sequence>
 *         &lt;element name="port" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="pid" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="device" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mnt_options" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fs_name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element ref="{}gluster_clients" minOccurs="0"/>
 *         &lt;element ref="{}memory_pools" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GlusterBrickAdvancedDetails", propOrder = {
    "port",
    "pid",
    "device",
    "mntOptions",
    "fsName",
    "glusterClients",
    "memoryPools"
})
@XmlSeeAlso({
    GlusterBrick.class
})
public class GlusterBrickAdvancedDetails
    extends BaseResource
{

    protected Integer port;
    protected Integer pid;
    protected String device;
    @XmlElement(name = "mnt_options")
    protected String mntOptions;
    @XmlElement(name = "fs_name")
    protected String fsName;
    @XmlElement(name = "gluster_clients")
    protected GlusterClients glusterClients;
    @XmlElement(name = "memory_pools")
    protected GlusterMemoryPools memoryPools;

    /**
     * Gets the value of the port property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getPort() {
        return port;
    }

    /**
     * Sets the value of the port property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setPort(Integer value) {
        this.port = value;
    }

    public boolean isSetPort() {
        return (this.port!= null);
    }

    /**
     * Gets the value of the pid property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * Sets the value of the pid property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setPid(Integer value) {
        this.pid = value;
    }

    public boolean isSetPid() {
        return (this.pid!= null);
    }

    /**
     * Gets the value of the device property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDevice() {
        return device;
    }

    /**
     * Sets the value of the device property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDevice(String value) {
        this.device = value;
    }

    public boolean isSetDevice() {
        return (this.device!= null);
    }

    /**
     * Gets the value of the mntOptions property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getMntOptions() {
        return mntOptions;
    }

    /**
     * Sets the value of the mntOptions property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setMntOptions(String value) {
        this.mntOptions = value;
    }

    public boolean isSetMntOptions() {
        return (this.mntOptions!= null);
    }

    /**
     * Gets the value of the fsName property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getFsName() {
        return fsName;
    }

    /**
     * Sets the value of the fsName property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setFsName(String value) {
        this.fsName = value;
    }

    public boolean isSetFsName() {
        return (this.fsName!= null);
    }

    /**
     * Gets the value of the glusterClients property.
     *
     * @return
     *     possible object is
     *     {@link GlusterClients }
     *
     */
    public GlusterClients getGlusterClients() {
        return glusterClients;
    }

    /**
     * Sets the value of the glusterClients property.
     *
     * @param value
     *     allowed object is
     *     {@link GlusterClients }
     *
     */
    public void setGlusterClients(GlusterClients value) {
        this.glusterClients = value;
    }

    public boolean isSetGlusterClients() {
        return (this.glusterClients!= null);
    }

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

