package com.rgsystem;

import com.rgsystem.connection.DBConnection;
import com.rgsystem.connection.SQLConnection;
import com.rgsystem.database.Database;
import com.rgsystem.database.SQLDatabase;
import com.rgsystem.input.Inputs;
import com.rgsystem.input.CommandLineInputs;

public class Main {
    public static void main(String[] args) {
        DBConnection connection = new SQLConnection(
                "jdbc:mysql://localhost:3306/bookbae",
                "root",
                ""
        );

        Database database = new SQLDatabase();
        Inputs inputs = new CommandLineInputs(args);
        ReportGeneratorApp app = new ReportGeneratorApp(connection, database, inputs);

        //start the app
        app.execute();
    }
}
