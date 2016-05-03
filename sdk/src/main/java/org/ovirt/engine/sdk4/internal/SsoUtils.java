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

    private static final String SCOPE = "ovirt-app-api";
    private static final String GRANT_TYPE_PASSWORD = "password";
    private static final String GRANT_TYPE_HTTP = "urn:ovirt:params:oauth:grant-type:http";
    private static final String ENTRY_POINT_HTTP = "token-http-auth";
    private static final String ENTRY_POINT_TOKEN = "token";

    /**
     * Construct SSO URL to obtain token from username and password.
     *
     * @param url oVirt engine URL
     * @param username username to obtain ticket for
     * @param password password of user
     * @return URI to be used to obtain token
     */
    public static URI buildSsoUrlBasic(String url, String username, String password) {
        try {
            URIBuilder uriBuilder = new URIBuilder(
                String.format(
                    "%1$s/sso/oauth/%2$s",
                    url.substring(0, url.lastIndexOf("/")),
                    ENTRY_POINT_TOKEN
                )
            );
            uriBuilder.addParameter("grant_type", GRANT_TYPE_PASSWORD);
            uriBuilder.addParameter("scope", SCOPE);
            uriBuilder.addParameter("username", username);
            uriBuilder.addParameter("password", password);
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
            URIBuilder uriBuilder = new URIBuilder(
                String.format(
                    "%1$s/sso/oauth/%2$s",
                    url.substring(0, url.lastIndexOf("/")),
                    ENTRY_POINT_HTTP
                )
            );
            uriBuilder.addParameter("grant_type", GRANT_TYPE_HTTP);
            uriBuilder.addParameter("scope", SCOPE);
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
     * @param ssoToken SSO token to revoke
     * @return URI to be used to obtain token
     */
    public static URI buildSsoRevokeUrl(String url, String ssoToken) {
        try {
            URIBuilder uriBuilder = new URIBuilder(
                String.format(
                    "%1$s/services/sso-logout",
                    url.substring(0, url.lastIndexOf("/"))
                )
            );
            uriBuilder.addParameter("scope", SCOPE);
            uriBuilder.addParameter("token", ssoToken);
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
