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
 * <p>Java class for ReportedConfiguration complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ReportedConfiguration">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="expected_value" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="actual_value" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="in_sync" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReportedConfiguration", propOrder = {
    "name",
    "expectedValue",
    "actualValue",
    "inSync"
})
public class ReportedConfiguration {

    protected String name;
    @XmlElement(name = "expected_value")
    protected String expectedValue;
    @XmlElement(name = "actual_value")
    protected String actualValue;
    @XmlElement(name = "in_sync")
    protected Boolean inSync;

    /**
     * Gets the value of the name property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setName(String value) {
        this.name = value;
    }

    public boolean isSetName() {
        return (this.name!= null);
    }

    /**
     * Gets the value of the expectedValue property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getExpectedValue() {
        return expectedValue;
    }

    /**
     * Sets the value of the expectedValue property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setExpectedValue(String value) {
        this.expectedValue = value;
    }

    public boolean isSetExpectedValue() {
        return (this.expectedValue!= null);
    }

    /**
     * Gets the value of the actualValue property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getActualValue() {
        return actualValue;
    }

    /**
     * Sets the value of the actualValue property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setActualValue(String value) {
        this.actualValue = value;
    }

    public boolean isSetActualValue() {
        return (this.actualValue!= null);
    }

    /**
     * Gets the value of the inSync property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getInSync() {
        return inSync;
    }

    /**
     * Sets the value of the inSync property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setInSync(Boolean value) {
        this.inSync = value;
    }

    public boolean isSetInSync() {
        return (this.inSync!= null);
    }

}
