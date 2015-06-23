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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for OpenstackVolumeAuthenticationKey complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="OpenstackVolumeAuthenticationKey">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseResource">
 *       &lt;sequence>
 *         &lt;element name="uuid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="usage_type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="creation_date" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element ref="{}openstack_volume_provider" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OpenstackVolumeAuthenticationKey", propOrder = {
    "uuid",
    "value",
    "usageType",
    "creationDate",
    "openstackVolumeProvider"
})
public class OpenstackVolumeAuthenticationKey
    extends BaseResource
{

    protected String uuid;
    protected String value;
    @XmlElement(name = "usage_type")
    protected String usageType;
    @XmlElement(name = "creation_date")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar creationDate;
    @XmlElement(name = "openstack_volume_provider")
    protected OpenStackVolumeProvider openstackVolumeProvider;

    /**
     * Gets the value of the uuid property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * Sets the value of the uuid property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setUuid(String value) {
        this.uuid = value;
    }

    public boolean isSetUuid() {
        return (this.uuid!= null);
    }

    /**
     * Gets the value of the value property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setValue(String value) {
        this.value = value;
    }

    public boolean isSetValue() {
        return (this.value!= null);
    }

    /**
     * Gets the value of the usageType property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getUsageType() {
        return usageType;
    }

    /**
     * Sets the value of the usageType property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setUsageType(String value) {
        this.usageType = value;
    }

    public boolean isSetUsageType() {
        return (this.usageType!= null);
    }

    /**
     * Gets the value of the creationDate property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getCreationDate() {
        return creationDate;
    }

    /**
     * Sets the value of the creationDate property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setCreationDate(XMLGregorianCalendar value) {
        this.creationDate = value;
    }

    public boolean isSetCreationDate() {
        return (this.creationDate!= null);
    }

    /**
     * Gets the value of the openstackVolumeProvider property.
     *
     * @return
     *     possible object is
     *     {@link OpenStackVolumeProvider }
     *
     */
    public OpenStackVolumeProvider getOpenstackVolumeProvider() {
        return openstackVolumeProvider;
    }

    /**
     * Sets the value of the openstackVolumeProvider property.
     *
     * @param value
     *     allowed object is
     *     {@link OpenStackVolumeProvider }
     *
     */
    public void setOpenstackVolumeProvider(OpenStackVolumeProvider value) {
        this.openstackVolumeProvider = value;
    }

    public boolean isSetOpenstackVolumeProvider() {
        return (this.openstackVolumeProvider!= null);
    }

}
