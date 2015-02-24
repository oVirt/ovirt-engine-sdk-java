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
 * <p>Java class for Permit complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Permit">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseResource">
 *       &lt;sequence>
 *         &lt;element name="administrative" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="role" type="{}Role" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Permit", propOrder = {
    "administrative",
    "role"
})
public class Permit
    extends BaseResource
{

    protected boolean administrative;
    protected Role role;

    /**
     * Gets the value of the administrative property.
     *
     */
    public boolean isAdministrative() {
        return administrative;
    }

    /**
     * Sets the value of the administrative property.
     *
     */
    public void setAdministrative(boolean value) {
        this.administrative = value;
    }

    public boolean isSetAdministrative() {
        return true;
    }

    /**
     * Gets the value of the role property.
     *
     * @return
     *     possible object is
     *     {@link Role }
     *
     */
    public Role getRole() {
        return role;
    }

    /**
     * Sets the value of the role property.
     *
     * @param value
     *     allowed object is
     *     {@link Role }
     *
     */
    public void setRole(Role value) {
        this.role = value;
    }

    public boolean isSetRole() {
        return (this.role!= null);
    }

}
