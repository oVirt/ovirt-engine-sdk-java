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
 * <p>Java class for QoS complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="QoS">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseResource">
 *       &lt;sequence>
 *         &lt;element ref="{}data_center" minOccurs="0"/>
 *         &lt;element name="max_throughput" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="max_read_throughput" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="max_write_throughput" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="max_iops" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="max_read_iops" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="max_write_iops" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="cpu_limit" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="inbound_average" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="inbound_peak" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="inbound_burst" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="outbound_average" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="outbound_peak" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="outbound_burst" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QoS", propOrder = {
    "dataCenter",
    "maxThroughput",
    "maxReadThroughput",
    "maxWriteThroughput",
    "maxIops",
    "maxReadIops",
    "maxWriteIops",
    "cpuLimit",
    "inboundAverage",
    "inboundPeak",
    "inboundBurst",
    "outboundAverage",
    "outboundPeak",
    "outboundBurst"
})
public class QoS
    extends BaseResource
{

    @XmlElement(name = "data_center")
    protected DataCenter dataCenter;
    @XmlElement(name = "max_throughput")
    protected Integer maxThroughput;
    @XmlElement(name = "max_read_throughput")
    protected Integer maxReadThroughput;
    @XmlElement(name = "max_write_throughput")
    protected Integer maxWriteThroughput;
    @XmlElement(name = "max_iops")
    protected Integer maxIops;
    @XmlElement(name = "max_read_iops")
    protected Integer maxReadIops;
    @XmlElement(name = "max_write_iops")
    protected Integer maxWriteIops;
    @XmlElement(name = "cpu_limit")
    protected Integer cpuLimit;
    @XmlElement(name = "inbound_average")
    protected Integer inboundAverage;
    @XmlElement(name = "inbound_peak")
    protected Integer inboundPeak;
    @XmlElement(name = "inbound_burst")
    protected Integer inboundBurst;
    @XmlElement(name = "outbound_average")
    protected Integer outboundAverage;
    @XmlElement(name = "outbound_peak")
    protected Integer outboundPeak;
    @XmlElement(name = "outbound_burst")
    protected Integer outboundBurst;
    @XmlAttribute(name = "type")
    protected String type;

    /**
     * Gets the value of the dataCenter property.
     *
     * @return
     *     possible object is
     *     {@link DataCenter }
     *
     */
    public DataCenter getDataCenter() {
        return dataCenter;
    }

    /**
     * Sets the value of the dataCenter property.
     *
     * @param value
     *     allowed object is
     *     {@link DataCenter }
     *
     */
    public void setDataCenter(DataCenter value) {
        this.dataCenter = value;
    }

    public boolean isSetDataCenter() {
        return (this.dataCenter!= null);
    }

    /**
     * Gets the value of the maxThroughput property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getMaxThroughput() {
        return maxThroughput;
    }

    /**
     * Sets the value of the maxThroughput property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setMaxThroughput(Integer value) {
        this.maxThroughput = value;
    }

    public boolean isSetMaxThroughput() {
        return (this.maxThroughput!= null);
    }

    /**
     * Gets the value of the maxReadThroughput property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getMaxReadThroughput() {
        return maxReadThroughput;
    }

    /**
     * Sets the value of the maxReadThroughput property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setMaxReadThroughput(Integer value) {
        this.maxReadThroughput = value;
    }

    public boolean isSetMaxReadThroughput() {
        return (this.maxReadThroughput!= null);
    }

    /**
     * Gets the value of the maxWriteThroughput property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getMaxWriteThroughput() {
        return maxWriteThroughput;
    }

    /**
     * Sets the value of the maxWriteThroughput property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setMaxWriteThroughput(Integer value) {
        this.maxWriteThroughput = value;
    }

    public boolean isSetMaxWriteThroughput() {
        return (this.maxWriteThroughput!= null);
    }

    /**
     * Gets the value of the maxIops property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getMaxIops() {
        return maxIops;
    }

    /**
     * Sets the value of the maxIops property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setMaxIops(Integer value) {
        this.maxIops = value;
    }

    public boolean isSetMaxIops() {
        return (this.maxIops!= null);
    }

    /**
     * Gets the value of the maxReadIops property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getMaxReadIops() {
        return maxReadIops;
    }

    /**
     * Sets the value of the maxReadIops property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setMaxReadIops(Integer value) {
        this.maxReadIops = value;
    }

    public boolean isSetMaxReadIops() {
        return (this.maxReadIops!= null);
    }

    /**
     * Gets the value of the maxWriteIops property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getMaxWriteIops() {
        return maxWriteIops;
    }

    /**
     * Sets the value of the maxWriteIops property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setMaxWriteIops(Integer value) {
        this.maxWriteIops = value;
    }

    public boolean isSetMaxWriteIops() {
        return (this.maxWriteIops!= null);
    }

    /**
     * Gets the value of the cpuLimit property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getCpuLimit() {
        return cpuLimit;
    }

    /**
     * Sets the value of the cpuLimit property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setCpuLimit(Integer value) {
        this.cpuLimit = value;
    }

    public boolean isSetCpuLimit() {
        return (this.cpuLimit!= null);
    }

    /**
     * Gets the value of the inboundAverage property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getInboundAverage() {
        return inboundAverage;
    }

    /**
     * Sets the value of the inboundAverage property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setInboundAverage(Integer value) {
        this.inboundAverage = value;
    }

    public boolean isSetInboundAverage() {
        return (this.inboundAverage!= null);
    }

    /**
     * Gets the value of the inboundPeak property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getInboundPeak() {
        return inboundPeak;
    }

    /**
     * Sets the value of the inboundPeak property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setInboundPeak(Integer value) {
        this.inboundPeak = value;
    }

    public boolean isSetInboundPeak() {
        return (this.inboundPeak!= null);
    }

    /**
     * Gets the value of the inboundBurst property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getInboundBurst() {
        return inboundBurst;
    }

    /**
     * Sets the value of the inboundBurst property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setInboundBurst(Integer value) {
        this.inboundBurst = value;
    }

    public boolean isSetInboundBurst() {
        return (this.inboundBurst!= null);
    }

    /**
     * Gets the value of the outboundAverage property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getOutboundAverage() {
        return outboundAverage;
    }

    /**
     * Sets the value of the outboundAverage property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setOutboundAverage(Integer value) {
        this.outboundAverage = value;
    }

    public boolean isSetOutboundAverage() {
        return (this.outboundAverage!= null);
    }

    /**
     * Gets the value of the outboundPeak property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getOutboundPeak() {
        return outboundPeak;
    }

    /**
     * Sets the value of the outboundPeak property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setOutboundPeak(Integer value) {
        this.outboundPeak = value;
    }

    public boolean isSetOutboundPeak() {
        return (this.outboundPeak!= null);
    }

    /**
     * Gets the value of the outboundBurst property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getOutboundBurst() {
        return outboundBurst;
    }

    /**
     * Sets the value of the outboundBurst property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setOutboundBurst(Integer value) {
        this.outboundBurst = value;
    }

    public boolean isSetOutboundBurst() {
        return (this.outboundBurst!= null);
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
