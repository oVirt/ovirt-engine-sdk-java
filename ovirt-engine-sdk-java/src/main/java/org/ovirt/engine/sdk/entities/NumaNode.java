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
 * <p>Java class for NumaNode complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="NumaNode">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseResource">
 *       &lt;sequence>
 *         &lt;element ref="{}host" minOccurs="0"/>
 *         &lt;element name="index" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="memory" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="cpu" type="{}CPU" minOccurs="0"/>
 *         &lt;element name="statistics" type="{}Statistics" minOccurs="0"/>
 *         &lt;element name="node_distance" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NumaNode", propOrder = {
    "host",
    "index",
    "memory",
    "cpu",
    "statistics",
    "nodeDistance"
})
@XmlSeeAlso({
    VirtualNumaNode.class
})
public class NumaNode
    extends BaseResource
{

    protected Host host;
    protected Integer index;
    protected Long memory;
    protected CPU cpu;
    protected Statistics statistics;
    @XmlElement(name = "node_distance")
    protected String nodeDistance;

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
     * Gets the value of the index property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getIndex() {
        return index;
    }

    /**
     * Sets the value of the index property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setIndex(Integer value) {
        this.index = value;
    }

    public boolean isSetIndex() {
        return (this.index!= null);
    }

    /**
     * Gets the value of the memory property.
     *
     * @return
     *     possible object is
     *     {@link Long }
     *
     */
    public Long getMemory() {
        return memory;
    }

    /**
     * Sets the value of the memory property.
     *
     * @param value
     *     allowed object is
     *     {@link Long }
     *
     */
    public void setMemory(Long value) {
        this.memory = value;
    }

    public boolean isSetMemory() {
        return (this.memory!= null);
    }

    /**
     * Gets the value of the cpu property.
     *
     * @return
     *     possible object is
     *     {@link CPU }
     *
     */
    public CPU getCpu() {
        return cpu;
    }

    /**
     * Sets the value of the cpu property.
     *
     * @param value
     *     allowed object is
     *     {@link CPU }
     *
     */
    public void setCpu(CPU value) {
        this.cpu = value;
    }

    public boolean isSetCpu() {
        return (this.cpu!= null);
    }

    /**
     * Gets the value of the statistics property.
     *
     * @return
     *     possible object is
     *     {@link Statistics }
     *
     */
    public Object getStatistics() {
        return statistics;
    }

    /**
     * Sets the value of the statistics property.
     *
     * @param value
     *     allowed object is
     *     {@link Statistics }
     *
     */
    public void setStatistics(Statistics value) {
        this.statistics = value;
    }

    public boolean isSetStatistics() {
        return (this.statistics!= null);
    }

    /**
     * Gets the value of the nodeDistance property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getNodeDistance() {
        return nodeDistance;
    }

    /**
     * Sets the value of the nodeDistance property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setNodeDistance(String value) {
        this.nodeDistance = value;
    }

    public boolean isSetNodeDistance() {
        return (this.nodeDistance!= null);
    }

}
