package com.rgsystem.input.CommandLineInputs;

import com.rgsystem.input.InvalidInputException;

public class EndDateInput extends CommandLineInputs {

    private final String endDate;

    //Constructor of the class
    public EndDateInput(String[] args) {
        super(args);
        endDate = this.args[2];
    }


    public String getReportRequirement() throws InvalidInputException {

        //Make sure to validate the arguments before using...
        if (endDate == null) {
            throw new InvalidInputException("Please provide the end date as the third argument");
        }

        return endDate;
    }
}
