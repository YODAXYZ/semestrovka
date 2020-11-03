package ru.itis.model;

import java.io.IOException;

public class RunPython {
    private final String ABSOLUTE_PATH = "/Users/aleksandr/Desktop/Programm/java/lesson_kpfu_3/CoronavirusStatistic/src/main/webapp/WEB-INF/python/";

    public void runScraping() {
        String command = "python " + ABSOLUTE_PATH + "corona_scraping.py";
        try {
            Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            e.getMessage();
        }
    }
    public void sendStatistic(String email) {
        String command = "python " + ABSOLUTE_PATH + "sender.py " + email;
        try {
            Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            e.getMessage();
        }
    }

}
