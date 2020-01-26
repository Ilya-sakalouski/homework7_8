package ru.mail.ilya6697089.app.repository;

import java.sql.Connection;

public interface DatabaseRepository {

    void deleteExistingTables(Connection connection);

    void createTables(Connection connection);

}
