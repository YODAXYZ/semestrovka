package ru.itis.dao;

import ru.itis.model.User;
import ru.itis.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserProfile implements UserProfileDao {
    private static final String SELECT_TODO_BY_ID = "select id,title,username,description,target_date,is_done from todos where id =?";
    private static final String SELECT_ALL_TODOS = "select * from todos";
    private static final String DELETE_USER_BY_EMAIL = "delete from student where email = ?;";
    private static final String UPDATE_USER = "update student set name = ?, email= ?, pass =?";

    @Override
    public boolean deleteUser(String email) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = JDBCUtils.getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_USER_BY_EMAIL);) {
            statement.setString(1, email);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = JDBCUtils.getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_USER);) {
            statement.setString(1, user.getNickName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
}
