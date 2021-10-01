package com.rgsystem.connection;

import java.sql.SQLException;

public class ConnectionFailedException extends SQLException {
    public ConnectionFailedException(String message){
        super(message);
    }
}
