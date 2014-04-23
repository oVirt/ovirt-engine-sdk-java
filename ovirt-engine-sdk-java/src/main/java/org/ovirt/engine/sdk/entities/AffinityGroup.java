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
 * <p>Java class for AffinityGroup complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="AffinityGroup">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseResource">
 *       &lt;sequence>
 *         &lt;element ref="{}cluster"/>
 *         &lt;element name="positive" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="enforcing" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AffinityGroup", propOrder = {
    "cluster",
    "positive",
    "enforcing"
})
public class AffinityGroup
    extends BaseResource
{

    @XmlElement(required = true)
    protected Cluster cluster;
    protected boolean positive;
    protected boolean enforcing;

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

    /**
     * Gets the value of the positive property.
     *
     */
    public boolean isPositive() {
        return positive;
    }

    /**
     * Sets the value of the positive property.
     *
     */
    public void setPositive(boolean value) {
        this.positive = value;
    }

    public boolean isSetPositive() {
        return true;
    }

    /**
     * Gets the value of the enforcing property.
     *
     */
    public boolean isEnforcing() {
        return enforcing;
    }

    /**
     * Sets the value of the enforcing property.
     *
     */
    public void setEnforcing(boolean value) {
        this.enforcing = value;
    }

    public boolean isSetEnforcing() {
        return true;
    }

}
