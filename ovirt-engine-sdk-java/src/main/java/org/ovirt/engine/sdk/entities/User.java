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
 * <p>Java class for User complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="User">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseResource">
 *       &lt;sequence>
 *         &lt;element ref="{}domain" minOccurs="0"/>
 *         &lt;element name="domain_entry_id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="department" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="logged_in" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="namespace" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="last_name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="user_name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="principal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="roles" type="{}Roles" minOccurs="0"/>
 *         &lt;element ref="{}groups" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "User", propOrder = {
    "domain",
    "domainEntryId",
    "department",
    "loggedIn",
    "namespace",
    "lastName",
    "userName",
    "principal",
    "password",
    "email",
    "roles",
    "groups"
})
public class User
    extends BaseResource
{

    protected Domain domain;
    @XmlElement(name = "domain_entry_id")
    protected String domainEntryId;
    protected String department;
    @XmlElement(name = "logged_in")
    protected Boolean loggedIn;
    protected String namespace;
    @XmlElement(name = "last_name")
    protected String lastName;
    @XmlElement(name = "user_name")
    protected String userName;
    protected String principal;
    protected String password;
    protected String email;
    protected Roles roles;
    protected Groups groups;

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
     * Gets the value of the department property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Sets the value of the department property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDepartment(String value) {
        this.department = value;
    }

    public boolean isSetDepartment() {
        return (this.department!= null);
    }

    /**
     * Gets the value of the loggedIn property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getLoggedIn() {
        return loggedIn;
    }

    /**
     * Sets the value of the loggedIn property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setLoggedIn(Boolean value) {
        this.loggedIn = value;
    }

    public boolean isSetLoggedIn() {
        return (this.loggedIn!= null);
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
     * Gets the value of the lastName property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the value of the lastName property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setLastName(String value) {
        this.lastName = value;
    }

    public boolean isSetLastName() {
        return (this.lastName!= null);
    }

    /**
     * Gets the value of the userName property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the value of the userName property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setUserName(String value) {
        this.userName = value;
    }

    public boolean isSetUserName() {
        return (this.userName!= null);
    }

    /**
     * Gets the value of the principal property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getPrincipal() {
        return principal;
    }

    /**
     * Sets the value of the principal property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setPrincipal(String value) {
        this.principal = value;
    }

    public boolean isSetPrincipal() {
        return (this.principal!= null);
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
     * Gets the value of the email property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setEmail(String value) {
        this.email = value;
    }

    public boolean isSetEmail() {
        return (this.email!= null);
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

    /**
     * Gets the value of the groups property.
     *
     * @return
     *     possible object is
     *     {@link Groups }
     *
     */
    public Groups getGroups() {
        return groups;
    }

    /**
     * Sets the value of the groups property.
     *
     * @param value
     *     allowed object is
     *     {@link Groups }
     *
     */
    public void setGroups(Groups value) {
        this.groups = value;
    }

    public boolean isSetGroups() {
        return (this.groups!= null);
    }

}
