package com.rgsystem;

import com.rgsystem.connection.DBConnection;
import com.rgsystem.database.Database;
import com.rgsystem.input.Inputs;
import com.rgsystem.report.Period;
import com.rgsystem.report.Report;
import com.rgsystem.report.ReportFactory;
import com.rgsystem.report.ReportResult;

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

    public void start(){

        try {
            this.database.connect(this.connection.getConnection());
            ReportFactory factory = new ReportFactory(this.database, this.period);
            Report report = factory.getInstance("daily-report");
            ReportResult reportResult = report.getReport();

            //test
//            while (reportResult.getResult().next()){
//                System.out.println(reportResult.getResult().getString("total_price"));
//            }
        } catch (Exception e) {
            System.out.println("Exception from app: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
