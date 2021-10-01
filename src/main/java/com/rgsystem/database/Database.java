package com.rgsystem.database;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface Database {

    void createStatement() throws SQLException;
    ResultSet executeQuery(String query) throws Exception;

}
