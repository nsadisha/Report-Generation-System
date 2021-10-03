package com.rgsystem.excelsheet.cellformat;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TableCellFormat implements CellFormat{
    @Override
    public CellStyle formatCell(XSSFWorkbook workbook, Cell cell) {

        CellStyle newCellStyle = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontName("Calibri");
        font.setFontHeightInPoints((short)14);
        font.setColor(HSSFColor.HSSFColorPredefined.DARK_BLUE.getIndex());
        newCellStyle.setAlignment(HorizontalAlignment.RIGHT);
        newCellStyle.setFont(font);
        newCellStyle.setWrapText(true);
        newCellStyle.setLocked(true);
        newCellStyle.setBorderBottom(BorderStyle.THIN);
        newCellStyle.setBorderLeft(BorderStyle.THIN);
        newCellStyle.setBorderTop(BorderStyle.THIN);
        newCellStyle.setBorderRight(BorderStyle.THIN);
        newCellStyle.setBottomBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
        newCellStyle.setTopBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
        newCellStyle.setLeftBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
        newCellStyle.setRightBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());

        return newCellStyle;

    }
}
