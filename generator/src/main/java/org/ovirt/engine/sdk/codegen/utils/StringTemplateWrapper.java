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

package org.ovirt.engine.sdk.codegen.utils;

/**
 * Provides string templating capabilities
 */
public class StringTemplateWrapper {

    private String content;
    private String KEY_WRAP = "$";

    /**
     * @param content
     *            template content
     */
    public StringTemplateWrapper(String content) {
        this.content = content;
    }

    /**
     * @param content
     *            template content
     * @param keyWrapper
     *            key wrapping string
     */
    public StringTemplateWrapper(String content, String keyWrapper) {
        this.content = content;
        this.KEY_WRAP = keyWrapper;
    }

    /**
     * Converts StringTemplate to String
     */
    @Override
    public String toString() {
        return this.content;
    }

    /**
     * Updates template key with value
     * 
     * @param key
     * @param value
     */
    public void set(String key, String value) {
        this.content = this.content.replace(toKey(key), value);
    }

    private String toKey(String key) {
        return this.KEY_WRAP + key + this.KEY_WRAP;
    }
}
