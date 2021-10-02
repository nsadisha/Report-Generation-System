package com.rgsystem.report;

import com.rgsystem.report.results.ReportResult;

public interface Report {
    ReportResult getSummaryReport() throws Exception;
    ReportResult getFullReport() throws Exception;
}
