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
 * <p>Java class for Capabilities complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Capabilities">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseResources">
 *       &lt;sequence>
 *         &lt;element name="version" type="{}VersionCaps" maxOccurs="unbounded"/>
 *         &lt;element name="permits" type="{}Permits" minOccurs="0"/>
 *         &lt;element name="scheduling_policies" type="{}SchedulingPolicies" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Capabilities", propOrder = {
    "versions",
    "permits",
    "schedulingPolicies"
})
public class Capabilities
    extends BaseResources
{

    @XmlElement(name = "version", required = true)
    protected List<VersionCaps> versions;
    protected Permits permits;
    @XmlElement(name = "scheduling_policies")
    protected SchedulingPolicies schedulingPolicies;

    /**
     * Gets the value of the versions property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the versions property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVersions().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VersionCaps }
     *
     *
     */
    public List<VersionCaps> getVersions() {
        if (versions == null) {
            versions = new ArrayList<VersionCaps>();
        }
        return this.versions;
    }

    public boolean isSetVersions() {
        return ((this.versions!= null)&&(!this.versions.isEmpty()));
    }

    public void unsetVersions() {
        this.versions = null;
    }

    /**
     * Gets the value of the permits property.
     *
     * @return
     *     possible object is
     *     {@link Permits }
     *
     */
    public Permits getPermits() {
        return permits;
    }

    /**
     * Sets the value of the permits property.
     *
     * @param value
     *     allowed object is
     *     {@link Permits }
     *
     */
    public void setPermits(Permits value) {
        this.permits = value;
    }

    public boolean isSetPermits() {
        return (this.permits!= null);
    }

    /**
     * Gets the value of the schedulingPolicies property.
     *
     * @return
     *     possible object is
     *     {@link SchedulingPolicies }
     *
     */
    public SchedulingPolicies getSchedulingPolicies() {
        return schedulingPolicies;
    }

    /**
     * Sets the value of the schedulingPolicies property.
     *
     * @param value
     *     allowed object is
     *     {@link SchedulingPolicies }
     *
     */
    public void setSchedulingPolicies(SchedulingPolicies value) {
        this.schedulingPolicies = value;
    }

    public boolean isSetSchedulingPolicies() {
        return (this.schedulingPolicies!= null);
    }

}

