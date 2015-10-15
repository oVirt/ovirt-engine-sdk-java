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
 * <p>Java class for ProfileDetail complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ProfileDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="profile_type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="duration" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element ref="{}statistics" minOccurs="0"/>
 *         &lt;element ref="{}block_statistics" minOccurs="0"/>
 *         &lt;element ref="{}fop_statistics" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProfileDetail", propOrder = {
    "profileType",
    "duration",
    "statistics",
    "blockStatistics",
    "fopStatistics"
})
public class ProfileDetail {

    @XmlElement(name = "profile_type", required = true)
    protected String profileType;
    protected Integer duration;
    protected Statistics statistics;
    @XmlElement(name = "block_statistics")
    protected BlockStatistics blockStatistics;
    @XmlElement(name = "fop_statistics")
    protected FopStatistics fopStatistics;

    /**
     * Gets the value of the profileType property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getProfileType() {
        return profileType;
    }

    /**
     * Sets the value of the profileType property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setProfileType(String value) {
        this.profileType = value;
    }

    public boolean isSetProfileType() {
        return (this.profileType!= null);
    }

    /**
     * Gets the value of the duration property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getDuration() {
        return duration;
    }

    /**
     * Sets the value of the duration property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setDuration(Integer value) {
        this.duration = value;
    }

    public boolean isSetDuration() {
        return (this.duration!= null);
    }

    /**
     * Gets the value of the statistics property.
     *
     * @return
     *     possible object is
     *     {@link Statistics }
     *
     */
    public Statistics getStatistics() {
        return statistics;
    }

    /**
     * Sets the value of the statistics property.
     *
     * @param value
     *     allowed object is
     *     {@link Statistics }
     *
     */
    public void setStatistics(Statistics value) {
        this.statistics = value;
    }

    public boolean isSetStatistics() {
        return (this.statistics!= null);
    }

    /**
     * Gets the value of the blockStatistics property.
     *
     * @return
     *     possible object is
     *     {@link BlockStatistics }
     *
     */
    public BlockStatistics getBlockStatistics() {
        return blockStatistics;
    }

    /**
     * Sets the value of the blockStatistics property.
     *
     * @param value
     *     allowed object is
     *     {@link BlockStatistics }
     *
     */
    public void setBlockStatistics(BlockStatistics value) {
        this.blockStatistics = value;
    }

    public boolean isSetBlockStatistics() {
        return (this.blockStatistics!= null);
    }

    /**
     * Gets the value of the fopStatistics property.
     *
     * @return
     *     possible object is
     *     {@link FopStatistics }
     *
     */
    public FopStatistics getFopStatistics() {
        return fopStatistics;
    }

    /**
     * Sets the value of the fopStatistics property.
     *
     * @param value
     *     allowed object is
     *     {@link FopStatistics }
     *
     */
    public void setFopStatistics(FopStatistics value) {
        this.fopStatistics = value;
    }

    public boolean isSetFopStatistics() {
        return (this.fopStatistics!= null);
    }

}
