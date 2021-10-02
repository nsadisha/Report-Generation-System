package com.rgsystem.emails;

import javax.mail.*;


public class SubjectCreator {

    public String startingDate;
    public String endingDate;
    private String subject;

    public SubjectCreator(String startingMonth,String endingMonth){
        this.startingDate=startingMonth;
        this.endingDate =endingMonth;
    }


    public String setSubject() throws MessagingException{

        subject = "Daily Sales Report from " + startingDate + "to" + endingDate;
        return subject;

    }

}


