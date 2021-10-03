package com.rgsystem.excelsheet.cellformat;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DateCellFormat implements DateFormat{

    public CellStyle formatDateCell(XSSFWorkbook workbook, CellStyle newCellStyle) {

        CreationHelper creationHelper = workbook.getCreationHelper();
        newCellStyle.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy-MM-dd"));
        return newCellStyle;
    }

}
