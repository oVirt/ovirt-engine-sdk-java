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
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Template complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Template">
 *   &lt;complexContent>
 *     &lt;extension base="{}VmBase">
 *       &lt;sequence>
 *         &lt;element ref="{}vm" minOccurs="0"/>
 *         &lt;element name="version" type="{}TemplateVersion" minOccurs="0"/>
 *         &lt;element ref="{}permissions" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Template", propOrder = {
    "vm",
    "version",
    "permissions"
})
@XmlSeeAlso({
    InstanceType.class
})
public class Template
    extends VmBase
{

    protected VM vm;
    protected TemplateVersion version;
    protected Permissions permissions;

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
     * Gets the value of the version property.
     *
     * @return
     *     possible object is
     *     {@link TemplateVersion }
     *
     */
    public TemplateVersion getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     *
     * @param value
     *     allowed object is
     *     {@link TemplateVersion }
     *
     */
    public void setVersion(TemplateVersion value) {
        this.version = value;
    }

    public boolean isSetVersion() {
        return (this.version!= null);
    }

    /**
     * Gets the value of the permissions property.
     *
     * @return
     *     possible object is
     *     {@link Permissions }
     *
     */
    public Object getPermissions() {
        return permissions;
    }

    /**
     * Sets the value of the permissions property.
     *
     * @param value
     *     allowed object is
     *     {@link Permissions }
     *
     */
    public void setPermissions(Permissions value) {
        this.permissions = value;
    }

    public boolean isSetPermissions() {
        return (this.permissions!= null);
    }

}
