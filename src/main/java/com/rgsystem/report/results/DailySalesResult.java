package com.rgsystem.report.results;

import com.rgsystem.report.ReportResult;
import java.sql.ResultSet;

public class DailySalesResult implements ReportResult {
    ResultSet result;

    public DailySalesResult(ResultSet result) {
        this.result = result;
    }

    public ResultSet getResult() throws NullReportException {
        if(this.result == null){
            throw new NullReportException("Result from the report is null");
        }
        return this.result;
    }
}
