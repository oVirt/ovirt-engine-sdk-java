
package org.ovirt.engine.sdk.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Bonding complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Bonding">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}options" minOccurs="0"/>
 *         &lt;element ref="{}slaves" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Bonding", propOrder = {
    "options",
    "slaves"
})
public class Bonding {

    protected Options options;
    protected Slaves slaves;

    /**
     * Gets the value of the options property.
     * 
     * @return
     *     possible object is
     *     {@link Options }
     *     
     */
    public Options getOptions() {
        return options;
    }

    /**
     * Sets the value of the options property.
     * 
     * @param value
     *     allowed object is
     *     {@link Options }
     *     
     */
    public void setOptions(Options value) {
        this.options = value;
    }

    public boolean isSetOptions() {
        return (this.options!= null);
    }

    /**
     * Gets the value of the slaves property.
     * 
     * @return
     *     possible object is
     *     {@link Slaves }
     *     
     */
    public Slaves getSlaves() {
        return slaves;
    }

    /**
     * Sets the value of the slaves property.
     * 
     * @param value
     *     allowed object is
     *     {@link Slaves }
     *     
     */
    public void setSlaves(Slaves value) {
        this.slaves = value;
    }

    public boolean isSetSlaves() {
        return (this.slaves!= null);
    }

}
