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
 * <p>Java class for Step complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Step">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseResource">
 *       &lt;sequence>
 *         &lt;element name="parent_step" type="{}Step" minOccurs="0"/>
 *         &lt;element name="job" type="{}Job" minOccurs="0"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="number" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element ref="{}status" minOccurs="0"/>
 *         &lt;element name="start_time" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="end_time" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="external" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="external_type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Step", propOrder = {
    "parentStep",
    "job",
    "type",
    "number",
    "status",
    "startTime",
    "endTime",
    "external",
    "externalType"
})
public class Step
    extends BaseResource
{

    @XmlElement(name = "parent_step")
    protected Step parentStep;
    protected Job job;
    protected String type;
    protected Integer number;
    protected Status status;
    @XmlElement(name = "start_time")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar startTime;
    @XmlElement(name = "end_time")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar endTime;
    protected Boolean external;
    @XmlElement(name = "external_type")
    protected String externalType;

    /**
     * Gets the value of the parentStep property.
     *
     * @return
     *     possible object is
     *     {@link Step }
     *
     */
    public Step getParentStep() {
        return parentStep;
    }

    /**
     * Sets the value of the parentStep property.
     *
     * @param value
     *     allowed object is
     *     {@link Step }
     *
     */
    public void setParentStep(Step value) {
        this.parentStep = value;
    }

    public boolean isSetParentStep() {
        return (this.parentStep!= null);
    }

    /**
     * Gets the value of the job property.
     *
     * @return
     *     possible object is
     *     {@link Job }
     *
     */
    public Job getJob() {
        return job;
    }

    /**
     * Sets the value of the job property.
     *
     * @param value
     *     allowed object is
     *     {@link Job }
     *
     */
    public void setJob(Job value) {
        this.job = value;
    }

    public boolean isSetJob() {
        return (this.job!= null);
    }

    /**
     * Gets the value of the type property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setType(String value) {
        this.type = value;
    }

    public boolean isSetType() {
        return (this.type!= null);
    }

    /**
     * Gets the value of the number property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * Sets the value of the number property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setNumber(Integer value) {
        this.number = value;
    }

    public boolean isSetNumber() {
        return (this.number!= null);
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
     * Gets the value of the externalType property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getExternalType() {
        return externalType;
    }

    /**
     * Sets the value of the externalType property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setExternalType(String value) {
        this.externalType = value;
    }

    public boolean isSetExternalType() {
        return (this.externalType!= null);
    }

}
