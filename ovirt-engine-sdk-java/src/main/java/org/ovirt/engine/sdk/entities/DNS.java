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
 * <p>Java class for DNS complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="DNS">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="servers" type="{}Hosts" minOccurs="0"/>
 *         &lt;element name="search_domains" type="{}Hosts" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DNS", propOrder = {
    "servers",
    "searchDomains"
})
public class DNS {

    protected Hosts servers;
    @XmlElement(name = "search_domains")
    protected Hosts searchDomains;

    /**
     * Gets the value of the servers property.
     *
     * @return
     *     possible object is
     *     {@link Hosts }
     *
     */
    public Hosts getServers() {
        return servers;
    }

    /**
     * Sets the value of the servers property.
     *
     * @param value
     *     allowed object is
     *     {@link Hosts }
     *
     */
    public void setServers(Hosts value) {
        this.servers = value;
    }

    public boolean isSetServers() {
        return (this.servers!= null);
    }

    /**
     * Gets the value of the searchDomains property.
     *
     * @return
     *     possible object is
     *     {@link Hosts }
     *
     */
    public Hosts getSearchDomains() {
        return searchDomains;
    }

    /**
     * Sets the value of the searchDomains property.
     *
     * @param value
     *     allowed object is
     *     {@link Hosts }
     *
     */
    public void setSearchDomains(Hosts value) {
        this.searchDomains = value;
    }

    public boolean isSetSearchDomains() {
        return (this.searchDomains!= null);
    }

}

