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
 * <p>Java class for GlusterServerHook complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="GlusterServerHook">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseResource">
 *       &lt;sequence>
 *         &lt;element ref="{}host" minOccurs="0"/>
 *         &lt;element name="content_type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element ref="{}status" minOccurs="0"/>
 *         &lt;element name="checksum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GlusterServerHook", propOrder = {
    "host",
    "contentType",
    "status",
    "checksum"
})
public class GlusterServerHook
    extends BaseResource
{

    protected Host host;
    @XmlElement(name = "content_type")
    protected String contentType;
    protected Status status;
    protected String checksum;

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
     * Gets the value of the contentType property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getContentType() {
        return contentType;
    }

    /**
     * Sets the value of the contentType property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setContentType(String value) {
        this.contentType = value;
    }

    public boolean isSetContentType() {
        return (this.contentType!= null);
    }

    /**
     * Gets the value of the status property.
     *
     * @return
     *     possible object is
     *     {@link Status }
     *
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     *
     * @param value
     *     allowed object is
     *     {@link Status }
     *
     */
    public void setStatus(Status value) {
        this.status = value;
    }

    public boolean isSetStatus() {
        return (this.status!= null);
    }

    /**
     * Gets the value of the checksum property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getChecksum() {
        return checksum;
    }

    /**
     * Sets the value of the checksum property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setChecksum(String value) {
        this.checksum = value;
    }

    public boolean isSetChecksum() {
        return (this.checksum!= null);
    }

}

