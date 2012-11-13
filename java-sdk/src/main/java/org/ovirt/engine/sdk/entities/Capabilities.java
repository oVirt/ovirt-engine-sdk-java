
package org.ovirt.engine.sdk.entities;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Capabilities complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Capabilities">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="version" type="{}VersionCaps" maxOccurs="unbounded"/>
 *         &lt;element name="permits" type="{}Permits" minOccurs="0"/>
 *         &lt;element name="scheduling_policies" type="{}SchedulingPolicies" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Capabilities", propOrder = {
    "versions",
    "permits",
    "schedulingPolicies"
})
public class Capabilities {

    @XmlElement(name = "version", required = true)
    protected List<VersionCaps> versions;
    protected Permits permits;
    @XmlElement(name = "scheduling_policies")
    protected SchedulingPolicies schedulingPolicies;

    /**
     * Gets the value of the versions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the versions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVersions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VersionCaps }
     * 
     * 
     */
    public List<VersionCaps> getVersions() {
        if (versions == null) {
            versions = new ArrayList<VersionCaps>();
        }
        return this.versions;
    }

    public boolean isSetVersions() {
        return ((this.versions!= null)&&(!this.versions.isEmpty()));
    }

    public void unsetVersions() {
        this.versions = null;
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

}
