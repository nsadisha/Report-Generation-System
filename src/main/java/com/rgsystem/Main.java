package com.rgsystem;

import com.rgsystem.connection.DBConnection;
import com.rgsystem.connection.SQLConnection;
import com.rgsystem.database.Database;
import com.rgsystem.database.SQLDatabase;
import com.rgsystem.excelsheet.*;
import com.rgsystem.excelsheet.cellformat.*;
import com.rgsystem.input.Inputs;
import com.rgsystem.report.Period;
import com.rgsystem.report.Report;
import com.rgsystem.report.ReportFactory;
import com.rgsystem.input.CommandLineInputs;
import com.rgsystem.report.results.ReportResult;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.sql.ResultSet;



public class Main {
    public static void main(String[] args) throws Exception{

        String excelFilePath = "Daily-Sales.xlsx";

        DBConnection connection = new SQLConnection(
                "jdbc:mysql://localhost:3306/bookbae",
                "root",
                ""
        );

        Database database = new SQLDatabase();
        Inputs inputs = new CommandLineInputs(args);
        ReportGeneratorApp app = new ReportGeneratorApp(connection, database, inputs);

        //start the app
        app.execute();

        Period period = new Period("2021-09-20", "2021-10-30");
        ReportFactory reportFactory = new ReportFactory(database, period);
        Report report = reportFactory.getInstance("daily-sales");

        ReportResult res = report.getSummaryReport();
        ResultSet result = res.getResult();

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Daily Sales");

        CellFormat sheetHeaderFormat = new SheetHeaderFormat();
        ExcelSheet excelSheetHeader = new ExcelSheetHeader(result, sheet, workbook, sheetHeaderFormat);
        excelSheetHeader.writeLines();

        CellFormat tableTitleFormat = new TableTitlteFormat();
        ExcelSheet excelSheetTableTitle = new ExcelSheetTableTitle(result, sheet, workbook,tableTitleFormat);
        excelSheetTableTitle.writeLines();

        CellFormat tableHeaderFormat = new TableHeaderFormat();
        ExcelSheet excelSheetTableHeader = new ExcelSheetTableHeader(result, sheet, workbook,tableHeaderFormat);
        excelSheetTableHeader.writeLines();

        CellFormat tableCellFormat = new TableCellFormat();
        ExcelSheet excelSheetTableData = new ExcelSheetTableData(result, sheet, workbook,tableCellFormat);
        excelSheetTableData.writeLines();

        FileOutputStream outputStream = new FileOutputStream(excelFilePath);
        workbook.write(outputStream);
        workbook.close();

    }
}