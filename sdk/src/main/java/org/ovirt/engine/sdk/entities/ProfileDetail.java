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

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element ref="{}statistic" maxOccurs="2" minOccurs="0"/>
 *         &lt;element ref="{}block_statistic" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}fop_statistic" maxOccurs="unbounded" minOccurs="0"/>
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
    "statistic",
    "blockStatistic",
    "fopStatistic"
})
public class ProfileDetail {

    @XmlElement(name = "profile_type", required = true)
    protected String profileType;
    protected Integer duration;
    protected List<Statistic> statistic;
    @XmlElement(name = "block_statistic")
    protected List<BlockStatistic> blockStatistic;
    @XmlElement(name = "fop_statistic")
    protected List<FopStatistic> fopStatistic;

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
     * Gets the value of the statistic property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the statistic property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStatistic().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Statistic }
     *
     *
     */
    public List<Statistic> getStatistic() {
        if (statistic == null) {
            statistic = new ArrayList<Statistic>();
        }
        return this.statistic;
    }

    public boolean isSetStatistic() {
        return ((this.statistic!= null)&&(!this.statistic.isEmpty()));
    }

    public void unsetStatistic() {
        this.statistic = null;
    }

    /**
     * Gets the value of the blockStatistic property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the blockStatistic property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBlockStatistic().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BlockStatistic }
     *
     *
     */
    public List<BlockStatistic> getBlockStatistic() {
        if (blockStatistic == null) {
            blockStatistic = new ArrayList<BlockStatistic>();
        }
        return this.blockStatistic;
    }

    public boolean isSetBlockStatistic() {
        return ((this.blockStatistic!= null)&&(!this.blockStatistic.isEmpty()));
    }

    public void unsetBlockStatistic() {
        this.blockStatistic = null;
    }

    /**
     * Gets the value of the fopStatistic property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fopStatistic property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFopStatistic().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FopStatistic }
     *
     *
     */
    public List<FopStatistic> getFopStatistic() {
        if (fopStatistic == null) {
            fopStatistic = new ArrayList<FopStatistic>();
        }
        return this.fopStatistic;
    }

    public boolean isSetFopStatistic() {
        return ((this.fopStatistic!= null)&&(!this.fopStatistic.isEmpty()));
    }

    public void unsetFopStatistic() {
        this.fopStatistic = null;
    }

}

