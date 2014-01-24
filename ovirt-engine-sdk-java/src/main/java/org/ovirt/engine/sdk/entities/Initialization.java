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
 * <p>Java class for Initialization complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Initialization">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="configuration" type="{}Configuration" minOccurs="0"/>
 *         &lt;element name="cloud_init" type="{}CloudInit" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Initialization", propOrder = {
    "configuration",
    "cloudInit"
})
public class Initialization {

    protected Configuration configuration;
    @XmlElement(name = "cloud_init")
    protected CloudInit cloudInit;

    /**
     * Gets the value of the configuration property.
     *
     * @return
     *     possible object is
     *     {@link Configuration }
     *
     */
    public Configuration getConfiguration() {
        return configuration;
    }

    /**
     * Sets the value of the configuration property.
     *
     * @param value
     *     allowed object is
     *     {@link Configuration }
     *
     */
    public void setConfiguration(Configuration value) {
        this.configuration = value;
    }

    public boolean isSetConfiguration() {
        return (this.configuration!= null);
    }

    /**
     * Gets the value of the cloudInit property.
     *
     * @return
     *     possible object is
     *     {@link CloudInit }
     *
     */
    public CloudInit getCloudInit() {
        return cloudInit;
    }

    /**
     * Sets the value of the cloudInit property.
     *
     * @param value
     *     allowed object is
     *     {@link CloudInit }
     *
     */
    public void setCloudInit(CloudInit value) {
        this.cloudInit = value;
    }

    public boolean isSetCloudInit() {
        return (this.cloudInit!= null);
    }

}

