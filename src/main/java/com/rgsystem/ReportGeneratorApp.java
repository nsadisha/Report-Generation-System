package com.rgsystem;

import com.rgsystem.connection.DBConnection;
import com.rgsystem.database.Database;
import com.rgsystem.input.Inputs;
import com.rgsystem.input.InvalidInputException;
import com.rgsystem.output.OutputFactory;
import com.rgsystem.output.Outputs;
import com.rgsystem.report.*;

public class ReportGeneratorApp {
    //database and connection
    private final DBConnection connection;
    private final Database database;
    private final Inputs inputs;

    public ReportGeneratorApp(DBConnection connection, Database database, Inputs inputs){
        this.connection = connection;
        this.database = database;
        this.inputs = inputs;
    }

    public void execute(){
        try{
            //connect to the database
            database.connect(connection.getConnection());

            Period period = new Period(
                    this.inputs.getStartDate(),
                    this.inputs.getEndDate()
            );

            ReportFactory factory = new ReportFactory(this.database, period);
            String reportType = inputs.getReportType();
            Report report = factory.getInstance(reportType);

            //get instance from output factory
            String to = inputs.getUserEmail();
            OutputFactory outputFactory = new OutputFactory(report, period, to);

            String outputType = inputs.getOutputFormat();
            Outputs output = outputFactory.getInstance(outputType);

            //launch the action
            output.launch();

        }catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (InvalidInputException e) {
            e.printStackTrace();
        }
    }
}
