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
 * <p>Java class for IscsiBond complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="IscsiBond">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseResource">
 *       &lt;sequence>
 *         &lt;element ref="{}data_center" minOccurs="0"/>
 *         &lt;element ref="{}storage_connections"/>
 *         &lt;element ref="{}networks"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IscsiBond", propOrder = {
    "dataCenter",
    "storageConnections",
    "networks"
})
public class IscsiBond
    extends BaseResource
{

    @XmlElement(name = "data_center")
    protected DataCenter dataCenter;
    @XmlElement(name = "storage_connections", required = true)
    protected StorageConnections storageConnections;
    @XmlElement(required = true)
    protected Networks networks;

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
     * Gets the value of the storageConnections property.
     *
     * @return
     *     possible object is
     *     {@link StorageConnections }
     *
     */
    public Object getStorageConnections() {
        return storageConnections;
    }

    /**
     * Sets the value of the storageConnections property.
     *
     * @param value
     *     allowed object is
     *     {@link StorageConnections }
     *
     */
    public void setStorageConnections(StorageConnections value) {
        this.storageConnections = value;
    }

    public boolean isSetStorageConnections() {
        return (this.storageConnections!= null);
    }

    /**
     * Gets the value of the networks property.
     *
     * @return
     *     possible object is
     *     {@link Networks }
     *
     */
    public Object getNetworks() {
        return networks;
    }

    /**
     * Sets the value of the networks property.
     *
     * @param value
     *     allowed object is
     *     {@link Networks }
     *
     */
    public void setNetworks(Networks value) {
        this.networks = value;
    }

    public boolean isSetNetworks() {
        return (this.networks!= null);
    }

}
