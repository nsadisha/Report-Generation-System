package com.rgsystem.output.outputs;

import com.rgsystem.emails.Attachment;
import com.rgsystem.emails.Email;
import com.rgsystem.emails.EmailSender;
import com.rgsystem.output.ExcelFileOutput;
import com.rgsystem.output.Outputs;
import com.rgsystem.output.WorkBookWriter;
import com.rgsystem.report.EmailBody;
import com.rgsystem.report.EmailBodyGenerator;
import com.rgsystem.report.Period;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.sql.ResultSet;

public class EmailOutput implements Outputs {
    ResultSet summaryReport;
    ResultSet fullReport;
    Period period;
    String to;
    String title;
    public EmailOutput(ResultSet summaryReport, ResultSet fullReport, String to, Period period, String title){
        this.summaryReport  = summaryReport;
        this.fullReport = fullReport;
        this.to = to;
        this.period = period;
        this.title = title;
    }

    public void launch() throws LaunchFailException{
        try{
            //generate excel sheet
            String fileName = "report.xlsx";
            ExcelFileOutput output = new ExcelFileOutput(this.title);
            XSSFWorkbook workBook = output.getWorkBook(this.summaryReport, this.fullReport, this.title);

            WorkBookWriter writer = new WorkBookWriter(workBook);
            //file path
            writer.save(fileName);

            //sending the email
            String startingMonth = this.period.getStartDate();
            String endingMonth = this.period.getEndDate();
            String receiverAddress=this.to;

            EmailBodyGenerator emailBodyGenerator = new EmailBodyGenerator();
            EmailBody emailBody = emailBodyGenerator.generateEmailBody(startingMonth, endingMonth, fileName);

            EmailSender emailSender = new EmailSender();
            Email email = new Email();
            email.setSubject(emailBody.getSubject());
            email.setToAddress(receiverAddress);
            email.setAttachment(emailBody.getData());

            Attachment attachment = new Attachment();
            attachment.setAttachment(emailBody.getData());

            emailSender.send(email);
        }catch (Exception e){
            throw new LaunchFailException("Sending email launch failed: "+e.getMessage());
        }
    }
}
