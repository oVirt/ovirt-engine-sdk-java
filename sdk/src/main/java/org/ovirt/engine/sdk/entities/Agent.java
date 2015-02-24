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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Agent complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Agent">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="address" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="username" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element ref="{}options" minOccurs="0"/>
 *         &lt;element name="concurrent" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="order" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Agent", propOrder = {
    "address",
    "username",
    "password",
    "options",
    "concurrent",
    "order"
})
public class Agent {

    protected String address;
    protected String username;
    protected String password;
    protected Options options;
    protected Boolean concurrent;
    protected Integer order;
    @XmlAttribute(name = "type")
    protected String type;

    /**
     * Gets the value of the address property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAddress(String value) {
        this.address = value;
    }

    public boolean isSetAddress() {
        return (this.address!= null);
    }

    /**
     * Gets the value of the username property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the value of the username property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setUsername(String value) {
        this.username = value;
    }

    public boolean isSetUsername() {
        return (this.username!= null);
    }

    /**
     * Gets the value of the password property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setPassword(String value) {
        this.password = value;
    }

    public boolean isSetPassword() {
        return (this.password!= null);
    }

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
     * Gets the value of the concurrent property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getConcurrent() {
        return concurrent;
    }

    /**
     * Sets the value of the concurrent property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setConcurrent(Boolean value) {
        this.concurrent = value;
    }

    public boolean isSetConcurrent() {
        return (this.concurrent!= null);
    }

    /**
     * Gets the value of the order property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getOrder() {
        return order;
    }

    /**
     * Sets the value of the order property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setOrder(Integer value) {
        this.order = value;
    }

    public boolean isSetOrder() {
        return (this.order!= null);
    }

    /**
     * Gets the value of the type property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setType(String value) {
        this.type = value;
    }

    public boolean isSetType() {
        return (this.type!= null);
    }

}

