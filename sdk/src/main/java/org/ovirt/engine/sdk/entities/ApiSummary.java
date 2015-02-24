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
 * <p>Java class for ApiSummary complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ApiSummary">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}vms" minOccurs="0"/>
 *         &lt;element ref="{}hosts" minOccurs="0"/>
 *         &lt;element ref="{}users" minOccurs="0"/>
 *         &lt;element ref="{}storage_domains" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ApiSummary", propOrder = {
    "vMs",
    "hosts",
    "users",
    "storageDomains"
})
public class ApiSummary {

    @XmlElement(name = "vms")
    protected VMs vMs;
    protected Hosts hosts;
    protected Users users;
    @XmlElement(name = "storage_domains")
    protected StorageDomains storageDomains;

    /**
     * Gets the value of the vMs property.
     *
     * @return
     *     possible object is
     *     {@link VMs }
     *
     */
    public VMs getVMs() {
        return vMs;
    }

    /**
     * Sets the value of the vMs property.
     *
     * @param value
     *     allowed object is
     *     {@link VMs }
     *
     */
    public void setVMs(VMs value) {
        this.vMs = value;
    }

    public boolean isSetVMs() {
        return (this.vMs!= null);
    }

    /**
     * Gets the value of the hosts property.
     *
     * @return
     *     possible object is
     *     {@link Hosts }
     *
     */
    public Hosts getHosts() {
        return hosts;
    }

    /**
     * Sets the value of the hosts property.
     *
     * @param value
     *     allowed object is
     *     {@link Hosts }
     *
     */
    public void setHosts(Hosts value) {
        this.hosts = value;
    }

    public boolean isSetHosts() {
        return (this.hosts!= null);
    }

    /**
     * Gets the value of the users property.
     *
     * @return
     *     possible object is
     *     {@link Users }
     *
     */
    public Users getUsers() {
        return users;
    }

    /**
     * Sets the value of the users property.
     *
     * @param value
     *     allowed object is
     *     {@link Users }
     *
     */
    public void setUsers(Users value) {
        this.users = value;
    }

    public boolean isSetUsers() {
        return (this.users!= null);
    }

    /**
     * Gets the value of the storageDomains property.
     *
     * @return
     *     possible object is
     *     {@link StorageDomains }
     *
     */
    public StorageDomains getStorageDomains() {
        return storageDomains;
    }

    /**
     * Sets the value of the storageDomains property.
     *
     * @param value
     *     allowed object is
     *     {@link StorageDomains }
     *
     */
    public void setStorageDomains(StorageDomains value) {
        this.storageDomains = value;
    }

    public boolean isSetStorageDomains() {
        return (this.storageDomains!= null);
    }

}

