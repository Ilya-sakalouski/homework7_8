package ru.mail.ilya6697089.app.repository.constant;

public interface ConnectionConstant {

    String DATABASE_URL = "datasource.url";
    String DATABASE_USERNAME = "datasource.username";
    String DATABASE_PASSWORD = "datasource.password";

    String DATASOURCE_CACHE_STMTS = "cachePrepStmts";
    String DATASOURCE_CACHE_SIZE = "prepStmtCacheSize";
    String DATASOURCE_CACHE_SQL_LIMIT = "prepStmtCacheSqlLimit";

    boolean cachePrepStmts = true;
    int prepStmtCacheSqlLimit = 2048;
    int prepStmtCacheSize = 250;

}
