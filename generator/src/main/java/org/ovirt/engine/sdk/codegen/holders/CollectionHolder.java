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

import org.ovirt.engine.sdk.codegen.templates.CollectionTemplate;
import org.ovirt.engine.sdk.codegen.templates.SubCollectionTemplate;

/**
 * Holds sub-collections
 */
public class CollectionHolder extends AbstractCollectionHolder {

    private String publicCollectionName;

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
    public CollectionHolder(
            String decoratorSubCollectionName,
            String publicEntityName,
            String publicCollectionName,
            String parentDecoratorName,
            String decoratorEntityName,
            String url,
            SubCollectionTemplate subCollectionTemplate) {
        super(decoratorSubCollectionName,
                publicEntityName,
                publicCollectionName,
                parentDecoratorName,
                decoratorEntityName,
                url,
                subCollectionTemplate);
        this.publicCollectionName = publicCollectionName;
    }

    /**
     * Root-Collection
     * 
     * @param decoratorSubCollectionName
     * @param publicEntityName
     * @param publicCollectionName
     * @param parentDecoratorName
     * @param decoratorEntityName
     * @param url
     * @param collectionTemplate
     */
    public CollectionHolder(
            String decoratorSubCollectionName,
            String publicEntityName,
            String publicCollectionName,
            String decoratorEntityName,
            String url,
            CollectionTemplate collectionTemplate) {
        super(decoratorSubCollectionName,
                publicEntityName,
                publicCollectionName,
                decoratorEntityName,
                url,
                collectionTemplate);
        this.publicCollectionName = publicCollectionName;
    }

    /**
     * @return PublicCollectionName
     */
    public String getPublicCollectionName() {
        return publicCollectionName;
    }
}
