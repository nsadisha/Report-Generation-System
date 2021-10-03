package com.rgsystem.excelsheet.cellformat;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public interface DateFormat {

    CellStyle formatDateCell(XSSFWorkbook workbook, CellStyle newCellStyle);

}
