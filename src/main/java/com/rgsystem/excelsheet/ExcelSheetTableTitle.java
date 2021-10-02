package com.rgsystem.excelsheet;

import com.rgsystem.excelsheet.cellformat.CellFormat;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ExcelSheetTableTitle extends ExcelSheet{

    public ExcelSheetTableTitle(ResultSet result, XSSFSheet sheet, XSSFWorkbook workbook, CellFormat format) {
        super(result, sheet, workbook, format);
    }

    public void writeLines(String title) throws SQLException {

        // write header line containing column names
        ResultSetMetaData metaData = super.result.getMetaData();

        int numberOfColumns = metaData.getColumnCount();
        int numberOfRows = sheet.getLastRowNum() + 2;

        Row headerRow = super.sheet.createRow(numberOfRows);

        CellRangeAddress cellMerge = new CellRangeAddress(numberOfRows,numberOfRows,0,numberOfColumns-1);
        super.sheet.addMergedRegion(cellMerge);

        Cell headerCell = headerRow.createCell(0);
        headerCell.setCellValue(title);
        headerCell.setCellStyle(this.format.formatCell(workbook, headerCell));
        super.sheet.autoSizeColumn(0);

    }
}
