
package org.ovirt.engine.sdk.entities;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Url complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Url">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}parameters_set" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Url", propOrder = {
    "parametersSets"
})
public class Url {

    @XmlElement(name = "parameters_set")
    protected List<ParametersSet> parametersSets;

    /**
     * Gets the value of the parametersSets property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the parametersSets property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParametersSets().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ParametersSet }
     * 
     * 
     */
    public List<ParametersSet> getParametersSets() {
        if (parametersSets == null) {
            parametersSets = new ArrayList<ParametersSet>();
        }
        return this.parametersSets;
    }

    public boolean isSetParametersSets() {
        return ((this.parametersSets!= null)&&(!this.parametersSets.isEmpty()));
    }

    public void unsetParametersSets() {
        this.parametersSets = null;
    }

}
