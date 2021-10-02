package com.rgsystem.excelsheet.cellformat;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TableTitlteFormat implements CellFormat{
    @Override
    public CellStyle formatCell(XSSFWorkbook workbook, Cell cell) {

        CellStyle newCellStyle = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontName("Calibri");
        font.setFontHeightInPoints((short)16);
        font.setBold(true);
        newCellStyle.setFont(font);
        newCellStyle.setWrapText(true);
        newCellStyle.setLocked(true);
        return newCellStyle;

    }
}
