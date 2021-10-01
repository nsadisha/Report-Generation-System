package com.rgsystem.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLDatabase implements Database{

    final Connection connection;
    Statement statement;

    public SQLDatabase(Connection connection){
        this.connection = connection;
    }

    //Create a statement to execute a query(should be called before calling the executeQuery() method.)
    public Statement createStatement() throws SQLException {
        this.statement = this.connection.createStatement();
        return null;
    }

    //Execute a SQL query
    public ResultSet executeQuery(String query) throws SQLException {
        //Checking if the statement is initialized or not
        if(this.statement == null){
            throw new SQLException("Uninitialized statement.");
        }

        //Return the result
        return this.statement.executeQuery(query);
    }

}
