
package org.ovirt.engine.sdk.entities;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StatisticUnit.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="StatisticUnit">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NONE"/>
 *     &lt;enumeration value="PERCENT"/>
 *     &lt;enumeration value="BYTES"/>
 *     &lt;enumeration value="SECONDS"/>
 *     &lt;enumeration value="BYTES_PER_SECOND"/>
 *     &lt;enumeration value="BITS_PER_SECOND"/>
 *     &lt;enumeration value="COUNT_PER_SECOND"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "StatisticUnit")
@XmlEnum
public enum StatisticUnit {

    NONE,
    PERCENT,
    BYTES,
    SECONDS,
    BYTES_PER_SECOND,
    BITS_PER_SECOND,
    COUNT_PER_SECOND;

    public String value() {
        return name();
    }

    public static StatisticUnit fromValue(String v) {
        return valueOf(v);
    }

}
