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
 * <p>Java class for OperatingSystemInfo complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="OperatingSystemInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseResource">
 *       &lt;sequence>
 *         &lt;element name="large_icon" type="{}Icon" minOccurs="0"/>
 *         &lt;element name="small_icon" type="{}Icon" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OperatingSystemInfo", propOrder = {
    "largeIcon",
    "smallIcon"
})
public class OperatingSystemInfo
    extends BaseResource
{

    @XmlElement(name = "large_icon")
    protected Icon largeIcon;
    @XmlElement(name = "small_icon")
    protected Icon smallIcon;

    /**
     * Gets the value of the largeIcon property.
     *
     * @return
     *     possible object is
     *     {@link Icon }
     *
     */
    public Icon getLargeIcon() {
        return largeIcon;
    }

    /**
     * Sets the value of the largeIcon property.
     *
     * @param value
     *     allowed object is
     *     {@link Icon }
     *
     */
    public void setLargeIcon(Icon value) {
        this.largeIcon = value;
    }

    public boolean isSetLargeIcon() {
        return (this.largeIcon!= null);
    }

    /**
     * Gets the value of the smallIcon property.
     *
     * @return
     *     possible object is
     *     {@link Icon }
     *
     */
    public Icon getSmallIcon() {
        return smallIcon;
    }

    /**
     * Sets the value of the smallIcon property.
     *
     * @param value
     *     allowed object is
     *     {@link Icon }
     *
     */
    public void setSmallIcon(Icon value) {
        this.smallIcon = value;
    }

    public boolean isSetSmallIcon() {
        return (this.smallIcon!= null);
    }

}
