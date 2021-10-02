package com.rgsystem.report;

import com.rgsystem.report.results.NullReportException;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

public interface ReportResult {
    void setSummaryReportHeaders(List<String> headers);
    List<String> getSummaryReportHeaders();
    void setSummaryData(List<Map<String, String>> data);
    List<Map<String, String>> getSummaryData();

}
