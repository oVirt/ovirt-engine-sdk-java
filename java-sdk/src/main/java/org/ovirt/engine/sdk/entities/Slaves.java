
package org.ovirt.engine.sdk.entities;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Slaves complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Slaves">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}host_nic" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Slaves", propOrder = {
    "slaves"
})
public class Slaves {

    @XmlElement(name = "host_nic", required = true)
    protected List<HostNIC> slaves;

    /**
     * Gets the value of the slaves property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the slaves property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSlaves().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostNIC }
     * 
     * 
     */
    public List<HostNIC> getSlaves() {
        if (slaves == null) {
            slaves = new ArrayList<HostNIC>();
        }
        return this.slaves;
    }

    public boolean isSetSlaves() {
        return ((this.slaves!= null)&&(!this.slaves.isEmpty()));
    }

    public void unsetSlaves() {
        this.slaves = null;
    }

}
