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
 * <p>Java class for VersionCaps complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="VersionCaps">
 *   &lt;complexContent>
 *     &lt;extension base="{}Version">
 *       &lt;sequence>
 *         &lt;element name="current" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="features" type="{}Features" minOccurs="0"/>
 *         &lt;element ref="{}cpus" minOccurs="0"/>
 *         &lt;element ref="{}power_managers" minOccurs="0"/>
 *         &lt;element ref="{}fence_types" minOccurs="0"/>
 *         &lt;element ref="{}storage_types" minOccurs="0"/>
 *         &lt;element ref="{}configuration_types" minOccurs="0"/>
 *         &lt;element ref="{}storage_domain_types" minOccurs="0"/>
 *         &lt;element ref="{}vm_types" minOccurs="0"/>
 *         &lt;element ref="{}boot_devices" minOccurs="0"/>
 *         &lt;element ref="{}display_types" minOccurs="0"/>
 *         &lt;element ref="{}nic_interfaces" minOccurs="0"/>
 *         &lt;element ref="{}os_types" minOccurs="0"/>
 *         &lt;element ref="{}disk_formats" minOccurs="0"/>
 *         &lt;element ref="{}disk_interfaces" minOccurs="0"/>
 *         &lt;element ref="{}vm_affinities" minOccurs="0"/>
 *         &lt;element ref="{}custom_properties" minOccurs="0"/>
 *         &lt;element ref="{}boot_protocols" minOccurs="0"/>
 *         &lt;element ref="{}error_handling" minOccurs="0"/>
 *         &lt;element ref="{}storage_formats" minOccurs="0"/>
 *         &lt;element ref="{}creation_states" minOccurs="0"/>
 *         &lt;element ref="{}power_management_states" minOccurs="0"/>
 *         &lt;element ref="{}host_states" minOccurs="0"/>
 *         &lt;element ref="{}host_protocols" minOccurs="0"/>
 *         &lt;element ref="{}host_non_operational_details" minOccurs="0"/>
 *         &lt;element ref="{}network_states" minOccurs="0"/>
 *         &lt;element ref="{}storage_domain_states" minOccurs="0"/>
 *         &lt;element ref="{}template_states" minOccurs="0"/>
 *         &lt;element ref="{}vm_states" minOccurs="0"/>
 *         &lt;element ref="{}vm_pause_details" minOccurs="0"/>
 *         &lt;element ref="{}disk_states" minOccurs="0"/>
 *         &lt;element ref="{}host_nic_states" minOccurs="0"/>
 *         &lt;element ref="{}data_center_states" minOccurs="0"/>
 *         &lt;element ref="{}vm_device_types" minOccurs="0"/>
 *         &lt;element ref="{}permits" minOccurs="0"/>
 *         &lt;element ref="{}scheduling_policies" minOccurs="0"/>
 *         &lt;element ref="{}usages" minOccurs="0"/>
 *         &lt;element ref="{}nfs_versions" minOccurs="0"/>
 *         &lt;element ref="{}pm_proxy_types" minOccurs="0"/>
 *         &lt;element ref="{}cpu_modes" minOccurs="0"/>
 *         &lt;element ref="{}sgio_options" minOccurs="0"/>
 *         &lt;element ref="{}watchdog_models" minOccurs="0"/>
 *         &lt;element ref="{}watchdog_actions" minOccurs="0"/>
 *         &lt;element ref="{}authentication_methods" minOccurs="0"/>
 *         &lt;element ref="{}kdump_states" minOccurs="0"/>
 *         &lt;element ref="{}spm_states" minOccurs="0"/>
 *         &lt;element ref="{}vm_pool_types" minOccurs="0"/>
 *         &lt;element ref="{}step_types" minOccurs="0"/>
 *         &lt;element ref="{}payload_encodings" minOccurs="0"/>
 *         &lt;element ref="{}gluster_volume_types" minOccurs="0"/>
 *         &lt;element ref="{}transport_types" minOccurs="0"/>
 *         &lt;element ref="{}gluster_volume_states" minOccurs="0"/>
 *         &lt;element ref="{}brick_states" minOccurs="0"/>
 *         &lt;element ref="{}reported_device_types" minOccurs="0"/>
 *         &lt;element ref="{}ip_versions" minOccurs="0"/>
 *         &lt;element ref="{}snapshot_statuses" minOccurs="0"/>
 *         &lt;element ref="{}content_types" minOccurs="0"/>
 *         &lt;element ref="{}hook_states" minOccurs="0"/>
 *         &lt;element ref="{}stages" minOccurs="0"/>
 *         &lt;element ref="{}sso_methods" minOccurs="0"/>
 *         &lt;element ref="{}architecture_capabilities" minOccurs="0"/>
 *         &lt;element ref="{}serial_number_policies" minOccurs="0"/>
 *         &lt;element ref="{}selinux_modes" minOccurs="0"/>
 *         &lt;element ref="{}rng_sources" minOccurs="0"/>
 *         &lt;element ref="{}scheduling_policy_unit_types" minOccurs="0"/>
 *         &lt;element ref="{}qos_types" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VersionCaps", propOrder = {
    "current",
    "features",
    "cpus",
    "powerManagers",
    "fenceTypes",
    "storageTypes",
    "configurationTypes",
    "storageDomainTypes",
    "vmTypes",
    "bootDevices",
    "displayTypes",
    "nicInterfaces",
    "osTypes",
    "diskFormats",
    "diskInterfaces",
    "vmAffinities",
    "customProperties",
    "bootProtocols",
    "errorHandling",
    "storageFormats",
    "creationStates",
    "powerManagementStates",
    "hostStates",
    "hostProtocols",
    "hostNonOperationalDetails",
    "networkStates",
    "storageDomainStates",
    "templateStates",
    "vmStates",
    "vmPauseDetails",
    "diskStates",
    "hostNicStates",
    "dataCenterStates",
    "vmDeviceTypes",
    "permits",
    "schedulingPolicies",
    "usages",
    "nfsVersions",
    "pmProxyTypes",
    "cpuModes",
    "sgioOptions",
    "watchdogModels",
    "watchdogActions",
    "authenticationMethods",
    "kdumpStates",
    "spmStates",
    "vmPoolTypes",
    "stepTypes",
    "payloadEncodings",
    "glusterVolumeTypes",
    "transportTypes",
    "glusterVolumeStates",
    "brickStates",
    "reportedDeviceTypes",
    "ipVersions",
    "snapshotStatuses",
    "contentTypes",
    "hookStates",
    "stages",
    "ssoMethods",
    "architectureCapabilities",
    "serialNumberPolicies",
    "selinuxModes",
    "rngSources",
    "schedulingPolicyUnitTypes",
    "qosTypes"
})
public class VersionCaps
    extends Version
{

    protected Boolean current;
    protected Features features;
    protected CPUs cpus;
    @XmlElement(name = "power_managers")
    protected PowerManagers powerManagers;
    @XmlElement(name = "fence_types")
    protected FenceTypes fenceTypes;
    @XmlElement(name = "storage_types")
    protected StorageTypes storageTypes;
    @XmlElement(name = "configuration_types")
    protected ConfigurationTypes configurationTypes;
    @XmlElement(name = "storage_domain_types")
    protected StorageDomainTypes storageDomainTypes;
    @XmlElement(name = "vm_types")
    protected VmTypes vmTypes;
    @XmlElement(name = "boot_devices")
    protected BootDevices bootDevices;
    @XmlElement(name = "display_types")
    protected DisplayTypes displayTypes;
    @XmlElement(name = "nic_interfaces")
    protected NicInterfaces nicInterfaces;
    @XmlElement(name = "os_types")
    protected OsTypes osTypes;
    @XmlElement(name = "disk_formats")
    protected DiskFormats diskFormats;
    @XmlElement(name = "disk_interfaces")
    protected DiskInterfaces diskInterfaces;
    @XmlElement(name = "vm_affinities")
    protected VmAffinities vmAffinities;
    @XmlElement(name = "custom_properties")
    protected CustomProperties customProperties;
    @XmlElement(name = "boot_protocols")
    protected BootProtocols bootProtocols;
    @XmlElement(name = "error_handling")
    protected ErrorHandlingOptions errorHandling;
    @XmlElement(name = "storage_formats")
    protected StorageFormats storageFormats;
    @XmlElement(name = "creation_states")
    protected CreationStates creationStates;
    @XmlElement(name = "power_management_states")
    protected PowerManagementStates powerManagementStates;
    @XmlElement(name = "host_states")
    protected HostStates hostStates;
    @XmlElement(name = "host_protocols")
    protected HostProtocols hostProtocols;
    @XmlElement(name = "host_non_operational_details")
    protected HostNonOperationalDetails hostNonOperationalDetails;
    @XmlElement(name = "network_states")
    protected NetworkStates networkStates;
    @XmlElement(name = "storage_domain_states")
    protected StorageDomainStates storageDomainStates;
    @XmlElement(name = "template_states")
    protected TemplateStates templateStates;
    @XmlElement(name = "vm_states")
    protected VmStates vmStates;
    @XmlElement(name = "vm_pause_details")
    protected VmPauseDetails vmPauseDetails;
    @XmlElement(name = "disk_states")
    protected DiskStates diskStates;
    @XmlElement(name = "host_nic_states")
    protected HostNICStates hostNicStates;
    @XmlElement(name = "data_center_states")
    protected DataCenterStates dataCenterStates;
    @XmlElement(name = "vm_device_types")
    protected VmDeviceTypes vmDeviceTypes;
    protected Permits permits;
    @XmlElement(name = "scheduling_policies")
    protected SchedulingPolicies schedulingPolicies;
    protected Usages usages;
    @XmlElement(name = "nfs_versions")
    protected NfsVersions nfsVersions;
    @XmlElement(name = "pm_proxy_types")
    protected PmProxyTypes pmProxyTypes;
    @XmlElement(name = "cpu_modes")
    protected CpuModes cpuModes;
    @XmlElement(name = "sgio_options")
    protected ScsiGenericIoOptions sgioOptions;
    @XmlElement(name = "watchdog_models")
    protected WatchdogModels watchdogModels;
    @XmlElement(name = "watchdog_actions")
    protected WatchdogActions watchdogActions;
    @XmlElement(name = "authentication_methods")
    protected AuthenticationMethod authenticationMethods;
    @XmlElement(name = "kdump_states")
    protected KdumpStates kdumpStates;
    @XmlElement(name = "spm_states")
    protected SpmStates spmStates;
    @XmlElement(name = "vm_pool_types")
    protected VmPoolTypes vmPoolTypes;
    @XmlElement(name = "step_types")
    protected StepTypes stepTypes;
    @XmlElement(name = "payload_encodings")
    protected PayloadEncodings payloadEncodings;
    @XmlElement(name = "gluster_volume_types")
    protected GlusterVolumeTypes glusterVolumeTypes;
    @XmlElement(name = "transport_types")
    protected TransportTypes transportTypes;
    @XmlElement(name = "gluster_volume_states")
    protected GlusterStates glusterVolumeStates;
    @XmlElement(name = "brick_states")
    protected GlusterStates brickStates;
    @XmlElement(name = "reported_device_types")
    protected ReportedDeviceTypes reportedDeviceTypes;
    @XmlElement(name = "ip_versions")
    protected IpVersions ipVersions;
    @XmlElement(name = "snapshot_statuses")
    protected SnapshotStatuses snapshotStatuses;
    @XmlElement(name = "content_types")
    protected ContentTypes contentTypes;
    @XmlElement(name = "hook_states")
    protected HookStates hookStates;
    protected Stages stages;
    @XmlElement(name = "sso_methods")
    protected SsoMethods ssoMethods;
    @XmlElement(name = "architecture_capabilities")
    protected ArchitectureCapabilities architectureCapabilities;
    @XmlElement(name = "serial_number_policies")
    protected SerialNumberPolicies serialNumberPolicies;
    @XmlElement(name = "selinux_modes")
    protected SELinuxModes selinuxModes;
    @XmlElement(name = "rng_sources")
    protected RngSources rngSources;
    @XmlElement(name = "scheduling_policy_unit_types")
    protected SchedulingPolicyUnitTypes schedulingPolicyUnitTypes;
    @XmlElement(name = "qos_types")
    protected QosTypes qosTypes;

    /**
     * Gets the value of the current property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getCurrent() {
        return current;
    }

    /**
     * Sets the value of the current property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setCurrent(Boolean value) {
        this.current = value;
    }

    public boolean isSetCurrent() {
        return (this.current!= null);
    }

    /**
     * Gets the value of the features property.
     *
     * @return
     *     possible object is
     *     {@link Features }
     *
     */
    public Features getFeatures() {
        return features;
    }

    /**
     * Sets the value of the features property.
     *
     * @param value
     *     allowed object is
     *     {@link Features }
     *
     */
    public void setFeatures(Features value) {
        this.features = value;
    }

    public boolean isSetFeatures() {
        return (this.features!= null);
    }

    /**
     * Gets the value of the cpus property.
     *
     * @return
     *     possible object is
     *     {@link CPUs }
     *
     */
    public CPUs getCpus() {
        return cpus;
    }

    /**
     * Sets the value of the cpus property.
     *
     * @param value
     *     allowed object is
     *     {@link CPUs }
     *
     */
    public void setCpus(CPUs value) {
        this.cpus = value;
    }

    public boolean isSetCpus() {
        return (this.cpus!= null);
    }

    /**
     * Gets the value of the powerManagers property.
     *
     * @return
     *     possible object is
     *     {@link PowerManagers }
     *
     */
    public PowerManagers getPowerManagers() {
        return powerManagers;
    }

    /**
     * Sets the value of the powerManagers property.
     *
     * @param value
     *     allowed object is
     *     {@link PowerManagers }
     *
     */
    public void setPowerManagers(PowerManagers value) {
        this.powerManagers = value;
    }

    public boolean isSetPowerManagers() {
        return (this.powerManagers!= null);
    }

    /**
     * Gets the value of the fenceTypes property.
     *
     * @return
     *     possible object is
     *     {@link FenceTypes }
     *
     */
    public FenceTypes getFenceTypes() {
        return fenceTypes;
    }

    /**
     * Sets the value of the fenceTypes property.
     *
     * @param value
     *     allowed object is
     *     {@link FenceTypes }
     *
     */
    public void setFenceTypes(FenceTypes value) {
        this.fenceTypes = value;
    }

    public boolean isSetFenceTypes() {
        return (this.fenceTypes!= null);
    }

    /**
     * Gets the value of the storageTypes property.
     *
     * @return
     *     possible object is
     *     {@link StorageTypes }
     *
     */
    public StorageTypes getStorageTypes() {
        return storageTypes;
    }

    /**
     * Sets the value of the storageTypes property.
     *
     * @param value
     *     allowed object is
     *     {@link StorageTypes }
     *
     */
    public void setStorageTypes(StorageTypes value) {
        this.storageTypes = value;
    }

    public boolean isSetStorageTypes() {
        return (this.storageTypes!= null);
    }

    /**
     * Gets the value of the configurationTypes property.
     *
     * @return
     *     possible object is
     *     {@link ConfigurationTypes }
     *
     */
    public ConfigurationTypes getConfigurationTypes() {
        return configurationTypes;
    }

    /**
     * Sets the value of the configurationTypes property.
     *
     * @param value
     *     allowed object is
     *     {@link ConfigurationTypes }
     *
     */
    public void setConfigurationTypes(ConfigurationTypes value) {
        this.configurationTypes = value;
    }

    public boolean isSetConfigurationTypes() {
        return (this.configurationTypes!= null);
    }

    /**
     * Gets the value of the storageDomainTypes property.
     *
     * @return
     *     possible object is
     *     {@link StorageDomainTypes }
     *
     */
    public StorageDomainTypes getStorageDomainTypes() {
        return storageDomainTypes;
    }

    /**
     * Sets the value of the storageDomainTypes property.
     *
     * @param value
     *     allowed object is
     *     {@link StorageDomainTypes }
     *
     */
    public void setStorageDomainTypes(StorageDomainTypes value) {
        this.storageDomainTypes = value;
    }

    public boolean isSetStorageDomainTypes() {
        return (this.storageDomainTypes!= null);
    }

    /**
     * Gets the value of the vmTypes property.
     *
     * @return
     *     possible object is
     *     {@link VmTypes }
     *
     */
    public VmTypes getVmTypes() {
        return vmTypes;
    }

    /**
     * Sets the value of the vmTypes property.
     *
     * @param value
     *     allowed object is
     *     {@link VmTypes }
     *
     */
    public void setVmTypes(VmTypes value) {
        this.vmTypes = value;
    }

    public boolean isSetVmTypes() {
        return (this.vmTypes!= null);
    }

    /**
     * Gets the value of the bootDevices property.
     *
     * @return
     *     possible object is
     *     {@link BootDevices }
     *
     */
    public BootDevices getBootDevices() {
        return bootDevices;
    }

    /**
     * Sets the value of the bootDevices property.
     *
     * @param value
     *     allowed object is
     *     {@link BootDevices }
     *
     */
    public void setBootDevices(BootDevices value) {
        this.bootDevices = value;
    }

    public boolean isSetBootDevices() {
        return (this.bootDevices!= null);
    }

    /**
     * Gets the value of the displayTypes property.
     *
     * @return
     *     possible object is
     *     {@link DisplayTypes }
     *
     */
    public DisplayTypes getDisplayTypes() {
        return displayTypes;
    }

    /**
     * Sets the value of the displayTypes property.
     *
     * @param value
     *     allowed object is
     *     {@link DisplayTypes }
     *
     */
    public void setDisplayTypes(DisplayTypes value) {
        this.displayTypes = value;
    }

    public boolean isSetDisplayTypes() {
        return (this.displayTypes!= null);
    }

    /**
     * Gets the value of the nicInterfaces property.
     *
     * @return
     *     possible object is
     *     {@link NicInterfaces }
     *
     */
    public NicInterfaces getNicInterfaces() {
        return nicInterfaces;
    }

    /**
     * Sets the value of the nicInterfaces property.
     *
     * @param value
     *     allowed object is
     *     {@link NicInterfaces }
     *
     */
    public void setNicInterfaces(NicInterfaces value) {
        this.nicInterfaces = value;
    }

    public boolean isSetNicInterfaces() {
        return (this.nicInterfaces!= null);
    }

    /**
     * Gets the value of the osTypes property.
     *
     * @return
     *     possible object is
     *     {@link OsTypes }
     *
     */
    public OsTypes getOsTypes() {
        return osTypes;
    }

    /**
     * Sets the value of the osTypes property.
     *
     * @param value
     *     allowed object is
     *     {@link OsTypes }
     *
     */
    public void setOsTypes(OsTypes value) {
        this.osTypes = value;
    }

    public boolean isSetOsTypes() {
        return (this.osTypes!= null);
    }

    /**
     * Gets the value of the diskFormats property.
     *
     * @return
     *     possible object is
     *     {@link DiskFormats }
     *
     */
    public DiskFormats getDiskFormats() {
        return diskFormats;
    }

    /**
     * Sets the value of the diskFormats property.
     *
     * @param value
     *     allowed object is
     *     {@link DiskFormats }
     *
     */
    public void setDiskFormats(DiskFormats value) {
        this.diskFormats = value;
    }

    public boolean isSetDiskFormats() {
        return (this.diskFormats!= null);
    }

    /**
     * Gets the value of the diskInterfaces property.
     *
     * @return
     *     possible object is
     *     {@link DiskInterfaces }
     *
     */
    public DiskInterfaces getDiskInterfaces() {
        return diskInterfaces;
    }

    /**
     * Sets the value of the diskInterfaces property.
     *
     * @param value
     *     allowed object is
     *     {@link DiskInterfaces }
     *
     */
    public void setDiskInterfaces(DiskInterfaces value) {
        this.diskInterfaces = value;
    }

    public boolean isSetDiskInterfaces() {
        return (this.diskInterfaces!= null);
    }

    /**
     * Gets the value of the vmAffinities property.
     *
     * @return
     *     possible object is
     *     {@link VmAffinities }
     *
     */
    public VmAffinities getVmAffinities() {
        return vmAffinities;
    }

    /**
     * Sets the value of the vmAffinities property.
     *
     * @param value
     *     allowed object is
     *     {@link VmAffinities }
     *
     */
    public void setVmAffinities(VmAffinities value) {
        this.vmAffinities = value;
    }

    public boolean isSetVmAffinities() {
        return (this.vmAffinities!= null);
    }

    /**
     * Gets the value of the customProperties property.
     *
     * @return
     *     possible object is
     *     {@link CustomProperties }
     *
     */
    public CustomProperties getCustomProperties() {
        return customProperties;
    }

    /**
     * Sets the value of the customProperties property.
     *
     * @param value
     *     allowed object is
     *     {@link CustomProperties }
     *
     */
    public void setCustomProperties(CustomProperties value) {
        this.customProperties = value;
    }

    public boolean isSetCustomProperties() {
        return (this.customProperties!= null);
    }

    /**
     * Gets the value of the bootProtocols property.
     *
     * @return
     *     possible object is
     *     {@link BootProtocols }
     *
     */
    public BootProtocols getBootProtocols() {
        return bootProtocols;
    }

    /**
     * Sets the value of the bootProtocols property.
     *
     * @param value
     *     allowed object is
     *     {@link BootProtocols }
     *
     */
    public void setBootProtocols(BootProtocols value) {
        this.bootProtocols = value;
    }

    public boolean isSetBootProtocols() {
        return (this.bootProtocols!= null);
    }

    /**
     * Gets the value of the errorHandling property.
     *
     * @return
     *     possible object is
     *     {@link ErrorHandlingOptions }
     *
     */
    public ErrorHandlingOptions getErrorHandling() {
        return errorHandling;
    }

    /**
     * Sets the value of the errorHandling property.
     *
     * @param value
     *     allowed object is
     *     {@link ErrorHandlingOptions }
     *
     */
    public void setErrorHandling(ErrorHandlingOptions value) {
        this.errorHandling = value;
    }

    public boolean isSetErrorHandling() {
        return (this.errorHandling!= null);
    }

    /**
     * Gets the value of the storageFormats property.
     *
     * @return
     *     possible object is
     *     {@link StorageFormats }
     *
     */
    public StorageFormats getStorageFormats() {
        return storageFormats;
    }

    /**
     * Sets the value of the storageFormats property.
     *
     * @param value
     *     allowed object is
     *     {@link StorageFormats }
     *
     */
    public void setStorageFormats(StorageFormats value) {
        this.storageFormats = value;
    }

    public boolean isSetStorageFormats() {
        return (this.storageFormats!= null);
    }

    /**
     * Gets the value of the creationStates property.
     *
     * @return
     *     possible object is
     *     {@link CreationStates }
     *
     */
    public CreationStates getCreationStates() {
        return creationStates;
    }

    /**
     * Sets the value of the creationStates property.
     *
     * @param value
     *     allowed object is
     *     {@link CreationStates }
     *
     */
    public void setCreationStates(CreationStates value) {
        this.creationStates = value;
    }

    public boolean isSetCreationStates() {
        return (this.creationStates!= null);
    }

    /**
     * Gets the value of the powerManagementStates property.
     *
     * @return
     *     possible object is
     *     {@link PowerManagementStates }
     *
     */
    public PowerManagementStates getPowerManagementStates() {
        return powerManagementStates;
    }

    /**
     * Sets the value of the powerManagementStates property.
     *
     * @param value
     *     allowed object is
     *     {@link PowerManagementStates }
     *
     */
    public void setPowerManagementStates(PowerManagementStates value) {
        this.powerManagementStates = value;
    }

    public boolean isSetPowerManagementStates() {
        return (this.powerManagementStates!= null);
    }

    /**
     * Gets the value of the hostStates property.
     *
     * @return
     *     possible object is
     *     {@link HostStates }
     *
     */
    public HostStates getHostStates() {
        return hostStates;
    }

    /**
     * Sets the value of the hostStates property.
     *
     * @param value
     *     allowed object is
     *     {@link HostStates }
     *
     */
    public void setHostStates(HostStates value) {
        this.hostStates = value;
    }

    public boolean isSetHostStates() {
        return (this.hostStates!= null);
    }

    /**
     * Gets the value of the hostProtocols property.
     *
     * @return
     *     possible object is
     *     {@link HostProtocols }
     *
     */
    public HostProtocols getHostProtocols() {
        return hostProtocols;
    }

    /**
     * Sets the value of the hostProtocols property.
     *
     * @param value
     *     allowed object is
     *     {@link HostProtocols }
     *
     */
    public void setHostProtocols(HostProtocols value) {
        this.hostProtocols = value;
    }

    public boolean isSetHostProtocols() {
        return (this.hostProtocols!= null);
    }

    /**
     * Gets the value of the hostNonOperationalDetails property.
     *
     * @return
     *     possible object is
     *     {@link HostNonOperationalDetails }
     *
     */
    public HostNonOperationalDetails getHostNonOperationalDetails() {
        return hostNonOperationalDetails;
    }

    /**
     * Sets the value of the hostNonOperationalDetails property.
     *
     * @param value
     *     allowed object is
     *     {@link HostNonOperationalDetails }
     *
     */
    public void setHostNonOperationalDetails(HostNonOperationalDetails value) {
        this.hostNonOperationalDetails = value;
    }

    public boolean isSetHostNonOperationalDetails() {
        return (this.hostNonOperationalDetails!= null);
    }

    /**
     * Gets the value of the networkStates property.
     *
     * @return
     *     possible object is
     *     {@link NetworkStates }
     *
     */
    public NetworkStates getNetworkStates() {
        return networkStates;
    }

    /**
     * Sets the value of the networkStates property.
     *
     * @param value
     *     allowed object is
     *     {@link NetworkStates }
     *
     */
    public void setNetworkStates(NetworkStates value) {
        this.networkStates = value;
    }

    public boolean isSetNetworkStates() {
        return (this.networkStates!= null);
    }

    /**
     * Gets the value of the storageDomainStates property.
     *
     * @return
     *     possible object is
     *     {@link StorageDomainStates }
     *
     */
    public StorageDomainStates getStorageDomainStates() {
        return storageDomainStates;
    }

    /**
     * Sets the value of the storageDomainStates property.
     *
     * @param value
     *     allowed object is
     *     {@link StorageDomainStates }
     *
     */
    public void setStorageDomainStates(StorageDomainStates value) {
        this.storageDomainStates = value;
    }

    public boolean isSetStorageDomainStates() {
        return (this.storageDomainStates!= null);
    }

    /**
     * Gets the value of the templateStates property.
     *
     * @return
     *     possible object is
     *     {@link TemplateStates }
     *
     */
    public TemplateStates getTemplateStates() {
        return templateStates;
    }

    /**
     * Sets the value of the templateStates property.
     *
     * @param value
     *     allowed object is
     *     {@link TemplateStates }
     *
     */
    public void setTemplateStates(TemplateStates value) {
        this.templateStates = value;
    }

    public boolean isSetTemplateStates() {
        return (this.templateStates!= null);
    }

    /**
     * Gets the value of the vmStates property.
     *
     * @return
     *     possible object is
     *     {@link VmStates }
     *
     */
    public VmStates getVmStates() {
        return vmStates;
    }

    /**
     * Sets the value of the vmStates property.
     *
     * @param value
     *     allowed object is
     *     {@link VmStates }
     *
     */
    public void setVmStates(VmStates value) {
        this.vmStates = value;
    }

    public boolean isSetVmStates() {
        return (this.vmStates!= null);
    }

    /**
     * Gets the value of the vmPauseDetails property.
     *
     * @return
     *     possible object is
     *     {@link VmPauseDetails }
     *
     */
    public VmPauseDetails getVmPauseDetails() {
        return vmPauseDetails;
    }

    /**
     * Sets the value of the vmPauseDetails property.
     *
     * @param value
     *     allowed object is
     *     {@link VmPauseDetails }
     *
     */
    public void setVmPauseDetails(VmPauseDetails value) {
        this.vmPauseDetails = value;
    }

    public boolean isSetVmPauseDetails() {
        return (this.vmPauseDetails!= null);
    }

    /**
     * Gets the value of the diskStates property.
     *
     * @return
     *     possible object is
     *     {@link DiskStates }
     *
     */
    public DiskStates getDiskStates() {
        return diskStates;
    }

    /**
     * Sets the value of the diskStates property.
     *
     * @param value
     *     allowed object is
     *     {@link DiskStates }
     *
     */
    public void setDiskStates(DiskStates value) {
        this.diskStates = value;
    }

    public boolean isSetDiskStates() {
        return (this.diskStates!= null);
    }

    /**
     * Gets the value of the hostNicStates property.
     *
     * @return
     *     possible object is
     *     {@link HostNICStates }
     *
     */
    public HostNICStates getHostNicStates() {
        return hostNicStates;
    }

    /**
     * Sets the value of the hostNicStates property.
     *
     * @param value
     *     allowed object is
     *     {@link HostNICStates }
     *
     */
    public void setHostNicStates(HostNICStates value) {
        this.hostNicStates = value;
    }

    public boolean isSetHostNicStates() {
        return (this.hostNicStates!= null);
    }

    /**
     * Gets the value of the dataCenterStates property.
     *
     * @return
     *     possible object is
     *     {@link DataCenterStates }
     *
     */
    public DataCenterStates getDataCenterStates() {
        return dataCenterStates;
    }

    /**
     * Sets the value of the dataCenterStates property.
     *
     * @param value
     *     allowed object is
     *     {@link DataCenterStates }
     *
     */
    public void setDataCenterStates(DataCenterStates value) {
        this.dataCenterStates = value;
    }

    public boolean isSetDataCenterStates() {
        return (this.dataCenterStates!= null);
    }

    /**
     * Gets the value of the vmDeviceTypes property.
     *
     * @return
     *     possible object is
     *     {@link VmDeviceTypes }
     *
     */
    public VmDeviceTypes getVmDeviceTypes() {
        return vmDeviceTypes;
    }

    /**
     * Sets the value of the vmDeviceTypes property.
     *
     * @param value
     *     allowed object is
     *     {@link VmDeviceTypes }
     *
     */
    public void setVmDeviceTypes(VmDeviceTypes value) {
        this.vmDeviceTypes = value;
    }

    public boolean isSetVmDeviceTypes() {
        return (this.vmDeviceTypes!= null);
    }

    /**
     * Gets the value of the permits property.
     *
     * @return
     *     possible object is
     *     {@link Permits }
     *
     */
    public Permits getPermits() {
        return permits;
    }

    /**
     * Sets the value of the permits property.
     *
     * @param value
     *     allowed object is
     *     {@link Permits }
     *
     */
    public void setPermits(Permits value) {
        this.permits = value;
    }

    public boolean isSetPermits() {
        return (this.permits!= null);
    }

    /**
     * Gets the value of the schedulingPolicies property.
     *
     * @return
     *     possible object is
     *     {@link SchedulingPolicies }
     *
     */
    public SchedulingPolicies getSchedulingPolicies() {
        return schedulingPolicies;
    }

    /**
     * Sets the value of the schedulingPolicies property.
     *
     * @param value
     *     allowed object is
     *     {@link SchedulingPolicies }
     *
     */
    public void setSchedulingPolicies(SchedulingPolicies value) {
        this.schedulingPolicies = value;
    }

    public boolean isSetSchedulingPolicies() {
        return (this.schedulingPolicies!= null);
    }

    /**
     * Gets the value of the usages property.
     *
     * @return
     *     possible object is
     *     {@link Usages }
     *
     */
    public Usages getUsages() {
        return usages;
    }

    /**
     * Sets the value of the usages property.
     *
     * @param value
     *     allowed object is
     *     {@link Usages }
     *
     */
    public void setUsages(Usages value) {
        this.usages = value;
    }

    public boolean isSetUsages() {
        return (this.usages!= null);
    }

    /**
     * Gets the value of the nfsVersions property.
     *
     * @return
     *     possible object is
     *     {@link NfsVersions }
     *
     */
    public NfsVersions getNfsVersions() {
        return nfsVersions;
    }

    /**
     * Sets the value of the nfsVersions property.
     *
     * @param value
     *     allowed object is
     *     {@link NfsVersions }
     *
     */
    public void setNfsVersions(NfsVersions value) {
        this.nfsVersions = value;
    }

    public boolean isSetNfsVersions() {
        return (this.nfsVersions!= null);
    }

    /**
     * Gets the value of the pmProxyTypes property.
     *
     * @return
     *     possible object is
     *     {@link PmProxyTypes }
     *
     */
    public PmProxyTypes getPmProxyTypes() {
        return pmProxyTypes;
    }

    /**
     * Sets the value of the pmProxyTypes property.
     *
     * @param value
     *     allowed object is
     *     {@link PmProxyTypes }
     *
     */
    public void setPmProxyTypes(PmProxyTypes value) {
        this.pmProxyTypes = value;
    }

    public boolean isSetPmProxyTypes() {
        return (this.pmProxyTypes!= null);
    }

    /**
     * Gets the value of the cpuModes property.
     *
     * @return
     *     possible object is
     *     {@link CpuModes }
     *
     */
    public CpuModes getCpuModes() {
        return cpuModes;
    }

    /**
     * Sets the value of the cpuModes property.
     *
     * @param value
     *     allowed object is
     *     {@link CpuModes }
     *
     */
    public void setCpuModes(CpuModes value) {
        this.cpuModes = value;
    }

    public boolean isSetCpuModes() {
        return (this.cpuModes!= null);
    }

    /**
     * Gets the value of the sgioOptions property.
     *
     * @return
     *     possible object is
     *     {@link ScsiGenericIoOptions }
     *
     */
    public ScsiGenericIoOptions getSgioOptions() {
        return sgioOptions;
    }

    /**
     * Sets the value of the sgioOptions property.
     *
     * @param value
     *     allowed object is
     *     {@link ScsiGenericIoOptions }
     *
     */
    public void setSgioOptions(ScsiGenericIoOptions value) {
        this.sgioOptions = value;
    }

    public boolean isSetSgioOptions() {
        return (this.sgioOptions!= null);
    }

    /**
     * Gets the value of the watchdogModels property.
     *
     * @return
     *     possible object is
     *     {@link WatchdogModels }
     *
     */
    public WatchdogModels getWatchdogModels() {
        return watchdogModels;
    }

    /**
     * Sets the value of the watchdogModels property.
     *
     * @param value
     *     allowed object is
     *     {@link WatchdogModels }
     *
     */
    public void setWatchdogModels(WatchdogModels value) {
        this.watchdogModels = value;
    }

    public boolean isSetWatchdogModels() {
        return (this.watchdogModels!= null);
    }

    /**
     * Gets the value of the watchdogActions property.
     *
     * @return
     *     possible object is
     *     {@link WatchdogActions }
     *
     */
    public WatchdogActions getWatchdogActions() {
        return watchdogActions;
    }

    /**
     * Sets the value of the watchdogActions property.
     *
     * @param value
     *     allowed object is
     *     {@link WatchdogActions }
     *
     */
    public void setWatchdogActions(WatchdogActions value) {
        this.watchdogActions = value;
    }

    public boolean isSetWatchdogActions() {
        return (this.watchdogActions!= null);
    }

    /**
     * Gets the value of the authenticationMethods property.
     *
     * @return
     *     possible object is
     *     {@link AuthenticationMethod }
     *
     */
    public AuthenticationMethod getAuthenticationMethods() {
        return authenticationMethods;
    }

    /**
     * Sets the value of the authenticationMethods property.
     *
     * @param value
     *     allowed object is
     *     {@link AuthenticationMethod }
     *
     */
    public void setAuthenticationMethods(AuthenticationMethod value) {
        this.authenticationMethods = value;
    }

    public boolean isSetAuthenticationMethods() {
        return (this.authenticationMethods!= null);
    }

    /**
     * Gets the value of the kdumpStates property.
     *
     * @return
     *     possible object is
     *     {@link KdumpStates }
     *
     */
    public KdumpStates getKdumpStates() {
        return kdumpStates;
    }

    /**
     * Sets the value of the kdumpStates property.
     *
     * @param value
     *     allowed object is
     *     {@link KdumpStates }
     *
     */
    public void setKdumpStates(KdumpStates value) {
        this.kdumpStates = value;
    }

    public boolean isSetKdumpStates() {
        return (this.kdumpStates!= null);
    }

    /**
     * Gets the value of the spmStates property.
     *
     * @return
     *     possible object is
     *     {@link SpmStates }
     *
     */
    public SpmStates getSpmStates() {
        return spmStates;
    }

    /**
     * Sets the value of the spmStates property.
     *
     * @param value
     *     allowed object is
     *     {@link SpmStates }
     *
     */
    public void setSpmStates(SpmStates value) {
        this.spmStates = value;
    }

    public boolean isSetSpmStates() {
        return (this.spmStates!= null);
    }

    /**
     * Gets the value of the vmPoolTypes property.
     *
     * @return
     *     possible object is
     *     {@link VmPoolTypes }
     *
     */
    public VmPoolTypes getVmPoolTypes() {
        return vmPoolTypes;
    }

    /**
     * Sets the value of the vmPoolTypes property.
     *
     * @param value
     *     allowed object is
     *     {@link VmPoolTypes }
     *
     */
    public void setVmPoolTypes(VmPoolTypes value) {
        this.vmPoolTypes = value;
    }

    public boolean isSetVmPoolTypes() {
        return (this.vmPoolTypes!= null);
    }

    /**
     * Gets the value of the stepTypes property.
     *
     * @return
     *     possible object is
     *     {@link StepTypes }
     *
     */
    public StepTypes getStepTypes() {
        return stepTypes;
    }

    /**
     * Sets the value of the stepTypes property.
     *
     * @param value
     *     allowed object is
     *     {@link StepTypes }
     *
     */
    public void setStepTypes(StepTypes value) {
        this.stepTypes = value;
    }

    public boolean isSetStepTypes() {
        return (this.stepTypes!= null);
    }

    /**
     * Gets the value of the payloadEncodings property.
     *
     * @return
     *     possible object is
     *     {@link PayloadEncodings }
     *
     */
    public PayloadEncodings getPayloadEncodings() {
        return payloadEncodings;
    }

    /**
     * Sets the value of the payloadEncodings property.
     *
     * @param value
     *     allowed object is
     *     {@link PayloadEncodings }
     *
     */
    public void setPayloadEncodings(PayloadEncodings value) {
        this.payloadEncodings = value;
    }

    public boolean isSetPayloadEncodings() {
        return (this.payloadEncodings!= null);
    }

    /**
     * Gets the value of the glusterVolumeTypes property.
     *
     * @return
     *     possible object is
     *     {@link GlusterVolumeTypes }
     *
     */
    public GlusterVolumeTypes getGlusterVolumeTypes() {
        return glusterVolumeTypes;
    }

    /**
     * Sets the value of the glusterVolumeTypes property.
     *
     * @param value
     *     allowed object is
     *     {@link GlusterVolumeTypes }
     *
     */
    public void setGlusterVolumeTypes(GlusterVolumeTypes value) {
        this.glusterVolumeTypes = value;
    }

    public boolean isSetGlusterVolumeTypes() {
        return (this.glusterVolumeTypes!= null);
    }

    /**
     * Gets the value of the transportTypes property.
     *
     * @return
     *     possible object is
     *     {@link TransportTypes }
     *
     */
    public TransportTypes getTransportTypes() {
        return transportTypes;
    }

    /**
     * Sets the value of the transportTypes property.
     *
     * @param value
     *     allowed object is
     *     {@link TransportTypes }
     *
     */
    public void setTransportTypes(TransportTypes value) {
        this.transportTypes = value;
    }

    public boolean isSetTransportTypes() {
        return (this.transportTypes!= null);
    }

    /**
     * Gets the value of the glusterVolumeStates property.
     *
     * @return
     *     possible object is
     *     {@link GlusterStates }
     *
     */
    public GlusterStates getGlusterVolumeStates() {
        return glusterVolumeStates;
    }

    /**
     * Sets the value of the glusterVolumeStates property.
     *
     * @param value
     *     allowed object is
     *     {@link GlusterStates }
     *
     */
    public void setGlusterVolumeStates(GlusterStates value) {
        this.glusterVolumeStates = value;
    }

    public boolean isSetGlusterVolumeStates() {
        return (this.glusterVolumeStates!= null);
    }

    /**
     * Gets the value of the brickStates property.
     *
     * @return
     *     possible object is
     *     {@link GlusterStates }
     *
     */
    public GlusterStates getBrickStates() {
        return brickStates;
    }

    /**
     * Sets the value of the brickStates property.
     *
     * @param value
     *     allowed object is
     *     {@link GlusterStates }
     *
     */
    public void setBrickStates(GlusterStates value) {
        this.brickStates = value;
    }

    public boolean isSetBrickStates() {
        return (this.brickStates!= null);
    }

    /**
     * Gets the value of the reportedDeviceTypes property.
     *
     * @return
     *     possible object is
     *     {@link ReportedDeviceTypes }
     *
     */
    public ReportedDeviceTypes getReportedDeviceTypes() {
        return reportedDeviceTypes;
    }

    /**
     * Sets the value of the reportedDeviceTypes property.
     *
     * @param value
     *     allowed object is
     *     {@link ReportedDeviceTypes }
     *
     */
    public void setReportedDeviceTypes(ReportedDeviceTypes value) {
        this.reportedDeviceTypes = value;
    }

    public boolean isSetReportedDeviceTypes() {
        return (this.reportedDeviceTypes!= null);
    }

    /**
     * Gets the value of the ipVersions property.
     *
     * @return
     *     possible object is
     *     {@link IpVersions }
     *
     */
    public IpVersions getIpVersions() {
        return ipVersions;
    }

    /**
     * Sets the value of the ipVersions property.
     *
     * @param value
     *     allowed object is
     *     {@link IpVersions }
     *
     */
    public void setIpVersions(IpVersions value) {
        this.ipVersions = value;
    }

    public boolean isSetIpVersions() {
        return (this.ipVersions!= null);
    }

    /**
     * Gets the value of the snapshotStatuses property.
     *
     * @return
     *     possible object is
     *     {@link SnapshotStatuses }
     *
     */
    public SnapshotStatuses getSnapshotStatuses() {
        return snapshotStatuses;
    }

    /**
     * Sets the value of the snapshotStatuses property.
     *
     * @param value
     *     allowed object is
     *     {@link SnapshotStatuses }
     *
     */
    public void setSnapshotStatuses(SnapshotStatuses value) {
        this.snapshotStatuses = value;
    }

    public boolean isSetSnapshotStatuses() {
        return (this.snapshotStatuses!= null);
    }

    /**
     * Gets the value of the contentTypes property.
     *
     * @return
     *     possible object is
     *     {@link ContentTypes }
     *
     */
    public ContentTypes getContentTypes() {
        return contentTypes;
    }

    /**
     * Sets the value of the contentTypes property.
     *
     * @param value
     *     allowed object is
     *     {@link ContentTypes }
     *
     */
    public void setContentTypes(ContentTypes value) {
        this.contentTypes = value;
    }

    public boolean isSetContentTypes() {
        return (this.contentTypes!= null);
    }

    /**
     * Gets the value of the hookStates property.
     *
     * @return
     *     possible object is
     *     {@link HookStates }
     *
     */
    public HookStates getHookStates() {
        return hookStates;
    }

    /**
     * Sets the value of the hookStates property.
     *
     * @param value
     *     allowed object is
     *     {@link HookStates }
     *
     */
    public void setHookStates(HookStates value) {
        this.hookStates = value;
    }

    public boolean isSetHookStates() {
        return (this.hookStates!= null);
    }

    /**
     * Gets the value of the stages property.
     *
     * @return
     *     possible object is
     *     {@link Stages }
     *
     */
    public Stages getStages() {
        return stages;
    }

    /**
     * Sets the value of the stages property.
     *
     * @param value
     *     allowed object is
     *     {@link Stages }
     *
     */
    public void setStages(Stages value) {
        this.stages = value;
    }

    public boolean isSetStages() {
        return (this.stages!= null);
    }

    /**
     * Gets the value of the ssoMethods property.
     *
     * @return
     *     possible object is
     *     {@link SsoMethods }
     *
     */
    public SsoMethods getSsoMethods() {
        return ssoMethods;
    }

    /**
     * Sets the value of the ssoMethods property.
     *
     * @param value
     *     allowed object is
     *     {@link SsoMethods }
     *
     */
    public void setSsoMethods(SsoMethods value) {
        this.ssoMethods = value;
    }

    public boolean isSetSsoMethods() {
        return (this.ssoMethods!= null);
    }

    /**
     * Gets the value of the architectureCapabilities property.
     *
     * @return
     *     possible object is
     *     {@link ArchitectureCapabilities }
     *
     */
    public ArchitectureCapabilities getArchitectureCapabilities() {
        return architectureCapabilities;
    }

    /**
     * Sets the value of the architectureCapabilities property.
     *
     * @param value
     *     allowed object is
     *     {@link ArchitectureCapabilities }
     *
     */
    public void setArchitectureCapabilities(ArchitectureCapabilities value) {
        this.architectureCapabilities = value;
    }

    public boolean isSetArchitectureCapabilities() {
        return (this.architectureCapabilities!= null);
    }

    /**
     * Gets the value of the serialNumberPolicies property.
     *
     * @return
     *     possible object is
     *     {@link SerialNumberPolicies }
     *
     */
    public SerialNumberPolicies getSerialNumberPolicies() {
        return serialNumberPolicies;
    }

    /**
     * Sets the value of the serialNumberPolicies property.
     *
     * @param value
     *     allowed object is
     *     {@link SerialNumberPolicies }
     *
     */
    public void setSerialNumberPolicies(SerialNumberPolicies value) {
        this.serialNumberPolicies = value;
    }

    public boolean isSetSerialNumberPolicies() {
        return (this.serialNumberPolicies!= null);
    }

    /**
     * Gets the value of the selinuxModes property.
     *
     * @return
     *     possible object is
     *     {@link SELinuxModes }
     *
     */
    public SELinuxModes getSelinuxModes() {
        return selinuxModes;
    }

    /**
     * Sets the value of the selinuxModes property.
     *
     * @param value
     *     allowed object is
     *     {@link SELinuxModes }
     *
     */
    public void setSelinuxModes(SELinuxModes value) {
        this.selinuxModes = value;
    }

    public boolean isSetSelinuxModes() {
        return (this.selinuxModes!= null);
    }

    /**
     * Gets the value of the rngSources property.
     *
     * @return
     *     possible object is
     *     {@link RngSources }
     *
     */
    public RngSources getRngSources() {
        return rngSources;
    }

    /**
     * Sets the value of the rngSources property.
     *
     * @param value
     *     allowed object is
     *     {@link RngSources }
     *
     */
    public void setRngSources(RngSources value) {
        this.rngSources = value;
    }

    public boolean isSetRngSources() {
        return (this.rngSources!= null);
    }

    /**
     * Gets the value of the schedulingPolicyUnitTypes property.
     *
     * @return
     *     possible object is
     *     {@link SchedulingPolicyUnitTypes }
     *
     */
    public SchedulingPolicyUnitTypes getSchedulingPolicyUnitTypes() {
        return schedulingPolicyUnitTypes;
    }

    /**
     * Sets the value of the schedulingPolicyUnitTypes property.
     *
     * @param value
     *     allowed object is
     *     {@link SchedulingPolicyUnitTypes }
     *
     */
    public void setSchedulingPolicyUnitTypes(SchedulingPolicyUnitTypes value) {
        this.schedulingPolicyUnitTypes = value;
    }

    public boolean isSetSchedulingPolicyUnitTypes() {
        return (this.schedulingPolicyUnitTypes!= null);
    }

    /**
     * Gets the value of the qosTypes property.
     *
     * @return
     *     possible object is
     *     {@link QosTypes }
     *
     */
    public QosTypes getQosTypes() {
        return qosTypes;
    }

    /**
     * Sets the value of the qosTypes property.
     *
     * @param value
     *     allowed object is
     *     {@link QosTypes }
     *
     */
    public void setQosTypes(QosTypes value) {
        this.qosTypes = value;
    }

    public boolean isSetQosTypes() {
        return (this.qosTypes!= null);
    }

}
