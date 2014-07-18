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
 * <p>Java class for Balance complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Balance">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseResource">
 *       &lt;sequence>
 *         &lt;element ref="{}scheduling_policy" minOccurs="0"/>
 *         &lt;element ref="{}scheduling_policy_unit" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Balance", propOrder = {
    "schedulingPolicy",
    "schedulingPolicyUnit"
})
public class Balance
    extends BaseResource
{

    @XmlElement(name = "scheduling_policy")
    protected SchedulingPolicy schedulingPolicy;
    @XmlElement(name = "scheduling_policy_unit")
    protected SchedulingPolicyUnit schedulingPolicyUnit;

    /**
     * Gets the value of the schedulingPolicy property.
     *
     * @return
     *     possible object is
     *     {@link SchedulingPolicy }
     *
     */
    public SchedulingPolicy getSchedulingPolicy() {
        return schedulingPolicy;
    }

    /**
     * Sets the value of the schedulingPolicy property.
     *
     * @param value
     *     allowed object is
     *     {@link SchedulingPolicy }
     *
     */
    public void setSchedulingPolicy(SchedulingPolicy value) {
        this.schedulingPolicy = value;
    }

    public boolean isSetSchedulingPolicy() {
        return (this.schedulingPolicy!= null);
    }

    /**
     * Gets the value of the schedulingPolicyUnit property.
     *
     * @return
     *     possible object is
     *     {@link SchedulingPolicyUnit }
     *
     */
    public SchedulingPolicyUnit getSchedulingPolicyUnit() {
        return schedulingPolicyUnit;
    }

    /**
     * Sets the value of the schedulingPolicyUnit property.
     *
     * @param value
     *     allowed object is
     *     {@link SchedulingPolicyUnit }
     *
     */
    public void setSchedulingPolicyUnit(SchedulingPolicyUnit value) {
        this.schedulingPolicyUnit = value;
    }

    public boolean isSetSchedulingPolicyUnit() {
        return (this.schedulingPolicyUnit!= null);
    }

}
