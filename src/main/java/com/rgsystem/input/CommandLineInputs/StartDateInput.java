package com.rgsystem.input.CommandLineInputs;

import com.rgsystem.input.InvalidInputException;

public class StartDateInput extends CommandLineInputs {

    private final String startDate;

    //Constructor of the class
    public StartDateInput(String[] args) {
        super(args);
        startDate = this.args[1];
    }


    public String getReportRequirement() throws InvalidInputException {

        //Make sure to validate the arguments before using...
        if (startDate == null) {
            throw new InvalidInputException("Please provide the start date as the second argument");
        }

        return startDate;
    }

}
