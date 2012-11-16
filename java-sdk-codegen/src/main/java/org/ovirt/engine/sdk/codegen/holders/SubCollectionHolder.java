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

import org.ovirt.engine.sdk.codegen.templates.SubCollectionTemplate;

/**
 * Holds sub-collections
 */
public class SubCollectionHolder extends AbstractCollectionHolder {

    private SubCollectionTemplate subCollectionTemplate;
    private String decoratorSubCollectionName;
    private String publicEntityName;
    private String publicCollectionName;
    private String parentDecoratorName;
    private String decoratorEntityName;

    /**
     * @param decoratorSubCollectionName
     * @param publicEntityName
     * @param publicCollectionName
     * @param parentDecoratorName
     * @param decoratorEntityName
     * @param subCollectionTemplate
     */
    public SubCollectionHolder(
            String decoratorSubCollectionName,
            String publicEntityName,
            String publicCollectionName,
            String parentDecoratorName,
            String decoratorEntityName,
            SubCollectionTemplate subCollectionTemplate) {
        this.subCollectionTemplate = subCollectionTemplate;
        this.decoratorSubCollectionName = decoratorSubCollectionName;
        this.publicEntityName = publicEntityName;
        this.publicCollectionName = publicCollectionName;
        this.parentDecoratorName = parentDecoratorName;
        this.decoratorEntityName = decoratorEntityName;
    }

    /**
     * Produces this holder content
     */
    @Override
    public String toString() {
        return subCollectionTemplate.getTemplate(
                decoratorSubCollectionName,
                publicEntityName,
                publicCollectionName,
                parentDecoratorName,
                decoratorEntityName,
                getMethods());
    }
}
