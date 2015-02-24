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
 * <p>Java class for SchedulingPolicy complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="SchedulingPolicy">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseResource">
 *       &lt;sequence>
 *         &lt;element name="policy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="thresholds" type="{}SchedulingPolicyThresholds" minOccurs="0"/>
 *         &lt;element name="locked" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="default_policy" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element ref="{}properties" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SchedulingPolicy", propOrder = {
    "policy",
    "thresholds",
    "locked",
    "defaultPolicy",
    "properties"
})
public class SchedulingPolicy
    extends BaseResource
{

    protected String policy;
    protected SchedulingPolicyThresholds thresholds;
    protected Boolean locked;
    @XmlElement(name = "default_policy")
    protected Boolean defaultPolicy;
    protected Properties properties;

    /**
     * Gets the value of the policy property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getPolicy() {
        return policy;
    }

    /**
     * Sets the value of the policy property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setPolicy(String value) {
        this.policy = value;
    }

    public boolean isSetPolicy() {
        return (this.policy!= null);
    }

    /**
     * Gets the value of the thresholds property.
     *
     * @return
     *     possible object is
     *     {@link SchedulingPolicyThresholds }
     *
     */
    public SchedulingPolicyThresholds getThresholds() {
        return thresholds;
    }

    /**
     * Sets the value of the thresholds property.
     *
     * @param value
     *     allowed object is
     *     {@link SchedulingPolicyThresholds }
     *
     */
    public void setThresholds(SchedulingPolicyThresholds value) {
        this.thresholds = value;
    }

    public boolean isSetThresholds() {
        return (this.thresholds!= null);
    }

    /**
     * Gets the value of the locked property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getLocked() {
        return locked;
    }

    /**
     * Sets the value of the locked property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setLocked(Boolean value) {
        this.locked = value;
    }

    public boolean isSetLocked() {
        return (this.locked!= null);
    }

    /**
     * Gets the value of the defaultPolicy property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getDefaultPolicy() {
        return defaultPolicy;
    }

    /**
     * Sets the value of the defaultPolicy property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setDefaultPolicy(Boolean value) {
        this.defaultPolicy = value;
    }

    public boolean isSetDefaultPolicy() {
        return (this.defaultPolicy!= null);
    }

    /**
     * Gets the value of the properties property.
     *
     * @return
     *     possible object is
     *     {@link Properties }
     *
     */
    public Properties getProperties() {
        return properties;
    }

    /**
     * Sets the value of the properties property.
     *
     * @param value
     *     allowed object is
     *     {@link Properties }
     *
     */
    public void setProperties(Properties value) {
        this.properties = value;
    }

    public boolean isSetProperties() {
        return (this.properties!= null);
    }

}
