package com.rgsystem.report;

import java.io.File;

public class EmailBodyGenerator {

    public EmailBody generateReport(String startingMonth, String endingMonth, String fileName) {

        String subject = "Daily Sales Report from " + startingMonth + " to " + endingMonth;
        File dataFile = new File(fileName);

        EmailBody report = new EmailBody();
        report.setSubject(subject);
        report.setData(dataFile);

        return report;
    }
}
