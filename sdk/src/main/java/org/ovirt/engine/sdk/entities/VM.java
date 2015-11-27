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
 *     &lt;extension base="{}VmBase">
 *       &lt;sequence>
 *         &lt;element name="stop_reason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element ref="{}host" minOccurs="0"/>
 *         &lt;element ref="{}template" minOccurs="0"/>
 *         &lt;element ref="{}instance_type" minOccurs="0"/>
 *         &lt;element name="start_time" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="stop_time" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="run_once" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="payloads" type="{}Payloads" minOccurs="0"/>
 *         &lt;element name="statistics" type="{}Statistics" minOccurs="0"/>
 *         &lt;element name="disks" type="{}Disks" minOccurs="0"/>
 *         &lt;element ref="{}initialization" minOccurs="0"/>
 *         &lt;element name="nics" type="{}Nics" minOccurs="0"/>
 *         &lt;element name="tags" type="{}Tags" minOccurs="0"/>
 *         &lt;element name="snapshots" type="{}Snapshots" minOccurs="0"/>
 *         &lt;element name="placement_policy" type="{}VmPlacementPolicy" minOccurs="0"/>
 *         &lt;element name="guest_info" type="{}GuestInfo" minOccurs="0"/>
 *         &lt;element ref="{}quota" minOccurs="0"/>
 *         &lt;element ref="{}vmpool" minOccurs="0"/>
 *         &lt;element ref="{}cdroms" minOccurs="0"/>
 *         &lt;element ref="{}floppies" minOccurs="0"/>
 *         &lt;element ref="{}reported_devices" minOccurs="0"/>
 *         &lt;element ref="{}watchdogs" minOccurs="0"/>
 *         &lt;element name="use_latest_template_version" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="next_run_configuration_exists" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="numa_tune_mode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element ref="{}permissions" minOccurs="0"/>
 *         &lt;element ref="{}external_host_provider" minOccurs="0"/>
 *         &lt;element ref="{}katello_errata" minOccurs="0"/>
 *         &lt;element name="guest_time_zone" type="{}TimeZone" minOccurs="0"/>
 *         &lt;element name="guest_operating_system" type="{}GuestOperatingSystem" minOccurs="0"/>
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
    "stopReason",
    "host",
    "template",
    "instanceType",
    "startTime",
    "stopTime",
    "runOnce",
    "payloads",
    "statistics",
    "disks",
    "initialization",
    "nics",
    "tags",
    "snapshots",
    "placementPolicy",
    "guestInfo",
    "quota",
    "vmPool",
    "cdroms",
    "floppies",
    "reportedDevices",
    "watchdogs",
    "useLatestTemplateVersion",
    "nextRunConfigurationExists",
    "numaTuneMode",
    "permissions",
    "externalHostProvider",
    "katelloErrata",
    "guestTimeZone",
    "guestOperatingSystem"
})
@XmlSeeAlso({
    Snapshot.class
})
public class VM
    extends VmBase
{

    @XmlElement(name = "stop_reason")
    protected String stopReason;
    protected Host host;
    protected Template template;
    @XmlElement(name = "instance_type")
    protected InstanceType instanceType;
    @XmlElement(name = "start_time")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar startTime;
    @XmlElement(name = "stop_time")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar stopTime;
    @XmlElement(name = "run_once")
    protected Boolean runOnce;
    protected Payloads payloads;
    protected Statistics statistics;
    protected Disks disks;
    protected Initialization initialization;
    protected Nics nics;
    protected Tags tags;
    protected Snapshots snapshots;
    @XmlElement(name = "placement_policy")
    protected VmPlacementPolicy placementPolicy;
    @XmlElement(name = "guest_info")
    protected GuestInfo guestInfo;
    protected Quota quota;
    @XmlElement(name = "vmpool")
    protected VmPool vmPool;
    protected CdRoms cdroms;
    protected Floppies floppies;
    @XmlElement(name = "reported_devices")
    protected ReportedDevices reportedDevices;
    protected WatchDogs watchdogs;
    @XmlElement(name = "use_latest_template_version")
    protected Boolean useLatestTemplateVersion;
    @XmlElement(name = "next_run_configuration_exists")
    protected Boolean nextRunConfigurationExists;
    @XmlElement(name = "numa_tune_mode")
    protected String numaTuneMode;
    protected Permissions permissions;
    @XmlElement(name = "external_host_provider")
    protected ExternalHostProvider externalHostProvider;
    @XmlElement(name = "katello_errata")
    protected KatelloErrata katelloErrata;
    @XmlElement(name = "guest_time_zone")
    protected TimeZone guestTimeZone;
    @XmlElement(name = "guest_operating_system")
    protected GuestOperatingSystem guestOperatingSystem;

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
     * Gets the value of the runOnce property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getRunOnce() {
        return runOnce;
    }

    /**
     * Sets the value of the runOnce property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setRunOnce(Boolean value) {
        this.runOnce = value;
    }

    public boolean isSetRunOnce() {
        return (this.runOnce!= null);
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
     * Gets the value of the externalHostProvider property.
     *
     * @return
     *     possible object is
     *     {@link ExternalHostProvider }
     *
     */
    public ExternalHostProvider getExternalHostProvider() {
        return externalHostProvider;
    }

    /**
     * Sets the value of the externalHostProvider property.
     *
     * @param value
     *     allowed object is
     *     {@link ExternalHostProvider }
     *
     */
    public void setExternalHostProvider(ExternalHostProvider value) {
        this.externalHostProvider = value;
    }

    public boolean isSetExternalHostProvider() {
        return (this.externalHostProvider!= null);
    }

    /**
     * Gets the value of the katelloErrata property.
     *
     * @return
     *     possible object is
     *     {@link KatelloErrata }
     *
     */
    public Object getKatelloErrata() {
        return katelloErrata;
    }

    /**
     * Sets the value of the katelloErrata property.
     *
     * @param value
     *     allowed object is
     *     {@link KatelloErrata }
     *
     */
    public void setKatelloErrata(KatelloErrata value) {
        this.katelloErrata = value;
    }

    public boolean isSetKatelloErrata() {
        return (this.katelloErrata!= null);
    }

    /**
     * Gets the value of the guestTimeZone property.
     *
     * @return
     *     possible object is
     *     {@link TimeZone }
     *
     */
    public TimeZone getGuestTimeZone() {
        return guestTimeZone;
    }

    /**
     * Sets the value of the guestTimeZone property.
     *
     * @param value
     *     allowed object is
     *     {@link TimeZone }
     *
     */
    public void setGuestTimeZone(TimeZone value) {
        this.guestTimeZone = value;
    }

    public boolean isSetGuestTimeZone() {
        return (this.guestTimeZone!= null);
    }

    /**
     * Gets the value of the guestOperatingSystem property.
     *
     * @return
     *     possible object is
     *     {@link GuestOperatingSystem }
     *
     */
    public GuestOperatingSystem getGuestOperatingSystem() {
        return guestOperatingSystem;
    }

    /**
     * Sets the value of the guestOperatingSystem property.
     *
     * @param value
     *     allowed object is
     *     {@link GuestOperatingSystem }
     *
     */
    public void setGuestOperatingSystem(GuestOperatingSystem value) {
        this.guestOperatingSystem = value;
    }

    public boolean isSetGuestOperatingSystem() {
        return (this.guestOperatingSystem!= null);
    }

}
