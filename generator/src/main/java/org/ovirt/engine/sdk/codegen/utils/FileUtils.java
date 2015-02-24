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

package org.ovirt.engine.sdk.codegen.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Provides File/Directory related services
 */
public class FileUtils {

    public static final String LINE_SEPARATOR = "line.separator";
    public static final String ENCODING = "UTF-8";
    public static final String NEW_LINE = System.getProperty(LINE_SEPARATOR);

    /**
     * Deletes all files in given directory
     *
     * @param directory
     *            directory to clean
     *
     * @return sucess/failure
     */
    public static boolean deleteAllFiles(String directory) {
        boolean res = true;
        for (File f : list(directory)) {
            res = res & f.delete();
        }
        return res;
    }

    /**
     * Deletes given file
     *
     * @param fileName
     *            file to delete
     *
     * @return boolean
     */
    public static boolean delete(String fileName) {
        return new File(fileName).delete();
    }

    /**
     * Deletes given file
     *
     * @param file
     *            file to delete
     *
     * @return boolean
     */
    public static boolean delete(File file) {
        return file.delete();
    }

    /**
     * Renames file
     *
     * @param file
     *            File to rename
     * @param name
     *            new file name
     *
     * @return boolean
     */
    public static boolean rename(File file, String name) {
        return file.renameTo(new File(name));
    }

    /**
     * List all files in given directory
     *
     * @param directory
     *
     * @return File[]
     */
    public static File[] list(String directory) {
        return new File(directory).listFiles();
    }

    /**
     * Reads file content
     * 
     * @param path
     *            file path to read from
     * 
     * @return file content
     * 
     * @throws FileNotFoundException
     */
    public static String getFileContent(String path) throws FileNotFoundException {
        return getFileContent(path, true, true);
    }

    /**
     * Reads file content
     *
     * @param path
     *            file path to read from
     * @param appendNewLine
     *            append new line to the end of the file
     * @param removeTrailingWhitespace
     *            removes trailing whitespaces
     *
     * @return file content
     *
     * @throws FileNotFoundException
     */
    public static String getFileContent(String path, boolean appendNewLine,
            boolean removeTrailingWhitespace) throws FileNotFoundException {
        StringBuilder text = new StringBuilder();
        Scanner scanner = new Scanner(new FileInputStream(path), ENCODING);

        try {
            while (scanner.hasNextLine()) {
                if (scanner.hasNextLine()) {
                    text.append(
                            removeTrailingWhitespaces(
                                    scanner.nextLine(),
                                    removeTrailingWhitespace) + NEW_LINE);
                } else {
                    if (appendNewLine) {
                        text.append(
                                removeTrailingWhitespaces(
                                        scanner.nextLine(),
                                        removeTrailingWhitespace) + NEW_LINE);
                    } else {
                        text.append(
                                removeTrailingWhitespaces(
                                        scanner.nextLine(),
                                        removeTrailingWhitespace));
                    }
                }
            }
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
        return text.toString();
    }

    /**
     * removes trailing whitespaces
     *
     * @param string
     *            the string to process
     *
     * @return string with no trailing whitespaces
     */
    private static String removeTrailingWhitespaces(String string, boolean remove) {
        return remove && string != null ? string.replaceAll("\\s+$", "") : string;
    }

    /**
     * Reads file content
     *
     * @return file content as list of strings
     *
     * @throws FileNotFoundException
     */
    public static List<String> getFileContentAsList(String path)
            throws FileNotFoundException {
        return getFileContentAsList(path, true);
    }

    /**
     * Reads file content
     *
     * @return file content as list of strings
     * @param removeTrailingWhitespace
     *            removes trailing whitespaces
     *
     * @throws FileNotFoundException
     */
    public static List<String> getFileContentAsList(String path, boolean removeTrailingWhitespace)
            throws FileNotFoundException {
        List<String> strings = new ArrayList<String>();
        String NL = System.getProperty(LINE_SEPARATOR);
        Scanner scanner = new Scanner(new FileInputStream(path), ENCODING);

        try {
            while (scanner.hasNextLine()) {
                strings.add(
                        removeTrailingWhitespaces(
                                scanner.nextLine(),
                                removeTrailingWhitespace) + NL);
            }
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
        return strings;
    }

    /**
     * Stores file
     *
     * @param filePath
     *            file path
     * @param content
     *            file content
     */
    public static void saveFile(String filePath, String content) {
        PrintWriter out = null;
        if (filePath != null && content != null) {
            try {
                out = new PrintWriter(filePath);
                out.println(content);
            } catch (FileNotFoundException e) {
                // TODO: Log error
                e.printStackTrace();
                throw new RuntimeException("File \"" + filePath + "\" write failed.");
            } finally {
                if (out != null) {
                    out.close();
                }
            }
        }
    }
}
