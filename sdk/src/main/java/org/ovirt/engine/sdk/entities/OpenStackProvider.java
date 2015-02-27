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
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OpenStackProvider complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="OpenStackProvider">
 *   &lt;complexContent>
 *     &lt;extension base="{}ExternalProvider">
 *       &lt;sequence>
 *         &lt;element name="tenant_name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OpenStackProvider", propOrder = {
    "tenantName"
})
@XmlSeeAlso({
    OpenStackImageProvider.class,
    OpenStackNetworkProvider.class
})
public class OpenStackProvider
    extends ExternalProvider
{

    @XmlElement(name = "tenant_name", required = true)
    protected String tenantName;

    /**
     * Gets the value of the tenantName property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getTenantName() {
        return tenantName;
    }

    /**
     * Sets the value of the tenantName property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTenantName(String value) {
        this.tenantName = value;
    }

    public boolean isSetTenantName() {
        return (this.tenantName!= null);
    }

}
