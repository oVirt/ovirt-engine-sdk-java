
package org.ovirt.engine.sdk.entities;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Networks complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Networks">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseResources">
 *       &lt;sequence>
 *         &lt;element ref="{}network" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Networks", propOrder = {
    "networks"
})
public class Networks
    extends BaseResources
{

    @XmlElement(name = "network")
    protected List<Network> networks;

    /**
     * Gets the value of the networks property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the networks property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNetworks().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Network }
     * 
     * 
     */
    public List<Network> getNetworks() {
        if (networks == null) {
            networks = new ArrayList<Network>();
        }
        return this.networks;
    }

    public boolean isSetNetworks() {
        return ((this.networks!= null)&&(!this.networks.isEmpty()));
    }

    public void unsetNetworks() {
        this.networks = null;
    }

}
