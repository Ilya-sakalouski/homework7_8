package ru.mail.ilya6697089.app.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.mail.ilya6697089.app.repository.ConnectionRepository;
import ru.mail.ilya6697089.app.repository.UserRepository;
import ru.mail.ilya6697089.app.repository.impl.ConnectionRepositoryImpl;
import ru.mail.ilya6697089.app.repository.impl.UserRepositoryImpl;
import ru.mail.ilya6697089.app.repository.model.User;
import ru.mail.ilya6697089.app.service.UserService;
import ru.mail.ilya6697089.app.service.model.UserDTO;

import java.lang.invoke.MethodHandles;
import java.sql.Connection;
import java.sql.SQLException;

public class UserServiceImpl implements UserService {

    private static final Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private static UserService instance;
    private ConnectionRepository connectionRepository = ConnectionRepositoryImpl.getInstance();
    private UserRepository userRepository = UserRepositoryImpl.getInstance();

    private UserServiceImpl() {
    }

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserServiceImpl();
        }
        return instance;
    }

    @Override
    public UserDTO add(UserDTO userDTO) {
        try (Connection connection = connectionRepository.getConnection()) {
            connection.setAutoCommit(false);
            try {
                User databaseUser = convertDTOToDatabaseUser(userDTO);
                databaseUser = userRepository.add(connection, databaseUser);
                connection.commit();
                return convertDatabaseUserToDTO(databaseUser);
            } catch (SQLException e) {
                connection.rollback();
                logger.error(e.getMessage(), e);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    private User convertDTOToDatabaseUser(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getName());
        user.setPassword(userDTO.getPassword());
        user.setAge(userDTO.getAge());
        return user;
    }

    private UserDTO convertDatabaseUserToDTO(User databaseUser) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(databaseUser.getId());
        userDTO.setName(databaseUser.getUsername());
        userDTO.setPassword(databaseUser.getPassword());
        userDTO.setAge(databaseUser.getAge());
        return userDTO;
    }

}

