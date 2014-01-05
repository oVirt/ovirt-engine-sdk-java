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

package org.ovirt.engine.sdk.codegen.rsdl;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

import javax.xml.bind.JAXBException;

import org.ovirt.engine.sdk.codegen.common.AbstractCodegen;
import org.ovirt.engine.sdk.codegen.holders.CollectionHolder;
import org.ovirt.engine.sdk.codegen.templates.ApiTemplate;
import org.ovirt.engine.sdk.codegen.templates.CollectionGetterTemplate;
import org.ovirt.engine.sdk.codegen.templates.RootResourceDynamicTemplate;
import org.ovirt.engine.sdk.codegen.templates.RootResourceStaticTemplate;
import org.ovirt.engine.sdk.codegen.templates.VariableTemplate;
import org.ovirt.engine.sdk.codegen.utils.OsUtil;
import org.ovirt.engine.sdk.entities.API;
import org.ovirt.engine.sdk.utils.ArrayUtils;
import org.ovirt.engine.sdk.utils.StringUtils;

/**
 * Provides SDK entry point codegen capabilities
 */
public class ApiCodegen extends AbstractCodegen {

    private static final String NX_API_PATH =
            "../ovirt-engine-sdk-java/src/main/java/org/ovirt/engine/sdk/";
    private static final String WINDOWS_API_PATH =
            "..\\ovirt-engine-sdk-java\\src\\main\\java\\org\\ovirt\\engine\\sdk\\";
    private static final String EP_NAME = "Api";

    private ApiTemplate apiTemplate;
    private Map<String, CollectionHolder> collectionsHolder;

    private VariableTemplate variableTemplate;
    private CollectionGetterTemplate collectionGetterTemplate;

    private RootResourceStaticTemplate rootResourceStaticTemplate;
    private RootResourceDynamicTemplate rootResourceDynamicTemplate;

    /**
     * @param collectionsHolder
     * @param variableTemplate
     * @param collectionGetterTemplate
     */
    public ApiCodegen(Map<String, CollectionHolder> collectionsHolder,
            VariableTemplate variableTemplate,
            CollectionGetterTemplate collectionGetterTemplate) {
        super(getApiPath());
        this.apiTemplate = new ApiTemplate();
        this.rootResourceStaticTemplate = new RootResourceStaticTemplate();
        this.rootResourceDynamicTemplate = new RootResourceDynamicTemplate();

        this.collectionsHolder = collectionsHolder;
        this.variableTemplate = variableTemplate;
        this.collectionGetterTemplate = collectionGetterTemplate;
    }

    /**
     * @return Path to generate SDK entry point at
     */
    private static String getApiPath() {
        if (OsUtil.isWindows()) {
            return WINDOWS_API_PATH;
        } else if (OsUtil.isMac() || OsUtil.isUnix() || OsUtil.isSolaris()) {
            return NX_API_PATH;
        } else {
            throw new RuntimeException("unsupported OS.");
        }
    }

    /**
     * Generates SDK entry point class
     */
    @Override
    protected void doGenerate(String distPath) throws IOException, JAXBException {
        String collectionsVariables = produceCollectionVariables();
        String collectionsGetters = produceCollectionGetters();
        String rootMethods = produceRootMethods();

        persistClass(EP_NAME,
                this.apiTemplate.getTemplate(collectionsVariables,
                        collectionsGetters,
                        rootMethods),
                distPath);

    }

    /**
     * @return /api resource methods
     * 
     * @throws IOException
     */
    private String produceRootMethods() throws IOException {
        String rootMethods = "";

        String[] exceptions =
                new String[] { "Actions", "Href", "Links", "ExtensionType",
                        "CreationStatus", "Id", "Name", "Description", "Class" };

        String[] staticMethods =
                new String[] { "SpecialObjects", "ProductInfo" };

        for (Method method : API.class.getMethods()) {
            String simpleMethodName = method.getName().replace("get", "");
            if (method.getName().startsWith("get")
                    && !ArrayUtils.contains(exceptions, simpleMethodName)) {
                if (ArrayUtils.contains(staticMethods, simpleMethodName)) { // static methods
                    rootMethods +=
                            this.rootResourceStaticTemplate.getTemplate(method.getName(), method.getReturnType()
                                    .getSimpleName(), method.getReturnType().getPackage().getName(), simpleMethodName);
                } else { // dynamic methods
                    rootMethods +=
                            this.rootResourceDynamicTemplate.getTemplate(method.getName(), method.getReturnType()
                                    .getSimpleName(), method.getReturnType().getPackage().getName(), simpleMethodName);
                }
            }
        }
        return rootMethods;
    }

    /**
     * @return root-collection/s getter/s
     */
    private String produceCollectionGetters() {
        StringBuffer subCollectionGetters = new StringBuffer();

        for (CollectionHolder ch : this.collectionsHolder.values()) {
            subCollectionGetters.append(
                    this.collectionGetterTemplate.getTemplate(ch.getName(),
                            StringUtils.toLowerCase(ch.getName()),
                            ch.getPublicCollectionName()));
        }

        return subCollectionGetters.toString();
    }

    /**
     * @return root-collection/s variable/s
     */
    private String produceCollectionVariables() {
        StringBuffer subCollectionVariables = new StringBuffer();

        for (CollectionHolder ch : this.collectionsHolder.values()) {
            subCollectionVariables.append(
                    this.variableTemplate.getTemplate(ch.getName(),
                            StringUtils.toLowerCase(ch.getName())));
        }

        return subCollectionVariables.toString();
    }

    /**
     * Cleans destionation path
     */
    @Override
    protected void doCleanPackage(String dir) {
        ;
        // Do not clean /sdk package
    }
}
