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
 * <p>Java class for RngDevice complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="RngDevice">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="rate" type="{}Rate" minOccurs="0"/>
 *         &lt;element ref="{}source"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RngDevice", propOrder = {
    "rate",
    "source"
})
public class RngDevice {

    protected Rate rate;
    @XmlElement(required = true)
    protected String source;

    /**
     * Gets the value of the rate property.
     *
     * @return
     *     possible object is
     *     {@link Rate }
     *
     */
    public Rate getRate() {
        return rate;
    }

    /**
     * Sets the value of the rate property.
     *
     * @param value
     *     allowed object is
     *     {@link Rate }
     *
     */
    public void setRate(Rate value) {
        this.rate = value;
    }

    public boolean isSetRate() {
        return (this.rate!= null);
    }

    /**
     * Gets the value of the source property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSource() {
        return source;
    }

    /**
     * Sets the value of the source property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSource(String value) {
        this.source = value;
    }

    public boolean isSetSource() {
        return (this.source!= null);
    }

}

