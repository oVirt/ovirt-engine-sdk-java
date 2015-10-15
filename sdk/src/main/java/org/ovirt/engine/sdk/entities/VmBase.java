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
 * <p>Java class for VmBase complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="VmBase">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseResource">
 *       &lt;sequence>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element ref="{}status" minOccurs="0"/>
 *         &lt;element name="memory" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="cpu" type="{}Cpu" minOccurs="0"/>
 *         &lt;element name="cpu_shares" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="bios" type="{}Bios" minOccurs="0"/>
 *         &lt;element name="os" type="{}OperatingSystem" minOccurs="0"/>
 *         &lt;element ref="{}cluster" minOccurs="0"/>
 *         &lt;element ref="{}storage_domain" minOccurs="0"/>
 *         &lt;element name="creation_time" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="origin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="stateless" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="delete_protected" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="high_availability" type="{}HighAvailability" minOccurs="0"/>
 *         &lt;element name="display" type="{}Display" minOccurs="0"/>
 *         &lt;element ref="{}sso" minOccurs="0"/>
 *         &lt;element ref="{}rng_device" minOccurs="0"/>
 *         &lt;element ref="{}console" minOccurs="0"/>
 *         &lt;element ref="{}domain" minOccurs="0"/>
 *         &lt;element ref="{}usb" minOccurs="0"/>
 *         &lt;element ref="{}soundcard_enabled" minOccurs="0"/>
 *         &lt;element name="tunnel_migration" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="migration_downtime" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element ref="{}virtio_scsi" minOccurs="0"/>
 *         &lt;element ref="{}serial_number" minOccurs="0"/>
 *         &lt;element name="start_paused" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element ref="{}cpu_profile" minOccurs="0"/>
 *         &lt;element ref="{}migration" minOccurs="0"/>
 *         &lt;element ref="{}io" minOccurs="0"/>
 *         &lt;element name="custom_properties" type="{}CustomProperties" minOccurs="0"/>
 *         &lt;element name="custom_emulated_machine" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="custom_cpu_model" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="time_zone" type="{}TimeZone" minOccurs="0"/>
 *         &lt;element name="small_icon" type="{}Icon" minOccurs="0"/>
 *         &lt;element name="large_icon" type="{}Icon" minOccurs="0"/>
 *         &lt;element ref="{}initialization" minOccurs="0"/>
 *         &lt;element name="memory_policy" type="{}MemoryPolicy" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VmBase", propOrder = {
    "type",
    "status",
    "memory",
    "cpu",
    "cpuShares",
    "bios",
    "os",
    "cluster",
    "storageDomain",
    "creationTime",
    "origin",
    "stateless",
    "deleteProtected",
    "highAvailability",
    "display",
    "sso",
    "rngDevice",
    "console",
    "domain",
    "usb",
    "soundcardEnabled",
    "tunnelMigration",
    "migrationDowntime",
    "virtioScsi",
    "serialNumber",
    "startPaused",
    "cpuProfile",
    "migration",
    "io",
    "customProperties",
    "customEmulatedMachine",
    "customCpuModel",
    "timeZone",
    "smallIcon",
    "largeIcon",
    "initialization",
    "memoryPolicy"
})
@XmlSeeAlso({
    Vm.class,
    Template.class
})
public class VmBase
    extends BaseResource
{

    protected String type;
    protected Status status;
    protected Long memory;
    protected Cpu cpu;
    @XmlElement(name = "cpu_shares")
    protected Integer cpuShares;
    protected Bios bios;
    protected OperatingSystem os;
    protected Cluster cluster;
    @XmlElement(name = "storage_domain")
    protected StorageDomain storageDomain;
    @XmlElement(name = "creation_time")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar creationTime;
    protected String origin;
    protected Boolean stateless;
    @XmlElement(name = "delete_protected")
    protected Boolean deleteProtected;
    @XmlElement(name = "high_availability")
    protected HighAvailability highAvailability;
    protected Display display;
    protected Sso sso;
    @XmlElement(name = "rng_device")
    protected RngDevice rngDevice;
    protected Console console;
    protected Domain domain;
    protected Usb usb;
    @XmlElement(name = "soundcard_enabled")
    protected Boolean soundcardEnabled;
    @XmlElement(name = "tunnel_migration")
    protected Boolean tunnelMigration;
    @XmlElement(name = "migration_downtime")
    protected Integer migrationDowntime;
    @XmlElement(name = "virtio_scsi")
    protected VirtioScsi virtioScsi;
    @XmlElement(name = "serial_number")
    protected SerialNumber serialNumber;
    @XmlElement(name = "start_paused")
    protected Boolean startPaused;
    @XmlElement(name = "cpu_profile")
    protected CpuProfile cpuProfile;
    protected MigrationOptions migration;
    protected Io io;
    @XmlElement(name = "custom_properties")
    protected CustomProperties customProperties;
    @XmlElement(name = "custom_emulated_machine")
    protected String customEmulatedMachine;
    @XmlElement(name = "custom_cpu_model")
    protected String customCpuModel;
    @XmlElement(name = "time_zone")
    protected TimeZone timeZone;
    @XmlElement(name = "small_icon")
    protected Icon smallIcon;
    @XmlElement(name = "large_icon")
    protected Icon largeIcon;
    protected Initialization initialization;
    @XmlElement(name = "memory_policy")
    protected MemoryPolicy memoryPolicy;

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
     *     {@link VirtioScsi }
     *
     */
    public VirtioScsi getVirtioScsi() {
        return virtioScsi;
    }

    /**
     * Sets the value of the virtioScsi property.
     *
     * @param value
     *     allowed object is
     *     {@link VirtioScsi }
     *
     */
    public void setVirtioScsi(VirtioScsi value) {
        this.virtioScsi = value;
    }

    public boolean isSetVirtioScsi() {
        return (this.virtioScsi!= null);
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
     * Gets the value of the startPaused property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getStartPaused() {
        return startPaused;
    }

    /**
     * Sets the value of the startPaused property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setStartPaused(Boolean value) {
        this.startPaused = value;
    }

    public boolean isSetStartPaused() {
        return (this.startPaused!= null);
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
     * Gets the value of the io property.
     *
     * @return
     *     possible object is
     *     {@link Io }
     *
     */
    public Io getIo() {
        return io;
    }

    /**
     * Sets the value of the io property.
     *
     * @param value
     *     allowed object is
     *     {@link Io }
     *
     */
    public void setIo(Io value) {
        this.io = value;
    }

    public boolean isSetIo() {
        return (this.io!= null);
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
     * Gets the value of the customEmulatedMachine property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCustomEmulatedMachine() {
        return customEmulatedMachine;
    }

    /**
     * Sets the value of the customEmulatedMachine property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCustomEmulatedMachine(String value) {
        this.customEmulatedMachine = value;
    }

    public boolean isSetCustomEmulatedMachine() {
        return (this.customEmulatedMachine!= null);
    }

    /**
     * Gets the value of the customCpuModel property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCustomCpuModel() {
        return customCpuModel;
    }

    /**
     * Sets the value of the customCpuModel property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCustomCpuModel(String value) {
        this.customCpuModel = value;
    }

    public boolean isSetCustomCpuModel() {
        return (this.customCpuModel!= null);
    }

    /**
     * Gets the value of the timeZone property.
     *
     * @return
     *     possible object is
     *     {@link TimeZone }
     *
     */
    public TimeZone getTimeZone() {
        return timeZone;
    }

    /**
     * Sets the value of the timeZone property.
     *
     * @param value
     *     allowed object is
     *     {@link TimeZone }
     *
     */
    public void setTimeZone(TimeZone value) {
        this.timeZone = value;
    }

    public boolean isSetTimeZone() {
        return (this.timeZone!= null);
    }

    /**
     * Gets the value of the smallIcon property.
     *
     * @return
     *     possible object is
     *     {@link Icon }
     *
     */
    public Icon getSmallIcon() {
        return smallIcon;
    }

    /**
     * Sets the value of the smallIcon property.
     *
     * @param value
     *     allowed object is
     *     {@link Icon }
     *
     */
    public void setSmallIcon(Icon value) {
        this.smallIcon = value;
    }

    public boolean isSetSmallIcon() {
        return (this.smallIcon!= null);
    }

    /**
     * Gets the value of the largeIcon property.
     *
     * @return
     *     possible object is
     *     {@link Icon }
     *
     */
    public Icon getLargeIcon() {
        return largeIcon;
    }

    /**
     * Sets the value of the largeIcon property.
     *
     * @param value
     *     allowed object is
     *     {@link Icon }
     *
     */
    public void setLargeIcon(Icon value) {
        this.largeIcon = value;
    }

    public boolean isSetLargeIcon() {
        return (this.largeIcon!= null);
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

}
