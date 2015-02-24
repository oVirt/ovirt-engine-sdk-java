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
 * <p>Java class for Tag complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Tag">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseResource">
 *       &lt;sequence>
 *         &lt;element ref="{}host" minOccurs="0"/>
 *         &lt;element ref="{}vm" minOccurs="0"/>
 *         &lt;element ref="{}template" minOccurs="0"/>
 *         &lt;element ref="{}user" minOccurs="0"/>
 *         &lt;element ref="{}group" minOccurs="0"/>
 *         &lt;element name="parent" type="{}TagParent" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Tag", propOrder = {
    "host",
    "vm",
    "template",
    "user",
    "group",
    "parent"
})
public class Tag
    extends BaseResource
{

    protected Host host;
    protected VM vm;
    protected Template template;
    protected User user;
    protected Group group;
    protected TagParent parent;

    /**
     * Gets the value of the host property.
     *
     * @return
     *     possible object is
     *     {@link Host }
     *
     */
    public Host getHost() {
        return host;
    }

    /**
     * Sets the value of the host property.
     *
     * @param value
     *     allowed object is
     *     {@link Host }
     *
     */
    public void setHost(Host value) {
        this.host = value;
    }

    public boolean isSetHost() {
        return (this.host!= null);
    }

    /**
     * Gets the value of the vm property.
     *
     * @return
     *     possible object is
     *     {@link VM }
     *
     */
    public VM getVm() {
        return vm;
    }

    /**
     * Sets the value of the vm property.
     *
     * @param value
     *     allowed object is
     *     {@link VM }
     *
     */
    public void setVm(VM value) {
        this.vm = value;
    }

    public boolean isSetVm() {
        return (this.vm!= null);
    }

    /**
     * Gets the value of the template property.
     *
     * @return
     *     possible object is
     *     {@link Template }
     *
     */
    public Template getTemplate() {
        return template;
    }

    /**
     * Sets the value of the template property.
     *
     * @param value
     *     allowed object is
     *     {@link Template }
     *
     */
    public void setTemplate(Template value) {
        this.template = value;
    }

    public boolean isSetTemplate() {
        return (this.template!= null);
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
     * Gets the value of the group property.
     *
     * @return
     *     possible object is
     *     {@link Group }
     *
     */
    public Group getGroup() {
        return group;
    }

    /**
     * Sets the value of the group property.
     *
     * @param value
     *     allowed object is
     *     {@link Group }
     *
     */
    public void setGroup(Group value) {
        this.group = value;
    }

    public boolean isSetGroup() {
        return (this.group!= null);
    }

    /**
     * Gets the value of the parent property.
     *
     * @return
     *     possible object is
     *     {@link TagParent }
     *
     */
    public TagParent getParent() {
        return parent;
    }

    /**
     * Sets the value of the parent property.
     *
     * @param value
     *     allowed object is
     *     {@link TagParent }
     *
     */
    public void setParent(TagParent value) {
        this.parent = value;
    }

    public boolean isSetParent() {
        return (this.parent!= null);
    }

}
