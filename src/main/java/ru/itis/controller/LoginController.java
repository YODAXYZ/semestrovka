package ru.itis.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ru.itis.dao.LoginDao;
import ru.itis.model.LoginBean;


@WebServlet("/login")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1;
    private LoginDao loginDao;

    public void init() {
        loginDao = new LoginDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/login/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        authenticate(request, response);
    }

    private void authenticate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        LoginBean loginBean = new LoginBean();
        loginBean.setEmail(email);
        loginBean.setPassword(password);

        try {
            if (loginDao.validate(loginBean)) {
                HttpSession session = request.getSession();
                session.setAttribute("emailStatus", email);
                session.setAttribute("nameStatus", loginDao.user(loginBean));
                response.sendRedirect("http://localhost:8080/");

            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/login/login.jsp");
                request.setAttribute("email", email);
                request.setAttribute("password", password);
                request.setAttribute("status", false);
                dispatcher.forward(request, response);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
