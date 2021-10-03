package com.rgsystem.output.outputs;

import com.rgsystem.output.ExcelFileOutput;
import com.rgsystem.output.Outputs;
import com.rgsystem.output.WorkBookWriter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.sql.ResultSet;

public class FileOutput implements Outputs {
    ResultSet summaryReport;
    ResultSet fullReport;
    String title;
    final String to = "report.xlsx";

    public FileOutput(ResultSet summaryReport, ResultSet fullReport, String title){
        this.summaryReport  = summaryReport;
        this.fullReport = fullReport;
        this.title = title;
    }

    public void launch() throws LaunchFailException{
        try{
            ExcelFileOutput output = new ExcelFileOutput(this.title);
            XSSFWorkbook workBook = output.getWorkBook(this.summaryReport, this.fullReport, this.title);

            WorkBookWriter writer = new WorkBookWriter(workBook);
            //file path
            writer.save(this.to);
        }catch (Exception e){
            throw new LaunchFailException("File output launch failed: "+e.getMessage());
        }
    }
}
