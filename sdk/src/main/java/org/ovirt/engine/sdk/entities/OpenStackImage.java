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
 * <p>Java class for OpenStackImage complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="OpenStackImage">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseResource">
 *       &lt;sequence>
 *         &lt;element ref="{}openstack_image_provider" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OpenStackImage", propOrder = {
    "openstackImageProvider"
})
public class OpenStackImage
    extends BaseResource
{

    @XmlElement(name = "openstack_image_provider")
    protected OpenStackImageProvider openstackImageProvider;

    /**
     * Gets the value of the openstackImageProvider property.
     *
     * @return
     *     possible object is
     *     {@link OpenStackImageProvider }
     *
     */
    public OpenStackImageProvider getOpenstackImageProvider() {
        return openstackImageProvider;
    }

    /**
     * Sets the value of the openstackImageProvider property.
     *
     * @param value
     *     allowed object is
     *     {@link OpenStackImageProvider }
     *
     */
    public void setOpenstackImageProvider(OpenStackImageProvider value) {
        this.openstackImageProvider = value;
    }

    public boolean isSetOpenstackImageProvider() {
        return (this.openstackImageProvider!= null);
    }

}
