/*
Copyright (c) 2016 Red Hat, Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package org.ovirt.engine.sdk4.internal;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.client.utils.URIBuilder;
import org.ovirt.engine.sdk4.Error;

/**
 * Helper class, which provides methods to work with SSO.
 */
public class SsoUtils {

    private static final String ENTRY_POINT_HTTP = "token-http-auth";
    private static final String ENTRY_POINT_TOKEN = "token";

    /**
     * Construct SSO URL to obtain token from username and password.
     *
     * @param url oVirt engine URL
     * @return URI to be used to obtain token
     */
    public static URI buildSsoUrlBasic(String url) {
        try {
            URI uri = new URI(url);
            URIBuilder uriBuilder = new URIBuilder(
                String.format(
                    "%1$s://%2$s/ovirt-engine/sso/oauth/%3$s",
                    uri.getScheme(),
                    uri.getAuthority(),
                    ENTRY_POINT_TOKEN
                )
            );
            return uriBuilder.build();
        }
        catch (URISyntaxException ex) {
            throw new Error("Failed to build SSO authentication URL", ex);
        }
    }

    /**
     * Construct SSO URL to obtain token from kerberos authentication.
     *
     * @param url oVirt engine URL
     * @return URI to be used to obtain token
     */
    public static URI buildSsoUrlKerberos(String url) {
        try {
            URI uri = new URI(url);
            URIBuilder uriBuilder = new URIBuilder(
                String.format(
                    "%1$s://%2$s/ovirt-engine/sso/oauth/%3$s",
                    uri.getScheme(),
                    uri.getAuthority(),
                    ENTRY_POINT_HTTP
                )
            );
            return uriBuilder.build();
        }
        catch (URISyntaxException ex) {
            throw new Error("Failed to build SSO authentication URL", ex);
        }
    }

    /**
     * Construct SSO URL to revoke SSO token
     *
     * @param url oVirt engine URL
     * @return URI to be used to revoke token
     */
    public static URI buildSsoRevokeUrl(String url) {
        try {
            URI uri = new URI(url);
            URIBuilder uriBuilder = new URIBuilder(
                String.format(
                    "%1$s://%2$s/ovirt-engine/services/sso-logout",
                    uri.getScheme(),
                    uri.getAuthority()
                )
            );
            return uriBuilder.build();
        }
        catch (URISyntaxException ex) {
            throw new Error("Failed to build SSO revoke URL", ex);
        }
    }

    /**
     * Construct simple URL
     *
     * @param url url to build
     * @return URI
     */
    public static URI buildUrl(String url) {
        try {
            return new URI(url);
        }
        catch (URISyntaxException ex) {
            throw new Error("Failed to build URL", ex);
        }
    }
}
