package com.rgsystem.report.results;

import com.rgsystem.report.ReportResult;

import java.util.List;
import java.util.Map;

public class DailySalesResult implements ReportResult {
    private List<String> summaryReportHeaders;
    private List<Map<String, String>> summaryData;

    //setter and getter for summary report headers
    public void setSummaryReportHeaders(List<String> headers){
        this.summaryReportHeaders = headers;
    }
    public List<String> getSummaryReportHeaders(){
        return this.summaryReportHeaders;
    }

    //setter and getter for summary data
    public void setSummaryData(List<Map<String, String>> data){
        this.summaryData = data;
    }

    public List<Map<String, String>> getSummaryData(){
        return this.summaryData;
    }

}
