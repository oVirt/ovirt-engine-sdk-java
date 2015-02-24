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
 * <p>Java class for Label complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Label">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseResource">
 *       &lt;sequence>
 *         &lt;element ref="{}network" minOccurs="0"/>
 *         &lt;element ref="{}host_nic" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Label", propOrder = {
    "network",
    "hostNic"
})
public class Label
    extends BaseResource
{

    protected Network network;
    @XmlElement(name = "host_nic")
    protected HostNIC hostNic;

    /**
     * Gets the value of the network property.
     *
     * @return
     *     possible object is
     *     {@link Network }
     *
     */
    public Network getNetwork() {
        return network;
    }

    /**
     * Sets the value of the network property.
     *
     * @param value
     *     allowed object is
     *     {@link Network }
     *
     */
    public void setNetwork(Network value) {
        this.network = value;
    }

    public boolean isSetNetwork() {
        return (this.network!= null);
    }

    /**
     * Gets the value of the hostNic property.
     *
     * @return
     *     possible object is
     *     {@link HostNIC }
     *
     */
    public HostNIC getHostNic() {
        return hostNic;
    }

    /**
     * Sets the value of the hostNic property.
     *
     * @param value
     *     allowed object is
     *     {@link HostNIC }
     *
     */
    public void setHostNic(HostNIC value) {
        this.hostNic = value;
    }

    public boolean isSetHostNic() {
        return (this.hostNic!= null);
    }

}
