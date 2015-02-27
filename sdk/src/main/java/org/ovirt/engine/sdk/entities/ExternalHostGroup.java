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
 * <p>Java class for ExternalHostGroup complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ExternalHostGroup">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseResource">
 *       &lt;sequence>
 *         &lt;element name="architecture_name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="operating_system_name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="domain_name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="subnet_name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "ExternalHostGroup", propOrder = {
    "architectureName",
    "operatingSystemName",
    "domainName",
    "subnetName",
    "externalHostProvider"
})
public class ExternalHostGroup
    extends BaseResource
{

    @XmlElement(name = "architecture_name")
    protected String architectureName;
    @XmlElement(name = "operating_system_name")
    protected String operatingSystemName;
    @XmlElement(name = "domain_name")
    protected String domainName;
    @XmlElement(name = "subnet_name")
    protected String subnetName;
    @XmlElement(name = "external_host_provider")
    protected ExternalHostProvider externalHostProvider;

    /**
     * Gets the value of the architectureName property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getArchitectureName() {
        return architectureName;
    }

    /**
     * Sets the value of the architectureName property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setArchitectureName(String value) {
        this.architectureName = value;
    }

    public boolean isSetArchitectureName() {
        return (this.architectureName!= null);
    }

    /**
     * Gets the value of the operatingSystemName property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getOperatingSystemName() {
        return operatingSystemName;
    }

    /**
     * Sets the value of the operatingSystemName property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setOperatingSystemName(String value) {
        this.operatingSystemName = value;
    }

    public boolean isSetOperatingSystemName() {
        return (this.operatingSystemName!= null);
    }

    /**
     * Gets the value of the domainName property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDomainName() {
        return domainName;
    }

    /**
     * Sets the value of the domainName property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDomainName(String value) {
        this.domainName = value;
    }

    public boolean isSetDomainName() {
        return (this.domainName!= null);
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
