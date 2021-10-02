package com.rgsystem.excelsheet;

import com.rgsystem.excelsheet.cellformat.CellFormat;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ExcelSheetTableHeader extends ExcelSheet{


    public ExcelSheetTableHeader(ResultSet result, XSSFSheet sheet, XSSFWorkbook workbook, CellFormat format) {
        super(result, sheet, workbook,format);
    }

    @Override
    public void writeLines() throws SQLException {

        // write header line containing column names
        ResultSetMetaData metaData = super.result.getMetaData();

        int numberOfColumns = metaData.getColumnCount();
        int numberOfRows = sheet.getPhysicalNumberOfRows();

        Row headerRow = super.sheet.createRow(numberOfRows+3);

        // exclude the first column which is the ID field
        for (int i = 1; i <= numberOfColumns; i++) {
            String columnName = metaData.getColumnName(i);
            Cell headerCell = headerRow.createCell(i-1);
            headerCell.setCellValue(columnName);
            headerCell.setCellStyle(this.format.formatCell(workbook, headerCell));
            super.sheet.autoSizeColumn(i-1);
        }

    }

}
