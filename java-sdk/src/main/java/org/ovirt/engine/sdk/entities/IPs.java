
package org.ovirt.engine.sdk.entities;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IPs complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IPs">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseResources">
 *       &lt;sequence>
 *         &lt;element ref="{}ip" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IPs", propOrder = {
    "iPs"
})
public class IPs
    extends BaseResources
{

    @XmlElement(name = "ip")
    protected List<IP> iPs;

    /**
     * Gets the value of the iPs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the iPs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIPs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IP }
     * 
     * 
     */
    public List<IP> getIPs() {
        if (iPs == null) {
            iPs = new ArrayList<IP>();
        }
        return this.iPs;
    }

    public boolean isSetIPs() {
        return ((this.iPs!= null)&&(!this.iPs.isEmpty()));
    }

    public void unsetIPs() {
        this.iPs = null;
    }

}
