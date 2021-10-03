package com.rgsystem.emails;

import java.io.File;

public class EmailBodyGenerator {

    public EmailBody generateEmailBody(String startingMonth, String endingMonth, String fileName) {

        String subject = "Daily Sales Report from " + startingMonth + " to " + endingMonth;
        File dataFile = new File(fileName);

        EmailBody emailBody = new EmailBody();
        emailBody.setSubject(subject);
        emailBody.setData(dataFile);

        return emailBody;
    }
}
