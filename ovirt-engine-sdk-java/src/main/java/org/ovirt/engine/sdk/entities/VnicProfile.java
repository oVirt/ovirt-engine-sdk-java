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
 * <p>Java class for VnicProfile complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="VnicProfile">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseResource">
 *       &lt;sequence>
 *         &lt;element ref="{}network" minOccurs="0"/>
 *         &lt;element name="port_mirroring" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element ref="{}custom_properties" minOccurs="0"/>
 *         &lt;element ref="{}qos" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VnicProfile", propOrder = {
    "network",
    "portMirroring",
    "customProperties",
    "qos"
})
public class VnicProfile
    extends BaseResource
{

    protected Network network;
    @XmlElement(name = "port_mirroring")
    protected Boolean portMirroring;
    @XmlElement(name = "custom_properties")
    protected CustomProperties customProperties;
    protected QoS qos;

    /**
     * Gets the value of the network property.
     *
     * @return
     *     possible object is
     *     {@link Network }
     *
     */
    public Network getNetwork() {
        return network;
    }

    /**
     * Sets the value of the network property.
     *
     * @param value
     *     allowed object is
     *     {@link Network }
     *
     */
    public void setNetwork(Network value) {
        this.network = value;
    }

    public boolean isSetNetwork() {
        return (this.network!= null);
    }

    /**
     * Gets the value of the portMirroring property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getPortMirroring() {
        return portMirroring;
    }

    /**
     * Sets the value of the portMirroring property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setPortMirroring(Boolean value) {
        this.portMirroring = value;
    }

    public boolean isSetPortMirroring() {
        return (this.portMirroring!= null);
    }

    /**
     * Gets the value of the customProperties property.
     *
     * @return
     *     possible object is
     *     {@link CustomProperties }
     *
     */
    public CustomProperties getCustomProperties() {
        return customProperties;
    }

    /**
     * Sets the value of the customProperties property.
     *
     * @param value
     *     allowed object is
     *     {@link CustomProperties }
     *
     */
    public void setCustomProperties(CustomProperties value) {
        this.customProperties = value;
    }

    public boolean isSetCustomProperties() {
        return (this.customProperties!= null);
    }

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

}
