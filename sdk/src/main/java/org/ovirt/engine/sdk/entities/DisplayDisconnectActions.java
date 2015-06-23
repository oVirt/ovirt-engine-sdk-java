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
 * <p>Java class for DisplayDisconnectActions complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="DisplayDisconnectActions">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="display_disconnect_action" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DisplayDisconnectActions", propOrder = {
    "displayDisconnectActions"
})
public class DisplayDisconnectActions {

    @XmlElement(name = "display_disconnect_action")
    protected List<String> displayDisconnectActions;

    /**
     * Gets the value of the displayDisconnectActions property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the displayDisconnectActions property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDisplayDisconnectActions().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     *
     *
     */
    public List<String> getDisplayDisconnectActions() {
        if (displayDisconnectActions == null) {
            displayDisconnectActions = new ArrayList<String>();
        }
        return this.displayDisconnectActions;
    }

    public boolean isSetDisplayDisconnectActions() {
        return ((this.displayDisconnectActions!= null)&&(!this.displayDisconnectActions.isEmpty()));
    }

    public void unsetDisplayDisconnectActions() {
        this.displayDisconnectActions = null;
    }

}
