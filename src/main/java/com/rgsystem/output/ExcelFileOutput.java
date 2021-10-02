package com.rgsystem.output;

import com.rgsystem.excelsheet.ExcelSheet;
import com.rgsystem.excelsheet.ExcelSheetHeader;
import com.rgsystem.excelsheet.ExcelSheetTableData;
import com.rgsystem.excelsheet.ExcelSheetTableHeader;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.sql.ResultSet;

public class ExcelFileOutput implements Outputs{

    XSSFWorkbook workbook;
    XSSFSheet sheet;

    public ExcelFileOutput(String name){
        this.workbook = new XSSFWorkbook();
        this.sheet = workbook.createSheet(name);
    }

    public XSSFWorkbook getWorkBook(ResultSet summaryReport, ResultSet fullReport) throws ExcelSheetGenerationFailedException{
        try {
            //writing sheet header line
            ExcelSheet excelSheetHeader = new ExcelSheetHeader(summaryReport, sheet, workbook);
            excelSheetHeader.writeLines();

            //-------------------Writing summary report-------------------
            //writing table header
            ExcelSheet summaryReportTableHeader = new ExcelSheetTableHeader(summaryReport, sheet, workbook);
            summaryReportTableHeader.writeLines();

            //writing table data
            ExcelSheet summaryReportTableData = new ExcelSheetTableData(summaryReport, sheet, workbook);
            summaryReportTableData.writeLines();

            //-------------------Writing full report-------------------
            //writing table header
            ExcelSheet fullReportTableHeader = new ExcelSheetTableHeader(fullReport, sheet, workbook);
            fullReportTableHeader.writeLines();

            //writing table data
            ExcelSheet fullReportTableData = new ExcelSheetTableData(fullReport, sheet, workbook);
            fullReportTableData.writeLines();

        }catch (Exception e){
            throw new ExcelSheetGenerationFailedException("Excel file generation failed: "+e.getMessage());
        }

        return this.workbook;
    }
}
