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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CpuTopology complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="CpuTopology">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="sockets" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="cores" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="threads" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CpuTopology")
public class CpuTopology {

    @XmlAttribute(name = "sockets")
    protected Integer sockets;
    @XmlAttribute(name = "cores")
    protected Integer cores;
    @XmlAttribute(name = "threads")
    protected Integer threads;

    /**
     * Gets the value of the sockets property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getSockets() {
        return sockets;
    }

    /**
     * Sets the value of the sockets property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setSockets(Integer value) {
        this.sockets = value;
    }

    /**
     * Gets the value of the cores property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getCores() {
        return cores;
    }

    /**
     * Sets the value of the cores property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setCores(Integer value) {
        this.cores = value;
    }

    /**
     * Gets the value of the threads property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getThreads() {
        return threads;
    }

    /**
     * Sets the value of the threads property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setThreads(Integer value) {
        this.threads = value;
    }

}

