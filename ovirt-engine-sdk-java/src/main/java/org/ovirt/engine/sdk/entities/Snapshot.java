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
 * <p>Java class for Snapshot complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Snapshot">
 *   &lt;complexContent>
 *     &lt;extension base="{}VM">
 *       &lt;sequence>
 *         &lt;element ref="{}vm" minOccurs="0"/>
 *         &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="snapshot_status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="persist_memorystate" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Snapshot", propOrder = {
    "vm",
    "date",
    "snapshotStatus",
    "persistMemorystate"
})
public class Snapshot
    extends VM
{

    protected VM vm;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar date;
    @XmlElement(name = "snapshot_status")
    protected String snapshotStatus;
    @XmlElement(name = "persist_memorystate")
    protected Boolean persistMemorystate;

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
     * Gets the value of the date property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setDate(XMLGregorianCalendar value) {
        this.date = value;
    }

    public boolean isSetDate() {
        return (this.date!= null);
    }

    /**
     * Gets the value of the snapshotStatus property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSnapshotStatus() {
        return snapshotStatus;
    }

    /**
     * Sets the value of the snapshotStatus property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSnapshotStatus(String value) {
        this.snapshotStatus = value;
    }

    public boolean isSetSnapshotStatus() {
        return (this.snapshotStatus!= null);
    }

    /**
     * Gets the value of the persistMemorystate property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getPersistMemorystate() {
        return persistMemorystate;
    }

    /**
     * Sets the value of the persistMemorystate property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setPersistMemorystate(Boolean value) {
        this.persistMemorystate = value;
    }

    public boolean isSetPersistMemorystate() {
        return (this.persistMemorystate!= null);
    }

}
