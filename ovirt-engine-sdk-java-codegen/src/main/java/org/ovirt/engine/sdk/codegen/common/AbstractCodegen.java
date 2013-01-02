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

package org.ovirt.engine.sdk.codegen.common;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.apache.http.client.ClientProtocolException;
import org.ovirt.engine.sdk.codegen.utils.FileUtils;
import org.ovirt.engine.sdk.exceptions.ServerException;

/**
 * Base class for CodeGen generators
 */
public abstract class AbstractCodegen implements ICodegen {

    private String distPath;

    /**
     * @param distPath
     *            path to generate the code in
     */
    public AbstractCodegen(String distPath) {
        super();
        this.distPath = distPath;
    }

    /**
     * Cleans the package and generates new code
     * 
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws IOException
     * @throws JAXBException
     */
    public void generate() throws ClientProtocolException,
            ServerException, IOException, JAXBException {
        doCleanPackage(this.distPath);
        doGenerate(this.distPath);
    }

    /**
     * Generates the code
     * 
     * @param distPath
     *            directory to generates the code at
     * 
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws IOException
     * @throws JAXBException
     */
    protected abstract void doGenerate(String distPath) throws ClientProtocolException,
            ServerException, IOException, JAXBException;

    /**
     * Delete all files in given directory
     * 
     * @param dir
     *            directory to clean
     */
    protected void doCleanPackage(String dir) {
        FileUtils.deleteAllFiles(dir);
    }

    /***
     * @return path to generate the code in
     */
    protected String getDistinationPath() {
        return distPath;
    }

    /**
     * Persist Java class
     * 
     * @param name
     *            class name (without suffix/extention)
     * @param content
     *            class content
     * 
     * @param outDir
     *            directory to write the file to
     */
    protected void persistClass(String name, String content, String outDir) {
        String fileName = outDir + name + ".java";
        FileUtils.saveFile(fileName, content);
    }
}
