package com.rgsystem.excelsheet;

import com.rgsystem.excelsheet.cellformat.CellFormat;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.sql.ResultSet;

public class ExcelSheetHeader extends ExcelSheet{

    public ExcelSheetHeader(ResultSet result, XSSFSheet sheet, XSSFWorkbook workbook, CellFormat format) {
        super(result, sheet, workbook, format);
    }

    @Override
    public void writeLines() {

        Row headerRow = super.sheet.createRow(0);

        CellRangeAddress cellMerge = new CellRangeAddress(0,2,0,8);
        super.sheet.addMergedRegion(cellMerge);

        Cell headerCell = headerRow.createCell(0);

        headerCell.setCellValue("Daily Sales Report");
        headerCell.setCellStyle(this.format.formatCell(workbook, headerCell));

    }
}
