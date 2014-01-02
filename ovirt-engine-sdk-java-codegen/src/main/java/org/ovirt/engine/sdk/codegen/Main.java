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

import org.ovirt.engine.sdk.codegen.rsdl.RsdlCodegen;
import org.ovirt.engine.sdk.codegen.xsd.XsdCodegen;
import org.ovirt.engine.sdk.exceptions.ServerException;
import org.ovirt.engine.sdk.web.ConnectionsPool;
import org.ovirt.engine.sdk.web.ConnectionsPoolBuilder;
import org.ovirt.engine.sdk.web.HttpProxyBroker;
import org.ovirt.engine.sdk.web.HttpProxyBuilder;

/**
 * oVirt ovirt-engine-sdk-java codegen suite
 */
public class Main {
    private static final String DEFAULT_URL = "http://localhost:8080/ovirt-engine/api";
    private static final String DEFAULT_USER = "admin@internal";
    private static final String DEFAULT_PASSWORD = "letmein!";

    public static void main(String[] args) throws ServerException, IOException, JAXBException {
        // Parse the command line parameters:
        String url = DEFAULT_URL;
        String user = DEFAULT_USER;
        String password = DEFAULT_PASSWORD;
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
            case "--url":
                i++;
                if (i < args.length) {
                    url = args[i];
                }
                break;
            case "--user":
                i++;
                if (i < args.length) {
                    user = args[i];
                }
                break;
            case "--password":
                i++;
                if (i < args.length) {
                    password = args[i];
                }
                break;
            default:
                System.err.println("Unknown command line parameter \"" + args[i] + "\".");
                System.exit(1);
            }
        }

        // Create a connection pool that allows us to connect to SSL protected servers without verificating the host
        // name, as this verification is an unnecessary complication for the code generator:
        ConnectionsPool pool = new ConnectionsPoolBuilder(url, user, password)
            .noHostVerification(true)
            .build();

        HttpProxyBroker httpProxyBroker = new HttpProxyBroker(
                new HttpProxyBuilder(pool).build());

        // #1 - generate api entities from the XSD schema
        new XsdCodegen(httpProxyBroker).generate();

        // #2 - generate api entities decorators by RSDL and SDK entry point
        new RsdlCodegen(httpProxyBroker).generate();

        // #3 - exit
        System.exit(0);
    }
}
