package com.rgsystem.report.results;

import java.sql.ResultSet;

public class ReportResult {
    ResultSet result;

    public ReportResult(ResultSet result) {
        this.result = result;
    }

    public ResultSet getResult() throws NullReportException {
        if(this.result == null){
            throw new NullReportException("");
        }
        return this.result;
    }
}
