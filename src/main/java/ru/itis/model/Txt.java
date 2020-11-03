package ru.itis.model;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Txt {
    private static final String full_path = "/Users/aleksandr/Desktop/Programm/java/lesson_kpfu_3/CoronavirusStatistic/src/main/webapp/WEB-INF/python/txt/";


    public static String getFullPath() {
        return full_path;
    }

    public static String txtToString() throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(pathToTxt()));
        return new String(encoded, "UTF-8");
    }

    public static String pathToTxt() throws IOException {
        File f = new File(getFullPath());

        FilenameFilter textFilter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".txt");
            }
        };

        File[] files = f.listFiles(textFilter);
        for (File file : files) {
            if (!file.isDirectory()) {
                return file.getCanonicalPath();
            }
        }
        return null;
    }

    private static File pathToTxtFile() throws IOException {
        File f = new File(getFullPath());

        FilenameFilter textFilter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".txt");
            }
        };

        File[] files = f.listFiles(textFilter);
        for (File file : files) {
            if (file.isFile()) {
                return file;
            }
        }
        return null;
    }
}
