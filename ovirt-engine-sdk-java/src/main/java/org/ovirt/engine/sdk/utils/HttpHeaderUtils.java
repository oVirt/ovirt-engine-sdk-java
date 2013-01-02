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
 * Provides HttpHeader related services
 */
public class HttpHeaderUtils {
    /**
     * Converts KeyValuePair/s to HttpHeaders
     * 
     * @param keyValuePairs
     *            KeyValuePair/s to convert
     * 
     * @return List<Header>
     */
    public static List<Header> toHeaders(KeyValuePair... keyValuePairs) {
        List<Header> headers = new ArrayList<Header>();

        for (KeyValuePair kv : keyValuePairs) {
            headers.add(new BasicHeader(kv.getKey(), kv.getValue()));
        }

        return headers;
    }

    /**
     * Converts string pairs to HttpHeaders
     * 
     * pattern is k1:v1,k2:v2, ...,kN:vN, ...
     * 
     * @param keyValuePairs
     * @return
     */
    public static List<Header> toHeaders(String... keyValuePairs) {
        List<Header> headers = new ArrayList<Header>();

        for (int i = 0; i < keyValuePairs.length; i++) {
            String[] kv = keyValuePairs[i].split(":");
            if (kv.length == 2) {
                headers.add(new BasicHeader(kv[0], kv[1]));
            }
        }

        return headers;
    }
}
