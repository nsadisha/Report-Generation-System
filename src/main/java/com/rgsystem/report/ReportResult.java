package com.rgsystem.report;

import com.rgsystem.report.results.NullReportException;

import java.sql.ResultSet;

public interface ReportResult {
    ResultSet getResult() throws NullReportException;
}
