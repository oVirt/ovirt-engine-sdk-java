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
 * <p>Java class for GlusterHook complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="GlusterHook">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseResource">
 *       &lt;sequence>
 *         &lt;element ref="{}cluster" minOccurs="0"/>
 *         &lt;element name="gluster_command" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="stage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="content_type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="checksum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="content" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="conflict_status" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" minOccurs="0"/>
 *         &lt;element name="conflicts" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element ref="{}status" minOccurs="0"/>
 *         &lt;element ref="{}server_hooks" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GlusterHook", propOrder = {
    "cluster",
    "glusterCommand",
    "stage",
    "contentType",
    "checksum",
    "content",
    "conflictStatus",
    "conflicts",
    "status",
    "serverHooks"
})
public class GlusterHook
    extends BaseResource
{

    protected Cluster cluster;
    @XmlElement(name = "gluster_command")
    protected String glusterCommand;
    protected String stage;
    @XmlElement(name = "content_type")
    protected String contentType;
    protected String checksum;
    protected String content;
    @XmlElement(name = "conflict_status")
    @XmlSchemaType(name = "unsignedShort")
    protected Integer conflictStatus;
    protected String conflicts;
    protected Status status;
    @XmlElement(name = "server_hooks")
    protected GlusterServerHooks serverHooks;

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
     * Gets the value of the glusterCommand property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getGlusterCommand() {
        return glusterCommand;
    }

    /**
     * Sets the value of the glusterCommand property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setGlusterCommand(String value) {
        this.glusterCommand = value;
    }

    public boolean isSetGlusterCommand() {
        return (this.glusterCommand!= null);
    }

    /**
     * Gets the value of the stage property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getStage() {
        return stage;
    }

    /**
     * Sets the value of the stage property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setStage(String value) {
        this.stage = value;
    }

    public boolean isSetStage() {
        return (this.stage!= null);
    }

    /**
     * Gets the value of the contentType property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getContentType() {
        return contentType;
    }

    /**
     * Sets the value of the contentType property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setContentType(String value) {
        this.contentType = value;
    }

    public boolean isSetContentType() {
        return (this.contentType!= null);
    }

    /**
     * Gets the value of the checksum property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getChecksum() {
        return checksum;
    }

    /**
     * Sets the value of the checksum property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setChecksum(String value) {
        this.checksum = value;
    }

    public boolean isSetChecksum() {
        return (this.checksum!= null);
    }

    /**
     * Gets the value of the content property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the value of the content property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setContent(String value) {
        this.content = value;
    }

    public boolean isSetContent() {
        return (this.content!= null);
    }

    /**
     * Gets the value of the conflictStatus property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getConflictStatus() {
        return conflictStatus;
    }

    /**
     * Sets the value of the conflictStatus property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setConflictStatus(Integer value) {
        this.conflictStatus = value;
    }

    public boolean isSetConflictStatus() {
        return (this.conflictStatus!= null);
    }

    /**
     * Gets the value of the conflicts property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getConflicts() {
        return conflicts;
    }

    /**
     * Sets the value of the conflicts property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setConflicts(String value) {
        this.conflicts = value;
    }

    public boolean isSetConflicts() {
        return (this.conflicts!= null);
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
     * Gets the value of the serverHooks property.
     *
     * @return
     *     possible object is
     *     {@link GlusterServerHooks }
     *
     */
    public GlusterServerHooks getServerHooks() {
        return serverHooks;
    }

    /**
     * Sets the value of the serverHooks property.
     *
     * @param value
     *     allowed object is
     *     {@link GlusterServerHooks }
     *
     */
    public void setServerHooks(GlusterServerHooks value) {
        this.serverHooks = value;
    }

    public boolean isSetServerHooks() {
        return (this.serverHooks!= null);
    }

}
