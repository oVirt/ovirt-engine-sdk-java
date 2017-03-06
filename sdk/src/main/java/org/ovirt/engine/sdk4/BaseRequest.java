/*
Copyright (c) 2017 Red Hat, Inc.

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

package org.ovirt.engine.sdk4;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseRequest<REQUEST extends Request, RESPONSE extends Response>
    implements Request<REQUEST, RESPONSE> {

    protected Map<String, String> headers;
    protected Map<String, String> query;

    @Override
    public REQUEST header(String name, String value) {
        if (headers == null) {
            headers = new HashMap<>();
        }

        headers.put(name, value);
        return (REQUEST) this;
    }

    @Override
    public REQUEST query(String name, String value) {
        if (query == null) {
            query = new HashMap<>();
        }

        query.put(name, value);
        return (REQUEST) this;
    }
}
