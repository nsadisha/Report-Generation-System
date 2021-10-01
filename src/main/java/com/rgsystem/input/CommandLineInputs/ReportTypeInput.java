package com.rgsystem.input.CommandLineInputs;

import com.rgsystem.input.InvalidInputException;

public class ReportTypeInput extends CommandLineInputs {

    private final String reportType;

    //Constructor of the class
    public ReportTypeInput(String[] args) {
        super(args);
        reportType = this.args[0];
    }


    public String getReportRequirement() throws InvalidInputException {

        //Make sure to validate the arguments before using...
        if (reportType == null) {
            throw new InvalidInputException("Please provide the report type as an argument");
        }

        if (!(reportType.equals("monthlysales") || reportType.equals("usersignups"))) {
            throw new InvalidInputException
                    ("Please provide monthlysales or usersignups as the report type for first argument");
        }

        return reportType;
    }
}
