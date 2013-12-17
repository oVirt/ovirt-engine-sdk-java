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
import org.ovirt.engine.sdk.codegen.documentation.DocsGen;
import org.ovirt.engine.sdk.codegen.holders.CollectionHolder;
import org.ovirt.engine.sdk.codegen.holders.ResourceHolder;
import org.ovirt.engine.sdk.codegen.templates.CollectionActionMethodTemplate;
import org.ovirt.engine.sdk.codegen.templates.CollectionAddMethodTemplate;
import org.ovirt.engine.sdk.codegen.templates.CollectionGetterTemplate;
import org.ovirt.engine.sdk.codegen.templates.CollectionListMethodTemplate;
import org.ovirt.engine.sdk.codegen.templates.CollectionTemplate;
import org.ovirt.engine.sdk.codegen.templates.DeleteMethodTemplate;
import org.ovirt.engine.sdk.codegen.templates.ResourceActionMethodTemplate;
import org.ovirt.engine.sdk.codegen.templates.SubCollectionAddMethodTemplate;
import org.ovirt.engine.sdk.codegen.templates.SubCollectionGetterTemplate;
import org.ovirt.engine.sdk.codegen.templates.ResourceTemplate;
import org.ovirt.engine.sdk.codegen.templates.SubCollectionListMethodTemplate;
import org.ovirt.engine.sdk.codegen.templates.SubCollectionTemplate;
import org.ovirt.engine.sdk.codegen.templates.SubResourceTemplate;
import org.ovirt.engine.sdk.codegen.templates.UpdateMethodTemplate;
import org.ovirt.engine.sdk.codegen.templates.VariableTemplate;
import org.ovirt.engine.sdk.codegen.utils.OsUtil;
import org.ovirt.engine.sdk.codegen.utils.ReflectionHelper;
import org.ovirt.engine.sdk.codegen.xsd.XsdCodegen;
import org.ovirt.engine.sdk.entities.Capabilities;
import org.ovirt.engine.sdk.entities.DetailedLink;
import org.ovirt.engine.sdk.entities.GlusterBrick;
import org.ovirt.engine.sdk.entities.GlusterBricks;
import org.ovirt.engine.sdk.entities.HostNIC;
import org.ovirt.engine.sdk.entities.HostNics;
import org.ovirt.engine.sdk.entities.HttpMethod;
import org.ovirt.engine.sdk.entities.RSDL;
import org.ovirt.engine.sdk.entities.VersionCaps;
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
    private ResourceActionMethodTemplate resourceActionMethodTemplate;
    private CollectionActionMethodTemplate collectionActionMethodTemplate;
    private DeleteMethodTemplate deleteMethodTemplate;
    private UpdateMethodTemplate updateMethodTemplate;
    private CollectionAddMethodTemplate collectionAddMethodTemplate;
    private SubCollectionAddMethodTemplate subCollectionAddMethodTemplate;
    private CollectionListMethodTemplate collectionListMethodTemplate;
    private SubCollectionListMethodTemplate subCollectionListMethodTemplate;

    private Map<String, CollectionHolder> collectionsHolder;
    private Map<String, ResourceHolder> resourcesHolder;

    private static final String RSDL_URL = "?rsdl";
    private static final String NX_DECORATORS_PATH =
            "../ovirt-engine-sdk-java/src/main/java/org/ovirt/engine/sdk/decorators/";
    private static final String WINDOWS_DECORATORS_PATH =
            "..\\ovirt-engine-sdk-java\\src\\main\\java\\org\\ovirt\\engine\\sdk\\decorators\\";
    private static final String SLASH = "/";
    private static final String ROOT_URL = "/ovirt-engine/api/";
    private static final String ENTITIES_PACKAGE = "org.ovirt.engine.sdk.entities";
    private static final String DELETE_REL = "delete";
    private static final String UPDATE_REL = "update";
    private static final String ADD_REL = "add";
    private static final String GET_REL = "get";

    private static final String[] COLLECTION2ENTITY_EXCEPTIONS = new String[] {
            "capabilities",
            "{capabilitie:id}",
            "storage", "{storage:id}"
    };
    private static final String[] RETURN_BODY_EXCEPTIONS = new String[] { "Response", "Responses" };
    private static final String[] ACTION_NAME_EXCEPTIONS = new String[] { "import", "export" };

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
        this.resourceActionMethodTemplate = new ResourceActionMethodTemplate();
        this.collectionActionMethodTemplate = new CollectionActionMethodTemplate();
        this.deleteMethodTemplate = new DeleteMethodTemplate();
        this.updateMethodTemplate = new UpdateMethodTemplate();
        this.collectionAddMethodTemplate = new CollectionAddMethodTemplate();
        this.subCollectionAddMethodTemplate = new SubCollectionAddMethodTemplate();
        this.collectionListMethodTemplate = new CollectionListMethodTemplate();
        this.subCollectionListMethodTemplate = new SubCollectionListMethodTemplate();

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
        // FIXME: Fix this on server side or fond a way locating exceptions programatically

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
    @SuppressWarnings("unused")
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
                responseBodyType = getResponseBodyType(dl);

                String[] periods = url.split(SLASH);
                parent = "";
                collectionName = "";

                int i = 1;
                for (String period : periods) {
                    actualReturnType = getActualReturnType(responseBodyType, period, i, periods);

                    if (!ArrayUtils.contains(COLLECTION2ENTITY_EXCEPTIONS, period)) {
                        if (i == 1) { // root-collection
                            String collection = getRootCollectionName(period);
                            collectionName = collection;
                            parent = StringUtils.toUpperCase(StringUtils.toSingular(collection));
                            String decoratorCollectionName = StringUtils.toUpperCase(collection);
                            String publicEntityName = getPublicEntity(StringUtils.toSingular(collection));
                            String publicCollectionName = getPublicCollection(collection);
                            String decoratorEntityName = StringUtils.toSingular(decoratorCollectionName);

                            addRootCollection(url,
                                    rel,
                                    dl,
                                    i,
                                    period,
                                    decoratorCollectionName,
                                    publicEntityName,
                                    publicCollectionName,
                                    decoratorEntityName);

                        } else if (i == 2) { // root-resource
                            String resource = getRootResourceName(collectionName);
                            String decoratorResourceName = StringUtils.toUpperCase(resource);
                            String publicEntityName = getPublicEntity(StringUtils.toSingular(collectionName));

                            addRootResource(url,
                                    rel,
                                    dl,
                                    resource,
                                    decoratorResourceName,
                                    publicEntityName);

                        } else if (i % 2 != 0) { // sub-collection
                            String collection = getSubCollectionName(actualReturnType, parent, i, periods);
                            collectionName = collection;
                            ResourceHolder resourceHolder = this.resourcesHolder.get(parent.toLowerCase());
                            String decoratorEntityName = getSubResourceName(collectionName, parent);
                            String publicEntityName =
                                    getSubCollectionEntityName(rel, actualReturnType, requestMethod, periods, i, period);
                            String publicCollectionName =
                                    getPublicCollection(StringUtils.toPlural(actualReturnType));

                            addSubCollection(url,
                                    rel,
                                    parent,
                                    requestMethod,
                                    dl,
                                    periods,
                                    i,
                                    period,
                                    collection,
                                    resourceHolder,
                                    decoratorEntityName,
                                    publicEntityName,
                                    publicCollectionName);

                        } else { // sub-resource
                            if (!isAction(period, rel, requestMethod)) {
                                String resource = getSubResourceName(collectionName, parent);
                                String subResourceDecoratorName = resource;
                                String publicEntityName = getSubResourceEntityName(parent, collectionName);

                                addSubResource(url,
                                        rel,
                                        dl,
                                        resource,
                                        subResourceDecoratorName,
                                        publicEntityName);

                                parent = resource;
                            } else {
                                // TODO: use extra params (besides action) defined by RSDL
                                addResourceAction(rel, parent, collectionName, period, dl);
                            }
                        }
                    } else { // unique treatment for COLLECTION2ENTITY_EXCEPTIONS
                        if (period.equals("capabilities") || parent.equalsIgnoreCase("capabilities")) {
                            if (i == 1) { // root-collection
                                String collection = getRootCollectionName(period);
                                collectionName = collection;
                                parent = StringUtils.toUpperCase(collectionName);
                                String decoratorCollectionName = StringUtils.toUpperCase(collection);
                                String publicEntityName = getPublicEntity(VersionCaps.class.getSimpleName());
                                String publicCollectionName = getPublicCollection(Capabilities.class.getSimpleName());
                                String decoratorEntityName = VersionCaps.class.getSimpleName();

                                addRootCollection(url,
                                        rel,
                                        dl,
                                        i,
                                        period,
                                        decoratorCollectionName,
                                        publicEntityName,
                                        publicCollectionName,
                                        decoratorEntityName);

                            } else if (i == 2) { // root-resource
                                String resource = VersionCaps.class.getSimpleName();
                                String decoratorResourceName = resource;
                                String publicEntityName = getPublicEntity(resource);

                                addRootResource(url,
                                        rel,
                                        dl,
                                        resource,
                                        decoratorResourceName,
                                        publicEntityName);

                            }
                        } else {
                            // TODO: implement unique treatment for COLLECTION2ENTITY_EXCEPTIONS
                            break;
                        }
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

        // #5 - remove collection getters/setters from the public entities
        // (as they being shadowed by the decorators getters)
        XsdCodegen.modifyGetters(getPublicAccessors());
    }

    /**
     * Adds SubResource to the resourcesHolder
     * 
     * @param url
     * @param rel
     * @param dl
     *            DetailedLink
     * @param resource
     * @param subResourceDecoratorName
     * @param publicEntityName
     */
    private void addSubResource(String url,
            String rel,
            DetailedLink dl,
            String resource,
            String subResourceDecoratorName,
            String publicEntityName) {
        if (!this.resourcesHolder.containsKey(resource.toLowerCase())) {
            this.resourcesHolder.put(resource.toLowerCase(),
                    new ResourceHolder(subResourceDecoratorName,
                            publicEntityName,
                            subResourceTemplate,
                            variableTemplate,
                            subCollectionGetterTemplate));
        }
        addResourceMethod(this.resourcesHolder.get(resource.toLowerCase()), url, rel,
                subResourceDecoratorName, publicEntityName, dl);
    }

    /**
     * adds SubCollection to the resourceHolder
     * 
     * @param url
     * @param rel
     * @param parent
     * @param requestMethod
     * @param dl
     *            DetailedLink
     * @param periods
     * @param i
     *            the index offset in URI
     * @param period
     *            the URI period
     * @param collection
     * @param resourceHolder
     * @param decoratorEntityName
     * @param publicEntityName
     * @param publicCollectionName
     */
    private void addSubCollection(String url,
            String rel,
            String parent,
            HttpMethod requestMethod,
            DetailedLink dl,
            String[] periods,
            int i,
            String period,
            String collection,
            ResourceHolder resourceHolder,
            String decoratorEntityName,
            String publicEntityName,
            String publicCollectionName) {
        if (!isAction(period, rel, requestMethod)) {
            if (!resourceHolder.getSubcollections().containsKey(collection.toLowerCase())) {

                String decoratorSubCollectionName = collection;
                String parentDecoratorName = parent;
                resourceHolder.addSubCollection(collection.toLowerCase(),
                        new CollectionHolder(decoratorSubCollectionName,
                                publicEntityName,
                                publicCollectionName,
                                parentDecoratorName,
                                decoratorEntityName,
                                StringUtils.toPlural(period),
                                subCollectionTemplate));
            }
        } else {
            // TODO: use extra params (besides action) defined by RSDL
            addCollectionAction(rel, periods, i, period, resourceHolder, dl);
        }
        addCollectionMethod(resourceHolder.getSubcollections().get(collection.toLowerCase()),
                url, rel, decoratorEntityName, publicEntityName, publicCollectionName, i, dl);
    }

    /**
     * adds RootResource to the resourcesHolder
     * 
     * @param url
     * @param rel
     * @param dl
     *            DetailedLink
     * @param resource
     * @param decoratorResourceName
     * @param publicEntityName
     */
    private void addRootResource(String url,
            String rel,
            DetailedLink dl,
            String resource,
            String decoratorResourceName,
            String publicEntityName) {
        if (!this.resourcesHolder.containsKey(resource.toLowerCase())) {
            this.resourcesHolder.put(resource.toLowerCase(),
                    new ResourceHolder(
                            decoratorResourceName,
                            publicEntityName,
                            resourceTemplate,
                            variableTemplate,
                            subCollectionGetterTemplate));
        }
        addResourceMethod(this.resourcesHolder.get(resource.toLowerCase()),
                url, rel, decoratorResourceName, publicEntityName, dl);
    }

    /**
     * adds RootCollection to the collectionsHolder
     * 
     * @param url
     * @param rel
     * @param dl
     *            DetailedLink
     * @param i
     *            the index offset in URI
     * @param period
     *            the URI period
     * @param decoratorCollectionName
     * @param publicEntityName
     * @param publicCollectionName
     * @param decoratorEntityName
     */
    private void addRootCollection(String url,
            String rel,
            DetailedLink dl,
            int i,
            String period,
            String decoratorCollectionName,
            String publicEntityName,
            String publicCollectionName,
            String decoratorEntityName) {
        if (!this.collectionsHolder.containsKey(decoratorCollectionName.toLowerCase())) {
            this.collectionsHolder.put(decoratorCollectionName.toLowerCase(),
                    new CollectionHolder(
                            decoratorCollectionName,
                            publicEntityName,
                            publicCollectionName,
                            decoratorEntityName,
                            StringUtils.toPlural(period),
                            collectionTemplate));
        }
        addCollectionMethod(this.collectionsHolder.get(decoratorCollectionName.toLowerCase()),
                url, rel, decoratorEntityName, publicEntityName, publicCollectionName, i, dl);
    }

    /**
     * @return list of public collection names
     */
    private Map<String, List<String>> getPublicAccessors() {
        Map<String, List<String>> publicAccessors = new HashMap<String, List<String>>();
        for (CollectionHolder collection : this.collectionsHolder.values()) {
            if (!publicAccessors.containsKey("API")) {
                publicAccessors.put("API", new ArrayList<String>());
            }
            publicAccessors.get("API").add(collection.getPublicCollectionName());
        }
        for (ResourceHolder resource : this.resourcesHolder.values()) {
            if (!publicAccessors.containsKey(resource.getPublicEntityName())) {
                publicAccessors.put(resource.getPublicEntityName(), new ArrayList<String>());
            }
            for (CollectionHolder subCollection : resource.getSubcollections().values()) {
                publicAccessors.get(resource.getPublicEntityName())
                        .add(subCollection.getPublicCollectionName());
            }
        }
        return publicAccessors;
    }

    /**
     * Locates ResponseBodyType
     * 
     * @param dl
     *            Ditaled lonk to fetch from
     * @return
     */
    private String getResponseBodyType(DetailedLink dl) {
        String responseBodyType;
        if (dl.getResponse() != null) {
            responseBodyType = dl.getResponse().getType();
        } else {
            responseBodyType = null;
        }
        return responseBodyType;
    }

    /**
     * Locates SubCollectionEntityName
     * 
     * @param rel
     * @param actualReturnType
     * @param requestMethod
     * @param periods
     * @param i
     * @param period
     * @return
     */
    private String getSubCollectionEntityName(String rel, String actualReturnType,
            HttpMethod requestMethod, String[] periods, int i, String period) {
        String publicEntityName =
                getPublicEntity(StringUtils.toSingular(StringUtils.toPlural(actualReturnType)),
                        false);
        if (publicEntityName == null && isAction(period, rel, requestMethod)) {
            publicEntityName =
                    getPublicEntity(StringUtils.toSingular(StringUtils.toPlural(periods[i - 3])));
        }
        return publicEntityName;
    }

    /**
     * Locates SubResourceEntityName
     * 
     * @param parent
     * @param collectionName
     * @return
     */
    private String getSubResourceEntityName(String parent, String collectionName) {
        String publicEntityName =
                getPublicEntity(StringUtils.toSingular(collectionName), false);
        if (publicEntityName == null) {
            publicEntityName =
                    getPublicEntity(StringUtils.toSingular(collectionName.replace(parent,
                            "")));
        }
        return publicEntityName;
    }

    /**
     * Injects action in to the collection
     * 
     * @param rel
     * @param periods
     * @param i
     * @param period
     * @param resourceHolder
     * @param detailedLink
     */
    private void addCollectionAction(String rel, String[] periods, int i, String period,
            ResourceHolder resourceHolder, DetailedLink detailedLink) {

        String methodName = getActionMethodName(period, periods[i - 3]);
        if (!resourceHolder.hasMethod(period)) {
            String docParams = DocsGen.generateBodyParams(detailedLink);

            resourceHolder.addMethod(period,
                    this.resourceActionMethodTemplate.getTemplate(methodName,
                            rel,
                            docParams,
                            detailedLink));
        }
    }

    /**
     * Injects action in to the resource
     * 
     * @param rel
     * @param parent
     * @param collectionName
     * @param period
     * @param detailedLink
     */
    private void addResourceAction(String rel, String parent, String collectionName,
            String period, DetailedLink detailedLink) {

        String methodName = getActionMethodName(period, parent);
        ResourceHolder resourceHolder = this.resourcesHolder.get(parent.toLowerCase());
        CollectionHolder collectionHolder =
                resourceHolder.getSubcollections().get(collectionName.toLowerCase());

        if (!collectionHolder.hasMethod(period)) {
            String docParams = DocsGen.generateBodyParams(detailedLink);

            collectionHolder.addMethod(period,
                    this.collectionActionMethodTemplate.getTemplate(methodName,
                            rel,
                            docParams,
                            detailedLink));
        }
    }

    /**
     * Injects method to the collection
     * 
     * @param collectionHolder
     * @param url
     * @param rel
     * @param decoratorCollectionName
     * @param publicEntityName
     * @param indx
     * @param detailedLink
     */
    private void addCollectionMethod(CollectionHolder collectionHolder,
            String url, String rel, String decoratorCollectionName, String publicEntityName,
            String publicCollectionName, int indx, DetailedLink detailedLink) {

        String docParams = DocsGen.generateBodyParams(detailedLink);
        if (rel.equals(ADD_REL)) {
            if (indx == 1) {
                if (!collectionHolder.hasMethod(rel)) {
                    collectionHolder.addMethod(rel,
                            this.collectionAddMethodTemplate.getTemplate(decoratorCollectionName,
                                    publicEntityName,
                                    docParams, detailedLink));
                }
            } else {
                if (!collectionHolder.hasMethod(rel)) {
                    collectionHolder.addMethod(rel,
                            this.subCollectionAddMethodTemplate.getTemplate(decoratorCollectionName,
                                    publicEntityName,
                                    docParams, detailedLink));

                }
            }
        } else if (rel.equals(GET_REL)) {
            if (detailedLink.getRequest() != null && detailedLink.getRequest().getUrl() != null &&
                    detailedLink.getRequest().getUrl().getParametersSets().size() > 0) {

                String methodId = "list_"
                        + detailedLink.getRequest().getUrl().getParametersSets().size();

                if (!collectionHolder.hasMethod(methodId)) {
                    if (indx == 1) {
                        collectionHolder.addMethod(methodId,
                                this.collectionListMethodTemplate.getTemplate(
                                        StringUtils.toSingular(decoratorCollectionName),
                                        publicCollectionName,
                                        docParams,
                                        detailedLink));
                    } else {
                        collectionHolder.addMethod(methodId,
                                this.subCollectionListMethodTemplate.getTemplate(
                                        StringUtils.toSingular(decoratorCollectionName),
                                        publicCollectionName,
                                        docParams,
                                        detailedLink));

                    }
                }
            }
        }
    }

    /**
     * Injects method to the resource
     * 
     * @param resourceHolder
     * @param url
     * @param rel
     * @param decoratorName
     * @param publicEntityName
     * @param detailedLink
     */
    private void addResourceMethod(ResourceHolder resourceHolder,
            String url, String rel, String decoratorName, String publicEntityName, DetailedLink detailedLink) {

        String docParams = DocsGen.generateBodyParams(detailedLink);

        if (rel.equals(DELETE_REL)) {
            if (!resourceHolder.hasMethod(DELETE_REL)) {
                resourceHolder.addMethod(DELETE_REL,
                        this.deleteMethodTemplate.getTemplate(docParams, detailedLink));
            }
        } else if (rel.equals(UPDATE_REL)) {
            if (!resourceHolder.hasMethod(UPDATE_REL)) {
                resourceHolder.addMethod(UPDATE_REL,
                        this.updateMethodTemplate.getTemplate(decoratorName,
                                publicEntityName,
                                docParams,
                                detailedLink));
            }
        }
    }

    /**
     * Converts rel to actual java method name
     * 
     * @param rel
     *            api URI rel
     * @param parent
     *            resource the action is invoked on
     * 
     * @return actual Java method name
     */
    private String getActionMethodName(String rel, String parent) {
        if (ArrayUtils.contains(ACTION_NAME_EXCEPTIONS, rel))
            return rel + StringUtils.toUpperCase(StringUtils.toSingular(parent));
        return rel;
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
    private String getSubCollectionName(String actualReturnType, String parent, int i, String[] periods) {
        String collection;
        // here
        if (i == periods.length) {
            collection = StringUtils.toPlural(StringUtils.toUpperCase(actualReturnType));
            if (!actualReturnType.toLowerCase().startsWith(parent.toLowerCase())) {
                collection = StringUtils.toPlural(parent
                        +
                        StringUtils.toUpperCase(actualReturnType));
            }
        } else {
            collection = getPublicCollection(periods[i - 1].toLowerCase(), false);
            if (collection != null) {
                collection = StringUtils.toPlural(parent
                        +
                        StringUtils.toUpperCase(collection));
            } else {
                collection = StringUtils.toPlural(parent
                        +
                        StringUtils.toUpperCase(periods[i]));
            }
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
    private String getActualReturnType(String responseBodyType, String period, int i, String[] periods) {
        String actualReturnType;
        if (i == periods.length) {
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

        } else {
            actualReturnType = getPublicCollection(period.toLowerCase(), false);
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
