package com.rgsystem.excelsheet.cellformat;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public interface CellFormat {

    CellStyle formatCell(XSSFWorkbook workbook, Cell cell);

}
