package org.ovirt.engine.sdk.codegen.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

public class ReflectionHelper {

    /**
     * Locate all directories in given package
     * 
     * @param path
     * @return Map<URL, File>
     * @throws IOException
     */
    public static List<URL> getDirectories(String path) throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        assert classLoader != null;
        Enumeration<URL> resources = classLoader.getResources(path);
        List<URL> dirs = new ArrayList<URL>();
        while (resources.hasMoreElements()) {
            dirs.add(resources.nextElement());
        }
        return dirs;
    }

    /**
     * Locates all classes in given package
     * 
     * @param packageName
     * @return array of the classes
     * @throws ClassNotFoundException
     * @throws IOException
     */
    public static List<Class<?>> getClasses(String packageName) throws ClassNotFoundException,
            IOException {
        String path = packageName.replace('.', '/');
        List<URL> dirs = getDirectories(path);
        ArrayList<Class<?>> classes = new ArrayList<Class<?>>();
        ClassLoader loader = URLClassLoader.newInstance(dirs.toArray(new URL[0]),
                                                        Thread.currentThread().getContextClassLoader());

        for (URL directory : dirs) {
            String resource = URLDecoder.decode(directory.getPath(), "UTF-8").replace("/" + path + "/", "");
            if (resource.endsWith(".jar")) {
                classes.addAll(getClassNamesInJarPackage(loader, resource, packageName));
            } else {
                classes.addAll(getClassNamesInPackage(new File(URLDecoder.decode(directory.getFile(), "UTF-8")),
                        packageName));
            }
        }
        return classes;
    }

    /**
     * Locates all classes in given package
     * 
     * @param directory
     * @param packageName
     * @return List of classes
     * @throws ClassNotFoundException
     */
    private static List<Class<?>> getClassNamesInPackage(File directory, String packageName)
            throws ClassNotFoundException {
        List<Class<?>> classes = new ArrayList<Class<?>>();
        if (!directory.exists()) {
            return classes;
        }
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                assert !file.getName().contains(".");
                classes.addAll(getClassNamesInPackage(file, packageName + "." + file.getName()));
            } else if (file.getName().endsWith(".class")) {
                classes.add(Class.forName(packageName + '.'
                        + file.getName().substring(0, file.getName().length() - 6)));
            }
        }
        return classes;
    }

    /**
     * Locates all classes in given jar package
     * 
     * @param jarName
     * @param url
     * @param packageName
     * @return List of classes
     * @throws MalformedURLException
     */
    static List<Class<?>> getClassNamesInJarPackage(ClassLoader loader, String jarName, String packageName)
            throws MalformedURLException {
        ArrayList<Class<?>> classes = new ArrayList<Class<?>>();

        packageName = packageName.replaceAll("\\.", "/");

        JarInputStream jarFileInputStream = null;
        try {
            jarFileInputStream = new JarInputStream(new FileInputStream(jarName));
            JarEntry jarEntry;
            while (true) {
                jarEntry = jarFileInputStream.getNextJarEntry();
                if (jarEntry == null)
                    break;
                if ((jarEntry.getName().startsWith(packageName)) && (jarEntry.getName().endsWith(".class"))) {
                    classes.add(loader.loadClass(jarEntry.getName().replaceAll("/", "\\.").replace(".class", "")));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (jarFileInputStream != null) {
                    jarFileInputStream.close();
                }
            } catch (IOException e) {
                // ignore
            }
        }
        return classes;
    }
}