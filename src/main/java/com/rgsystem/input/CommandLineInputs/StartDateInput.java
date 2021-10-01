package com.rgsystem.input.commandlineinputs;

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

        if(!(isDateValid(startDate))){
            throw new InvalidInputException("Please provide the start date in dd/mm/yyyy format");
        }

        return startDate;
    }

    static boolean isDateValid(String Date) {
        if (Date.matches("([0-9]{2})/([0-9]{2})/([0-9]{4})"))
            return true;
        else
            return false;
    }

}
