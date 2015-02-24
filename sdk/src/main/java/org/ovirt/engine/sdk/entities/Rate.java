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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Rate complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Rate">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bytes" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="period" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Rate", propOrder = {
    "bytes",
    "period"
})
public class Rate {

    protected int bytes;
    protected Integer period;

    /**
     * Gets the value of the bytes property.
     *
     */
    public int getBytes() {
        return bytes;
    }

    /**
     * Sets the value of the bytes property.
     *
     */
    public void setBytes(int value) {
        this.bytes = value;
    }

    public boolean isSetBytes() {
        return true;
    }

    /**
     * Gets the value of the period property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getPeriod() {
        return period;
    }

    /**
     * Sets the value of the period property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setPeriod(Integer value) {
        this.period = value;
    }

    public boolean isSetPeriod() {
        return (this.period!= null);
    }

}

