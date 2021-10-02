package com.rgsystem.excelsheet;

import com.rgsystem.excelsheet.cellformat.CellFormat;
import com.rgsystem.excelsheet.cellformat.DateCellFormat;
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
        int numberOfRows = sheet.getPhysicalNumberOfRows();
        int rowCount = numberOfRows+3;

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
                else if (valueObject instanceof Long) {
                    cell.setCellValue((long) valueObject);
                }
                else if (valueObject instanceof Float) {
                    cell.setCellValue((float) valueObject);
                }
                else if (valueObject instanceof Date) {
                    CellFormat dateCellFormat = new DateCellFormat();
                    dateCellFormat.formatCell(workbook, cell);
                    cell.setCellValue((Date) valueObject);
                }
                else {
                    cell.setCellValue((String) valueObject);
                }
            }
        }
    }

}
