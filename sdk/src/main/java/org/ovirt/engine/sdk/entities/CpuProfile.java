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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CpuProfile complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="CpuProfile">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseResource">
 *       &lt;sequence>
 *         &lt;element ref="{}qos" minOccurs="0"/>
 *         &lt;element ref="{}cluster" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CpuProfile", propOrder = {
    "qos",
    "cluster"
})
public class CpuProfile
    extends BaseResource
{

    protected QoS qos;
    protected Cluster cluster;

    /**
     * Gets the value of the qos property.
     *
     * @return
     *     possible object is
     *     {@link QoS }
     *
     */
    public QoS getQos() {
        return qos;
    }

    /**
     * Sets the value of the qos property.
     *
     * @param value
     *     allowed object is
     *     {@link QoS }
     *
     */
    public void setQos(QoS value) {
        this.qos = value;
    }

    public boolean isSetQos() {
        return (this.qos!= null);
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

}
