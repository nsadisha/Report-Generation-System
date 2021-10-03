package com.rgsystem.excelsheet.cellformat;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SheetHeaderFormat implements CellFormat{
    @Override
    public CellStyle formatCell(XSSFWorkbook workbook, Cell cell) {

        CellStyle newCellStyle = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontName("Georgia");
        font.setFontHeightInPoints((short)20);
        font.setBold(true);
        font.setColor(HSSFColor.HSSFColorPredefined.DARK_BLUE.getIndex());
        newCellStyle.setAlignment(HorizontalAlignment.CENTER);
        newCellStyle.setFont(font);
        newCellStyle.setWrapText(true);
        newCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        newCellStyle.setAlignment(HorizontalAlignment.CENTER);
        newCellStyle.setLocked(true);
        newCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        newCellStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        newCellStyle.setBorderBottom(BorderStyle.THIN);
        newCellStyle.setBorderLeft(BorderStyle.THIN);
        return newCellStyle;
    }
}
