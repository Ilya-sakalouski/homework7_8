package ru.mail.ilya6697089.app.repository.impl;

import ru.mail.ilya6697089.app.repository.UserRepository;
import ru.mail.ilya6697089.app.repository.model.User;

import java.sql.*;

import static ru.mail.ilya6697089.app.repository.constant.SqlQueryConstant.*;

public class UserRepositoryImpl implements UserRepository {

    private static UserRepository instance;

    private UserRepositoryImpl() {
    }

    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepositoryImpl();
        }
        return instance;
    }

    @Override
    public User add(Connection connection, User user) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(SQL_QUERY_INSERT_USER, Statement.RETURN_GENERATED_KEYS);
        ) {
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setInt(3, user.getAge());
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating person failed, no rows affected.");
            }
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    user.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
            return user;
        }
    }

}
