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
 * <p>Java class for WatchDogs complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="WatchDogs">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseDevices">
 *       &lt;sequence>
 *         &lt;element ref="{}watchdog" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WatchDogs", propOrder = {
    "watchDogs"
})
public class WatchDogs
    extends BaseDevices
{

    @XmlElement(name = "watchdog")
    protected List<WatchDog> watchDogs;

    /**
     * Gets the value of the watchDogs property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the watchDogs property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWatchDogs().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WatchDog }
     *
     *
     */
    public List<WatchDog> getWatchDogs() {
        if (watchDogs == null) {
            watchDogs = new ArrayList<WatchDog>();
        }
        return this.watchDogs;
    }

    public boolean isSetWatchDogs() {
        return ((this.watchDogs!= null)&&(!this.watchDogs.isEmpty()));
    }

    public void unsetWatchDogs() {
        this.watchDogs = null;
    }

}

