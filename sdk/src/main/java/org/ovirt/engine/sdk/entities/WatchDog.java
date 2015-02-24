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
 * <p>Java class for WatchDog complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="WatchDog">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseDevice">
 *       &lt;sequence>
 *         &lt;element name="model" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="action" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WatchDog", propOrder = {
    "model",
    "action"
})
public class WatchDog
    extends BaseDevice
{

    @XmlElement(required = true)
    protected String model;
    @XmlElement(required = true)
    protected String action;

    /**
     * Gets the value of the model property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getModel() {
        return model;
    }

    /**
     * Sets the value of the model property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setModel(String value) {
        this.model = value;
    }

    public boolean isSetModel() {
        return (this.model!= null);
    }

    /**
     * Gets the value of the action property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAction() {
        return action;
    }

    /**
     * Sets the value of the action property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAction(String value) {
        this.action = value;
    }

    public boolean isSetAction() {
        return (this.action!= null);
    }

}
