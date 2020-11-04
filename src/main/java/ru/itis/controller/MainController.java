package ru.itis.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import ru.itis.model.Csv;
import ru.itis.model.Image;
import ru.itis.model.RunPython;
import ru.itis.model.Txt;

@WebServlet("")
public class MainController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List statistic = Csv.csvToArray();
        ArrayList images = Image.ListOfImage();
        String main_info = Txt.txtToString();


        if (actual_file()) {
            File file = new File(Csv.pathToCsv());
            file.delete();
            File file_2 = new File(Txt.pathToTxt());
            file_2.delete();

            RunPython runPython = new RunPython();
            runPython.runScraping();
            runPython.runDatabase();
        }
        request.setAttribute("temp", statistic);
        request.setAttribute("images", images);
        request.setAttribute("main_info", main_info);
        request.getRequestDispatcher("/main.jsp").forward(request, response);
    }

    private String currently_date_csv() {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date) + ".csv";
    }

    private boolean actual_file() throws IOException {
        return !(Csv.getFullPath() + currently_date_csv()).equals(Csv.pathToCsv());
    }
}

