package com.rgsystem.database;

import java.sql.SQLException;

public class QueryExecutionFailedException extends SQLException {
    public QueryExecutionFailedException(String message){
        super(message);
    }
}
