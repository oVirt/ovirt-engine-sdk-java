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
 * <p>Java class for GlusterBrick complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="GlusterBrick">
 *   &lt;complexContent>
 *     &lt;extension base="{}GlusterBrickAdvancedDetails">
 *       &lt;sequence>
 *         &lt;element ref="{}gluster_volume" minOccurs="0"/>
 *         &lt;element name="server_id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="brick_dir" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "GlusterBrick", propOrder = {
    "glusterVolume",
    "serverId",
    "brickDir",
    "status"
})
public class GlusterBrick
    extends GlusterBrickAdvancedDetails
{

    @XmlElement(name = "gluster_volume")
    protected GlusterVolume glusterVolume;
    @XmlElement(name = "server_id")
    protected String serverId;
    @XmlElement(name = "brick_dir")
    protected String brickDir;
    protected Status status;

    /**
     * Gets the value of the glusterVolume property.
     *
     * @return
     *     possible object is
     *     {@link GlusterVolume }
     *
     */
    public GlusterVolume getGlusterVolume() {
        return glusterVolume;
    }

    /**
     * Sets the value of the glusterVolume property.
     *
     * @param value
     *     allowed object is
     *     {@link GlusterVolume }
     *
     */
    public void setGlusterVolume(GlusterVolume value) {
        this.glusterVolume = value;
    }

    public boolean isSetGlusterVolume() {
        return (this.glusterVolume!= null);
    }

    /**
     * Gets the value of the serverId property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getServerId() {
        return serverId;
    }

    /**
     * Sets the value of the serverId property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setServerId(String value) {
        this.serverId = value;
    }

    public boolean isSetServerId() {
        return (this.serverId!= null);
    }

    /**
     * Gets the value of the brickDir property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getBrickDir() {
        return brickDir;
    }

    /**
     * Sets the value of the brickDir property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setBrickDir(String value) {
        this.brickDir = value;
    }

    public boolean isSetBrickDir() {
        return (this.brickDir!= null);
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
