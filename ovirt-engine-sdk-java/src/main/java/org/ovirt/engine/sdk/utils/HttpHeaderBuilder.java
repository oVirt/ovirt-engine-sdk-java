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

import java.util.ArrayList;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.ovirt.engine.sdk.entities.KeyValuePair;

/**
 * Providing Http Header building services
 */
public class HttpHeaderBuilder {

    private List<HttpHeaderParameter> params;

    /**
     * Providing Http Header building services
     */
    public HttpHeaderBuilder() {
        this.params = new ArrayList<HttpHeaderParameter>();
    }

    /**
     * Providing Http Header building services
     * 
     * @param headers
     *            headers to use as template
     */
    public HttpHeaderBuilder(List<HttpHeaderParameter> headers) {
        this.params = headers;
    }

    /**
     * Adds Http Header parameter
     * 
     * @param key
     *            the key of the url param
     * @param value
     *            the value of the url param
     * 
     * @return HttpHeaderBuilder
     */
    public HttpHeaderBuilder add(String key, Object value) {
        this.params.add(new HttpHeaderParameter(key, value != null ?
                String.valueOf(value)
                :
                null));

        return this;
    }

    /**
     * Adds Http Header parameter
     * 
     * @param key
     *            the key of the url param
     * 
     * @return HttpHeaderBuilder
     */
    public HttpHeaderBuilder add(String key) {
        this.params.add(new HttpHeaderParameter(key, null));
        return this;
    }

    /**
     * Builds Http Headers according to defined params
     * 
     * @return List of {@link Header}
     */
    public List<Header> build() {
        List<Header> headers = new ArrayList<Header>();
        for (HttpHeaderParameter param : this.params) {
            headers.add(new BasicHeader(param.getKey(), param.getValue()));
        }
        return headers;
    }

    /**
     * Http Header parameter decorator
     */
    private static class HttpHeaderParameter extends KeyValuePair {

        /**
         * @param key
         *            URL parameter key
         * @param value
         *            URL parameter value
         */
        public HttpHeaderParameter(String key, String value) {
            super();
            this.setKey(key);
            this.setValue(value);
        }
    }
}
