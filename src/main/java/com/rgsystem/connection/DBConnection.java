package com.rgsystem.connection;

import java.sql.Connection;
import java.sql.SQLException;

public interface DBConnection {
    Connection getConnection() throws ConnectionFailedException;
}
