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
 * <p>Java class for ExternalDiscoveredHost complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ExternalDiscoveredHost">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseResource">
 *       &lt;sequence>
 *         &lt;element name="ip" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mac" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="subnet_name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="last_report" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element ref="{}external_host_provider" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExternalDiscoveredHost", propOrder = {
    "ip",
    "mac",
    "subnetName",
    "lastReport",
    "externalHostProvider"
})
public class ExternalDiscoveredHost
    extends BaseResource
{

    protected String ip;
    protected String mac;
    @XmlElement(name = "subnet_name")
    protected String subnetName;
    @XmlElement(name = "last_report")
    protected String lastReport;
    @XmlElement(name = "external_host_provider")
    protected ExternalHostProvider externalHostProvider;

    /**
     * Gets the value of the ip property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getIp() {
        return ip;
    }

    /**
     * Sets the value of the ip property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setIp(String value) {
        this.ip = value;
    }

    public boolean isSetIp() {
        return (this.ip!= null);
    }

    /**
     * Gets the value of the mac property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getMac() {
        return mac;
    }

    /**
     * Sets the value of the mac property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setMac(String value) {
        this.mac = value;
    }

    public boolean isSetMac() {
        return (this.mac!= null);
    }

    /**
     * Gets the value of the subnetName property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSubnetName() {
        return subnetName;
    }

    /**
     * Sets the value of the subnetName property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSubnetName(String value) {
        this.subnetName = value;
    }

    public boolean isSetSubnetName() {
        return (this.subnetName!= null);
    }

    /**
     * Gets the value of the lastReport property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getLastReport() {
        return lastReport;
    }

    /**
     * Sets the value of the lastReport property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setLastReport(String value) {
        this.lastReport = value;
    }

    public boolean isSetLastReport() {
        return (this.lastReport!= null);
    }

    /**
     * Gets the value of the externalHostProvider property.
     *
     * @return
     *     possible object is
     *     {@link ExternalHostProvider }
     *
     */
    public ExternalHostProvider getExternalHostProvider() {
        return externalHostProvider;
    }

    /**
     * Sets the value of the externalHostProvider property.
     *
     * @param value
     *     allowed object is
     *     {@link ExternalHostProvider }
     *
     */
    public void setExternalHostProvider(ExternalHostProvider value) {
        this.externalHostProvider = value;
    }

    public boolean isSetExternalHostProvider() {
        return (this.externalHostProvider!= null);
    }

}
