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
 * <p>Java class for Request complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="http_method" type="{}HttpMethod"/>
 *         &lt;element ref="{}headers" minOccurs="0"/>
 *         &lt;element ref="{}url" minOccurs="0"/>
 *         &lt;element ref="{}body" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Request", propOrder = {
    "httpMethod",
    "headers",
    "url",
    "body"
})
public class Request {

    @XmlElement(name = "http_method", required = true)
    protected HttpMethod httpMethod;
    protected Headers headers;
    protected Url url;
    protected Body body;

    /**
     * Gets the value of the httpMethod property.
     *
     * @return
     *     possible object is
     *     {@link HttpMethod }
     *
     */
    public HttpMethod getHttpMethod() {
        return httpMethod;
    }

    /**
     * Sets the value of the httpMethod property.
     *
     * @param value
     *     allowed object is
     *     {@link HttpMethod }
     *
     */
    public void setHttpMethod(HttpMethod value) {
        this.httpMethod = value;
    }

    public boolean isSetHttpMethod() {
        return (this.httpMethod!= null);
    }

    /**
     * Gets the value of the headers property.
     *
     * @return
     *     possible object is
     *     {@link Headers }
     *
     */
    public Headers getHeaders() {
        return headers;
    }

    /**
     * Sets the value of the headers property.
     *
     * @param value
     *     allowed object is
     *     {@link Headers }
     *
     */
    public void setHeaders(Headers value) {
        this.headers = value;
    }

    public boolean isSetHeaders() {
        return (this.headers!= null);
    }

    /**
     * Gets the value of the url property.
     *
     * @return
     *     possible object is
     *     {@link Url }
     *
     */
    public Url getUrl() {
        return url;
    }

    /**
     * Sets the value of the url property.
     *
     * @param value
     *     allowed object is
     *     {@link Url }
     *
     */
    public void setUrl(Url value) {
        this.url = value;
    }

    public boolean isSetUrl() {
        return (this.url!= null);
    }

    /**
     * Gets the value of the body property.
     *
     * @return
     *     possible object is
     *     {@link Body }
     *
     */
    public Body getBody() {
        return body;
    }

    /**
     * Sets the value of the body property.
     *
     * @param value
     *     allowed object is
     *     {@link Body }
     *
     */
    public void setBody(Body value) {
        this.body = value;
    }

    public boolean isSetBody() {
        return (this.body!= null);
    }

}

