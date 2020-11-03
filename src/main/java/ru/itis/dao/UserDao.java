package ru.itis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ru.itis.model.LoginBean;
import ru.itis.model.User;
import ru.itis.util.JDBCUtils;

public class UserDao {

    public int registerEmployee(User employee) {
        String INSERT_USERS_SQL = "INSERT INTO student VALUES (?,?,?)";

        int result = 0;
        try (Connection connection = JDBCUtils.getConnection();
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
                preparedStatement.setString(1, employee.getNickName());
                preparedStatement.setString(2, employee.getEmail());
                preparedStatement.setString(3, employee.getPassword());

                System.out.println(preparedStatement);
                // Step 3: Execute the query or update query
                result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
            JDBCUtils.printSQLException(e);
        }
        return result;
    }

    public boolean dublicate(User emoloyee) throws ClassNotFoundException {
        boolean status = true;

        Class.forName("org.postgresql.Driver");

        try (Connection connection = JDBCUtils.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection
                     .prepareStatement("select * from student where email = ?")) {
            preparedStatement.setString(1, emoloyee.getEmail());

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            status = rs.next();

        } catch (SQLException e) {
            // process sql exception
            JDBCUtils.printSQLException(e);
        }
        return !status;
    }
}