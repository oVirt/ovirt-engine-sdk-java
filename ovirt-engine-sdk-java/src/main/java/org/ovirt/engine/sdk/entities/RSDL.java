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
 * <p>Java class for RSDL complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="RSDL">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="version" type="{}Version" minOccurs="0"/>
 *         &lt;element ref="{}schema" minOccurs="0"/>
 *         &lt;element name="general" type="{}GeneralMetadata" minOccurs="0"/>
 *         &lt;element name="links" type="{}DetailedLinks" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="href" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="rel" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RSDL", propOrder = {
    "description",
    "version",
    "schema",
    "general",
    "links"
})
public class RSDL {

    protected String description;
    protected Version version;
    protected Schema schema;
    protected GeneralMetadata general;
    protected DetailedLinks links;
    @XmlAttribute(name = "href")
    protected String href;
    @XmlAttribute(name = "rel")
    protected String rel;

    /**
     * Gets the value of the description property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDescription(String value) {
        this.description = value;
    }

    public boolean isSetDescription() {
        return (this.description!= null);
    }

    /**
     * Gets the value of the version property.
     *
     * @return
     *     possible object is
     *     {@link Version }
     *
     */
    public Version getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     *
     * @param value
     *     allowed object is
     *     {@link Version }
     *
     */
    public void setVersion(Version value) {
        this.version = value;
    }

    public boolean isSetVersion() {
        return (this.version!= null);
    }

    /**
     * Gets the value of the schema property.
     *
     * @return
     *     possible object is
     *     {@link Schema }
     *
     */
    public Schema getSchema() {
        return schema;
    }

    /**
     * Sets the value of the schema property.
     *
     * @param value
     *     allowed object is
     *     {@link Schema }
     *
     */
    public void setSchema(Schema value) {
        this.schema = value;
    }

    public boolean isSetSchema() {
        return (this.schema!= null);
    }

    /**
     * Gets the value of the general property.
     *
     * @return
     *     possible object is
     *     {@link GeneralMetadata }
     *
     */
    public GeneralMetadata getGeneral() {
        return general;
    }

    /**
     * Sets the value of the general property.
     *
     * @param value
     *     allowed object is
     *     {@link GeneralMetadata }
     *
     */
    public void setGeneral(GeneralMetadata value) {
        this.general = value;
    }

    public boolean isSetGeneral() {
        return (this.general!= null);
    }

    /**
     * Gets the value of the links property.
     *
     * @return
     *     possible object is
     *     {@link DetailedLinks }
     *
     */
    public DetailedLinks getLinks() {
        return links;
    }

    /**
     * Sets the value of the links property.
     *
     * @param value
     *     allowed object is
     *     {@link DetailedLinks }
     *
     */
    public void setLinks(DetailedLinks value) {
        this.links = value;
    }

    public boolean isSetLinks() {
        return (this.links!= null);
    }

    /**
     * Gets the value of the href property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getHref() {
        return href;
    }

    /**
     * Sets the value of the href property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setHref(String value) {
        this.href = value;
    }

    public boolean isSetHref() {
        return (this.href!= null);
    }

    /**
     * Gets the value of the rel property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getRel() {
        return rel;
    }

    /**
     * Sets the value of the rel property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setRel(String value) {
        this.rel = value;
    }

    public boolean isSetRel() {
        return (this.rel!= null);
    }

}

