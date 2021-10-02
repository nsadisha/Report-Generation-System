package com.rgsystem.emails;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

public class SessionCreator {

    protected Session createSession(){

        ServerProperties serverProperties=new ServerProperties();
        Properties properties=serverProperties.setServerProperties();

        // creates a new session with an authenticator
        Session session=Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(serverProperties.userName,serverProperties.password);
            }
        });
        return session;

    }
}
