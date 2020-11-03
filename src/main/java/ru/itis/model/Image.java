package ru.itis.model;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Image {
    private static final String relative_path = "/Users/aleksandr/Desktop/Programm/java/lesson_kpfu_3/CoronavirusStatistic";

    public static String getRelative_path() {
        return relative_path;
    }

    public static ArrayList<File> ListOfImage() {
        File f = new File( getRelative_path() + "/src/main/webapp/template/plots_images");
        ArrayList<File> pathList = new ArrayList<>();
        FilenameFilter textFilter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".png");
            }
        };

        File[] files = f.listFiles(textFilter);
        for (File file : files) {
            if (file.isFile()) {
                pathList.add(file);
            }
        }
        return pathList;
    }
}
