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
 * <p>Java class for AuthorizedKeys complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="AuthorizedKeys">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseResources">
 *       &lt;sequence>
 *         &lt;element ref="{}authorized_key" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AuthorizedKeys", propOrder = {
    "authorizedKeys"
})
public class AuthorizedKeys
    extends BaseResources
{

    @XmlElement(name = "authorized_key")
    protected List<AuthorizedKey> authorizedKeys;

    /**
     * Gets the value of the authorizedKeys property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the authorizedKeys property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAuthorizedKeys().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AuthorizedKey }
     *
     *
     */
    public List<AuthorizedKey> getAuthorizedKeys() {
        if (authorizedKeys == null) {
            authorizedKeys = new ArrayList<AuthorizedKey>();
        }
        return this.authorizedKeys;
    }

    public boolean isSetAuthorizedKeys() {
        return ((this.authorizedKeys!= null)&&(!this.authorizedKeys.isEmpty()));
    }

    public void unsetAuthorizedKeys() {
        this.authorizedKeys = null;
    }

}

