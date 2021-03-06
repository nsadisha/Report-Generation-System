package com.rgsystem;

import com.rgsystem.connection.DBConnection;
import com.rgsystem.connection.SQLConnection;
import com.rgsystem.database.Database;
import com.rgsystem.database.SQLDatabase;
import com.rgsystem.input.Inputs;
import com.rgsystem.input.CommandLineInputs;
import com.rgsystem.ui.CmdLineUI;
import com.rgsystem.ui.UI;
import com.rgsystem.validation.CMDInputValidations;
import com.rgsystem.validation.InputValidations;


public class Main {
    public static void main(String[] args){

        DBConnection connection = new SQLConnection(
                "jdbc:mysql://localhost:3306/bookbae",
                "root",
                ""
        );

        Database database = new SQLDatabase();
        InputValidations validations = new CMDInputValidations();
        Inputs inputs = new CommandLineInputs(args, validations);
        UI ui = new CmdLineUI();
        ReportGeneratorApp app = new ReportGeneratorApp(connection, database, inputs, ui);

        //start the app
        app.execute();

    }

}