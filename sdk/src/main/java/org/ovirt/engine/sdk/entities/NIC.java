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
 * <p>Java class for NIC complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="NIC">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseDevice">
 *       &lt;sequence>
 *         &lt;element ref="{}network" minOccurs="0"/>
 *         &lt;element name="linked" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="interface" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element ref="{}mac" minOccurs="0"/>
 *         &lt;element name="statistics" type="{}Statistics" minOccurs="0"/>
 *         &lt;element name="active" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="plugged" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element ref="{}port_mirroring" minOccurs="0"/>
 *         &lt;element ref="{}reported_devices" minOccurs="0"/>
 *         &lt;element ref="{}vnic_profile" minOccurs="0"/>
 *         &lt;element name="boot_protocol" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="on_boot" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NIC", propOrder = {
    "network",
    "linked",
    "_interface",
    "mac",
    "statistics",
    "active",
    "plugged",
    "portMirroring",
    "reportedDevices",
    "vnicProfile",
    "bootProtocol",
    "onBoot"
})
public class NIC
    extends BaseDevice
{

    protected Network network;
    protected Boolean linked;
    @XmlElement(name = "interface")
    protected String _interface;
    protected MAC mac;
    protected Statistics statistics;
    protected Boolean active;
    protected Boolean plugged;
    @XmlElement(name = "port_mirroring")
    protected PortMirroring portMirroring;
    @XmlElement(name = "reported_devices")
    protected ReportedDevices reportedDevices;
    @XmlElement(name = "vnic_profile")
    protected VnicProfile vnicProfile;
    @XmlElement(name = "boot_protocol")
    protected String bootProtocol;
    @XmlElement(name = "on_boot")
    protected Boolean onBoot;

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
     * Gets the value of the linked property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getLinked() {
        return linked;
    }

    /**
     * Sets the value of the linked property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setLinked(Boolean value) {
        this.linked = value;
    }

    public boolean isSetLinked() {
        return (this.linked!= null);
    }

    /**
     * Gets the value of the interface property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getInterface() {
        return _interface;
    }

    /**
     * Sets the value of the interface property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setInterface(String value) {
        this._interface = value;
    }

    public boolean isSetInterface() {
        return (this._interface!= null);
    }

    /**
     * Gets the value of the mac property.
     *
     * @return
     *     possible object is
     *     {@link MAC }
     *
     */
    public MAC getMac() {
        return mac;
    }

    /**
     * Sets the value of the mac property.
     *
     * @param value
     *     allowed object is
     *     {@link MAC }
     *
     */
    public void setMac(MAC value) {
        this.mac = value;
    }

    public boolean isSetMac() {
        return (this.mac!= null);
    }

    /**
     * Gets the value of the statistics property.
     *
     * @return
     *     possible object is
     *     {@link Statistics }
     *
     */
    public Object getStatistics() {
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
     * Gets the value of the active property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getActive() {
        return active;
    }

    /**
     * Sets the value of the active property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setActive(Boolean value) {
        this.active = value;
    }

    public boolean isSetActive() {
        return (this.active!= null);
    }

    /**
     * Gets the value of the plugged property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getPlugged() {
        return plugged;
    }

    /**
     * Sets the value of the plugged property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setPlugged(Boolean value) {
        this.plugged = value;
    }

    public boolean isSetPlugged() {
        return (this.plugged!= null);
    }

    /**
     * Gets the value of the portMirroring property.
     *
     * @return
     *     possible object is
     *     {@link PortMirroring }
     *
     */
    public PortMirroring getPortMirroring() {
        return portMirroring;
    }

    /**
     * Sets the value of the portMirroring property.
     *
     * @param value
     *     allowed object is
     *     {@link PortMirroring }
     *
     */
    public void setPortMirroring(PortMirroring value) {
        this.portMirroring = value;
    }

    public boolean isSetPortMirroring() {
        return (this.portMirroring!= null);
    }

    /**
     * Gets the value of the reportedDevices property.
     *
     * @return
     *     possible object is
     *     {@link ReportedDevices }
     *
     */
    public Object getReportedDevices() {
        return reportedDevices;
    }

    /**
     * Sets the value of the reportedDevices property.
     *
     * @param value
     *     allowed object is
     *     {@link ReportedDevices }
     *
     */
    public void setReportedDevices(ReportedDevices value) {
        this.reportedDevices = value;
    }

    public boolean isSetReportedDevices() {
        return (this.reportedDevices!= null);
    }

    /**
     * Gets the value of the vnicProfile property.
     *
     * @return
     *     possible object is
     *     {@link VnicProfile }
     *
     */
    public VnicProfile getVnicProfile() {
        return vnicProfile;
    }

    /**
     * Sets the value of the vnicProfile property.
     *
     * @param value
     *     allowed object is
     *     {@link VnicProfile }
     *
     */
    public void setVnicProfile(VnicProfile value) {
        this.vnicProfile = value;
    }

    public boolean isSetVnicProfile() {
        return (this.vnicProfile!= null);
    }

    /**
     * Gets the value of the bootProtocol property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getBootProtocol() {
        return bootProtocol;
    }

    /**
     * Sets the value of the bootProtocol property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setBootProtocol(String value) {
        this.bootProtocol = value;
    }

    public boolean isSetBootProtocol() {
        return (this.bootProtocol!= null);
    }

    /**
     * Gets the value of the onBoot property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getOnBoot() {
        return onBoot;
    }

    /**
     * Sets the value of the onBoot property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setOnBoot(Boolean value) {
        this.onBoot = value;
    }

    public boolean isSetOnBoot() {
        return (this.onBoot!= null);
    }

}
