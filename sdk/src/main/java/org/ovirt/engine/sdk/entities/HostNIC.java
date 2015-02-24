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
 * <p>Java class for HostNIC complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="HostNIC">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseResource">
 *       &lt;sequence>
 *         &lt;element ref="{}host" minOccurs="0"/>
 *         &lt;element ref="{}network" minOccurs="0"/>
 *         &lt;element ref="{}mac" minOccurs="0"/>
 *         &lt;element ref="{}ip" minOccurs="0"/>
 *         &lt;element name="base_interface" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element ref="{}vlan" minOccurs="0"/>
 *         &lt;element ref="{}bonding" minOccurs="0"/>
 *         &lt;element name="boot_protocol" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="statistics" type="{}Statistics" minOccurs="0"/>
 *         &lt;element name="check_connectivity" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="speed" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element ref="{}status" minOccurs="0"/>
 *         &lt;element name="mtu" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="bridged" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="custom_configuration" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="override_configuration" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element ref="{}labels" minOccurs="0"/>
 *         &lt;element ref="{}properties" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostNIC", propOrder = {
    "host",
    "network",
    "mac",
    "ip",
    "baseInterface",
    "vlan",
    "bonding",
    "bootProtocol",
    "statistics",
    "checkConnectivity",
    "speed",
    "status",
    "mtu",
    "bridged",
    "customConfiguration",
    "overrideConfiguration",
    "labels",
    "properties"
})
public class HostNIC
    extends BaseResource
{

    protected Host host;
    protected Network network;
    protected MAC mac;
    protected IP ip;
    @XmlElement(name = "base_interface")
    protected String baseInterface;
    protected VLAN vlan;
    protected Bonding bonding;
    @XmlElement(name = "boot_protocol")
    protected String bootProtocol;
    protected Statistics statistics;
    @XmlElement(name = "check_connectivity")
    protected Boolean checkConnectivity;
    protected Long speed;
    protected Status status;
    protected Integer mtu;
    protected Boolean bridged;
    @XmlElement(name = "custom_configuration")
    protected Boolean customConfiguration;
    @XmlElement(name = "override_configuration")
    protected Boolean overrideConfiguration;
    protected Labels labels;
    protected Properties properties;

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
     * Gets the value of the ip property.
     *
     * @return
     *     possible object is
     *     {@link IP }
     *
     */
    public IP getIp() {
        return ip;
    }

    /**
     * Sets the value of the ip property.
     *
     * @param value
     *     allowed object is
     *     {@link IP }
     *
     */
    public void setIp(IP value) {
        this.ip = value;
    }

    public boolean isSetIp() {
        return (this.ip!= null);
    }

    /**
     * Gets the value of the baseInterface property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getBaseInterface() {
        return baseInterface;
    }

    /**
     * Sets the value of the baseInterface property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setBaseInterface(String value) {
        this.baseInterface = value;
    }

    public boolean isSetBaseInterface() {
        return (this.baseInterface!= null);
    }

    /**
     * Gets the value of the vlan property.
     *
     * @return
     *     possible object is
     *     {@link VLAN }
     *
     */
    public VLAN getVlan() {
        return vlan;
    }

    /**
     * Sets the value of the vlan property.
     *
     * @param value
     *     allowed object is
     *     {@link VLAN }
     *
     */
    public void setVlan(VLAN value) {
        this.vlan = value;
    }

    public boolean isSetVlan() {
        return (this.vlan!= null);
    }

    /**
     * Gets the value of the bonding property.
     *
     * @return
     *     possible object is
     *     {@link Bonding }
     *
     */
    public Bonding getBonding() {
        return bonding;
    }

    /**
     * Sets the value of the bonding property.
     *
     * @param value
     *     allowed object is
     *     {@link Bonding }
     *
     */
    public void setBonding(Bonding value) {
        this.bonding = value;
    }

    public boolean isSetBonding() {
        return (this.bonding!= null);
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
     * Gets the value of the checkConnectivity property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getCheckConnectivity() {
        return checkConnectivity;
    }

    /**
     * Sets the value of the checkConnectivity property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setCheckConnectivity(Boolean value) {
        this.checkConnectivity = value;
    }

    public boolean isSetCheckConnectivity() {
        return (this.checkConnectivity!= null);
    }

    /**
     * Gets the value of the speed property.
     *
     * @return
     *     possible object is
     *     {@link Long }
     *
     */
    public Long getSpeed() {
        return speed;
    }

    /**
     * Sets the value of the speed property.
     *
     * @param value
     *     allowed object is
     *     {@link Long }
     *
     */
    public void setSpeed(Long value) {
        this.speed = value;
    }

    public boolean isSetSpeed() {
        return (this.speed!= null);
    }

    /**
     * Gets the value of the status property.
     *
     * @return
     *     possible object is
     *     {@link Status }
     *
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     *
     * @param value
     *     allowed object is
     *     {@link Status }
     *
     */
    public void setStatus(Status value) {
        this.status = value;
    }

    public boolean isSetStatus() {
        return (this.status!= null);
    }

    /**
     * Gets the value of the mtu property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getMtu() {
        return mtu;
    }

    /**
     * Sets the value of the mtu property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setMtu(Integer value) {
        this.mtu = value;
    }

    public boolean isSetMtu() {
        return (this.mtu!= null);
    }

    /**
     * Gets the value of the bridged property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getBridged() {
        return bridged;
    }

    /**
     * Sets the value of the bridged property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setBridged(Boolean value) {
        this.bridged = value;
    }

    public boolean isSetBridged() {
        return (this.bridged!= null);
    }

    /**
     * Gets the value of the customConfiguration property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getCustomConfiguration() {
        return customConfiguration;
    }

    /**
     * Sets the value of the customConfiguration property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setCustomConfiguration(Boolean value) {
        this.customConfiguration = value;
    }

    public boolean isSetCustomConfiguration() {
        return (this.customConfiguration!= null);
    }

    /**
     * Gets the value of the overrideConfiguration property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getOverrideConfiguration() {
        return overrideConfiguration;
    }

    /**
     * Sets the value of the overrideConfiguration property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setOverrideConfiguration(Boolean value) {
        this.overrideConfiguration = value;
    }

    public boolean isSetOverrideConfiguration() {
        return (this.overrideConfiguration!= null);
    }

    /**
     * Gets the value of the labels property.
     *
     * @return
     *     possible object is
     *     {@link Labels }
     *
     */
    public Object getLabels() {
        return labels;
    }

    /**
     * Sets the value of the labels property.
     *
     * @param value
     *     allowed object is
     *     {@link Labels }
     *
     */
    public void setLabels(Labels value) {
        this.labels = value;
    }

    public boolean isSetLabels() {
        return (this.labels!= null);
    }

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

}
