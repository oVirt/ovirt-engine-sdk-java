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
 * <p>Java class for OpenStackNetworkProvider complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="OpenStackNetworkProvider">
 *   &lt;complexContent>
 *     &lt;extension base="{}OpenStackProvider">
 *       &lt;sequence>
 *         &lt;element name="plugin_type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element ref="{}agent_configuration" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OpenStackNetworkProvider", propOrder = {
    "pluginType",
    "agentConfiguration"
})
public class OpenStackNetworkProvider
    extends OpenStackProvider
{

    @XmlElement(name = "plugin_type", required = true)
    protected String pluginType;
    @XmlElement(name = "agent_configuration")
    protected AgentConfiguration agentConfiguration;

    /**
     * Gets the value of the pluginType property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getPluginType() {
        return pluginType;
    }

    /**
     * Sets the value of the pluginType property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setPluginType(String value) {
        this.pluginType = value;
    }

    public boolean isSetPluginType() {
        return (this.pluginType!= null);
    }

    /**
     * Gets the value of the agentConfiguration property.
     *
     * @return
     *     possible object is
     *     {@link AgentConfiguration }
     *
     */
    public AgentConfiguration getAgentConfiguration() {
        return agentConfiguration;
    }

    /**
     * Sets the value of the agentConfiguration property.
     *
     * @param value
     *     allowed object is
     *     {@link AgentConfiguration }
     *
     */
    public void setAgentConfiguration(AgentConfiguration value) {
        this.agentConfiguration = value;
    }

    public boolean isSetAgentConfiguration() {
        return (this.agentConfiguration!= null);
    }

}
