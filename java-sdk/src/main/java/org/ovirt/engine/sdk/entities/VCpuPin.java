
package org.ovirt.engine.sdk.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VCpuPin complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VCpuPin">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="vcpu" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="cpu_set" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VCpuPin")
public class VCpuPin {

    @XmlAttribute(required = true)
    protected int vcpu;
    @XmlAttribute(name = "cpu_set", required = true)
    protected String cpuSet;

    /**
     * Gets the value of the vcpu property.
     * 
     */
    public int getVcpu() {
        return vcpu;
    }

    /**
     * Sets the value of the vcpu property.
     * 
     */
    public void setVcpu(int value) {
        this.vcpu = value;
    }

    public boolean isSetVcpu() {
        return true;
    }

    /**
     * Gets the value of the cpuSet property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCpuSet() {
        return cpuSet;
    }

    /**
     * Sets the value of the cpuSet property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCpuSet(String value) {
        this.cpuSet = value;
    }

    public boolean isSetCpuSet() {
        return (this.cpuSet!= null);
    }

}
