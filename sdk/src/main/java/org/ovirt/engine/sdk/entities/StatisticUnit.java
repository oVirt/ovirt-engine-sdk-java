//
// Copyright (c) 2012 Red Hat, Inc.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//           http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
//

// *********************************************************************
// ********************* GENERATED CODE - DO NOT MODIFY ****************
// *********************************************************************


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

