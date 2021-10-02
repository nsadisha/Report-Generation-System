package com.rgsystem.report.reports;

import com.rgsystem.database.Database;
import com.rgsystem.report.results.DailySalesResult;
import com.rgsystem.report.Period;
import com.rgsystem.report.Report;
import com.rgsystem.report.ReportResult;

import java.sql.ResultSet;
import java.util.*;

public class DailySalesReport implements Report {
    Database database;
    Period period;

    public DailySalesReport(Database database, Period period){
        this.database = database;
        this.period = period;
    }

    @Override
    public ReportResult getReport() throws ReportGenerationFailedException{
        ReportResult result;
        try{
            //getting start date and end date as strings
            //String startDate = this.period.getStartDate();
            //String endDate = this.period.getEndDate();
            //SQL query to execute
            //String query = "SELECT * FROM orders WHERE" +
              //      " date BETWEEN'" +startDate+ "' AND '" +endDate+ "' ORDER BY date ASC";

            //Report result
            result = new DailySalesResult(
//                database.executeQuery(query)
            );
        }catch(Exception e){
            throw new ReportGenerationFailedException("Report generation failed");
        }

        return result;
    }

    @Override
    public ReportResult getSummaryReport() throws ReportGenerationFailedException{
        ReportResult dailySalesResult = new DailySalesResult();
        //setting report headers
        final List<String> headers = Arrays.asList("Date", "Transactions", "Net sales");
        dailySalesResult.setSummaryReportHeaders(headers);

        //setting summary report data
        List<Map<String, String>> data = new ArrayList<>();

        try {
            //getting start date and end date as strings
            String startDate = this.period.getStartDate();
            String endDate = this.period.getEndDate();
            //SQL query to execute
            String query = "SELECT CAST(date as date) date, COUNT(8) transactions, SUM(total_price) net_sales " +
                    "FROM orders " +
                    "WHERE date BETWEEN '"+startDate+"' AND '"+endDate+"' " +
                    "GROUP BY CAST(date as date)";
            ResultSet resultSet = database.executeQuery(query);

            //adding data to the Map object
            while (resultSet.next()){
                Map<String, String> temp = new HashMap<>();
                //get temp values
                temp.put("Date", resultSet.getString("date"));
                temp.put("Transactions", resultSet.getString("transactions"));
                temp.put("Net sales", resultSet.getString("net_sales"));

                //add item to the data list
                data.add(temp);
            }
            dailySalesResult.setSummaryData(data);

        }catch(Exception e){
            throw new ReportGenerationFailedException("Summary report generation failed: "+e.getMessage());
        }

        return dailySalesResult;
    }
}
