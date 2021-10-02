package com.rgsystem.excelsheet;

import com.rgsystem.excelsheet.cellformat.CellFormat;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class ExcelSheet {

    protected ResultSet result;
    protected XSSFSheet sheet;
    protected XSSFWorkbook workbook;
    protected CellFormat format;

    protected ExcelSheet(ResultSet result, XSSFSheet sheet, XSSFWorkbook workbook,CellFormat format){

        this.result = result;
        this.sheet = sheet;
        this.workbook = workbook;
        this.format = format;
    }

    public void writeLines() throws SQLException {

    }

    public void writeLines(String title) throws SQLException {
    }
}
