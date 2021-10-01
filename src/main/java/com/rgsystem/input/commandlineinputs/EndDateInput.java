package com.rgsystem.input.commandlineinputs;

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

        if(!(isDateValid(endDate))){
            throw new InvalidInputException("Please provide the end date in dd/mm/yyyy format");
        }

        return endDate;
    }

    static boolean isDateValid(String Date) {
        if (Date.matches("([0-9]{2})/([0-9]{2})/([0-9]{4})"))
            return true;
        else
            return false;
    }
}
