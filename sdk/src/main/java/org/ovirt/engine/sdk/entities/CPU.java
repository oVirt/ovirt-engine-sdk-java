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

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CPU complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="CPU">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="topology" type="{}CpuTopology" minOccurs="0"/>
 *         &lt;element name="level" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="speed" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="cpu_tune" type="{}CpuTune" minOccurs="0"/>
 *         &lt;element name="mode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="architecture" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cores" type="{}Cores" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CPU", propOrder = {
    "topology",
    "level",
    "name",
    "speed",
    "cpuTune",
    "mode",
    "architecture",
    "cores"
})
public class CPU {

    protected CpuTopology topology;
    protected Integer level;
    protected String name;
    protected BigDecimal speed;
    @XmlElement(name = "cpu_tune")
    protected CpuTune cpuTune;
    protected String mode;
    protected String architecture;
    protected Cores cores;
    @XmlAttribute(name = "id")
    protected String id;

    /**
     * Gets the value of the topology property.
     *
     * @return
     *     possible object is
     *     {@link CpuTopology }
     *
     */
    public CpuTopology getTopology() {
        return topology;
    }

    /**
     * Sets the value of the topology property.
     *
     * @param value
     *     allowed object is
     *     {@link CpuTopology }
     *
     */
    public void setTopology(CpuTopology value) {
        this.topology = value;
    }

    public boolean isSetTopology() {
        return (this.topology!= null);
    }

    /**
     * Gets the value of the level property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * Sets the value of the level property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setLevel(Integer value) {
        this.level = value;
    }

    public boolean isSetLevel() {
        return (this.level!= null);
    }

    /**
     * Gets the value of the name property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setName(String value) {
        this.name = value;
    }

    public boolean isSetName() {
        return (this.name!= null);
    }

    /**
     * Gets the value of the speed property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getSpeed() {
        return speed;
    }

    /**
     * Sets the value of the speed property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setSpeed(BigDecimal value) {
        this.speed = value;
    }

    public boolean isSetSpeed() {
        return (this.speed!= null);
    }

    /**
     * Gets the value of the cpuTune property.
     *
     * @return
     *     possible object is
     *     {@link CpuTune }
     *
     */
    public CpuTune getCpuTune() {
        return cpuTune;
    }

    /**
     * Sets the value of the cpuTune property.
     *
     * @param value
     *     allowed object is
     *     {@link CpuTune }
     *
     */
    public void setCpuTune(CpuTune value) {
        this.cpuTune = value;
    }

    public boolean isSetCpuTune() {
        return (this.cpuTune!= null);
    }

    /**
     * Gets the value of the mode property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getMode() {
        return mode;
    }

    /**
     * Sets the value of the mode property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setMode(String value) {
        this.mode = value;
    }

    public boolean isSetMode() {
        return (this.mode!= null);
    }

    /**
     * Gets the value of the architecture property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getArchitecture() {
        return architecture;
    }

    /**
     * Sets the value of the architecture property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setArchitecture(String value) {
        this.architecture = value;
    }

    public boolean isSetArchitecture() {
        return (this.architecture!= null);
    }

    /**
     * Gets the value of the cores property.
     *
     * @return
     *     possible object is
     *     {@link Cores }
     *
     */
    public Cores getCores() {
        return cores;
    }

    /**
     * Sets the value of the cores property.
     *
     * @param value
     *     allowed object is
     *     {@link Cores }
     *
     */
    public void setCores(Cores value) {
        this.cores = value;
    }

    public boolean isSetCores() {
        return (this.cores!= null);
    }

    /**
     * Gets the value of the id property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setId(String value) {
        this.id = value;
    }

    public boolean isSetId() {
        return (this.id!= null);
    }

}

