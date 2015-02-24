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
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Job complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Job">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseResource">
 *       &lt;sequence>
 *         &lt;element ref="{}status" minOccurs="0"/>
 *         &lt;element name="owner" type="{}User" minOccurs="0"/>
 *         &lt;element name="start_time" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="end_time" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="last_updated" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="external" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="auto_cleared" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Job", propOrder = {
    "status",
    "owner",
    "startTime",
    "endTime",
    "lastUpdated",
    "external",
    "autoCleared"
})
public class Job
    extends BaseResource
{

    protected Status status;
    protected User owner;
    @XmlElement(name = "start_time")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar startTime;
    @XmlElement(name = "end_time")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar endTime;
    @XmlElement(name = "last_updated")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastUpdated;
    protected Boolean external;
    @XmlElement(name = "auto_cleared")
    protected Boolean autoCleared;

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
     * Gets the value of the owner property.
     *
     * @return
     *     possible object is
     *     {@link User }
     *
     */
    public User getOwner() {
        return owner;
    }

    /**
     * Sets the value of the owner property.
     *
     * @param value
     *     allowed object is
     *     {@link User }
     *
     */
    public void setOwner(User value) {
        this.owner = value;
    }

    public boolean isSetOwner() {
        return (this.owner!= null);
    }

    /**
     * Gets the value of the startTime property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getStartTime() {
        return startTime;
    }

    /**
     * Sets the value of the startTime property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setStartTime(XMLGregorianCalendar value) {
        this.startTime = value;
    }

    public boolean isSetStartTime() {
        return (this.startTime!= null);
    }

    /**
     * Gets the value of the endTime property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getEndTime() {
        return endTime;
    }

    /**
     * Sets the value of the endTime property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setEndTime(XMLGregorianCalendar value) {
        this.endTime = value;
    }

    public boolean isSetEndTime() {
        return (this.endTime!= null);
    }

    /**
     * Gets the value of the lastUpdated property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getLastUpdated() {
        return lastUpdated;
    }

    /**
     * Sets the value of the lastUpdated property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setLastUpdated(XMLGregorianCalendar value) {
        this.lastUpdated = value;
    }

    public boolean isSetLastUpdated() {
        return (this.lastUpdated!= null);
    }

    /**
     * Gets the value of the external property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getExternal() {
        return external;
    }

    /**
     * Sets the value of the external property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setExternal(Boolean value) {
        this.external = value;
    }

    public boolean isSetExternal() {
        return (this.external!= null);
    }

    /**
     * Gets the value of the autoCleared property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getAutoCleared() {
        return autoCleared;
    }

    /**
     * Sets the value of the autoCleared property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setAutoCleared(Boolean value) {
        this.autoCleared = value;
    }

    public boolean isSetAutoCleared() {
        return (this.autoCleared!= null);
    }

}
