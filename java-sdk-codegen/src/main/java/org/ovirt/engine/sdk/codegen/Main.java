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

package org.ovirt.engine.sdk.codegen;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.apache.http.client.ClientProtocolException;
import org.ovirt.engine.sdk.codegen.xsd.XsdCodegen;
import org.ovirt.engine.sdk.exceptions.ServerException;
import org.ovirt.engine.sdk.utils.ConnectionsPoolBuilder;
import org.ovirt.engine.sdk.utils.HttpProxyBuilder;
import org.ovirt.engine.sdk.web.HttpProxy;

/**
 * oVirt java-sdk codegen suite
 */
public class Main {

    private static final String API_URL = "http://localhost:8080/api";
    private static final String USER = "admin@internal";
    private static final String PASSWORD = "123456";

    public static void main(String[] args) throws ClientProtocolException,
            ServerException, IOException, JAXBException {
        HttpProxy httpProxy =
                new HttpProxyBuilder(
                        new ConnectionsPoolBuilder(API_URL, USER, PASSWORD).build()
                        ).build();

        // #1 - download xsd schema from api & generate java entities classes from it
        XsdCodegen.generate(httpProxy);

        // #2 - generate API e.p

        // #3 - generate entities decorators

        // #$ - compile java-sdk

        // #5 - exit
        System.exit(0);
    }
}
