
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
 *         &lt;element ref="{}gluster_volume_types" minOccurs="0"/>
 *         &lt;element ref="{}transport_types" minOccurs="0"/>
 *         &lt;element ref="{}gluster_volume_states" minOccurs="0"/>
 *         &lt;element ref="{}brick_states" minOccurs="0"/>
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
    "glusterVolumeTypes",
    "transportTypes",
    "glusterVolumeStates",
    "brickStates"
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
    @XmlElement(name = "gluster_volume_types")
    protected GlusterVolumeTypes glusterVolumeTypes;
    @XmlElement(name = "transport_types")
    protected TransportTypes transportTypes;
    @XmlElement(name = "gluster_volume_states")
    protected GlusterStates glusterVolumeStates;
    @XmlElement(name = "brick_states")
    protected GlusterStates brickStates;

    /**
     * Gets the value of the current property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCurrent() {
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

}
