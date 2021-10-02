package com.rgsystem;

import com.rgsystem.connection.DBConnection;
import com.rgsystem.database.Database;
import com.rgsystem.report.Period;
import com.rgsystem.report.Report;
import com.rgsystem.report.ReportFactory;
import com.rgsystem.report.results.ReportResult;

import java.sql.ResultSet;

public class ReportGeneratorApp {
    //database and connection
    private final DBConnection connection;
    private final Database database;

    //inputs
    private final Period period;

    public ReportGeneratorApp(DBConnection connection, Database database){
        this.connection = connection;
        this.database = database;
        this.period = new Period("2020-10-10", "2021-12-31");
    }

    public void execute(){
        try{
            //connect to the database
            database.connect(connection.getConnection());
            ReportFactory factory = new ReportFactory(this.database, this.period);
            Report report = factory.getInstance("daily-sales");
            ReportResult result = report.getSummaryReport();
            ResultSet rows = result.getResult();
            while (rows.next()){
                System.out.println(
                        rows.getString("date")+"  "+rows.getString("Transactions")+"  "+rows.getString("Net Sales")
                );
            }

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
