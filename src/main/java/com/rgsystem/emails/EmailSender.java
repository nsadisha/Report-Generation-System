package com.rgsystem.emails;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.*;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class EmailSender {

    private  ServerProperties serverProperties;

    public void send(Email email) throws MessageSendingException, IOException {
    try {
        Message message = new MimeMessage(createSession());
        Address addressTo = new InternetAddress(email.getToAddress());

        message.setSubject(email.getSubject());
        message.setRecipient(Message.RecipientType.TO, addressTo);

        MimeBodyPart attachment = new MimeBodyPart();
        attachment.attachFile(email.getAttachment());

        MimeMultipart multipart = new MimeMultipart();
        multipart.addBodyPart(attachment);

        message.setContent(multipart);

        Transport.send(message);
    }catch (MessagingException e){
        throw new MessageSendingException(e);
    }
    }

    protected Session createSession(){

        ServerProperties serverProperties=new ServerProperties();
        Properties properties=serverProperties.setServerProperties();

        // creates a new session with an authenticator
        Session session=Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(serverProperties.getUserName(),serverProperties.getPassword());
            }
        });
        return session;

    }
}
