package com.rgsystem.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public interface Database {

    Statement createStatement() throws SQLException;
    ResultSet executeQuery(String query) throws Exception;

}
