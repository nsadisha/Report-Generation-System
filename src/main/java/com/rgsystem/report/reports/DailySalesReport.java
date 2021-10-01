package com.rgsystem.report.reports;

import com.rgsystem.database.Database;
import com.rgsystem.report.results.DailySalesResult;
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
            //getting start date and end date as strings
            String startDate = this.period.getStartDate();
            String endDate = this.period.getEndDate();
            //SQL query to execute
            String query = "SELECT * FROM orders WHERE" +
                    " date BETWEEN'" +startDate+ "' AND '" +endDate+ "' ORDER BY date ASC";

            //Report result
            result = new DailySalesResult(
                database.executeQuery(query)
            );
        }catch(Exception e){
            throw new ReportGenerationFailedException(e.getMessage());
        }

        return result;
    }
}
