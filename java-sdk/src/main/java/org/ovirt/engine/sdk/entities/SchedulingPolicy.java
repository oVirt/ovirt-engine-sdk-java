
package org.ovirt.engine.sdk.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SchedulingPolicy complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SchedulingPolicy">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="policy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="thresholds" type="{}SchedulingPolicyThresholds" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SchedulingPolicy", propOrder = {
    "policy",
    "thresholds"
})
public class SchedulingPolicy {

    protected String policy;
    protected SchedulingPolicyThresholds thresholds;

    /**
     * Gets the value of the policy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPolicy() {
        return policy;
    }

    /**
     * Sets the value of the policy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPolicy(String value) {
        this.policy = value;
    }

    public boolean isSetPolicy() {
        return (this.policy!= null);
    }

    /**
     * Gets the value of the thresholds property.
     * 
     * @return
     *     possible object is
     *     {@link SchedulingPolicyThresholds }
     *     
     */
    public SchedulingPolicyThresholds getThresholds() {
        return thresholds;
    }

    /**
     * Sets the value of the thresholds property.
     * 
     * @param value
     *     allowed object is
     *     {@link SchedulingPolicyThresholds }
     *     
     */
    public void setThresholds(SchedulingPolicyThresholds value) {
        this.thresholds = value;
    }

    public boolean isSetThresholds() {
        return (this.thresholds!= null);
    }

}
