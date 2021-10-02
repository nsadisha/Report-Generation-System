package com.rgsystem.output;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;

public class WorkBookWriter {
    XSSFWorkbook workbook;

    public WorkBookWriter(XSSFWorkbook workbook){
        this.workbook = workbook;
    }

    public void save(String path) throws FileWriteFailedException {
        try{
            FileOutputStream outputStream = new FileOutputStream(path);
            this.workbook.write(outputStream);
            this.workbook.close();
        }catch(Exception e){
            throw new FileWriteFailedException("Excel file writing failed: "+e.getMessage());
        }
    }
}
