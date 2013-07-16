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
 * <p>Java class for API complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="API">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseResource">
 *       &lt;sequence>
 *         &lt;element ref="{}special_objects" minOccurs="0"/>
 *         &lt;element ref="{}product_info" minOccurs="0"/>
 *         &lt;element ref="{}summary" minOccurs="0"/>
 *         &lt;element name="time" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "API", propOrder = {
    "specialObjects",
    "productInfo",
    "summary",
    "time"
})
public class API
    extends BaseResource
{

    @XmlElement(name = "special_objects")
    protected SpecialObjects specialObjects;
    @XmlElement(name = "product_info")
    protected ProductInfo productInfo;
    protected ApiSummary summary;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar time;

    /**
     * Gets the value of the specialObjects property.
     *
     * @return
     *     possible object is
     *     {@link SpecialObjects }
     *
     */
    public SpecialObjects getSpecialObjects() {
        return specialObjects;
    }

    /**
     * Sets the value of the specialObjects property.
     *
     * @param value
     *     allowed object is
     *     {@link SpecialObjects }
     *
     */
    public void setSpecialObjects(SpecialObjects value) {
        this.specialObjects = value;
    }

    public boolean isSetSpecialObjects() {
        return (this.specialObjects!= null);
    }

    /**
     * Gets the value of the productInfo property.
     *
     * @return
     *     possible object is
     *     {@link ProductInfo }
     *
     */
    public ProductInfo getProductInfo() {
        return productInfo;
    }

    /**
     * Sets the value of the productInfo property.
     *
     * @param value
     *     allowed object is
     *     {@link ProductInfo }
     *
     */
    public void setProductInfo(ProductInfo value) {
        this.productInfo = value;
    }

    public boolean isSetProductInfo() {
        return (this.productInfo!= null);
    }

    /**
     * Gets the value of the summary property.
     *
     * @return
     *     possible object is
     *     {@link ApiSummary }
     *
     */
    public ApiSummary getSummary() {
        return summary;
    }

    /**
     * Sets the value of the summary property.
     *
     * @param value
     *     allowed object is
     *     {@link ApiSummary }
     *
     */
    public void setSummary(ApiSummary value) {
        this.summary = value;
    }

    public boolean isSetSummary() {
        return (this.summary!= null);
    }

    /**
     * Gets the value of the time property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getTime() {
        return time;
    }

    /**
     * Sets the value of the time property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setTime(XMLGregorianCalendar value) {
        this.time = value;
    }

    public boolean isSetTime() {
        return (this.time!= null);
    }

}
