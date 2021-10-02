package com.rgsystem.report.excelsheet;

import com.rgsystem.report.ReportResult;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExcelSheet {

    protected ResultSet result;
    protected XSSFSheet sheet;
    protected XSSFWorkbook workbook;

    protected ExcelSheet(ResultSet result, XSSFSheet sheet, XSSFWorkbook workbook){

        this.result = result;
        this.sheet = sheet;
        this.workbook = workbook;
    }

    public void writeLines() throws SQLException {

    }

}
