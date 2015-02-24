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

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Value complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Value">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="datum" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="detail" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Value", propOrder = {
    "datum",
    "detail"
})
public class Value {

    @XmlElement(required = true)
    protected BigDecimal datum;
    @XmlElement(required = true)
    protected String detail;

    /**
     * Gets the value of the datum property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getDatum() {
        return datum;
    }

    /**
     * Sets the value of the datum property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setDatum(BigDecimal value) {
        this.datum = value;
    }

    public boolean isSetDatum() {
        return (this.datum!= null);
    }

    /**
     * Gets the value of the detail property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDetail() {
        return detail;
    }

    /**
     * Sets the value of the detail property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDetail(String value) {
        this.detail = value;
    }

    public boolean isSetDetail() {
        return (this.detail!= null);
    }

}

