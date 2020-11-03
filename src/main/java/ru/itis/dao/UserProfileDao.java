package ru.itis.dao;

import ru.itis.model.User;
import java.sql.SQLException;

public interface UserProfileDao {

    boolean deleteUser(String email) throws SQLException;

    boolean updateUser(User user) throws SQLException;
}
