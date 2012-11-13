package org.ovirt.engine.sdk.codegen;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.xml.bind.JAXBException;

import org.apache.http.client.ClientProtocolException;
import org.ovirt.engine.sdk.exceptions.ServerException;
import org.ovirt.engine.sdk.utils.ConnectionsPoolBuilder;
import org.ovirt.engine.sdk.utils.HttpProxyBuilder;
import org.ovirt.engine.sdk.web.HttpProxy;

/**
 * oVirt java-sdk codegen suite
 */
public class Main {
    private static final String API_URL = "http://localhost:8080/api";
    private static final String USER = "admin@internal";
    private static final String PASSWORD = "123456";

    private static final String SCHEMA_URL = "?schema";

    private static final String WINDOWS_XJC_PATH = "%java_home%\\bin\\xjc";
    private static final String NX_XJC_PATH = "xjc";

    private static final String OS = System.getProperty("os.name").toLowerCase();

    private static final String WINDOWS_ENTITIES_PACKAGE = "..\\java-sdk\\src\\main\\java\\";
    private static final String NX_ENTITIES_PACKAGE = "../java-sdk/src/main/java/";

    private static final String ENTITIES_PACKAGE = "org.ovirt.engine.sdk.entities";

    private static final String SCHEMA_FILE_NAME = "api.xsd";

    public static void main(String[] args) throws ClientProtocolException,
            ServerException, IOException, JAXBException {
        HttpProxy httpProxy =
                new HttpProxyBuilder(
                        new ConnectionsPoolBuilder(API_URL, USER, PASSWORD).build()
                        ).build();

        // #1 - generate java classes from the schema
        generateEntities(httpProxy);

        // #2 - generate API e.p

        // #3 - generate entities decorators

        // #$ - compile java-sdk

        // #5 - exit
        System.exit(0);
    }

    private static void generateEntities(HttpProxy httpProxy) throws ClientProtocolException,
            ServerException, IOException, JAXBException {

        String xjcOutput = null;

        fetchScema(httpProxy);

        if (isWindows()) {
            xjcOutput = runCommand(WINDOWS_XJC_PATH + " -d " + WINDOWS_ENTITIES_PACKAGE +
                    " -p " + ENTITIES_PACKAGE + " -extension -no-header " + SCHEMA_FILE_NAME);
        } else if (isMac() || isUnix() || isSolaris()) {
            xjcOutput = runCommand(NX_XJC_PATH + " -d " + NX_ENTITIES_PACKAGE +
                    " -p " + ENTITIES_PACKAGE + " -extension -no-header " + SCHEMA_FILE_NAME);
        } else {
            throw new RuntimeException("unsupported OS.");
        }

        if (!xjcOutput.startsWith("parsing a schema...compiling a schema...")) {
            throw new RuntimeException("xjc codegen failed: " + xjcOutput);
        }
    }

    private static void fetchScema(HttpProxy httpProxy) throws ServerException,
            JAXBException, IOException {
        PrintWriter out = null;
        String schema = httpProxy.get(SCHEMA_URL);
        if (schema != null && !schema.equals("")) {
            try {
                out = new PrintWriter(SCHEMA_FILE_NAME);
                out.println(schema);
            } finally {
                if (out != null) {
                    out.close();
                }
            }
        } else {
            throw new RuntimeException("xsd schema download failed.");
        }
    }

    private static String runCommand(String command) throws IOException {
        String stdout = "";
        String stderr = "";
        String s = null;

        Process p = Runtime.getRuntime().exec(command);

        BufferedReader stdInput = new BufferedReader(new
                InputStreamReader(p.getInputStream()));

        BufferedReader stdError = new BufferedReader(new
                InputStreamReader(p.getErrorStream()));

        while ((s = stdInput.readLine()) != null) {
            stdout += s;
        }

        while ((s = stdError.readLine()) != null) {
            stderr += s;
        }

        if (!stderr.equals(""))
            throw new RuntimeException(stderr);

        return stdout;
    }

    public static boolean isWindows() {

        return (OS.indexOf("win") >= 0);

    }

    public static boolean isMac() {

        return (OS.indexOf("mac") >= 0);

    }

    public static boolean isUnix() {

        return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0);

    }

    public static boolean isSolaris() {

        return (OS.indexOf("sunos") >= 0);

    }
}
