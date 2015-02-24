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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Host complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Host">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseResource">
 *       &lt;sequence>
 *         &lt;element name="address" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element ref="{}certificate" minOccurs="0"/>
 *         &lt;element ref="{}status" minOccurs="0"/>
 *         &lt;element name="cluster" type="{}Cluster" minOccurs="0"/>
 *         &lt;element name="port" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" minOccurs="0"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="storage_manager" type="{}StorageManager" minOccurs="0"/>
 *         &lt;element name="spm" type="{}SPM" minOccurs="0"/>
 *         &lt;element name="version" type="{}Version" minOccurs="0"/>
 *         &lt;element ref="{}hardware_information" minOccurs="0"/>
 *         &lt;element ref="{}power_management" minOccurs="0"/>
 *         &lt;element ref="{}ksm" minOccurs="0"/>
 *         &lt;element ref="{}transparent_hugepages" minOccurs="0"/>
 *         &lt;element name="iscsi" type="{}IscsiDetails" minOccurs="0"/>
 *         &lt;element name="root_password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element ref="{}ssh" minOccurs="0"/>
 *         &lt;element name="statistics" type="{}Statistics" minOccurs="0"/>
 *         &lt;element ref="{}cpu" minOccurs="0"/>
 *         &lt;element name="memory" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="max_scheduling_memory" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="summary" type="{}VmSummary" minOccurs="0"/>
 *         &lt;element name="override_iptables" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="protocol" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reboot_after_installation" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="os" type="{}OperatingSystem" minOccurs="0"/>
 *         &lt;element ref="{}hooks" minOccurs="0"/>
 *         &lt;element name="libvirt_version" type="{}Version" minOccurs="0"/>
 *         &lt;element ref="{}display" minOccurs="0"/>
 *         &lt;element name="hosted_engine" type="{}HostedEngine" minOccurs="0"/>
 *         &lt;element name="kdump_status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="selinux" type="{}SELinux" minOccurs="0"/>
 *         &lt;element name="auto_numa_status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numa_supported" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="live_snapshot_support" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Host", propOrder = {
    "address",
    "certificate",
    "status",
    "cluster",
    "port",
    "type",
    "storageManager",
    "spm",
    "version",
    "hardwareInformation",
    "powerManagement",
    "ksm",
    "transparentHugepages",
    "iscsi",
    "rootPassword",
    "ssh",
    "statistics",
    "cpu",
    "memory",
    "maxSchedulingMemory",
    "summary",
    "overrideIptables",
    "protocol",
    "rebootAfterInstallation",
    "os",
    "hooks",
    "libvirtVersion",
    "display",
    "hostedEngine",
    "kdumpStatus",
    "selinux",
    "autoNumaStatus",
    "numaSupported",
    "liveSnapshotSupport"
})
public class Host
    extends BaseResource
{

    protected String address;
    protected Certificate certificate;
    protected Status status;
    protected Cluster cluster;
    @XmlSchemaType(name = "unsignedShort")
    protected Integer port;
    protected String type;
    @XmlElement(name = "storage_manager")
    protected StorageManager storageManager;
    protected SPM spm;
    protected Version version;
    @XmlElement(name = "hardware_information")
    protected HardwareInformation hardwareInformation;
    @XmlElement(name = "power_management")
    protected PowerManagement powerManagement;
    protected KSM ksm;
    @XmlElement(name = "transparent_hugepages")
    protected TransparentHugePages transparentHugepages;
    protected IscsiDetails iscsi;
    @XmlElement(name = "root_password")
    protected String rootPassword;
    protected SSH ssh;
    protected Statistics statistics;
    protected CPU cpu;
    protected Long memory;
    @XmlElement(name = "max_scheduling_memory")
    protected Long maxSchedulingMemory;
    protected VmSummary summary;
    @XmlElement(name = "override_iptables")
    protected Boolean overrideIptables;
    protected String protocol;
    @XmlElement(name = "reboot_after_installation")
    protected Boolean rebootAfterInstallation;
    protected OperatingSystem os;
    protected Hooks hooks;
    @XmlElement(name = "libvirt_version")
    protected Version libvirtVersion;
    protected Display display;
    @XmlElement(name = "hosted_engine")
    protected HostedEngine hostedEngine;
    @XmlElement(name = "kdump_status")
    protected String kdumpStatus;
    protected SELinux selinux;
    @XmlElement(name = "auto_numa_status")
    protected String autoNumaStatus;
    @XmlElement(name = "numa_supported")
    protected Boolean numaSupported;
    @XmlElement(name = "live_snapshot_support")
    protected Boolean liveSnapshotSupport;

    /**
     * Gets the value of the address property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAddress(String value) {
        this.address = value;
    }

    public boolean isSetAddress() {
        return (this.address!= null);
    }

    /**
     * Gets the value of the certificate property.
     *
     * @return
     *     possible object is
     *     {@link Certificate }
     *
     */
    public Certificate getCertificate() {
        return certificate;
    }

    /**
     * Sets the value of the certificate property.
     *
     * @param value
     *     allowed object is
     *     {@link Certificate }
     *
     */
    public void setCertificate(Certificate value) {
        this.certificate = value;
    }

    public boolean isSetCertificate() {
        return (this.certificate!= null);
    }

    /**
     * Gets the value of the status property.
     *
     * @return
     *     possible object is
     *     {@link Status }
     *
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     *
     * @param value
     *     allowed object is
     *     {@link Status }
     *
     */
    public void setStatus(Status value) {
        this.status = value;
    }

    public boolean isSetStatus() {
        return (this.status!= null);
    }

    /**
     * Gets the value of the cluster property.
     *
     * @return
     *     possible object is
     *     {@link Cluster }
     *
     */
    public Cluster getCluster() {
        return cluster;
    }

    /**
     * Sets the value of the cluster property.
     *
     * @param value
     *     allowed object is
     *     {@link Cluster }
     *
     */
    public void setCluster(Cluster value) {
        this.cluster = value;
    }

    public boolean isSetCluster() {
        return (this.cluster!= null);
    }

    /**
     * Gets the value of the port property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getPort() {
        return port;
    }

    /**
     * Sets the value of the port property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setPort(Integer value) {
        this.port = value;
    }

    public boolean isSetPort() {
        return (this.port!= null);
    }

    /**
     * Gets the value of the type property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setType(String value) {
        this.type = value;
    }

    public boolean isSetType() {
        return (this.type!= null);
    }

    /**
     * Gets the value of the storageManager property.
     *
     * @return
     *     possible object is
     *     {@link StorageManager }
     *
     */
    public StorageManager getStorageManager() {
        return storageManager;
    }

    /**
     * Sets the value of the storageManager property.
     *
     * @param value
     *     allowed object is
     *     {@link StorageManager }
     *
     */
    public void setStorageManager(StorageManager value) {
        this.storageManager = value;
    }

    public boolean isSetStorageManager() {
        return (this.storageManager!= null);
    }

    /**
     * Gets the value of the spm property.
     *
     * @return
     *     possible object is
     *     {@link SPM }
     *
     */
    public SPM getSpm() {
        return spm;
    }

    /**
     * Sets the value of the spm property.
     *
     * @param value
     *     allowed object is
     *     {@link SPM }
     *
     */
    public void setSpm(SPM value) {
        this.spm = value;
    }

    public boolean isSetSpm() {
        return (this.spm!= null);
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
     * Gets the value of the hardwareInformation property.
     *
     * @return
     *     possible object is
     *     {@link HardwareInformation }
     *
     */
    public HardwareInformation getHardwareInformation() {
        return hardwareInformation;
    }

    /**
     * Sets the value of the hardwareInformation property.
     *
     * @param value
     *     allowed object is
     *     {@link HardwareInformation }
     *
     */
    public void setHardwareInformation(HardwareInformation value) {
        this.hardwareInformation = value;
    }

    public boolean isSetHardwareInformation() {
        return (this.hardwareInformation!= null);
    }

    /**
     * Gets the value of the powerManagement property.
     *
     * @return
     *     possible object is
     *     {@link PowerManagement }
     *
     */
    public PowerManagement getPowerManagement() {
        return powerManagement;
    }

    /**
     * Sets the value of the powerManagement property.
     *
     * @param value
     *     allowed object is
     *     {@link PowerManagement }
     *
     */
    public void setPowerManagement(PowerManagement value) {
        this.powerManagement = value;
    }

    public boolean isSetPowerManagement() {
        return (this.powerManagement!= null);
    }

    /**
     * Gets the value of the ksm property.
     *
     * @return
     *     possible object is
     *     {@link KSM }
     *
     */
    public KSM getKsm() {
        return ksm;
    }

    /**
     * Sets the value of the ksm property.
     *
     * @param value
     *     allowed object is
     *     {@link KSM }
     *
     */
    public void setKsm(KSM value) {
        this.ksm = value;
    }

    public boolean isSetKsm() {
        return (this.ksm!= null);
    }

    /**
     * Gets the value of the transparentHugepages property.
     *
     * @return
     *     possible object is
     *     {@link TransparentHugePages }
     *
     */
    public TransparentHugePages getTransparentHugepages() {
        return transparentHugepages;
    }

    /**
     * Sets the value of the transparentHugepages property.
     *
     * @param value
     *     allowed object is
     *     {@link TransparentHugePages }
     *
     */
    public void setTransparentHugepages(TransparentHugePages value) {
        this.transparentHugepages = value;
    }

    public boolean isSetTransparentHugepages() {
        return (this.transparentHugepages!= null);
    }

    /**
     * Gets the value of the iscsi property.
     *
     * @return
     *     possible object is
     *     {@link IscsiDetails }
     *
     */
    public IscsiDetails getIscsi() {
        return iscsi;
    }

    /**
     * Sets the value of the iscsi property.
     *
     * @param value
     *     allowed object is
     *     {@link IscsiDetails }
     *
     */
    public void setIscsi(IscsiDetails value) {
        this.iscsi = value;
    }

    public boolean isSetIscsi() {
        return (this.iscsi!= null);
    }

    /**
     * Gets the value of the rootPassword property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getRootPassword() {
        return rootPassword;
    }

    /**
     * Sets the value of the rootPassword property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setRootPassword(String value) {
        this.rootPassword = value;
    }

    public boolean isSetRootPassword() {
        return (this.rootPassword!= null);
    }

    /**
     * Gets the value of the ssh property.
     *
     * @return
     *     possible object is
     *     {@link SSH }
     *
     */
    public SSH getSsh() {
        return ssh;
    }

    /**
     * Sets the value of the ssh property.
     *
     * @param value
     *     allowed object is
     *     {@link SSH }
     *
     */
    public void setSsh(SSH value) {
        this.ssh = value;
    }

    public boolean isSetSsh() {
        return (this.ssh!= null);
    }

    /**
     * Gets the value of the statistics property.
     *
     * @return
     *     possible object is
     *     {@link Statistics }
     *
     */
    public Object getStatistics() {
        return statistics;
    }

    /**
     * Sets the value of the statistics property.
     *
     * @param value
     *     allowed object is
     *     {@link Statistics }
     *
     */
    public void setStatistics(Statistics value) {
        this.statistics = value;
    }

    public boolean isSetStatistics() {
        return (this.statistics!= null);
    }

    /**
     * Gets the value of the cpu property.
     *
     * @return
     *     possible object is
     *     {@link CPU }
     *
     */
    public CPU getCpu() {
        return cpu;
    }

    /**
     * Sets the value of the cpu property.
     *
     * @param value
     *     allowed object is
     *     {@link CPU }
     *
     */
    public void setCpu(CPU value) {
        this.cpu = value;
    }

    public boolean isSetCpu() {
        return (this.cpu!= null);
    }

    /**
     * Gets the value of the memory property.
     *
     * @return
     *     possible object is
     *     {@link Long }
     *
     */
    public Long getMemory() {
        return memory;
    }

    /**
     * Sets the value of the memory property.
     *
     * @param value
     *     allowed object is
     *     {@link Long }
     *
     */
    public void setMemory(Long value) {
        this.memory = value;
    }

    public boolean isSetMemory() {
        return (this.memory!= null);
    }

    /**
     * Gets the value of the maxSchedulingMemory property.
     *
     * @return
     *     possible object is
     *     {@link Long }
     *
     */
    public Long getMaxSchedulingMemory() {
        return maxSchedulingMemory;
    }

    /**
     * Sets the value of the maxSchedulingMemory property.
     *
     * @param value
     *     allowed object is
     *     {@link Long }
     *
     */
    public void setMaxSchedulingMemory(Long value) {
        this.maxSchedulingMemory = value;
    }

    public boolean isSetMaxSchedulingMemory() {
        return (this.maxSchedulingMemory!= null);
    }

    /**
     * Gets the value of the summary property.
     *
     * @return
     *     possible object is
     *     {@link VmSummary }
     *
     */
    public VmSummary getSummary() {
        return summary;
    }

    /**
     * Sets the value of the summary property.
     *
     * @param value
     *     allowed object is
     *     {@link VmSummary }
     *
     */
    public void setSummary(VmSummary value) {
        this.summary = value;
    }

    public boolean isSetSummary() {
        return (this.summary!= null);
    }

    /**
     * Gets the value of the overrideIptables property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getOverrideIptables() {
        return overrideIptables;
    }

    /**
     * Sets the value of the overrideIptables property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setOverrideIptables(Boolean value) {
        this.overrideIptables = value;
    }

    public boolean isSetOverrideIptables() {
        return (this.overrideIptables!= null);
    }

    /**
     * Gets the value of the protocol property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getProtocol() {
        return protocol;
    }

    /**
     * Sets the value of the protocol property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setProtocol(String value) {
        this.protocol = value;
    }

    public boolean isSetProtocol() {
        return (this.protocol!= null);
    }

    /**
     * Gets the value of the rebootAfterInstallation property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getRebootAfterInstallation() {
        return rebootAfterInstallation;
    }

    /**
     * Sets the value of the rebootAfterInstallation property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setRebootAfterInstallation(Boolean value) {
        this.rebootAfterInstallation = value;
    }

    public boolean isSetRebootAfterInstallation() {
        return (this.rebootAfterInstallation!= null);
    }

    /**
     * Gets the value of the os property.
     *
     * @return
     *     possible object is
     *     {@link OperatingSystem }
     *
     */
    public OperatingSystem getOs() {
        return os;
    }

    /**
     * Sets the value of the os property.
     *
     * @param value
     *     allowed object is
     *     {@link OperatingSystem }
     *
     */
    public void setOs(OperatingSystem value) {
        this.os = value;
    }

    public boolean isSetOs() {
        return (this.os!= null);
    }

    /**
     * Gets the value of the hooks property.
     *
     * @return
     *     possible object is
     *     {@link Hooks }
     *
     */
    public Object getHooks() {
        return hooks;
    }

    /**
     * Sets the value of the hooks property.
     *
     * @param value
     *     allowed object is
     *     {@link Hooks }
     *
     */
    public void setHooks(Hooks value) {
        this.hooks = value;
    }

    public boolean isSetHooks() {
        return (this.hooks!= null);
    }

    /**
     * Gets the value of the libvirtVersion property.
     *
     * @return
     *     possible object is
     *     {@link Version }
     *
     */
    public Version getLibvirtVersion() {
        return libvirtVersion;
    }

    /**
     * Sets the value of the libvirtVersion property.
     *
     * @param value
     *     allowed object is
     *     {@link Version }
     *
     */
    public void setLibvirtVersion(Version value) {
        this.libvirtVersion = value;
    }

    public boolean isSetLibvirtVersion() {
        return (this.libvirtVersion!= null);
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
     * Gets the value of the hostedEngine property.
     *
     * @return
     *     possible object is
     *     {@link HostedEngine }
     *
     */
    public HostedEngine getHostedEngine() {
        return hostedEngine;
    }

    /**
     * Sets the value of the hostedEngine property.
     *
     * @param value
     *     allowed object is
     *     {@link HostedEngine }
     *
     */
    public void setHostedEngine(HostedEngine value) {
        this.hostedEngine = value;
    }

    public boolean isSetHostedEngine() {
        return (this.hostedEngine!= null);
    }

    /**
     * Gets the value of the kdumpStatus property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getKdumpStatus() {
        return kdumpStatus;
    }

    /**
     * Sets the value of the kdumpStatus property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setKdumpStatus(String value) {
        this.kdumpStatus = value;
    }

    public boolean isSetKdumpStatus() {
        return (this.kdumpStatus!= null);
    }

    /**
     * Gets the value of the selinux property.
     *
     * @return
     *     possible object is
     *     {@link SELinux }
     *
     */
    public SELinux getSelinux() {
        return selinux;
    }

    /**
     * Sets the value of the selinux property.
     *
     * @param value
     *     allowed object is
     *     {@link SELinux }
     *
     */
    public void setSelinux(SELinux value) {
        this.selinux = value;
    }

    public boolean isSetSelinux() {
        return (this.selinux!= null);
    }

    /**
     * Gets the value of the autoNumaStatus property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAutoNumaStatus() {
        return autoNumaStatus;
    }

    /**
     * Sets the value of the autoNumaStatus property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAutoNumaStatus(String value) {
        this.autoNumaStatus = value;
    }

    public boolean isSetAutoNumaStatus() {
        return (this.autoNumaStatus!= null);
    }

    /**
     * Gets the value of the numaSupported property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getNumaSupported() {
        return numaSupported;
    }

    /**
     * Sets the value of the numaSupported property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setNumaSupported(Boolean value) {
        this.numaSupported = value;
    }

    public boolean isSetNumaSupported() {
        return (this.numaSupported!= null);
    }

    /**
     * Gets the value of the liveSnapshotSupport property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getLiveSnapshotSupport() {
        return liveSnapshotSupport;
    }

    /**
     * Sets the value of the liveSnapshotSupport property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setLiveSnapshotSupport(Boolean value) {
        this.liveSnapshotSupport = value;
    }

    public boolean isSetLiveSnapshotSupport() {
        return (this.liveSnapshotSupport!= null);
    }

}
