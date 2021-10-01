package com.rgsystem;

import com.rgsystem.connection.DBConnection;
import com.rgsystem.connection.SQLConnection;
import com.rgsystem.database.Database;
import com.rgsystem.database.SQLDatabase;

public class Main {
    public static void main(String[] args) {

//        Inputs inputs = new ;

        DBConnection connection = new SQLConnection(
            "jdbc:mysql://localhost:3306/bookbae",
            "root",
            ""
        );

        Database database = new SQLDatabase();
        ReportGeneratorApp app = new ReportGeneratorApp(connection, database);

        //start the app
        app.start();

    }
}
