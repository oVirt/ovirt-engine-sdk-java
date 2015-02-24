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
 * <p>Java class for Permission complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Permission">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseResource">
 *       &lt;sequence>
 *         &lt;element name="role" type="{}Role" minOccurs="0"/>
 *         &lt;element name="user" type="{}User" minOccurs="0"/>
 *         &lt;element name="group" type="{}Group" minOccurs="0"/>
 *         &lt;element ref="{}data_center" minOccurs="0"/>
 *         &lt;element ref="{}cluster" minOccurs="0"/>
 *         &lt;element ref="{}host" minOccurs="0"/>
 *         &lt;element ref="{}storage_domain" minOccurs="0"/>
 *         &lt;element ref="{}vm" minOccurs="0"/>
 *         &lt;element ref="{}vmpool" minOccurs="0"/>
 *         &lt;element ref="{}template" minOccurs="0"/>
 *         &lt;element ref="{}disk" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Permission", propOrder = {
    "role",
    "user",
    "group",
    "dataCenter",
    "cluster",
    "host",
    "storageDomain",
    "vm",
    "vmpool",
    "template",
    "disk"
})
public class Permission
    extends BaseResource
{

    protected Role role;
    protected User user;
    protected Group group;
    @XmlElement(name = "data_center")
    protected DataCenter dataCenter;
    protected Cluster cluster;
    protected Host host;
    @XmlElement(name = "storage_domain")
    protected StorageDomain storageDomain;
    protected VM vm;
    protected VmPool vmpool;
    protected Template template;
    protected Disk disk;

    /**
     * Gets the value of the role property.
     *
     * @return
     *     possible object is
     *     {@link Role }
     *
     */
    public Role getRole() {
        return role;
    }

    /**
     * Sets the value of the role property.
     *
     * @param value
     *     allowed object is
     *     {@link Role }
     *
     */
    public void setRole(Role value) {
        this.role = value;
    }

    public boolean isSetRole() {
        return (this.role!= null);
    }

    /**
     * Gets the value of the user property.
     *
     * @return
     *     possible object is
     *     {@link User }
     *
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the value of the user property.
     *
     * @param value
     *     allowed object is
     *     {@link User }
     *
     */
    public void setUser(User value) {
        this.user = value;
    }

    public boolean isSetUser() {
        return (this.user!= null);
    }

    /**
     * Gets the value of the group property.
     *
     * @return
     *     possible object is
     *     {@link Group }
     *
     */
    public Group getGroup() {
        return group;
    }

    /**
     * Sets the value of the group property.
     *
     * @param value
     *     allowed object is
     *     {@link Group }
     *
     */
    public void setGroup(Group value) {
        this.group = value;
    }

    public boolean isSetGroup() {
        return (this.group!= null);
    }

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
     * Gets the value of the storageDomain property.
     *
     * @return
     *     possible object is
     *     {@link StorageDomain }
     *
     */
    public StorageDomain getStorageDomain() {
        return storageDomain;
    }

    /**
     * Sets the value of the storageDomain property.
     *
     * @param value
     *     allowed object is
     *     {@link StorageDomain }
     *
     */
    public void setStorageDomain(StorageDomain value) {
        this.storageDomain = value;
    }

    public boolean isSetStorageDomain() {
        return (this.storageDomain!= null);
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
     * Gets the value of the vmpool property.
     *
     * @return
     *     possible object is
     *     {@link VmPool }
     *
     */
    public VmPool getVmpool() {
        return vmpool;
    }

    /**
     * Sets the value of the vmpool property.
     *
     * @param value
     *     allowed object is
     *     {@link VmPool }
     *
     */
    public void setVmpool(VmPool value) {
        this.vmpool = value;
    }

    public boolean isSetVmpool() {
        return (this.vmpool!= null);
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

}
