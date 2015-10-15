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
 * <p>Java class for Cluster complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Cluster">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseResource">
 *       &lt;sequence>
 *         &lt;element ref="{}cpu" minOccurs="0"/>
 *         &lt;element ref="{}data_center" minOccurs="0"/>
 *         &lt;element name="memory_policy" type="{}MemoryPolicy" minOccurs="0"/>
 *         &lt;element name="scheduling_policy" type="{}SchedulingPolicy" minOccurs="0"/>
 *         &lt;element name="version" type="{}Version" minOccurs="0"/>
 *         &lt;element name="supported_versions" type="{}Versions" minOccurs="0"/>
 *         &lt;element name="error_handling" type="{}ErrorHandling" minOccurs="0"/>
 *         &lt;element name="virt_service" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="gluster_service" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="threads_as_cores" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="tunnel_migration" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="trusted_service" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ha_reservation" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="optional_reason" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="maintenance_reason_required" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ballooning_enabled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element ref="{}display" minOccurs="0"/>
 *         &lt;element ref="{}ksm" minOccurs="0"/>
 *         &lt;element ref="{}serial_number" minOccurs="0"/>
 *         &lt;element name="required_rng_sources" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="required_rng_source" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element ref="{}fencing_policy" minOccurs="0"/>
 *         &lt;element ref="{}migration" minOccurs="0"/>
 *         &lt;element name="management_network" type="{}Network" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Cluster", propOrder = {
    "cpu",
    "dataCenter",
    "memoryPolicy",
    "schedulingPolicy",
    "version",
    "supportedVersions",
    "errorHandling",
    "virtService",
    "glusterService",
    "threadsAsCores",
    "tunnelMigration",
    "trustedService",
    "haReservation",
    "optionalReason",
    "maintenanceReasonRequired",
    "ballooningEnabled",
    "display",
    "ksm",
    "serialNumber",
    "requiredRngSources",
    "fencingPolicy",
    "migration",
    "managementNetwork"
})
public class Cluster
    extends BaseResource
{

    protected Cpu cpu;
    @XmlElement(name = "data_center")
    protected DataCenter dataCenter;
    @XmlElement(name = "memory_policy")
    protected MemoryPolicy memoryPolicy;
    @XmlElement(name = "scheduling_policy")
    protected SchedulingPolicy schedulingPolicy;
    protected Version version;
    @XmlElement(name = "supported_versions")
    protected Versions supportedVersions;
    @XmlElement(name = "error_handling")
    protected ErrorHandling errorHandling;
    @XmlElement(name = "virt_service")
    protected Boolean virtService;
    @XmlElement(name = "gluster_service")
    protected Boolean glusterService;
    @XmlElement(name = "threads_as_cores")
    protected Boolean threadsAsCores;
    @XmlElement(name = "tunnel_migration")
    protected Boolean tunnelMigration;
    @XmlElement(name = "trusted_service")
    protected Boolean trustedService;
    @XmlElement(name = "ha_reservation")
    protected Boolean haReservation;
    @XmlElement(name = "optional_reason")
    protected Boolean optionalReason;
    @XmlElement(name = "maintenance_reason_required")
    protected Boolean maintenanceReasonRequired;
    @XmlElement(name = "ballooning_enabled")
    protected Boolean ballooningEnabled;
    protected Display display;
    protected Ksm ksm;
    @XmlElement(name = "serial_number")
    protected SerialNumber serialNumber;
    @XmlElement(name = "required_rng_sources")
    protected Cluster.RequiredRngSourcesList requiredRngSources;
    @XmlElement(name = "fencing_policy")
    protected FencingPolicy fencingPolicy;
    protected MigrationOptions migration;
    @XmlElement(name = "management_network")
    protected Network managementNetwork;

    /**
     * Gets the value of the cpu property.
     *
     * @return
     *     possible object is
     *     {@link Cpu }
     *
     */
    public Cpu getCpu() {
        return cpu;
    }

    /**
     * Sets the value of the cpu property.
     *
     * @param value
     *     allowed object is
     *     {@link Cpu }
     *
     */
    public void setCpu(Cpu value) {
        this.cpu = value;
    }

    public boolean isSetCpu() {
        return (this.cpu!= null);
    }

    /**
     * Gets the value of the dataCenter property.
     *
     * @return
     *     possible object is
     *     {@link DataCenter }
     *
     */
    public DataCenter getDataCenter() {
        return dataCenter;
    }

    /**
     * Sets the value of the dataCenter property.
     *
     * @param value
     *     allowed object is
     *     {@link DataCenter }
     *
     */
    public void setDataCenter(DataCenter value) {
        this.dataCenter = value;
    }

    public boolean isSetDataCenter() {
        return (this.dataCenter!= null);
    }

    /**
     * Gets the value of the memoryPolicy property.
     *
     * @return
     *     possible object is
     *     {@link MemoryPolicy }
     *
     */
    public MemoryPolicy getMemoryPolicy() {
        return memoryPolicy;
    }

    /**
     * Sets the value of the memoryPolicy property.
     *
     * @param value
     *     allowed object is
     *     {@link MemoryPolicy }
     *
     */
    public void setMemoryPolicy(MemoryPolicy value) {
        this.memoryPolicy = value;
    }

    public boolean isSetMemoryPolicy() {
        return (this.memoryPolicy!= null);
    }

    /**
     * Gets the value of the schedulingPolicy property.
     *
     * @return
     *     possible object is
     *     {@link SchedulingPolicy }
     *
     */
    public SchedulingPolicy getSchedulingPolicy() {
        return schedulingPolicy;
    }

    /**
     * Sets the value of the schedulingPolicy property.
     *
     * @param value
     *     allowed object is
     *     {@link SchedulingPolicy }
     *
     */
    public void setSchedulingPolicy(SchedulingPolicy value) {
        this.schedulingPolicy = value;
    }

    public boolean isSetSchedulingPolicy() {
        return (this.schedulingPolicy!= null);
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

    /**
     * Gets the value of the supportedVersions property.
     *
     * @return
     *     possible object is
     *     {@link Versions }
     *
     */
    public Versions getSupportedVersions() {
        return supportedVersions;
    }

    /**
     * Sets the value of the supportedVersions property.
     *
     * @param value
     *     allowed object is
     *     {@link Versions }
     *
     */
    public void setSupportedVersions(Versions value) {
        this.supportedVersions = value;
    }

    public boolean isSetSupportedVersions() {
        return (this.supportedVersions!= null);
    }

    /**
     * Gets the value of the errorHandling property.
     *
     * @return
     *     possible object is
     *     {@link ErrorHandling }
     *
     */
    public ErrorHandling getErrorHandling() {
        return errorHandling;
    }

    /**
     * Sets the value of the errorHandling property.
     *
     * @param value
     *     allowed object is
     *     {@link ErrorHandling }
     *
     */
    public void setErrorHandling(ErrorHandling value) {
        this.errorHandling = value;
    }

    public boolean isSetErrorHandling() {
        return (this.errorHandling!= null);
    }

    /**
     * Gets the value of the virtService property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getVirtService() {
        return virtService;
    }

    /**
     * Sets the value of the virtService property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setVirtService(Boolean value) {
        this.virtService = value;
    }

    public boolean isSetVirtService() {
        return (this.virtService!= null);
    }

    /**
     * Gets the value of the glusterService property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getGlusterService() {
        return glusterService;
    }

    /**
     * Sets the value of the glusterService property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setGlusterService(Boolean value) {
        this.glusterService = value;
    }

    public boolean isSetGlusterService() {
        return (this.glusterService!= null);
    }

    /**
     * Gets the value of the threadsAsCores property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getThreadsAsCores() {
        return threadsAsCores;
    }

    /**
     * Sets the value of the threadsAsCores property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setThreadsAsCores(Boolean value) {
        this.threadsAsCores = value;
    }

    public boolean isSetThreadsAsCores() {
        return (this.threadsAsCores!= null);
    }

    /**
     * Gets the value of the tunnelMigration property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getTunnelMigration() {
        return tunnelMigration;
    }

    /**
     * Sets the value of the tunnelMigration property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setTunnelMigration(Boolean value) {
        this.tunnelMigration = value;
    }

    public boolean isSetTunnelMigration() {
        return (this.tunnelMigration!= null);
    }

    /**
     * Gets the value of the trustedService property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getTrustedService() {
        return trustedService;
    }

    /**
     * Sets the value of the trustedService property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setTrustedService(Boolean value) {
        this.trustedService = value;
    }

    public boolean isSetTrustedService() {
        return (this.trustedService!= null);
    }

    /**
     * Gets the value of the haReservation property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getHaReservation() {
        return haReservation;
    }

    /**
     * Sets the value of the haReservation property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setHaReservation(Boolean value) {
        this.haReservation = value;
    }

    public boolean isSetHaReservation() {
        return (this.haReservation!= null);
    }

    /**
     * Gets the value of the optionalReason property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getOptionalReason() {
        return optionalReason;
    }

    /**
     * Sets the value of the optionalReason property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setOptionalReason(Boolean value) {
        this.optionalReason = value;
    }

    public boolean isSetOptionalReason() {
        return (this.optionalReason!= null);
    }

    /**
     * Gets the value of the maintenanceReasonRequired property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getMaintenanceReasonRequired() {
        return maintenanceReasonRequired;
    }

    /**
     * Sets the value of the maintenanceReasonRequired property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setMaintenanceReasonRequired(Boolean value) {
        this.maintenanceReasonRequired = value;
    }

    public boolean isSetMaintenanceReasonRequired() {
        return (this.maintenanceReasonRequired!= null);
    }

    /**
     * Gets the value of the ballooningEnabled property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getBallooningEnabled() {
        return ballooningEnabled;
    }

    /**
     * Sets the value of the ballooningEnabled property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setBallooningEnabled(Boolean value) {
        this.ballooningEnabled = value;
    }

    public boolean isSetBallooningEnabled() {
        return (this.ballooningEnabled!= null);
    }

    /**
     * Gets the value of the display property.
     *
     * @return
     *     possible object is
     *     {@link Display }
     *
     */
    public Display getDisplay() {
        return display;
    }

    /**
     * Sets the value of the display property.
     *
     * @param value
     *     allowed object is
     *     {@link Display }
     *
     */
    public void setDisplay(Display value) {
        this.display = value;
    }

    public boolean isSetDisplay() {
        return (this.display!= null);
    }

    /**
     * Gets the value of the ksm property.
     *
     * @return
     *     possible object is
     *     {@link Ksm }
     *
     */
    public Ksm getKsm() {
        return ksm;
    }

    /**
     * Sets the value of the ksm property.
     *
     * @param value
     *     allowed object is
     *     {@link Ksm }
     *
     */
    public void setKsm(Ksm value) {
        this.ksm = value;
    }

    public boolean isSetKsm() {
        return (this.ksm!= null);
    }

    /**
     * Gets the value of the serialNumber property.
     *
     * @return
     *     possible object is
     *     {@link SerialNumber }
     *
     */
    public SerialNumber getSerialNumber() {
        return serialNumber;
    }

    /**
     * Sets the value of the serialNumber property.
     *
     * @param value
     *     allowed object is
     *     {@link SerialNumber }
     *
     */
    public void setSerialNumber(SerialNumber value) {
        this.serialNumber = value;
    }

    public boolean isSetSerialNumber() {
        return (this.serialNumber!= null);
    }

    /**
     * Gets the value of the requiredRngSources property.
     *
     * @return
     *     possible object is
     *     {@link Cluster.RequiredRngSourcesList }
     *
     */
    public Cluster.RequiredRngSourcesList getRequiredRngSources() {
        return requiredRngSources;
    }

    /**
     * Sets the value of the requiredRngSources property.
     *
     * @param value
     *     allowed object is
     *     {@link Cluster.RequiredRngSourcesList }
     *
     */
    public void setRequiredRngSources(Cluster.RequiredRngSourcesList value) {
        this.requiredRngSources = value;
    }

    public boolean isSetRequiredRngSources() {
        return (this.requiredRngSources!= null);
    }

    /**
     * Gets the value of the fencingPolicy property.
     *
     * @return
     *     possible object is
     *     {@link FencingPolicy }
     *
     */
    public FencingPolicy getFencingPolicy() {
        return fencingPolicy;
    }

    /**
     * Sets the value of the fencingPolicy property.
     *
     * @param value
     *     allowed object is
     *     {@link FencingPolicy }
     *
     */
    public void setFencingPolicy(FencingPolicy value) {
        this.fencingPolicy = value;
    }

    public boolean isSetFencingPolicy() {
        return (this.fencingPolicy!= null);
    }

    /**
     * Gets the value of the migration property.
     *
     * @return
     *     possible object is
     *     {@link MigrationOptions }
     *
     */
    public MigrationOptions getMigration() {
        return migration;
    }

    /**
     * Sets the value of the migration property.
     *
     * @param value
     *     allowed object is
     *     {@link MigrationOptions }
     *
     */
    public void setMigration(MigrationOptions value) {
        this.migration = value;
    }

    public boolean isSetMigration() {
        return (this.migration!= null);
    }

    /**
     * Gets the value of the managementNetwork property.
     *
     * @return
     *     possible object is
     *     {@link Network }
     *
     */
    public Network getManagementNetwork() {
        return managementNetwork;
    }

    /**
     * Sets the value of the managementNetwork property.
     *
     * @param value
     *     allowed object is
     *     {@link Network }
     *
     */
    public void setManagementNetwork(Network value) {
        this.managementNetwork = value;
    }

    public boolean isSetManagementNetwork() {
        return (this.managementNetwork!= null);
    }


    /**
     * <p>Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="required_rng_source" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "requiredRngSources"
    })
    public static class RequiredRngSourcesList {

        @XmlElement(name = "required_rng_source")
        protected List<String> requiredRngSources;

        /**
         * Gets the value of the requiredRngSources property.
         *
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the requiredRngSources property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getRequiredRngSources().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         *
         *
         */
        public List<String> getRequiredRngSources() {
            if (requiredRngSources == null) {
                requiredRngSources = new ArrayList<String>();
            }
            return this.requiredRngSources;
        }

        public boolean isSetRequiredRngSources() {
            return ((this.requiredRngSources!= null)&&(!this.requiredRngSources.isEmpty()));
        }

        public void unsetRequiredRngSources() {
            this.requiredRngSources = null;
        }

    }

}
