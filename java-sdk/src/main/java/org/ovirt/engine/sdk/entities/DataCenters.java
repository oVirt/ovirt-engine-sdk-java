
package org.ovirt.engine.sdk.entities;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DataCenters complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DataCenters">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseResources">
 *       &lt;sequence>
 *         &lt;element ref="{}data_center" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataCenters", propOrder = {
    "dataCenters"
})
public class DataCenters
    extends BaseResources
{

    @XmlElement(name = "data_center")
    protected List<DataCenter> dataCenters;

    /**
     * Gets the value of the dataCenters property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dataCenters property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDataCenters().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DataCenter }
     * 
     * 
     */
    public List<DataCenter> getDataCenters() {
        if (dataCenters == null) {
            dataCenters = new ArrayList<DataCenter>();
        }
        return this.dataCenters;
    }

    public boolean isSetDataCenters() {
        return ((this.dataCenters!= null)&&(!this.dataCenters.isEmpty()));
    }

    public void unsetDataCenters() {
        this.dataCenters = null;
    }

}
