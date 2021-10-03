package com.rgsystem.output;

import com.rgsystem.output.outputs.EmailOutput;
import com.rgsystem.output.outputs.FileOutput;
import com.rgsystem.report.Period;
import com.rgsystem.report.Report;
import com.rgsystem.report.results.ReportResult;
import java.sql.ResultSet;

public class OutputFactory {
    String reportTitle;
    Period period;
    String to;
    ReportResult summaryReportResult;
    ReportResult fullReportResults;

    //final results
    ResultSet summaryReport;
    ResultSet fullReport;

    public OutputFactory(Report report, Period period, String to) throws Exception{
        this.reportTitle = report.getReportTitle();
        this.summaryReportResult = report.getSummaryReport();
        this.fullReportResults = report.getFullReport();

        //store final results
        this.summaryReport = this.summaryReportResult.getResult();
        this.fullReport = this.fullReportResults.getResult();

        this.to = to;
        this.period = period;
    }

    public Outputs getInstance(String type){
        Outputs output = null;
        if (type.equals("file")){
            output = new FileOutput(this.summaryReport, this.fullReport, this.reportTitle);
        }else if(type.equals("email")){
            output = new EmailOutput(this.summaryReport, this.fullReport, this.to, this.period, this.reportTitle);
        }

        return output;
    }
}
