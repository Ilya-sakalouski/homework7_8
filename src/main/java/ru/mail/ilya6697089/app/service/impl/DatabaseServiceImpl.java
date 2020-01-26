package ru.mail.ilya6697089.app.service.impl;

import ru.mail.ilya6697089.app.repository.ConnectionRepository;
import ru.mail.ilya6697089.app.repository.DatabaseRepository;
import ru.mail.ilya6697089.app.repository.impl.ConnectionRepositoryImpl;
import ru.mail.ilya6697089.app.repository.impl.DatabaseRepositoryImpl;
import ru.mail.ilya6697089.app.service.DatabaseService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.invoke.MethodHandles;
import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseServiceImpl implements DatabaseService {

    private ConnectionRepository connectionRepository = ConnectionRepositoryImpl.getInstance();
    private DatabaseRepository databaseRepository = DatabaseRepositoryImpl.getInstance();
    private static final Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());

    private static DatabaseServiceImpl instance;

    public DatabaseServiceImpl() {
    }

    public static DatabaseServiceImpl getInstance() {
        if (instance == null) {
            instance = new DatabaseServiceImpl();
        }
        return instance;
    }

    @Override
    public void deleteExistingTables() {
        try (Connection connection = connectionRepository.getConnection()) {
            connection.setAutoCommit(false);
            try {
                databaseRepository.deleteExistingTables(connection);
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
                logger.error(e.getMessage(), e);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }
    }

    @Override
    public void createTables() {
        try (Connection connection = connectionRepository.getConnection()) {
            connection.setAutoCommit(false);
            try {
                databaseRepository.createTables(connection);
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
                logger.error(e.getMessage(), e);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }
    }

}
