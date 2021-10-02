package com.rgsystem;

import com.rgsystem.connection.DBConnection;
import com.rgsystem.connection.SQLConnection;
import com.rgsystem.database.Database;
import com.rgsystem.database.SQLDatabase;
import com.rgsystem.input.Inputs;
import com.rgsystem.input.commandlineinputs.*;
import com.rgsystem.report.Period;
import com.rgsystem.report.Report;
import com.rgsystem.report.ReportFactory;
import com.rgsystem.report.ReportResult;
import com.rgsystem.report.excelsheet.ExcelSheet;
import com.rgsystem.report.excelsheet.ExcelSheetHeader;
import com.rgsystem.report.excelsheet.ExcelSheetTableData;
import com.rgsystem.report.excelsheet.ExcelSheetTableHeader;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.sql.ResultSet;



public class Main {
    public static void main(String[] args) throws Exception{

        Inputs type = new ReportTypeInput(args);
        Inputs start = new StartDateInput(args);
        Inputs end = new EndDateInput(args);
        Inputs output = new OutputFormatInput(args);
        Inputs email = new UserMailInput(args);

        String excelFilePath = "Daily-Sales.xlsx";

        DBConnection connection = new SQLConnection(
                "jdbc:mysql://localhost:3306/bookbae",
                "root",
                ""
        );

        Database database = new SQLDatabase(connection.getConnection());
        database.createStatement();

        Period period = new Period("2021-09-20", "2021-10-30");
        ReportFactory reportFactory = new ReportFactory(database, period);
        Report report = reportFactory.getInstance("daily-sales");

        ReportResult res = report.getReport();
        ResultSet result = res.getResult();

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Daily Sales");

        ExcelSheet excelSheetHeader = new ExcelSheetHeader(result, sheet, workbook);
        excelSheetHeader.writeLines();

        ExcelSheet excelSheetTableHeader = new ExcelSheetTableHeader(result, sheet, workbook);
        excelSheetTableHeader.writeLines();

        ExcelSheet excelSheetTableData = new ExcelSheetTableData(result, sheet, workbook);
        excelSheetTableData.writeLines();

        FileOutputStream outputStream = new FileOutputStream(excelFilePath);
        workbook.write(outputStream);
        workbook.close();

    }
}