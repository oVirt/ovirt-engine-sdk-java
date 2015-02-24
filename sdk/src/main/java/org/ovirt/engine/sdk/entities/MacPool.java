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
 * <p>Java class for MacPool complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="MacPool">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseResource">
 *       &lt;sequence>
 *         &lt;element name="allow_duplicates" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="default_pool" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element ref="{}ranges" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MacPool", propOrder = {
    "allowDuplicates",
    "defaultPool",
    "ranges"
})
public class MacPool
    extends BaseResource
{

    @XmlElement(name = "allow_duplicates")
    protected boolean allowDuplicates;
    @XmlElement(name = "default_pool")
    protected Boolean defaultPool;
    protected Ranges ranges;

    /**
     * Gets the value of the allowDuplicates property.
     *
     */
    public boolean isAllowDuplicates() {
        return allowDuplicates;
    }

    /**
     * Sets the value of the allowDuplicates property.
     *
     */
    public void setAllowDuplicates(boolean value) {
        this.allowDuplicates = value;
    }

    public boolean isSetAllowDuplicates() {
        return true;
    }

    /**
     * Gets the value of the defaultPool property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getDefaultPool() {
        return defaultPool;
    }

    /**
     * Sets the value of the defaultPool property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setDefaultPool(Boolean value) {
        this.defaultPool = value;
    }

    public boolean isSetDefaultPool() {
        return (this.defaultPool!= null);
    }

    /**
     * Gets the value of the ranges property.
     *
     * @return
     *     possible object is
     *     {@link Ranges }
     *
     */
    public Ranges getRanges() {
        return ranges;
    }

    /**
     * Sets the value of the ranges property.
     *
     * @param value
     *     allowed object is
     *     {@link Ranges }
     *
     */
    public void setRanges(Ranges value) {
        this.ranges = value;
    }

    public boolean isSetRanges() {
        return (this.ranges!= null);
    }

}
