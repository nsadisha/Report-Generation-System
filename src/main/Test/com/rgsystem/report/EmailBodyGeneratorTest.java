package com.rgsystem.report;

import junit.framework.TestCase;
import org.junit.Test;

public class EmailBodyGeneratorTest extends TestCase {


    @Test
    public void subject_should_not_be_nll(){

        EmailBodyGenerator emailBodyGenerator = new EmailBodyGenerator();

        String startingDate="January";
        String endingDate="February";
        String fileName="test.pdf";
        EmailBody emailBody = emailBodyGenerator.generateEmailBody(startingDate, endingDate, fileName);

        assertNotNull(emailBody);
    }

}