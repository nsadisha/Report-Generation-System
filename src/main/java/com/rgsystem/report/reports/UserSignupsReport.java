package com.rgsystem.report.reports;

import com.rgsystem.database.Database;
import com.rgsystem.report.Period;
import com.rgsystem.report.Report;
import com.rgsystem.report.results.ReportResult;

public class UserSignupsReport implements Report {
    Database database;
    Period period;
    String reportTitle;

    public UserSignupsReport(Database database, Period period, String reportTitle){
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
            String query = "SELECT CAST(joined_date as date) 'Date', COUNT(*) 'New Users' " +
                    "FROM users " +
                    "WHERE joined_date BETWEEN '"+startDate+"' AND '"+endDate+"' " +
                    "GROUP BY CAST(joined_date as date) " +
                    "ORDER BY joined_date DESC";

            //Report result
            result = new ReportResult(
                    database.executeQuery(query)
            );
        }catch(Exception e){
            throw new ReportGenerationFailedException("Summery report generation failed for user signups: "+e.getMessage());
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
            String query = "SELECT CAST(U.joined_date as date) 'Joined date', U.email 'Email', " +
                    "CONCAT(fname,' ',lname) 'Name', contact 'Contact number', " +
                    "CONCAT(A.line1,', ',A.line2,', ',A.city,'.') 'Address', A.province 'Province', A.zip 'Zip Code' " +
                    "FROM users U JOIN user_addresses A ON U.email = A.email " +
                    "WHERE U.joined_date BETWEEN '"+startDate+"' AND '"+endDate+"' " +
                    "ORDER BY U.joined_date DESC";

            //Report result
            result = new ReportResult(
                    database.executeQuery(query)
            );
        }catch(Exception e){
            throw new ReportGenerationFailedException("Full report generation failed: "+e.getMessage());
        }

        return result;
    }

    @Override
    public String getReportTitle() throws Exception {
        return reportTitle;
    }
}
