package ru.itis.controller;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ru.itis.dao.LoginDao;
import ru.itis.dao.UserDao;
import ru.itis.model.User;

@WebServlet("/register")
public class UserController extends HttpServlet {
    private static final long serialVersionUID = 1;
    private UserDao userDao;
    private LoginDao loginDao;

    public void init() {
        userDao = new UserDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        register(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/register/register.jsp").forward(request, response);
    }

    private void register(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String nickName = request.getParameter("nickName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String repeatPassword = request.getParameter("repeatPassword");
        boolean status = true;
        System.out.println(nickName);


        User employee = new User();
        employee.setNickName(nickName);
        employee.setEmail(email);
        employee.setPassword(password);

        if (password.length() < 8) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/register/register.jsp");
            status = false;
            request.setAttribute("password_status_2", false);
            request.setAttribute("nickName", nickName);
            request.setAttribute("email", email);
            request.setAttribute("password", password);
            request.setAttribute("repeatPassword", repeatPassword);
            dispatcher.forward(request, response);
        }

        if (!password.equals(repeatPassword)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/register/register.jsp");
            status = false;
            request.setAttribute("password_status_2", false);
            request.setAttribute("nickName", nickName);
            request.setAttribute("email", email);
            request.setAttribute("password", password);
            request.setAttribute("repeatPassword", repeatPassword);
            dispatcher.forward(request, response);
        }

        if (!validate_email(email)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/register/register.jsp");
            status = false;
            request.setAttribute("email_status_2", false);
            request.setAttribute("nickName", nickName);
            request.setAttribute("email", email);
            request.setAttribute("password", password);
            request.setAttribute("repeatPassword", repeatPassword);
            dispatcher.forward(request, response);
        }

        try {
            if (userDao.dublicate(employee) && status) {
                int result = userDao.registerEmployee(employee);
                if (result == 1) {
                    HttpSession session = request.getSession();
                    session.setAttribute("emailStatus", email);
                    session.setAttribute("nameStatus", nickName);
                }
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/register/register.jsp");
                request.setAttribute("email_status", false);
                request.setAttribute("nickName", nickName);
                request.setAttribute("email", email);
                request.setAttribute("password", password);
                request.setAttribute("repeatPassword", repeatPassword);
                dispatcher.forward(request, response);
            }
        } catch (ClassNotFoundException e) {
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