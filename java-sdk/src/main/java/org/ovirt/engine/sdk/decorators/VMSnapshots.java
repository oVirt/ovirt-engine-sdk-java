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
 * Snapshots decorator.
 */
@SuppressWarnings("unused")
public class VMSnapshots extends
        CollectionDecorator<org.ovirt.engine.sdk.entities.Snapshot,
                            org.ovirt.engine.sdk.entities.Snapshots,
                            VMSnapshot> {

    private VM parent;

    /**
     * @param proxy HttpProxyBroker
     * @param parent VM
     */
    public VMSnapshots(HttpProxyBroker proxy, VM parent) {
        super(proxy, "snapshots");
        this.parent = parent;
    }

    /**
     * Lists VMSnapshot objects.
     * 
     * @return
     *     List of VMSnapshots
     *
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws IOException
     * @throws JAXBException
     */
    @Override
    public List<VMSnapshot> list() throws ClientProtocolException,
            ServerException, IOException, JAXBException {
        String url = this.parent.getHref() + SLASH + getName();
        return list(url, org.ovirt.engine.sdk.entities.Snapshots.class, VMSnapshot.class);
    }

    /**
     * Fetches VMSnapshot object by id.
     * 
     * @return 
     *     {@link VMSnapshot }
     *
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws IOException
     * @throws JAXBException
     */
    @Override
    public VMSnapshot get(UUID id) throws ClientProtocolException,
            ServerException, IOException, JAXBException {
        String url = this.parent.getHref() + SLASH + getName() + SLASH + id.toString();
        return getProxy().get(url, org.ovirt.engine.sdk.entities.Snapshot.class, VMSnapshot.class);
    }

    /**
     * Adds Snapshot object.
     *
     * @param Snapshot
     *
     * snapshot.description
     *
     * @return
     *     {@link VMSnapshot }
     *
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws IOException
     * @throws JAXBException
     */
    public VMSnapshot add(org.ovirt.engine.sdk.entities.Snapshot snapshot) throws 
            ClientProtocolException, ServerException, IOException, JAXBException {
        String url = this.parent.getHref() + SLASH + getName();
        return getProxy().add(url, snapshot, org.ovirt.engine.sdk.entities.Snapshot.class, VMSnapshot.class);
    }

}

