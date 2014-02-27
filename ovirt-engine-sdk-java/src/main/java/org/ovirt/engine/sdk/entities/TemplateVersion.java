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
 * <p>Java class for TemplateVersion complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="TemplateVersion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="base_template" type="{}Template" minOccurs="0"/>
 *         &lt;element name="version_number" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="version_name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TemplateVersion", propOrder = {
    "baseTemplate",
    "versionNumber",
    "versionName"
})
public class TemplateVersion {

    @XmlElement(name = "base_template")
    protected Template baseTemplate;
    @XmlElement(name = "version_number")
    protected Integer versionNumber;
    @XmlElement(name = "version_name")
    protected String versionName;

    /**
     * Gets the value of the baseTemplate property.
     *
     * @return
     *     possible object is
     *     {@link Template }
     *
     */
    public Template getBaseTemplate() {
        return baseTemplate;
    }

    /**
     * Sets the value of the baseTemplate property.
     *
     * @param value
     *     allowed object is
     *     {@link Template }
     *
     */
    public void setBaseTemplate(Template value) {
        this.baseTemplate = value;
    }

    public boolean isSetBaseTemplate() {
        return (this.baseTemplate!= null);
    }

    /**
     * Gets the value of the versionNumber property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getVersionNumber() {
        return versionNumber;
    }

    /**
     * Sets the value of the versionNumber property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setVersionNumber(Integer value) {
        this.versionNumber = value;
    }

    public boolean isSetVersionNumber() {
        return (this.versionNumber!= null);
    }

    /**
     * Gets the value of the versionName property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getVersionName() {
        return versionName;
    }

    /**
     * Sets the value of the versionName property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setVersionName(String value) {
        this.versionName = value;
    }

    public boolean isSetVersionName() {
        return (this.versionName!= null);
    }

}

