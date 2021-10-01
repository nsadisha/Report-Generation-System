package com.rgsystem.report;

import java.sql.ResultSet;

public interface Report {
    ReportResult getReport() throws Exception;
}
