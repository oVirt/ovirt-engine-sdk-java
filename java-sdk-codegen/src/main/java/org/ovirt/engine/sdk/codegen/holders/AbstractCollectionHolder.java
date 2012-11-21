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

package org.ovirt.engine.sdk.codegen.holders;

import java.util.HashMap;
import java.util.Map;

import org.ovirt.engine.sdk.codegen.templates.CollectionTemplate;
import org.ovirt.engine.sdk.codegen.templates.SubCollectionTemplate;

/**
 * Holds collections
 */
public abstract class AbstractCollectionHolder implements IHolder {

    private Map<String, String> methods;

    private SubCollectionTemplate subCollectionTemplate;
    private CollectionTemplate collectionTemplate;

    private String decoratorCollectionName;
    private String publicEntityName;
    private String publicCollectionName;
    private String decoratorEntityName;
    private String url;

    private String parentDecoratorName;

    /**
     * Resource
     */
    public AbstractCollectionHolder() {
        this.methods = new HashMap<String, String>();
    }

    /**
     * Sub-Collection
     * 
     * @param decoratorSubCollectionName
     * @param publicEntityName
     * @param publicCollectionName
     * @param parentDecoratorName
     * @param decoratorEntityName
     * @param url
     * @param subCollectionTemplate
     */
    public AbstractCollectionHolder(
            String decoratorSubCollectionName,
            String publicEntityName,
            String publicCollectionName,
            String parentDecoratorName,
            String decoratorEntityName,
            String url,
            SubCollectionTemplate subCollectionTemplate) {

        this.methods = new HashMap<String, String>();

        this.subCollectionTemplate = subCollectionTemplate;
        this.decoratorCollectionName = decoratorSubCollectionName;
        this.publicEntityName = publicEntityName;
        this.publicCollectionName = publicCollectionName;
        this.parentDecoratorName = parentDecoratorName;
        this.decoratorEntityName = decoratorEntityName;
        this.url = url;
    }

    /**
     * Root-Collection
     * 
     * @param decoratorSubCollectionName
     * @param publicEntityName
     * @param publicCollectionName
     * @param parentDecoratorName
     * @param decoratorEntityName
     * @param collectionTemplate
     */
    public AbstractCollectionHolder(
            String decoratorSubCollectionName,
            String publicEntityName,
            String publicCollectionName,
            String decoratorEntityName,
            String url,
            CollectionTemplate collectionTemplate) {

        this.methods = new HashMap<String, String>();

        this.collectionTemplate = collectionTemplate;
        this.decoratorCollectionName = decoratorSubCollectionName;
        this.publicEntityName = publicEntityName;
        this.publicCollectionName = publicCollectionName;
        this.decoratorEntityName = decoratorEntityName;
        this.url = url;
    }

    /**
     * @return methods string
     */
    protected String getMethods() {
        String methods = "";
        for (String key : this.methods.keySet()) {
            methods += this.methods.get(key);
        }
        return methods;
    }

    /**
     * Adds method string
     * 
     * @param name
     *            method name
     * @param content
     *            method content
     */
    public void addMethod(String name, String content) {
        this.methods.put(name, content);
    }

    /**
     * Produces this holder content
     */
    public String produce() {
        return toString();
    }

    @Override
    public String toString() {
        if (this.parentDecoratorName == null) {
            return collectionTemplate.getTemplate(
                    decoratorCollectionName,
                    publicEntityName,
                    publicCollectionName,
                    decoratorEntityName,
                    getMethods(),
                    url);
        }
        return subCollectionTemplate.getTemplate(
                decoratorCollectionName,
                publicEntityName,
                publicCollectionName,
                parentDecoratorName,
                decoratorEntityName,
                getMethods(),
                url);
    }

    /**
     * @return Collection name
     */
    public String getName() {
        return this.decoratorCollectionName;
    }
}
