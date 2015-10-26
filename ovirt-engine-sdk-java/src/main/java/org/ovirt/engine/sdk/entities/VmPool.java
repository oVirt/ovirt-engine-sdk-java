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
 * <p>Java class for VmPool complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="VmPool">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseResource">
 *       &lt;sequence>
 *         &lt;element name="size" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element ref="{}cluster" minOccurs="0"/>
 *         &lt;element ref="{}template" minOccurs="0"/>
 *         &lt;element name="prestarted_vms" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="max_user_vms" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element ref="{}display" minOccurs="0"/>
 *         &lt;element ref="{}rng_device" minOccurs="0"/>
 *         &lt;element ref="{}soundcard_enabled" minOccurs="0"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VmPool", propOrder = {
    "size",
    "cluster",
    "template",
    "prestartedVms",
    "maxUserVms",
    "display",
    "rngDevice",
    "soundcardEnabled",
    "type"
})
public class VmPool
    extends BaseResource
{

    protected Integer size;
    protected Cluster cluster;
    protected Template template;
    @XmlElement(name = "prestarted_vms")
    protected Integer prestartedVms;
    @XmlElement(name = "max_user_vms")
    protected Integer maxUserVms;
    protected Display display;
    @XmlElement(name = "rng_device")
    protected RngDevice rngDevice;
    @XmlElement(name = "soundcard_enabled")
    protected Boolean soundcardEnabled;
    protected String type;

    /**
     * Gets the value of the size property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getSize() {
        return size;
    }

    /**
     * Sets the value of the size property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setSize(Integer value) {
        this.size = value;
    }

    public boolean isSetSize() {
        return (this.size!= null);
    }

    /**
     * Gets the value of the cluster property.
     *
     * @return
     *     possible object is
     *     {@link Cluster }
     *
     */
    public Cluster getCluster() {
        return cluster;
    }

    /**
     * Sets the value of the cluster property.
     *
     * @param value
     *     allowed object is
     *     {@link Cluster }
     *
     */
    public void setCluster(Cluster value) {
        this.cluster = value;
    }

    public boolean isSetCluster() {
        return (this.cluster!= null);
    }

    /**
     * Gets the value of the template property.
     *
     * @return
     *     possible object is
     *     {@link Template }
     *
     */
    public Template getTemplate() {
        return template;
    }

    /**
     * Sets the value of the template property.
     *
     * @param value
     *     allowed object is
     *     {@link Template }
     *
     */
    public void setTemplate(Template value) {
        this.template = value;
    }

    public boolean isSetTemplate() {
        return (this.template!= null);
    }

    /**
     * Gets the value of the prestartedVms property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getPrestartedVms() {
        return prestartedVms;
    }

    /**
     * Sets the value of the prestartedVms property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setPrestartedVms(Integer value) {
        this.prestartedVms = value;
    }

    public boolean isSetPrestartedVms() {
        return (this.prestartedVms!= null);
    }

    /**
     * Gets the value of the maxUserVms property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getMaxUserVms() {
        return maxUserVms;
    }

    /**
     * Sets the value of the maxUserVms property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setMaxUserVms(Integer value) {
        this.maxUserVms = value;
    }

    public boolean isSetMaxUserVms() {
        return (this.maxUserVms!= null);
    }

    /**
     * Gets the value of the display property.
     *
     * @return
     *     possible object is
     *     {@link Display }
     *
     */
    public Display getDisplay() {
        return display;
    }

    /**
     * Sets the value of the display property.
     *
     * @param value
     *     allowed object is
     *     {@link Display }
     *
     */
    public void setDisplay(Display value) {
        this.display = value;
    }

    public boolean isSetDisplay() {
        return (this.display!= null);
    }

    /**
     * Gets the value of the rngDevice property.
     *
     * @return
     *     possible object is
     *     {@link RngDevice }
     *
     */
    public RngDevice getRngDevice() {
        return rngDevice;
    }

    /**
     * Sets the value of the rngDevice property.
     *
     * @param value
     *     allowed object is
     *     {@link RngDevice }
     *
     */
    public void setRngDevice(RngDevice value) {
        this.rngDevice = value;
    }

    public boolean isSetRngDevice() {
        return (this.rngDevice!= null);
    }

    /**
     * Gets the value of the soundcardEnabled property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getSoundcardEnabled() {
        return soundcardEnabled;
    }

    /**
     * Sets the value of the soundcardEnabled property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setSoundcardEnabled(Boolean value) {
        this.soundcardEnabled = value;
    }

    public boolean isSetSoundcardEnabled() {
        return (this.soundcardEnabled!= null);
    }

    /**
     * Gets the value of the type property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setType(String value) {
        this.type = value;
    }

    public boolean isSetType() {
        return (this.type!= null);
    }

}
