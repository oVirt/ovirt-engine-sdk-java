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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBException;

import org.apache.http.client.ClientProtocolException;
import org.ovirt.engine.sdk.codegen.common.AbstractCodegen;
import org.ovirt.engine.sdk.codegen.holders.CollectionHolder;
import org.ovirt.engine.sdk.codegen.holders.ResourceHolder;
import org.ovirt.engine.sdk.codegen.templates.CollectionGetterTemplate;
import org.ovirt.engine.sdk.codegen.templates.CollectionTemplate;
import org.ovirt.engine.sdk.codegen.templates.SubCollectionGetterTemplate;
import org.ovirt.engine.sdk.codegen.templates.ResourceTemplate;
import org.ovirt.engine.sdk.codegen.templates.SubCollectionTemplate;
import org.ovirt.engine.sdk.codegen.templates.SubResourceTemplate;
import org.ovirt.engine.sdk.codegen.templates.VariableTemplate;
import org.ovirt.engine.sdk.codegen.utils.OsUtil;
import org.ovirt.engine.sdk.codegen.utils.ReflectionHelper;
import org.ovirt.engine.sdk.entities.DetailedLink;
import org.ovirt.engine.sdk.entities.GlusterBrick;
import org.ovirt.engine.sdk.entities.GlusterBricks;
import org.ovirt.engine.sdk.entities.HostNIC;
import org.ovirt.engine.sdk.entities.HostNics;
import org.ovirt.engine.sdk.entities.HttpMethod;
import org.ovirt.engine.sdk.entities.RSDL;
import org.ovirt.engine.sdk.exceptions.ServerException;
import org.ovirt.engine.sdk.utils.ArrayUtils;
import org.ovirt.engine.sdk.utils.StringUtils;
import org.ovirt.engine.sdk.web.HttpProxyBroker;

/**
 * Provides RSDL related codegen capabilities
 */
public class RsdlCodegen extends AbstractCodegen {

    private HttpProxyBroker httpProxy;
    private Map<String, Class<?>> entitiesMap;

    private CollectionTemplate collectionTemplate;
    private ResourceTemplate resourceTemplate;
    private SubCollectionTemplate subCollectionTemplate;
    private SubResourceTemplate subResourceTemplate;

    private VariableTemplate variableTemplate;
    private SubCollectionGetterTemplate subCollectionGetterTemplate;
    private CollectionGetterTemplate collectionGetterTemplate;

    private Map<String, CollectionHolder> collectionsHolder;
    private Map<String, ResourceHolder> resourcesHolder;

    private static final String RSDL_URL = "?rsdl";
    private static final String NX_DECORATORS_PATH =
            "../java-sdk/src/main/java/org/ovirt/engine/sdk/decorators/";
    private static final String WINDOWS_DECORATORS_PATH =
            "..\\java-sdk\\src\\main\\java\\org\\ovirt\\engine\\sdk\\decorators\\";
    private static final String SLASH = "/";
    private static final String ROOT_URL = "/api/";
    private static final String ENTITIES_PACKAGE = "org.ovirt.engine.sdk.entities";
    private static final String[] COLLECTION2ENTITY_EXCEPTIONS = new String[] { "capabilities", "storage",
            "versioncaps" };
    private static final String[] RETURN_BODY_EXCEPTIONS = new String[] { "Response", "Responses" };

    public RsdlCodegen(HttpProxyBroker httpProxy) {
        super(getDecoratorsPath());

        this.httpProxy = httpProxy;

        this.collectionTemplate = new CollectionTemplate();
        this.resourceTemplate = new ResourceTemplate();
        this.subCollectionTemplate = new SubCollectionTemplate();
        this.subResourceTemplate = new SubResourceTemplate();
        this.entitiesMap = getEntitiesMap();

        this.variableTemplate = new VariableTemplate();
        this.subCollectionGetterTemplate = new SubCollectionGetterTemplate();
        this.collectionGetterTemplate = new CollectionGetterTemplate();

        this.collectionsHolder = new HashMap<String, CollectionHolder>();
        this.resourcesHolder = new HashMap<String, ResourceHolder>();
    }

    /**
     * Maps entity to clazz.SimpleName
     * 
     * @return EntitiesMap
     */
    private Map<String, Class<?>> getEntitiesMap() {
        List<Class<?>> classes = new ArrayList<Class<?>>();
        Map<String, Class<?>> map = new HashMap<String, Class<?>>();
        try {
            classes = ReflectionHelper.getClasses(ENTITIES_PACKAGE);
        } catch (ClassNotFoundException e) {
            // TODO: Log error
            e.printStackTrace();
        } catch (IOException e) {
            // TODO: Log error
            e.printStackTrace();
        }

        for (Class<?> clazz : classes) {
            map.put(clazz.getSimpleName().toLowerCase(), clazz);
        }

        return addExceptions(map);
    }

    /**
     * Injects naming convention exceptions
     * 
     * @param map
     *            map to inject to
     * 
     * @return updated map
     */
    private Map<String, Class<?>> addExceptions(Map<String, Class<?>> map) {
        // TODO: Fix this on server side

        map.put("brick", GlusterBrick.class);
        map.put("bricks", GlusterBricks.class);
        map.put("hostnic", HostNIC.class);
        map.put("hostnics", HostNics.class);

        return map;
    }

    /**
     * Generates the brokers classes
     * 
     * @param distPath
     *            directory to generates the code at
     * 
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws IOException
     * @throws JAXBException
     */
    @Override
    protected void doGenerate(String distPath) throws ClientProtocolException,
            ServerException, IOException, JAXBException {

        String url, rel, requestBodyType, responseBodyType, parent, collectionName, actualReturnType;
        HttpMethod requestMethod;

        // #1 - fetch RSDL
        RSDL rsdl = fetchRsdl();

        // #2 - walk RSDL
        if (rsdl != null) {
            for (DetailedLink dl : rsdl.getLinks().getLinks()) {

                url = dl.getHref().replace(ROOT_URL, "");
                rel = dl.getRel();
                requestBodyType = dl.getRequest().getBody().getType();
                requestMethod = dl.getRequest().getHttpMethod();
                if (dl.getResponse() != null) {
                    responseBodyType = dl.getResponse().getType();
                } else {
                    responseBodyType = null;
                }

                String[] periods = url.split(SLASH);
                parent = "";
                collectionName = "";

                int i = 1;
                for (String period : periods) {
                    actualReturnType = getActualReturnType(responseBodyType, period);

                    if (!ArrayUtils.contains(COLLECTION2ENTITY_EXCEPTIONS, period)) {
                        if (i == 1) { // root-collection
                            String collection = getRootCollectionName(period);
                            collectionName = collection;
                            parent = StringUtils.toUpperCase(StringUtils.toSingular(collection));
                            String decoratorCollectionName = StringUtils.toUpperCase(collection);

                            if (!this.collectionsHolder.containsKey(decoratorCollectionName.toLowerCase())) {
                                String publicEntityName = getPublicEntity(StringUtils.toSingular(collection));
                                String publicCollectionName = getPublicCollection(collection);
                                String decoratorEntityName = StringUtils.toSingular(decoratorCollectionName);

                                this.collectionsHolder.put(decoratorCollectionName.toLowerCase(),
                                                            new CollectionHolder(
                                                                    decoratorCollectionName,
                                                                    publicEntityName,
                                                                    publicCollectionName,
                                                                    decoratorEntityName,
                                                                    StringUtils.toPlural(period),
                                                                    collectionTemplate));
                            }
                        } else if (i == 2) { // root-resource
                            String resource = getRootResourceName(collectionName);
                            if (!this.resourcesHolder.containsKey(resource.toLowerCase())) {
                                String decoratorResourceName = StringUtils.toUpperCase(resource);
                                String publicEntityName = getPublicEntity(StringUtils.toSingular(collectionName));

                                this.resourcesHolder.put(resource.toLowerCase(),
                                                            new ResourceHolder(
                                                                    decoratorResourceName,
                                                                    publicEntityName,
                                                                    resourceTemplate,
                                                                    variableTemplate,
                                                                    subCollectionGetterTemplate));
                            }
                        } else if (i % 2 != 0) { // sub-collection
                            String collection = getSubCollectionName(actualReturnType, parent);
                            collectionName = collection;
                            ResourceHolder resourceHolder = this.resourcesHolder.get(parent.toLowerCase());

                            if (!resourceHolder.getSubcollections().containsKey(collection.toLowerCase())
                                    && !isAction(period, rel, requestMethod)) {

                                String decoratorSubCollectionName = collection;
                                String publicEntityName =
                                        getPublicEntity(StringUtils.toSingular(StringUtils.toPlural(actualReturnType)));
                                String publicCollectionName =
                                        getPublicCollection(StringUtils.toPlural(actualReturnType));
                                String parentDecoratorName = parent;
                                String decoratorEntityName = StringUtils.toSingular(collection);

                                resourceHolder.addSubCollection(collection.toLowerCase(),
                                        new CollectionHolder(decoratorSubCollectionName,
                                                                publicEntityName,
                                                                publicCollectionName,
                                                                parentDecoratorName,
                                                                decoratorEntityName,
                                                                StringUtils.toPlural(period),
                                                                subCollectionTemplate));
                            }
                        } else { // sub-resource
                            String resource = getSubResourceName(collectionName, parent);
                            if (!this.resourcesHolder.containsKey(resource.toLowerCase())) {
                                String subResourceDecoratorName = resource;
                                String publicEntityName =
                                        getPublicEntity(StringUtils.toSingular(collectionName.replace(parent, "")));

                                this.resourcesHolder.put(resource.toLowerCase(),
                                        new ResourceHolder(subResourceDecoratorName,
                                                publicEntityName,
                                                subResourceTemplate,
                                                variableTemplate,
                                                subCollectionGetterTemplate));
                            }
                        }
                    } else {
                        // TODO: implement unique treatment for COLLECTION2ENTITY_EXCEPTIONS
                        break;
                    }
                    i++;
                }
            }
        } else {
            throw new RuntimeException("RSDL download failed.");
        }

        // #3 - Persist content
        persistContent(distPath);

        // #4 - generate SDK entry point
        new ApiCodegen(collectionsHolder, variableTemplate, collectionGetterTemplate).generate();
    }

    /**
     * @param collectionName
     * @param parent
     * 
     * @return sub-resource name
     */
    private String getSubResourceName(String collectionName, String parent) {
        String resource = StringUtils.toSingular(collectionName);
        String resourceCandidate =
                getPublicEntity(StringUtils.toSingular(collectionName.replace(parent, "")
                        .toLowerCase()), false);
        if (resourceCandidate != null) {
            resource = parent + resourceCandidate;
        }
        return resource;
    }

    /**
     * @param actualReturnType
     * @param parent
     * 
     * @return sub-collection name
     */
    private String getSubCollectionName(String actualReturnType, String parent) {
        String collection = StringUtils.toPlural(StringUtils.toUpperCase(actualReturnType));
        if (!actualReturnType.toLowerCase().startsWith(parent.toLowerCase())) {
            collection = StringUtils.toPlural(parent
                         +
                         StringUtils.toUpperCase(actualReturnType));
        }
        return collection;
    }

    /**
     * @param collectionName
     *            collection name
     * 
     * @return root-resource name
     */
    private String getRootResourceName(String collectionName) {
        String resource = StringUtils.toSingular(collectionName);
        String resourceCandidate = getPublicEntity(StringUtils.toSingular(collectionName), false);
        if (resourceCandidate != null) {
            resource = resourceCandidate;
        }
        return resource;
    }

    /**
     * @param period
     *            url period
     * 
     * @return root-collection name
     */
    private String getRootCollectionName(String period) {
        String collection = StringUtils.toUpperCase(StringUtils.toPlural(period));
        String collectionCandidate = getPublicCollection(StringUtils.toPlural(period), false);
        if (collectionCandidate != null) {
            collection = collectionCandidate;
        }
        return collection;
    }

    /**
     * Checks if given context is an actio
     * 
     * @param period
     * @param rel
     * @param requestMethod
     * 
     * @return true/false
     */
    private boolean isAction(String period, String rel, HttpMethod requestMethod) {
        return period.equals(rel) && requestMethod == HttpMethod.POST;
    }

    /**
     * Retrieves actual return type
     * 
     * @param responseBodyType
     * @param period
     * @return
     */
    private String getActualReturnType(String responseBodyType, String period) {
        String actualReturnType;
        if (responseBodyType == null || ArrayUtils.contains(RETURN_BODY_EXCEPTIONS, responseBodyType)) {
            String collectionCandidate = getPublicCollection(period.toLowerCase(), false);
            if (collectionCandidate != null) {
                actualReturnType = collectionCandidate;
            } else {
                actualReturnType = period;
            }
        } else {
            actualReturnType = responseBodyType;
        }

        return actualReturnType;
    }

    /**
     * Persist holders content
     * 
     * @param distPath
     *            directory to write the files to
     */
    private void persistContent(String distPath) {
        for (CollectionHolder collection : this.collectionsHolder.values()) {
            persistClass(collection.getName(), collection.produce(), distPath);
        }
        for (ResourceHolder resource : this.resourcesHolder.values()) {
            persistClass(resource.getName(), resource.produce(), distPath);
            for (CollectionHolder subCollection : resource.getSubcollections().values()) {
                persistClass(subCollection.getName(), subCollection.produce(), distPath);
            }
        }
    }

    /**
     * @param collectionName
     * 
     * @return public entity name according to class-simple-name
     */
    private String getPublicCollection(String collectionName) {
        if (this.entitiesMap.containsKey(collectionName.toLowerCase())) {
            return this.entitiesMap.get(collectionName.toLowerCase()).getSimpleName();
        }
        return null;
    }

    /**
     * @param collectionName
     * @param throwError
     * 
     * @return public entity name according to class-simple-name
     */
    private String getPublicCollection(String collectionName, boolean throwError) {
        try {
            return getPublicCollection(collectionName);
        } catch (RuntimeException rte) {
            if (!throwError)
                return null;
            throw rte;
        }
    }

    /**
     * @param entityName
     * 
     * @return public collection name according to class-simple-name
     */
    private String getPublicEntity(String entityName) {
        if (this.entitiesMap.containsKey(entityName.toLowerCase())) {
            return this.entitiesMap.get(entityName.toLowerCase()).getSimpleName();
        }
        throw new RuntimeException("Public entity \"" + entityName + "\" fetch has failed.");
    }

    /**
     * @param entityName
     * @param throwError
     * 
     * @return public collection name according to class-simple-name
     */
    private String getPublicEntity(String entityName, boolean throwError) {
        try {
            return getPublicEntity(entityName);
        } catch (RuntimeException rte) {
            if (!throwError)
                return null;
            throw rte;
        }
    }

    /**
     * @return Decorators path according to OS
     */
    private static String getDecoratorsPath() {
        if (OsUtil.isWindows()) {
            return WINDOWS_DECORATORS_PATH;
        } else if (OsUtil.isMac() || OsUtil.isUnix() || OsUtil.isSolaris()) {
            return NX_DECORATORS_PATH;
        } else {
            throw new RuntimeException("unsupported OS.");
        }
    }

    /**
     * Fetches RSDL descriptor
     * 
     * @return RSDL
     * 
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws IOException
     * @throws JAXBException
     */
    private RSDL fetchRsdl() throws ClientProtocolException, ServerException, IOException, JAXBException {
        return httpProxy.get(RSDL_URL, RSDL.class);
    }
}
