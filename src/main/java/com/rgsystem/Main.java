package com.rgsystem;

import com.rgsystem.emails.Attachment;
import com.rgsystem.emails.Email;
import com.rgsystem.emails.EmailSender;
import com.rgsystem.emails.ServerProperties;
import com.rgsystem.report.EmailBody;
import com.rgsystem.report.EmailBodyGenerator;

import javax.mail.MessagingException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, MessagingException {

        String startingMonth = "January";
        String endingMonth = "February";
        String fileName = "test.pdf";
        String receiverAddress="tharu.chamalsha@gmail.com";

        EmailBodyGenerator emailBodyGenerator = new EmailBodyGenerator();
        EmailBody report = emailBodyGenerator.generateReport(startingMonth, endingMonth, fileName);

        EmailSender emailSender = new EmailSender();
        Email email = new Email();
        email.setSubject(report.getSubject());
        email.setToAddress(receiverAddress);

        Attachment attachment = new Attachment();
        attachment.setAttachment(report.getData());

        emailSender.send(email);
    }


}