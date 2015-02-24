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

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import com.sun.xml.xsom.XSComplexType;
import com.sun.xml.xsom.XSSchemaSet;
import com.sun.xml.xsom.parser.XSOMParser;
import org.apache.commons.io.FileUtils;
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
import org.ovirt.engine.sdk.codegen.utils.ClassUtils;
import org.ovirt.engine.sdk.codegen.xsd.XsdCodegen;
import org.ovirt.engine.sdk.entities.Capabilities;
import org.ovirt.engine.sdk.entities.DetailedLink;
import org.ovirt.engine.sdk.entities.HttpMethod;
import org.ovirt.engine.sdk.entities.RSDL;
import org.ovirt.engine.sdk.entities.VersionCaps;
import org.ovirt.engine.sdk.codegen.utils.ArrayUtils;
import org.ovirt.engine.sdk.codegen.utils.StringUtils;

/**
 * Provides RSDL related codegen capabilities
 */
public class RsdlCodegen {
    /**
     * The location of the XSD file.
     */
    private String xsdPath;

    /**
     * The location of the RSDL file.
     */
    private String rsdlPath;

    /**
     * This maps contains the mapping between entities as described in the RSDL and the names of the Java classes that
     * represent those entities.
     */
    private Map<String, String> entitiesMap;

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

    private static final String DECORATORS_PACKAGE = "org.ovirt.engine.sdk.decorators";

    private static final String SLASH = "/";
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

    /**
     * In come cases it isn't possible to derive the name of the entity from the link, specially when there are several
     * links that have similar structure but different types. For example, the following to lings have the same
     * structure:
     *
     * <pre>
     * hosts/{host:id}/numanodes/{numanode:id}
     * vms/{vm:id}/numanodes/{numanode:id}
     * </pre>
     *
     * But for the first the entity type is {@code NumaNode} and for the second it is {@code VirtualNumaNode}. This
     * isn't a problem for links that have a request or response type explicitly specified, as it will be taken from
     * there. For example, the link to get a VM numa node explicitly indicates that the type is {@code VirtualNumaNode}:
     *
     * <pre>
     * &lt;link href="/ovirt-engine/api/vms/{vm:id}/numanodes/{numanode:id}" rel="get"&gt;
     *   &lt;description&gt;get the details of the specified virtual NUMA node for the vm&lt;/description&gt;
     *   &lt;request&gt;
     *     &lt;http_method&gt;GET&lt;/http_method&gt;
     *     &lt;body/&gt;
     *   &lt;/request&gt;
     *   &lt;response&gt;
     *     &lt;type&gt;VirtualNumaNode&lt;/type&gt;
     *   &lt;/response&gt;
     * &lt;/link&gt;
     * </pre>
     *
     * But some links don't specify a request or response type, like the {@code DELETE} links. For those cases we need
     * this map of exceptions.
     */
    private static Map<String[], String> ENTITY_NAME_EXCEPTIONS = new HashMap<>();

    static {
        ENTITY_NAME_EXCEPTIONS.put(
            new String[] { "vms", "{vm:id}", "numanodes", "{numanode:id}" }, "VirtualNumaNode"
        );
        ENTITY_NAME_EXCEPTIONS.put(
            new String[] { "operatingsystems", "{operatingsystem:id}" }, "OperatingSystemInfo"
        );
    }

    /**
     * Same for collections.
     */
    private static Map<String[], String> COLLECTION_NAME_EXCEPTIONS = new HashMap<>();

    static {
        COLLECTION_NAME_EXCEPTIONS.put(
            new String[] { "vms", "{vm:id}", "numanodes", }, "VirtualNumaNodes"
        );
        COLLECTION_NAME_EXCEPTIONS.put(
            new String[] { "operatingsystems" }, "OperatingSystemInfos"
        );
    }

    /**
     * Checks if the given name has an exceptional treatment.
     *
     * @param exceptions the map of exceptions to check
     * @param name the name to check
     * @param periods the URL segments to check
     * @param i the number of URL segments to check
     * @return the exceptional name assigned, or {@code null} if no exceptional treatment is needed
     */
    private static String checkNamingException(Map<String[], String> exceptions, String name, String[] periods, int i) {
        periods = Arrays.copyOfRange(periods, 0, i);
        for (Map.Entry<String[], String> exceptionEntry : exceptions.entrySet()) {
            String[] exceptionKey = exceptionEntry.getKey();
            if (exceptionKey.length < i) {
                continue;
            }
            if (ArrayUtils.startsWith(periods, exceptionKey)) {
                return exceptionEntry.getValue();
            }
        }
        return null;
    }

    /**
     * Create a code generator for the decorator classes.
     *
     * @param xsdPath the path of the file containing the XML schema
     * @param rsdlPath the path of the file containing the RSDL document
     */
    public RsdlCodegen(String xsdPath, String rsdlPath) {
        this.xsdPath = xsdPath;
        this.rsdlPath = rsdlPath;

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
     * Maps RSDL entity name to Java class name.
     * 
     * @return EntitiesMap
     */
    private Map<String, String> getEntitiesMap() {
        Map<String, String> map = new HashMap<>();

        // Load the XML schema:
        XSOMParser parser = new XSOMParser();
        XSSchemaSet schema;
        try {
            parser.parse(new File(xsdPath));
            schema = parser.getResult();
        }
        catch (Exception exception) {
            throw new RuntimeException("Can't parse XML schema \"" + xsdPath + "\".", exception);
        }

        // For each complex type add an entry to the entities map:
        Iterator<XSComplexType> types = schema.iterateComplexTypes();
        while (types.hasNext()) {
            XSComplexType type = types.next();
            String name = type.getName();
            map.put(name.toLowerCase(), name);
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
    private Map<String, String> addExceptions(Map<String, String> map) {
        // FIXME: Fix this on server side or fond a way locating exceptions programatically

        map.put("brick", "GlusterBrick");
        map.put("bricks", "GlusterBricks");
        map.put("hostnic", "HostNIC");
        map.put("hostnics", "HostNics");

        return map;
    }

    /**
     * Generates the brokers classes
     * 
     * @param distPath
     *            directory to generates the code at
     * 
     * @throws IOException
     * @throws JAXBException
     */
    public void generate(String distPath) throws IOException, JAXBException {
        // Remove all the previously generate classes, so that classes corresponding to types that have been
        // removed from the XML schema will be later removed from the source code repository:
        File packageDir = new File(distPath, DECORATORS_PACKAGE.replace('.', File.separatorChar));
        if (packageDir.exists()) {
            FileUtils.cleanDirectory(packageDir);
        }

        String url, rel, requestBodyType, responseBodyType, parent, collectionName, actualReturnType;
        HttpMethod requestMethod;

        // #1 - load RSDL
        RSDL rsdl = loadRsdl(rsdlPath);

        // The root element of the RSDL document contains the following:
        //
        //   <rsdl href="/api?rsdl" ...
        //
        // Here we extract from the href the root URL of the API, as it is needed later to make relative other links
        // that appear in the RSDL document.
        String rootUrl = rsdl.getHref().replace("?rsdl", "");

        // #2 - walk RSDL
        for (DetailedLink dl : rsdl.getLinks().getLinks()) {

            url = dl.getHref();
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
                        String collection = getRootCollectionName(period, periods, i);
                        collectionName = collection;
                        parent = StringUtils.toUpperCase(StringUtils.toSingular(collection));
                        String decoratorCollectionName = StringUtils.toUpperCase(collection);
                        String publicEntityName = getPublicEntity(StringUtils.toSingular(collection), periods, i);
                        String publicCollectionName = getPublicCollection(collection, periods, i);
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
                        String resource = getRootResourceName(collectionName, periods, i);
                        String decoratorResourceName = StringUtils.toUpperCase(resource);
                        String publicEntityName = getPublicEntity(StringUtils.toSingular(collectionName), periods, i);

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
                        String decoratorEntityName = getSubResourceName(collectionName, parent, periods, i);
                        String publicEntityName =
                                getSubCollectionEntityName(rel, actualReturnType, requestMethod, periods, i, period);
                        String publicCollectionName =
                                getPublicCollection(StringUtils.toPlural(actualReturnType), periods, i);

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
                            String resource = getSubResourceName(collectionName, parent, periods, i);
                            String subResourceDecoratorName = resource;
                            String publicEntityName = getSubResourceEntityName(parent, collectionName, periods, i);

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
                            String collection = getRootCollectionName(period, periods, i);
                            collectionName = collection;
                            parent = StringUtils.toUpperCase(collectionName);
                            String decoratorCollectionName = StringUtils.toUpperCase(collection);
                            String publicEntityName = getPublicEntity(VersionCaps.class.getSimpleName(), periods, i);
                            String publicCollectionName = getPublicCollection(Capabilities.class.getSimpleName(), periods, i);
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
                            String publicEntityName = getPublicEntity(resource, periods, i);

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

        // #3 - Persist content
        persistContent(distPath);

        // #4 - generate SDK entry point
        new ApiCodegen(collectionsHolder, variableTemplate, collectionGetterTemplate).generate(distPath);

        // #5 - remove collection getters/setters from the public entities
        // (as they being shadowed by the decorators getters)
        XsdCodegen.modifyGetters(distPath, getPublicAccessors());
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
                getPublicEntity(StringUtils.toSingular(StringUtils.toPlural(actualReturnType)), periods, i,
                        false);
        if (publicEntityName == null && isAction(period, rel, requestMethod)) {
            publicEntityName =
                    getPublicEntity(StringUtils.toSingular(StringUtils.toPlural(periods[i - 3])), periods, i);
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
    private String getSubResourceEntityName(String parent, String collectionName, String[] periods, int i) {
        String publicEntityName =
                getPublicEntity(StringUtils.toSingular(collectionName), periods, i, false);
        if (publicEntityName == null) {
            publicEntityName =
                    getPublicEntity(StringUtils.toSingular(collectionName.replace(parent,
                            "")), periods, i);
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
    private String getSubResourceName(String collectionName, String parent, String[] periods, int i) {
        String resource = StringUtils.toSingular(collectionName);
        String resourceCandidate =
                getPublicEntity(StringUtils.toSingular(collectionName.replace(parent, "")
                        .toLowerCase()), periods, i, false);
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
            collection = getPublicCollection(periods[i - 1].toLowerCase(), periods, i, false);
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
    private String getRootResourceName(String collectionName, String[] periods, int i) {
        String resource = StringUtils.toSingular(collectionName);
        String resourceCandidate = getPublicEntity(StringUtils.toSingular(collectionName), periods, i, false);
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
    private String getRootCollectionName(String period, String[] periods, int i) {
        String collection = StringUtils.toUpperCase(StringUtils.toPlural(period));
        String collectionCandidate = getPublicCollection(StringUtils.toPlural(period), periods, i, false);
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
                String collectionCandidate = getPublicCollection(period.toLowerCase(), periods, i, false);
                if (collectionCandidate != null) {
                    actualReturnType = collectionCandidate;
                } else {
                    actualReturnType = period;
                }
            } else {
                actualReturnType = responseBodyType;
            }

        } else {
            actualReturnType = getPublicCollection(period.toLowerCase(), periods, i, false);
        }
        return actualReturnType;
    }

    /**
     * Persist holders content
     * 
     * @param distPath
     *            directory to write the files to
     */
    private void persistContent(String distPath) throws IOException {
        for (CollectionHolder collection : this.collectionsHolder.values()) {
            ClassUtils.saveClass(distPath, DECORATORS_PACKAGE + "." +collection.getName(), collection.produce());
        }
        for (ResourceHolder resource : this.resourcesHolder.values()) {
            ClassUtils.saveClass(distPath, DECORATORS_PACKAGE + "." + resource.getName(), resource.produce());
            for (CollectionHolder subCollection : resource.getSubcollections().values()) {
                ClassUtils.saveClass(distPath, DECORATORS_PACKAGE + "." + subCollection.getName(), subCollection.produce());
            }
        }
    }

    /**
     * @param collectionName
     * 
     * @return public entity name according to class-simple-name
     */
    private String getPublicCollection(String collectionName, String[] periods, int i) {
        String exception = checkNamingException(COLLECTION_NAME_EXCEPTIONS, collectionName, periods, i);
        if (exception != null) {
            return exception;
        }
        if (this.entitiesMap.containsKey(collectionName.toLowerCase())) {
            return this.entitiesMap.get(collectionName.toLowerCase());
        }
        return null;
    }

    /**
     * @param collectionName
     * @param throwError
     * 
     * @return public entity name according to class-simple-name
     */
    private String getPublicCollection(String collectionName, String[] periods, int i, boolean throwError) {
        try {
            return getPublicCollection(collectionName, periods, i);
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
    private String getPublicEntity(String entityName, String[] periods, int i) {
        String exception = checkNamingException(ENTITY_NAME_EXCEPTIONS, entityName, periods, i);
        if (exception != null) {
            return exception;
        }
        if (this.entitiesMap.containsKey(entityName.toLowerCase())) {
            return this.entitiesMap.get(entityName.toLowerCase());
        }
        throw new RuntimeException("Public entity \"" + entityName + "\" fetch has failed.");
    }

    /**
     * @param entityName
     * @param throwError
     * 
     * @return public collection name according to class-simple-name
     */
    private String getPublicEntity(String entityName, String[] periods, int i, boolean throwError) {
        try {
            return getPublicEntity(entityName, periods, i);
        } catch (RuntimeException rte) {
            if (!throwError)
                return null;
            throw rte;
        }
    }

    /**
     * Loads the RSDL from a file.
     *
     * @param rsdlPath the path of the file containing the RDSL document
     * @return RSDL
     * @throws IOException
     * @throws JAXBException
     */
    private RSDL loadRsdl(String rsdlPath) throws IOException, JAXBException {
        JAXBContext context = JAXBContext.newInstance(RSDL.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Source source = new StreamSource(new File(rsdlPath));
        JAXBElement<RSDL> element = unmarshaller.unmarshal(source, RSDL.class);
        return element.getValue();
    }
}
