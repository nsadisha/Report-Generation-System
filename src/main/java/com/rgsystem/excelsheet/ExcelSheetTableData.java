package com.rgsystem.excelsheet;

import com.rgsystem.excelsheet.cellformat.CellFormat;
import com.rgsystem.excelsheet.cellformat.DateCellFormat;
import com.rgsystem.excelsheet.cellformat.DateFormat;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.sql.*;

public class ExcelSheetTableData extends ExcelSheet{

    public ExcelSheetTableData(ResultSet result, XSSFSheet sheet, XSSFWorkbook workbook, CellFormat format) {
        super(result, sheet, workbook, format);
    }

    @Override
    public void writeLines() throws SQLException {

        ResultSetMetaData metaData = super.result.getMetaData();
        int numberOfColumns = metaData.getColumnCount();
        int numberOfRows = sheet.getLastRowNum();
        int rowCount = numberOfRows+1;

        while (super.result.next()) {
            Row row = super.sheet.createRow(rowCount++);

            for (int i = 1; i <= numberOfColumns; i++) {
                Object valueObject = super.result.getObject(i);

                Cell cell = row.createCell(i - 1);

                if (valueObject instanceof Boolean) {
                    cell.setCellValue((Boolean) valueObject);
                    cell.setCellStyle(this.format.formatCell(workbook, cell));

                }
                else if (valueObject instanceof Double) {
                    cell.setCellValue((double) valueObject);
                    cell.setCellStyle(this.format.formatCell(workbook, cell));

                }
                else if (valueObject instanceof Long) {
                    cell.setCellValue((long) valueObject);
                    cell.setCellStyle(this.format.formatCell(workbook, cell));

                }
                else if (valueObject instanceof Float) {
                    cell.setCellValue((float) valueObject);
                    cell.setCellStyle(this.format.formatCell(workbook, cell));

                }
                else if (valueObject instanceof Date) {
                    DateFormat dateCellFormat = new DateCellFormat();
                    cell.setCellValue((Date) valueObject);
                    cell.setCellStyle(dateCellFormat.formatDateCell(workbook, this.format.formatCell(workbook, cell)));
                }
                else {
                    cell.setCellValue((String) valueObject);
                    cell.setCellStyle(this.format.formatCell(workbook, cell));
                }

                super.sheet.autoSizeColumn(i-1);

            }
        }
    }

}
