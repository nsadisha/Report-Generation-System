package com.rgsystem.report;

import java.time.LocalDate;

public class Period {
    private final LocalDate startDate;
    private final LocalDate endDate;

    public Period(String startDate, String endDate){
        this.startDate = LocalDate.parse(startDate);
        this.endDate = LocalDate.parse(endDate);
    }

    public String getStartDate(){
        return this.startDate.toString();
    }
    public String getEndDate(){
        return this.endDate.toString();
    }
}
