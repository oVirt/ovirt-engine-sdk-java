
package org.ovirt.engine.sdk.entities;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DataCenterStates complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DataCenterStates">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="data_center_state" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataCenterStates", propOrder = {
    "dataCenterStates"
})
public class DataCenterStates {

    @XmlElement(name = "data_center_state")
    protected List<String> dataCenterStates;

    /**
     * Gets the value of the dataCenterStates property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dataCenterStates property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDataCenterStates().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getDataCenterStates() {
        if (dataCenterStates == null) {
            dataCenterStates = new ArrayList<String>();
        }
        return this.dataCenterStates;
    }

    public boolean isSetDataCenterStates() {
        return ((this.dataCenterStates!= null)&&(!this.dataCenterStates.isEmpty()));
    }

    public void unsetDataCenterStates() {
        this.dataCenterStates = null;
    }

}
