package ru.mail.ilya6697089.app.repository.constant;

public interface SqlQueryConstant {

    String SQL_QUERY_CREATE_TABLE_USER = "CREATE TABLE user" +
            "( id       INT(11) PRIMARY KEY AUTO_INCREMENT," +
            " username  VARCHAR(40) NOT NULL," +
            " password  VARCHAR(40) NOT NULL," +
            " is_active BOOLEAN DEFAULT TRUE," +
            " age INT(11) NOT NULL);";
    String SQL_QUERY_CREATE_TABLE_USER_INFO = "CREATE TABLE user_information" +
            "(user_id INT(11) PRIMARY KEY NOT NULL," +
            " address  VARCHAR(100) NOT NULL," +
            " telephone  VARCHAR(40) NOT NULL," +
            " FOREIGN KEY (user_id) REFERENCES user(id));";
    String SQL_QUERY_SHOW_TABLES = "SHOW TABLES;";
    String SQL_QUERY_DROP_TABLES = "DROP TABLE user, user_information;";
    String SQL_QUERY_INSERT_USER = "INSERT INTO user( username, password, age) VALUES (?,?,?);";
    String SQL_QUERY_SELECT_USERS_ID = "SELECT id  FROM user ORDER BY id";
    String SQL_QUERY_INSERT_USER_INFO = "INSERT INTO user_information(user_id, address, telephone) VALUES (?, ?, ?)";
    String SQL_QUERY_SELECT_ALL_USER = "SELECT * FROM user";
    String SQL_QUERY_FIND_GROUP_AND_COUNT_USERS = "SELECT ug.name as \"1\", " +
            "count(u.id) as \"2\" " +
            "FROM user_group ug " +
            "INNER JOIN user u " +
            "ON ug.id=u.user_group_id " +
            "GROUP BY ug.name;";
    String SQL_QUERY_DELETE_USER_YOUNGER_AGE = "DELETE user, user_information " +
            "FROM user " +
            "LEFT JOIN user_information " +
            "ON user.id=user_information.user_id " +
            "WHERE user.age<27;";
    String SQL_QUERY_DEACTIVATE_USERS_IN_AGE_RANGE = "UPDATE user SET is_active=false WHERE age>=? AND age<=?";
    String SQL_QUERY_INSERT_USER_GROUP = "INSERT INTO user_group(name) VALUES (?)";
    String SQL_QUERY_SELECT_USER_GROUP_IDS = "SELECT id  FROM user_group";
    String SQL_QUERY_RESULT_COLUMN_GROUP_NAME = "1";
    String SQL_QUERY_RESULT_COLUMN_USER_COUNT = "2";

}
