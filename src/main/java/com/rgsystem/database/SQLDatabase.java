package com.rgsystem.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLDatabase implements Database{

    Connection connection;
    Statement statement;

    public void connect(Connection connection){
        this.connection = connection;
    }

    //Execute a SQL query
    public ResultSet executeQuery(String query) throws QueryExecutionFailedException {
        try {

            //creating a statement
            this.statement = this.connection.createStatement();
            //Return the result
            return this.statement.executeQuery(query);

        } catch (SQLException e) {
            throw new QueryExecutionFailedException("SQL database query execution failed");
        }
    }

}