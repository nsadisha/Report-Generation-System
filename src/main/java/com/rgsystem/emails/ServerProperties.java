package com.rgsystem.emails;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

public class ServerProperties {
    protected String host="smtp.gmail.com";
    protected String port="587";
    protected String userName="lbookbae@gmail.com";
    protected String password="bookbae1234";

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    protected Properties getServerProperties(){
        //set SMTP server properties
        Properties properties=new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.user", userName);
        properties.put("mail.password", password);

        return properties;
    }


}
