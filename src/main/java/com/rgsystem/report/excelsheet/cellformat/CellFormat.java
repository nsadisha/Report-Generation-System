package com.rgsystem.report.excelsheet.cellformat;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public interface CellFormat {

    void formatCell(XSSFWorkbook workbook, Cell cell);

}
