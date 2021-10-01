package com.rgsystem;

import com.rgsystem.emails.EmailAttachmentSender;

public class Main {
    public static void main(String[] args) throws Exception {
        EmailAttachmentSender emailAttachmentSender=new EmailAttachmentSender("tharu.chamalsha@gmail.com","test","hello");
        return;
    }
}