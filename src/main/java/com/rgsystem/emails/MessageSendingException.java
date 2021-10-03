package com.rgsystem.emails;

import javax.mail.MessagingException;

public class MessageSendingException extends MessagingException {

    public MessageSendingException(Exception e){
        super(String.valueOf(e));
    }

}
