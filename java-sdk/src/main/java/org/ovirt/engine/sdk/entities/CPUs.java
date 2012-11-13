
package org.ovirt.engine.sdk.entities;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CPUs complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CPUs">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}cpu" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CPUs", propOrder = {
    "cpUs"
})
public class CPUs {

    @XmlElement(name = "cpu", required = true)
    protected List<CPU> cpUs;

    /**
     * Gets the value of the cpUs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cpUs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCPUs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CPU }
     * 
     * 
     */
    public List<CPU> getCPUs() {
        if (cpUs == null) {
            cpUs = new ArrayList<CPU>();
        }
        return this.cpUs;
    }

    public boolean isSetCPUs() {
        return ((this.cpUs!= null)&&(!this.cpUs.isEmpty()));
    }

    public void unsetCPUs() {
        this.cpUs = null;
    }

}
