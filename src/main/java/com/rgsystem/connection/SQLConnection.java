package com.rgsystem.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnection implements DBConnection{
    private final String host;
    private final String userName;
    private final String password;

    public SQLConnection(String host, String userName, String password){
        this.host = host;
        this.userName = userName;
        this.password = password;
    }

    public Connection getConnection() throws ConnectionFailedException{
        try {
            return DriverManager.getConnection(this.host, this.userName, this.password);
        } catch (SQLException e) {
            throw new ConnectionFailedException("Connection to the database failed");
        }
    }
}
