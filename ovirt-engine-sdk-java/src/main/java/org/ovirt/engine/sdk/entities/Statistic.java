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
 * <p>Java class for Statistic complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Statistic">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseResource">
 *       &lt;sequence>
 *         &lt;element ref="{}values"/>
 *         &lt;element name="type" type="{}StatisticType"/>
 *         &lt;element name="unit" type="{}StatisticUnit"/>
 *         &lt;element ref="{}disk" minOccurs="0"/>
 *         &lt;element ref="{}host" minOccurs="0"/>
 *         &lt;element ref="{}host_nic" minOccurs="0"/>
 *         &lt;element ref="{}host_numa_node" minOccurs="0"/>
 *         &lt;element ref="{}nic" minOccurs="0"/>
 *         &lt;element ref="{}vm" minOccurs="0"/>
 *         &lt;element ref="{}brick" minOccurs="0"/>
 *         &lt;element ref="{}step" minOccurs="0"/>
 *         &lt;element ref="{}gluster_volume" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Statistic", propOrder = {
    "values",
    "type",
    "unit",
    "disk",
    "host",
    "hostNic",
    "hostNumaNode",
    "nic",
    "vm",
    "brick",
    "step",
    "glusterVolume"
})
public class Statistic
    extends BaseResource
{

    @XmlElement(required = true)
    protected Values values;
    @XmlElement(required = true)
    protected StatisticType type;
    @XmlElement(required = true)
    protected StatisticUnit unit;
    protected Disk disk;
    protected Host host;
    @XmlElement(name = "host_nic")
    protected HostNIC hostNic;
    @XmlElement(name = "host_numa_node")
    protected NumaNode hostNumaNode;
    protected NIC nic;
    protected VM vm;
    protected GlusterBrick brick;
    protected Step step;
    @XmlElement(name = "gluster_volume")
    protected GlusterVolume glusterVolume;

    /**
     * Gets the value of the values property.
     *
     * @return
     *     possible object is
     *     {@link Values }
     *
     */
    public Values getValues() {
        return values;
    }

    /**
     * Sets the value of the values property.
     *
     * @param value
     *     allowed object is
     *     {@link Values }
     *
     */
    public void setValues(Values value) {
        this.values = value;
    }

    public boolean isSetValues() {
        return (this.values!= null);
    }

    /**
     * Gets the value of the type property.
     *
     * @return
     *     possible object is
     *     {@link StatisticType }
     *
     */
    public StatisticType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     *
     * @param value
     *     allowed object is
     *     {@link StatisticType }
     *
     */
    public void setType(StatisticType value) {
        this.type = value;
    }

    public boolean isSetType() {
        return (this.type!= null);
    }

    /**
     * Gets the value of the unit property.
     *
     * @return
     *     possible object is
     *     {@link StatisticUnit }
     *
     */
    public StatisticUnit getUnit() {
        return unit;
    }

    /**
     * Sets the value of the unit property.
     *
     * @param value
     *     allowed object is
     *     {@link StatisticUnit }
     *
     */
    public void setUnit(StatisticUnit value) {
        this.unit = value;
    }

    public boolean isSetUnit() {
        return (this.unit!= null);
    }

    /**
     * Gets the value of the disk property.
     *
     * @return
     *     possible object is
     *     {@link Disk }
     *
     */
    public Disk getDisk() {
        return disk;
    }

    /**
     * Sets the value of the disk property.
     *
     * @param value
     *     allowed object is
     *     {@link Disk }
     *
     */
    public void setDisk(Disk value) {
        this.disk = value;
    }

    public boolean isSetDisk() {
        return (this.disk!= null);
    }

    /**
     * Gets the value of the host property.
     *
     * @return
     *     possible object is
     *     {@link Host }
     *
     */
    public Host getHost() {
        return host;
    }

    /**
     * Sets the value of the host property.
     *
     * @param value
     *     allowed object is
     *     {@link Host }
     *
     */
    public void setHost(Host value) {
        this.host = value;
    }

    public boolean isSetHost() {
        return (this.host!= null);
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

    /**
     * Gets the value of the hostNumaNode property.
     *
     * @return
     *     possible object is
     *     {@link NumaNode }
     *
     */
    public NumaNode getHostNumaNode() {
        return hostNumaNode;
    }

    /**
     * Sets the value of the hostNumaNode property.
     *
     * @param value
     *     allowed object is
     *     {@link NumaNode }
     *
     */
    public void setHostNumaNode(NumaNode value) {
        this.hostNumaNode = value;
    }

    public boolean isSetHostNumaNode() {
        return (this.hostNumaNode!= null);
    }

    /**
     * Gets the value of the nic property.
     *
     * @return
     *     possible object is
     *     {@link NIC }
     *
     */
    public NIC getNic() {
        return nic;
    }

    /**
     * Sets the value of the nic property.
     *
     * @param value
     *     allowed object is
     *     {@link NIC }
     *
     */
    public void setNic(NIC value) {
        this.nic = value;
    }

    public boolean isSetNic() {
        return (this.nic!= null);
    }

    /**
     * Gets the value of the vm property.
     *
     * @return
     *     possible object is
     *     {@link VM }
     *
     */
    public VM getVm() {
        return vm;
    }

    /**
     * Sets the value of the vm property.
     *
     * @param value
     *     allowed object is
     *     {@link VM }
     *
     */
    public void setVm(VM value) {
        this.vm = value;
    }

    public boolean isSetVm() {
        return (this.vm!= null);
    }

    /**
     * Gets the value of the brick property.
     *
     * @return
     *     possible object is
     *     {@link GlusterBrick }
     *
     */
    public GlusterBrick getBrick() {
        return brick;
    }

    /**
     * Sets the value of the brick property.
     *
     * @param value
     *     allowed object is
     *     {@link GlusterBrick }
     *
     */
    public void setBrick(GlusterBrick value) {
        this.brick = value;
    }

    public boolean isSetBrick() {
        return (this.brick!= null);
    }

    /**
     * Gets the value of the step property.
     *
     * @return
     *     possible object is
     *     {@link Step }
     *
     */
    public Step getStep() {
        return step;
    }

    /**
     * Sets the value of the step property.
     *
     * @param value
     *     allowed object is
     *     {@link Step }
     *
     */
    public void setStep(Step value) {
        this.step = value;
    }

    public boolean isSetStep() {
        return (this.step!= null);
    }

    /**
     * Gets the value of the glusterVolume property.
     *
     * @return
     *     possible object is
     *     {@link GlusterVolume }
     *
     */
    public GlusterVolume getGlusterVolume() {
        return glusterVolume;
    }

    /**
     * Sets the value of the glusterVolume property.
     *
     * @param value
     *     allowed object is
     *     {@link GlusterVolume }
     *
     */
    public void setGlusterVolume(GlusterVolume value) {
        this.glusterVolume = value;
    }

    public boolean isSetGlusterVolume() {
        return (this.glusterVolume!= null);
    }

}
