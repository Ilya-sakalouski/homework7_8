package ru.mail.ilya6697089.app.repository.impl;

import ru.mail.ilya6697089.app.repository.DatabaseRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.invoke.MethodHandles;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static ru.mail.ilya6697089.app.repository.constant.SqlQueryConstant.*;

public class DatabaseRepositoryImpl implements DatabaseRepository {

    private static final Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());

    private static DatabaseRepository instance;

    private DatabaseRepositoryImpl() {
    }

    public static DatabaseRepository getInstance() {
        if (instance == null) {
            instance = new DatabaseRepositoryImpl();
        }
        return instance;
    }

    @Override
    public void deleteExistingTables(Connection connection) {
        try (Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(SQL_QUERY_SHOW_TABLES)) {
            if (rs.next()) {
                try {
                    statement.executeUpdate(SQL_QUERY_DROP_TABLES);
                    logger.info("Tables user, user_information deleted if existed");
                } catch (SQLException e) {
                    logger.error("SQLException during deleting existing tables: " + e.getMessage());
                }
            }
        } catch (SQLException e) {
            logger.error("SQLException during deleting existing tables: " + e.getMessage());
        }
    }

    @Override
    public void createTables(Connection connection) {
        try (Statement statement = connection.createStatement();
        ) {
            statement.executeUpdate(SQL_QUERY_CREATE_TABLE_USER);
            statement.executeUpdate(SQL_QUERY_CREATE_TABLE_USER_INFO);
        } catch (SQLException e) {
            logger.error("SQLException during creating tables: " + e.getMessage());
        }
    }

}
