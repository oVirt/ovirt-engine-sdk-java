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
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for VM complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="VM">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseResource">
 *       &lt;sequence>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element ref="{}status" minOccurs="0"/>
 *         &lt;element name="stop_reason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="memory" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="cpu" type="{}CPU" minOccurs="0"/>
 *         &lt;element name="cpu_shares" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="bios" type="{}Bios" minOccurs="0"/>
 *         &lt;element name="os" type="{}OperatingSystem" minOccurs="0"/>
 *         &lt;element name="high_availability" type="{}HighAvailability" minOccurs="0"/>
 *         &lt;element name="display" type="{}Display" minOccurs="0"/>
 *         &lt;element ref="{}host" minOccurs="0"/>
 *         &lt;element ref="{}cluster" minOccurs="0"/>
 *         &lt;element ref="{}template" minOccurs="0"/>
 *         &lt;element ref="{}instance_type" minOccurs="0"/>
 *         &lt;element ref="{}storage_domain" minOccurs="0"/>
 *         &lt;element name="start_time" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="stop_time" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="creation_time" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="origin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="stateless" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="delete_protected" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element ref="{}sso" minOccurs="0"/>
 *         &lt;element ref="{}rng_device" minOccurs="0"/>
 *         &lt;element ref="{}console" minOccurs="0"/>
 *         &lt;element name="timezone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element ref="{}domain" minOccurs="0"/>
 *         &lt;element name="custom_properties" type="{}CustomProperties" minOccurs="0"/>
 *         &lt;element name="payloads" type="{}Payloads" minOccurs="0"/>
 *         &lt;element name="statistics" type="{}Statistics" minOccurs="0"/>
 *         &lt;element name="disks" type="{}Disks" minOccurs="0"/>
 *         &lt;element ref="{}initialization" minOccurs="0"/>
 *         &lt;element name="nics" type="{}Nics" minOccurs="0"/>
 *         &lt;element name="tags" type="{}Tags" minOccurs="0"/>
 *         &lt;element name="snapshots" type="{}Snapshots" minOccurs="0"/>
 *         &lt;element name="placement_policy" type="{}VmPlacementPolicy" minOccurs="0"/>
 *         &lt;element name="memory_policy" type="{}MemoryPolicy" minOccurs="0"/>
 *         &lt;element name="guest_info" type="{}GuestInfo" minOccurs="0"/>
 *         &lt;element ref="{}quota" minOccurs="0"/>
 *         &lt;element ref="{}usb" minOccurs="0"/>
 *         &lt;element ref="{}soundcard_enabled" minOccurs="0"/>
 *         &lt;element name="tunnel_migration" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="migration_downtime" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element ref="{}virtio_scsi" minOccurs="0"/>
 *         &lt;element ref="{}permissions" minOccurs="0"/>
 *         &lt;element ref="{}cpu_profile" minOccurs="0"/>
 *         &lt;element ref="{}vmpool" minOccurs="0"/>
 *         &lt;element ref="{}cdroms" minOccurs="0"/>
 *         &lt;element ref="{}floppies" minOccurs="0"/>
 *         &lt;element ref="{}reported_devices" minOccurs="0"/>
 *         &lt;element ref="{}watchdogs" minOccurs="0"/>
 *         &lt;element name="use_latest_template_version" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element ref="{}serial_number" minOccurs="0"/>
 *         &lt;element name="next_run_configuration_exists" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="numa_tune_mode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VM", propOrder = {
    "type",
    "status",
    "stopReason",
    "memory",
    "cpu",
    "cpuShares",
    "bios",
    "os",
    "highAvailability",
    "display",
    "host",
    "cluster",
    "template",
    "instanceType",
    "storageDomain",
    "startTime",
    "stopTime",
    "creationTime",
    "origin",
    "stateless",
    "deleteProtected",
    "sso",
    "rngDevice",
    "console",
    "timezone",
    "domain",
    "customProperties",
    "payloads",
    "statistics",
    "disks",
    "initialization",
    "nics",
    "tags",
    "snapshots",
    "placementPolicy",
    "memoryPolicy",
    "guestInfo",
    "quota",
    "usb",
    "soundcardEnabled",
    "tunnelMigration",
    "migrationDowntime",
    "virtioScsi",
    "permissions",
    "cpuProfile",
    "vmPool",
    "cdroms",
    "floppies",
    "reportedDevices",
    "watchdogs",
    "useLatestTemplateVersion",
    "serialNumber",
    "nextRunConfigurationExists",
    "numaTuneMode"
})
@XmlSeeAlso({
    Snapshot.class
})
public class VM
    extends BaseResource
{

    protected String type;
    protected Status status;
    @XmlElement(name = "stop_reason")
    protected String stopReason;
    protected Long memory;
    protected CPU cpu;
    @XmlElement(name = "cpu_shares")
    protected Integer cpuShares;
    protected Bios bios;
    protected OperatingSystem os;
    @XmlElement(name = "high_availability")
    protected HighAvailability highAvailability;
    protected Display display;
    protected Host host;
    protected Cluster cluster;
    protected Template template;
    @XmlElement(name = "instance_type")
    protected InstanceType instanceType;
    @XmlElement(name = "storage_domain")
    protected StorageDomain storageDomain;
    @XmlElement(name = "start_time")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar startTime;
    @XmlElement(name = "stop_time")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar stopTime;
    @XmlElement(name = "creation_time")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar creationTime;
    protected String origin;
    protected Boolean stateless;
    @XmlElement(name = "delete_protected")
    protected Boolean deleteProtected;
    protected Sso sso;
    @XmlElement(name = "rng_device")
    protected RngDevice rngDevice;
    protected Console console;
    protected String timezone;
    protected Domain domain;
    @XmlElement(name = "custom_properties")
    protected CustomProperties customProperties;
    protected Payloads payloads;
    protected Statistics statistics;
    protected Disks disks;
    protected Initialization initialization;
    protected Nics nics;
    protected Tags tags;
    protected Snapshots snapshots;
    @XmlElement(name = "placement_policy")
    protected VmPlacementPolicy placementPolicy;
    @XmlElement(name = "memory_policy")
    protected MemoryPolicy memoryPolicy;
    @XmlElement(name = "guest_info")
    protected GuestInfo guestInfo;
    protected Quota quota;
    protected Usb usb;
    @XmlElement(name = "soundcard_enabled")
    protected Boolean soundcardEnabled;
    @XmlElement(name = "tunnel_migration")
    protected Boolean tunnelMigration;
    @XmlElement(name = "migration_downtime")
    protected Integer migrationDowntime;
    @XmlElement(name = "virtio_scsi")
    protected VirtIOSCSI virtioScsi;
    protected Permissions permissions;
    @XmlElement(name = "cpu_profile")
    protected CpuProfile cpuProfile;
    @XmlElement(name = "vmpool")
    protected VmPool vmPool;
    protected CdRoms cdroms;
    protected Floppies floppies;
    @XmlElement(name = "reported_devices")
    protected ReportedDevices reportedDevices;
    protected WatchDogs watchdogs;
    @XmlElement(name = "use_latest_template_version")
    protected Boolean useLatestTemplateVersion;
    @XmlElement(name = "serial_number")
    protected SerialNumber serialNumber;
    @XmlElement(name = "next_run_configuration_exists")
    protected Boolean nextRunConfigurationExists;
    @XmlElement(name = "numa_tune_mode")
    protected String numaTuneMode;

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
     * Gets the value of the stopReason property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getStopReason() {
        return stopReason;
    }

    /**
     * Sets the value of the stopReason property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setStopReason(String value) {
        this.stopReason = value;
    }

    public boolean isSetStopReason() {
        return (this.stopReason!= null);
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
     * Gets the value of the cpuShares property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getCpuShares() {
        return cpuShares;
    }

    /**
     * Sets the value of the cpuShares property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setCpuShares(Integer value) {
        this.cpuShares = value;
    }

    public boolean isSetCpuShares() {
        return (this.cpuShares!= null);
    }

    /**
     * Gets the value of the bios property.
     *
     * @return
     *     possible object is
     *     {@link Bios }
     *
     */
    public Bios getBios() {
        return bios;
    }

    /**
     * Sets the value of the bios property.
     *
     * @param value
     *     allowed object is
     *     {@link Bios }
     *
     */
    public void setBios(Bios value) {
        this.bios = value;
    }

    public boolean isSetBios() {
        return (this.bios!= null);
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
     * Gets the value of the highAvailability property.
     *
     * @return
     *     possible object is
     *     {@link HighAvailability }
     *
     */
    public HighAvailability getHighAvailability() {
        return highAvailability;
    }

    /**
     * Sets the value of the highAvailability property.
     *
     * @param value
     *     allowed object is
     *     {@link HighAvailability }
     *
     */
    public void setHighAvailability(HighAvailability value) {
        this.highAvailability = value;
    }

    public boolean isSetHighAvailability() {
        return (this.highAvailability!= null);
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
     * Gets the value of the host property.
     *
     * @return
     *     possible object is
     *     {@link Host }
     *
     */
    public Host getHost() {
        return host;
    }

    /**
     * Sets the value of the host property.
     *
     * @param value
     *     allowed object is
     *     {@link Host }
     *
     */
    public void setHost(Host value) {
        this.host = value;
    }

    public boolean isSetHost() {
        return (this.host!= null);
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
     * Gets the value of the template property.
     *
     * @return
     *     possible object is
     *     {@link Template }
     *
     */
    public Template getTemplate() {
        return template;
    }

    /**
     * Sets the value of the template property.
     *
     * @param value
     *     allowed object is
     *     {@link Template }
     *
     */
    public void setTemplate(Template value) {
        this.template = value;
    }

    public boolean isSetTemplate() {
        return (this.template!= null);
    }

    /**
     * Gets the value of the instanceType property.
     *
     * @return
     *     possible object is
     *     {@link InstanceType }
     *
     */
    public InstanceType getInstanceType() {
        return instanceType;
    }

    /**
     * Sets the value of the instanceType property.
     *
     * @param value
     *     allowed object is
     *     {@link InstanceType }
     *
     */
    public void setInstanceType(InstanceType value) {
        this.instanceType = value;
    }

    public boolean isSetInstanceType() {
        return (this.instanceType!= null);
    }

    /**
     * Gets the value of the storageDomain property.
     *
     * @return
     *     possible object is
     *     {@link StorageDomain }
     *
     */
    public StorageDomain getStorageDomain() {
        return storageDomain;
    }

    /**
     * Sets the value of the storageDomain property.
     *
     * @param value
     *     allowed object is
     *     {@link StorageDomain }
     *
     */
    public void setStorageDomain(StorageDomain value) {
        this.storageDomain = value;
    }

    public boolean isSetStorageDomain() {
        return (this.storageDomain!= null);
    }

    /**
     * Gets the value of the startTime property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getStartTime() {
        return startTime;
    }

    /**
     * Sets the value of the startTime property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setStartTime(XMLGregorianCalendar value) {
        this.startTime = value;
    }

    public boolean isSetStartTime() {
        return (this.startTime!= null);
    }

    /**
     * Gets the value of the stopTime property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getStopTime() {
        return stopTime;
    }

    /**
     * Sets the value of the stopTime property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setStopTime(XMLGregorianCalendar value) {
        this.stopTime = value;
    }

    public boolean isSetStopTime() {
        return (this.stopTime!= null);
    }

    /**
     * Gets the value of the creationTime property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getCreationTime() {
        return creationTime;
    }

    /**
     * Sets the value of the creationTime property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setCreationTime(XMLGregorianCalendar value) {
        this.creationTime = value;
    }

    public boolean isSetCreationTime() {
        return (this.creationTime!= null);
    }

    /**
     * Gets the value of the origin property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * Sets the value of the origin property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setOrigin(String value) {
        this.origin = value;
    }

    public boolean isSetOrigin() {
        return (this.origin!= null);
    }

    /**
     * Gets the value of the stateless property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getStateless() {
        return stateless;
    }

    /**
     * Sets the value of the stateless property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setStateless(Boolean value) {
        this.stateless = value;
    }

    public boolean isSetStateless() {
        return (this.stateless!= null);
    }

    /**
     * Gets the value of the deleteProtected property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getDeleteProtected() {
        return deleteProtected;
    }

    /**
     * Sets the value of the deleteProtected property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setDeleteProtected(Boolean value) {
        this.deleteProtected = value;
    }

    public boolean isSetDeleteProtected() {
        return (this.deleteProtected!= null);
    }

    /**
     * Gets the value of the sso property.
     *
     * @return
     *     possible object is
     *     {@link Sso }
     *
     */
    public Sso getSso() {
        return sso;
    }

    /**
     * Sets the value of the sso property.
     *
     * @param value
     *     allowed object is
     *     {@link Sso }
     *
     */
    public void setSso(Sso value) {
        this.sso = value;
    }

    public boolean isSetSso() {
        return (this.sso!= null);
    }

    /**
     * Gets the value of the rngDevice property.
     *
     * @return
     *     possible object is
     *     {@link RngDevice }
     *
     */
    public RngDevice getRngDevice() {
        return rngDevice;
    }

    /**
     * Sets the value of the rngDevice property.
     *
     * @param value
     *     allowed object is
     *     {@link RngDevice }
     *
     */
    public void setRngDevice(RngDevice value) {
        this.rngDevice = value;
    }

    public boolean isSetRngDevice() {
        return (this.rngDevice!= null);
    }

    /**
     * Gets the value of the console property.
     *
     * @return
     *     possible object is
     *     {@link Console }
     *
     */
    public Console getConsole() {
        return console;
    }

    /**
     * Sets the value of the console property.
     *
     * @param value
     *     allowed object is
     *     {@link Console }
     *
     */
    public void setConsole(Console value) {
        this.console = value;
    }

    public boolean isSetConsole() {
        return (this.console!= null);
    }

    /**
     * Gets the value of the timezone property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getTimezone() {
        return timezone;
    }

    /**
     * Sets the value of the timezone property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTimezone(String value) {
        this.timezone = value;
    }

    public boolean isSetTimezone() {
        return (this.timezone!= null);
    }

    /**
     * Gets the value of the domain property.
     *
     * @return
     *     possible object is
     *     {@link Domain }
     *
     */
    public Domain getDomain() {
        return domain;
    }

    /**
     * Sets the value of the domain property.
     *
     * @param value
     *     allowed object is
     *     {@link Domain }
     *
     */
    public void setDomain(Domain value) {
        this.domain = value;
    }

    public boolean isSetDomain() {
        return (this.domain!= null);
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
     * Gets the value of the payloads property.
     *
     * @return
     *     possible object is
     *     {@link Payloads }
     *
     */
    public Payloads getPayloads() {
        return payloads;
    }

    /**
     * Sets the value of the payloads property.
     *
     * @param value
     *     allowed object is
     *     {@link Payloads }
     *
     */
    public void setPayloads(Payloads value) {
        this.payloads = value;
    }

    public boolean isSetPayloads() {
        return (this.payloads!= null);
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
     * Gets the value of the disks property.
     *
     * @return
     *     possible object is
     *     {@link Disks }
     *
     */
    public Object getDisks() {
        return disks;
    }

    /**
     * Sets the value of the disks property.
     *
     * @param value
     *     allowed object is
     *     {@link Disks }
     *
     */
    public void setDisks(Disks value) {
        this.disks = value;
    }

    public boolean isSetDisks() {
        return (this.disks!= null);
    }

    /**
     * Gets the value of the initialization property.
     *
     * @return
     *     possible object is
     *     {@link Initialization }
     *
     */
    public Initialization getInitialization() {
        return initialization;
    }

    /**
     * Sets the value of the initialization property.
     *
     * @param value
     *     allowed object is
     *     {@link Initialization }
     *
     */
    public void setInitialization(Initialization value) {
        this.initialization = value;
    }

    public boolean isSetInitialization() {
        return (this.initialization!= null);
    }

    /**
     * Gets the value of the nics property.
     *
     * @return
     *     possible object is
     *     {@link Nics }
     *
     */
    public Object getNics() {
        return nics;
    }

    /**
     * Sets the value of the nics property.
     *
     * @param value
     *     allowed object is
     *     {@link Nics }
     *
     */
    public void setNics(Nics value) {
        this.nics = value;
    }

    public boolean isSetNics() {
        return (this.nics!= null);
    }

    /**
     * Gets the value of the tags property.
     *
     * @return
     *     possible object is
     *     {@link Tags }
     *
     */
    public Object getTags() {
        return tags;
    }

    /**
     * Sets the value of the tags property.
     *
     * @param value
     *     allowed object is
     *     {@link Tags }
     *
     */
    public void setTags(Tags value) {
        this.tags = value;
    }

    public boolean isSetTags() {
        return (this.tags!= null);
    }

    /**
     * Gets the value of the snapshots property.
     *
     * @return
     *     possible object is
     *     {@link Snapshots }
     *
     */
    public Object getSnapshots() {
        return snapshots;
    }

    /**
     * Sets the value of the snapshots property.
     *
     * @param value
     *     allowed object is
     *     {@link Snapshots }
     *
     */
    public void setSnapshots(Snapshots value) {
        this.snapshots = value;
    }

    public boolean isSetSnapshots() {
        return (this.snapshots!= null);
    }

    /**
     * Gets the value of the placementPolicy property.
     *
     * @return
     *     possible object is
     *     {@link VmPlacementPolicy }
     *
     */
    public VmPlacementPolicy getPlacementPolicy() {
        return placementPolicy;
    }

    /**
     * Sets the value of the placementPolicy property.
     *
     * @param value
     *     allowed object is
     *     {@link VmPlacementPolicy }
     *
     */
    public void setPlacementPolicy(VmPlacementPolicy value) {
        this.placementPolicy = value;
    }

    public boolean isSetPlacementPolicy() {
        return (this.placementPolicy!= null);
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
     * Gets the value of the guestInfo property.
     *
     * @return
     *     possible object is
     *     {@link GuestInfo }
     *
     */
    public GuestInfo getGuestInfo() {
        return guestInfo;
    }

    /**
     * Sets the value of the guestInfo property.
     *
     * @param value
     *     allowed object is
     *     {@link GuestInfo }
     *
     */
    public void setGuestInfo(GuestInfo value) {
        this.guestInfo = value;
    }

    public boolean isSetGuestInfo() {
        return (this.guestInfo!= null);
    }

    /**
     * Gets the value of the quota property.
     *
     * @return
     *     possible object is
     *     {@link Quota }
     *
     */
    public Quota getQuota() {
        return quota;
    }

    /**
     * Sets the value of the quota property.
     *
     * @param value
     *     allowed object is
     *     {@link Quota }
     *
     */
    public void setQuota(Quota value) {
        this.quota = value;
    }

    public boolean isSetQuota() {
        return (this.quota!= null);
    }

    /**
     * Gets the value of the usb property.
     *
     * @return
     *     possible object is
     *     {@link Usb }
     *
     */
    public Usb getUsb() {
        return usb;
    }

    /**
     * Sets the value of the usb property.
     *
     * @param value
     *     allowed object is
     *     {@link Usb }
     *
     */
    public void setUsb(Usb value) {
        this.usb = value;
    }

    public boolean isSetUsb() {
        return (this.usb!= null);
    }

    /**
     * Gets the value of the soundcardEnabled property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getSoundcardEnabled() {
        return soundcardEnabled;
    }

    /**
     * Sets the value of the soundcardEnabled property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setSoundcardEnabled(Boolean value) {
        this.soundcardEnabled = value;
    }

    public boolean isSetSoundcardEnabled() {
        return (this.soundcardEnabled!= null);
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
     * Gets the value of the migrationDowntime property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getMigrationDowntime() {
        return migrationDowntime;
    }

    /**
     * Sets the value of the migrationDowntime property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setMigrationDowntime(Integer value) {
        this.migrationDowntime = value;
    }

    public boolean isSetMigrationDowntime() {
        return (this.migrationDowntime!= null);
    }

    /**
     * Gets the value of the virtioScsi property.
     *
     * @return
     *     possible object is
     *     {@link VirtIOSCSI }
     *
     */
    public VirtIOSCSI getVirtioScsi() {
        return virtioScsi;
    }

    /**
     * Sets the value of the virtioScsi property.
     *
     * @param value
     *     allowed object is
     *     {@link VirtIOSCSI }
     *
     */
    public void setVirtioScsi(VirtIOSCSI value) {
        this.virtioScsi = value;
    }

    public boolean isSetVirtioScsi() {
        return (this.virtioScsi!= null);
    }

    /**
     * Gets the value of the permissions property.
     *
     * @return
     *     possible object is
     *     {@link Permissions }
     *
     */
    public Object getPermissions() {
        return permissions;
    }

    /**
     * Sets the value of the permissions property.
     *
     * @param value
     *     allowed object is
     *     {@link Permissions }
     *
     */
    public void setPermissions(Permissions value) {
        this.permissions = value;
    }

    public boolean isSetPermissions() {
        return (this.permissions!= null);
    }

    /**
     * Gets the value of the cpuProfile property.
     *
     * @return
     *     possible object is
     *     {@link CpuProfile }
     *
     */
    public CpuProfile getCpuProfile() {
        return cpuProfile;
    }

    /**
     * Sets the value of the cpuProfile property.
     *
     * @param value
     *     allowed object is
     *     {@link CpuProfile }
     *
     */
    public void setCpuProfile(CpuProfile value) {
        this.cpuProfile = value;
    }

    public boolean isSetCpuProfile() {
        return (this.cpuProfile!= null);
    }

    /**
     * Gets the value of the vmPool property.
     *
     * @return
     *     possible object is
     *     {@link VmPool }
     *
     */
    public VmPool getVmPool() {
        return vmPool;
    }

    /**
     * Sets the value of the vmPool property.
     *
     * @param value
     *     allowed object is
     *     {@link VmPool }
     *
     */
    public void setVmPool(VmPool value) {
        this.vmPool = value;
    }

    public boolean isSetVmPool() {
        return (this.vmPool!= null);
    }

    /**
     * Gets the value of the cdroms property.
     *
     * @return
     *     possible object is
     *     {@link CdRoms }
     *
     */
    public Object getCdRoms() {
        return cdroms;
    }

    /**
     * Sets the value of the cdroms property.
     *
     * @param value
     *     allowed object is
     *     {@link CdRoms }
     *
     */
    public void setCdroms(CdRoms value) {
        this.cdroms = value;
    }

    public boolean isSetCdroms() {
        return (this.cdroms!= null);
    }

    /**
     * Gets the value of the floppies property.
     *
     * @return
     *     possible object is
     *     {@link Floppies }
     *
     */
    public Floppies getFloppies() {
        return floppies;
    }

    /**
     * Sets the value of the floppies property.
     *
     * @param value
     *     allowed object is
     *     {@link Floppies }
     *
     */
    public void setFloppies(Floppies value) {
        this.floppies = value;
    }

    public boolean isSetFloppies() {
        return (this.floppies!= null);
    }

    /**
     * Gets the value of the reportedDevices property.
     *
     * @return
     *     possible object is
     *     {@link ReportedDevices }
     *
     */
    public Object getReportedDevices() {
        return reportedDevices;
    }

    /**
     * Sets the value of the reportedDevices property.
     *
     * @param value
     *     allowed object is
     *     {@link ReportedDevices }
     *
     */
    public void setReportedDevices(ReportedDevices value) {
        this.reportedDevices = value;
    }

    public boolean isSetReportedDevices() {
        return (this.reportedDevices!= null);
    }

    /**
     * Gets the value of the watchdogs property.
     *
     * @return
     *     possible object is
     *     {@link WatchDogs }
     *
     */
    public Object getWatchDogs() {
        return watchdogs;
    }

    /**
     * Sets the value of the watchdogs property.
     *
     * @param value
     *     allowed object is
     *     {@link WatchDogs }
     *
     */
    public void setWatchdogs(WatchDogs value) {
        this.watchdogs = value;
    }

    public boolean isSetWatchdogs() {
        return (this.watchdogs!= null);
    }

    /**
     * Gets the value of the useLatestTemplateVersion property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getUseLatestTemplateVersion() {
        return useLatestTemplateVersion;
    }

    /**
     * Sets the value of the useLatestTemplateVersion property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setUseLatestTemplateVersion(Boolean value) {
        this.useLatestTemplateVersion = value;
    }

    public boolean isSetUseLatestTemplateVersion() {
        return (this.useLatestTemplateVersion!= null);
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
     * Gets the value of the nextRunConfigurationExists property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getNextRunConfigurationExists() {
        return nextRunConfigurationExists;
    }

    /**
     * Sets the value of the nextRunConfigurationExists property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setNextRunConfigurationExists(Boolean value) {
        this.nextRunConfigurationExists = value;
    }

    public boolean isSetNextRunConfigurationExists() {
        return (this.nextRunConfigurationExists!= null);
    }

    /**
     * Gets the value of the numaTuneMode property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getNumaTuneMode() {
        return numaTuneMode;
    }

    /**
     * Sets the value of the numaTuneMode property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setNumaTuneMode(String value) {
        this.numaTuneMode = value;
    }

    public boolean isSetNumaTuneMode() {
        return (this.numaTuneMode!= null);
    }

}
