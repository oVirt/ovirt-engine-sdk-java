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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Display complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Display">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="address" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="port" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" minOccurs="0"/>
 *         &lt;element name="secure_port" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" minOccurs="0"/>
 *         &lt;element name="monitors" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="single_qxl_pci" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="allow_override" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element ref="{}certificate" minOccurs="0"/>
 *         &lt;element name="smartcard_enabled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="keyboard_layout" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="proxy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="file_transfer_enabled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="copy_paste_enabled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Display", propOrder = {
    "type",
    "address",
    "port",
    "securePort",
    "monitors",
    "singleQxlPci",
    "allowOverride",
    "certificate",
    "smartcardEnabled",
    "keyboardLayout",
    "proxy",
    "fileTransferEnabled",
    "copyPasteEnabled"
})
public class Display {

    protected String type;
    protected String address;
    @XmlSchemaType(name = "unsignedShort")
    protected Integer port;
    @XmlElement(name = "secure_port")
    @XmlSchemaType(name = "unsignedShort")
    protected Integer securePort;
    protected Integer monitors;
    @XmlElement(name = "single_qxl_pci")
    protected Boolean singleQxlPci;
    @XmlElement(name = "allow_override")
    protected Boolean allowOverride;
    protected Certificate certificate;
    @XmlElement(name = "smartcard_enabled")
    protected Boolean smartcardEnabled;
    @XmlElement(name = "keyboard_layout")
    protected String keyboardLayout;
    protected String proxy;
    @XmlElement(name = "file_transfer_enabled")
    protected Boolean fileTransferEnabled;
    @XmlElement(name = "copy_paste_enabled")
    protected Boolean copyPasteEnabled;

    /**
     * Gets the value of the type property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setType(String value) {
        this.type = value;
    }

    public boolean isSetType() {
        return (this.type!= null);
    }

    /**
     * Gets the value of the address property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAddress(String value) {
        this.address = value;
    }

    public boolean isSetAddress() {
        return (this.address!= null);
    }

    /**
     * Gets the value of the port property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getPort() {
        return port;
    }

    /**
     * Sets the value of the port property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setPort(Integer value) {
        this.port = value;
    }

    public boolean isSetPort() {
        return (this.port!= null);
    }

    /**
     * Gets the value of the securePort property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getSecurePort() {
        return securePort;
    }

    /**
     * Sets the value of the securePort property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setSecurePort(Integer value) {
        this.securePort = value;
    }

    public boolean isSetSecurePort() {
        return (this.securePort!= null);
    }

    /**
     * Gets the value of the monitors property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getMonitors() {
        return monitors;
    }

    /**
     * Sets the value of the monitors property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setMonitors(Integer value) {
        this.monitors = value;
    }

    public boolean isSetMonitors() {
        return (this.monitors!= null);
    }

    /**
     * Gets the value of the singleQxlPci property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getSingleQxlPci() {
        return singleQxlPci;
    }

    /**
     * Sets the value of the singleQxlPci property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setSingleQxlPci(Boolean value) {
        this.singleQxlPci = value;
    }

    public boolean isSetSingleQxlPci() {
        return (this.singleQxlPci!= null);
    }

    /**
     * Gets the value of the allowOverride property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getAllowOverride() {
        return allowOverride;
    }

    /**
     * Sets the value of the allowOverride property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setAllowOverride(Boolean value) {
        this.allowOverride = value;
    }

    public boolean isSetAllowOverride() {
        return (this.allowOverride!= null);
    }

    /**
     * Gets the value of the certificate property.
     *
     * @return
     *     possible object is
     *     {@link Certificate }
     *
     */
    public Certificate getCertificate() {
        return certificate;
    }

    /**
     * Sets the value of the certificate property.
     *
     * @param value
     *     allowed object is
     *     {@link Certificate }
     *
     */
    public void setCertificate(Certificate value) {
        this.certificate = value;
    }

    public boolean isSetCertificate() {
        return (this.certificate!= null);
    }

    /**
     * Gets the value of the smartcardEnabled property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getSmartcardEnabled() {
        return smartcardEnabled;
    }

    /**
     * Sets the value of the smartcardEnabled property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setSmartcardEnabled(Boolean value) {
        this.smartcardEnabled = value;
    }

    public boolean isSetSmartcardEnabled() {
        return (this.smartcardEnabled!= null);
    }

    /**
     * Gets the value of the keyboardLayout property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getKeyboardLayout() {
        return keyboardLayout;
    }

    /**
     * Sets the value of the keyboardLayout property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setKeyboardLayout(String value) {
        this.keyboardLayout = value;
    }

    public boolean isSetKeyboardLayout() {
        return (this.keyboardLayout!= null);
    }

    /**
     * Gets the value of the proxy property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getProxy() {
        return proxy;
    }

    /**
     * Sets the value of the proxy property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setProxy(String value) {
        this.proxy = value;
    }

    public boolean isSetProxy() {
        return (this.proxy!= null);
    }

    /**
     * Gets the value of the fileTransferEnabled property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getFileTransferEnabled() {
        return fileTransferEnabled;
    }

    /**
     * Sets the value of the fileTransferEnabled property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setFileTransferEnabled(Boolean value) {
        this.fileTransferEnabled = value;
    }

    public boolean isSetFileTransferEnabled() {
        return (this.fileTransferEnabled!= null);
    }

    /**
     * Gets the value of the copyPasteEnabled property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getCopyPasteEnabled() {
        return copyPasteEnabled;
    }

    /**
     * Sets the value of the copyPasteEnabled property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setCopyPasteEnabled(Boolean value) {
        this.copyPasteEnabled = value;
    }

    public boolean isSetCopyPasteEnabled() {
        return (this.copyPasteEnabled!= null);
    }

}

