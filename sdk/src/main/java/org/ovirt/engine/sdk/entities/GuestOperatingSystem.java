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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GuestOperatingSystem complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="GuestOperatingSystem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="architecture" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codename" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="distribution" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="kernel" type="{}Kernel" minOccurs="0"/>
 *         &lt;element name="family" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="version" type="{}Version" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GuestOperatingSystem", propOrder = {
    "architecture",
    "codename",
    "distribution",
    "kernel",
    "family",
    "version"
})
public class GuestOperatingSystem {

    protected String architecture;
    protected String codename;
    protected String distribution;
    protected Kernel kernel;
    protected String family;
    protected Version version;

    /**
     * Gets the value of the architecture property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getArchitecture() {
        return architecture;
    }

    /**
     * Sets the value of the architecture property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setArchitecture(String value) {
        this.architecture = value;
    }

    public boolean isSetArchitecture() {
        return (this.architecture!= null);
    }

    /**
     * Gets the value of the codename property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCodename() {
        return codename;
    }

    /**
     * Sets the value of the codename property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCodename(String value) {
        this.codename = value;
    }

    public boolean isSetCodename() {
        return (this.codename!= null);
    }

    /**
     * Gets the value of the distribution property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDistribution() {
        return distribution;
    }

    /**
     * Sets the value of the distribution property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDistribution(String value) {
        this.distribution = value;
    }

    public boolean isSetDistribution() {
        return (this.distribution!= null);
    }

    /**
     * Gets the value of the kernel property.
     *
     * @return
     *     possible object is
     *     {@link Kernel }
     *
     */
    public Kernel getKernel() {
        return kernel;
    }

    /**
     * Sets the value of the kernel property.
     *
     * @param value
     *     allowed object is
     *     {@link Kernel }
     *
     */
    public void setKernel(Kernel value) {
        this.kernel = value;
    }

    public boolean isSetKernel() {
        return (this.kernel!= null);
    }

    /**
     * Gets the value of the family property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getFamily() {
        return family;
    }

    /**
     * Sets the value of the family property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setFamily(String value) {
        this.family = value;
    }

    public boolean isSetFamily() {
        return (this.family!= null);
    }

    /**
     * Gets the value of the version property.
     *
     * @return
     *     possible object is
     *     {@link Version }
     *
     */
    public Version getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     *
     * @param value
     *     allowed object is
     *     {@link Version }
     *
     */
    public void setVersion(Version value) {
        this.version = value;
    }

    public boolean isSetVersion() {
        return (this.version!= null);
    }

}
