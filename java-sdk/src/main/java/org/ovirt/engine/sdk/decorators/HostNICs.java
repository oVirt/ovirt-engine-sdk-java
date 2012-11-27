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
import java.util.UUID;

import javax.xml.bind.JAXBException;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.ovirt.engine.sdk.common.CollectionDecorator;
import org.ovirt.engine.sdk.exceptions.ServerException;
import org.ovirt.engine.sdk.utils.CollectionUtils;
import org.ovirt.engine.sdk.utils.HttpHeaderUtils;
import org.ovirt.engine.sdk.utils.UrlHelper;
import org.ovirt.engine.sdk.web.HttpProxyBroker;
import org.ovirt.engine.sdk.web.UrlParameterType;
import org.ovirt.engine.sdk.entities.Action;

/**
 * HostNics decorator.
 */
@SuppressWarnings("unused")
public class HostNICs extends
        CollectionDecorator<org.ovirt.engine.sdk.entities.HostNIC,
                            org.ovirt.engine.sdk.entities.HostNics,
                            HostNIC> {

    private Host parent;

    /**
     * @param proxy HttpProxyBroker
     * @param parent Host
     */
    public HostNICs(HttpProxyBroker proxy, Host parent) {
        super(proxy, "nics");
        this.parent = parent;
    }

    /**
     * Lists HostNIC objects.
     * 
     * @return
     *     List<HostNIC>
     *
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws IOException
     * @throws JAXBException
     */
    @Override
    public List<HostNIC> list() throws ClientProtocolException,
            ServerException, IOException, JAXBException {
        String url = this.parent.getHref() + SLASH + getName();
        return list(url, org.ovirt.engine.sdk.entities.HostNics.class, HostNIC.class);
    }

    /**
     * Fetches HostNIC object by id.
     * 
     * @return 
     *     {@link HostNIC }
     *
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws IOException
     * @throws JAXBException
     */
    @Override
    public HostNIC get(UUID id) throws ClientProtocolException,
            ServerException, IOException, JAXBException {
        String url = this.parent.getHref() + SLASH + getName() + SLASH + id.toString();
        return getProxy().get(url, org.ovirt.engine.sdk.entities.HostNIC.class, HostNIC.class);
    }

    /**
     * Performs setupnetworks action.
     *
     * @param action Action
     *
     * @return
     *     {@link Action }
     *
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws IOException
     * @throws JAXBException
     */
   public Action setupnetworks(Action action) throws ClientProtocolException,
            ServerException, IOException, JAXBException {
        String url = this.parent.getHref() + SLASH + "setupnetworks";
        return getProxy().action(url, action, Action.class, Action.class);
    }
    /**
     * Adds HostNIC object.
     * 
     * @param HostNIC
     *
     * @return
     *     {@link HostNIC }
     *
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws IOException
     * @throws JAXBException
     */
    public HostNIC add(org.ovirt.engine.sdk.entities.HostNIC hostnic) throws 
            ClientProtocolException, ServerException, IOException, JAXBException {
        String url = this.parent.getHref() + SLASH + getName();
        return getProxy().add(url, hostnic, org.ovirt.engine.sdk.entities.HostNIC.class, HostNIC.class);
    }

}

