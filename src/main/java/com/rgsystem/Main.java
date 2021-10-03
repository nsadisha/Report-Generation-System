package com.rgsystem;

import com.rgsystem.emails.Attachment;
import com.rgsystem.emails.Email;
import com.rgsystem.emails.EmailSender;
import com.rgsystem.emails.MessageSendingException;
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
        EmailBody emailBody = emailBodyGenerator.generateEmailBody(startingMonth, endingMonth, fileName);

        EmailSender emailSender = new EmailSender();
        Email email = new Email();
        email.setSubject(emailBody.getSubject());
        email.setToAddress(receiverAddress);
        email.setAttachment(emailBody.getData());

        Attachment attachment = new Attachment();
        attachment.setAttachment(emailBody.getData());

        emailSender.send(email);
    }


}