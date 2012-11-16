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

/**
 * Holds root-collections
 */
public class RootCollectionHolder extends AbstractCollectionHolder {

    private String decoratorCollectionName;
    private String publicEntityName;
    private String publicCollectionName;
    private String decoratorEntityName;
    private CollectionTemplate collectionTemplate;

    /**
     * @param decoratorCollectionName
     * @param publicEntityName
     * @param publicCollectionName
     * @param decoratorEntityName
     * @param collectionTemplate
     */
    public RootCollectionHolder(String decoratorCollectionName,
            String publicEntityName,
            String publicCollectionName,
            String decoratorEntityName,
            CollectionTemplate collectionTemplate) {
        this.decoratorCollectionName = decoratorCollectionName;
        this.publicEntityName = publicEntityName;
        this.publicCollectionName = publicCollectionName;
        this.decoratorEntityName = decoratorEntityName;
        this.collectionTemplate = collectionTemplate;
    }

    /**
     * Produces this holder content
     */
    @Override
    public String toString() {
        return collectionTemplate.getTemplate(
                decoratorCollectionName,
                publicEntityName,
                publicCollectionName,
                decoratorEntityName,
                getMethods());
    }
}
