package com.rgsystem.report.reports;

import com.rgsystem.database.Database;
import com.rgsystem.report.results.DailyReportResult;
import com.rgsystem.report.Period;
import com.rgsystem.report.Report;
import com.rgsystem.report.ReportResult;

public class DailySalesReport implements Report {
    Database database;
    Period period;

    public DailySalesReport(Database database, Period period){
        this.database = database;
        this.period = period;
    }

    @Override
    public ReportResult getReport() throws Exception{
        ReportResult result;
        try{
            String query = "SELECT * FROM orders";
            result = new DailyReportResult(
                database.executeQuery(query)
            );
        }catch(Exception e){
            throw new ReportGenerationFailedException(e.getMessage());
        }

        return result;
    }
}
