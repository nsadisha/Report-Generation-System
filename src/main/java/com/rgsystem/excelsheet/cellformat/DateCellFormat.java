package com.rgsystem.excelsheet.cellformat;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DateCellFormat implements CellFormat{


    @Override
    public CellStyle formatCell(XSSFWorkbook workbook, Cell cell) {

        CellStyle cellStyle = workbook.createCellStyle();
        CreationHelper creationHelper = workbook.getCreationHelper();
        cellStyle.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy-MM-dd"));
        cell.setCellStyle(cellStyle);

        return cellStyle;
    }

}
