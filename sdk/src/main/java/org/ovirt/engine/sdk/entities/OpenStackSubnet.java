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
 * <p>Java class for OpenStackSubnet complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="OpenStackSubnet">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseResource">
 *       &lt;sequence>
 *         &lt;element name="cidr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ip_version" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gateway" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dns_servers" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="dns_server" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element ref="{}openstack_network" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OpenStackSubnet", propOrder = {
    "cidr",
    "ipVersion",
    "gateway",
    "dnsServers",
    "openstackNetwork"
})
public class OpenStackSubnet
    extends BaseResource
{

    protected String cidr;
    @XmlElement(name = "ip_version")
    protected String ipVersion;
    protected String gateway;
    @XmlElement(name = "dns_servers")
    protected OpenStackSubnet.DnsServersList dnsServers;
    @XmlElement(name = "openstack_network")
    protected OpenStackNetwork openstackNetwork;

    /**
     * Gets the value of the cidr property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCidr() {
        return cidr;
    }

    /**
     * Sets the value of the cidr property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCidr(String value) {
        this.cidr = value;
    }

    public boolean isSetCidr() {
        return (this.cidr!= null);
    }

    /**
     * Gets the value of the ipVersion property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getIpVersion() {
        return ipVersion;
    }

    /**
     * Sets the value of the ipVersion property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setIpVersion(String value) {
        this.ipVersion = value;
    }

    public boolean isSetIpVersion() {
        return (this.ipVersion!= null);
    }

    /**
     * Gets the value of the gateway property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getGateway() {
        return gateway;
    }

    /**
     * Sets the value of the gateway property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setGateway(String value) {
        this.gateway = value;
    }

    public boolean isSetGateway() {
        return (this.gateway!= null);
    }

    /**
     * Gets the value of the dnsServers property.
     *
     * @return
     *     possible object is
     *     {@link OpenStackSubnet.DnsServersList }
     *
     */
    public OpenStackSubnet.DnsServersList getDnsServers() {
        return dnsServers;
    }

    /**
     * Sets the value of the dnsServers property.
     *
     * @param value
     *     allowed object is
     *     {@link OpenStackSubnet.DnsServersList }
     *
     */
    public void setDnsServers(OpenStackSubnet.DnsServersList value) {
        this.dnsServers = value;
    }

    public boolean isSetDnsServers() {
        return (this.dnsServers!= null);
    }

    /**
     * Gets the value of the openstackNetwork property.
     *
     * @return
     *     possible object is
     *     {@link OpenStackNetwork }
     *
     */
    public OpenStackNetwork getOpenstackNetwork() {
        return openstackNetwork;
    }

    /**
     * Sets the value of the openstackNetwork property.
     *
     * @param value
     *     allowed object is
     *     {@link OpenStackNetwork }
     *
     */
    public void setOpenstackNetwork(OpenStackNetwork value) {
        this.openstackNetwork = value;
    }

    public boolean isSetOpenstackNetwork() {
        return (this.openstackNetwork!= null);
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
     *         &lt;element name="dns_server" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "dnsServers"
    })
    public static class DnsServersList {

        @XmlElement(name = "dns_server")
        protected List<String> dnsServers;

        /**
         * Gets the value of the dnsServers property.
         *
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the dnsServers property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDnsServers().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         *
         *
         */
        public List<String> getDnsServers() {
            if (dnsServers == null) {
                dnsServers = new ArrayList<String>();
            }
            return this.dnsServers;
        }

        public boolean isSetDnsServers() {
            return ((this.dnsServers!= null)&&(!this.dnsServers.isEmpty()));
        }

        public void unsetDnsServers() {
            this.dnsServers = null;
        }

    }

}
