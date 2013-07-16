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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GlusterVolume complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="GlusterVolume">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseResource">
 *       &lt;sequence>
 *         &lt;element ref="{}cluster" minOccurs="0"/>
 *         &lt;element name="volume_type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element ref="{}transport_types" minOccurs="0"/>
 *         &lt;element name="replica_count" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" minOccurs="0"/>
 *         &lt;element name="stripe_count" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" minOccurs="0"/>
 *         &lt;element ref="{}bricks" minOccurs="0"/>
 *         &lt;element ref="{}options" minOccurs="0"/>
 *         &lt;element ref="{}status" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GlusterVolume", propOrder = {
    "cluster",
    "volumeType",
    "transportTypes",
    "replicaCount",
    "stripeCount",
    "bricks",
    "options",
    "status"
})
public class GlusterVolume
    extends BaseResource
{

    protected Cluster cluster;
    @XmlElement(name = "volume_type")
    protected String volumeType;
    @XmlElement(name = "transport_types")
    protected TransportTypes transportTypes;
    @XmlElement(name = "replica_count")
    @XmlSchemaType(name = "unsignedShort")
    protected Integer replicaCount;
    @XmlElement(name = "stripe_count")
    @XmlSchemaType(name = "unsignedShort")
    protected Integer stripeCount;
    protected GlusterBricks bricks;
    protected Options options;
    protected Status status;

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
     * Gets the value of the volumeType property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getVolumeType() {
        return volumeType;
    }

    /**
     * Sets the value of the volumeType property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setVolumeType(String value) {
        this.volumeType = value;
    }

    public boolean isSetVolumeType() {
        return (this.volumeType!= null);
    }

    /**
     * Gets the value of the transportTypes property.
     *
     * @return
     *     possible object is
     *     {@link TransportTypes }
     *
     */
    public TransportTypes getTransportTypes() {
        return transportTypes;
    }

    /**
     * Sets the value of the transportTypes property.
     *
     * @param value
     *     allowed object is
     *     {@link TransportTypes }
     *
     */
    public void setTransportTypes(TransportTypes value) {
        this.transportTypes = value;
    }

    public boolean isSetTransportTypes() {
        return (this.transportTypes!= null);
    }

    /**
     * Gets the value of the replicaCount property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getReplicaCount() {
        return replicaCount;
    }

    /**
     * Sets the value of the replicaCount property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setReplicaCount(Integer value) {
        this.replicaCount = value;
    }

    public boolean isSetReplicaCount() {
        return (this.replicaCount!= null);
    }

    /**
     * Gets the value of the stripeCount property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getStripeCount() {
        return stripeCount;
    }

    /**
     * Sets the value of the stripeCount property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setStripeCount(Integer value) {
        this.stripeCount = value;
    }

    public boolean isSetStripeCount() {
        return (this.stripeCount!= null);
    }

    /**
     * Gets the value of the bricks property.
     *
     * @return
     *     possible object is
     *     {@link GlusterBricks }
     *
     */
    public GlusterBricks getBricks() {
        return bricks;
    }

    /**
     * Sets the value of the bricks property.
     *
     * @param value
     *     allowed object is
     *     {@link GlusterBricks }
     *
     */
    public void setBricks(GlusterBricks value) {
        this.bricks = value;
    }

    public boolean isSetBricks() {
        return (this.bricks!= null);
    }

    /**
     * Gets the value of the options property.
     *
     * @return
     *     possible object is
     *     {@link Options }
     *
     */
    public Options getOptions() {
        return options;
    }

    /**
     * Sets the value of the options property.
     *
     * @param value
     *     allowed object is
     *     {@link Options }
     *
     */
    public void setOptions(Options value) {
        this.options = value;
    }

    public boolean isSetOptions() {
        return (this.options!= null);
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

}
