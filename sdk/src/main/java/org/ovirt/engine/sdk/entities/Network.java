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
 * <p>Java class for Network complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Network">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseResource">
 *       &lt;sequence>
 *         &lt;element ref="{}data_center" minOccurs="0"/>
 *         &lt;element ref="{}cluster" minOccurs="0"/>
 *         &lt;element ref="{}ip" minOccurs="0"/>
 *         &lt;element ref="{}vlan" minOccurs="0"/>
 *         &lt;element name="stp" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element ref="{}status" minOccurs="0"/>
 *         &lt;element name="display" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="mtu" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="usages" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="usage" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="required" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="profile_required" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element ref="{}labels" minOccurs="0"/>
 *         &lt;element ref="{}qos" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Network", propOrder = {
    "dataCenter",
    "cluster",
    "ip",
    "vlan",
    "stp",
    "status",
    "display",
    "mtu",
    "usages",
    "required",
    "profileRequired",
    "labels",
    "qos"
})
public class Network
    extends BaseResource
{

    @XmlElement(name = "data_center")
    protected DataCenter dataCenter;
    protected Cluster cluster;
    protected Ip ip;
    protected Vlan vlan;
    protected Boolean stp;
    protected Status status;
    protected Boolean display;
    protected Integer mtu;
    protected Network.UsagesList usages;
    protected Boolean required;
    @XmlElement(name = "profile_required")
    protected Boolean profileRequired;
    protected Labels labels;
    protected Qos qos;

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
     * Gets the value of the ip property.
     *
     * @return
     *     possible object is
     *     {@link Ip }
     *
     */
    public Ip getIp() {
        return ip;
    }

    /**
     * Sets the value of the ip property.
     *
     * @param value
     *     allowed object is
     *     {@link Ip }
     *
     */
    public void setIp(Ip value) {
        this.ip = value;
    }

    public boolean isSetIp() {
        return (this.ip!= null);
    }

    /**
     * Gets the value of the vlan property.
     *
     * @return
     *     possible object is
     *     {@link Vlan }
     *
     */
    public Vlan getVlan() {
        return vlan;
    }

    /**
     * Sets the value of the vlan property.
     *
     * @param value
     *     allowed object is
     *     {@link Vlan }
     *
     */
    public void setVlan(Vlan value) {
        this.vlan = value;
    }

    public boolean isSetVlan() {
        return (this.vlan!= null);
    }

    /**
     * Gets the value of the stp property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getStp() {
        return stp;
    }

    /**
     * Sets the value of the stp property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setStp(Boolean value) {
        this.stp = value;
    }

    public boolean isSetStp() {
        return (this.stp!= null);
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
     * Gets the value of the display property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getDisplay() {
        return display;
    }

    /**
     * Sets the value of the display property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setDisplay(Boolean value) {
        this.display = value;
    }

    public boolean isSetDisplay() {
        return (this.display!= null);
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
     * Gets the value of the usages property.
     *
     * @return
     *     possible object is
     *     {@link Network.UsagesList }
     *
     */
    public Network.UsagesList getUsages() {
        return usages;
    }

    /**
     * Sets the value of the usages property.
     *
     * @param value
     *     allowed object is
     *     {@link Network.UsagesList }
     *
     */
    public void setUsages(Network.UsagesList value) {
        this.usages = value;
    }

    public boolean isSetUsages() {
        return (this.usages!= null);
    }

    /**
     * Gets the value of the required property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getRequired() {
        return required;
    }

    /**
     * Sets the value of the required property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setRequired(Boolean value) {
        this.required = value;
    }

    public boolean isSetRequired() {
        return (this.required!= null);
    }

    /**
     * Gets the value of the profileRequired property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getProfileRequired() {
        return profileRequired;
    }

    /**
     * Sets the value of the profileRequired property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setProfileRequired(Boolean value) {
        this.profileRequired = value;
    }

    public boolean isSetProfileRequired() {
        return (this.profileRequired!= null);
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
     * Gets the value of the qos property.
     *
     * @return
     *     possible object is
     *     {@link Qos }
     *
     */
    public Qos getQos() {
        return qos;
    }

    /**
     * Sets the value of the qos property.
     *
     * @param value
     *     allowed object is
     *     {@link Qos }
     *
     */
    public void setQos(Qos value) {
        this.qos = value;
    }

    public boolean isSetQos() {
        return (this.qos!= null);
    }


    /**
     * <p>Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="usage" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "usages"
    })
    public static class UsagesList {

        @XmlElement(name = "usage")
        protected List<String> usages;

        /**
         * Gets the value of the usages property.
         *
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the usages property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getUsages().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         *
         *
         */
        public List<String> getUsages() {
            if (usages == null) {
                usages = new ArrayList<String>();
            }
            return this.usages;
        }

        public boolean isSetUsages() {
            return ((this.usages!= null)&&(!this.usages.isEmpty()));
        }

        public void unsetUsages() {
            this.usages = null;
        }

    }

}
