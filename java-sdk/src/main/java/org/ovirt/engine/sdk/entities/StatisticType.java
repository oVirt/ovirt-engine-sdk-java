
package org.ovirt.engine.sdk.entities;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StatisticType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="StatisticType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="GAUGE"/>
 *     &lt;enumeration value="COUNTER"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "StatisticType")
@XmlEnum
public enum StatisticType {

    GAUGE,
    COUNTER;

    public String value() {
        return name();
    }

    public static StatisticType fromValue(String v) {
        return valueOf(v);
    }

}
