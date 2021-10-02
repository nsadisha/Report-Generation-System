package com.rgsystem;

import com.rgsystem.emails.EmailAttachmentSender;
import com.rgsystem.emails.SubjectCreator;

public class Main {
    public static void main(String[] args) throws Exception {
        EmailAttachmentSender emailAttachmentSender=new EmailAttachmentSender("tharu.chamalsha@gmail.com","January","February");
        return;
    }
}