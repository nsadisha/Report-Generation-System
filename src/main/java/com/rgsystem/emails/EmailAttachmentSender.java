package com.rgsystem.emails;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.*;
import java.io.File;
import java.io.IOException;

public class EmailAttachmentSender {

    protected String toAddress;
    public String startingMonth;
    public String endingMonth;

    public EmailAttachmentSender(String toAddress,String startingMonth,String endingMonth) throws IOException, MessagingException {

        SessionCreator session=new SessionCreator();
        Message message1=new MimeMessage(session.createSession());

        SubjectCreator subjectCreator=new SubjectCreator(startingMonth,endingMonth);
        message1.setSubject(subjectCreator.setSubject());

        MimeBodyPart attachment=new MimeBodyPart();
        attachment.attachFile(new File("report/Assignment-2 2021 (2) (1).pdf"));


        Address addressTo=new InternetAddress(toAddress);
        message1.setRecipient(Message.RecipientType.TO,addressTo);

        MimeMultipart multipart=new MimeMultipart();

        multipart.addBodyPart(attachment);

        message1.setContent(multipart);

        Transport.send(message1);

    }

}
