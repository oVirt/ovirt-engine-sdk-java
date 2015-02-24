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
 * <p>Java class for GlusterVolumeProfileDetails complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="GlusterVolumeProfileDetails">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseResource">
 *       &lt;sequence>
 *         &lt;element ref="{}brick_profile_details" minOccurs="0"/>
 *         &lt;element ref="{}nfs_profile_details" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GlusterVolumeProfileDetails", propOrder = {
    "brickProfileDetails",
    "nfsProfileDetails"
})
public class GlusterVolumeProfileDetails
    extends BaseResource
{

    @XmlElement(name = "brick_profile_details")
    protected BrickProfileDetails brickProfileDetails;
    @XmlElement(name = "nfs_profile_details")
    protected NfsProfileDetails nfsProfileDetails;

    /**
     * Gets the value of the brickProfileDetails property.
     *
     * @return
     *     possible object is
     *     {@link BrickProfileDetails }
     *
     */
    public BrickProfileDetails getBrickProfileDetails() {
        return brickProfileDetails;
    }

    /**
     * Sets the value of the brickProfileDetails property.
     *
     * @param value
     *     allowed object is
     *     {@link BrickProfileDetails }
     *
     */
    public void setBrickProfileDetails(BrickProfileDetails value) {
        this.brickProfileDetails = value;
    }

    public boolean isSetBrickProfileDetails() {
        return (this.brickProfileDetails!= null);
    }

    /**
     * Gets the value of the nfsProfileDetails property.
     *
     * @return
     *     possible object is
     *     {@link NfsProfileDetails }
     *
     */
    public NfsProfileDetails getNfsProfileDetails() {
        return nfsProfileDetails;
    }

    /**
     * Sets the value of the nfsProfileDetails property.
     *
     * @param value
     *     allowed object is
     *     {@link NfsProfileDetails }
     *
     */
    public void setNfsProfileDetails(NfsProfileDetails value) {
        this.nfsProfileDetails = value;
    }

    public boolean isSetNfsProfileDetails() {
        return (this.nfsProfileDetails!= null);
    }

}

