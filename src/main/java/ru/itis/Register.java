package ru.itis;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/test")
public class Register extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");


            // loading drivers for mysql
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //creating connection with the database
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/itis_java","postgres","postgres");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("INSERT INTO student VALUES (?,?,?)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        int i = 0;
        try {
            i = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(i > 0) {
                out.println("You are sucessfully registered");
            }

    }

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        getServletContext().getRequestDispatcher("/").forward(req, resp);
//    }
}
