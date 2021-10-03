package com.rgsystem.excelsheet.cellformat;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TableHeaderFormat implements CellFormat{
    @Override
    public CellStyle formatCell(XSSFWorkbook workbook, Cell cell) {

        CellStyle newCellStyle = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontName("Calibri");
        font.setFontHeightInPoints((short)14);
        font.setBold(true);
        font.setColor(HSSFColor.HSSFColorPredefined.DARK_BLUE.getIndex());
        newCellStyle.setAlignment(HorizontalAlignment.CENTER);
        newCellStyle.setFont(font);
        newCellStyle.setWrapText(true);
        newCellStyle.setLocked(true);
        newCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        newCellStyle.setBorderBottom(BorderStyle.THIN);
        newCellStyle.setBorderLeft(BorderStyle.THIN);
        newCellStyle.setBorderTop(BorderStyle.THIN);
        newCellStyle.setBorderRight(BorderStyle.THIN);
        newCellStyle.setFillForegroundColor(IndexedColors.PALE_BLUE.getIndex());
        newCellStyle.setBottomBorderColor(IndexedColors.DARK_BLUE.getIndex());
        newCellStyle.setTopBorderColor(IndexedColors.DARK_BLUE.getIndex());
        newCellStyle.setLeftBorderColor(IndexedColors.DARK_BLUE.getIndex());
        newCellStyle.setRightBorderColor(IndexedColors.DARK_BLUE.getIndex());

        return newCellStyle;

    }
}
