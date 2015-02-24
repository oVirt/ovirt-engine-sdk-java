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
 * <p>Java class for Role complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Role">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseResource">
 *       &lt;sequence>
 *         &lt;element name="mutable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="administrative" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="user" type="{}User" minOccurs="0"/>
 *         &lt;element name="permits" type="{}Permits" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Role", propOrder = {
    "mutable",
    "administrative",
    "user",
    "permits"
})
public class Role
    extends BaseResource
{

    protected Boolean mutable;
    protected Boolean administrative;
    protected User user;
    protected Permits permits;

    /**
     * Gets the value of the mutable property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getMutable() {
        return mutable;
    }

    /**
     * Sets the value of the mutable property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setMutable(Boolean value) {
        this.mutable = value;
    }

    public boolean isSetMutable() {
        return (this.mutable!= null);
    }

    /**
     * Gets the value of the administrative property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getAdministrative() {
        return administrative;
    }

    /**
     * Sets the value of the administrative property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setAdministrative(Boolean value) {
        this.administrative = value;
    }

    public boolean isSetAdministrative() {
        return (this.administrative!= null);
    }

    /**
     * Gets the value of the user property.
     *
     * @return
     *     possible object is
     *     {@link User }
     *
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the value of the user property.
     *
     * @param value
     *     allowed object is
     *     {@link User }
     *
     */
    public void setUser(User value) {
        this.user = value;
    }

    public boolean isSetUser() {
        return (this.user!= null);
    }

    /**
     * Gets the value of the permits property.
     *
     * @return
     *     possible object is
     *     {@link Permits }
     *
     */
    public Object getPermits() {
        return permits;
    }

    /**
     * Sets the value of the permits property.
     *
     * @param value
     *     allowed object is
     *     {@link Permits }
     *
     */
    public void setPermits(Permits value) {
        this.permits = value;
    }

    public boolean isSetPermits() {
        return (this.permits!= null);
    }

}
