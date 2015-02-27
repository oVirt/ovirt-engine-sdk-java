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
 * <p>Java class for KatelloErrata complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="KatelloErrata">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseResources">
 *       &lt;sequence>
 *         &lt;element ref="{}katello_erratum" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "KatelloErrata", propOrder = {
    "katelloErrata"
})
public class KatelloErrata
    extends BaseResources
{

    @XmlElement(name = "katello_erratum")
    protected List<KatelloErratum> katelloErrata;

    /**
     * Gets the value of the katelloErrata property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the katelloErrata property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKatelloErrata().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link KatelloErratum }
     *
     *
     */
    public List<KatelloErratum> getKatelloErrata() {
        if (katelloErrata == null) {
            katelloErrata = new ArrayList<KatelloErratum>();
        }
        return this.katelloErrata;
    }

    public boolean isSetKatelloErrata() {
        return ((this.katelloErrata!= null)&&(!this.katelloErrata.isEmpty()));
    }

    public void unsetKatelloErrata() {
        this.katelloErrata = null;
    }

}
