package com.rgsystem;

import com.rgsystem.connection.DBConnection;
import com.rgsystem.connection.SQLConnection;
import com.rgsystem.database.Database;
import com.rgsystem.database.SQLDatabase;
import com.rgsystem.report.Period;
import com.rgsystem.report.Report;
import com.rgsystem.report.ReportFactory;
import com.rgsystem.report.ReportResult;

public class Main {
    public static void main(String[] args) throws Exception {
        Period period = new Period("2010-05-06", "2021-03-05");
        DBConnection connection = new SQLConnection(
                "jdbc:mysql://localhost:3306/bookbae",
                "root",
                ""
        );

        Database database = new SQLDatabase(connection.getConnection());
        database.createStatement();

        ReportFactory reportFactory = new ReportFactory(database, period);
        Report report = reportFactory.getInstance("daily-sales");

        ReportResult res = report.getReport();
        res.print();
    }
}