package com.rgsystem.report.excelsheet;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.sql.ResultSet;

public class ExcelSheetHeader extends ExcelSheet{


    public ExcelSheetHeader(ResultSet result, XSSFSheet sheet, XSSFWorkbook workbook) {
        super(result, sheet, workbook);
    }

    @Override
    public void writeLines() {

        Row headerRow = super.sheet.createRow(0);

        CellRangeAddress cellMerge = new CellRangeAddress(0,1,0,5);
        super.sheet.addMergedRegion(cellMerge);

        Cell headerCell = headerRow.createCell(0);
        headerCell.setCellValue("Daily Sales Report");

    }
}
