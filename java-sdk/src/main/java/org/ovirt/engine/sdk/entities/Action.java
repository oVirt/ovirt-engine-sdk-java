
package org.ovirt.engine.sdk.entities;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Action complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Action">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseResource">
 *       &lt;sequence>
 *         &lt;element name="async" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;group ref="{}ActionParameterGroup"/>
 *         &lt;element ref="{}status" minOccurs="0"/>
 *         &lt;element ref="{}fault" minOccurs="0"/>
 *         &lt;group ref="{}ActionResponseGroup"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Action", propOrder = {
    "async",
    "gracePeriod",
    "host",
    "network",
    "rootPassword",
    "image",
    "fenceType",
    "ticket",
    "iscsi",
    "storageDomain",
    "cluster",
    "discardSnapshots",
    "exclusive",
    "vm",
    "template",
    "hostNics",
    "checkConnectivity",
    "connectivityTimeout",
    "pause",
    "force",
    "option",
    "fixLayout",
    "brick",
    "detach",
    "clone",
    "status",
    "fault",
    "iscsiTargets",
    "powerManagement"
})
public class Action
    extends BaseResource
{

    protected Boolean async;
    @XmlElement(name = "grace_period")
    protected GracePeriod gracePeriod;
    protected Host host;
    protected Network network;
    @XmlElement(name = "root_password")
    protected String rootPassword;
    protected String image;
    @XmlElement(name = "fence_type")
    protected String fenceType;
    protected Ticket ticket;
    protected IscsiDetails iscsi;
    @XmlElement(name = "storage_domain")
    protected StorageDomain storageDomain;
    protected Cluster cluster;
    @XmlElement(name = "discard_snapshots")
    protected Boolean discardSnapshots;
    protected Boolean exclusive;
    protected VM vm;
    protected Template template;
    @XmlElement(name = "host_nics")
    protected HostNics hostNics;
    @XmlElement(name = "check_connectivity")
    protected Boolean checkConnectivity;
    @XmlElement(name = "connectivity_timeout")
    protected Integer connectivityTimeout;
    protected Boolean pause;
    protected Boolean force;
    protected Option option;
    @XmlElement(name = "fix_layout")
    protected Boolean fixLayout;
    protected GlusterBrick brick;
    protected Boolean detach;
    protected Boolean clone;
    protected Status status;
    protected Fault fault;
    @XmlElement(name = "iscsi_target")
    protected List<String> iscsiTargets;
    @XmlElement(name = "power_management")
    protected PowerManagement powerManagement;

    /**
     * Gets the value of the async property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAsync() {
        return async;
    }

    /**
     * Sets the value of the async property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAsync(Boolean value) {
        this.async = value;
    }

    public boolean isSetAsync() {
        return (this.async!= null);
    }

    /**
     * Gets the value of the gracePeriod property.
     * 
     * @return
     *     possible object is
     *     {@link GracePeriod }
     *     
     */
    public GracePeriod getGracePeriod() {
        return gracePeriod;
    }

    /**
     * Sets the value of the gracePeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link GracePeriod }
     *     
     */
    public void setGracePeriod(GracePeriod value) {
        this.gracePeriod = value;
    }

    public boolean isSetGracePeriod() {
        return (this.gracePeriod!= null);
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
     * Gets the value of the network property.
     * 
     * @return
     *     possible object is
     *     {@link Network }
     *     
     */
    public Network getNetwork() {
        return network;
    }

    /**
     * Sets the value of the network property.
     * 
     * @param value
     *     allowed object is
     *     {@link Network }
     *     
     */
    public void setNetwork(Network value) {
        this.network = value;
    }

    public boolean isSetNetwork() {
        return (this.network!= null);
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
     * Gets the value of the image property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImage() {
        return image;
    }

    /**
     * Sets the value of the image property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImage(String value) {
        this.image = value;
    }

    public boolean isSetImage() {
        return (this.image!= null);
    }

    /**
     * Gets the value of the fenceType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFenceType() {
        return fenceType;
    }

    /**
     * Sets the value of the fenceType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFenceType(String value) {
        this.fenceType = value;
    }

    public boolean isSetFenceType() {
        return (this.fenceType!= null);
    }

    /**
     * Gets the value of the ticket property.
     * 
     * @return
     *     possible object is
     *     {@link Ticket }
     *     
     */
    public Ticket getTicket() {
        return ticket;
    }

    /**
     * Sets the value of the ticket property.
     * 
     * @param value
     *     allowed object is
     *     {@link Ticket }
     *     
     */
    public void setTicket(Ticket value) {
        this.ticket = value;
    }

    public boolean isSetTicket() {
        return (this.ticket!= null);
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
     * Gets the value of the discardSnapshots property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDiscardSnapshots() {
        return discardSnapshots;
    }

    /**
     * Sets the value of the discardSnapshots property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDiscardSnapshots(Boolean value) {
        this.discardSnapshots = value;
    }

    public boolean isSetDiscardSnapshots() {
        return (this.discardSnapshots!= null);
    }

    /**
     * Gets the value of the exclusive property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isExclusive() {
        return exclusive;
    }

    /**
     * Sets the value of the exclusive property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setExclusive(Boolean value) {
        this.exclusive = value;
    }

    public boolean isSetExclusive() {
        return (this.exclusive!= null);
    }

    /**
     * Gets the value of the vm property.
     * 
     * @return
     *     possible object is
     *     {@link VM }
     *     
     */
    public VM getVm() {
        return vm;
    }

    /**
     * Sets the value of the vm property.
     * 
     * @param value
     *     allowed object is
     *     {@link VM }
     *     
     */
    public void setVm(VM value) {
        this.vm = value;
    }

    public boolean isSetVm() {
        return (this.vm!= null);
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
     * Gets the value of the hostNics property.
     * 
     * @return
     *     possible object is
     *     {@link HostNics }
     *     
     */
    public HostNics getHostNics() {
        return hostNics;
    }

    /**
     * Sets the value of the hostNics property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostNics }
     *     
     */
    public void setHostNics(HostNics value) {
        this.hostNics = value;
    }

    public boolean isSetHostNics() {
        return (this.hostNics!= null);
    }

    /**
     * Gets the value of the checkConnectivity property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCheckConnectivity() {
        return checkConnectivity;
    }

    /**
     * Sets the value of the checkConnectivity property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCheckConnectivity(Boolean value) {
        this.checkConnectivity = value;
    }

    public boolean isSetCheckConnectivity() {
        return (this.checkConnectivity!= null);
    }

    /**
     * Gets the value of the connectivityTimeout property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getConnectivityTimeout() {
        return connectivityTimeout;
    }

    /**
     * Sets the value of the connectivityTimeout property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setConnectivityTimeout(Integer value) {
        this.connectivityTimeout = value;
    }

    public boolean isSetConnectivityTimeout() {
        return (this.connectivityTimeout!= null);
    }

    /**
     * Gets the value of the pause property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPause() {
        return pause;
    }

    /**
     * Sets the value of the pause property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPause(Boolean value) {
        this.pause = value;
    }

    public boolean isSetPause() {
        return (this.pause!= null);
    }

    /**
     * Gets the value of the force property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isForce() {
        return force;
    }

    /**
     * Sets the value of the force property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setForce(Boolean value) {
        this.force = value;
    }

    public boolean isSetForce() {
        return (this.force!= null);
    }

    /**
     * Gets the value of the option property.
     * 
     * @return
     *     possible object is
     *     {@link Option }
     *     
     */
    public Option getOption() {
        return option;
    }

    /**
     * Sets the value of the option property.
     * 
     * @param value
     *     allowed object is
     *     {@link Option }
     *     
     */
    public void setOption(Option value) {
        this.option = value;
    }

    public boolean isSetOption() {
        return (this.option!= null);
    }

    /**
     * Gets the value of the fixLayout property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFixLayout() {
        return fixLayout;
    }

    /**
     * Sets the value of the fixLayout property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFixLayout(Boolean value) {
        this.fixLayout = value;
    }

    public boolean isSetFixLayout() {
        return (this.fixLayout!= null);
    }

    /**
     * Gets the value of the brick property.
     * 
     * @return
     *     possible object is
     *     {@link GlusterBrick }
     *     
     */
    public GlusterBrick getBrick() {
        return brick;
    }

    /**
     * Sets the value of the brick property.
     * 
     * @param value
     *     allowed object is
     *     {@link GlusterBrick }
     *     
     */
    public void setBrick(GlusterBrick value) {
        this.brick = value;
    }

    public boolean isSetBrick() {
        return (this.brick!= null);
    }

    /**
     * Gets the value of the detach property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDetach() {
        return detach;
    }

    /**
     * Sets the value of the detach property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDetach(Boolean value) {
        this.detach = value;
    }

    public boolean isSetDetach() {
        return (this.detach!= null);
    }

    /**
     * Gets the value of the clone property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isClone() {
        return clone;
    }

    /**
     * Sets the value of the clone property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setClone(Boolean value) {
        this.clone = value;
    }

    public boolean isSetClone() {
        return (this.clone!= null);
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
     * Gets the value of the fault property.
     * 
     * @return
     *     possible object is
     *     {@link Fault }
     *     
     */
    public Fault getFault() {
        return fault;
    }

    /**
     * Sets the value of the fault property.
     * 
     * @param value
     *     allowed object is
     *     {@link Fault }
     *     
     */
    public void setFault(Fault value) {
        this.fault = value;
    }

    public boolean isSetFault() {
        return (this.fault!= null);
    }

    /**
     * Gets the value of the iscsiTargets property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the iscsiTargets property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIscsiTargets().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getIscsiTargets() {
        if (iscsiTargets == null) {
            iscsiTargets = new ArrayList<String>();
        }
        return this.iscsiTargets;
    }

    public boolean isSetIscsiTargets() {
        return ((this.iscsiTargets!= null)&&(!this.iscsiTargets.isEmpty()));
    }

    public void unsetIscsiTargets() {
        this.iscsiTargets = null;
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

}
