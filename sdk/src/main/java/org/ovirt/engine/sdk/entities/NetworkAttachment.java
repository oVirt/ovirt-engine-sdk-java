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
 * <p>Java class for NetworkAttachment complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="NetworkAttachment">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseResource">
 *       &lt;sequence>
 *         &lt;element ref="{}network" minOccurs="0"/>
 *         &lt;element ref="{}host_nic" minOccurs="0"/>
 *         &lt;element name="ip_address_assignments" type="{}IpAddressAssignments" minOccurs="0"/>
 *         &lt;element ref="{}properties" minOccurs="0"/>
 *         &lt;element name="reported_configurations" type="{}ReportedConfigurations" minOccurs="0"/>
 *         &lt;element ref="{}host" minOccurs="0"/>
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
@XmlType(name = "NetworkAttachment", propOrder = {
    "network",
    "hostNic",
    "ipAddressAssignments",
    "properties",
    "reportedConfigurations",
    "host",
    "qos"
})
public class NetworkAttachment
    extends BaseResource
{

    protected Network network;
    @XmlElement(name = "host_nic")
    protected HostNIC hostNic;
    @XmlElement(name = "ip_address_assignments")
    protected IpAddressAssignments ipAddressAssignments;
    protected Properties properties;
    @XmlElement(name = "reported_configurations")
    protected ReportedConfigurations reportedConfigurations;
    protected Host host;
    protected QoS qos;

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

    /**
     * Gets the value of the ipAddressAssignments property.
     *
     * @return
     *     possible object is
     *     {@link IpAddressAssignments }
     *
     */
    public IpAddressAssignments getIpAddressAssignments() {
        return ipAddressAssignments;
    }

    /**
     * Sets the value of the ipAddressAssignments property.
     *
     * @param value
     *     allowed object is
     *     {@link IpAddressAssignments }
     *
     */
    public void setIpAddressAssignments(IpAddressAssignments value) {
        this.ipAddressAssignments = value;
    }

    public boolean isSetIpAddressAssignments() {
        return (this.ipAddressAssignments!= null);
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

    /**
     * Gets the value of the reportedConfigurations property.
     *
     * @return
     *     possible object is
     *     {@link ReportedConfigurations }
     *
     */
    public ReportedConfigurations getReportedConfigurations() {
        return reportedConfigurations;
    }

    /**
     * Sets the value of the reportedConfigurations property.
     *
     * @param value
     *     allowed object is
     *     {@link ReportedConfigurations }
     *
     */
    public void setReportedConfigurations(ReportedConfigurations value) {
        this.reportedConfigurations = value;
    }

    public boolean isSetReportedConfigurations() {
        return (this.reportedConfigurations!= null);
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
     * Gets the value of the qos property.
     *
     * @return
     *     possible object is
     *     {@link QoS }
     *
     */
    public QoS getQos() {
        return qos;
    }

    /**
     * Sets the value of the qos property.
     *
     * @param value
     *     allowed object is
     *     {@link QoS }
     *
     */
    public void setQos(QoS value) {
        this.qos = value;
    }

    public boolean isSetQos() {
        return (this.qos!= null);
    }

}
