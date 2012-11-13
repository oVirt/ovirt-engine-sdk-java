
package org.ovirt.engine.sdk.entities;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostNics complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostNics">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseResources">
 *       &lt;sequence>
 *         &lt;element ref="{}host_nic" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostNics", propOrder = {
    "hostNics"
})
public class HostNics
    extends BaseResources
{

    @XmlElement(name = "host_nic")
    protected List<HostNIC> hostNics;

    /**
     * Gets the value of the hostNics property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hostNics property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHostNics().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostNIC }
     * 
     * 
     */
    public List<HostNIC> getHostNics() {
        if (hostNics == null) {
            hostNics = new ArrayList<HostNIC>();
        }
        return this.hostNics;
    }

    public boolean isSetHostNics() {
        return ((this.hostNics!= null)&&(!this.hostNics.isEmpty()));
    }

    public void unsetHostNics() {
        this.hostNics = null;
    }

}
