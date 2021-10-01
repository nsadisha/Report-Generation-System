package com.rgsystem.report;

import com.rgsystem.report.reports.ReportGenerationFailedException;

public interface Report {
    ReportResult getReport() throws ReportGenerationFailedException;
}
