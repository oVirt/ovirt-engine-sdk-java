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

package org.ovirt.engine.sdk.decorators;

import java.io.IOException;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.ovirt.engine.sdk.entities.Action;
import org.ovirt.engine.sdk.entities.Response;
import org.ovirt.engine.sdk.exceptions.ServerException;
import org.ovirt.engine.sdk.utils.HttpHeaderUtils;
import org.ovirt.engine.sdk.web.HttpProxyBroker;

/**
 * Template decorator.
 */
@SuppressWarnings("unused")
public class Template extends
        org.ovirt.engine.sdk.entities.Template {

    private HttpProxyBroker proxy;

    private TemplateCdRoms templateCdRoms;
    private TemplateNICs templateNICs;
    private TemplatePermissions templatePermissions;
    private TemplateDisks templateDisks;


    /**
     * @param proxy HttpProxyBroker
     */
    public Template(HttpProxyBroker proxy) {
        this.proxy = proxy;
    }

    /**
     * @return HttpProxyBroker
     */
    private HttpProxyBroker getProxy() {
        return proxy;
    }

    /**
     * Gets TemplateCdRoms collection decorator.
     * 
     * @return
     *     {@link TemplateCdRoms }
     *     
     */
    public synchronized TemplateCdRoms getCdRoms() {
        if (this.templateCdRoms == null) {
            this.templateCdRoms = new TemplateCdRoms(proxy, this);
        }
        return templateCdRoms;
    }
    /**
     * Gets TemplateNICs collection decorator.
     * 
     * @return
     *     {@link TemplateNICs }
     *     
     */
    public synchronized TemplateNICs getNics() {
        if (this.templateNICs == null) {
            this.templateNICs = new TemplateNICs(proxy, this);
        }
        return templateNICs;
    }
    /**
     * Gets TemplatePermissions collection decorator.
     * 
     * @return
     *     {@link TemplatePermissions }
     *     
     */
    public synchronized TemplatePermissions getPermissions() {
        if (this.templatePermissions == null) {
            this.templatePermissions = new TemplatePermissions(proxy, this);
        }
        return templatePermissions;
    }
    /**
     * Gets TemplateDisks collection decorator.
     * 
     * @return
     *     {@link TemplateDisks }
     *     
     */
    public synchronized TemplateDisks getDisks() {
        if (this.templateDisks == null) {
            this.templateDisks = new TemplateDisks(proxy, this);
        }
        return templateDisks;
    }


    /**
     * Updates Template object.
     *
     * @param template
     *
     * <pre>
     * [template.name]
     * [template.memory]
     * [template.cpu.topology.cores]
     * [template.high_availability.enabled]
     * [template.os.cmdline]
     * [template.origin]
     * [template.high_availability.priority]
     * [template.timezone]
     * [template.domain.name]
     * [template.type]
     * [template.stateless]
     * [template.placement_policy.affinity]
     * [template.description]
     * [template.custom_properties.custom_property]
     * [template.os.type]
     * [template.os.boot]
     * [template.cpu.topology.sockets]
     * [template.os.kernel]
     * [template.display.type]
     * [template.display.monitors]
     * [template.display.allow_override]
     * [template.display.smartcard_enabled]
     * [template.os.initRd]
     * [template.usb.enabled]
     * [template.usb.type]
     * </pre>
     *
     * @return
     *     {@link Template }
     *
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws IOException
     */
    public Template update() throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref();
        return getProxy().update(url, this, org.ovirt.engine.sdk.entities.Template.class, Template.class);
    }
    /**
     * Performs export action.
     *
     * @param action
     *
     * <pre>
     * action.storage_domain.id|name
     * [action.async]
     * [action.exclusive]
     * [action.grace_period.expiry]
     * </pre>
     *
     * @return
     *     {@link Action }
     *
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws IOException
     */
    public Action export(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/export";
        return getProxy().action(url, action, Action.class, Action.class);
    }
    /**
     * Deletes object.
     *
     * @return
     *     {@link Response }
     *
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws IOException
     */
    public Response delete() throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref();
        return getProxy().delete(url, Response.class);
    }

}

