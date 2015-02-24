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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BaseResources complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="BaseResources">
 *   &lt;complexContent>
 *     &lt;extension base="{}ActionableResource">
 *       &lt;sequence>
 *         &lt;element name="total" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *         &lt;element name="active" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BaseResources", propOrder = {
    "total",
    "active"
})
@XmlSeeAlso({
    GlusterServerHooks.class,
    Events.class,
    MacPools.class,
    Hosts.class,
    AuthorizedKeys.class,
    IPs.class,
    Labels.class,
    Tags.class,
    Permits.class,
    Networks.class,
    DataCenters.class,
    Balances.class,
    CpuProfiles.class,
    Hooks.class,
    Jobs.class,
    DiskProfiles.class,
    GlusterMemoryPools.class,
    GlusterVolumes.class,
    Bookmarks.class,
    VMs.class,
    HostNics.class,
    PreviewVMs.class,
    Users.class,
    Roles.class,
    QoSs.class,
    Clusters.class,
    Capabilities.class,
    Filters.class,
    OperatingSystemInfos.class,
    Applications.class,
    SchedulingPolicies.class,
    Permissions.class,
    Images.class,
    VnicProfiles.class,
    Sessions.class,
    ReportedDevices.class,
    Templates.class,
    StorageDomains.class,
    Snapshots.class,
    HostStorage.class,
    Statistics.class,
    SchedulingPolicyUnits.class,
    Quotas.class,
    StorageConnections.class,
    Domains.class,
    Weights.class,
    Steps.class,
    GlusterClients.class,
    Files.class,
    GlusterHooks.class,
    InstanceTypes.class,
    NumaNodes.class,
    AffinityGroups.class,
    GlusterBricks.class,
    Groups.class,
    IscsiBonds.class,
    VmPools.class,
    BaseDevices.class
})
public class BaseResources
    extends ActionableResource
{

    @XmlSchemaType(name = "unsignedInt")
    protected Long total;
    @XmlSchemaType(name = "unsignedInt")
    protected Long active;

    /**
     * Gets the value of the total property.
     *
     * @return
     *     possible object is
     *     {@link Long }
     *
     */
    public Long getTotal() {
        return total;
    }

    /**
     * Sets the value of the total property.
     *
     * @param value
     *     allowed object is
     *     {@link Long }
     *
     */
    public void setTotal(Long value) {
        this.total = value;
    }

    public boolean isSetTotal() {
        return (this.total!= null);
    }

    /**
     * Gets the value of the active property.
     *
     * @return
     *     possible object is
     *     {@link Long }
     *
     */
    public Long getActive() {
        return active;
    }

    /**
     * Sets the value of the active property.
     *
     * @param value
     *     allowed object is
     *     {@link Long }
     *
     */
    public void setActive(Long value) {
        this.active = value;
    }

    public boolean isSetActive() {
        return (this.active!= null);
    }

}
