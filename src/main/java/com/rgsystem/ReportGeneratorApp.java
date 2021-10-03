package com.rgsystem;

import com.rgsystem.connection.DBConnection;
import com.rgsystem.database.Database;
import com.rgsystem.emails.Attachment;
import com.rgsystem.emails.Email;
import com.rgsystem.emails.EmailSender;
import com.rgsystem.input.Inputs;
import com.rgsystem.input.InvalidInputException;
import com.rgsystem.output.ExcelFileOutput;
import com.rgsystem.output.WorkBookWriter;
import com.rgsystem.report.*;
import com.rgsystem.report.results.ReportResult;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.sql.ResultSet;

public class ReportGeneratorApp {
    //database and connection
    private final DBConnection connection;
    private final Database database;
    private final Inputs inputs;

    public ReportGeneratorApp(DBConnection connection, Database database, Inputs inputs){
        this.connection = connection;
        this.database = database;
        this.inputs = inputs;
    }

    public void execute(){
        try{
            //connect to the database
            database.connect(connection.getConnection());

            Period period = new Period(
                    this.inputs.getStartDate(),
                    this.inputs.getEndDate()
            );

            ReportFactory factory = new ReportFactory(this.database, period);
            String reportType = inputs.getReportType();
            Report report = factory.getInstance(reportType);
            String reportTitle = report.getReportTitle();

            //Report results
            ReportResult summaryReportResult = report.getSummaryReport();
            ReportResult fullReportResult = report.getFullReport();

            //final results
            ResultSet summaryReport = summaryReportResult.getResult();
            ResultSet fullReport = fullReportResult.getResult();


            ExcelFileOutput output = new ExcelFileOutput(inputs.getReportType());
            XSSFWorkbook workBook = output.getWorkBook(summaryReport, fullReport, reportTitle);

            WorkBookWriter writer = new WorkBookWriter(workBook);

            //file path
            String path = "Daily-Sales.xlsx";
            writer.save(path);

            String startingMonth = "January";
            String endingMonth = "February";
            String fileName = "Daily-Sales.xlsx";
            String receiverAddress="hasinisama99@gmail.com";

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


        }catch(Exception e){
            System.out.println(e.getMessage());
        } catch (InvalidInputException e) {
            e.printStackTrace();
        }
    }
}
