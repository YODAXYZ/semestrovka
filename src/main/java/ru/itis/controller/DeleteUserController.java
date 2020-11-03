package ru.itis.controller;

import ru.itis.dao.UserProfile;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/delete-profile")
public class DeleteUserController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        if (session.getAttribute("emailStatus") == null) {
            request.getRequestDispatcher("/WEB-INF/views/profile/profile.jsp").forward(request, response);
        }
        else {
            deleteUser(request, response);
        }
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("emailStatus");
        UserProfile userProfile = new UserProfile();
        try {
            userProfile.deleteUser(email);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        session.setAttribute("emailStatus", null);
        session.setAttribute("nameStatus", null);
        response.sendRedirect("http://localhost:8080/");
    }
}
