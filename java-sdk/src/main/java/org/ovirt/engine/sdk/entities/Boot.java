
package org.ovirt.engine.sdk.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Boot complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Boot">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="dev" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Boot")
public class Boot {

    @XmlAttribute
    protected String dev;

    /**
     * Gets the value of the dev property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDev() {
        return dev;
    }

    /**
     * Sets the value of the dev property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDev(String value) {
        this.dev = value;
    }

    public boolean isSetDev() {
        return (this.dev!= null);
    }

}
