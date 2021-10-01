package com.rgsystem.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface Database {

    void connect(Connection connection);
    ResultSet executeQuery(String query) throws QueryExecutionFailedException;

}
