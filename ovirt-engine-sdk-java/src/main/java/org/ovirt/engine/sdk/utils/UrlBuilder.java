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

import org.ovirt.engine.sdk.entities.KeyValuePair;
import org.ovirt.engine.sdk.web.UrlParameterType;

/**
 * Providing URL building services
 */
public class UrlBuilder {

    private String url;
    private List<UrlParameter> params;

    /**
     * Providing URL building services
     * 
     * @param url
     *            url string
     */
    public UrlBuilder(String url) {
        this.url = url;
        this.params = new ArrayList<UrlParameter>();
    }

    /**
     * Adds URL parameter
     * 
     * @param key
     *            the key of the url param
     * @param value
     *            the value of the url param
     * @param type
     *            url parameter type
     * 
     * @return UrlBuilder
     */
    public UrlBuilder add(String key, Object value, UrlParameterType type) {
        this.params.add(new UrlParameter(key, value != null ? String.valueOf(value) : null, type));
        return this;
    }

    /**
     * Adds URL parameter
     * 
     * @param key
     *            the key of the url param
     * @param type
     *            url parameter type
     * 
     * @return UrlBuilder
     */
    public UrlBuilder add(String key, UrlParameterType type) {
        this.params.add(new UrlParameter(key, null, type));
        return this;
    }

    /**
     * Builds URL according to defined params
     * 
     * @return encoded url
     */
    public String build() {
        StringBuffer matrixParams = new StringBuffer();
        StringBuffer queryParams = new StringBuffer();
        for (UrlParameter urlParam : this.params) {
            if (urlParam.getValue() != null) {
                switch (urlParam.getType()) {
                case MATRIX:
                    matrixParams.append(";" + urlParam.getKey() + "=" + urlParam.getValue());
                    break;
                case QUERY:
                    queryParams.append("?" + urlParam.getKey() + "=" + UrlHelper.encode(urlParam.getValue()));
                    break;
                }
            }
        }
        return url + matrixParams.toString() + queryParams.toString();
    }

    /**
     * URL parameter decorator
     */
    private static class UrlParameter extends KeyValuePair {
        private UrlParameterType type;

        /**
         * @param key
         *            URL parameter key
         * @param value
         *            URL parameter value
         * @param type
         *            URL parameter type
         */
        public UrlParameter(String key, String value, UrlParameterType type) {
            super();
            this.setKey(key);
            this.setValue(value);
            this.setType(type);
        }

        /**
         * @param type
         *            URL parameter type
         */
        private void setType(UrlParameterType type) {
            this.type = type;
        }

        /**
         * @return URL parameter type
         */
        public UrlParameterType getType() {
            return type;
        }
    }
}
