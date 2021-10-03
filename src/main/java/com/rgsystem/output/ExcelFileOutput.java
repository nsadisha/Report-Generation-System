package com.rgsystem.output;

import com.rgsystem.excelsheet.*;
import com.rgsystem.excelsheet.cellformat.*;
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

    public XSSFWorkbook getWorkBook(ResultSet summaryReport, ResultSet fullReport, String reportTitle) throws ExcelSheetGenerationFailedException{
        try {
            //writing sheet header line
            CellFormat sheetHeaderFormat = new SheetHeaderFormat();
            ExcelSheet excelSheetHeader = new ExcelSheetHeader(summaryReport, sheet, workbook, sheetHeaderFormat);
            excelSheetHeader.writeLines(reportTitle);

            //-------------------Writing summary report-------------------
            //writing table title
            CellFormat tableTitleFormat = new TableTitlteFormat();
            ExcelSheet summaryReportTableTitle = new ExcelSheetTableTitle(summaryReport, sheet, workbook, tableTitleFormat);
            summaryReportTableTitle.writeLines("Summary Report");

            //writing table header
            CellFormat tableHeaderFormat = new TableHeaderFormat();
            ExcelSheet summaryReportTableHeader = new ExcelSheetTableHeader(summaryReport, sheet, workbook, tableHeaderFormat);
            summaryReportTableHeader.writeLines();

            //writing table data
            CellFormat tableCellFormat = new TableCellFormat();
            ExcelSheet summaryReportTableData = new ExcelSheetTableData(summaryReport, sheet, workbook, tableCellFormat);
            summaryReportTableData.writeLines();

            //-------------------Writing full report-------------------
            //writing table title
            ExcelSheet fullReportTableTitle = new ExcelSheetTableTitle(summaryReport, sheet, workbook, tableTitleFormat);
            fullReportTableTitle.writeLines("Detailed Report");

            //writing table header
            ExcelSheet fullReportTableHeader = new ExcelSheetTableHeader(fullReport, sheet, workbook, tableHeaderFormat);
            fullReportTableHeader.writeLines();

            //writing table data
            ExcelSheet fullReportTableData = new ExcelSheetTableData(fullReport, sheet, workbook, tableCellFormat);
            fullReportTableData.writeLines();

        }catch (Exception e){
            throw new ExcelSheetGenerationFailedException("Excel file generation failed: "+e.getMessage());
        }

        return this.workbook;
    }
}
