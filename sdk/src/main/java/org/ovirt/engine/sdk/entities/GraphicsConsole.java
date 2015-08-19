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
 * <p>Java class for GraphicsConsole complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="GraphicsConsole">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseResource">
 *       &lt;sequence>
 *         &lt;element ref="{}vm" minOccurs="0"/>
 *         &lt;element ref="{}template" minOccurs="0"/>
 *         &lt;element ref="{}instance_type" minOccurs="0"/>
 *         &lt;element name="protocol" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="port" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="tls_port" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="address" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GraphicsConsole", propOrder = {
    "vm",
    "template",
    "instanceType",
    "protocol",
    "port",
    "tlsPort",
    "address"
})
public class GraphicsConsole
    extends BaseResource
{

    protected VM vm;
    protected Template template;
    @XmlElement(name = "instance_type")
    protected InstanceType instanceType;
    protected String protocol;
    protected Integer port;
    @XmlElement(name = "tls_port")
    protected Integer tlsPort;
    protected String address;

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
     * Gets the value of the instanceType property.
     *
     * @return
     *     possible object is
     *     {@link InstanceType }
     *
     */
    public InstanceType getInstanceType() {
        return instanceType;
    }

    /**
     * Sets the value of the instanceType property.
     *
     * @param value
     *     allowed object is
     *     {@link InstanceType }
     *
     */
    public void setInstanceType(InstanceType value) {
        this.instanceType = value;
    }

    public boolean isSetInstanceType() {
        return (this.instanceType!= null);
    }

    /**
     * Gets the value of the protocol property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getProtocol() {
        return protocol;
    }

    /**
     * Sets the value of the protocol property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setProtocol(String value) {
        this.protocol = value;
    }

    public boolean isSetProtocol() {
        return (this.protocol!= null);
    }

    /**
     * Gets the value of the port property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getPort() {
        return port;
    }

    /**
     * Sets the value of the port property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setPort(Integer value) {
        this.port = value;
    }

    public boolean isSetPort() {
        return (this.port!= null);
    }

    /**
     * Gets the value of the tlsPort property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getTlsPort() {
        return tlsPort;
    }

    /**
     * Sets the value of the tlsPort property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setTlsPort(Integer value) {
        this.tlsPort = value;
    }

    public boolean isSetTlsPort() {
        return (this.tlsPort!= null);
    }

    /**
     * Gets the value of the address property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAddress(String value) {
        this.address = value;
    }

    public boolean isSetAddress() {
        return (this.address!= null);
    }

}
