package ru.mail.ilya6697089.app.repository.impl;

import ru.mail.ilya6697089.app.repository.ConnectionRepository;
import ru.mail.ilya6697089.app.util.PropertyUtil;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

import static ru.mail.ilya6697089.app.repository.constant.ConnectionConstant.*;

public class ConnectionRepositoryImpl implements ConnectionRepository {

    private static ConnectionRepository instance;

    private ConnectionRepositoryImpl() {
    }

    public static ConnectionRepository getInstance() {
        if (instance == null) {
            instance = new ConnectionRepositoryImpl();
        }
        return instance;
    }

    private static HikariDataSource ds;

    @Override
    public Connection getConnection() throws SQLException {
        if (ds == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            PropertyUtil propertyUtil = new PropertyUtil();
            HikariConfig config = new HikariConfig();
            config.setJdbcUrl(propertyUtil.getProperty(DATABASE_URL));
            config.setUsername(propertyUtil.getProperty(DATABASE_USERNAME));
            config.setPassword(propertyUtil.getProperty(DATABASE_PASSWORD));
            config.addDataSourceProperty(DATASOURCE_CACHE_STMTS, cachePrepStmts);
            config.addDataSourceProperty(DATASOURCE_CACHE_SIZE, prepStmtCacheSize);
            config.addDataSourceProperty(DATASOURCE_CACHE_SQL_LIMIT, prepStmtCacheSqlLimit);
            ds = new HikariDataSource(config);
        }
        return ds.getConnection();
    }

}