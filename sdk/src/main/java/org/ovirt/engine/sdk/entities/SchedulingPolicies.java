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

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SchedulingPolicies complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="SchedulingPolicies">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseResources">
 *       &lt;sequence>
 *         &lt;element name="scheduling_policy" type="{}SchedulingPolicy" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SchedulingPolicies", propOrder = {
    "schedulingPolicies"
})
public class SchedulingPolicies
    extends BaseResources
{

    @XmlElement(name = "scheduling_policy")
    protected List<SchedulingPolicy> schedulingPolicies;

    /**
     * Gets the value of the schedulingPolicies property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the schedulingPolicies property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSchedulingPolicies().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SchedulingPolicy }
     *
     *
     */
    public List<SchedulingPolicy> getSchedulingPolicies() {
        if (schedulingPolicies == null) {
            schedulingPolicies = new ArrayList<SchedulingPolicy>();
        }
        return this.schedulingPolicies;
    }

    public boolean isSetSchedulingPolicies() {
        return ((this.schedulingPolicies!= null)&&(!this.schedulingPolicies.isEmpty()));
    }

    public void unsetSchedulingPolicies() {
        this.schedulingPolicies = null;
    }

}
