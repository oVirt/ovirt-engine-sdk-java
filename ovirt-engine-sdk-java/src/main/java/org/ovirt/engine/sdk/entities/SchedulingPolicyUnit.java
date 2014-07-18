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
 * <p>Java class for SchedulingPolicyUnit complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="SchedulingPolicyUnit">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseResource">
 *       &lt;sequence>
 *         &lt;element name="internal" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="enabled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element ref="{}properties" minOccurs="0"/>
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
@XmlType(name = "SchedulingPolicyUnit", propOrder = {
    "internal",
    "enabled",
    "propertiesMetaData"
})
public class SchedulingPolicyUnit
    extends BaseResource
{

    protected Boolean internal;
    protected Boolean enabled;
    @XmlElement(name = "properties")
    protected Properties propertiesMetaData;
    @XmlAttribute(name = "type")
    protected String type;

    /**
     * Gets the value of the internal property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getInternal() {
        return internal;
    }

    /**
     * Sets the value of the internal property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setInternal(Boolean value) {
        this.internal = value;
    }

    public boolean isSetInternal() {
        return (this.internal!= null);
    }

    /**
     * Gets the value of the enabled property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getEnabled() {
        return enabled;
    }

    /**
     * Sets the value of the enabled property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setEnabled(Boolean value) {
        this.enabled = value;
    }

    public boolean isSetEnabled() {
        return (this.enabled!= null);
    }

    /**
     * Gets the value of the propertiesMetaData property.
     *
     * @return
     *     possible object is
     *     {@link Properties }
     *
     */
    public Properties getPropertiesMetaData() {
        return propertiesMetaData;
    }

    /**
     * Sets the value of the propertiesMetaData property.
     *
     * @param value
     *     allowed object is
     *     {@link Properties }
     *
     */
    public void setPropertiesMetaData(Properties value) {
        this.propertiesMetaData = value;
    }

    public boolean isSetPropertiesMetaData() {
        return (this.propertiesMetaData!= null);
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
