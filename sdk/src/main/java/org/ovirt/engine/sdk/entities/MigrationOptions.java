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
 * <p>Java class for MigrationOptions complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="MigrationOptions">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="auto_converge" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="compressed" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MigrationOptions", propOrder = {
    "autoConverge",
    "compressed"
})
public class MigrationOptions {

    @XmlElement(name = "auto_converge")
    protected String autoConverge;
    protected String compressed;

    /**
     * Gets the value of the autoConverge property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAutoConverge() {
        return autoConverge;
    }

    /**
     * Sets the value of the autoConverge property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAutoConverge(String value) {
        this.autoConverge = value;
    }

    public boolean isSetAutoConverge() {
        return (this.autoConverge!= null);
    }

    /**
     * Gets the value of the compressed property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCompressed() {
        return compressed;
    }

    /**
     * Sets the value of the compressed property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCompressed(String value) {
        this.compressed = value;
    }

    public boolean isSetCompressed() {
        return (this.compressed!= null);
    }

}
