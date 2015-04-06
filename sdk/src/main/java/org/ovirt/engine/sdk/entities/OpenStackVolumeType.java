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
 * <p>Java class for OpenStackVolumeType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="OpenStackVolumeType">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseResource">
 *       &lt;sequence>
 *         &lt;element ref="{}properties" minOccurs="0"/>
 *         &lt;element ref="{}openstack_volume_provider" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OpenStackVolumeType", propOrder = {
    "properties",
    "openstackVolumeProvider"
})
public class OpenStackVolumeType
    extends BaseResource
{

    protected Properties properties;
    @XmlElement(name = "openstack_volume_provider")
    protected OpenStackVolumeProvider openstackVolumeProvider;

    /**
     * Gets the value of the properties property.
     *
     * @return
     *     possible object is
     *     {@link Properties }
     *
     */
    public Properties getProperties() {
        return properties;
    }

    /**
     * Sets the value of the properties property.
     *
     * @param value
     *     allowed object is
     *     {@link Properties }
     *
     */
    public void setProperties(Properties value) {
        this.properties = value;
    }

    public boolean isSetProperties() {
        return (this.properties!= null);
    }

    /**
     * Gets the value of the openstackVolumeProvider property.
     *
     * @return
     *     possible object is
     *     {@link OpenStackVolumeProvider }
     *
     */
    public OpenStackVolumeProvider getOpenstackVolumeProvider() {
        return openstackVolumeProvider;
    }

    /**
     * Sets the value of the openstackVolumeProvider property.
     *
     * @param value
     *     allowed object is
     *     {@link OpenStackVolumeProvider }
     *
     */
    public void setOpenstackVolumeProvider(OpenStackVolumeProvider value) {
        this.openstackVolumeProvider = value;
    }

    public boolean isSetOpenstackVolumeProvider() {
        return (this.openstackVolumeProvider!= null);
    }

}
