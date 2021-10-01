package com.rgsystem.report.results;

import com.rgsystem.report.ReportResult;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DailyReportResult implements ReportResult {
    ResultSet result;

    public DailyReportResult(ResultSet result) {
        this.result = result;
    }

    public void print() throws SQLException {
        while (this.result.next()){
            System.out.println(this.result.getString("total_price"));
        }
    }
}
