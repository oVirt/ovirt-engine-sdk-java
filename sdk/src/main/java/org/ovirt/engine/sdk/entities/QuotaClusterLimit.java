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
 * <p>Java class for QuotaClusterLimit complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="QuotaClusterLimit">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseResource">
 *       &lt;sequence>
 *         &lt;element ref="{}quota" minOccurs="0"/>
 *         &lt;element ref="{}cluster" minOccurs="0"/>
 *         &lt;element name="vcpu_limit" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="vcpu_usage" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="memory_limit" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="memory_usage" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QuotaClusterLimit", propOrder = {
    "quota",
    "cluster",
    "vcpuLimit",
    "vcpuUsage",
    "memoryLimit",
    "memoryUsage"
})
public class QuotaClusterLimit
    extends BaseResource
{

    protected Quota quota;
    protected Cluster cluster;
    @XmlElement(name = "vcpu_limit")
    protected Integer vcpuLimit;
    @XmlElement(name = "vcpu_usage")
    protected Integer vcpuUsage;
    @XmlElement(name = "memory_limit")
    protected Double memoryLimit;
    @XmlElement(name = "memory_usage")
    protected Double memoryUsage;

    /**
     * Gets the value of the quota property.
     *
     * @return
     *     possible object is
     *     {@link Quota }
     *
     */
    public Quota getQuota() {
        return quota;
    }

    /**
     * Sets the value of the quota property.
     *
     * @param value
     *     allowed object is
     *     {@link Quota }
     *
     */
    public void setQuota(Quota value) {
        this.quota = value;
    }

    public boolean isSetQuota() {
        return (this.quota!= null);
    }

    /**
     * Gets the value of the cluster property.
     *
     * @return
     *     possible object is
     *     {@link Cluster }
     *
     */
    public Cluster getCluster() {
        return cluster;
    }

    /**
     * Sets the value of the cluster property.
     *
     * @param value
     *     allowed object is
     *     {@link Cluster }
     *
     */
    public void setCluster(Cluster value) {
        this.cluster = value;
    }

    public boolean isSetCluster() {
        return (this.cluster!= null);
    }

    /**
     * Gets the value of the vcpuLimit property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getVcpuLimit() {
        return vcpuLimit;
    }

    /**
     * Sets the value of the vcpuLimit property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setVcpuLimit(Integer value) {
        this.vcpuLimit = value;
    }

    public boolean isSetVcpuLimit() {
        return (this.vcpuLimit!= null);
    }

    /**
     * Gets the value of the vcpuUsage property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getVcpuUsage() {
        return vcpuUsage;
    }

    /**
     * Sets the value of the vcpuUsage property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setVcpuUsage(Integer value) {
        this.vcpuUsage = value;
    }

    public boolean isSetVcpuUsage() {
        return (this.vcpuUsage!= null);
    }

    /**
     * Gets the value of the memoryLimit property.
     *
     * @return
     *     possible object is
     *     {@link Double }
     *
     */
    public Double getMemoryLimit() {
        return memoryLimit;
    }

    /**
     * Sets the value of the memoryLimit property.
     *
     * @param value
     *     allowed object is
     *     {@link Double }
     *
     */
    public void setMemoryLimit(Double value) {
        this.memoryLimit = value;
    }

    public boolean isSetMemoryLimit() {
        return (this.memoryLimit!= null);
    }

    /**
     * Gets the value of the memoryUsage property.
     *
     * @return
     *     possible object is
     *     {@link Double }
     *
     */
    public Double getMemoryUsage() {
        return memoryUsage;
    }

    /**
     * Sets the value of the memoryUsage property.
     *
     * @param value
     *     allowed object is
     *     {@link Double }
     *
     */
    public void setMemoryUsage(Double value) {
        this.memoryUsage = value;
    }

    public boolean isSetMemoryUsage() {
        return (this.memoryUsage!= null);
    }

}
