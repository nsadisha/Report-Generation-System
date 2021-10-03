package com.rgsystem.report.reports;

import com.rgsystem.database.Database;
import com.rgsystem.report.results.ReportResult;
import com.rgsystem.report.Period;
import com.rgsystem.report.Report;

public class DailySalesReport implements Report {
    Database database;
    Period period;
    String reportTitle;

    public DailySalesReport(Database database, Period period, String reportTitle){
        this.database = database;
        this.period = period;
        this.reportTitle = reportTitle;
    }

    @Override
    public ReportResult getSummaryReport() throws Exception{
        ReportResult result;
        try{
            //getting start date and end date as strings
            String startDate = this.period.getStartDate();
            String endDate = this.period.getEndDate();
            //SQL query to execute
            String query = "SELECT CAST(date as date) 'Date', COUNT(*) 'Transactions', SUM(total_price) 'Net Sales' " +
                    "FROM orders " +
                    "WHERE date BETWEEN '"+startDate+"' AND '"+endDate+"' " +
                    "GROUP BY CAST(date as date) " +
                    "ORDER BY date DESC";

            //Report result
            result = new ReportResult(
                database.executeQuery(query)
            );
        }catch(Exception e){
            throw new ReportGenerationFailedException("Summery report generation failed: "+e.getMessage());
        }

        return result;
    }

    @Override
    public ReportResult getFullReport() throws Exception {
        ReportResult result;
        try{
            //getting start date and end date as strings
            String startDate = this.period.getStartDate();
            String endDate = this.period.getEndDate();
            //SQL query to execute
            String query = "SELECT CAST(date as date) 'Date', order_id 'Order ID', email 'Email', " +
                    "total_price 'Total Revenue', status 'Status' " +
                    "FROM orders " +
                    "WHERE date BETWEEN '"+startDate+"' AND '"+endDate+"' " +
                    "ORDER BY date DESC";

            //Report result
            result = new ReportResult(
                    database.executeQuery(query)
            );
        }catch(Exception e){
            throw new ReportGenerationFailedException("Summery report generation failed: "+e.getMessage());
        }

        return result;
    }

    @Override
    public String getReportTitle() throws Exception {
        return reportTitle;
    }
}
