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
 * <p>Java class for Bonding complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Bonding">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}options" minOccurs="0"/>
 *         &lt;element ref="{}slaves" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Bonding", propOrder = {
    "options",
    "slaves"
})
public class Bonding {

    protected Options options;
    protected Slaves slaves;

    /**
     * Gets the value of the options property.
     *
     * @return
     *     possible object is
     *     {@link Options }
     *
     */
    public Options getOptions() {
        return options;
    }

    /**
     * Sets the value of the options property.
     *
     * @param value
     *     allowed object is
     *     {@link Options }
     *
     */
    public void setOptions(Options value) {
        this.options = value;
    }

    public boolean isSetOptions() {
        return (this.options!= null);
    }

    /**
     * Gets the value of the slaves property.
     *
     * @return
     *     possible object is
     *     {@link Slaves }
     *
     */
    public Slaves getSlaves() {
        return slaves;
    }

    /**
     * Sets the value of the slaves property.
     *
     * @param value
     *     allowed object is
     *     {@link Slaves }
     *
     */
    public void setSlaves(Slaves value) {
        this.slaves = value;
    }

    public boolean isSetSlaves() {
        return (this.slaves!= null);
    }

}

