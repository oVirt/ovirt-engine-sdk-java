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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BaseResource complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="BaseResource">
 *   &lt;complexContent>
 *     &lt;extension base="{}ActionableResource">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="comment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="creation_status" type="{}Status" minOccurs="0"/>
 *         &lt;element ref="{}link" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="href" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BaseResource", propOrder = {
    "name",
    "description",
    "comment",
    "creationStatus",
    "links"
})
@XmlSeeAlso({
    QoS.class,
    Event.class,
    Role.class,
    Feature.class,
    Bookmark.class,
    Host.class,
    Image.class,
    Header.class,
    Statistic.class,
    SpecialObjects.class,
    SchedulingPolicyUnit.class,
    AffinityGroup.class,
    AuthorizedKey.class,
    HostNIC.class,
    Domain.class,
    SchedulingPolicy.class,
    ProductInfo.class,
    SSH.class,
    Balance.class,
    StorageDomain.class,
    DataCenter.class,
    Hook.class,
    GlusterVolumeProfileDetails.class,
    Label.class,
    CpuProfile.class,
    Weight.class,
    GlusterVolume.class,
    StorageConnection.class,
    DiskProfile.class,
    ReportedDevice.class,
    IscsiBond.class,
    Tag.class,
    File.class,
    Job.class,
    Session.class,
    Creation.class,
    GlusterBrickAdvancedDetails.class,
    API.class,
    Template.class,
    VM.class,
    GlusterHook.class,
    Permit.class,
    VnicProfile.class,
    NumaNode.class,
    Action.class,
    Permission.class,
    Filter.class,
    VmPool.class,
    Network.class,
    Quota.class,
    Parameter.class,
    Version.class,
    Application.class,
    GlusterServerHook.class,
    Cluster.class,
    Group.class,
    User.class,
    Step.class,
    Storage.class,
    BaseDevice.class
})
public class BaseResource
    extends ActionableResource
{

    protected String name;
    protected String description;
    protected String comment;
    @XmlElement(name = "creation_status")
    protected Status creationStatus;
    @XmlElement(name = "link")
    protected List<Link> links;
    @XmlAttribute(name = "href")
    protected String href;
    @XmlAttribute(name = "id")
    protected String id;

    /**
     * Gets the value of the name property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setName(String value) {
        this.name = value;
    }

    public boolean isSetName() {
        return (this.name!= null);
    }

    /**
     * Gets the value of the description property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDescription(String value) {
        this.description = value;
    }

    public boolean isSetDescription() {
        return (this.description!= null);
    }

    /**
     * Gets the value of the comment property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getComment() {
        return comment;
    }

    /**
     * Sets the value of the comment property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setComment(String value) {
        this.comment = value;
    }

    public boolean isSetComment() {
        return (this.comment!= null);
    }

    /**
     * Gets the value of the creationStatus property.
     *
     * @return
     *     possible object is
     *     {@link Status }
     *
     */
    public Status getCreationStatus() {
        return creationStatus;
    }

    /**
     * Sets the value of the creationStatus property.
     *
     * @param value
     *     allowed object is
     *     {@link Status }
     *
     */
    public void setCreationStatus(Status value) {
        this.creationStatus = value;
    }

    public boolean isSetCreationStatus() {
        return (this.creationStatus!= null);
    }

    /**
     * Gets the value of the links property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the links property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLinks().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Link }
     *
     *
     */
    public List<Link> getLinks() {
        if (links == null) {
            links = new ArrayList<Link>();
        }
        return this.links;
    }

    public boolean isSetLinks() {
        return ((this.links!= null)&&(!this.links.isEmpty()));
    }

    public void unsetLinks() {
        this.links = null;
    }

    /**
     * Gets the value of the href property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getHref() {
        return href;
    }

    /**
     * Sets the value of the href property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setHref(String value) {
        this.href = value;
    }

    public boolean isSetHref() {
        return (this.href!= null);
    }

    /**
     * Gets the value of the id property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setId(String value) {
        this.id = value;
    }

    public boolean isSetId() {
        return (this.id!= null);
    }

}

