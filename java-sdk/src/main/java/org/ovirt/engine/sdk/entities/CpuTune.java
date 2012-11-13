
package org.ovirt.engine.sdk.entities;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CpuTune complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CpuTune">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="vcpu_pin" type="{}VCpuPin" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CpuTune", propOrder = {
    "vcpuPin"
})
public class CpuTune {

    @XmlElement(name = "vcpu_pin")
    protected List<VCpuPin> vcpuPin;

    /**
     * Gets the value of the vcpuPin property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vcpuPin property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVcpuPin().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VCpuPin }
     * 
     * 
     */
    public List<VCpuPin> getVcpuPin() {
        if (vcpuPin == null) {
            vcpuPin = new ArrayList<VCpuPin>();
        }
        return this.vcpuPin;
    }

    public boolean isSetVcpuPin() {
        return ((this.vcpuPin!= null)&&(!this.vcpuPin.isEmpty()));
    }

    public void unsetVcpuPin() {
        this.vcpuPin = null;
    }

}
