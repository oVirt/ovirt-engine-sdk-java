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

package org.ovirt.engine.sdk.utils;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;

public class UrlHelper {

    private static final String DEFAULT_ENCODING = "UTF-8";
    private static String SLASH = "/";

    private URL url;
    private String effectiveUri;
    private String root;

    public UrlHelper(URL url) {
        this.url = url;
        this.root = url.getPath();
        this.effectiveUri = url.toString().replace(this.root, "");
    }

    /**
     * Combines offset path in to FQ resource identifier
     * 
     * @param path
     *            offset patch
     * 
     * @return FQ resource identifier
     */
    public String combine(String path) {
        if (path.startsWith(this.root)) {
            return this.effectiveUri + path;
        }
        if (this.root.startsWith(SLASH))
            return this.effectiveUri + this.root + path;
        return this.effectiveUri + SLASH + this.root + path;
    }

    /**
     * Returns FQ URL
     * 
     * @return URL
     */
    public URL getUrl() {
        return url;
    }

    /**
     * Returns server root resource
     * 
     * @return String
     */
    public String getRoot() {
        return root;
    }

    /**
     * Encodes url using UTF-8
     * 
     * @param url
     *            to encode
     * 
     * @return encoded url
     */
    public static String encode(String url) {
        try {
            return URLEncoder.encode(url, DEFAULT_ENCODING);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return url;
        }
    }
}
