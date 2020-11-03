package ru.itis.controller;

import ru.itis.dao.UserDao;
import ru.itis.dao.UserProfile;
import ru.itis.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/edit-profile")
public class EditUserController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        if (session.getAttribute("emailStatus") == null) {
            request.getRequestDispatcher("/WEB-INF/views/profile/profile.jsp").forward(request, response);
        }
        else {
            String name = (String) session.getAttribute("nameStatus");
            String email = (String) session.getAttribute("emailStatus");
            request.setAttribute("nickName", name);
            request.setAttribute("email", email);
            request.getRequestDispatcher("/WEB-INF/views/edit/edit.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        editUser(request, response);
    }

    private void editUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String nickName = request.getParameter("nickName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String repeatPassword = request.getParameter("repeatPassword");

        if (password.length() < 8) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/edit/edit.jsp");
            request.setAttribute("password_status_2", false);
            request.setAttribute("nickName", nickName);
            request.setAttribute("email", email);
            request.setAttribute("password", password);
            request.setAttribute("repeatPassword", repeatPassword);
            dispatcher.forward(request, response);
        }

        if (!password.equals(repeatPassword)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/edit/edit.jsp");
            request.setAttribute("password_status", false);
            request.setAttribute("nickName", nickName);
            request.setAttribute("email", email);
            request.setAttribute("password", password);
            request.setAttribute("repeatPassword", repeatPassword);
            dispatcher.forward(request, response);
        }


        if (!validate_email(email)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/register/register.jsp");
            request.setAttribute("email_status_2", false);
            request.setAttribute("nickName", nickName);
            request.setAttribute("email", email);
            request.setAttribute("password", password);
            request.setAttribute("repeatPassword", repeatPassword);
            dispatcher.forward(request, response);
        }

        User user = new User();
        user.setNickName(nickName);
        user.setEmail(email);
        user.setPassword(password);

        UserProfile userProfile = new UserProfile();
        HttpSession session = request.getSession();

        UserDao userDao = new UserDao();
        try {
            if (user.getEmail().equals(session.getAttribute("emailStatus"))) {
                boolean result = userProfile.updateUser(user);
                if (result) {
                    session.setAttribute("emailStatus", email);
                    session.setAttribute("nameStatus", nickName);
                }
            }
            else {
                if (userDao.dublicate(user)) {
                    boolean result = userProfile.updateUser(user);
                    if (result) {
                        session.setAttribute("emailStatus", email);
                        session.setAttribute("nameStatus", nickName);
                    }
                }
                else {
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/edit/edit.jsp");
                    request.setAttribute("email_status", false);
                    request.setAttribute("nickName", nickName);
                    request.setAttribute("email", email);
                    request.setAttribute("password", password);
                    request.setAttribute("repeatPassword", repeatPassword);
                    dispatcher.forward(request, response);
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("http://localhost:8080/");
    }

    private static boolean validate_email(String emailStr) {
        Pattern valid_email =
                Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

        Matcher matcher = valid_email.matcher(emailStr);
        return matcher.find();
    }
}
