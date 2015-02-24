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
 * <p>Java class for HostedEngine complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="HostedEngine">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="configured" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="active" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="score" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="global_maintenance" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="local_maintenance" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostedEngine", propOrder = {
    "configured",
    "active",
    "score",
    "globalMaintenance",
    "localMaintenance"
})
public class HostedEngine {

    protected Boolean configured;
    protected Boolean active;
    protected Integer score;
    @XmlElement(name = "global_maintenance")
    protected Boolean globalMaintenance;
    @XmlElement(name = "local_maintenance")
    protected Boolean localMaintenance;

    /**
     * Gets the value of the configured property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getConfigured() {
        return configured;
    }

    /**
     * Sets the value of the configured property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setConfigured(Boolean value) {
        this.configured = value;
    }

    public boolean isSetConfigured() {
        return (this.configured!= null);
    }

    /**
     * Gets the value of the active property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getActive() {
        return active;
    }

    /**
     * Sets the value of the active property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setActive(Boolean value) {
        this.active = value;
    }

    public boolean isSetActive() {
        return (this.active!= null);
    }

    /**
     * Gets the value of the score property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getScore() {
        return score;
    }

    /**
     * Sets the value of the score property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setScore(Integer value) {
        this.score = value;
    }

    public boolean isSetScore() {
        return (this.score!= null);
    }

    /**
     * Gets the value of the globalMaintenance property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getGlobalMaintenance() {
        return globalMaintenance;
    }

    /**
     * Sets the value of the globalMaintenance property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setGlobalMaintenance(Boolean value) {
        this.globalMaintenance = value;
    }

    public boolean isSetGlobalMaintenance() {
        return (this.globalMaintenance!= null);
    }

    /**
     * Gets the value of the localMaintenance property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getLocalMaintenance() {
        return localMaintenance;
    }

    /**
     * Sets the value of the localMaintenance property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setLocalMaintenance(Boolean value) {
        this.localMaintenance = value;
    }

    public boolean isSetLocalMaintenance() {
        return (this.localMaintenance!= null);
    }

}

