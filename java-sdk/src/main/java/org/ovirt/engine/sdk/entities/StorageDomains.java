
package org.ovirt.engine.sdk.entities;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StorageDomains complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StorageDomains">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseResources">
 *       &lt;sequence>
 *         &lt;element ref="{}storage_domain" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StorageDomains", propOrder = {
    "storageDomains"
})
public class StorageDomains
    extends BaseResources
{

    @XmlElement(name = "storage_domain")
    protected List<StorageDomain> storageDomains;

    /**
     * Gets the value of the storageDomains property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the storageDomains property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStorageDomains().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StorageDomain }
     * 
     * 
     */
    public List<StorageDomain> getStorageDomains() {
        if (storageDomains == null) {
            storageDomains = new ArrayList<StorageDomain>();
        }
        return this.storageDomains;
    }

    public boolean isSetStorageDomains() {
        return ((this.storageDomains!= null)&&(!this.storageDomains.isEmpty()));
    }

    public void unsetStorageDomains() {
        this.storageDomains = null;
    }

}
