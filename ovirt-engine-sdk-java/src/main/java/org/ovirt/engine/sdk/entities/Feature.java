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
 * <p>Java class for Feature complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Feature">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseResource">
 *       &lt;sequence>
 *         &lt;element ref="{}transparent_hugepages" minOccurs="0"/>
 *         &lt;element ref="{}gluster_volumes" minOccurs="0"/>
 *         &lt;element ref="{}vm_device_types" minOccurs="0"/>
 *         &lt;element ref="{}storage_types" minOccurs="0"/>
 *         &lt;element ref="{}storage_domain" minOccurs="0"/>
 *         &lt;element ref="{}nic" minOccurs="0"/>
 *         &lt;element ref="{}api" minOccurs="0"/>
 *         &lt;element ref="{}host" minOccurs="0"/>
 *         &lt;element ref="{}url" minOccurs="0"/>
 *         &lt;element ref="{}headers" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Feature", propOrder = {
    "transparentHugepages",
    "glusterVolumes",
    "vmDeviceTypes",
    "storageTypes",
    "storageDomain",
    "nic",
    "api",
    "host",
    "url",
    "headers"
})
public class Feature
    extends BaseResource
{

    @XmlElement(name = "transparent_hugepages")
    protected TransparentHugePages transparentHugepages;
    @XmlElement(name = "gluster_volumes")
    protected GlusterVolumes glusterVolumes;
    @XmlElement(name = "vm_device_types")
    protected VmDeviceTypes vmDeviceTypes;
    @XmlElement(name = "storage_types")
    protected StorageTypes storageTypes;
    @XmlElement(name = "storage_domain")
    protected StorageDomain storageDomain;
    protected NIC nic;
    protected API api;
    protected Host host;
    protected Url url;
    protected Headers headers;

    /**
     * Gets the value of the transparentHugepages property.
     *
     * @return
     *     possible object is
     *     {@link TransparentHugePages }
     *
     */
    public TransparentHugePages getTransparentHugepages() {
        return transparentHugepages;
    }

    /**
     * Sets the value of the transparentHugepages property.
     *
     * @param value
     *     allowed object is
     *     {@link TransparentHugePages }
     *
     */
    public void setTransparentHugepages(TransparentHugePages value) {
        this.transparentHugepages = value;
    }

    public boolean isSetTransparentHugepages() {
        return (this.transparentHugepages!= null);
    }

    /**
     * Gets the value of the glusterVolumes property.
     *
     * @return
     *     possible object is
     *     {@link GlusterVolumes }
     *
     */
    public GlusterVolumes getGlusterVolumes() {
        return glusterVolumes;
    }

    /**
     * Sets the value of the glusterVolumes property.
     *
     * @param value
     *     allowed object is
     *     {@link GlusterVolumes }
     *
     */
    public void setGlusterVolumes(GlusterVolumes value) {
        this.glusterVolumes = value;
    }

    public boolean isSetGlusterVolumes() {
        return (this.glusterVolumes!= null);
    }

    /**
     * Gets the value of the vmDeviceTypes property.
     *
     * @return
     *     possible object is
     *     {@link VmDeviceTypes }
     *
     */
    public VmDeviceTypes getVmDeviceTypes() {
        return vmDeviceTypes;
    }

    /**
     * Sets the value of the vmDeviceTypes property.
     *
     * @param value
     *     allowed object is
     *     {@link VmDeviceTypes }
     *
     */
    public void setVmDeviceTypes(VmDeviceTypes value) {
        this.vmDeviceTypes = value;
    }

    public boolean isSetVmDeviceTypes() {
        return (this.vmDeviceTypes!= null);
    }

    /**
     * Gets the value of the storageTypes property.
     *
     * @return
     *     possible object is
     *     {@link StorageTypes }
     *
     */
    public StorageTypes getStorageTypes() {
        return storageTypes;
    }

    /**
     * Sets the value of the storageTypes property.
     *
     * @param value
     *     allowed object is
     *     {@link StorageTypes }
     *
     */
    public void setStorageTypes(StorageTypes value) {
        this.storageTypes = value;
    }

    public boolean isSetStorageTypes() {
        return (this.storageTypes!= null);
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
     * Gets the value of the api property.
     *
     * @return
     *     possible object is
     *     {@link API }
     *
     */
    public API getApi() {
        return api;
    }

    /**
     * Sets the value of the api property.
     *
     * @param value
     *     allowed object is
     *     {@link API }
     *
     */
    public void setApi(API value) {
        this.api = value;
    }

    public boolean isSetApi() {
        return (this.api!= null);
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
     * Gets the value of the url property.
     *
     * @return
     *     possible object is
     *     {@link Url }
     *
     */
    public Url getUrl() {
        return url;
    }

    /**
     * Sets the value of the url property.
     *
     * @param value
     *     allowed object is
     *     {@link Url }
     *
     */
    public void setUrl(Url value) {
        this.url = value;
    }

    public boolean isSetUrl() {
        return (this.url!= null);
    }

    /**
     * Gets the value of the headers property.
     *
     * @return
     *     possible object is
     *     {@link Headers }
     *
     */
    public Headers getHeaders() {
        return headers;
    }

    /**
     * Sets the value of the headers property.
     *
     * @param value
     *     allowed object is
     *     {@link Headers }
     *
     */
    public void setHeaders(Headers value) {
        this.headers = value;
    }

    public boolean isSetHeaders() {
        return (this.headers!= null);
    }

}

