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
 * <p>Java class for Hook complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Hook">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseResource">
 *       &lt;sequence>
 *         &lt;element name="event_name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="md5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element ref="{}host" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Hook", propOrder = {
    "eventName",
    "md5",
    "host"
})
public class Hook
    extends BaseResource
{

    @XmlElement(name = "event_name")
    protected String eventName;
    protected String md5;
    protected Host host;

    /**
     * Gets the value of the eventName property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getEventName() {
        return eventName;
    }

    /**
     * Sets the value of the eventName property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setEventName(String value) {
        this.eventName = value;
    }

    public boolean isSetEventName() {
        return (this.eventName!= null);
    }

    /**
     * Gets the value of the md5 property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getMd5() {
        return md5;
    }

    /**
     * Sets the value of the md5 property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setMd5(String value) {
        this.md5 = value;
    }

    public boolean isSetMd5() {
        return (this.md5 != null);
    }

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

}
