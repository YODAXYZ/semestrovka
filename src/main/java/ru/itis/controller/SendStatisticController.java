package ru.itis.controller;

import ru.itis.model.RunPython;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/send-statistic")
public class SendStatisticController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String email = (String) session.getAttribute("emailStatus");

        if (email != null) {
            RunPython runPython = new RunPython();
            runPython.sendStatistic(email);
            System.out.println("Send statistic");
            resp.sendRedirect("http://localhost:8080/");
        } else {
            req.getRequestDispatcher("/WEB-INF/views/profile/profile.jsp").forward(req, resp);
        }

    }
}
