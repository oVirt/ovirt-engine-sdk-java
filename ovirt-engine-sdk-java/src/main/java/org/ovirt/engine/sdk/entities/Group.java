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
 * <p>Java class for Group complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Group">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseResource">
 *       &lt;sequence>
 *         &lt;element ref="{}domain" minOccurs="0"/>
 *         &lt;element name="domain_entry_id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="namespace" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="roles" type="{}Roles" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Group", propOrder = {
    "domain",
    "domainEntryId",
    "namespace",
    "roles"
})
public class Group
    extends BaseResource
{

    protected Domain domain;
    @XmlElement(name = "domain_entry_id")
    protected String domainEntryId;
    protected String namespace;
    protected Roles roles;

    /**
     * Gets the value of the domain property.
     *
     * @return
     *     possible object is
     *     {@link Domain }
     *
     */
    public Domain getDomain() {
        return domain;
    }

    /**
     * Sets the value of the domain property.
     *
     * @param value
     *     allowed object is
     *     {@link Domain }
     *
     */
    public void setDomain(Domain value) {
        this.domain = value;
    }

    public boolean isSetDomain() {
        return (this.domain!= null);
    }

    /**
     * Gets the value of the domainEntryId property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDomainEntryId() {
        return domainEntryId;
    }

    /**
     * Sets the value of the domainEntryId property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDomainEntryId(String value) {
        this.domainEntryId = value;
    }

    public boolean isSetDomainEntryId() {
        return (this.domainEntryId!= null);
    }

    /**
     * Gets the value of the namespace property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getNamespace() {
        return namespace;
    }

    /**
     * Sets the value of the namespace property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setNamespace(String value) {
        this.namespace = value;
    }

    public boolean isSetNamespace() {
        return (this.namespace!= null);
    }

    /**
     * Gets the value of the roles property.
     *
     * @return
     *     possible object is
     *     {@link Roles }
     *
     */
    public Object getRoles() {
        return roles;
    }

    /**
     * Sets the value of the roles property.
     *
     * @param value
     *     allowed object is
     *     {@link Roles }
     *
     */
    public void setRoles(Roles value) {
        this.roles = value;
    }

    public boolean isSetRoles() {
        return (this.roles!= null);
    }

}
