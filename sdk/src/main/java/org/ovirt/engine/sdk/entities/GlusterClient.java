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
 * <p>Java class for GlusterClient complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="GlusterClient">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="host_name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="client_port" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="bytes_read" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="bytes_written" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GlusterClient", propOrder = {
    "hostName",
    "clientPort",
    "bytesRead",
    "bytesWritten"
})
public class GlusterClient {

    @XmlElement(name = "host_name")
    protected String hostName;
    @XmlElement(name = "client_port")
    protected Integer clientPort;
    @XmlElement(name = "bytes_read")
    protected Long bytesRead;
    @XmlElement(name = "bytes_written")
    protected Long bytesWritten;

    /**
     * Gets the value of the hostName property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getHostName() {
        return hostName;
    }

    /**
     * Sets the value of the hostName property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setHostName(String value) {
        this.hostName = value;
    }

    public boolean isSetHostName() {
        return (this.hostName!= null);
    }

    /**
     * Gets the value of the clientPort property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getClientPort() {
        return clientPort;
    }

    /**
     * Sets the value of the clientPort property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setClientPort(Integer value) {
        this.clientPort = value;
    }

    public boolean isSetClientPort() {
        return (this.clientPort!= null);
    }

    /**
     * Gets the value of the bytesRead property.
     *
     * @return
     *     possible object is
     *     {@link Long }
     *
     */
    public Long getBytesRead() {
        return bytesRead;
    }

    /**
     * Sets the value of the bytesRead property.
     *
     * @param value
     *     allowed object is
     *     {@link Long }
     *
     */
    public void setBytesRead(Long value) {
        this.bytesRead = value;
    }

    public boolean isSetBytesRead() {
        return (this.bytesRead!= null);
    }

    /**
     * Gets the value of the bytesWritten property.
     *
     * @return
     *     possible object is
     *     {@link Long }
     *
     */
    public Long getBytesWritten() {
        return bytesWritten;
    }

    /**
     * Sets the value of the bytesWritten property.
     *
     * @param value
     *     allowed object is
     *     {@link Long }
     *
     */
    public void setBytesWritten(Long value) {
        this.bytesWritten = value;
    }

    public boolean isSetBytesWritten() {
        return (this.bytesWritten!= null);
    }

}

