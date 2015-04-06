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
 * <p>Java class for OpenStackVolumeProvider complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="OpenStackVolumeProvider">
 *   &lt;complexContent>
 *     &lt;extension base="{}OpenStackProvider">
 *       &lt;sequence>
 *         &lt;element ref="{}data_center" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OpenStackVolumeProvider", propOrder = {
    "dataCenter"
})
public class OpenStackVolumeProvider
    extends OpenStackProvider
{

    @XmlElement(name = "data_center")
    protected DataCenter dataCenter;

    /**
     * Gets the value of the dataCenter property.
     *
     * @return
     *     possible object is
     *     {@link DataCenter }
     *
     */
    public DataCenter getDataCenter() {
        return dataCenter;
    }

    /**
     * Sets the value of the dataCenter property.
     *
     * @param value
     *     allowed object is
     *     {@link DataCenter }
     *
     */
    public void setDataCenter(DataCenter value) {
        this.dataCenter = value;
    }

    public boolean isSetDataCenter() {
        return (this.dataCenter!= null);
    }

}
