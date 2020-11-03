package ru.itis.model;

import java.io.*;
import java.sql.Struct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Csv {
    private static final String full_path = "/Users/aleksandr/Desktop/Programm/java/lesson_kpfu_3/CoronavirusStatistic/src/main/webapp/WEB-INF/python/csv/";

    public static String getFullPath() {
        return full_path;
    }

    public static List csvToArray() throws IOException {
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(pathToCsvFile()))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                records.add(Arrays.asList(values));
            }
        }
        return records;
    }

    public static String pathToCsv() throws IOException {
        File f = new File(getFullPath());

        FilenameFilter textFilter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".csv");
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

    private static File pathToCsvFile() throws IOException {
        File f = new File(getFullPath());

        FilenameFilter textFilter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".csv");
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