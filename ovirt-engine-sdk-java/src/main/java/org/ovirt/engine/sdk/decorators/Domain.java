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
import org.ovirt.engine.sdk.utils.HttpHeaderBuilder;
import org.ovirt.engine.sdk.utils.HttpHeaderUtils;
import org.ovirt.engine.sdk.utils.UrlBuilder;
import org.ovirt.engine.sdk.web.HttpProxyBroker;
import org.ovirt.engine.sdk.web.UrlParameterType;

/**
 * <p>Domain providing relation and functional services
 * <p>to {@link org.ovirt.engine.sdk.entities.Domain }.
 */
@SuppressWarnings("unused")
public class Domain extends
        org.ovirt.engine.sdk.entities.Domain {

    private HttpProxyBroker proxy;
    private final Object LOCK = new Object();

    private volatile DomainGroups domainGroups;
    private volatile DomainUsers domainUsers;


    /**
     * @param proxy HttpProxyBroker
     */
    public Domain(HttpProxyBroker proxy) {
        this.proxy = proxy;
    }

    /**
     * @return HttpProxyBroker
     */
    private HttpProxyBroker getProxy() {
        return proxy;
    }

    /**
     * Gets the value of the DomainGroups property.
     *
     * @return
     *     {@link DomainGroups }
     */
    public DomainGroups getGroups() {
        if (this.domainGroups == null) {
            synchronized (this.LOCK) {
                if (this.domainGroups == null) {
                    this.domainGroups = new DomainGroups(proxy, this);
                }
            }
        }
        return domainGroups;
    }
    /**
     * Gets the value of the DomainUsers property.
     *
     * @return
     *     {@link DomainUsers }
     */
    public DomainUsers getUsers() {
        if (this.domainUsers == null) {
            synchronized (this.LOCK) {
                if (this.domainUsers == null) {
                    this.domainUsers = new DomainUsers(proxy, this);
                }
            }
        }
        return domainUsers;
    }



}

