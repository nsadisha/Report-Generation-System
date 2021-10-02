package com.rgsystem.report.excelsheet;

import com.rgsystem.report.excelsheet.cellformat.CellFormat;
import com.rgsystem.report.excelsheet.cellformat.DateCellFormat;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.sql.*;

public class ExcelSheetTableData extends ExcelSheet{

    public ExcelSheetTableData(ResultSet result, XSSFSheet sheet, XSSFWorkbook workbook) {
        super(result, sheet, workbook);
    }

    @Override
    public void writeLines() throws SQLException {

        ResultSetMetaData metaData = super.result.getMetaData();
        int numberOfColumns = metaData.getColumnCount();

        int rowCount = 3;

        while (super.result.next()) {
            Row row = super.sheet.createRow(rowCount++);

            for (int i = 1; i <= numberOfColumns; i++) {
                Object valueObject = super.result.getObject(i);

                Cell cell = row.createCell(i - 1);

                if (valueObject instanceof Boolean) {
                    cell.setCellValue((Boolean) valueObject);
                }
                else if (valueObject instanceof Double) {
                    cell.setCellValue((double) valueObject);
                }
                else if (valueObject instanceof Float) {
                    cell.setCellValue((float) valueObject);
                }
                else if (valueObject instanceof Timestamp) {
                    CellFormat dateCellFormat = new DateCellFormat();
                    dateCellFormat.formatCell(workbook, cell);
                    cell.setCellValue((Timestamp) valueObject);
                }
                else {
                    cell.setCellValue((String) valueObject);
                }
            }
        }
    }

}
