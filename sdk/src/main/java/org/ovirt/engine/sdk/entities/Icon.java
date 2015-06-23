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
 * <p>Java class for Icon complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Icon">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseResource">
 *       &lt;sequence>
 *         &lt;element name="media_type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="data" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icon", propOrder = {
    "mediaType",
    "data"
})
public class Icon
    extends BaseResource
{

    @XmlElement(name = "media_type")
    protected String mediaType;
    protected String data;

    /**
     * Gets the value of the mediaType property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getMediaType() {
        return mediaType;
    }

    /**
     * Sets the value of the mediaType property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setMediaType(String value) {
        this.mediaType = value;
    }

    public boolean isSetMediaType() {
        return (this.mediaType!= null);
    }

    /**
     * Gets the value of the data property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getData() {
        return data;
    }

    /**
     * Sets the value of the data property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setData(String value) {
        this.data = value;
    }

    public boolean isSetData() {
        return (this.data!= null);
    }

}
