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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReportedConfigurations complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ReportedConfigurations">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="in_sync" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="reported_configuration" type="{}ReportedConfiguration" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReportedConfigurations", propOrder = {
    "inSync",
    "reportedConfigurations"
})
public class ReportedConfigurations {

    @XmlElement(name = "in_sync")
    protected boolean inSync;
    @XmlElement(name = "reported_configuration")
    protected List<ReportedConfiguration> reportedConfigurations;

    /**
     * Gets the value of the inSync property.
     *
     */
    public boolean isInSync() {
        return inSync;
    }

    /**
     * Sets the value of the inSync property.
     *
     */
    public void setInSync(boolean value) {
        this.inSync = value;
    }

    public boolean isSetInSync() {
        return true;
    }

    /**
     * Gets the value of the reportedConfigurations property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the reportedConfigurations property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReportedConfigurations().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReportedConfiguration }
     *
     *
     */
    public List<ReportedConfiguration> getReportedConfigurations() {
        if (reportedConfigurations == null) {
            reportedConfigurations = new ArrayList<ReportedConfiguration>();
        }
        return this.reportedConfigurations;
    }

    public boolean isSetReportedConfigurations() {
        return ((this.reportedConfigurations!= null)&&(!this.reportedConfigurations.isEmpty()));
    }

    public void unsetReportedConfigurations() {
        this.reportedConfigurations = null;
    }

}
