package com.rgsystem.emails;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.util.Properties;

public class EmailAttachmentSender {
    private static String host="smtp.gmail.com";
    private static String port="587";
    private static String userName="lbookbae@gmail.com";
    private static String password="bookbae1234";
    private String toAddress;
    private String subject;
    private String message;


    //constructor of the class
    public EmailAttachmentSender(String toAddress, String subject, String message) throws Exception{
        this.toAddress = toAddress;
        this.subject = subject;
        this.message = message;


        //set SMTP server properties
        Properties properties=new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.user", userName);
        properties.put("mail.password", password);

        // creates a new session with an authenticator
        Session session=Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName,password);
            }
        });

        Message message1=new MimeMessage(session);
        message1.setSubject(subject);


        Address addressTo=new InternetAddress(toAddress);
        message1.setRecipient(Message.RecipientType.TO,addressTo);

        MimeMultipart multipart=new MimeMultipart();

        MimeBodyPart attachment=new MimeBodyPart();
        attachment.attachFile(new File("report/Assignment-2 2021 (2) (1).pdf"));

        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setText(message);
        multipart.addBodyPart(attachment);

        message1.setContent(multipart);

        Transport.send(message1);
    }











}
