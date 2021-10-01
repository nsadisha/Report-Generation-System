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
import com.rgsystem.report.results.NullReportException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.sql.SQLException;


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


        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Daily Sales");

        writeHeaderLine(sheet);

        writeDataLines(res, workbook, sheet);

        FileOutputStream outputStream = new FileOutputStream(excelFilePath);
        workbook.write(outputStream);
        workbook.close();


    }

    private static void writeHeaderLine(XSSFSheet sheet) {

        Row headerRow = sheet.createRow(0);

        Cell headerCell = headerRow.createCell(0);
        headerCell.setCellValue("Order Id");

        headerCell = headerRow.createCell(1);
        headerCell.setCellValue("User Email");

        headerCell = headerRow.createCell(2);
        headerCell.setCellValue("Date");

        headerCell = headerRow.createCell(3);
        headerCell.setCellValue("Total Price");

        headerCell = headerRow.createCell(4);
        headerCell.setCellValue("Note");

        headerCell = headerRow.createCell(5);
        headerCell.setCellValue("Status");

    }


    private static void writeDataLines(ReportResult result, XSSFWorkbook workbook,
                                XSSFSheet sheet) throws SQLException, NullReportException {
        int rowCount = 1;
        System.out.println(result.getResult().next());
        while (result.getResult().next()) {


            String orderID = result.getResult().getString("order_id");
            String email = result.getResult().getString("email");
            String date = result.getResult().getString("date");
            Double price = result.getResult().getDouble("total_price");
            String note = result.getResult().getString("note");
            String status = result.getResult().getString("status");

            Row row = sheet.createRow(rowCount++);

            int columnCount = 0;
            Cell cell = row.createCell(columnCount++);
            cell.setCellValue(orderID);

            cell = row.createCell(columnCount++);
            cell.setCellValue(email);

            cell = row.createCell(columnCount++);

            CellStyle cellStyle = workbook.createCellStyle();
            CreationHelper creationHelper = workbook.getCreationHelper();
            cellStyle.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy-MM-dd HH:mm:ss"));
            cell.setCellStyle(cellStyle);

            cell.setCellValue(date);

            cell = row.createCell(columnCount++);
            cell.setCellValue(price);

            cell = row.createCell(columnCount++);
            cell.setCellValue(note);

            cell = row.createCell(columnCount);
            cell.setCellValue(status);
        }
    }

}